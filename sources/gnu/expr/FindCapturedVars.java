package gnu.expr;

import gnu.mapping.EnvironmentKey;
import gnu.mapping.KeyPair;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class FindCapturedVars extends ExpExpVisitor<Void> {
    int backJumpPossible = 0;
    Hashtable unknownDecls = null;
    ModuleExp currentModule = null;

    public static void findCapturedVars(Expression exp, Compilation comp) {
        FindCapturedVars visitor = new FindCapturedVars();
        visitor.setContext(comp);
        exp.visit(visitor, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Expression visitApplyExp(ApplyExp exp, Void ignored) {
        int oldBackJumpPossible = this.backJumpPossible;
        boolean skipFunc = false;
        boolean skipArgs = false;
        if ((exp.func instanceof ReferenceExp) && Compilation.defaultCallConvention <= 1) {
            Declaration decl = Declaration.followAliases(((ReferenceExp) exp.func).binding);
            if (decl != null && (decl.context instanceof ModuleExp) && !decl.isPublic() && !decl.getFlag(4096L)) {
                Expression value = decl.getValue();
                if ((value instanceof LambdaExp) && !((LambdaExp) value).getNeedsClosureEnv()) {
                    skipFunc = true;
                }
            }
        } else if ((exp.func instanceof QuoteExp) && exp.getArgCount() > 0) {
            Object val = ((QuoteExp) exp.func).getValue();
            Expression arg0 = exp.getArg(0);
            if ((val instanceof PrimProcedure) && (arg0 instanceof ReferenceExp)) {
                PrimProcedure primProcedure = (PrimProcedure) val;
                Declaration decl2 = Declaration.followAliases(((ReferenceExp) arg0).binding);
                if (decl2 != null && (decl2.context instanceof ModuleExp) && !decl2.getFlag(4096L)) {
                    Expression value2 = decl2.getValue();
                    if (value2 instanceof ClassExp) {
                        Expression[] args = exp.getArgs();
                        if (!((LambdaExp) value2).getNeedsClosureEnv()) {
                            exp.nextCall = decl2.firstCall;
                            decl2.firstCall = exp;
                            for (int i = 1; i < args.length; i++) {
                                args[i].visit(this, ignored);
                            }
                            skipArgs = true;
                            skipFunc = true;
                        }
                    }
                }
            }
        }
        if (!skipFunc) {
            exp.func = (Expression) exp.func.visit(this, ignored);
        }
        if (this.exitValue == null && !skipArgs) {
            exp.args = visitExps(exp.args, ignored);
        }
        if (this.backJumpPossible > oldBackJumpPossible) {
            exp.setFlag(8);
        }
        return exp;
    }

    public void visitDefaultArgs(LambdaExp exp, Void ignored) {
        if (exp.defaultArgs != null) {
            super.visitDefaultArgs(exp, (LambdaExp) ignored);
            for (Declaration param = exp.firstDecl(); param != null; param = param.nextDecl()) {
                if (!param.isSimple()) {
                    exp.setFlag(true, 512);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Expression visitClassExp(ClassExp exp, Void ignored) {
        Expression ret = (Expression) super.visitClassExp(exp, (ClassExp) ignored);
        if (!exp.explicitInit && !exp.instanceType.isInterface()) {
            Compilation.getConstructor(exp.instanceType, exp);
        } else if (exp.getNeedsClosureEnv()) {
            for (LambdaExp child = exp.firstChild; child != null; child = child.nextSibling) {
                if ("*init*".equals(child.getName())) {
                    child.setNeedsStaticLink(true);
                }
            }
        }
        if (exp.isSimple() && exp.getNeedsClosureEnv() && exp.nameDecl != null && exp.nameDecl.getType() == Compilation.typeClass) {
            exp.nameDecl.setType(Compilation.typeClassType);
        }
        return ret;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Expression visitModuleExp(ModuleExp exp, Void ignored) {
        ModuleExp saveModule = this.currentModule;
        Hashtable saveDecls = this.unknownDecls;
        this.currentModule = exp;
        this.unknownDecls = null;
        try {
            return visitLambdaExp((LambdaExp) exp, ignored);
        } finally {
            this.currentModule = saveModule;
            this.unknownDecls = saveDecls;
        }
    }

    void maybeWarnNoDeclarationSeen(Object name, Compilation comp, SourceLocator location) {
        if (comp.warnUndefinedVariable()) {
            comp.error('w', "no declaration seen for " + name, location);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Expression visitFluidLetExp(FluidLetExp exp, Void ignored) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            if (decl.base == null) {
                Object name = decl.getSymbol();
                Declaration bind = allocUnboundDecl(name, false);
                maybeWarnNoDeclarationSeen(name, this.comp, exp);
                capture(bind);
                decl.base = bind;
            }
        }
        return (Expression) super.visitLetExp((LetExp) exp, (FluidLetExp) ignored);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Expression visitLetExp(LetExp exp, Void ignored) {
        if (exp.body instanceof BeginExp) {
            Expression[] inits = exp.inits;
            int len = inits.length;
            Expression[] exps = ((BeginExp) exp.body).exps;
            int init_index = 0;
            Declaration decl = exp.firstDecl();
            for (int begin_index = 0; begin_index < exps.length && init_index < len; begin_index++) {
                Expression st = exps[begin_index];
                if (st instanceof SetExp) {
                    SetExp set = (SetExp) st;
                    if (set.binding == decl && inits[init_index] == QuoteExp.nullExp && set.isDefining()) {
                        Expression new_value = set.new_value;
                        if (((new_value instanceof QuoteExp) || (new_value instanceof LambdaExp)) && decl.getValue() == new_value) {
                            inits[init_index] = new_value;
                            exps[begin_index] = QuoteExp.voidExp;
                        }
                        init_index++;
                        decl = decl.nextDecl();
                    }
                }
            }
        }
        return (Expression) super.visitLetExp(exp, (LetExp) ignored);
    }

    static Expression checkInlineable(LambdaExp current, Set<LambdaExp> seen) {
        if (current.returnContinuation == LambdaExp.unknownContinuation) {
            return current.returnContinuation;
        }
        if (seen.contains(current)) {
            return current.returnContinuation;
        }
        if (current.getCanRead() || current.isClassMethod() || current.min_args != current.max_args) {
            current.returnContinuation = LambdaExp.unknownContinuation;
            return LambdaExp.unknownContinuation;
        }
        seen.add(current);
        Expression r = current.returnContinuation;
        if (current.tailCallers != null) {
            for (LambdaExp p : current.tailCallers) {
                Expression t = checkInlineable(p, seen);
                if (t == LambdaExp.unknownContinuation) {
                    if (r == null || r == p.body) {
                        r = p.body;
                        current.inlineHome = p;
                    } else {
                        current.returnContinuation = LambdaExp.unknownContinuation;
                        return t;
                    }
                } else if (r == null) {
                    r = t;
                    if (current.inlineHome == null) {
                        if (!current.nestedIn(p)) {
                            p = p.inlineHome;
                        }
                        current.inlineHome = p;
                    }
                } else if (!(t == null || r == t) || current.getFlag(32)) {
                    current.returnContinuation = LambdaExp.unknownContinuation;
                    return LambdaExp.unknownContinuation;
                }
            }
        }
        return r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Expression visitLambdaExp(LambdaExp exp, Void ignored) {
        if (checkInlineable(exp, new LinkedHashSet<>()) != LambdaExp.unknownContinuation && (!(exp.outer instanceof ModuleExp) || exp.nameDecl == null)) {
            exp.setInlineOnly(true);
            this.backJumpPossible++;
        }
        return (Expression) super.visitLambdaExp(exp, (LambdaExp) ignored);
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x015d, code lost:
        java.lang.System.err.println("null declLambda for " + r24 + " curL:" + r6);
        r4 = r24.context;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0189, code lost:
        if (r4 == null) goto L_0x0233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x018b, code lost:
        java.lang.System.err.println("- context:" + r4);
        r4 = r4.outer;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void capture(gnu.expr.Declaration r24) {
        /*
            Method dump skipped, instructions count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.expr.FindCapturedVars.capture(gnu.expr.Declaration):void");
    }

    Declaration allocUnboundDecl(Object name, boolean function) {
        Declaration decl;
        Object key = name;
        if (function && (name instanceof Symbol)) {
            if (!getCompilation().getLanguage().hasSeparateFunctionNamespace()) {
                function = false;
            } else {
                key = new KeyPair((Symbol) name, EnvironmentKey.FUNCTION);
            }
        }
        if (this.unknownDecls == null) {
            this.unknownDecls = new Hashtable(100);
            decl = null;
        } else {
            decl = (Declaration) this.unknownDecls.get(key);
        }
        if (decl == null) {
            decl = this.currentModule.addDeclaration(name);
            decl.setSimple(false);
            decl.setPrivate(true);
            if (function) {
                decl.setProcedureDecl(true);
            }
            if (this.currentModule.isStatic()) {
                decl.setFlag(2048L);
            }
            decl.setCanRead(true);
            decl.setCanWrite(true);
            decl.setFlag(327680L);
            decl.setIndirectBinding(true);
            this.unknownDecls.put(key, decl);
        }
        return decl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Expression visitReferenceExp(ReferenceExp exp, Void ignored) {
        Declaration decl = exp.getBinding();
        if (decl == null) {
            decl = allocUnboundDecl(exp.getSymbol(), exp.isProcedureName());
            exp.setBinding(decl);
        }
        if (decl.getFlag(65536L) && this.comp.resolve(exp.getSymbol(), exp.isProcedureName()) == null) {
            maybeWarnNoDeclarationSeen(exp.getSymbol(), this.comp, exp);
        }
        capture(exp.contextDecl(), decl);
        return exp;
    }

    void capture(Declaration containing, Declaration decl) {
        ReferenceExp rexp;
        Declaration orig;
        if (!decl.isAlias() || !(decl.value instanceof ReferenceExp) || (orig = (rexp = (ReferenceExp) decl.value).binding) == null || (containing != null && orig.needsContext())) {
            while (decl.isFluid() && (decl.context instanceof FluidLetExp)) {
                decl = decl.base;
            }
            if (containing == null || !decl.needsContext()) {
                capture(decl);
            } else {
                capture(containing);
            }
        } else {
            capture(rexp.contextDecl(), orig);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Expression visitThisExp(ThisExp exp, Void ignored) {
        if (!exp.isForContext()) {
            return visitReferenceExp((ReferenceExp) exp, ignored);
        }
        getCurrentLambda().setImportsLexVars();
        return exp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Expression visitSetExp(SetExp exp, Void ignored) {
        Declaration decl = exp.binding;
        if (decl == null) {
            decl = allocUnboundDecl(exp.getSymbol(), exp.isFuncDef());
            exp.binding = decl;
        }
        if (!decl.ignorable()) {
            if (!exp.isDefining()) {
                decl = Declaration.followAliases(decl);
            }
            capture(exp.contextDecl(), decl);
        }
        return (Expression) super.visitSetExp(exp, (SetExp) ignored);
    }
}
