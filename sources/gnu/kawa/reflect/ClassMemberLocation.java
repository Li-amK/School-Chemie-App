package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Language;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrappedException;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class ClassMemberLocation extends Location {
    Object instance;
    String mname;
    Field rfield;
    ClassType type;

    public final Object getInstance() {
        return this.instance;
    }

    public final void setInstance(Object obj) {
        this.instance = obj;
    }

    public ClassMemberLocation(Object instance, ClassType type, String mname) {
        this.instance = instance;
        this.type = type;
        this.mname = mname;
    }

    public ClassMemberLocation(Object instance, Class clas, String mname) {
        this.instance = instance;
        this.type = (ClassType) Type.make(clas);
        this.mname = mname;
    }

    public ClassMemberLocation(Object instance, Field field) {
        this.instance = instance;
        this.rfield = field;
        this.mname = field.getName();
    }

    public String getMemberName() {
        return this.mname;
    }

    public ClassType getDeclaringClass() {
        return this.type;
    }

    public void setup() {
        if (this.rfield == null) {
            try {
                try {
                    this.rfield = this.type.getReflectClass().getField(this.mname);
                } catch (NoSuchFieldException ex) {
                    RuntimeException uex = new UnboundLocationException((Object) null, "Unbound location  - no field " + this.mname + " in " + this.type.getName());
                    uex.initCause(ex);
                    throw uex;
                }
            } catch (RuntimeException ex2) {
                RuntimeException uex2 = new UnboundLocationException((Object) null, "Unbound location - " + ex2.toString());
                uex2.initCause(ex2);
                throw uex2;
            }
        }
    }

    public Field getRField() {
        Field rfld = this.rfield;
        if (rfld == null) {
            try {
                rfld = this.type.getReflectClass().getField(this.mname);
                this.rfield = rfld;
            } catch (Exception e) {
                return null;
            }
        }
        return rfld;
    }

    public Class getRClass() {
        Field rfld = this.rfield;
        if (rfld != null) {
            return rfld.getDeclaringClass();
        }
        try {
            return this.type.getReflectClass();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // gnu.mapping.Location
    public Object get(Object defaultValue) {
        Field rfld = getRField();
        if (rfld == null) {
            return defaultValue;
        }
        try {
            return rfld.get(this.instance);
        } catch (IllegalAccessException ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }

    @Override // gnu.mapping.Location
    public boolean isConstant() {
        return (getRField() == null || (this.rfield.getModifiers() & 16) == 0) ? false : true;
    }

    @Override // gnu.mapping.Location
    public boolean isBound() {
        return getRField() != null;
    }

    @Override // gnu.mapping.Location
    public void set(Object value) {
        setup();
        try {
            this.rfield.set(this.instance, value);
        } catch (IllegalAccessException ex) {
            throw WrappedException.wrapIfNeeded(ex);
        }
    }

    public static void define(Object instance, Field rfield, String uri, Language language, Environment env) throws IllegalAccessException {
        Symbol sym;
        Location loc;
        Object fvalue = rfield.get(instance);
        Type ftype = Type.make(rfield.getType());
        boolean isAlias = ftype.isSubtype(Compilation.typeLocation);
        ftype.isSubtype(Compilation.typeProcedure);
        int rModifiers = rfield.getModifiers();
        boolean isFinal = (rModifiers & 16) != 0;
        Object fdname = (!isFinal || !(fvalue instanceof Named) || isAlias) ? Compilation.demangleName(rfield.getName(), true) : ((Named) fvalue).getSymbol();
        if (fdname instanceof Symbol) {
            sym = (Symbol) fdname;
        } else {
            if (uri == null) {
                uri = "";
            }
            sym = Symbol.make(uri, fdname.toString().intern());
        }
        Object property = null;
        if (!isAlias || !isFinal) {
            if (isFinal) {
                property = language.getEnvPropertyFor(rfield, fvalue);
            }
            if ((rModifiers & 8) != 0) {
                loc = new StaticFieldLocation(rfield);
            } else {
                loc = new FieldLocation(instance, rfield);
            }
        } else {
            loc = (Location) fvalue;
        }
        env.addLocation(sym, property, loc);
    }

    public static void defineAll(Object instance, Language language, Environment env) throws IllegalAccessException {
        Field[] fields = instance.getClass().getFields();
        int i = fields.length;
        while (true) {
            i--;
            if (i >= 0) {
                Field field = fields[i];
                String fname = field.getName();
                if (!fname.startsWith(Declaration.PRIVATE_PREFIX) && !fname.endsWith("$instance")) {
                    define(instance, field, null, language, env);
                }
            } else {
                return;
            }
        }
    }
}
