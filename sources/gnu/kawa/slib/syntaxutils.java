package gnu.kawa.slib;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.SetExp;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.reflect.SlotGet;
import gnu.lists.Consumer;
import gnu.lists.EofClass;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import gnu.text.SourceMessages;
import kawa.lang.Macro;
import kawa.lang.Quote;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.Translator;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;

/* compiled from: syntaxutils.scm */
/* loaded from: classes.dex */
public class syntaxutils extends ModuleBody {
    public static final Macro $Prvt$$Ex;
    public static final Macro $Prvt$typecase$Pc;
    static final SimpleSymbol Lit13;
    static final SyntaxRules Lit14;
    static final SimpleSymbol Lit15;
    static final SyntaxRules Lit16;
    static final SimpleSymbol Lit26 = (SimpleSymbol) new SimpleSymbol("lambda").readResolve();
    static final SimpleSymbol Lit25 = (SimpleSymbol) new SimpleSymbol("as").readResolve();
    static final SimpleSymbol Lit24 = (SimpleSymbol) new SimpleSymbol("else").readResolve();
    static final SimpleSymbol Lit23 = (SimpleSymbol) new SimpleSymbol("let").readResolve();
    static final SimpleSymbol Lit22 = (SimpleSymbol) new SimpleSymbol("cond").readResolve();
    static final SimpleSymbol Lit21 = (SimpleSymbol) new SimpleSymbol("begin").readResolve();
    static final SimpleSymbol Lit20 = (SimpleSymbol) new SimpleSymbol("or").readResolve();
    static final SimpleSymbol Lit19 = (SimpleSymbol) new SimpleSymbol(LispLanguage.quote_sym).readResolve();
    static final SimpleSymbol Lit18 = (SimpleSymbol) new SimpleSymbol("eql").readResolve();
    static final SimpleSymbol Lit17 = (SimpleSymbol) new SimpleSymbol("expand").readResolve();
    static final PairWithPosition Lit12 = PairWithPosition.make((SimpleSymbol) new SimpleSymbol(":").readResolve(), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/syntaxutils.scm", 634896);
    static final PairWithPosition Lit11 = PairWithPosition.make(Lit25, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/syntaxutils.scm", 626704);
    static final PairWithPosition Lit10 = PairWithPosition.make(Lit19, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/syntaxutils.scm", 552972);
    static final PairWithPosition Lit9 = PairWithPosition.make(Lit23, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/syntaxutils.scm", 479236);
    static final IntNum Lit8 = IntNum.make(1);
    static final IntNum Lit7 = IntNum.make(0);
    static final PairWithPosition Lit6 = PairWithPosition.make((SimpleSymbol) new SimpleSymbol("if").readResolve(), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/syntaxutils.scm", 417799);
    static final PairWithPosition Lit5 = PairWithPosition.make(Lit21, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/syntaxutils.scm", 409627);
    static final PairWithPosition Lit4 = PairWithPosition.make(Lit26, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/syntaxutils.scm", 376839);
    static final PairWithPosition Lit3 = PairWithPosition.make((SimpleSymbol) new SimpleSymbol("set").readResolve(), LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/syntaxutils.scm", 368647);
    static final Keyword Lit2 = Keyword.make("lang");
    static final PairWithPosition Lit1 = PairWithPosition.make(Lit21, LList.Empty, "/u2/home/jis/ai2-kawa/gnu/kawa/slib/syntaxutils.scm", 278557);
    static final Keyword Lit0 = Keyword.make("env");
    public static final syntaxutils $instance = new syntaxutils();
    public static final ModuleMethod expand = new ModuleMethod($instance, 1, Lit17, -4095);

    /* compiled from: syntaxutils.scm */
    /* loaded from: classes.dex */
    public class frame extends ModuleBody {
        LList pack;
    }

    /* compiled from: syntaxutils.scm */
    /* loaded from: classes.dex */
    public class frame0 extends ModuleBody {
        LList pack;
    }

    /* compiled from: syntaxutils.scm */
    /* loaded from: classes.dex */
    public class frame1 extends ModuleBody {
        LList pack;
    }

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol("!").readResolve();
        Lit15 = simpleSymbol;
        Lit16 = new SyntaxRules(new Object[]{simpleSymbol}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\r\u0017\u0010\b\b", new Object[0], 3), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b)\u0011\u0018\f\b\u0003\b\u0015\u0013", new Object[]{(SimpleSymbol) new SimpleSymbol("invoke").readResolve(), Lit19}, 1)}, 3);
        SimpleSymbol simpleSymbol2 = (SimpleSymbol) new SimpleSymbol("typecase%").readResolve();
        Lit13 = simpleSymbol2;
        Lit14 = new SyntaxRules(new Object[]{simpleSymbol2, Lit18, Lit20}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u0002\r\u000f\b\b\b\r\u0017\u0010\b\b", new Object[]{Boolean.TRUE}, 3), "\u0001\u0003\u0003", "\u0011\u0018\u0004\b\r\u000b", new Object[]{Lit21}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\\,\f\u0002\f\u000f\b\r\u0017\u0010\b\b\r\u001f\u0018\b\b", new Object[]{Lit18}, 4), "\u0001\u0001\u0003\u0003", "\u0011\u0018\u0004yY\u0011\u0018\f\t\u0003\b\u0011\u0018\u0014\b\u000b\b\u0015\u0013\b\u0011\u0018\u001c\b\u0011\u0018$\t\u0003\b\u001d\u001b", new Object[]{Lit22, (SimpleSymbol) new SimpleSymbol("eqv?").readResolve(), Lit19, Lit24, Lit13}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\\,\f\u0002\f\u000f\b\r\u0017\u0010\b\b\r\u001f\u0018\b\b", new Object[]{Lit20}, 4), "\u0001\u0001\u0003\u0003", "\u0011\u0018\u0004\t\u0003)\t\u000b\b\u0015\u0013\b\u001d\u001b", new Object[]{Lit13}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007l<\f\u0002\r\u000f\b\b\b\r\u0017\u0010\b\b\r\u001f\u0018\b\b", new Object[]{Lit20}, 4), "\u0001\u0003\u0003\u0003", "\u0011\u0018\u0004\u0091\b\u0011\u0018\f\b\u0011\u0018\u0014\u0011\b\u0003\b\u0011\u0018\u001c\b\u0015\u0013\b\u0011\u0018$\t\u0003I\r\t\u000b\b\u0011\u0018\f\b\u0003\b\u0011\u0018,\b\u0011\u0018$\t\u0003\b\u001d\u001b", new Object[]{Lit23, (SimpleSymbol) new SimpleSymbol("f").readResolve(), Lit26, Lit21, Lit13, Boolean.TRUE}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\r\u0017\u0010\b\b\r\u001f\u0018\b\b", new Object[0], 4), "\u0001\u0001\u0003\u0003", "\u0011\u0018\u0004ñ9\u0011\u0018\f\t\u0003\b\u000b\b\u0011\u0018\u0014Q\b\t\u0003\u0011\u0018\u001c\t\u000b\b\u0003\b\u0011\u0018$\b\u0015\u0013\b\u0011\u0018,\b\u0011\u00184\t\u0003\b\u001d\u001b", new Object[]{Lit22, (SimpleSymbol) new SimpleSymbol(GetNamedPart.INSTANCEOF_METHOD_NAME).readResolve(), Lit23, (SimpleSymbol) new SimpleSymbol("::").readResolve(), Lit21, Lit24, Lit13}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", new Object[0], 1), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\t\u0003\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\u0011\u0018,\b\u0003", new Object[]{(SimpleSymbol) new SimpleSymbol("error").readResolve(), "typecase% failed", Lit15, (SimpleSymbol) new SimpleSymbol("getClass").readResolve(), Lit25, (SimpleSymbol) new SimpleSymbol("<object>").readResolve()}, 0)}, 4);
        $Prvt$typecase$Pc = Macro.make(Lit13, Lit14, $instance);
        $Prvt$$Ex = Macro.make(Lit15, Lit16, $instance);
        $instance.run();
    }

    public syntaxutils() {
        ModuleInfo.register(this);
    }

    @Override // gnu.expr.ModuleBody
    public final void run(CallContext $ctx) {
        Consumer consumer = $ctx.consumer;
    }

    public static Object expand$V(Object sexp, Object[] argsArray) {
        Object consX;
        Object env = Keyword.searchForKeyword(argsArray, 0, Lit0);
        if (env == Special.dfault) {
            env = misc.interactionEnvironment();
        }
        consX = LList.consX(new Object[]{sexp, LList.Empty});
        return unrewrite(rewriteForm$V(Quote.append$V(new Object[]{Lit1, consX}), new Object[]{Lit0, env}));
    }

    @Override // gnu.expr.ModuleBody
    public Object applyN(ModuleMethod moduleMethod, Object[] objArr) {
        if (moduleMethod.selector != 1) {
            return super.applyN(moduleMethod, objArr);
        }
        Object obj = objArr[0];
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        while (true) {
            length--;
            if (length < 0) {
                return expand$V(obj, objArr2);
            }
            objArr2[length] = objArr[length + 1];
        }
    }

    @Override // gnu.expr.ModuleBody
    public int matchN(ModuleMethod moduleMethod, Object[] objArr, CallContext callContext) {
        if (moduleMethod.selector != 1) {
            return super.matchN(moduleMethod, objArr, callContext);
        }
        callContext.values = objArr;
        callContext.proc = moduleMethod;
        callContext.pc = 5;
        return 0;
    }

    static Expression rewriteForm$V(Object exp, Object[] argsArray) {
        Object lang = Keyword.searchForKeyword(argsArray, 0, Lit2);
        if (lang == Special.dfault) {
            lang = Language.getDefaultLanguage();
        }
        Object env = Keyword.searchForKeyword(argsArray, 0, Lit0);
        if (env == Special.dfault) {
            env = misc.interactionEnvironment();
        }
        try {
            try {
                try {
                    Translator translator = new Translator((Language) lang, new SourceMessages(), NameLookup.getInstance((Environment) env, (Language) lang));
                    translator.pushNewModule((String) null);
                    Compilation saved$Mncomp = Compilation.setSaveCurrent(translator);
                    try {
                        return translator.rewrite(exp);
                    } finally {
                        Compilation.restoreCurrent(saved$Mncomp);
                    }
                } catch (ClassCastException e) {
                    throw new WrongType(e, "kawa.lang.Translator.<init>(gnu.expr.Language,gnu.text.SourceMessages,gnu.expr.NameLookup)", 1, lang);
                }
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "gnu.expr.NameLookup.getInstance(gnu.mapping.Environment,gnu.expr.Language)", 2, lang);
            }
        } catch (ClassCastException e3) {
            throw new WrongType(e3, "gnu.expr.NameLookup.getInstance(gnu.mapping.Environment,gnu.expr.Language)", 1, env);
        }
    }

    /* JADX INFO: Multiple debug info for r11v0 gnu.expr.Expression: [D('exp' gnu.expr.LetExp), D('exp' gnu.expr.Expression)] */
    /* JADX INFO: Multiple debug info for r11v11 gnu.expr.LambdaExp: [D('exp' gnu.expr.LambdaExp), D('exp' gnu.expr.Expression)] */
    /* JADX INFO: Multiple debug info for r11v12 java.lang.Object: [D('exp' gnu.expr.LetExp), D('exp' gnu.expr.LambdaExp)] */
    /* JADX INFO: Multiple debug info for r11v14 gnu.expr.ReferenceExp: [D('exp' gnu.expr.ReferenceExp), D('exp' gnu.expr.Expression)] */
    /* JADX INFO: Multiple debug info for r11v15 java.lang.Object: [D('exp' gnu.expr.LetExp), D('exp' gnu.expr.ReferenceExp)] */
    /* JADX INFO: Multiple debug info for r11v17 gnu.expr.ApplyExp: [D('exp' gnu.expr.Expression), D('exp' gnu.expr.ApplyExp)] */
    /* JADX INFO: Multiple debug info for r11v18 java.lang.Object: [D('exp' gnu.expr.LetExp), D('exp' gnu.expr.ApplyExp)] */
    /* JADX INFO: Multiple debug info for r11v2 gnu.expr.LetExp: [D('exp' gnu.expr.LetExp), D('exp' gnu.expr.Expression)] */
    /* JADX INFO: Multiple debug info for r11v20 gnu.expr.BeginExp: [D('exp' gnu.expr.BeginExp), D('exp' gnu.expr.Expression)] */
    /* JADX INFO: Multiple debug info for r11v21 java.lang.Object: [D('exp' gnu.expr.LetExp), D('exp' gnu.expr.BeginExp)] */
    /* JADX INFO: Multiple debug info for r11v23 gnu.expr.IfExp: [D('exp' gnu.expr.Expression), D('exp' gnu.expr.IfExp)] */
    /* JADX INFO: Multiple debug info for r11v24 java.lang.Object: [D('exp' gnu.expr.LetExp), D('exp' gnu.expr.IfExp)] */
    /* JADX INFO: Multiple debug info for r11v5 gnu.expr.QuoteExp: [D('exp' gnu.expr.QuoteExp), D('exp' gnu.expr.Expression)] */
    /* JADX INFO: Multiple debug info for r11v6 java.lang.Object: [D('exp' gnu.expr.LetExp), D('exp' gnu.expr.QuoteExp)] */
    /* JADX INFO: Multiple debug info for r11v8 gnu.expr.SetExp: [D('exp' gnu.expr.SetExp), D('exp' gnu.expr.Expression)] */
    /* JADX INFO: Multiple debug info for r11v9 java.lang.Object: [D('exp' gnu.expr.LetExp), D('exp' gnu.expr.SetExp)] */
    static Object unrewrite(Expression exp) {
        Object consX;
        Object consX2;
        Object consX3;
        Object consX4;
        Object consX5;
        Object consX6;
        frame closureEnv = new frame();
        if (exp instanceof LetExp) {
            try {
                return unrewriteLet((LetExp) exp);
            } catch (ClassCastException e) {
                throw new WrongType(e, "exp", -2, exp);
            }
        } else if (exp instanceof QuoteExp) {
            try {
                return unrewriteQuote((QuoteExp) exp);
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "exp", -2, exp);
            }
        } else if (exp instanceof SetExp) {
            try {
                SetExp exp2 = (SetExp) exp;
                consX = LList.consX(new Object[]{unrewrite(exp2.getNewValue()), LList.Empty});
                consX2 = LList.consX(new Object[]{exp2.getSymbol(), consX});
                return Quote.append$V(new Object[]{Lit3, consX2});
            } catch (ClassCastException e3) {
                throw new WrongType(e3, "exp", -2, exp);
            }
        } else if (exp instanceof LambdaExp) {
            try {
                LambdaExp exp3 = (LambdaExp) exp;
                Object[] objArr = new Object[2];
                objArr[0] = Lit4;
                Object[] objArr2 = new Object[2];
                closureEnv.pack = LList.Empty;
                for (Declaration decl = exp3.firstDecl(); decl != null; decl = decl.nextDecl()) {
                    closureEnv.pack = lists.cons(decl.getSymbol(), closureEnv.pack);
                }
                objArr2[0] = LList.reverseInPlace(closureEnv.pack);
                consX3 = LList.consX(new Object[]{unrewrite(exp3.body), LList.Empty});
                objArr2[1] = consX3;
                consX4 = LList.consX(objArr2);
                objArr[1] = consX4;
                return Quote.append$V(objArr);
            } catch (ClassCastException e4) {
                throw new WrongType(e4, "exp", -2, exp);
            }
        } else if (exp instanceof ReferenceExp) {
            try {
                return ((ReferenceExp) exp).getSymbol();
            } catch (ClassCastException e5) {
                throw new WrongType(e5, "exp", -2, exp);
            }
        } else if (exp instanceof ApplyExp) {
            try {
                return unrewriteApply((ApplyExp) exp);
            } catch (ClassCastException e6) {
                throw new WrongType(e6, "exp", -2, exp);
            }
        } else if (exp instanceof BeginExp) {
            try {
                return Quote.append$V(new Object[]{Lit5, unrewrite$St(((BeginExp) exp).getExpressions())});
            } catch (ClassCastException e7) {
                throw new WrongType(e7, "exp", -2, exp);
            }
        } else if (!(exp instanceof IfExp)) {
            return exp;
        } else {
            try {
                IfExp exp4 = (IfExp) exp;
                Object[] objArr3 = new Object[2];
                objArr3[0] = Lit6;
                Object[] objArr4 = new Object[2];
                objArr4[0] = unrewrite(exp4.getTest());
                Object[] objArr5 = new Object[2];
                objArr5[0] = unrewrite(exp4.getThenClause());
                Object[] objArr6 = new Object[2];
                Expression eclause = exp4.getElseClause();
                objArr6[0] = eclause == null ? LList.Empty : LList.list1(unrewrite(eclause));
                objArr6[1] = LList.Empty;
                objArr5[1] = Quote.append$V(objArr6);
                consX5 = LList.consX(objArr5);
                objArr4[1] = consX5;
                consX6 = LList.consX(objArr4);
                objArr3[1] = consX6;
                return Quote.append$V(objArr3);
            } catch (ClassCastException e8) {
                throw new WrongType(e8, "exp", -2, exp);
            }
        }
    }

    static Object unrewrite$St(Expression[] exps) {
        frame0 closureEnv = new frame0();
        closureEnv.pack = LList.Empty;
        Integer len = Integer.valueOf(exps.length);
        for (IntNum intNum = Lit7; Scheme.numEqu.apply2(intNum, len) == Boolean.FALSE; intNum = AddOp.$Pl.apply2(intNum, Lit8)) {
            closureEnv.pack = lists.cons(unrewrite(exps[intNum.intValue()]), closureEnv.pack);
        }
        return LList.reverseInPlace(closureEnv.pack);
    }

    static Object unrewriteLet(LetExp exp) {
        Object consX;
        Object consX2;
        frame1 closureEnv = new frame1();
        Object[] objArr = new Object[2];
        objArr[0] = Lit9;
        Object[] objArr2 = new Object[2];
        closureEnv.pack = LList.Empty;
        Declaration decl = exp.firstDecl();
        IntNum intNum = Lit7;
        while (decl != null) {
            closureEnv.pack = lists.cons(LList.list2(decl.getSymbol(), unrewrite(exp.inits[intNum.intValue()])), closureEnv.pack);
            decl = decl.nextDecl();
            intNum = AddOp.$Pl.apply2(intNum, Lit8);
        }
        objArr2[0] = LList.reverseInPlace(closureEnv.pack);
        consX = LList.consX(new Object[]{unrewrite(exp.body), LList.Empty});
        objArr2[1] = consX;
        consX2 = LList.consX(objArr2);
        objArr[1] = consX2;
        return Quote.append$V(objArr);
    }

    /* JADX INFO: Multiple debug info for r1v14 gnu.bytecode.Type: [D('val' java.lang.Object), D('val' gnu.bytecode.Type)] */
    /* JADX INFO: Multiple debug info for r1v16 java.lang.Class: [D('val' java.lang.Object), D('val' java.lang.Class)] */
    static Object unrewriteQuote(QuoteExp exp) {
        String name;
        Object consX;
        Object val = exp.getValue();
        if (Numeric.asNumericOrNull(val) != null) {
            try {
                return LangObjType.coerceNumeric(val);
            } catch (ClassCastException e) {
                throw new WrongType(e, "val", -2, val);
            }
        } else if (val instanceof Boolean) {
            try {
                return (val != Boolean.FALSE ? 1 : null) != null ? Boolean.TRUE : Boolean.FALSE;
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "val", -2, val);
            }
        } else if (val instanceof Char) {
            try {
                return (Char) val;
            } catch (ClassCastException e3) {
                throw new WrongType(e3, "val", -2, val);
            }
        } else if (val instanceof Keyword) {
            try {
                return (Keyword) val;
            } catch (ClassCastException e4) {
                throw new WrongType(e4, "val", -2, val);
            }
        } else if (val instanceof CharSequence) {
            try {
                return (CharSequence) val;
            } catch (ClassCastException e5) {
                throw new WrongType(e5, "val", -2, val);
            }
        } else if (val == Special.undefined || val == EofClass.eofValue) {
            return val;
        } else {
            if (val instanceof Type) {
                try {
                    name = ((Type) val).getName();
                } catch (ClassCastException e6) {
                    throw new WrongType(e6, "val", -2, val);
                }
            } else if (val instanceof Class) {
                try {
                    name = ((Class) val).getName();
                } catch (ClassCastException e7) {
                    throw new WrongType(e7, "val", -2, val);
                }
            } else {
                consX = LList.consX(new Object[]{val, LList.Empty});
                return Quote.append$V(new Object[]{Lit10, consX});
            }
            return misc.string$To$Symbol(Format.formatToString(0, "<~a>", name));
        }
    }

    static Object unrewriteApply(ApplyExp exp) {
        Declaration fbinding;
        Object x;
        Object args;
        Expression fun = exp.getFunction();
        Object args2 = unrewrite$St(exp.getArgs());
        if (fun instanceof ReferenceExp) {
            try {
                fbinding = ((ReferenceExp) fun).getBinding();
            } catch (ClassCastException e) {
                throw new WrongType(e, "fun", -2, fun);
            }
        } else {
            fbinding = null;
        }
        Declaration apply$Mnto$Mnargs = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "applyToArgs");
        Object fval = exp.getFunctionValue();
        int i = ((fbinding == null ? 1 : 0) + 1) & 1;
        if (i != 0) {
            int i2 = ((apply$Mnto$Mnargs == null ? 1 : 0) + 1) & 1;
            if (i2 != 0) {
                if (SlotGet.getSlotValue(false, fbinding, "field", "field", "getField", "isField", Scheme.instance) == apply$Mnto$Mnargs.field) {
                    return args2;
                }
            } else if (i2 != 0) {
                return args2;
            }
        } else if (i != 0) {
            return args2;
        }
        if (fval instanceof Convert) {
            x = Quote.append$V(new Object[]{Lit11, args2});
        } else {
            x = fval instanceof GetNamedPart ? Quote.append$V(new Object[]{Lit12, args2}) : Boolean.FALSE;
        }
        if (x != Boolean.FALSE) {
            return x;
        }
        args = LList.consX(new Object[]{unrewrite(fun), args2});
        return args;
    }
}
