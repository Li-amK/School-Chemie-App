package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class SourceFileAttr extends Attribute {
    String filename;
    int filename_index;

    public String getSourceFile() {
        return this.filename;
    }

    public void setSourceFile(String filename) {
        this.filename = filename;
        this.filename_index = 0;
    }

    public static String fixSourceFile(String fname) {
        char fsep0;
        String fsep = System.getProperty("file.separator", "/");
        if (fsep == null || fsep.length() != 1 || (fsep0 = fsep.charAt(0)) == '/') {
            return fname;
        }
        return fname.replace(fsep0, '/');
    }

    public static void setSourceFile(ClassType cl, String filename) {
        Attribute attr = Attribute.get(cl, "SourceFile");
        if (attr == null || !(attr instanceof SourceFileAttr)) {
            new SourceFileAttr(filename).addToFrontOf(cl);
        } else {
            ((SourceFileAttr) attr).setSourceFile(filename);
        }
    }

    public SourceFileAttr(String filename) {
        super("SourceFile");
        this.filename = filename;
    }

    public SourceFileAttr(int index, ClassType ctype) {
        super("SourceFile");
        this.filename = ((CpoolUtf8) ctype.constants.getForced(index, 1)).string;
        this.filename_index = index;
    }

    @Override // gnu.bytecode.Attribute
    public void assignConstants(ClassType cl) {
        super.assignConstants(cl);
        if (this.filename_index == 0) {
            this.filename_index = cl.getConstants().addUtf8(this.filename).getIndex();
        }
    }

    @Override // gnu.bytecode.Attribute
    public final int getLength() {
        return 2;
    }

    @Override // gnu.bytecode.Attribute
    public void write(DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.filename_index);
    }

    @Override // gnu.bytecode.Attribute
    public void print(ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(getName());
        dst.print("\", length:");
        dst.print(getLength());
        dst.print(", ");
        dst.printOptionalIndex(this.filename_index);
        dst.print('\"');
        dst.print(getSourceFile());
        dst.println('\"');
    }
}
