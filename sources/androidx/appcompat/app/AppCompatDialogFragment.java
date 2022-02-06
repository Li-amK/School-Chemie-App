package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.DialogFragment;

/* loaded from: classes.dex */
public class AppCompatDialogFragment extends DialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AppCompatDialog(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setupDialog(Dialog dialog, int style) {
        if (dialog instanceof AppCompatDialog) {
            AppCompatDialog acd = (AppCompatDialog) dialog;
            switch (style) {
                case 1:
                case 2:
                    break;
                default:
                    return;
                case 3:
                    dialog.getWindow().addFlags(24);
                    break;
            }
            acd.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, style);
    }
}
