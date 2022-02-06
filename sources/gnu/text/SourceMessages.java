package gnu.text;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class SourceMessages implements SourceLocator {
    int current_column;
    String current_filename;
    int current_line;
    SourceError firstError;
    SourceError lastError;
    SourceLocator locator;
    public boolean sortMessages;
    public static boolean debugStackTraceOnWarning = false;
    public static boolean debugStackTraceOnError = false;
    private int errorCount = 0;
    SourceError lastPrevFilename = null;

    public SourceError getErrors() {
        return this.firstError;
    }

    public boolean seenErrors() {
        return this.errorCount > 0;
    }

    public boolean seenErrorsOrWarnings() {
        return this.firstError != null;
    }

    public int getErrorCount() {
        return this.errorCount;
    }

    public void clearErrors() {
        this.errorCount = 0;
    }

    public void clear() {
        this.lastError = null;
        this.firstError = null;
        this.errorCount = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
        r7.next = r6.firstError;
        r6.firstError = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void error(gnu.text.SourceError r7) {
        /*
            r6 = this;
            r5 = 119(0x77, float:1.67E-43)
            r4 = 102(0x66, float:1.43E-43)
            char r2 = r7.severity
            if (r2 != r4) goto L_0x005e
            r2 = 1000(0x3e8, float:1.401E-42)
            r6.errorCount = r2
        L_0x000c:
            boolean r2 = gnu.text.SourceMessages.debugStackTraceOnError
            if (r2 == 0) goto L_0x001a
            char r2 = r7.severity
            r3 = 101(0x65, float:1.42E-43)
            if (r2 == r3) goto L_0x0022
            char r2 = r7.severity
            if (r2 == r4) goto L_0x0022
        L_0x001a:
            boolean r2 = gnu.text.SourceMessages.debugStackTraceOnWarning
            if (r2 == 0) goto L_0x0029
            char r2 = r7.severity
            if (r2 != r5) goto L_0x0029
        L_0x0022:
            java.lang.Throwable r2 = new java.lang.Throwable
            r2.<init>()
            r7.fakeException = r2
        L_0x0029:
            gnu.text.SourceError r2 = r6.lastError
            if (r2 == 0) goto L_0x0043
            gnu.text.SourceError r2 = r6.lastError
            java.lang.String r2 = r2.filename
            if (r2 == 0) goto L_0x0043
            gnu.text.SourceError r2 = r6.lastError
            java.lang.String r2 = r2.filename
            java.lang.String r3 = r7.filename
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0043
            gnu.text.SourceError r2 = r6.lastError
            r6.lastPrevFilename = r2
        L_0x0043:
            gnu.text.SourceError r1 = r6.lastPrevFilename
            boolean r2 = r6.sortMessages
            if (r2 == 0) goto L_0x004d
            char r2 = r7.severity
            if (r2 != r4) goto L_0x006a
        L_0x004d:
            gnu.text.SourceError r1 = r6.lastError
        L_0x004f:
            if (r1 != 0) goto L_0x0096
            gnu.text.SourceError r2 = r6.firstError
            r7.next = r2
            r6.firstError = r7
        L_0x0057:
            gnu.text.SourceError r2 = r6.lastError
            if (r1 != r2) goto L_0x005d
            r6.lastError = r7
        L_0x005d:
            return
        L_0x005e:
            char r2 = r7.severity
            if (r2 == r5) goto L_0x000c
            int r2 = r6.errorCount
            int r2 = r2 + 1
            r6.errorCount = r2
            goto L_0x000c
        L_0x0069:
            r1 = r0
        L_0x006a:
            if (r1 != 0) goto L_0x0093
            gnu.text.SourceError r0 = r6.firstError
        L_0x006e:
            if (r0 == 0) goto L_0x004f
            int r2 = r7.line
            if (r2 == 0) goto L_0x0069
            int r2 = r0.line
            if (r2 == 0) goto L_0x0069
            int r2 = r7.line
            int r3 = r0.line
            if (r2 < r3) goto L_0x004f
            int r2 = r7.line
            int r3 = r0.line
            if (r2 != r3) goto L_0x0069
            int r2 = r7.column
            if (r2 == 0) goto L_0x0069
            int r2 = r0.column
            if (r2 == 0) goto L_0x0069
            int r2 = r7.column
            int r3 = r0.column
            if (r2 >= r3) goto L_0x0069
            goto L_0x004f
        L_0x0093:
            gnu.text.SourceError r0 = r1.next
            goto L_0x006e
        L_0x0096:
            gnu.text.SourceError r2 = r1.next
            r7.next = r2
            r1.next = r7
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.text.SourceMessages.error(gnu.text.SourceError):void");
    }

    public void error(char severity, String filename, int line, int column, String message) {
        error(new SourceError(severity, filename, line, column, message));
    }

    public void error(char severity, SourceLocator location, String message) {
        error(new SourceError(severity, location, message));
    }

    public void error(char severity, String filename, int line, int column, String message, String code) {
        SourceError err = new SourceError(severity, filename, line, column, message);
        err.code = code;
        error(err);
    }

    public void error(char severity, SourceLocator location, String message, String code) {
        SourceError err = new SourceError(severity, location, message);
        err.code = code;
        error(err);
    }

    public void error(char severity, String message) {
        error(new SourceError(severity, this.current_filename, this.current_line, this.current_column, message));
    }

    public void error(char severity, String message, Throwable exception) {
        SourceError err = new SourceError(severity, this.current_filename, this.current_line, this.current_column, message);
        err.fakeException = exception;
        error(err);
    }

    public void error(char severity, String message, String code) {
        SourceError err = new SourceError(severity, this.current_filename, this.current_line, this.current_column, message);
        err.code = code;
        error(err);
    }

    public void printAll(PrintStream out, int max) {
        for (SourceError err = this.firstError; err != null; err = err.next) {
            max--;
            if (max >= 0) {
                err.println(out);
            } else {
                return;
            }
        }
    }

    public void printAll(PrintWriter out, int max) {
        for (SourceError err = this.firstError; err != null; err = err.next) {
            max--;
            if (max >= 0) {
                err.println(out);
            } else {
                return;
            }
        }
    }

    public String toString(int max) {
        if (this.firstError == null) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        for (SourceError err = this.firstError; err != null; err = err.next) {
            max--;
            if (max < 0) {
                break;
            }
            buffer.append(err);
            buffer.append('\n');
        }
        return buffer.toString();
    }

    public boolean checkErrors(PrintWriter out, int max) {
        if (this.firstError == null) {
            return false;
        }
        printAll(out, max);
        this.lastError = null;
        this.firstError = null;
        int saveCount = this.errorCount;
        this.errorCount = 0;
        return saveCount > 0;
    }

    public boolean checkErrors(PrintStream out, int max) {
        if (this.firstError == null) {
            return false;
        }
        printAll(out, max);
        this.lastError = null;
        this.firstError = null;
        int saveCount = this.errorCount;
        this.errorCount = 0;
        return saveCount > 0;
    }

    public final void setSourceLocator(SourceLocator locator) {
        if (locator == this) {
            locator = null;
        }
        this.locator = locator;
    }

    public final SourceLocator swapSourceLocator(SourceLocator locator) {
        SourceLocator save = this.locator;
        this.locator = locator;
        return save;
    }

    public final void setLocation(SourceLocator locator) {
        this.locator = null;
        this.current_line = locator.getLineNumber();
        this.current_column = locator.getColumnNumber();
        this.current_filename = locator.getFileName();
    }

    @Override // gnu.text.SourceLocator, org.xml.sax.Locator
    public String getPublicId() {
        if (this.locator == null) {
            return null;
        }
        return this.locator.getPublicId();
    }

    @Override // gnu.text.SourceLocator, org.xml.sax.Locator
    public String getSystemId() {
        return this.locator == null ? this.current_filename : this.locator.getSystemId();
    }

    @Override // gnu.text.SourceLocator
    public boolean isStableSourceLocation() {
        return false;
    }

    @Override // gnu.text.SourceLocator
    public final String getFileName() {
        return this.current_filename;
    }

    @Override // gnu.text.SourceLocator, org.xml.sax.Locator
    public final int getLineNumber() {
        return this.locator == null ? this.current_line : this.locator.getLineNumber();
    }

    @Override // gnu.text.SourceLocator, org.xml.sax.Locator
    public final int getColumnNumber() {
        return this.locator == null ? this.current_column : this.locator.getColumnNumber();
    }

    public void setFile(String filename) {
        this.current_filename = filename;
    }

    public void setLine(int line) {
        this.current_line = line;
    }

    public void setColumn(int column) {
        this.current_column = column;
    }

    public void setLine(String filename, int line, int column) {
        this.current_filename = filename;
        this.current_line = line;
        this.current_column = column;
    }
}
