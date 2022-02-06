package gnu.expr;

/* loaded from: classes.dex */
public abstract class ExpExpVisitor<D> extends ExpVisitor<Expression, D> {
    /* JADX INFO: Access modifiers changed from: protected */
    public Expression update(Expression exp, Expression r) {
        return r;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // gnu.expr.ExpVisitor
    protected Expression defaultValue(Expression r, D d) {
        return r;
    }
}
