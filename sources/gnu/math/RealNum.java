package gnu.math;

import java.math.BigDecimal;

/* loaded from: classes.dex */
public abstract class RealNum extends Complex implements Comparable {
    @Override // gnu.math.Complex, gnu.math.Quantity, gnu.math.Numeric
    public abstract Numeric add(Object obj, int i);

    @Override // gnu.math.Complex, gnu.math.Quantity, gnu.math.Numeric
    public abstract Numeric div(Object obj);

    public abstract boolean isNegative();

    @Override // gnu.math.Complex, gnu.math.Quantity, gnu.math.Numeric
    public abstract Numeric mul(Object obj);

    public abstract int sign();

    @Override // gnu.math.Quantity
    public final RealNum re() {
        return this;
    }

    @Override // gnu.math.Quantity
    public final RealNum im() {
        return IntNum.zero();
    }

    public static RealNum asRealNumOrNull(Object value) {
        if (value instanceof RealNum) {
            return (RealNum) value;
        }
        if ((value instanceof Float) || (value instanceof Double)) {
            return new DFloNum(((Number) value).doubleValue());
        }
        return RatNum.asRatNumOrNull(value);
    }

    public RealNum max(RealNum x) {
        boolean exact = isExact() && x.isExact();
        RealNum result = grt(x) ? this : x;
        if (exact || !result.isExact()) {
            return result;
        }
        return new DFloNum(result.doubleValue());
    }

    public RealNum min(RealNum x) {
        boolean exact = isExact() && x.isExact();
        RealNum result = grt(x) ? x : this;
        if (exact || !result.isExact()) {
            return result;
        }
        return new DFloNum(result.doubleValue());
    }

    public static RealNum add(RealNum x, RealNum y, int k) {
        return (RealNum) x.add(y, k);
    }

    public static RealNum times(RealNum x, RealNum y) {
        return (RealNum) x.mul(y);
    }

    public static RealNum divide(RealNum x, RealNum y) {
        return (RealNum) x.div(y);
    }

    @Override // gnu.math.Complex, gnu.math.Quantity, gnu.math.Numeric
    public Numeric abs() {
        return isNegative() ? neg() : this;
    }

    public RealNum rneg() {
        return (RealNum) neg();
    }

    @Override // gnu.math.Complex, gnu.math.Numeric
    public boolean isZero() {
        return sign() == 0;
    }

    @Override // gnu.math.Complex, gnu.math.Numeric
    public RatNum toExact() {
        return DFloNum.toExact(doubleValue());
    }

    @Override // gnu.math.Complex, gnu.math.Numeric
    public RealNum toInexact() {
        if (isExact()) {
            return new DFloNum(doubleValue());
        }
        return this;
    }

    public static double toInt(double d, int rounding_mode) {
        switch (rounding_mode) {
            case 1:
                return Math.floor(d);
            case 2:
                return Math.ceil(d);
            case 3:
                return d < 0.0d ? Math.ceil(d) : Math.floor(d);
            case 4:
                return Math.rint(d);
            default:
                return d;
        }
    }

    public RealNum toInt(int rounding_mode) {
        return new DFloNum(toInt(doubleValue(), rounding_mode));
    }

    public IntNum toExactInt(int rounding_mode) {
        return toExactInt(doubleValue(), rounding_mode);
    }

    public static IntNum toExactInt(double value, int rounding_mode) {
        return toExactInt(toInt(value, rounding_mode));
    }

    public static IntNum toExactInt(double value) {
        boolean neg;
        long bits;
        if (Double.isInfinite(value) || Double.isNaN(value)) {
            throw new ArithmeticException("cannot convert " + value + " to exact integer");
        }
        long bits2 = Double.doubleToLongBits(value);
        if (bits2 < 0) {
            neg = true;
        } else {
            neg = false;
        }
        int exp = ((int) (bits2 >> 52)) & 2047;
        long bits3 = bits2 & 4503599627370495L;
        if (exp == 0) {
            bits = bits3 << 1;
        } else {
            bits = bits3 | 4503599627370496L;
        }
        if (exp <= 1075) {
            int rshift = 1075 - exp;
            if (rshift > 53) {
                return IntNum.zero();
            }
            long bits4 = bits >> rshift;
            return IntNum.make(neg ? -bits4 : bits4);
        }
        return IntNum.shift(IntNum.make(neg ? -bits : bits), exp - 1075);
    }

    @Override // gnu.math.Complex
    public Complex exp() {
        return new DFloNum(Math.exp(doubleValue()));
    }

    @Override // gnu.math.Complex
    public Complex log() {
        double x = doubleValue();
        return x < 0.0d ? DComplex.log(x, 0.0d) : new DFloNum(Math.log(x));
    }

    public final Complex sin() {
        return new DFloNum(Math.sin(doubleValue()));
    }

    @Override // gnu.math.Complex
    public final Complex sqrt() {
        double d = doubleValue();
        if (d >= 0.0d) {
            return new DFloNum(Math.sqrt(d));
        }
        return DComplex.sqrt(d, 0.0d);
    }

    public static IntNum toScaledInt(double f, int k) {
        return toScaledInt(DFloNum.toExact(f), k);
    }

    public static IntNum toScaledInt(RatNum r, int k) {
        if (k != 0) {
            IntNum power = IntNum.power(IntNum.ten(), k < 0 ? -k : k);
            IntNum num = r.numerator();
            IntNum den = r.denominator();
            if (k >= 0) {
                num = IntNum.times(num, power);
            } else {
                den = IntNum.times(den, power);
            }
            r = RatNum.make(num, den);
        }
        return r.toExactInt(4);
    }

    public IntNum toScaledInt(int k) {
        return toScaledInt(toExact(), k);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object o) {
        return compare(o);
    }

    public BigDecimal asBigDecimal() {
        return new BigDecimal(doubleValue());
    }

    public static String toStringScientific(float d) {
        return toStringScientific(Float.toString(d));
    }

    public static String toStringScientific(double d) {
        return toStringScientific(Double.toString(d));
    }

    public static String toStringScientific(String dstr) {
        if (dstr.indexOf(69) >= 0) {
            return dstr;
        }
        int len = dstr.length();
        char ch = dstr.charAt(len - 1);
        if (ch == 'y' || ch == 'N') {
            return dstr;
        }
        StringBuffer sbuf = new StringBuffer(len + 10);
        int exp = toStringScientific(dstr, sbuf);
        sbuf.append('E');
        sbuf.append(exp);
        return sbuf.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a A[LOOP:1: B:15:0x0030->B:17:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad A[EDGE_INSN: B:59:0x00ad->B:45:0x00ad ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int toStringScientific(java.lang.String r12, java.lang.StringBuffer r13) {
        /*
            r10 = 0
            char r10 = r12.charAt(r10)
            r11 = 45
            if (r10 != r11) goto L_0x003c
            r5 = 1
        L_0x000a:
            if (r5 == 0) goto L_0x0011
            r10 = 45
            r13.append(r10)
        L_0x0011:
            if (r5 == 0) goto L_0x003e
            r6 = 1
        L_0x0014:
            int r3 = r12.length()
            char r10 = r12.charAt(r6)
            r11 = 48
            if (r10 != r11) goto L_0x007d
            r9 = r6
            r7 = r6
        L_0x0022:
            if (r7 != r3) goto L_0x0040
            java.lang.String r10 = "0"
            r13.append(r10)
            r2 = 0
            r6 = r7
        L_0x002b:
            int r6 = r13.length()
            r8 = -1
        L_0x0030:
            int r6 = r6 + (-1)
            char r0 = r13.charAt(r6)
            r10 = 48
            if (r0 != r10) goto L_0x00ad
            r8 = r6
            goto L_0x0030
        L_0x003c:
            r5 = 0
            goto L_0x000a
        L_0x003e:
            r6 = 0
            goto L_0x0014
        L_0x0040:
            int r6 = r7 + 1
            char r0 = r12.charAt(r7)
            r10 = 48
            if (r0 < r10) goto L_0x007b
            r10 = 57
            if (r0 > r10) goto L_0x007b
            r10 = 48
            if (r0 != r10) goto L_0x0054
            if (r6 != r3) goto L_0x007b
        L_0x0054:
            r13.append(r0)
            r10 = 46
            r13.append(r10)
            r10 = 48
            if (r0 != r10) goto L_0x0069
            r2 = 0
        L_0x0061:
            if (r6 != r3) goto L_0x00bc
            r10 = 48
            r13.append(r10)
            goto L_0x002b
        L_0x0069:
            int r10 = r9 - r6
            int r2 = r10 + 2
            goto L_0x0061
        L_0x006e:
            if (r7 >= r3) goto L_0x00b9
            int r6 = r7 + 1
            char r10 = r12.charAt(r7)
            r13.append(r10)
            r7 = r6
            goto L_0x006e
        L_0x007b:
            r7 = r6
            goto L_0x0022
        L_0x007d:
            if (r5 == 0) goto L_0x00ab
            r10 = 2
        L_0x0080:
            int r4 = r3 - r10
            r10 = 46
            int r1 = r12.indexOf(r10)
            int r10 = r4 - r3
            int r2 = r10 + r1
            int r7 = r6 + 1
            char r10 = r12.charAt(r6)
            r13.append(r10)
            r10 = 46
            r13.append(r10)
        L_0x009a:
            if (r7 >= r3) goto L_0x00b9
            int r6 = r7 + 1
            char r0 = r12.charAt(r7)
            r10 = 46
            if (r0 == r10) goto L_0x00a9
            r13.append(r0)
        L_0x00a9:
            r7 = r6
            goto L_0x009a
        L_0x00ab:
            r10 = 1
            goto L_0x0080
        L_0x00ad:
            r10 = 46
            if (r0 != r10) goto L_0x00b3
            int r8 = r6 + 2
        L_0x00b3:
            if (r8 < 0) goto L_0x00b8
            r13.setLength(r8)
        L_0x00b8:
            return r2
        L_0x00b9:
            r6 = r7
            goto L_0x002b
        L_0x00bc:
            r7 = r6
            goto L_0x006e
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.math.RealNum.toStringScientific(java.lang.String, java.lang.StringBuffer):int");
    }

    public static String toStringDecimal(String dstr) {
        int indexE = dstr.indexOf(69);
        if (indexE < 0) {
            return dstr;
        }
        int len = dstr.length();
        char ch = dstr.charAt(len - 1);
        if (ch == 'y' || ch == 'N') {
            return dstr;
        }
        StringBuffer sbuf = new StringBuffer(len + 10);
        boolean neg = dstr.charAt(0) == '-';
        if (dstr.charAt(indexE + 1) != '-') {
            throw new Error("not implemented: toStringDecimal given non-negative exponent: " + dstr);
        }
        int exp = 0;
        for (int pos = indexE + 2; pos < len; pos++) {
            exp = (exp * 10) + (dstr.charAt(pos) - '0');
        }
        if (neg) {
            sbuf.append('-');
        }
        sbuf.append("0.");
        while (true) {
            exp--;
            if (exp <= 0) {
                break;
            }
            sbuf.append('0');
        }
        int pos2 = 0;
        while (true) {
            int pos3 = pos2 + 1;
            char ch2 = dstr.charAt(pos2);
            if (ch2 == 'E') {
                return sbuf.toString();
            }
            if ((!(ch2 != '.') || !(ch2 != '-')) || (ch2 == '0' && pos3 >= indexE)) {
                pos2 = pos3;
            } else {
                sbuf.append(ch2);
                pos2 = pos3;
            }
        }
    }
}
