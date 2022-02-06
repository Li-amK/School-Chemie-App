package gnu.kawa.lispexpr;

import gnu.bytecode.Access;
import gnu.expr.Keyword;
import gnu.expr.QuoteExp;
import gnu.expr.Special;
import gnu.kawa.util.GeneralHashTable;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.Sequence;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;

/* loaded from: classes.dex */
public class LispReader extends Lexer {
    static final int SCM_COMPLEX = 1;
    public static final int SCM_NUMBERS = 1;
    public static final char TOKEN_ESCAPE_CHAR = 65535;
    protected boolean seenEscapes;
    GeneralHashTable<Integer, Object> sharedStructureTable;

    public LispReader(LineBufferedReader port) {
        super(port);
    }

    public LispReader(LineBufferedReader port, SourceMessages messages) {
        super(port, messages);
    }

    public final void readNestedComment(char c1, char c2) throws IOException, SyntaxException {
        int commentNesting = 1;
        int startLine = this.port.getLineNumber();
        int startColumn = this.port.getColumnNumber();
        do {
            int c = read();
            if (c == 124) {
                c = read();
                if (c == c1) {
                    commentNesting--;
                }
            } else if (c == c1 && (c = read()) == c2) {
                commentNesting++;
            }
            if (c < 0) {
                eofError("unexpected end-of-file in " + c1 + c2 + " comment starting here", startLine + 1, startColumn - 1);
                return;
            }
        } while (commentNesting > 0);
    }

    static char getReadCase() {
        try {
            char read_case = Environment.getCurrent().get("symbol-read-case", "P").toString().charAt(0);
            if (read_case == 'P') {
                return read_case;
            }
            if (read_case == 'u') {
                return 'U';
            }
            if (read_case == 'd' || read_case == 'l' || read_case == 'L') {
                return 'D';
            }
            if (read_case == 'i') {
                return Access.INNERCLASS_CONTEXT;
            }
            return read_case;
        } catch (Exception e) {
            return 'P';
        }
    }

    public Object readValues(int ch, ReadTable rtable) throws IOException, SyntaxException {
        return readValues(ch, rtable.lookup(ch), rtable);
    }

    public Object readValues(int ch, ReadTableEntry entry, ReadTable rtable) throws IOException, SyntaxException {
        int startPos = this.tokenBufferLength;
        this.seenEscapes = false;
        switch (entry.getKind()) {
            case 0:
                String err = "invalid character #\\" + ((char) ch);
                if (this.interactive) {
                    fatal(err);
                } else {
                    error(err);
                }
                return Values.empty;
            case 1:
                return Values.empty;
            case 2:
            case 3:
            case 4:
            default:
                return readAndHandleToken(ch, startPos, rtable);
            case 5:
            case 6:
                return entry.read(this, ch, -1);
        }
    }

    public Object readAndHandleToken(int ch, int startPos, ReadTable rtable) throws IOException, SyntaxException {
        int j;
        Object value;
        readToken(ch, getReadCase(), rtable);
        int endPos = this.tokenBufferLength;
        if (!this.seenEscapes && (value = parseNumber(this.tokenBuffer, startPos, endPos - startPos, (char) 0, 0, 1)) != null && !(value instanceof String)) {
            return value;
        }
        char readCase = getReadCase();
        if (readCase == 'I') {
            int upperCount = 0;
            int lowerCount = 0;
            int i = startPos;
            while (i < endPos) {
                char ci = this.tokenBuffer[i];
                if (ci == 65535) {
                    i++;
                } else if (Character.isLowerCase(ci)) {
                    lowerCount++;
                } else if (Character.isUpperCase(ci)) {
                    upperCount++;
                }
                i++;
            }
            if (lowerCount == 0) {
                readCase = 'D';
            } else if (upperCount == 0) {
                readCase = 'U';
            } else {
                readCase = 'P';
            }
        }
        boolean handleUri = endPos >= startPos + 2 && this.tokenBuffer[endPos + (-1)] == '}' && this.tokenBuffer[endPos + (-2)] != 65535 && peek() == 58;
        int packageMarker = -1;
        int lbrace = -1;
        int rbrace = -1;
        int braceNesting = 0;
        int i2 = startPos;
        int j2 = startPos;
        while (i2 < endPos) {
            char ci2 = this.tokenBuffer[i2];
            if (ci2 == 65535) {
                i2++;
                if (i2 < endPos) {
                    j = j2 + 1;
                    this.tokenBuffer[j2] = this.tokenBuffer[i2];
                } else {
                    j = j2;
                }
            } else {
                if (handleUri) {
                    if (ci2 == '{') {
                        if (lbrace < 0) {
                            lbrace = j2;
                        } else if (braceNesting == 0) {
                        }
                        braceNesting++;
                    } else if (ci2 == '}' && braceNesting - 1 >= 0 && braceNesting == 0 && rbrace < 0) {
                        rbrace = j2;
                    }
                }
                if (ci2 == ':') {
                    packageMarker = packageMarker >= 0 ? -1 : j2;
                } else if (readCase == 'U') {
                    ci2 = Character.toUpperCase(ci2);
                } else if (readCase == 'D') {
                    ci2 = Character.toLowerCase(ci2);
                }
                j = j2 + 1;
                this.tokenBuffer[j2] = ci2;
            }
            i2++;
            j2 = j;
        }
        int len = j2 - startPos;
        if (lbrace >= 0 && rbrace > lbrace) {
            String prefix = lbrace > 0 ? new String(this.tokenBuffer, startPos, lbrace - startPos) : null;
            int lbrace2 = lbrace + 1;
            String uri = new String(this.tokenBuffer, lbrace2, rbrace - lbrace2);
            read();
            int ch2 = read();
            Object rightOperand = readValues(ch2, rtable.lookup(ch2), rtable);
            if (!(rightOperand instanceof SimpleSymbol)) {
                error("expected identifier in symbol after '{URI}:'");
            }
            return Symbol.valueOf(rightOperand.toString(), uri, prefix);
        } else if (rtable.initialColonIsKeyword && packageMarker == startPos && len > 1) {
            int startPos2 = startPos + 1;
            return Keyword.make(new String(this.tokenBuffer, startPos2, j2 - startPos2).intern());
        } else if (!rtable.finalColonIsKeyword || packageMarker != j2 - 1 || (len <= 1 && !this.seenEscapes)) {
            return rtable.makeSymbol(new String(this.tokenBuffer, startPos, len));
        } else {
            return Keyword.make(new String(this.tokenBuffer, startPos, len - 1).intern());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
        unread(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void readToken(int r9, char r10, gnu.kawa.lispexpr.ReadTable r11) throws java.io.IOException, gnu.text.SyntaxException {
        /*
            r8 = this;
            r7 = 65535(0xffff, float:9.1834E-41)
            r5 = 1
            r2 = 0
            r0 = 0
        L_0x0006:
            if (r9 >= 0) goto L_0x000f
            if (r2 == 0) goto L_0x0035
            java.lang.String r6 = "unexpected EOF between escapes"
            r8.eofError(r6)
        L_0x000f:
            gnu.kawa.lispexpr.ReadTableEntry r1 = r11.lookup(r9)
            int r3 = r1.getKind()
            if (r3 != 0) goto L_0x0036
            if (r2 == 0) goto L_0x0026
            r8.tokenBufferAppend(r7)
            r8.tokenBufferAppend(r9)
        L_0x0021:
            int r9 = r8.read()
            goto L_0x0006
        L_0x0026:
            r6 = 125(0x7d, float:1.75E-43)
            if (r9 != r6) goto L_0x0032
            int r0 = r0 + (-1)
            if (r0 < 0) goto L_0x0032
            r8.tokenBufferAppend(r9)
            goto L_0x0021
        L_0x0032:
            r8.unread(r9)
        L_0x0035:
            return
        L_0x0036:
            char r6 = r11.postfixLookupOperator
            if (r9 != r6) goto L_0x0051
            if (r2 != 0) goto L_0x0051
            gnu.text.LineBufferedReader r6 = r8.port
            int r4 = r6.peek()
            char r6 = r11.postfixLookupOperator
            if (r4 != r6) goto L_0x004a
            r8.unread(r9)
            goto L_0x0035
        L_0x004a:
            boolean r6 = r8.validPostfixLookupStart(r4, r11)
            if (r6 == 0) goto L_0x0051
            r3 = 5
        L_0x0051:
            r6 = 3
            if (r3 != r6) goto L_0x0078
            int r9 = r8.read()
            if (r9 >= 0) goto L_0x005f
            java.lang.String r6 = "unexpected EOF after single escape"
            r8.eofError(r6)
        L_0x005f:
            boolean r6 = r11.hexEscapeAfterBackslash
            if (r6 == 0) goto L_0x006f
            r6 = 120(0x78, float:1.68E-43)
            if (r9 == r6) goto L_0x006b
            r6 = 88
            if (r9 != r6) goto L_0x006f
        L_0x006b:
            int r9 = r8.readHexEscape()
        L_0x006f:
            r8.tokenBufferAppend(r7)
            r8.tokenBufferAppend(r9)
            r8.seenEscapes = r5
            goto L_0x0021
        L_0x0078:
            r6 = 4
            if (r3 != r6) goto L_0x0083
            if (r2 != 0) goto L_0x0081
            r2 = r5
        L_0x007e:
            r8.seenEscapes = r5
            goto L_0x0021
        L_0x0081:
            r2 = 0
            goto L_0x007e
        L_0x0083:
            if (r2 == 0) goto L_0x008c
            r8.tokenBufferAppend(r7)
            r8.tokenBufferAppend(r9)
            goto L_0x0021
        L_0x008c:
            switch(r3) {
                case 1: goto L_0x0090;
                case 2: goto L_0x0094;
                case 3: goto L_0x008f;
                case 4: goto L_0x00a2;
                case 5: goto L_0x00a7;
                case 6: goto L_0x009e;
                default: goto L_0x008f;
            }
        L_0x008f:
            goto L_0x0021
        L_0x0090:
            r8.unread(r9)
            goto L_0x0035
        L_0x0094:
            r6 = 123(0x7b, float:1.72E-43)
            if (r9 != r6) goto L_0x009e
            gnu.kawa.lispexpr.ReadTableEntry r6 = gnu.kawa.lispexpr.ReadTableEntry.brace
            if (r1 != r6) goto L_0x009e
            int r0 = r0 + 1
        L_0x009e:
            r8.tokenBufferAppend(r9)
            goto L_0x0021
        L_0x00a2:
            r2 = 1
            r8.seenEscapes = r5
            goto L_0x0021
        L_0x00a7:
            r8.unread(r9)
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.kawa.lispexpr.LispReader.readToken(int, char, gnu.kawa.lispexpr.ReadTable):void");
    }

    public Object readObject() throws IOException, SyntaxException {
        int line;
        int column;
        Object value;
        char saveReadState = ((InPort) this.port).readState;
        int startPos = this.tokenBufferLength;
        ((InPort) this.port).readState = ' ';
        try {
            ReadTable rtable = ReadTable.getCurrent();
            do {
                line = this.port.getLineNumber();
                column = this.port.getColumnNumber();
                int ch = this.port.read();
                if (ch < 0) {
                    return Sequence.eofValue;
                }
                value = readValues(ch, rtable);
            } while (value == Values.empty);
            return handlePostfix(value, rtable, line, column);
        } finally {
            this.tokenBufferLength = startPos;
            ((InPort) this.port).readState = saveReadState;
        }
    }

    protected boolean validPostfixLookupStart(int ch, ReadTable rtable) throws IOException {
        if (ch < 0 || ch == 58 || ch == rtable.postfixLookupOperator) {
            return false;
        }
        if (ch == 44) {
            return true;
        }
        int kind = rtable.lookup(ch).getKind();
        return kind == 2 || kind == 6 || kind == 4 || kind == 3;
    }

    public Object handlePostfix(Object value, ReadTable rtable, int line, int column) throws IOException, SyntaxException {
        if (value == QuoteExp.voidExp) {
            value = Values.empty;
        }
        while (true) {
            int ch = this.port.peek();
            if (ch < 0 || ch != rtable.postfixLookupOperator) {
                break;
            }
            this.port.read();
            if (!validPostfixLookupStart(this.port.peek(), rtable)) {
                unread();
                break;
            }
            int ch2 = this.port.read();
            value = PairWithPosition.make(LispLanguage.lookup_sym, LList.list2(value, LList.list2(rtable.makeSymbol(LispLanguage.quasiquote_sym), readValues(ch2, rtable.lookup(ch2), rtable))), this.port.getName(), line + 1, column + 1);
        }
        return value;
    }

    private boolean isPotentialNumber(char[] buffer, int start, int end) {
        boolean z = true;
        int sawDigits = 0;
        for (int i = start; i < end; i++) {
            char ch = buffer[i];
            if (Character.isDigit(ch)) {
                sawDigits++;
            } else if (ch == '-' || ch == '+') {
                if (i + 1 == end) {
                    return false;
                }
            } else if (ch == '#') {
                return true;
            } else {
                if (Character.isLetter(ch) || ch == '/' || ch == '_' || ch == '^') {
                    if (i == start) {
                        return false;
                    }
                } else if (ch != '.') {
                    return false;
                }
            }
        }
        if (sawDigits <= 0) {
            z = false;
        }
        return z;
    }

    public static Object parseNumber(CharSequence str, int radix) {
        char[] buf;
        if (str instanceof FString) {
            buf = ((FString) str).data;
        } else {
            buf = str.toString().toCharArray();
        }
        return parseNumber(buf, 0, str.length(), (char) 0, radix, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x01aa, code lost:
        r34 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01ac, code lost:
        if (r6 >= 0) goto L_0x0511;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01ae, code lost:
        if (r50 == false) goto L_0x01de;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01b4, code lost:
        if ((r13 + 4) >= r26) goto L_0x01de;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x01bc, code lost:
        if (r54[r13 + 3] != '.') goto L_0x01de;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x01c4, code lost:
        if (r54[r13 + 4] != '0') goto L_0x01de;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x01ca, code lost:
        if (r54[r13] != 'i') goto L_0x0296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01d2, code lost:
        if (r54[r13 + 1] != 'n') goto L_0x0296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01da, code lost:
        if (r54[r13 + 2] != 'f') goto L_0x0296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01dc, code lost:
        r34 = 'i';
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01de, code lost:
        if (r34 != 0) goto L_0x02b0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01e0, code lost:
        return "no digits";
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x029a, code lost:
        if (r54[r13] != 'n') goto L_0x01de;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x02a2, code lost:
        if (r54[r13 + 1] != 'a') goto L_0x01de;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x02aa, code lost:
        if (r54[r13 + 2] != 'n') goto L_0x01de;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x02ac, code lost:
        r34 = 'n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x02b0, code lost:
        r43 = r13 + 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x02b4, code lost:
        if (r30 != false) goto L_0x02b8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x02b6, code lost:
        if (r52 == false) goto L_0x02b8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x02bc, code lost:
        if (r57 == 'i') goto L_0x02cc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x02c2, code lost:
        if (r57 == 'I') goto L_0x02cc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x02c8, code lost:
        if (r57 != ' ') goto L_0x0328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x02ca, code lost:
        if (r30 == false) goto L_0x0328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x02cc, code lost:
        r33 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x02ce, code lost:
        r27 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x02d2, code lost:
        if (r34 == 0) goto L_0x032e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x02da, code lost:
        if (r34 != 'i') goto L_0x032b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x02dc, code lost:
        r22 = Double.POSITIVE_INFINITY;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x02e0, code lost:
        if (r9 == false) goto L_0x02e7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x02e2, code lost:
        r22 = -r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x02e7, code lost:
        r38 = new gnu.math.DFloNum(r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x02f2, code lost:
        if (r57 == 'e') goto L_0x02fa;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x02f8, code lost:
        if (r57 != 'E') goto L_0x02fe;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x02fa, code lost:
        r38 = r38.toExact();
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0302, code lost:
        if (r43 >= r26) goto L_0x04d7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0304, code lost:
        r13 = r43 + 1;
        r18 = r54[r43];
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x030c, code lost:
        if (r18 != '@') goto L_0x042c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x030e, code lost:
        r4 = parseNumber(r54, r13, r26 - r13, r57, 10, r59);
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x031e, code lost:
        if ((r4 instanceof java.lang.String) != false) goto L_?;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0322, code lost:
        if ((r4 instanceof gnu.math.RealNum) != false) goto L_0x0409;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0324, code lost:
        return "invalid complex polar constant";
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0328, code lost:
        r33 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x032b, code lost:
        r22 = Double.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x032e, code lost:
        if (r29 >= 0) goto L_0x0332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0330, code lost:
        if (r21 < 0) goto L_0x039b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0334, code lost:
        if (r6 <= r21) goto L_0x033a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0336, code lost:
        if (r21 < 0) goto L_0x033a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0338, code lost:
        r6 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x033a, code lost:
        if (r40 == null) goto L_0x0342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0342, code lost:
        r51 = new java.lang.String(r54, r6, r43 - r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x034d, code lost:
        if (r29 < 0) goto L_0x0385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x034f, code lost:
        r27 = java.lang.Character.toLowerCase(r54[r29]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0359, code lost:
        if (r27 == 'e') goto L_0x0385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x035b, code lost:
        r44 = r29 - r6;
        r51 = r51.substring(0, r44) + 'e' + r51.substring(r44 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0385, code lost:
        r22 = gnu.lists.Convert.parseDouble(r51);
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x038b, code lost:
        if (r9 == false) goto L_0x0392;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x038d, code lost:
        r22 = -r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0392, code lost:
        r38 = new gnu.math.DFloNum(r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x039b, code lost:
        r35 = valueOf(r54, r6, r43 - r6, r58, r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x03a5, code lost:
        if (r40 != null) goto L_0x03c6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x03a7, code lost:
        r39 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x03ab, code lost:
        if (r33 == false) goto L_0x050d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x03b1, code lost:
        if (r39.isExact() == false) goto L_0x050d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x03b5, code lost:
        if (r9 == false) goto L_0x0404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x03bb, code lost:
        if (r39.isZero() == false) goto L_0x0404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x03bd, code lost:
        r14 = -0.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x03bf, code lost:
        r38 = new gnu.math.DFloNum(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x03ca, code lost:
        if (r35.isZero() == false) goto L_0x03f9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x03cc, code lost:
        r42 = r40.isZero();
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x03d0, code lost:
        if (r33 == false) goto L_0x03e8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x03d4, code lost:
        if (r42 == false) goto L_0x03e0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x03d6, code lost:
        r14 = Double.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x03d8, code lost:
        r38 = new gnu.math.DFloNum(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x03dd, code lost:
        r39 = r38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x03e0, code lost:
        if (r9 == false) goto L_0x03e5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x03e2, code lost:
        r14 = Double.NEGATIVE_INFINITY;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x03e5, code lost:
        r14 = Double.POSITIVE_INFINITY;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x03e8, code lost:
        if (r42 == false) goto L_0x03f0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x03f0, code lost:
        r38 = gnu.math.RatNum.make(r40, r35);
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x03f9, code lost:
        r39 = gnu.math.RatNum.make(r40, r35);
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0404, code lost:
        r14 = r39.doubleValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0409, code lost:
        r46 = (gnu.math.RealNum) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0411, code lost:
        if (r38.isZero() == false) goto L_0x0422;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0417, code lost:
        if (r46.isExact() != false) goto L_0x0422;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0430, code lost:
        if (r18 == '-') goto L_0x0438;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0436, code lost:
        if (r18 != '+') goto L_0x0493;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0438, code lost:
        r13 = r13 - 1;
        r32 = parseNumber(r54, r13, r26 - r13, r57, 10, r59);
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x044c, code lost:
        if ((r32 instanceof java.lang.String) == false) goto L_0x0452;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0456, code lost:
        if ((r32 instanceof gnu.math.Complex) != false) goto L_0x0475;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0475, code lost:
        r19 = (gnu.math.Complex) r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0481, code lost:
        if (r19.re().isZero() != false) goto L_0x0487;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0483, code lost:
        return "invalid numeric constant";
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0493, code lost:
        r36 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0499, code lost:
        if (java.lang.Character.isLetter(r18) != false) goto L_0x04ba;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x049b, code lost:
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x04a0, code lost:
        if (r36 != 1) goto L_0x04d3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x04a2, code lost:
        r45 = r54[r13 - 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x04aa, code lost:
        if (r45 == 'i') goto L_0x04b2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x04b0, code lost:
        if (r45 != 'I') goto L_0x04d3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x04b4, code lost:
        if (r13 >= r26) goto L_0x04c7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x04b6, code lost:
        return "junk after imaginary suffix 'i'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x04ba, code lost:
        r36 = r36 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x04be, code lost:
        if (r13 == r26) goto L_0x049d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x04c0, code lost:
        r18 = r54[r13];
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x04d3, code lost:
        return "excess junk after number";
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x04db, code lost:
        if ((r38 instanceof gnu.math.DFloNum) == false) goto L_0x04ec;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x04dd, code lost:
        if (r27 <= 0) goto L_0x04ec;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x04e3, code lost:
        if (r27 == 'e') goto L_0x04ec;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x04e5, code lost:
        r22 = r38.doubleValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x04e9, code lost:
        switch(r27) {
            case 100: goto L_0x04fd;
            case 102: goto L_0x04f2;
            case 108: goto L_0x0505;
            case 115: goto L_0x04f2;
            default: goto L_0x04ec;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x050d, code lost:
        r38 = r39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0511, code lost:
        r43 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:?, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:?, code lost:
        return "floating-point number after fraction symbol '/'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:?, code lost:
        return "0/0 is undefined";
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:?, code lost:
        return new gnu.math.DFloNum(0.0d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:?, code lost:
        return gnu.math.Complex.polar(r38, r46);
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:?, code lost:
        return r32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:?, code lost:
        return "invalid numeric constant (" + r32 + ")";
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:?, code lost:
        return gnu.math.Complex.make(r38, r19.im());
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:?, code lost:
        return gnu.math.Complex.make(gnu.math.IntNum.zero(), r38);
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:?, code lost:
        return r38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:?, code lost:
        return java.lang.Float.valueOf((float) r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:?, code lost:
        return java.lang.Double.valueOf(r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:?, code lost:
        return java.math.BigDecimal.valueOf(r22);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object parseNumber(char[] r54, int r55, int r56, char r57, int r58, int r59) {
        /*
            Method dump skipped, instructions count: 1424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.kawa.lispexpr.LispReader.parseNumber(char[], int, int, char, int, int):java.lang.Object");
    }

    private static IntNum valueOf(char[] buffer, int digits_start, int number_of_digits, int radix, boolean negative, long lvalue) {
        if (number_of_digits + radix > 28) {
            return IntNum.valueOf(buffer, digits_start, number_of_digits, radix, negative);
        }
        if (negative) {
            lvalue = -lvalue;
        }
        return IntNum.make(lvalue);
    }

    public int readEscape() throws IOException, SyntaxException {
        int c = read();
        if (c >= 0) {
            return readEscape(c);
        }
        eofError("unexpected EOF in character literal");
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int readEscape(int r11) throws java.io.IOException, gnu.text.SyntaxException {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.kawa.lispexpr.LispReader.readEscape(int):int");
    }

    public int readHexEscape() throws IOException, SyntaxException {
        int d;
        int c = 0;
        while (true) {
            d = read();
            int v = Character.digit((char) d, 16);
            if (v < 0) {
                break;
            }
            c = (c << 4) + v;
        }
        if (d != 59 && d >= 0) {
            unread(d);
        }
        return c;
    }

    public final Object readObject(int c) throws IOException, SyntaxException {
        unread(c);
        return readObject();
    }

    public Object readCommand() throws IOException, SyntaxException {
        return readObject();
    }

    public Object makeNil() {
        return LList.Empty;
    }

    public Pair makePair(Object car, int line, int column) {
        return makePair(car, LList.Empty, line, column);
    }

    protected Pair makePair(Object car, Object cdr, int line, int column) {
        String pname = this.port.getName();
        return (pname == null || line < 0) ? Pair.make(car, cdr) : PairWithPosition.make(car, cdr, pname, line + 1, column + 1);
    }

    public void setCdr(Object pair, Object cdr) {
        ((Pair) pair).setCdrBackdoor(cdr);
    }

    public static Object readNumberWithRadix(int previous, LispReader reader, int radix) throws IOException, SyntaxException {
        int startPos = reader.tokenBufferLength - previous;
        reader.readToken(reader.read(), 'P', ReadTable.getCurrent());
        int endPos = reader.tokenBufferLength;
        if (startPos == endPos) {
            reader.error("missing numeric token");
            return IntNum.zero();
        }
        Object result = parseNumber(reader.tokenBuffer, startPos, endPos - startPos, (char) 0, radix, 0);
        if (result instanceof String) {
            reader.error((String) result);
            return IntNum.zero();
        } else if (result != null) {
            return result;
        } else {
            reader.error("invalid numeric constant");
            return IntNum.zero();
        }
    }

    public static Object readCharacter(LispReader reader) throws IOException, SyntaxException {
        int ch = reader.read();
        if (ch < 0) {
            reader.eofError("unexpected EOF in character literal");
        }
        int startPos = reader.tokenBufferLength;
        reader.tokenBufferAppend(ch);
        reader.readToken(reader.read(), 'D', ReadTable.getCurrent());
        char[] tokenBuffer = reader.tokenBuffer;
        int length = reader.tokenBufferLength - startPos;
        if (length == 1) {
            return Char.make(tokenBuffer[startPos]);
        }
        String name = new String(tokenBuffer, startPos, length);
        int ch2 = Char.nameToChar(name);
        if (ch2 >= 0) {
            return Char.make(ch2);
        }
        char c = tokenBuffer[startPos];
        if (c == 'x' || c == 'X') {
            int value = 0;
            for (int i = 1; i != length; i++) {
                int v = Character.digit(tokenBuffer[startPos + i], 16);
                if (v >= 0 && (value = (value * 16) + v) <= 1114111) {
                }
            }
            return Char.make(value);
        }
        int ch3 = Character.digit((int) c, 8);
        if (ch3 >= 0) {
            int value2 = ch3;
            for (int i2 = 1; i2 != length; i2++) {
                int ch4 = Character.digit(tokenBuffer[startPos + i2], 8);
                if (ch4 >= 0) {
                    value2 = (value2 * 8) + ch4;
                }
            }
            return Char.make(value2);
        }
        reader.error("unknown character name: " + name);
        return Char.make(63);
    }

    public static Object readSpecial(LispReader reader) throws IOException, SyntaxException {
        int ch = reader.read();
        if (ch < 0) {
            reader.eofError("unexpected EOF in #! special form");
        }
        if (ch == 47 && reader.getLineNumber() == 0 && reader.getColumnNumber() == 3) {
            ReaderIgnoreRestOfLine.getInstance().read(reader, 35, 1);
            return Values.empty;
        }
        int startPos = reader.tokenBufferLength;
        reader.tokenBufferAppend(ch);
        reader.readToken(reader.read(), 'D', ReadTable.getCurrent());
        String name = new String(reader.tokenBuffer, startPos, reader.tokenBufferLength - startPos);
        if (name.equals("optional")) {
            return Special.optional;
        }
        if (name.equals("rest")) {
            return Special.rest;
        }
        if (name.equals("key")) {
            return Special.key;
        }
        if (name.equals("eof")) {
            return Special.eof;
        }
        if (name.equals("void")) {
            return QuoteExp.voidExp;
        }
        if (name.equals("default")) {
            return Special.dfault;
        }
        if (name.equals("undefined")) {
            return Special.undefined;
        }
        if (name.equals("abstract")) {
            return Special.abstractSpecial;
        }
        if (name.equals("null")) {
            return null;
        }
        reader.error("unknown named constant #!" + name);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static gnu.lists.SimpleVector readSimpleVector(gnu.kawa.lispexpr.LispReader r11, char r12) throws java.io.IOException, gnu.text.SyntaxException {
        /*
            r10 = 40
            r9 = 32
            r6 = 0
            r5 = 0
        L_0x0006:
            int r0 = r11.read()
            if (r0 >= 0) goto L_0x0011
            java.lang.String r7 = "unexpected EOF reading uniform vector"
            r11.eofError(r7)
        L_0x0011:
            char r7 = (char) r0
            r8 = 10
            int r1 = java.lang.Character.digit(r7, r8)
            if (r1 >= 0) goto L_0x0036
            r7 = 8
            if (r5 == r7) goto L_0x0028
            r7 = 16
            if (r5 == r7) goto L_0x0028
            if (r5 == r9) goto L_0x0028
            r7 = 64
            if (r5 != r7) goto L_0x0030
        L_0x0028:
            r7 = 70
            if (r12 != r7) goto L_0x002e
            if (r5 < r9) goto L_0x0030
        L_0x002e:
            if (r0 == r10) goto L_0x003b
        L_0x0030:
            java.lang.String r7 = "invalid uniform vector syntax"
            r11.error(r7)
        L_0x0035:
            return r6
        L_0x0036:
            int r7 = r5 * 10
            int r5 = r7 + r1
            goto L_0x0006
        L_0x003b:
            r7 = -1
            r8 = 41
            java.lang.Object r3 = gnu.kawa.lispexpr.ReaderParens.readList(r11, r10, r7, r8)
            r7 = 0
            int r2 = gnu.lists.LList.listLength(r3, r7)
            if (r2 >= 0) goto L_0x004f
            java.lang.String r7 = "invalid elements in uniform vector syntax"
            r11.error(r7)
            goto L_0x0035
        L_0x004f:
            r4 = r3
            gnu.lists.Sequence r4 = (gnu.lists.Sequence) r4
            switch(r12) {
                case 70: goto L_0x0056;
                case 83: goto L_0x0059;
                case 85: goto L_0x005c;
                default: goto L_0x0055;
            }
        L_0x0055:
            goto L_0x0035
        L_0x0056:
            switch(r5) {
                case 32: goto L_0x0066;
                case 64: goto L_0x006c;
                default: goto L_0x0059;
            }
        L_0x0059:
            switch(r5) {
                case 8: goto L_0x0072;
                case 16: goto L_0x0078;
                case 32: goto L_0x007e;
                case 64: goto L_0x0084;
                default: goto L_0x005c;
            }
        L_0x005c:
            switch(r5) {
                case 8: goto L_0x0060;
                case 16: goto L_0x008a;
                case 32: goto L_0x0090;
                case 64: goto L_0x0096;
                default: goto L_0x005f;
            }
        L_0x005f:
            goto L_0x0035
        L_0x0060:
            gnu.lists.U8Vector r6 = new gnu.lists.U8Vector
            r6.<init>(r4)
            goto L_0x0035
        L_0x0066:
            gnu.lists.F32Vector r6 = new gnu.lists.F32Vector
            r6.<init>(r4)
            goto L_0x0035
        L_0x006c:
            gnu.lists.F64Vector r6 = new gnu.lists.F64Vector
            r6.<init>(r4)
            goto L_0x0035
        L_0x0072:
            gnu.lists.S8Vector r6 = new gnu.lists.S8Vector
            r6.<init>(r4)
            goto L_0x0035
        L_0x0078:
            gnu.lists.S16Vector r6 = new gnu.lists.S16Vector
            r6.<init>(r4)
            goto L_0x0035
        L_0x007e:
            gnu.lists.S32Vector r6 = new gnu.lists.S32Vector
            r6.<init>(r4)
            goto L_0x0035
        L_0x0084:
            gnu.lists.S64Vector r6 = new gnu.lists.S64Vector
            r6.<init>(r4)
            goto L_0x0035
        L_0x008a:
            gnu.lists.U16Vector r6 = new gnu.lists.U16Vector
            r6.<init>(r4)
            goto L_0x0035
        L_0x0090:
            gnu.lists.U32Vector r6 = new gnu.lists.U32Vector
            r6.<init>(r4)
            goto L_0x0035
        L_0x0096:
            gnu.lists.U64Vector r6 = new gnu.lists.U64Vector
            r6.<init>(r4)
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.kawa.lispexpr.LispReader.readSimpleVector(gnu.kawa.lispexpr.LispReader, char):gnu.lists.SimpleVector");
    }
}
