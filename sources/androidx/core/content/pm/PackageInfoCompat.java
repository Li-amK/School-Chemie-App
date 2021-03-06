package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class PackageInfoCompat {
    public static long getLongVersionCode(@NonNull PackageInfo info) {
        return Build.VERSION.SDK_INT >= 28 ? info.getLongVersionCode() : info.versionCode;
    }

    private PackageInfoCompat() {
    }
}
