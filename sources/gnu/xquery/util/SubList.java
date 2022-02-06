package gnu.xquery.util;

import gnu.lists.Consumer;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;

/* loaded from: classes.dex */
public class SubList extends MethodProc {
    public static final SubList subList = new SubList();

    @Override // gnu.mapping.Procedure
    public int numArgs() {
        return 12290;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r2 >= r12) goto L_0x0027;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        r1 = r5.nextDataIndex(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r1 >= 0) goto L_0x002b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        r5.consumeIRange(r1, r1, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void subList(java.lang.Object r9, double r10, double r12, gnu.lists.Consumer r14) {
        /*
            boolean r6 = r9 instanceof gnu.mapping.Values
            if (r6 == 0) goto L_0x002e
            r5 = r9
            gnu.mapping.Values r5 = (gnu.mapping.Values) r5
            r2 = 0
            r1 = 0
        L_0x0009:
            int r2 = r2 + 1
            double r6 = (double) r2
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 >= 0) goto L_0x0017
            int r1 = r5.nextDataIndex(r1)
            if (r1 >= 0) goto L_0x0009
        L_0x0016:
            return
        L_0x0017:
            r4 = r1
            r0 = r1
            r3 = r2
        L_0x001a:
            int r2 = r3 + 1
            double r6 = (double) r3
            int r6 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r6 >= 0) goto L_0x0027
            int r1 = r5.nextDataIndex(r1)
            if (r1 >= 0) goto L_0x002b
        L_0x0027:
            r5.consumeIRange(r4, r0, r14)
            goto L_0x0016
        L_0x002b:
            r0 = r1
            r3 = r2
            goto L_0x001a
        L_0x002e:
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r6 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x0016
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r6 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x0016
            r14.writeObject(r9)
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.xquery.util.SubList.subList(java.lang.Object, double, double, gnu.lists.Consumer):void");
    }

    @Override // gnu.mapping.Procedure
    public void apply(CallContext ctx) {
        Consumer consumer = ctx.consumer;
        Object seq = ctx.getNextArg();
        double d1 = Math.round(StringUtils.asDouble(ctx.getNextArg()));
        Object eof = Sequence.eofValue;
        Object arg2 = ctx.getNextArg(eof);
        ctx.lastArg();
        subList(seq, d1, d1 + (arg2 != eof ? Math.round(StringUtils.asDouble(arg2)) : Double.POSITIVE_INFINITY), consumer);
    }
}
