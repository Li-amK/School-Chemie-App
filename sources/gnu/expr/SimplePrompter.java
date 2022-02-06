package gnu.expr;

import gnu.mapping.InPort;
import gnu.mapping.Procedure1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Language.java */
/* loaded from: classes.dex */
public class SimplePrompter extends Procedure1 {
    public String prefix = "[";
    public String suffix = "] ";

    @Override // gnu.mapping.Procedure1, gnu.mapping.Procedure
    public Object apply1(Object arg) {
        int line;
        return (!(arg instanceof InPort) || (line = ((InPort) arg).getLineNumber() + 1) < 0) ? this.suffix : this.prefix + line + this.suffix;
    }
}
