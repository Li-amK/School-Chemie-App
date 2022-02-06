package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import kawa.lang.SyntaxForms;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

@SimpleObject
@UsesPermissions(permissionNames = "android.permission.INTERNET")
@DesignerComponent(category = ComponentCategory.INTERNAL, description = "Non-visible component that communicates with a Web service and stores media files.", iconName = "images/mediastore.png", nonVisible = SyntaxForms.DEBUGGING, version = 1)
@UsesLibraries({"httpmime.jar"})
/* loaded from: classes.dex */
public final class MediaStore extends AndroidNonvisibleComponent implements Component {
    private static final String LOG_TAG_COMPONENT = "MediaStore: ";
    protected final ComponentContainer componentContainer;
    private Handler androidUIHandler = new Handler();
    private String serviceURL = "http://ai-mediaservice.appspot.com";

    public MediaStore(ComponentContainer container) {
        super(container.$form());
        this.componentContainer = container;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String ServiceURL() {
        return this.serviceURL;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "http://ai-mediaservice.appspot.com", editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING)
    public void ServiceURL(String url) {
        this.serviceURL = url;
    }

    @SimpleFunction
    public void PostMedia(String mediafile) throws FileNotFoundException {
        String newMediaPath;
        AsyncCallbackPair<String> myCallback = new AsyncCallbackPair<String>() { // from class: com.google.appinventor.components.runtime.MediaStore.1
            public void onSuccess(final String response) {
                MediaStore.this.androidUIHandler.post(new Runnable() { // from class: com.google.appinventor.components.runtime.MediaStore.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaStore.this.MediaStored(response);
                    }
                });
            }

            @Override // com.google.appinventor.components.runtime.util.AsyncCallbackPair
            public void onFailure(final String message) {
                MediaStore.this.androidUIHandler.post(new Runnable() { // from class: com.google.appinventor.components.runtime.MediaStore.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaStore.this.WebServiceError(message);
                    }
                });
            }
        };
        try {
            HttpClient client = new DefaultHttpClient();
            MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
            entityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            if (mediafile.split("/")[0].equals("file:")) {
                newMediaPath = new File(new URL(mediafile).toURI()).getAbsolutePath();
            } else {
                newMediaPath = mediafile;
            }
            entityBuilder.addPart("file", new FileBody(new File(newMediaPath)));
            HttpEntity entity = entityBuilder.build();
            HttpPost post = new HttpPost(getUploadUrl());
            post.setEntity(entity);
            myCallback.onSuccess(EntityUtils.toString(client.execute(post).getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
            myCallback.onFailure(e.getMessage());
        }
    }

    private String getUploadUrl() {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(this.serviceURL).openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "AppInventor");
            con.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            while (true) {
                String inputLine = in.readLine();
                if (inputLine != null) {
                    response.append(inputLine);
                } else {
                    in.close();
                    return response.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @SimpleEvent
    public void MediaStored(String url) {
        EventDispatcher.dispatchEvent(this, "MediaStored", url);
    }

    @SimpleEvent
    public void WebServiceError(String message) {
        EventDispatcher.dispatchEvent(this, "WebServiceError", message);
    }
}
