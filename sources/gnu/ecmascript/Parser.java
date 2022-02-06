package gnu.ecmascript;

import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.SetExp;
import gnu.lists.Sequence;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.mapping.TtyInPort;
import gnu.mapping.Values;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.util.Vector;
import kawa.standard.Scheme;

/* loaded from: classes.dex */
public class Parser {
    public int errors;
    Lexer lexer;
    InPort port;
    Object previous_token;
    Object token;
    public static Expression eofExpr = new QuoteExp(Sequence.eofValue);
    public static final Expression[] emptyArgs = new Expression[0];
    static Expression emptyStatement = new QuoteExp(Values.empty);

    public Parser(InPort port) {
        this.port = port;
        this.lexer = new Lexer(port);
    }

    public Expression parseConditionalExpression() throws IOException, SyntaxException {
        Expression exp1 = parseBinaryExpression(1);
        if (peekToken() != Lexer.condToken) {
            return exp1;
        }
        skipToken();
        Expression exp2 = parseAssignmentExpression();
        if (getToken() != Lexer.colonToken) {
            return syntaxError("expected ':' in conditional expression");
        }
        return new IfExp(exp1, exp2, parseAssignmentExpression());
    }

    public Expression parseAssignmentExpression() throws IOException, SyntaxException {
        Expression exp1 = parseConditionalExpression();
        Object token = peekToken();
        if (token == Lexer.equalToken) {
            skipToken();
            Expression exp2 = parseAssignmentExpression();
            if (!(exp1 instanceof ReferenceExp)) {
                return syntaxError("unmplemented non-symbol ihs in assignment");
            }
            SetExp sex = new SetExp(((ReferenceExp) exp1).getName(), exp2);
            sex.setDefining(true);
            return sex;
        } else if (!(token instanceof Reserved)) {
            return exp1;
        } else {
            Reserved op = (Reserved) token;
            if (!op.isAssignmentOp()) {
                return exp1;
            }
            skipToken();
            return new ApplyExp((Expression) new QuoteExp(op.proc), exp1, parseAssignmentExpression());
        }
    }

    public Expression parseExpression() throws IOException, SyntaxException {
        Expression[] exps = null;
        int nExps = 0;
        while (true) {
            Expression exp1 = parseAssignmentExpression();
            boolean last = peekToken() != Lexer.commaToken;
            if (exps == null) {
                if (last) {
                    return exp1;
                }
                exps = new Expression[2];
            } else if (!last ? exps.length <= nExps : exps.length != nExps + 1) {
                Expression[] new_exps = new Expression[last ? nExps + 1 : exps.length * 2];
                System.arraycopy(exps, 0, new_exps, 0, nExps);
                exps = new_exps;
            }
            int nExps2 = nExps + 1;
            exps[nExps] = exp1;
            if (last) {
                return new BeginExp(exps);
            }
            skipToken();
            nExps = nExps2;
        }
    }

    public Object peekTokenOrLine() throws IOException, SyntaxException {
        if (this.token == null) {
            this.token = this.lexer.getToken();
        }
        return this.token;
    }

    public Object peekToken() throws IOException, SyntaxException {
        if (this.token == null) {
            this.token = this.lexer.getToken();
        }
        while (this.token == Lexer.eolToken) {
            skipToken();
            this.token = this.lexer.getToken();
        }
        return this.token;
    }

    public Object getToken() throws IOException, SyntaxException {
        Object result = peekToken();
        skipToken();
        return result;
    }

    public final void skipToken() {
        if (this.token != Lexer.eofToken) {
            this.previous_token = this.token;
            this.token = null;
        }
    }

    public void getSemicolon() throws IOException, SyntaxException {
        this.token = peekToken();
        if (this.token == Lexer.semicolonToken) {
            skipToken();
        } else if (this.token != Lexer.rbraceToken && this.token != Lexer.eofToken && this.previous_token != Lexer.eolToken) {
            syntaxError("missing ';' after expression");
        }
    }

    public Expression parsePrimaryExpression() throws IOException, SyntaxException {
        Object result = getToken();
        if (result instanceof QuoteExp) {
            return (QuoteExp) result;
        }
        if (result instanceof String) {
            return new ReferenceExp((String) result);
        }
        if (result != Lexer.lparenToken) {
            return syntaxError("unexpected token: " + result);
        }
        Expression expr = parseExpression();
        Object token = getToken();
        return token != Lexer.rparenToken ? syntaxError("expected ')' - got:" + token) : expr;
    }

    public Expression makePropertyAccessor(Expression exp, Expression prop) {
        return null;
    }

    public Expression[] parseArguments() throws IOException, SyntaxException {
        skipToken();
        if (peekToken() == Lexer.rparenToken) {
            skipToken();
            return emptyArgs;
        }
        Vector args = new Vector(10);
        while (true) {
            args.addElement(parseAssignmentExpression());
            Object token = getToken();
            if (token == Lexer.rparenToken) {
                Expression[] exps = new Expression[args.size()];
                args.copyInto(exps);
                return exps;
            } else if (token != Lexer.commaToken) {
                syntaxError("invalid token '" + token + "' in argument list");
            }
        }
    }

    public Expression makeNewExpression(Expression exp, Expression[] args) {
        if (args == null) {
            args = emptyArgs;
        }
        return new ApplyExp((Expression) null, args);
    }

    public Expression makeCallExpression(Expression exp, Expression[] args) {
        return new ApplyExp(exp, args);
    }

    public String getIdentifier() throws IOException, SyntaxException {
        Object token = getToken();
        if (token instanceof String) {
            return (String) token;
        }
        syntaxError("missing identifier");
        return "??";
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008e, code lost:
        if (r3 <= 0) goto L_0x0098;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
        r1 = makeNewExpression(r1, null);
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public gnu.expr.Expression parseLeftHandSideExpression() throws java.io.IOException, gnu.text.SyntaxException {
        /*
            r9 = this;
            r3 = 0
        L_0x0001:
            java.lang.Object r6 = r9.peekToken()
            gnu.ecmascript.Reserved r7 = gnu.ecmascript.Lexer.newToken
            if (r6 != r7) goto L_0x000f
            int r3 = r3 + 1
            r9.skipToken()
            goto L_0x0001
        L_0x000f:
            gnu.expr.Expression r1 = r9.parsePrimaryExpression()
        L_0x0013:
            java.lang.Object r5 = r9.peekToken()
            gnu.text.Char r6 = gnu.ecmascript.Lexer.dotToken
            if (r5 != r6) goto L_0x002c
            r9.skipToken()
            java.lang.String r2 = r9.getIdentifier()
            gnu.expr.QuoteExp r6 = new gnu.expr.QuoteExp
            r6.<init>(r2)
            gnu.expr.Expression r1 = r9.makePropertyAccessor(r1, r6)
            goto L_0x0013
        L_0x002c:
            gnu.text.Char r6 = gnu.ecmascript.Lexer.lbracketToken
            if (r5 != r6) goto L_0x005c
            r9.skipToken()
            gnu.expr.Expression r4 = r9.parseExpression()
            java.lang.Object r5 = r9.getToken()
            gnu.text.Char r6 = gnu.ecmascript.Lexer.rbracketToken
            if (r5 == r6) goto L_0x0057
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "expected ']' - got:"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r5)
            java.lang.String r6 = r6.toString()
            gnu.expr.Expression r6 = r9.syntaxError(r6)
        L_0x0056:
            return r6
        L_0x0057:
            gnu.expr.Expression r1 = r9.makePropertyAccessor(r1, r4)
            goto L_0x0013
        L_0x005c:
            gnu.text.Char r6 = gnu.ecmascript.Lexer.lparenToken
            if (r5 != r6) goto L_0x008e
            gnu.expr.Expression[] r0 = r9.parseArguments()
            java.io.PrintStream r6 = java.lang.System.err
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "after parseArgs:"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.Object r8 = r9.peekToken()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.println(r7)
            if (r3 <= 0) goto L_0x0089
            gnu.expr.Expression r1 = r9.makeNewExpression(r1, r0)
            int r3 = r3 + (-1)
            goto L_0x0013
        L_0x0089:
            gnu.expr.Expression r1 = r9.makeCallExpression(r1, r0)
            goto L_0x0013
        L_0x008e:
            if (r3 <= 0) goto L_0x0098
            r6 = 0
            gnu.expr.Expression r1 = r9.makeNewExpression(r1, r6)
            int r3 = r3 + (-1)
            goto L_0x008e
        L_0x0098:
            r6 = r1
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.ecmascript.Parser.parseLeftHandSideExpression():gnu.expr.Expression");
    }

    public Expression parsePostfixExpression() throws IOException, SyntaxException {
        Expression exp = parseLeftHandSideExpression();
        Object op = peekTokenOrLine();
        if (op != Reserved.opPlusPlus && op != Reserved.opMinusMinus) {
            return exp;
        }
        skipToken();
        return new ApplyExp((Expression) new QuoteExp(((Reserved) op).proc), exp);
    }

    public Expression parseUnaryExpression() throws IOException, SyntaxException {
        return parsePostfixExpression();
    }

    public Expression syntaxError(String message) {
        this.errors++;
        OutPort err = OutPort.errDefault();
        String current_filename = this.port.getName();
        int current_line = this.port.getLineNumber() + 1;
        int current_column = this.port.getColumnNumber() + 1;
        if (current_line > 0) {
            if (current_filename != null) {
                err.print(current_filename);
            }
            err.print(':');
            err.print(current_line);
            if (current_column > 1) {
                err.print(':');
                err.print(current_column);
            }
            err.print(": ");
        }
        err.println(message);
        return new ErrorExp(message);
    }

    public Expression parseBinaryExpression(int prio) throws IOException, SyntaxException {
        Expression exp1 = parseUnaryExpression();
        while (true) {
            this.token = peekToken();
            if (this.token instanceof Reserved) {
                Reserved op = (Reserved) this.token;
                if (op.prio < prio) {
                    break;
                }
                getToken();
                exp1 = new ApplyExp((Expression) new QuoteExp(op.proc), exp1, parseBinaryExpression(op.prio + 1));
            } else {
                break;
            }
        }
        return exp1;
    }

    public Expression parseIfStatement() throws IOException, SyntaxException {
        Expression else_part;
        skipToken();
        Object token = getToken();
        if (token != Lexer.lparenToken) {
            return syntaxError("expected '(' - got:" + token);
        }
        Expression test_part = parseExpression();
        Object token2 = getToken();
        if (token2 != Lexer.rparenToken) {
            return syntaxError("expected ')' - got:" + token2);
        }
        Expression then_part = parseStatement();
        if (peekToken() == Lexer.elseToken) {
            skipToken();
            else_part = parseStatement();
        } else {
            else_part = null;
        }
        return new IfExp(test_part, then_part, else_part);
    }

    public Expression buildLoop(Expression init, Expression test, Expression incr, Expression body) {
        if (init != null) {
            return new BeginExp(new Expression[]{init, buildLoop(null, test, incr, body)});
        }
        throw new Error("not implemented - buildLoop");
    }

    public Expression parseWhileStatement() throws IOException, SyntaxException {
        skipToken();
        Object token = getToken();
        if (token != Lexer.lparenToken) {
            return syntaxError("expected '(' - got:" + token);
        }
        Expression test_part = parseExpression();
        Object token2 = getToken();
        if (token2 != Lexer.rparenToken) {
            return syntaxError("expected ')' - got:" + token2);
        }
        return buildLoop(null, test_part, null, parseStatement());
    }

    public Expression parseFunctionDefinition() throws IOException, SyntaxException {
        skipToken();
        String name = getIdentifier();
        Object token = getToken();
        if (token != Lexer.lparenToken) {
            return syntaxError("expected '(' - got:" + token);
        }
        Vector args = new Vector(10);
        if (peekToken() == Lexer.rparenToken) {
            skipToken();
        } else {
            while (true) {
                args.addElement(getIdentifier());
                Object token2 = getToken();
                if (token2 == Lexer.rparenToken) {
                    break;
                } else if (token2 != Lexer.commaToken) {
                    syntaxError("invalid token '" + token2 + "' in argument list");
                }
            }
        }
        LambdaExp lexp = new LambdaExp(parseBlock());
        lexp.setName(name);
        SetExp sexp = new SetExp(name, lexp);
        sexp.setDefining(true);
        return sexp;
    }

    public Expression parseBlock() throws IOException, SyntaxException {
        boolean last;
        Expression[] exps = null;
        if (getToken() != Lexer.lbraceToken) {
            return syntaxError("extened '{'");
        }
        int nExps = 0;
        while (true) {
            this.token = peekToken();
            if (this.token == Lexer.rbraceToken) {
                skipToken();
                if (exps == null) {
                    return emptyStatement;
                }
                last = true;
            } else {
                last = false;
            }
            if (exps == null) {
                exps = new Expression[2];
            } else if (!last ? exps.length <= nExps : exps.length != nExps) {
                Expression[] new_exps = new Expression[last ? nExps : exps.length * 2];
                System.arraycopy(exps, 0, new_exps, 0, nExps);
                exps = new_exps;
            }
            if (last) {
                return new BeginExp(exps);
            }
            exps[nExps] = parseStatement();
            nExps++;
        }
    }

    public Expression parseStatement() throws IOException, SyntaxException {
        Object token = peekToken();
        if (token instanceof Reserved) {
            switch (((Reserved) token).prio) {
                case 31:
                    return parseIfStatement();
                case 32:
                    return parseWhileStatement();
                case 41:
                    return parseFunctionDefinition();
            }
        }
        if (token == Lexer.eofToken) {
            return eofExpr;
        }
        if (token == Lexer.semicolonToken) {
            skipToken();
            return emptyStatement;
        } else if (token == Lexer.lbraceToken) {
            return parseBlock();
        } else {
            Expression parseExpression = parseExpression();
            getSemicolon();
            return parseExpression;
        }
    }

    public static void main(String[] args) {
        new Scheme();
        InPort inp = InPort.inDefault();
        if (inp instanceof TtyInPort) {
            ((TtyInPort) inp).setPrompter(new Prompter());
        }
        Parser parser = new Parser(inp);
        OutPort out = OutPort.outDefault();
        while (true) {
            try {
                Expression expr = parser.parseStatement();
                if (expr != eofExpr) {
                    out.print("[Expression: ");
                    expr.print(out);
                    out.println("]");
                    Object result = expr.eval(Environment.user());
                    out.print("result: ");
                    out.print(result);
                    out.println();
                } else {
                    return;
                }
            } catch (Throwable ex) {
                System.err.println("caught exception:" + ex);
                ex.printStackTrace(System.err);
                return;
            }
        }
    }
}
