package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class LineNumbersAttr extends Attribute {
    int linenumber_count;
    short[] linenumber_table;

    public LineNumbersAttr(CodeAttr code) {
        super("LineNumberTable");
        addToFrontOf(code);
        code.lines = this;
    }

    public LineNumbersAttr(short[] numbers, CodeAttr code) {
        this(code);
        this.linenumber_table = numbers;
        this.linenumber_count = numbers.length >> 1;
    }

    public void put(int linenumber, int PC) {
        if (this.linenumber_table == null) {
            this.linenumber_table = new short[32];
        } else if (this.linenumber_count * 2 >= this.linenumber_table.length) {
            short[] new_linenumbers = new short[this.linenumber_table.length * 2];
            System.arraycopy(this.linenumber_table, 0, new_linenumbers, 0, this.linenumber_count * 2);
            this.linenumber_table = new_linenumbers;
        }
        this.linenumber_table[this.linenumber_count * 2] = (short) PC;
        this.linenumber_table[(this.linenumber_count * 2) + 1] = (short) linenumber;
        this.linenumber_count++;
    }

    @Override // gnu.bytecode.Attribute
    public final int getLength() {
        return (this.linenumber_count * 4) + 2;
    }

    public int getLineCount() {
        return this.linenumber_count;
    }

    public short[] getLineNumberTable() {
        return this.linenumber_table;
    }

    @Override // gnu.bytecode.Attribute
    public void write(DataOutputStream dstr) throws IOException {
        dstr.writeShort(this.linenumber_count);
        int count = this.linenumber_count * 2;
        for (int i = 0; i < count; i++) {
            dstr.writeShort(this.linenumber_table[i]);
        }
    }

    @Override // gnu.bytecode.Attribute
    public void print(ClassTypeWriter dst) {
        dst.print("Attribute \"");
        dst.print(getName());
        dst.print("\", length:");
        dst.print(getLength());
        dst.print(", count: ");
        dst.println(this.linenumber_count);
        for (int i = 0; i < this.linenumber_count; i++) {
            dst.print("  line: ");
            dst.print(this.linenumber_table[(i * 2) + 1] & 65535);
            dst.print(" at pc: ");
            dst.println(this.linenumber_table[i * 2] & 65535);
        }
    }
}
