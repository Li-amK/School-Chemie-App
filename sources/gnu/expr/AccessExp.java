package gnu.expr;

import gnu.mapping.Symbol;

/* loaded from: classes.dex */
public abstract class AccessExp extends Expression {
    Declaration binding;
    private Declaration context;
    Object symbol;

    public String string_name() {
        return this.symbol.toString();
    }

    @Override // gnu.mapping.PropertySet, gnu.mapping.Named
    public final String getName() {
        return this.symbol instanceof Symbol ? ((Symbol) this.symbol).getName() : this.symbol.toString();
    }

    public final String getSimpleName() {
        if (this.symbol instanceof String) {
            return (String) this.symbol;
        }
        if (this.symbol instanceof Symbol) {
            Symbol sym = (Symbol) this.symbol;
            if (sym.hasEmptyNamespace()) {
                return sym.getLocalName();
            }
        }
        return null;
    }

    @Override // gnu.mapping.PropertySet, gnu.mapping.Named
    public final Object getSymbol() {
        return this.symbol;
    }

    public final Declaration getBinding() {
        return this.binding;
    }

    public final void setBinding(Declaration decl) {
        this.binding = decl;
    }

    public final Declaration contextDecl() {
        return this.context;
    }

    public final void setContextDecl(Declaration decl) {
        this.context = decl;
    }
}
