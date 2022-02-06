package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;

/* loaded from: classes.dex */
public class TryExp extends Expression {
    CatchClause catch_clauses;
    Expression finally_clause;
    Expression try_clause;

    public final CatchClause getCatchClauses() {
        return this.catch_clauses;
    }

    public final Expression getFinallyClause() {
        return this.finally_clause;
    }

    public final void setCatchClauses(CatchClause catch_clauses) {
        this.catch_clauses = catch_clauses;
    }

    public TryExp(Expression try_clause, Expression finally_clause) {
        this.try_clause = try_clause;
        this.finally_clause = finally_clause;
    }

    @Override // gnu.expr.Expression
    protected boolean mustCompile() {
        return false;
    }

    /* JADX WARN: Finally extract failed */
    @Override // gnu.expr.Expression, gnu.mapping.Procedure
    public void apply(CallContext ctx) throws Throwable {
        try {
            this.try_clause.apply(ctx);
            ctx.runUntilDone();
            if (this.finally_clause != null) {
                this.finally_clause.eval(ctx);
            }
        } catch (Throwable th) {
            if (this.finally_clause != null) {
                this.finally_clause.eval(ctx);
            }
            throw th;
        }
    }

    @Override // gnu.expr.Expression
    public void compile(Compilation comp, Target target) {
        Target ttarg;
        CodeAttr code = comp.getCode();
        boolean has_finally = this.finally_clause != null;
        if ((target instanceof StackTarget) || (target instanceof ConsumerTarget) || (target instanceof IgnoreTarget) || ((target instanceof ConditionalTarget) && this.finally_clause == null)) {
            ttarg = target;
        } else {
            ttarg = Target.pushValue(target.getType());
        }
        code.emitTryStart(has_finally, ttarg instanceof StackTarget ? ttarg.getType() : null);
        this.try_clause.compileWithPosition(comp, ttarg);
        for (CatchClause catch_clause = this.catch_clauses; catch_clause != null; catch_clause = catch_clause.getNext()) {
            catch_clause.compile(comp, ttarg);
        }
        if (this.finally_clause != null) {
            code.emitFinallyStart();
            this.finally_clause.compileWithPosition(comp, Target.Ignore);
            code.emitFinallyEnd();
        }
        code.emitTryCatchEnd();
        if (ttarg != target) {
            target.compileFromStack(comp, target.getType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // gnu.expr.Expression
    public <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitTryExp(this, d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // gnu.expr.Expression
    public <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
        this.try_clause = visitor.visitAndUpdate(this.try_clause, d);
        for (CatchClause catch_clause = this.catch_clauses; visitor.exitValue == null && catch_clause != null; catch_clause = catch_clause.getNext()) {
            visitor.visit(catch_clause, d);
        }
        if (visitor.exitValue == null && this.finally_clause != null) {
            this.finally_clause = visitor.visitAndUpdate(this.finally_clause, d);
        }
    }

    @Override // gnu.expr.Expression
    public Type getType() {
        return this.catch_clauses == null ? this.try_clause.getType() : super.getType();
    }

    @Override // gnu.expr.Expression
    public void print(OutPort ps) {
        ps.startLogicalBlock("(Try", ")", 2);
        ps.writeSpaceFill();
        this.try_clause.print(ps);
        for (CatchClause catch_clause = this.catch_clauses; catch_clause != null; catch_clause = catch_clause.getNext()) {
            catch_clause.print(ps);
        }
        if (this.finally_clause != null) {
            ps.writeSpaceLinear();
            ps.print(" finally: ");
            this.finally_clause.print(ps);
        }
        ps.endLogicalBlock(")");
    }
}
