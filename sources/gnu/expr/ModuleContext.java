package gnu.expr;

import gnu.kawa.util.AbstractWeakHashTable;
import gnu.mapping.WrappedException;

/* loaded from: classes.dex */
public class ModuleContext {
    int flags;
    ModuleManager manager;
    private ClassToInstanceMap table = new ClassToInstanceMap();
    static ModuleContext global = new ModuleContext(ModuleManager.instance);
    public static int IN_HTTP_SERVER = 1;
    public static int IN_SERVLET = 2;

    public int getFlags() {
        return this.flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public void addFlags(int flags) {
        this.flags |= flags;
    }

    public ModuleContext(ModuleManager manager) {
        this.manager = manager;
    }

    public static ModuleContext getContext() {
        return global;
    }

    public ModuleManager getManager() {
        return this.manager;
    }

    public synchronized Object findInstance(ModuleInfo info) {
        try {
        } catch (ClassNotFoundException ex) {
            throw new WrappedException("cannot find module " + info.getClassName(), ex);
        }
        return findInstance(info.getModuleClass());
    }

    public synchronized Object searchInstance(Class clas) {
        return this.table.get(clas);
    }

    public synchronized Object findInstance(Class clas) {
        Object inst;
        inst = this.table.get(clas);
        if (inst == null) {
            try {
                inst = clas.getDeclaredField("$instance").get(null);
            } catch (NoSuchFieldException e) {
                inst = clas.newInstance();
            }
            setInstance(inst);
        }
        return inst;
    }

    public synchronized void setInstance(Object instance) {
        this.table.put(instance.getClass(), instance);
    }

    public ModuleInfo findFromInstance(Object instance) {
        ModuleInfo info;
        Class instanceClass = instance.getClass();
        synchronized (this) {
            ModuleManager moduleManager = this.manager;
            info = ModuleManager.findWithClass(instanceClass);
            setInstance(instance);
        }
        return info;
    }

    public synchronized void clear() {
        this.table.clear();
    }

    /* loaded from: classes.dex */
    public static class ClassToInstanceMap extends AbstractWeakHashTable<Class, Object> {
        ClassToInstanceMap() {
        }

        @Override // gnu.kawa.util.AbstractWeakHashTable
        public Class getKeyFromValue(Object instance) {
            return instance.getClass();
        }

        protected boolean matches(Class oldValue, Class newValue) {
            return oldValue == newValue;
        }
    }
}
