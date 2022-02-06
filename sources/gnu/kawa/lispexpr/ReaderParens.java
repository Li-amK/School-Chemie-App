package gnu.kawa.lispexpr;

import gnu.lists.Pair;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;

/* loaded from: classes.dex */
public class ReaderParens extends ReadTableEntry {
    private static ReaderParens instance;
    char close;
    Object command;
    int kind;
    char open;

    @Override // gnu.kawa.lispexpr.ReadTableEntry
    public int getKind() {
        return this.kind;
    }

    public static ReaderParens getInstance(char open, char close) {
        return getInstance(open, close, 5);
    }

    public static ReaderParens getInstance(char open, char close, int kind) {
        if (open != '(' || close != ')' || kind != 5) {
            return new ReaderParens(open, close, kind, null);
        }
        if (instance == null) {
            instance = new ReaderParens(open, close, kind, null);
        }
        return instance;
    }

    public static ReaderParens getInstance(char open, char close, int kind, Object command) {
        return command == null ? getInstance(open, close, kind) : new ReaderParens(open, close, kind, command);
    }

    public ReaderParens(char open, char close, int kind, Object command) {
        this.open = open;
        this.close = close;
        this.kind = kind;
        this.command = command;
    }

    @Override // gnu.kawa.lispexpr.ReadTableEntry
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        Object r = readList((LispReader) in, ch, count, this.close);
        if (this.command == null) {
            return r;
        }
        LineBufferedReader port = in.getPort();
        Pair p = ((LispReader) in).makePair(this.command, port.getLineNumber(), port.getColumnNumber());
        ((LispReader) in).setCdr(p, r);
        return p;
    }

    /* JADX INFO: Multiple debug info for r17v2 gnu.lists.Pair: [D('value' java.lang.Object), D('value' gnu.lists.Pair)] */
    /* JADX INFO: Multiple debug info for r8v6 'value'  java.lang.Object: [D('list' java.lang.Object), D('value' java.lang.Object)] */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
        r20.error("unexpected '" + ((char) r23) + "' after '.'");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object readList(gnu.kawa.lispexpr.LispReader r20, int r21, int r22, int r23) throws java.io.IOException, gnu.text.SyntaxException {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.kawa.lispexpr.ReaderParens.readList(gnu.kawa.lispexpr.LispReader, int, int, int):java.lang.Object");
    }
}
