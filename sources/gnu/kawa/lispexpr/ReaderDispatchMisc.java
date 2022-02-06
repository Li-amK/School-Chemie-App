package gnu.kawa.lispexpr;

import gnu.bytecode.Access;
import gnu.bytecode.Type;
import gnu.expr.Keyword;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.util.GeneralHashTable;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.InPort;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;

/* loaded from: classes.dex */
public class ReaderDispatchMisc extends ReadTableEntry {
    private static ReaderDispatchMisc instance = new ReaderDispatchMisc();
    protected int code;

    public static ReaderDispatchMisc getInstance() {
        return instance;
    }

    public ReaderDispatchMisc() {
        this.code = -1;
    }

    public ReaderDispatchMisc(int code) {
        this.code = code;
    }

    @Override // gnu.kawa.lispexpr.ReadTableEntry
    public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException {
        GeneralHashTable<Integer, Object> map;
        Object object;
        Object list;
        int length;
        Object obj;
        LineBufferedReader port;
        LispReader reader = (LispReader) in;
        char saveReadState = 0;
        if (this.code >= 0) {
            ch = this.code;
        }
        switch (ch) {
            case 33:
                return LispReader.readSpecial(reader);
            case 35:
                if (!(!(in instanceof LispReader) || (map = ((LispReader) in).sharedStructureTable) == null || (object = map.get(Integer.valueOf(count), in)) == in)) {
                    return object;
                }
                in.error("an unrecognized #n# back-reference was read");
                return Values.empty;
            case 44:
                if (reader.getPort().peek() != 40 || (length = LList.listLength((list = reader.readObject()), false)) <= 0 || !(((Pair) list).getCar() instanceof Symbol)) {
                    in.error("a non-empty list starting with a symbol must follow #,");
                } else {
                    String name = ((Pair) list).getCar().toString();
                    Object proc = ReadTable.getCurrent().getReaderCtor(name);
                    if (proc == null) {
                        in.error("unknown reader constructor " + name);
                    } else if ((proc instanceof Procedure) || (proc instanceof Type)) {
                        int length2 = length - 1;
                        int parg = proc instanceof Type ? 1 : 0;
                        Object[] args = new Object[parg + length2];
                        Object argList = ((Pair) list).getCdr();
                        for (int i = 0; i < length2; i++) {
                            Pair pair = (Pair) argList;
                            args[parg + i] = pair.getCar();
                            argList = pair.getCdr();
                        }
                        try {
                            if (parg > 0) {
                                args[0] = proc;
                                obj = Invoke.make.applyN(args);
                            } else {
                                obj = ((Procedure) proc).applyN(args);
                            }
                            return obj;
                        } catch (Throwable ex) {
                            in.error("caught " + ex + " applying reader constructor " + name);
                        }
                    } else {
                        in.error("reader constructor must be procedure or type name");
                    }
                }
                return Boolean.FALSE;
            case 47:
                return readRegex(in, ch, count);
            case 58:
                int startPos = reader.tokenBufferLength;
                reader.readToken(reader.read(), 'P', ReadTable.getCurrent());
                String name2 = new String(reader.tokenBuffer, startPos, reader.tokenBufferLength - startPos);
                reader.tokenBufferLength = startPos;
                return Keyword.make(name2.intern());
            case 59:
                port = reader.getPort();
                if (port instanceof InPort) {
                    saveReadState = ((InPort) port).readState;
                    ((InPort) port).readState = ';';
                }
                try {
                    reader.readObject();
                    if (port instanceof InPort) {
                        ((InPort) port).readState = saveReadState;
                    }
                    return Values.empty;
                } finally {
                }
            case 61:
                Object object2 = reader.readObject();
                if (!(in instanceof LispReader)) {
                    return object2;
                }
                LispReader lin = (LispReader) in;
                GeneralHashTable<Integer, Object> map2 = lin.sharedStructureTable;
                if (map2 == null) {
                    map2 = new GeneralHashTable<>();
                    lin.sharedStructureTable = map2;
                }
                map2.put(Integer.valueOf(count), object2);
                return object2;
            case 66:
                return LispReader.readNumberWithRadix(0, reader, 2);
            case 68:
                return LispReader.readNumberWithRadix(0, reader, 10);
            case 69:
            case 73:
                reader.tokenBufferAppend(35);
                reader.tokenBufferAppend(ch);
                return LispReader.readNumberWithRadix(2, reader, 0);
            case 70:
                if (Character.isDigit((char) in.peek())) {
                    return LispReader.readSimpleVector(reader, Access.FIELD_CONTEXT);
                }
                return Boolean.FALSE;
            case 79:
                return LispReader.readNumberWithRadix(0, reader, 8);
            case 82:
                if (count > 36) {
                    in.error("the radix " + count + " is too big (max is 36)");
                    count = 36;
                }
                return LispReader.readNumberWithRadix(0, reader, count);
            case 83:
            case 85:
                return LispReader.readSimpleVector(reader, (char) ch);
            case 84:
                return Boolean.TRUE;
            case 88:
                return LispReader.readNumberWithRadix(0, reader, 16);
            case 92:
                return LispReader.readCharacter(reader);
            case 124:
                port = reader.getPort();
                if (port instanceof InPort) {
                    saveReadState = ((InPort) port).readState;
                    ((InPort) port).readState = '|';
                }
                try {
                    reader.readNestedComment('#', '|');
                    if (port instanceof InPort) {
                        ((InPort) port).readState = saveReadState;
                    }
                    return Values.empty;
                } finally {
                }
            default:
                in.error("An invalid #-construct was read.");
                return Values.empty;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0076, code lost:
        r10.eofError("unexpected EOF in regex literal");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.regex.Pattern readRegex(gnu.text.Lexer r10, int r11, int r12) throws java.io.IOException, gnu.text.SyntaxException {
        /*
            r9 = 92
            int r6 = r10.tokenBufferLength
            gnu.text.LineBufferedReader r4 = r10.getPort()
            r5 = 0
            r2 = 0
            boolean r7 = r4 instanceof gnu.mapping.InPort
            if (r7 == 0) goto L_0x001a
            r7 = r4
            gnu.mapping.InPort r7 = (gnu.mapping.InPort) r7
            char r5 = r7.readState
            r7 = r4
            gnu.mapping.InPort r7 = (gnu.mapping.InPort) r7
            r8 = 47
            r7.readState = r8
        L_0x001a:
            int r1 = r4.read()     // Catch: all -> 0x0043
            if (r1 >= 0) goto L_0x0025
            java.lang.String r7 = "unexpected EOF in regex literal"
            r10.eofError(r7)     // Catch: all -> 0x0043
        L_0x0025:
            if (r1 != r11) goto L_0x004f
            java.lang.String r3 = new java.lang.String     // Catch: all -> 0x0043
            char[] r7 = r10.tokenBuffer     // Catch: all -> 0x0043
            int r8 = r10.tokenBufferLength     // Catch: all -> 0x0043
            int r8 = r8 - r6
            r3.<init>(r7, r6, r8)     // Catch: all -> 0x0043
        L_0x0031:
            int r1 = r10.peek()     // Catch: all -> 0x0043
            r7 = 105(0x69, float:1.47E-43)
            if (r1 == r7) goto L_0x003d
            r7 = 73
            if (r1 != r7) goto L_0x0086
        L_0x003d:
            r2 = r2 | 66
        L_0x003f:
            r10.skip()     // Catch: all -> 0x0043
            goto L_0x0031
        L_0x0043:
            r7 = move-exception
            r10.tokenBufferLength = r6
            boolean r8 = r4 instanceof gnu.mapping.InPort
            if (r8 == 0) goto L_0x004e
            gnu.mapping.InPort r4 = (gnu.mapping.InPort) r4
            r4.readState = r5
        L_0x004e:
            throw r7
        L_0x004f:
            if (r1 != r9) goto L_0x0082
            int r1 = r4.read()     // Catch: all -> 0x0043
            r7 = 32
            if (r1 == r7) goto L_0x0065
            r7 = 9
            if (r1 == r7) goto L_0x0065
            r7 = 13
            if (r1 == r7) goto L_0x0065
            r7 = 10
            if (r1 != r7) goto L_0x0074
        L_0x0065:
            boolean r7 = r10 instanceof gnu.kawa.lispexpr.LispReader     // Catch: all -> 0x0043
            if (r7 == 0) goto L_0x0074
            r0 = r10
            gnu.kawa.lispexpr.LispReader r0 = (gnu.kawa.lispexpr.LispReader) r0     // Catch: all -> 0x0043
            r7 = r0
            int r1 = r7.readEscape(r1)     // Catch: all -> 0x0043
            r7 = -2
            if (r1 == r7) goto L_0x001a
        L_0x0074:
            if (r1 >= 0) goto L_0x007b
            java.lang.String r7 = "unexpected EOF in regex literal"
            r10.eofError(r7)     // Catch: all -> 0x0043
        L_0x007b:
            if (r1 == r11) goto L_0x0082
            r7 = 92
            r10.tokenBufferAppend(r7)     // Catch: all -> 0x0043
        L_0x0082:
            r10.tokenBufferAppend(r1)     // Catch: all -> 0x0043
            goto L_0x001a
        L_0x0086:
            r7 = 115(0x73, float:1.61E-43)
            if (r1 == r7) goto L_0x008e
            r7 = 83
            if (r1 != r7) goto L_0x0091
        L_0x008e:
            r2 = r2 | 32
            goto L_0x003f
        L_0x0091:
            r7 = 109(0x6d, float:1.53E-43)
            if (r1 == r7) goto L_0x0099
            r7 = 77
            if (r1 != r7) goto L_0x009c
        L_0x0099:
            r2 = r2 | 8
            goto L_0x003f
        L_0x009c:
            boolean r7 = java.lang.Character.isLetter(r1)     // Catch: all -> 0x0043
            if (r7 == 0) goto L_0x00c0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: all -> 0x0043
            r7.<init>()     // Catch: all -> 0x0043
            java.lang.String r8 = "unrecognized regex option '"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: all -> 0x0043
            char r8 = (char) r1     // Catch: all -> 0x0043
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: all -> 0x0043
            r8 = 39
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch: all -> 0x0043
            java.lang.String r7 = r7.toString()     // Catch: all -> 0x0043
            r10.error(r7)     // Catch: all -> 0x0043
            goto L_0x003f
        L_0x00c0:
            java.util.regex.Pattern r7 = java.util.regex.Pattern.compile(r3, r2)     // Catch: all -> 0x0043
            r10.tokenBufferLength = r6
            boolean r8 = r4 instanceof gnu.mapping.InPort
            if (r8 == 0) goto L_0x00ce
            gnu.mapping.InPort r4 = (gnu.mapping.InPort) r4
            r4.readState = r5
        L_0x00ce:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.kawa.lispexpr.ReaderDispatchMisc.readRegex(gnu.text.Lexer, int, int):java.util.regex.Pattern");
    }
}
