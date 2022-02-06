package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;

/* loaded from: classes.dex */
public class SynchronizedExp extends Expression {
    Expression body;
    Expression object;

    public SynchronizedExp(Expression object, Expression body) {
        this.object = object;
        this.body = body;
    }

    @Override // gnu.expr.Expression
    protected boolean mustCompile() {
        return false;
    }

    @Override // gnu.expr.Expression, gnu.mapping.Procedure
    public void apply(CallContext ctx) throws Throwable {
        Object result;
        synchronized (this.object.eval(ctx)) {
            result = this.body.eval(ctx);
        }
        ctx.writeValue(result);
    }

    @Override // gnu.expr.Expression
    public void compile(Compilation comp, Target target) {
        Type type;
        CodeAttr code = comp.getCode();
        this.object.compile(comp, Target.pushObject);
        code.emitDup(1);
        Variable objvar = code.pushScope().addVariable(code, Type.pointer_type, null);
        code.emitStore(objvar);
        code.emitMonitorEnter();
        if ((target instanceof IgnoreTarget) || (target instanceof ConsumerTarget)) {
            type = null;
        } else {
            type = target.getType();
        }
        code.emitTryStart(false, type);
        this.body.compileWithPosition(comp, target);
        code.emitLoad(objvar);
        code.emitMonitorExit();
        code.emitTryEnd();
        code.emitCatchStart(null);
        code.emitLoad(objvar);
        code.emitMonitorExit();
        code.emitThrow();
        code.emitCatchEnd();
        code.emitTryCatchEnd();
        code.popScope();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // gnu.expr.Expression
    public <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitSynchronizedExp(this, d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // gnu.expr.Expression
    public <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
        this.object = visitor.visitAndUpdate(this.object, d);
        if (visitor.exitValue == null) {
            this.body = visitor.visitAndUpdate(this.body, d);
        }
    }

    @Override // gnu.expr.Expression
    public void print(OutPort ps) {
        ps.print("(Synchronized ");
        this.object.print(ps);
        ps.print(" ");
        this.body.print(ps);
        ps.print(")");
    }
}
