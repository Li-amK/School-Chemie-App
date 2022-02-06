package kawa.lib;

import androidx.fragment.app.FragmentTransaction;
import com.google.appinventor.components.common.PropertyTypeConstants;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Consumer;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.standard.Scheme;
import kawa.standard.append;

/* compiled from: srfi95.scm */
/* loaded from: classes.dex */
public class srfi95 extends ModuleBody {
    public static final ModuleMethod $Pcsort$Mnlist;
    public static final ModuleMethod $Pcsort$Mnvector;
    public static final ModuleMethod $Pcvector$Mnsort$Ex;
    static final ModuleMethod identity;
    public static final ModuleMethod merge;
    public static final ModuleMethod merge$Ex;
    public static final ModuleMethod sort;
    public static final ModuleMethod sort$Ex;
    public static final ModuleMethod sorted$Qu;
    static final SimpleSymbol Lit12 = (SimpleSymbol) new SimpleSymbol("sort").readResolve();
    static final SimpleSymbol Lit11 = (SimpleSymbol) new SimpleSymbol("%sort-vector").readResolve();
    static final SimpleSymbol Lit10 = (SimpleSymbol) new SimpleSymbol("%vector-sort!").readResolve();
    static final SimpleSymbol Lit9 = (SimpleSymbol) new SimpleSymbol("sort!").readResolve();
    static final SimpleSymbol Lit8 = (SimpleSymbol) new SimpleSymbol("%sort-list").readResolve();
    static final SimpleSymbol Lit7 = (SimpleSymbol) new SimpleSymbol("merge!").readResolve();
    static final SimpleSymbol Lit6 = (SimpleSymbol) new SimpleSymbol("merge").readResolve();
    static final SimpleSymbol Lit5 = (SimpleSymbol) new SimpleSymbol("sorted?").readResolve();
    static final SimpleSymbol Lit4 = (SimpleSymbol) new SimpleSymbol("identity").readResolve();
    static final IntNum Lit3 = IntNum.make(0);
    static final IntNum Lit2 = IntNum.make(1);
    static final IntNum Lit1 = IntNum.make(2);
    static final IntNum Lit0 = IntNum.make(-1);
    public static final srfi95 $instance = new srfi95();

    public static void $PcSortVector(Sequence sequence, Object obj) {
        $PcSortVector(sequence, obj, Boolean.FALSE);
    }

    static {
        srfi95 srfi95Var = $instance;
        identity = new ModuleMethod(srfi95Var, 1, Lit4, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        sorted$Qu = new ModuleMethod(srfi95Var, 2, Lit5, 12290);
        merge = new ModuleMethod(srfi95Var, 4, Lit6, 16387);
        merge$Ex = new ModuleMethod(srfi95Var, 6, Lit7, 16387);
        $Pcsort$Mnlist = new ModuleMethod(srfi95Var, 8, Lit8, 12291);
        sort$Ex = new ModuleMethod(srfi95Var, 9, Lit9, 12290);
        $Pcvector$Mnsort$Ex = new ModuleMethod(srfi95Var, 11, Lit10, 12291);
        $Pcsort$Mnvector = new ModuleMethod(srfi95Var, 12, Lit11, 12290);
        sort = new ModuleMethod(srfi95Var, 14, Lit12, 12290);
        $instance.run();
    }

    public srfi95() {
        ModuleInfo.register(this);
    }

    public static Object isSorted(Object obj, Object obj2) {
        return isSorted(obj, obj2, identity);
    }

    public static Object merge(Object obj, Object obj2, Object obj3) {
        return merge(obj, obj2, obj3, identity);
    }

    public static Object merge$Ex(Object obj, Object obj2, Object obj3) {
        return sort$ClMerge$Ex(obj, obj2, obj3, identity);
    }

    public static Object sort(Sequence sequence, Object obj) {
        return sort(sequence, obj, Boolean.FALSE);
    }

    public static Object sort$Ex(Sequence sequence, Object obj) {
        return sort$Ex(sequence, obj, Boolean.FALSE);
    }

    @Override // gnu.expr.ModuleBody
    public final void run(CallContext $ctx) {
        Consumer consumer = $ctx.consumer;
    }

    static Object identity(Object x) {
        return x;
    }

    @Override // gnu.expr.ModuleBody
    public Object apply1(ModuleMethod moduleMethod, Object obj) {
        return moduleMethod.selector == 1 ? identity(obj) : super.apply1(moduleMethod, obj);
    }

    @Override // gnu.expr.ModuleBody
    public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
        if (moduleMethod.selector != 1) {
            return super.match1(moduleMethod, obj, callContext);
        }
        callContext.value1 = obj;
        callContext.proc = moduleMethod;
        callContext.pc = 1;
        return 0;
    }

    /* JADX INFO: Multiple debug info for r7v3 java.lang.Object: [D('x' boolean), D('x' java.lang.Object)] */
    public static Object isSorted(Object seq, Object less$Qu, Object key) {
        if (lists.isNull(seq)) {
            return Boolean.TRUE;
        }
        if (seq instanceof Sequence) {
            try {
                Sequence arr = (Sequence) seq;
                int dimax = arr.size() - 1;
                boolean x = dimax <= 1;
                if (x) {
                    return x ? Boolean.TRUE : Boolean.FALSE;
                }
                Object valueOf = Integer.valueOf(dimax - 1);
                Object apply2 = Scheme.applyToArgs.apply2(key, arr.get(dimax));
                while (true) {
                    try {
                        boolean x2 = numbers.isNegative(LangObjType.coerceRealNum(valueOf));
                        if (x2) {
                            return x2 ? Boolean.TRUE : Boolean.FALSE;
                        }
                        try {
                            Object nxt = Scheme.applyToArgs.apply2(key, arr.get(((Number) valueOf).intValue()));
                            Object x3 = Scheme.applyToArgs.apply3(less$Qu, nxt, apply2);
                            if (x3 == Boolean.FALSE) {
                                return x3;
                            }
                            valueOf = AddOp.$Pl.apply2(Lit0, valueOf);
                            apply2 = nxt;
                        } catch (ClassCastException e) {
                            throw new WrongType(e, "gnu.lists.Sequence.get(int)", 2, valueOf);
                        }
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "negative?", 1, valueOf);
                    }
                }
            } catch (ClassCastException e3) {
                throw new WrongType(e3, "arr", -2, seq);
            }
        } else if (lists.isNull(lists.cdr.apply1(seq))) {
            return Boolean.TRUE;
        } else {
            Object last = Scheme.applyToArgs.apply2(key, lists.car.apply1(seq));
            Object apply1 = lists.cdr.apply1(seq);
            while (true) {
                boolean x4 = lists.isNull(apply1);
                if (x4) {
                    return x4 ? Boolean.TRUE : Boolean.FALSE;
                }
                Object nxt2 = Scheme.applyToArgs.apply2(key, lists.car.apply1(apply1));
                Object apply3 = Scheme.applyToArgs.apply3(less$Qu, nxt2, last);
                try {
                    int i = ((apply3 != Boolean.FALSE ? 1 : 0) + 1) & 1;
                    if (i == 0) {
                        return i != 0 ? Boolean.TRUE : Boolean.FALSE;
                    }
                    apply1 = lists.cdr.apply1(apply1);
                    last = nxt2;
                } catch (ClassCastException e4) {
                    throw new WrongType(e4, "x", -2, apply3);
                }
            }
        }
    }

    @Override // gnu.expr.ModuleBody
    public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 2:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 9:
                if (!(obj instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 12:
                if (!(obj instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            case 14:
                if (!(obj instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            default:
                return super.match2(moduleMethod, obj, obj2, callContext);
        }
    }

    @Override // gnu.expr.ModuleBody
    public int match3(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 2:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 3:
            case 5:
            case 7:
            case 10:
            case 13:
            default:
                return super.match3(moduleMethod, obj, obj2, obj3, callContext);
            case 4:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 6:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 8:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 9:
                if (!(obj instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 11:
                if (!(obj instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 12:
                if (!(obj instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            case 14:
                if (!(obj instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
        }
    }

    public static Object merge(Object a, Object b, Object isLess, Object key) {
        frame frameVar = new frame();
        frameVar.less$Qu = isLess;
        frameVar.key = key;
        if (lists.isNull(a)) {
            return b;
        }
        return lists.isNull(b) ? a : frameVar.lambda1loop(lists.car.apply1(a), Scheme.applyToArgs.apply2(frameVar.key, lists.car.apply1(a)), lists.cdr.apply1(a), lists.car.apply1(b), Scheme.applyToArgs.apply2(frameVar.key, lists.car.apply1(b)), lists.cdr.apply1(b));
    }

    @Override // gnu.expr.ModuleBody
    public int match4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 4:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            case 5:
            default:
                return super.match4(moduleMethod, obj, obj2, obj3, obj4, callContext);
            case 6:
                callContext.value1 = obj;
                callContext.value2 = obj2;
                callContext.value3 = obj3;
                callContext.value4 = obj4;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
        }
    }

    /* compiled from: srfi95.scm */
    /* loaded from: classes.dex */
    public class frame extends ModuleBody {
        Object key;
        Object less$Qu;

        public Object lambda1loop(Object x, Object kx, Object a, Object y, Object ky, Object b) {
            if (Scheme.applyToArgs.apply3(this.less$Qu, ky, kx) != Boolean.FALSE) {
                if (lists.isNull(b)) {
                    return lists.cons(y, lists.cons(x, a));
                }
                return lists.cons(y, lambda1loop(x, kx, a, lists.car.apply1(b), Scheme.applyToArgs.apply2(this.key, lists.car.apply1(b)), lists.cdr.apply1(b)));
            } else if (lists.isNull(a)) {
                return lists.cons(x, lists.cons(y, b));
            } else {
                return lists.cons(x, lambda1loop(lists.car.apply1(a), Scheme.applyToArgs.apply2(this.key, lists.car.apply1(a)), lists.cdr.apply1(a), y, ky, b));
            }
        }
    }

    /* compiled from: srfi95.scm */
    /* loaded from: classes.dex */
    public class frame1 extends ModuleBody {
        Object key;
        Object less$Qu;

        public Object lambda3loop(Object r, Object a, Object kcara, Object b, Object kcarb) {
            if (Scheme.applyToArgs.apply3(this.less$Qu, kcarb, kcara) != Boolean.FALSE) {
                try {
                    ((Pair) r).setCdr(b);
                    if (!lists.isNull(lists.cdr.apply1(b))) {
                        return lambda3loop(b, a, kcara, lists.cdr.apply1(b), Scheme.applyToArgs.apply2(this.key, lists.cadr.apply1(b)));
                    }
                    try {
                        ((Pair) b).setCdr(a);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "set-cdr!", 1, b);
                    }
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "set-cdr!", 1, r);
                }
            } else {
                try {
                    ((Pair) r).setCdr(a);
                    if (!lists.isNull(lists.cdr.apply1(a))) {
                        return lambda3loop(a, lists.cdr.apply1(a), Scheme.applyToArgs.apply2(this.key, lists.cadr.apply1(a)), b, kcarb);
                    }
                    try {
                        ((Pair) a).setCdr(b);
                        return Values.empty;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "set-cdr!", 1, a);
                    }
                } catch (ClassCastException e4) {
                    throw new WrongType(e4, "set-cdr!", 1, r);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object sort$ClMerge$Ex(Object a, Object b, Object isLess, Object key) {
        frame1 frame1Var = new frame1();
        frame1Var.less$Qu = isLess;
        frame1Var.key = key;
        if (lists.isNull(a)) {
            return b;
        }
        if (lists.isNull(b)) {
            return a;
        }
        Object kcara = Scheme.applyToArgs.apply2(frame1Var.key, lists.car.apply1(a));
        Object kcarb = Scheme.applyToArgs.apply2(frame1Var.key, lists.car.apply1(b));
        if (Scheme.applyToArgs.apply3(frame1Var.less$Qu, kcarb, kcara) == Boolean.FALSE) {
            if (lists.isNull(lists.cdr.apply1(a))) {
                try {
                    ((Pair) a).setCdr(b);
                } catch (ClassCastException e) {
                    throw new WrongType(e, "set-cdr!", 1, a);
                }
            } else {
                frame1Var.lambda3loop(a, lists.cdr.apply1(a), Scheme.applyToArgs.apply2(frame1Var.key, lists.cadr.apply1(a)), b, kcarb);
            }
            return a;
        } else if (lists.isNull(lists.cdr.apply1(b))) {
            try {
                ((Pair) b).setCdr(a);
                return b;
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "set-cdr!", 1, b);
            }
        } else {
            frame1Var.lambda3loop(b, a, kcara, lists.cdr.apply1(b), Scheme.applyToArgs.apply2(frame1Var.key, lists.cadr.apply1(b)));
            return b;
        }
    }

    @Override // gnu.expr.ModuleBody
    public Object apply4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4) {
        switch (moduleMethod.selector) {
            case 4:
                return merge(obj, obj2, obj3, obj4);
            case 5:
            default:
                return super.apply4(moduleMethod, obj, obj2, obj3, obj4);
            case 6:
                return sort$ClMerge$Ex(obj, obj2, obj3, obj4);
        }
    }

    public static Object $PcSortList(Object seq, Object isLess, Object key) {
        frame0 frame0Var = new frame0();
        frame0Var.seq = seq;
        frame0Var.less$Qu = isLess;
        frame0Var.keyer = Special.undefined;
        frame0Var.keyer = key != Boolean.FALSE ? lists.car : identity;
        if (key != Boolean.FALSE) {
            for (Object lst = frame0Var.seq; !lists.isNull(lst); lst = lists.cdr.apply1(lst)) {
                try {
                    ((Pair) lst).setCar(lists.cons(Scheme.applyToArgs.apply2(key, lists.car.apply1(lst)), lists.car.apply1(lst)));
                } catch (ClassCastException e) {
                    throw new WrongType(e, "set-car!", 1, lst);
                }
            }
            Object obj = frame0Var.seq;
            try {
                frame0Var.seq = frame0Var.lambda2step(Integer.valueOf(lists.length((LList) obj)));
                for (Object lst2 = frame0Var.seq; !lists.isNull(lst2); lst2 = lists.cdr.apply1(lst2)) {
                    try {
                        ((Pair) lst2).setCar(lists.cdar.apply1(lst2));
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "set-car!", 1, lst2);
                    }
                }
                return frame0Var.seq;
            } catch (ClassCastException e3) {
                throw new WrongType(e3, PropertyTypeConstants.PROPERTY_TYPE_LENGTH, 1, obj);
            }
        } else {
            Object obj2 = frame0Var.seq;
            try {
                return frame0Var.lambda2step(Integer.valueOf(lists.length((LList) obj2)));
            } catch (ClassCastException e4) {
                throw new WrongType(e4, PropertyTypeConstants.PROPERTY_TYPE_LENGTH, 1, obj2);
            }
        }
    }

    /* compiled from: srfi95.scm */
    /* loaded from: classes.dex */
    public class frame0 extends ModuleBody {
        Object keyer;
        Object less$Qu;
        Object seq;

        public Object lambda2step(Object n) {
            if (Scheme.numGrt.apply2(n, srfi95.Lit1) != Boolean.FALSE) {
                Object j = DivideOp.quotient.apply2(n, srfi95.Lit1);
                return srfi95.sort$ClMerge$Ex(lambda2step(j), lambda2step(AddOp.$Mn.apply2(n, j)), this.less$Qu, this.keyer);
            } else if (Scheme.numEqu.apply2(n, srfi95.Lit1) != Boolean.FALSE) {
                Object x = lists.car.apply1(this.seq);
                Object y = lists.cadr.apply1(this.seq);
                Object p = this.seq;
                this.seq = lists.cddr.apply1(this.seq);
                if (Scheme.applyToArgs.apply3(this.less$Qu, Scheme.applyToArgs.apply2(this.keyer, y), Scheme.applyToArgs.apply2(this.keyer, x)) != Boolean.FALSE) {
                    try {
                        ((Pair) p).setCar(y);
                        Object apply1 = lists.cdr.apply1(p);
                        try {
                            ((Pair) apply1).setCar(x);
                        } catch (ClassCastException e) {
                            throw new WrongType(e, "set-car!", 1, apply1);
                        }
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "set-car!", 1, p);
                    }
                }
                Object apply12 = lists.cdr.apply1(p);
                try {
                    ((Pair) apply12).setCdr(LList.Empty);
                    return p;
                } catch (ClassCastException e3) {
                    throw new WrongType(e3, "set-cdr!", 1, apply12);
                }
            } else if (Scheme.numEqu.apply2(n, srfi95.Lit2) == Boolean.FALSE) {
                return LList.Empty;
            } else {
                Object p2 = this.seq;
                this.seq = lists.cdr.apply1(this.seq);
                try {
                    ((Pair) p2).setCdr(LList.Empty);
                    return p2;
                } catch (ClassCastException e4) {
                    throw new WrongType(e4, "set-cdr!", 1, p2);
                }
            }
        }
    }

    static Object rank$Mn1Array$To$List(Sequence seq) {
        Object obj = LList.Empty;
        for (int idx = seq.size() - 1; idx >= 0; idx--) {
            obj = lists.cons(seq.get(idx), obj);
        }
        return obj;
    }

    public static Object sort$Ex(Sequence seq, Object less$Qu, Object key) {
        if (!lists.isList(seq)) {
            return $PcVectorSort$Ex(seq, less$Qu, key);
        }
        Object ret = $PcSortList(seq, less$Qu, key);
        if (ret == seq) {
            return seq;
        }
        Object crt = ret;
        while (lists.cdr.apply1(crt) != seq) {
            crt = lists.cdr.apply1(crt);
        }
        try {
            ((Pair) crt).setCdr(ret);
            Object scar = lists.car.apply1(seq);
            Object scdr = lists.cdr.apply1(seq);
            try {
                ((Pair) seq).setCar(lists.car.apply1(ret));
                try {
                    ((Pair) seq).setCdr(lists.cdr.apply1(ret));
                    try {
                        ((Pair) ret).setCar(scar);
                        try {
                            ((Pair) ret).setCdr(scdr);
                            return seq;
                        } catch (ClassCastException e) {
                            throw new WrongType(e, "set-cdr!", 1, ret);
                        }
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "set-car!", 1, ret);
                    }
                } catch (ClassCastException e3) {
                    throw new WrongType(e3, "set-cdr!", 1, seq);
                }
            } catch (ClassCastException e4) {
                throw new WrongType(e4, "set-car!", 1, seq);
            }
        } catch (ClassCastException e5) {
            throw new WrongType(e5, "set-cdr!", 1, crt);
        }
    }

    public static Object $PcVectorSort$Ex(Sequence seq, Object less$Qu, Object key) {
        Object sorted = $PcSortList(rank$Mn1Array$To$List(seq), less$Qu, key);
        IntNum intNum = Lit3;
        while (!lists.isNull(sorted)) {
            seq.set(intNum.intValue(), lists.car.apply1(sorted));
            sorted = lists.cdr.apply1(sorted);
            intNum = AddOp.$Pl.apply2(intNum, Lit2);
        }
        return seq;
    }

    public static void $PcSortVector(Sequence seq, Object less$Qu, Object key) {
        FVector newra = vectors.makeVector(seq.size());
        Object sorted = $PcSortList(rank$Mn1Array$To$List(seq), less$Qu, key);
        IntNum intNum = Lit3;
        while (!lists.isNull(sorted)) {
            try {
                newra.set(intNum.intValue(), lists.car.apply1(sorted));
                sorted = lists.cdr.apply1(sorted);
                intNum = AddOp.$Pl.apply2(intNum, Lit2);
            } catch (ClassCastException e) {
                throw new WrongType(e, "vector-set!", 1, intNum);
            }
        }
    }

    public static Object sort(Sequence seq, Object less$Qu, Object key) {
        if (lists.isList(seq)) {
            return $PcSortList(append.append$V(new Object[]{seq, LList.Empty}), less$Qu, key);
        }
        $PcSortVector(seq, less$Qu, key);
        return Values.empty;
    }

    @Override // gnu.expr.ModuleBody
    public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
        switch (moduleMethod.selector) {
            case 2:
                return isSorted(obj, obj2);
            case 9:
                try {
                    return sort$Ex((Sequence) obj, obj2);
                } catch (ClassCastException e) {
                    throw new WrongType(e, "sort!", 1, obj);
                }
            case 12:
                try {
                    $PcSortVector((Sequence) obj, obj2);
                    return Values.empty;
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "%sort-vector", 1, obj);
                }
            case 14:
                try {
                    return sort((Sequence) obj, obj2);
                } catch (ClassCastException e3) {
                    throw new WrongType(e3, "sort", 1, obj);
                }
            default:
                return super.apply2(moduleMethod, obj, obj2);
        }
    }

    @Override // gnu.expr.ModuleBody
    public Object apply3(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3) {
        switch (moduleMethod.selector) {
            case 2:
                return isSorted(obj, obj2, obj3);
            case 3:
            case 5:
            case 7:
            case 10:
            case 13:
            default:
                return super.apply3(moduleMethod, obj, obj2, obj3);
            case 4:
                return merge(obj, obj2, obj3);
            case 6:
                return merge$Ex(obj, obj2, obj3);
            case 8:
                return $PcSortList(obj, obj2, obj3);
            case 9:
                try {
                    return sort$Ex((Sequence) obj, obj2, obj3);
                } catch (ClassCastException e) {
                    throw new WrongType(e, "sort!", 1, obj);
                }
            case 11:
                try {
                    return $PcVectorSort$Ex((Sequence) obj, obj2, obj3);
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "%vector-sort!", 1, obj);
                }
            case 12:
                try {
                    $PcSortVector((Sequence) obj, obj2, obj3);
                    return Values.empty;
                } catch (ClassCastException e3) {
                    throw new WrongType(e3, "%sort-vector", 1, obj);
                }
            case 14:
                try {
                    return sort((Sequence) obj, obj2, obj3);
                } catch (ClassCastException e4) {
                    throw new WrongType(e4, "sort", 1, obj);
                }
        }
    }
}
