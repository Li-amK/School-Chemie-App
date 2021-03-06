package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.ArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {
    final Context mContext;
    private Map<SupportMenuItem, MenuItem> mMenuItems;
    private Map<SupportSubMenu, SubMenu> mSubMenus;

    public BaseMenuWrapper(Context context, T object) {
        super(object);
        this.mContext = context;
    }

    final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.mMenuItems == null) {
            this.mMenuItems = new ArrayMap();
        }
        MenuItem wrappedItem = this.mMenuItems.get(menuItem);
        if (wrappedItem != null) {
            return wrappedItem;
        }
        MenuItem wrappedItem2 = MenuWrapperFactory.wrapSupportMenuItem(this.mContext, supportMenuItem);
        this.mMenuItems.put(supportMenuItem, wrappedItem2);
        return wrappedItem2;
    }

    final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.mSubMenus == null) {
            this.mSubMenus = new ArrayMap();
        }
        SubMenu wrappedMenu = this.mSubMenus.get(supportSubMenu);
        if (wrappedMenu != null) {
            return wrappedMenu;
        }
        SubMenu wrappedMenu2 = MenuWrapperFactory.wrapSupportSubMenu(this.mContext, supportSubMenu);
        this.mSubMenus.put(supportSubMenu, wrappedMenu2);
        return wrappedMenu2;
    }

    final void internalClear() {
        if (this.mMenuItems != null) {
            this.mMenuItems.clear();
        }
        if (this.mSubMenus != null) {
            this.mSubMenus.clear();
        }
    }

    final void internalRemoveGroup(int groupId) {
        if (this.mMenuItems != null) {
            Iterator<SupportMenuItem> iterator = this.mMenuItems.keySet().iterator();
            while (iterator.hasNext()) {
                if (groupId == iterator.next().getGroupId()) {
                    iterator.remove();
                }
            }
        }
    }

    final void internalRemoveItem(int id) {
        if (this.mMenuItems != null) {
            Iterator<SupportMenuItem> iterator = this.mMenuItems.keySet().iterator();
            while (iterator.hasNext()) {
                if (id == iterator.next().getItemId()) {
                    iterator.remove();
                    return;
                }
            }
        }
    }
}
