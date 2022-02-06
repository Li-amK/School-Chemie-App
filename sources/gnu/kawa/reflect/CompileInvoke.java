package gnu.kawa.reflect;

import com.google.appinventor.components.common.PropertyTypeConstants;
import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.LetExp;
import gnu.expr.PairClassType;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.TypeValue;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;

/* loaded from: classes.dex */
public class CompileInvoke {
    public static Expression validateApplyInvoke(ApplyExp exp, InlineCalls visitor, Type required, Procedure proc) {
        ObjectType type;
        int objIndex;
        int argsStartIndex;
        int margsLength;
        ClassType caller;
        int okCount;
        int maybeCount;
        ApplyExp ae;
        Type stype;
        Procedure constructor;
        Invoke iproc = (Invoke) proc;
        char kind = iproc.kind;
        Compilation comp = visitor.getCompilation();
        Expression[] args = exp.getArgs();
        int nargs = args.length;
        if (!comp.mustCompile || nargs == 0 || ((kind == 'V' || kind == '*') && nargs == 1)) {
            exp.visitArgs(visitor);
            return exp;
        }
        Expression arg0 = visitor.visit(args[0], (Type) null);
        args[0] = arg0;
        Type type0 = (kind == 'V' || kind == '*') ? arg0.getType() : iproc.language.getTypeFor(arg0);
        if ((type0 instanceof PairClassType) && kind == 'N') {
            type = ((PairClassType) type0).instanceType;
        } else if (type0 instanceof ObjectType) {
            type = (ObjectType) type0;
        } else {
            type = null;
        }
        String name = getMethodName(args, kind);
        if (kind == 'V' || kind == '*') {
            margsLength = nargs - 1;
            argsStartIndex = 2;
            objIndex = 0;
        } else if (kind == 'N') {
            margsLength = nargs;
            argsStartIndex = 0;
            objIndex = -1;
        } else if (kind == 'S' || kind == 's') {
            margsLength = nargs - 2;
            argsStartIndex = 2;
            objIndex = -1;
        } else if (kind == 'P') {
            margsLength = nargs - 2;
            argsStartIndex = 3;
            objIndex = 1;
        } else {
            exp.visitArgs(visitor);
            return exp;
        }
        if (kind != 'N' || !(type instanceof ArrayType)) {
            if (!(type == null || name == null)) {
                if (!(type instanceof TypeValue) || kind != 'N' || (constructor = ((TypeValue) type).getConstructor()) == null) {
                    if (comp == null) {
                        caller = null;
                    } else {
                        caller = comp.curClass != null ? comp.curClass : comp.mainClass;
                    }
                    try {
                        PrimProcedure[] methods = getMethods(type, name, caller, iproc);
                        int numCode = ClassMethods.selectApplicable(methods, margsLength);
                        int index = -1;
                        if (kind == 'N') {
                            int keywordStart = hasKeywordArgument(1, args);
                            if (keywordStart < args.length || (numCode <= 0 && (ClassMethods.selectApplicable(methods, new Type[]{Compilation.typeClassType}) >> 32) == 1)) {
                                Object[] slots = checkKeywords(type, args, keywordStart, caller);
                                if (slots.length * 2 == args.length - keywordStart || ClassMethods.selectApplicable(ClassMethods.getMethods(type, "add", 'V', null, iproc.language), 2) > 0) {
                                    StringBuffer errbuf = null;
                                    for (int i = 0; i < slots.length; i++) {
                                        if (slots[i] instanceof String) {
                                            if (errbuf == null) {
                                                errbuf = new StringBuffer();
                                                errbuf.append("no field or setter ");
                                            } else {
                                                errbuf.append(", ");
                                            }
                                            errbuf.append('`');
                                            errbuf.append(slots[i]);
                                            errbuf.append('\'');
                                        }
                                    }
                                    if (errbuf != null) {
                                        errbuf.append(" in class ");
                                        errbuf.append(type.getName());
                                        comp.error('w', errbuf.toString());
                                        return exp;
                                    }
                                    if (keywordStart < args.length) {
                                        Expression[] xargs = new Expression[keywordStart];
                                        System.arraycopy(args, 0, xargs, 0, keywordStart);
                                        ae = (ApplyExp) visitor.visit(new ApplyExp(exp.getFunction(), xargs), (Type) type);
                                    } else {
                                        ae = new ApplyExp(methods[0], arg0);
                                    }
                                    ae.setType(type);
                                    Expression e = ae;
                                    if (args.length > 0) {
                                        for (int i2 = 0; i2 < slots.length; i2++) {
                                            Object slot = slots[i2];
                                            if (slot instanceof Method) {
                                                stype = ((Method) slot).getParameterTypes()[0];
                                            } else if (slot instanceof Field) {
                                                stype = ((Field) slot).getType();
                                            } else {
                                                stype = null;
                                            }
                                            if (stype != null) {
                                                stype = iproc.language.getLangTypeFor(stype);
                                            }
                                            ae = new ApplyExp(SlotSet.setFieldReturnObject, ae, new QuoteExp(slot), visitor.visit(args[(i2 * 2) + keywordStart + 1], stype));
                                            ae.setType(type);
                                        }
                                        int sargs = keywordStart == args.length ? 1 : (slots.length * 2) + keywordStart;
                                        e = ae;
                                        if (sargs < args.length) {
                                            LetExp let = new LetExp(new Expression[]{e});
                                            Declaration adecl = let.addDeclaration((String) null, type);
                                            adecl.noteValue(e);
                                            BeginExp begin = new BeginExp();
                                            for (int i3 = sargs; i3 < args.length; i3++) {
                                                begin.add(visitor.visit(new ApplyExp(Invoke.invoke, new ReferenceExp(adecl), QuoteExp.getInstance("add"), args[i3]), (Type) null));
                                            }
                                            begin.add(new ReferenceExp(adecl));
                                            let.body = begin;
                                            e = let;
                                        }
                                    }
                                    return visitor.checkType(e.setLine(exp), required);
                                }
                            }
                        }
                        if (numCode >= 0) {
                            int i4 = 1;
                            while (i4 < nargs) {
                                Type atype = null;
                                boolean last = i4 == nargs + (-1);
                                if ((kind == 'P' && i4 == 2) || (kind != 'N' && i4 == 1)) {
                                    atype = null;
                                } else if (kind == 'P' && i4 == 1) {
                                    atype = type;
                                } else if (numCode > 0) {
                                    int pi = i4 - (kind == 'N' ? 1 : argsStartIndex);
                                    int j = 0;
                                    while (j < numCode) {
                                        PrimProcedure pproc = methods[j];
                                        int pii = pi + ((kind == 'S' || !pproc.takesTarget()) ? 0 : 1);
                                        if (!last || !pproc.takesVarArgs() || pii != pproc.minArgs()) {
                                            Type ptype = pproc.getParameterType(pii);
                                            if (j == 0) {
                                                atype = ptype;
                                            } else if ((ptype instanceof PrimType) != (atype instanceof PrimType)) {
                                                atype = null;
                                            } else {
                                                atype = Type.lowestCommonSuperType(atype, ptype);
                                            }
                                        } else {
                                            atype = null;
                                        }
                                        if (atype != null) {
                                            j++;
                                            atype = atype;
                                        }
                                    }
                                }
                                args[i4] = visitor.visit(args[i4], atype);
                                i4++;
                            }
                            long num = selectApplicable(methods, type, args, margsLength, argsStartIndex, objIndex);
                            okCount = (int) (num >> 32);
                            maybeCount = (int) num;
                        } else {
                            okCount = 0;
                            maybeCount = 0;
                        }
                        int nmethods = methods.length;
                        if (okCount + maybeCount == 0 && kind == 'N') {
                            methods = getMethods(type, "valueOf", caller, Invoke.invokeStatic);
                            argsStartIndex = 1;
                            margsLength = nargs - 1;
                            long num2 = selectApplicable(methods, type, args, margsLength, 1, -1);
                            okCount = (int) (num2 >> 32);
                            maybeCount = (int) num2;
                        }
                        if (okCount + maybeCount == 0) {
                            if (kind == 'P' || comp.warnInvokeUnknownMethod()) {
                                if (kind == 'N') {
                                    name = name + "/valueOf";
                                }
                                StringBuilder sbuf = new StringBuilder();
                                if (methods.length + nmethods == 0) {
                                    sbuf.append("no accessible method '");
                                } else if (numCode == -983040) {
                                    sbuf.append("too few arguments for method '");
                                } else if (numCode == -917504) {
                                    sbuf.append("too many arguments for method '");
                                } else {
                                    sbuf.append("no possibly applicable method '");
                                }
                                sbuf.append(name);
                                sbuf.append("' in ");
                                sbuf.append(type.getName());
                                comp.error(kind == 'P' ? 'e' : 'w', sbuf.toString());
                            }
                        } else if (okCount == 1 || (okCount == 0 && maybeCount == 1)) {
                            index = 0;
                        } else if (okCount > 0) {
                            index = MethodProc.mostSpecific(methods, okCount);
                            if (index < 0 && kind == 'S') {
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= okCount) {
                                        break;
                                    }
                                    if (methods[i5].getStaticFlag()) {
                                        if (index >= 0) {
                                            index = -1;
                                            break;
                                        }
                                        index = i5;
                                    }
                                    i5++;
                                }
                            }
                            if (index < 0 && (kind == 'P' || comp.warnInvokeUnknownMethod())) {
                                StringBuffer sbuf2 = new StringBuffer();
                                sbuf2.append("more than one definitely applicable method `");
                                sbuf2.append(name);
                                sbuf2.append("' in ");
                                sbuf2.append(type.getName());
                                append(methods, okCount, sbuf2);
                                comp.error(kind == 'P' ? 'e' : 'w', sbuf2.toString());
                            }
                        } else if (kind == 'P' || comp.warnInvokeUnknownMethod()) {
                            StringBuffer sbuf3 = new StringBuffer();
                            sbuf3.append("more than one possibly applicable method '");
                            sbuf3.append(name);
                            sbuf3.append("' in ");
                            sbuf3.append(type.getName());
                            append(methods, maybeCount, sbuf3);
                            comp.error(kind == 'P' ? 'e' : 'w', sbuf3.toString());
                        }
                        if (index >= 0) {
                            Expression[] margs = new Expression[margsLength];
                            PrimProcedure method = methods[index];
                            method.takesVarArgs();
                            int dst = 0;
                            if (objIndex >= 0) {
                                margs[0] = args[objIndex];
                                dst = 0 + 1;
                            }
                            int src = argsStartIndex;
                            while (src < args.length && dst < margs.length) {
                                margs[dst] = args[src];
                                src++;
                                dst++;
                            }
                            ApplyExp e2 = new ApplyExp(method, margs);
                            e2.setLine(exp);
                            return visitor.visitApplyOnly(e2, required);
                        }
                    } catch (Exception e3) {
                        comp.error('w', "unknown class: " + type.getName());
                        return exp;
                    }
                } else {
                    Expression[] xargs2 = new Expression[nargs - 1];
                    System.arraycopy(args, 1, xargs2, 0, nargs - 1);
                    return visitor.visit(new ApplyExp(constructor, xargs2), required);
                }
            }
            exp.visitArgs(visitor);
            return exp;
        }
        ArrayType atype2 = (ArrayType) type;
        Type elementType = atype2.getComponentType();
        Expression sizeArg = null;
        boolean lengthSpecified = false;
        if (args.length >= 3 && (args[1] instanceof QuoteExp)) {
            Object arg1 = ((QuoteExp) args[1]).getValue();
            if (arg1 instanceof Keyword) {
                String name2 = ((Keyword) arg1).getName();
                if (PropertyTypeConstants.PROPERTY_TYPE_LENGTH.equals(name2) || "size".equals(name2)) {
                    sizeArg = args[2];
                    lengthSpecified = true;
                }
            }
        }
        if (sizeArg == null) {
            sizeArg = QuoteExp.getInstance(new Integer(args.length - 1));
        }
        ApplyExp alloc = new ApplyExp(new ArrayNew(elementType), visitor.visit(sizeArg, Type.intType));
        alloc.setType(atype2);
        if (lengthSpecified && args.length == 3) {
            return alloc;
        }
        LetExp let2 = new LetExp(new Expression[]{alloc});
        Declaration adecl2 = let2.addDeclaration(null, atype2);
        adecl2.noteValue(alloc);
        BeginExp begin2 = new BeginExp();
        int index2 = 0;
        int i6 = lengthSpecified ? 3 : 1;
        while (i6 < args.length) {
            Expression arg = args[i6];
            if (lengthSpecified && i6 + 1 < args.length && (arg instanceof QuoteExp)) {
                Object key = ((QuoteExp) arg).getValue();
                if (key instanceof Keyword) {
                    String kname = ((Keyword) key).getName();
                    try {
                        index2 = Integer.parseInt(kname);
                        i6++;
                        arg = args[i6];
                    } catch (Throwable th) {
                        comp.error('e', "non-integer keyword '" + kname + "' in array constructor");
                        return exp;
                    }
                } else {
                    continue;
                }
            }
            begin2.add(new ApplyExp(new ArraySet(elementType), new ReferenceExp(adecl2), QuoteExp.getInstance(new Integer(index2)), visitor.visit(arg, elementType)));
            index2++;
            i6++;
        }
        begin2.add(new ReferenceExp(adecl2));
        let2.body = begin2;
        return let2;
    }

    static Object[] checkKeywords(ObjectType type, Expression[] args, int start, ClassType caller) {
        int len = args.length;
        int npairs = 0;
        while ((npairs * 2) + start + 1 < len && (args[(npairs * 2) + start].valueIfConstant() instanceof Keyword)) {
            npairs++;
        }
        Object[] fields = new Object[npairs];
        for (int i = 0; i < npairs; i++) {
            String name = ((Keyword) args[(i * 2) + start].valueIfConstant()).getName();
            String lookupMember = SlotSet.lookupMember(type, name, caller);
            if (lookupMember == null) {
                lookupMember = type.getMethod(ClassExp.slotToMethodName("add", name), SlotSet.type1Array);
            }
            if (lookupMember == null) {
                lookupMember = name;
            }
            fields[i] = lookupMember;
        }
        return fields;
    }

    private static String getMethodName(Expression[] args, char kind) {
        if (kind == 'N') {
            return "<init>";
        }
        int nameIndex = kind == 'P' ? 2 : 1;
        if (args.length >= nameIndex + 1) {
            return ClassMethods.checkName(args[nameIndex], false);
        }
        return null;
    }

    private static void append(PrimProcedure[] methods, int mcount, StringBuffer sbuf) {
        for (int i = 0; i < mcount; i++) {
            sbuf.append("\n  candidate: ");
            sbuf.append(methods[i]);
        }
    }

    protected static PrimProcedure[] getMethods(ObjectType ctype, String mname, ClassType caller, Invoke iproc) {
        char c = 'P';
        int kind = iproc.kind;
        if (kind != 80) {
            c = (kind == 42 || kind == 86) ? 'V' : (char) 0;
        }
        return ClassMethods.getMethods(ctype, mname, c, caller, iproc.language);
    }

    static int hasKeywordArgument(int argsStartIndex, Expression[] args) {
        for (int i = argsStartIndex; i < args.length; i++) {
            if (args[i].valueIfConstant() instanceof Keyword) {
                return i;
            }
        }
        return args.length;
    }

    private static long selectApplicable(PrimProcedure[] methods, ObjectType ctype, Expression[] args, int margsLength, int argsStartIndex, int objIndex) {
        Type[] atypes = new Type[margsLength];
        int dst = 0;
        if (objIndex >= 0) {
            atypes[0] = ctype;
            dst = 0 + 1;
        }
        int src = argsStartIndex;
        while (src < args.length && dst < atypes.length) {
            Expression arg = args[src];
            Type atype = null;
            if (InlineCalls.checkIntValue(arg) != null) {
                atype = Type.intType;
            } else if (InlineCalls.checkLongValue(arg) != null) {
                atype = Type.longType;
            } else if (0 == 0) {
                atype = arg.getType();
            }
            atypes[dst] = atype;
            src++;
            dst++;
        }
        return ClassMethods.selectApplicable(methods, atypes);
    }

    public static synchronized PrimProcedure getStaticMethod(ClassType type, String name, Expression[] args) {
        int index;
        PrimProcedure primProcedure;
        synchronized (CompileInvoke.class) {
            PrimProcedure[] methods = getMethods(type, name, null, Invoke.invokeStatic);
            long num = selectApplicable(methods, type, args, args.length, 0, -1);
            int okCount = (int) (num >> 32);
            int maybeCount = (int) num;
            if (methods == null) {
                index = -1;
            } else if (okCount > 0) {
                index = MethodProc.mostSpecific(methods, okCount);
            } else if (maybeCount == 1) {
                index = 0;
            } else {
                index = -1;
            }
            if (index < 0) {
                primProcedure = null;
            } else {
                primProcedure = methods[index];
            }
        }
        return primProcedure;
    }
}
