package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.FileUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.QUtil;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import kawa.lang.SyntaxForms;

@UsesPermissions(permissionNames = "android.permission.WRITE_EXTERNAL_STORAGE, android.permission.READ_EXTERNAL_STORAGE")
@DesignerComponent(category = ComponentCategory.STORAGE, description = "Non-visible component for storing and retrieving files. Use this component to write or read files on your device. The default behaviour is to write files to the private data directory associated with your App. The Companion is special cased to write files to /sdcard/AppInventor/data to facilitate debugging. If the file path starts with a slash (/), then the file is created relative to /sdcard. For example writing a file to /myFile.txt will write the file in /sdcard/myFile.txt.", iconName = "images/file.png", nonVisible = SyntaxForms.DEBUGGING, version = 3)
@SimpleObject
/* loaded from: classes.dex */
public class File extends AndroidNonvisibleComponent implements Component {
    private static final int BUFFER_LENGTH = 4096;
    private static final String LOG_TAG = "FileComponent";
    private boolean legacy = false;

    public File(ComponentContainer container) {
        super(container.$form());
        LegacyMode(false);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void LegacyMode(boolean legacy) {
        this.legacy = legacy;
    }

    @SimpleProperty(description = "Allows app to access files from the root of the external storage directory (legacy mode).")
    public boolean LegacyMode() {
        return this.legacy;
    }

    @SimpleFunction(description = "Saves text to a file. If the filename begins with a slash (/) the file is written to the sdcard. For example writing to /myFile.txt will write the file to /sdcard/myFile.txt. If the filename does not start with a slash, it will be written in the programs private data directory where it will not be accessible to other programs on the phone. There is a special exception for the AI Companion where these files are written to /sdcard/AppInventor/data to facilitate debugging. Note that this block will overwrite a file if it already exists.\n\nIf you want to add content to a file use the append block.")
    public void SaveFile(String text, String fileName) {
        if (fileName.startsWith("/")) {
            FileUtil.checkExternalStorageWriteable();
        }
        Write(fileName, text, false);
    }

    @SimpleFunction(description = "Appends text to the end of a file storage, creating the file if it does not exist. See the help text under SaveFile for information about where files are written.")
    public void AppendToFile(String text, String fileName) {
        if (fileName.startsWith("/")) {
            FileUtil.checkExternalStorageWriteable();
        }
        Write(fileName, text, true);
    }

    @SimpleFunction(description = "Reads text from a file in storage. Prefix the filename with / to read from a specific file on the SD card. for instance /myFile.txt will read the file /sdcard/myFile.txt. To read assets packaged with an application (also works for the Companion) start the filename with // (two slashes). If a filename does not start with a slash, it will be read from the applications private storage (for packaged apps) and from /sdcard/AppInventor/data for the Companion.")
    public void ReadFrom(final String fileName) {
        final boolean legacy = this.legacy;
        this.form.askPermission("android.permission.READ_EXTERNAL_STORAGE", new PermissionResultHandler() { // from class: com.google.appinventor.components.runtime.File.1
            @Override // com.google.appinventor.components.runtime.PermissionResultHandler
            public void HandlePermissionResponse(String permission, boolean granted) {
                final InputStream inputStream;
                if (granted) {
                    try {
                        if (fileName.startsWith("//")) {
                            inputStream = File.this.form.openAsset(fileName.substring(2));
                        } else {
                            String filepath = File.this.AbsoluteFileName(fileName, legacy);
                            Log.d(File.LOG_TAG, "filepath = " + filepath);
                            inputStream = FileUtil.openFile(File.this.form, filepath);
                        }
                        AsynchUtil.runAsynchronously(new Runnable() { // from class: com.google.appinventor.components.runtime.File.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                File.this.AsyncRead(inputStream, fileName);
                            }
                        });
                    } catch (PermissionException e) {
                        File.this.form.dispatchPermissionDeniedEvent(File.this, "ReadFrom", e);
                    } catch (FileNotFoundException e2) {
                        Log.e(File.LOG_TAG, "FileNotFoundException", e2);
                        File.this.form.dispatchErrorOccurredEvent(File.this, "ReadFrom", ErrorMessages.ERROR_CANNOT_FIND_FILE, fileName);
                    } catch (IOException e3) {
                        Log.e(File.LOG_TAG, "IOException", e3);
                        File.this.form.dispatchErrorOccurredEvent(File.this, "ReadFrom", ErrorMessages.ERROR_CANNOT_FIND_FILE, fileName);
                    }
                } else {
                    File.this.form.dispatchPermissionDeniedEvent(File.this, "ReadFrom", permission);
                }
            }
        });
    }

    @SimpleFunction(description = "Deletes a file from storage. Prefix the filename with / to delete a specific file in the SD card, for instance /myFile.txt. will delete the file /sdcard/myFile.txt. If the file does not begin with a /, then the file located in the programs private storage will be deleted. Starting the file with // is an error because assets files cannot be deleted.")
    public void Delete(final String fileName) {
        final boolean legacy = this.legacy;
        this.form.askPermission("android.permission.WRITE_EXTERNAL_STORAGE", new PermissionResultHandler() { // from class: com.google.appinventor.components.runtime.File.2
            @Override // com.google.appinventor.components.runtime.PermissionResultHandler
            public void HandlePermissionResponse(String permission, boolean granted) {
                if (!granted) {
                    File.this.form.dispatchPermissionDeniedEvent(File.this, "Delete", permission);
                } else if (fileName.startsWith("//")) {
                    File.this.form.dispatchErrorOccurredEvent(File.this, "DeleteFile", ErrorMessages.ERROR_CANNOT_DELETE_ASSET, fileName);
                } else {
                    String filepath = File.this.AbsoluteFileName(fileName, legacy);
                    if (MediaUtil.isExternalFile(File.this.form, fileName) && File.this.form.isDeniedPermission("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        File.this.form.dispatchPermissionDeniedEvent(File.this, "Delete", new PermissionException("android.permission.WRITE_EXTERNAL_STORAGE"));
                    }
                    new java.io.File(filepath).delete();
                }
            }
        });
    }

    private void Write(final String filename, final String text, final boolean append) {
        if (!filename.startsWith("//")) {
            final boolean legacy = this.legacy;
            final Runnable operation = new Runnable() { // from class: com.google.appinventor.components.runtime.File.3
                @Override // java.lang.Runnable
                public void run() {
                    String filepath = File.this.AbsoluteFileName(filename, legacy);
                    if (MediaUtil.isExternalFile(File.this.form, filepath)) {
                        File.this.form.assertPermission("android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                    java.io.File file = new java.io.File(filepath);
                    if (!file.exists()) {
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            if (append) {
                                File.this.form.dispatchErrorOccurredEvent(File.this, "AppendTo", ErrorMessages.ERROR_CANNOT_CREATE_FILE, filepath);
                                return;
                            } else {
                                File.this.form.dispatchErrorOccurredEvent(File.this, "SaveFile", ErrorMessages.ERROR_CANNOT_CREATE_FILE, filepath);
                                return;
                            }
                        }
                    }
                    try {
                        FileOutputStream fileWriter = new FileOutputStream(file, append);
                        OutputStreamWriter out = new OutputStreamWriter(fileWriter);
                        out.write(text);
                        out.flush();
                        out.close();
                        fileWriter.close();
                        File.this.form.runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.File.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                File.this.AfterFileSaved(filename);
                            }
                        });
                    } catch (IOException e2) {
                        if (append) {
                            File.this.form.dispatchErrorOccurredEvent(File.this, "AppendTo", ErrorMessages.ERROR_CANNOT_WRITE_TO_FILE, filepath);
                        } else {
                            File.this.form.dispatchErrorOccurredEvent(File.this, "SaveFile", ErrorMessages.ERROR_CANNOT_WRITE_TO_FILE, filepath);
                        }
                    }
                }
            };
            this.form.askPermission("android.permission.WRITE_EXTERNAL_STORAGE", new PermissionResultHandler() { // from class: com.google.appinventor.components.runtime.File.4
                @Override // com.google.appinventor.components.runtime.PermissionResultHandler
                public void HandlePermissionResponse(String permission, boolean granted) {
                    if (granted) {
                        AsynchUtil.runAsynchronously(operation);
                    } else {
                        File.this.form.dispatchPermissionDeniedEvent(File.this, append ? "AppendTo" : "SaveFile", permission);
                    }
                }
            });
        } else if (append) {
            this.form.dispatchErrorOccurredEvent(this, "AppendTo", ErrorMessages.ERROR_CANNOT_WRITE_ASSET, filename);
        } else {
            this.form.dispatchErrorOccurredEvent(this, "SaveFile", ErrorMessages.ERROR_CANNOT_WRITE_ASSET, filename);
        }
    }

    private String normalizeNewLines(String s) {
        return s.replaceAll("\r\n", "\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AsyncRead(InputStream fileInput, String fileName) {
        Throwable th;
        InputStreamReader input;
        IOException e;
        InputStreamReader input2;
        try {
            input = null;
            try {
                input2 = new InputStreamReader(fileInput);
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            StringWriter output = new StringWriter();
            char[] buffer = new char[4096];
            while (true) {
                int length = input2.read(buffer, 0, 4096);
                if (length <= 0) {
                    break;
                }
                output.write(buffer, 0, length);
            }
            final String text = normalizeNewLines(output.toString());
            this.form.runOnUiThread(new Runnable() { // from class: com.google.appinventor.components.runtime.File.5
                @Override // java.lang.Runnable
                public void run() {
                    File.this.GotText(text);
                }
            });
            if (input2 != null) {
                try {
                    input2.close();
                } catch (IOException e4) {
                }
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            input = input2;
            Log.e(LOG_TAG, "FileNotFoundException", e);
            this.form.dispatchErrorOccurredEvent(this, "ReadFrom", ErrorMessages.ERROR_CANNOT_FIND_FILE, fileName);
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e6) {
                }
            }
        } catch (IOException e7) {
            e = e7;
            input = input2;
            Log.e(LOG_TAG, "IOException", e);
            this.form.dispatchErrorOccurredEvent(this, "ReadFrom", ErrorMessages.ERROR_CANNOT_READ_FILE, fileName);
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e8) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            input = input2;
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e9) {
                }
            }
            throw th;
        }
    }

    @SimpleEvent(description = "Event indicating that the contents from the file have been read.")
    public void GotText(String text) {
        EventDispatcher.dispatchEvent(this, "GotText", text);
    }

    @SimpleEvent(description = "Event indicating that the contents of the file have been written.")
    public void AfterFileSaved(String fileName) {
        EventDispatcher.dispatchEvent(this, "AfterFileSaved", fileName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String AbsoluteFileName(String filename, boolean legacy) {
        java.io.File dirPath;
        if (filename.startsWith("/")) {
            return QUtil.getExternalStoragePath(this.form, false, legacy) + filename;
        }
        if (this.form.isRepl()) {
            dirPath = new java.io.File(QUtil.getReplDataPath(this.form, false));
        } else {
            dirPath = this.form.getFilesDir();
        }
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
        return dirPath.getPath() + "/" + filename;
    }
}
