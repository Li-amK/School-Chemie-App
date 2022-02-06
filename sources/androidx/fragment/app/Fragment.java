package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.util.DebugUtils;
import androidx.core.view.LayoutInflaterCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 4;
    static final int STARTED = 3;
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    FragmentManagerImpl mChildFragmentManager;
    FragmentManagerNonConfig mChildNonConfig;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManagerImpl mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback mHost;
    boolean mInLayout;
    View mInnerView;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    LayoutInflater mLayoutInflater;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetaining;
    Bundle mSavedFragmentState;
    @Nullable
    Boolean mSavedUserVisibleHint;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    View mView;
    LifecycleOwner mViewLifecycleOwner;
    LifecycleRegistry mViewLifecycleRegistry;
    ViewModelStore mViewModelStore;
    String mWho;
    private static final SimpleArrayMap<String, Class<?>> sClassMap = new SimpleArrayMap<>();
    static final Object USE_DEFAULT_TRANSITION = new Object();
    int mState = 0;
    int mIndex = -1;
    int mTargetIndex = -1;
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData = new MutableLiveData<>();

    /* loaded from: classes.dex */
    public interface OnStartEnterTransitionListener {
        void onStartEnterTransition();

        void startListening();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @NonNull
    @MainThread
    public LifecycleOwner getViewLifecycleOwner() {
        if (this.mViewLifecycleOwner != null) {
            return this.mViewLifecycleOwner;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    @NonNull
    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        if (getContext() == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mViewModelStore == null) {
            this.mViewModelStore = new ViewModelStore();
        }
        return this.mViewModelStore;
    }

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.fragment.app.Fragment.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                return new SavedState(in, loader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        final Bundle mState;

        public SavedState(Bundle state) {
            this.mState = state;
        }

        SavedState(Parcel in, ClassLoader loader) {
            this.mState = in.readBundle();
            if (loader != null && this.mState != null) {
                this.mState.setClassLoader(loader);
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeBundle(this.mState);
        }
    }

    /* loaded from: classes.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String msg, Exception cause) {
            super(msg, cause);
        }
    }

    public static Fragment instantiate(Context context, String fname) {
        return instantiate(context, fname, null);
    }

    public static Fragment instantiate(Context context, String fname, @Nullable Bundle args) {
        try {
            Class<?> clazz = sClassMap.get(fname);
            if (clazz == null) {
                clazz = context.getClassLoader().loadClass(fname);
                sClassMap.put(fname, clazz);
            }
            Fragment f = (Fragment) clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (args != null) {
                args.setClassLoader(f.getClass().getClassLoader());
                f.setArguments(args);
            }
            return f;
        } catch (ClassNotFoundException e) {
            throw new InstantiationException("Unable to instantiate fragment " + fname + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + fname + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + fname + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + fname + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new InstantiationException("Unable to instantiate fragment " + fname + ": calling Fragment constructor caused an exception", e5);
        }
    }

    public static boolean isSupportFragmentClass(Context context, String fname) {
        try {
            Class<?> clazz = sClassMap.get(fname);
            if (clazz == null) {
                clazz = context.getClassLoader().loadClass(fname);
                sClassMap.put(fname, clazz);
            }
            return Fragment.class.isAssignableFrom(clazz);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public final void restoreViewState(Bundle savedInstanceState) {
        if (this.mSavedViewState != null) {
            this.mInnerView.restoreHierarchyState(this.mSavedViewState);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(savedInstanceState);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.mView != null) {
            this.mViewLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        }
    }

    public final void setIndex(int index, Fragment parent) {
        this.mIndex = index;
        if (parent != null) {
            this.mWho = parent.mWho + ":" + this.mIndex;
        } else {
            this.mWho = "android:fragment:" + this.mIndex;
        }
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean equals(Object o) {
        return super.equals(o);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        DebugUtils.buildShortClassTag(this, sb);
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @Nullable
    public final String getTag() {
        return this.mTag;
    }

    public void setArguments(@Nullable Bundle args) {
        if (this.mIndex < 0 || !isStateSaved()) {
            this.mArguments = args;
            return;
        }
        throw new IllegalStateException("Fragment already active and state has been saved");
    }

    @Nullable
    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final boolean isStateSaved() {
        if (this.mFragmentManager == null) {
            return false;
        }
        return this.mFragmentManager.isStateSaved();
    }

    public void setInitialSavedState(@Nullable SavedState state) {
        if (this.mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.mSavedFragmentState = (state == null || state.mState == null) ? null : state.mState;
    }

    public void setTargetFragment(@Nullable Fragment fragment, int requestCode) {
        FragmentManager mine = getFragmentManager();
        FragmentManager theirs = fragment != null ? fragment.getFragmentManager() : null;
        if (mine == null || theirs == null || mine == theirs) {
            for (Fragment check = fragment; check != null; check = check.getTargetFragment()) {
                if (check == this) {
                    throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
                }
            }
            this.mTarget = fragment;
            this.mTargetRequestCode = requestCode;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
    }

    @Nullable
    public final Fragment getTargetFragment() {
        return this.mTarget;
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    @Nullable
    public Context getContext() {
        if (this.mHost == null) {
            return null;
        }
        return this.mHost.getContext();
    }

    @NonNull
    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Nullable
    public final FragmentActivity getActivity() {
        if (this.mHost == null) {
            return null;
        }
        return (FragmentActivity) this.mHost.getActivity();
    }

    @NonNull
    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @Nullable
    public final Object getHost() {
        if (this.mHost == null) {
            return null;
        }
        return this.mHost.onGetHost();
    }

    @NonNull
    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    @NonNull
    public final Resources getResources() {
        return requireContext().getResources();
    }

    @NonNull
    public final CharSequence getText(@StringRes int resId) {
        return getResources().getText(resId);
    }

    @NonNull
    public final String getString(@StringRes int resId) {
        return getResources().getString(resId);
    }

    @NonNull
    public final String getString(@StringRes int resId, Object... formatArgs) {
        return getResources().getString(resId, formatArgs);
    }

    @Nullable
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    @NonNull
    public final FragmentManager requireFragmentManager() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @NonNull
    public final FragmentManager getChildFragmentManager() {
        if (this.mChildFragmentManager == null) {
            instantiateChildFragmentManager();
            if (this.mState >= 4) {
                this.mChildFragmentManager.dispatchResume();
            } else if (this.mState >= 3) {
                this.mChildFragmentManager.dispatchStart();
            } else if (this.mState >= 2) {
                this.mChildFragmentManager.dispatchActivityCreated();
            } else if (this.mState >= 1) {
                this.mChildFragmentManager.dispatchCreate();
            }
        }
        return this.mChildFragmentManager;
    }

    @Nullable
    public FragmentManager peekChildFragmentManager() {
        return this.mChildFragmentManager;
    }

    @Nullable
    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isResumed() {
        return this.mState >= 4;
    }

    public final boolean isVisible() {
        return isAdded() && !isHidden() && this.mView != null && this.mView.getWindowToken() != null && this.mView.getVisibility() == 0;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    public void onHiddenChanged(boolean hidden) {
    }

    public void setRetainInstance(boolean retain) {
        this.mRetainInstance = retain;
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        if (this.mHasMenu != hasMenu) {
            this.mHasMenu = hasMenu;
            if (isAdded() && !isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setMenuVisibility(boolean menuVisible) {
        if (this.mMenuVisible != menuVisible) {
            this.mMenuVisible = menuVisible;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.onSupportInvalidateOptionsMenu();
            }
        }
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (!this.mUserVisibleHint && isVisibleToUser && this.mState < 3 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            this.mFragmentManager.performPendingDeferredStart(this);
        }
        this.mUserVisibleHint = isVisibleToUser;
        this.mDeferStart = this.mState < 3 && !isVisibleToUser;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(isVisibleToUser);
        }
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(Intent intent, @Nullable Bundle options) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mHost.onStartActivityFromFragment(this, intent, -1, options);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode, null);
    }

    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mHost.onStartActivityFromFragment(this, intent, requestCode, options);
    }

    public void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mHost.onStartIntentSenderFromFragment(this, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public final void requestPermissions(@NonNull String[] permissions, int requestCode) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mHost.onRequestPermissionsFromFragment(this, permissions, requestCode);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }

    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        if (this.mHost != null) {
            return this.mHost.onShouldShowRequestPermissionRationale(permission);
        }
        return false;
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        return getLayoutInflater(savedInstanceState);
    }

    public final LayoutInflater getLayoutInflater() {
        return this.mLayoutInflater == null ? performGetLayoutInflater(null) : this.mLayoutInflater;
    }

    @NonNull
    public LayoutInflater performGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        this.mLayoutInflater = onGetLayoutInflater(savedInstanceState);
        return this.mLayoutInflater;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Deprecated
    public LayoutInflater getLayoutInflater(@Nullable Bundle savedFragmentState) {
        if (this.mHost == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater result = this.mHost.onGetLayoutInflater();
        getChildFragmentManager();
        LayoutInflaterCompat.setFactory2(result, this.mChildFragmentManager.getLayoutInflaterFactory());
        return result;
    }

    @CallSuper
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        this.mCalled = true;
        Activity hostActivity = this.mHost == null ? null : this.mHost.getActivity();
        if (hostActivity != null) {
            this.mCalled = false;
            onInflate(hostActivity, attrs, savedInstanceState);
        }
    }

    @CallSuper
    @Deprecated
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        this.mCalled = true;
    }

    public void onAttachFragment(Fragment childFragment) {
    }

    @CallSuper
    public void onAttach(Context context) {
        this.mCalled = true;
        Activity hostActivity = this.mHost == null ? null : this.mHost.getActivity();
        if (hostActivity != null) {
            this.mCalled = false;
            onAttach(hostActivity);
        }
    }

    @CallSuper
    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return null;
    }

    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        return null;
    }

    @CallSuper
    public void onCreate(@Nullable Bundle savedInstanceState) {
        this.mCalled = true;
        restoreChildFragmentState(savedInstanceState);
        if (this.mChildFragmentManager != null && !this.mChildFragmentManager.isStateAtLeast(1)) {
            this.mChildFragmentManager.dispatchCreate();
        }
    }

    public void restoreChildFragmentState(@Nullable Bundle savedInstanceState) {
        Parcelable p;
        if (savedInstanceState != null && (p = savedInstanceState.getParcelable("android:support:fragments")) != null) {
            if (this.mChildFragmentManager == null) {
                instantiateChildFragmentManager();
            }
            this.mChildFragmentManager.restoreAllState(p, this.mChildNonConfig);
            this.mChildNonConfig = null;
            this.mChildFragmentManager.dispatchCreate();
        }
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    }

    @Nullable
    public View getView() {
        return this.mView;
    }

    @CallSuper
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        this.mCalled = true;
    }

    @CallSuper
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        this.mCalled = true;
    }

    @CallSuper
    public void onStart() {
        this.mCalled = true;
    }

    @CallSuper
    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
    }

    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
    }

    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    public void onConfigurationChanged(Configuration newConfig) {
        this.mCalled = true;
    }

    @CallSuper
    public void onPause() {
        this.mCalled = true;
    }

    @CallSuper
    public void onStop() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    @CallSuper
    public void onLowMemory() {
        this.mCalled = true;
    }

    @CallSuper
    public void onDestroyView() {
        this.mCalled = true;
    }

    @CallSuper
    public void onDestroy() {
        boolean isChangingConfigurations = true;
        this.mCalled = true;
        FragmentActivity activity = getActivity();
        if (activity == null || !activity.isChangingConfigurations()) {
            isChangingConfigurations = false;
        }
        if (this.mViewModelStore != null && !isChangingConfigurations) {
            this.mViewModelStore.clear();
        }
    }

    public void initState() {
        this.mIndex = -1;
        this.mWho = null;
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = null;
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
        this.mRetaining = false;
    }

    @CallSuper
    public void onDetach() {
        this.mCalled = true;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onDestroyOptionsMenu() {
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getActivity().onCreateContextMenu(menu, v, menuInfo);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public boolean onContextItemSelected(MenuItem item) {
        return false;
    }

    public void setEnterSharedElementCallback(SharedElementCallback callback) {
        ensureAnimationInfo().mEnterTransitionCallback = callback;
    }

    public void setExitSharedElementCallback(SharedElementCallback callback) {
        ensureAnimationInfo().mExitTransitionCallback = callback;
    }

    public void setEnterTransition(@Nullable Object transition) {
        ensureAnimationInfo().mEnterTransition = transition;
    }

    @Nullable
    public Object getEnterTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mEnterTransition;
    }

    public void setReturnTransition(@Nullable Object transition) {
        ensureAnimationInfo().mReturnTransition = transition;
    }

    @Nullable
    public Object getReturnTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mReturnTransition == USE_DEFAULT_TRANSITION ? getEnterTransition() : this.mAnimationInfo.mReturnTransition;
    }

    public void setExitTransition(@Nullable Object transition) {
        ensureAnimationInfo().mExitTransition = transition;
    }

    @Nullable
    public Object getExitTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mExitTransition;
    }

    public void setReenterTransition(@Nullable Object transition) {
        ensureAnimationInfo().mReenterTransition = transition;
    }

    public Object getReenterTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mReenterTransition == USE_DEFAULT_TRANSITION ? getExitTransition() : this.mAnimationInfo.mReenterTransition;
    }

    public void setSharedElementEnterTransition(@Nullable Object transition) {
        ensureAnimationInfo().mSharedElementEnterTransition = transition;
    }

    @Nullable
    public Object getSharedElementEnterTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mSharedElementEnterTransition;
    }

    public void setSharedElementReturnTransition(@Nullable Object transition) {
        ensureAnimationInfo().mSharedElementReturnTransition = transition;
    }

    @Nullable
    public Object getSharedElementReturnTransition() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : this.mAnimationInfo.mSharedElementReturnTransition;
    }

    public void setAllowEnterTransitionOverlap(boolean allow) {
        ensureAnimationInfo().mAllowEnterTransitionOverlap = Boolean.valueOf(allow);
    }

    public boolean getAllowEnterTransitionOverlap() {
        if (this.mAnimationInfo == null || this.mAnimationInfo.mAllowEnterTransitionOverlap == null) {
            return true;
        }
        return this.mAnimationInfo.mAllowEnterTransitionOverlap.booleanValue();
    }

    public void setAllowReturnTransitionOverlap(boolean allow) {
        ensureAnimationInfo().mAllowReturnTransitionOverlap = Boolean.valueOf(allow);
    }

    public boolean getAllowReturnTransitionOverlap() {
        if (this.mAnimationInfo == null || this.mAnimationInfo.mAllowReturnTransitionOverlap == null) {
            return true;
        }
        return this.mAnimationInfo.mAllowReturnTransitionOverlap.booleanValue();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    public void startPostponedEnterTransition() {
        if (this.mFragmentManager == null || this.mFragmentManager.mHost == null) {
            ensureAnimationInfo().mEnterTransitionPostponed = false;
        } else if (Looper.myLooper() != this.mFragmentManager.mHost.getHandler().getLooper()) {
            this.mFragmentManager.mHost.getHandler().postAtFrontOfQueue(new Runnable() { // from class: androidx.fragment.app.Fragment.1
                @Override // java.lang.Runnable
                public void run() {
                    Fragment.this.callStartTransitionListener();
                }
            });
        } else {
            callStartTransitionListener();
        }
    }

    void callStartTransitionListener() {
        OnStartEnterTransitionListener listener;
        if (this.mAnimationInfo == null) {
            listener = null;
        } else {
            this.mAnimationInfo.mEnterTransitionPostponed = false;
            listener = this.mAnimationInfo.mStartEnterTransitionListener;
            this.mAnimationInfo.mStartEnterTransitionListener = null;
        }
        if (listener != null) {
            listener.onStartEnterTransition();
        }
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.print(prefix);
        writer.print("mFragmentId=#");
        writer.print(Integer.toHexString(this.mFragmentId));
        writer.print(" mContainerId=#");
        writer.print(Integer.toHexString(this.mContainerId));
        writer.print(" mTag=");
        writer.println(this.mTag);
        writer.print(prefix);
        writer.print("mState=");
        writer.print(this.mState);
        writer.print(" mIndex=");
        writer.print(this.mIndex);
        writer.print(" mWho=");
        writer.print(this.mWho);
        writer.print(" mBackStackNesting=");
        writer.println(this.mBackStackNesting);
        writer.print(prefix);
        writer.print("mAdded=");
        writer.print(this.mAdded);
        writer.print(" mRemoving=");
        writer.print(this.mRemoving);
        writer.print(" mFromLayout=");
        writer.print(this.mFromLayout);
        writer.print(" mInLayout=");
        writer.println(this.mInLayout);
        writer.print(prefix);
        writer.print("mHidden=");
        writer.print(this.mHidden);
        writer.print(" mDetached=");
        writer.print(this.mDetached);
        writer.print(" mMenuVisible=");
        writer.print(this.mMenuVisible);
        writer.print(" mHasMenu=");
        writer.println(this.mHasMenu);
        writer.print(prefix);
        writer.print("mRetainInstance=");
        writer.print(this.mRetainInstance);
        writer.print(" mRetaining=");
        writer.print(this.mRetaining);
        writer.print(" mUserVisibleHint=");
        writer.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            writer.print(prefix);
            writer.print("mFragmentManager=");
            writer.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            writer.print(prefix);
            writer.print("mHost=");
            writer.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            writer.print(prefix);
            writer.print("mParentFragment=");
            writer.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            writer.print(prefix);
            writer.print("mArguments=");
            writer.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            writer.print(prefix);
            writer.print("mSavedFragmentState=");
            writer.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            writer.print(prefix);
            writer.print("mSavedViewState=");
            writer.println(this.mSavedViewState);
        }
        if (this.mTarget != null) {
            writer.print(prefix);
            writer.print("mTarget=");
            writer.print(this.mTarget);
            writer.print(" mTargetRequestCode=");
            writer.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            writer.print(prefix);
            writer.print("mNextAnim=");
            writer.println(getNextAnim());
        }
        if (this.mContainer != null) {
            writer.print(prefix);
            writer.print("mContainer=");
            writer.println(this.mContainer);
        }
        if (this.mView != null) {
            writer.print(prefix);
            writer.print("mView=");
            writer.println(this.mView);
        }
        if (this.mInnerView != null) {
            writer.print(prefix);
            writer.print("mInnerView=");
            writer.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            writer.print(prefix);
            writer.print("mAnimatingAway=");
            writer.println(getAnimatingAway());
            writer.print(prefix);
            writer.print("mStateAfterAnimating=");
            writer.println(getStateAfterAnimating());
        }
        if (getContext() != null) {
            LoaderManager.getInstance(this).dump(prefix, fd, writer, args);
        }
        if (this.mChildFragmentManager != null) {
            writer.print(prefix);
            writer.println("Child " + this.mChildFragmentManager + ":");
            this.mChildFragmentManager.dump(prefix + "  ", fd, writer, args);
        }
    }

    public Fragment findFragmentByWho(String who) {
        if (who.equals(this.mWho)) {
            return this;
        }
        if (this.mChildFragmentManager != null) {
            return this.mChildFragmentManager.findFragmentByWho(who);
        }
        return null;
    }

    void instantiateChildFragmentManager() {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment has not been attached yet.");
        }
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mChildFragmentManager.attachController(this.mHost, new FragmentContainer() { // from class: androidx.fragment.app.Fragment.2
            @Override // androidx.fragment.app.FragmentContainer
            @Nullable
            public View onFindViewById(int id) {
                if (Fragment.this.mView != null) {
                    return Fragment.this.mView.findViewById(id);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }

            @Override // androidx.fragment.app.FragmentContainer
            public boolean onHasView() {
                return Fragment.this.mView != null;
            }

            @Override // androidx.fragment.app.FragmentContainer
            public Fragment instantiate(Context context, String className, Bundle arguments) {
                return Fragment.this.mHost.instantiate(context, className, arguments);
            }
        }, this);
    }

    public void performCreate(Bundle savedInstanceState) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }
        this.mState = 1;
        this.mCalled = false;
        onCreate(savedInstanceState);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public void performCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new LifecycleOwner() { // from class: androidx.fragment.app.Fragment.3
            @Override // androidx.lifecycle.LifecycleOwner
            public Lifecycle getLifecycle() {
                if (Fragment.this.mViewLifecycleRegistry == null) {
                    Fragment.this.mViewLifecycleRegistry = new LifecycleRegistry(Fragment.this.mViewLifecycleOwner);
                }
                return Fragment.this.mViewLifecycleRegistry;
            }
        };
        this.mViewLifecycleRegistry = null;
        this.mView = onCreateView(inflater, container, savedInstanceState);
        if (this.mView != null) {
            this.mViewLifecycleOwner.getLifecycle();
            this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
        } else if (this.mViewLifecycleRegistry != null) {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        } else {
            this.mViewLifecycleOwner = null;
        }
    }

    public void performActivityCreated(Bundle savedInstanceState) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(savedInstanceState);
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchActivityCreated();
        }
    }

    public void performStart() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
            this.mChildFragmentManager.execPendingActions();
        }
        this.mState = 3;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchStart();
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        if (this.mView != null) {
            this.mViewLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        }
    }

    public void performResume() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
            this.mChildFragmentManager.execPendingActions();
        }
        this.mState = 4;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchResume();
            this.mChildFragmentManager.execPendingActions();
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (this.mView != null) {
            this.mViewLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        }
    }

    public void noteStateNotSaved() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.noteStateNotSaved();
        }
    }

    public void performMultiWindowModeChanged(boolean isInMultiWindowMode) {
        onMultiWindowModeChanged(isInMultiWindowMode);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchMultiWindowModeChanged(isInMultiWindowMode);
        }
    }

    public void performPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        onPictureInPictureModeChanged(isInPictureInPictureMode);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchPictureInPictureModeChanged(isInPictureInPictureMode);
        }
    }

    public void performConfigurationChanged(Configuration newConfig) {
        onConfigurationChanged(newConfig);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchConfigurationChanged(newConfig);
        }
    }

    public void performLowMemory() {
        onLowMemory();
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchLowMemory();
        }
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean show = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            show = true;
            onCreateOptionsMenu(menu, inflater);
        }
        if (this.mChildFragmentManager != null) {
            return show | this.mChildFragmentManager.dispatchCreateOptionsMenu(menu, inflater);
        }
        return show;
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean show = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            show = true;
            onPrepareOptionsMenu(menu);
        }
        if (this.mChildFragmentManager != null) {
            return show | this.mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
        }
        return show;
    }

    public boolean performOptionsItemSelected(MenuItem item) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(item)) {
                return true;
            }
            if (this.mChildFragmentManager != null && this.mChildFragmentManager.dispatchOptionsItemSelected(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean performContextItemSelected(MenuItem item) {
        if (!this.mHidden) {
            if (onContextItemSelected(item)) {
                return true;
            }
            if (this.mChildFragmentManager != null && this.mChildFragmentManager.dispatchContextItemSelected(item)) {
                return true;
            }
        }
        return false;
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.dispatchOptionsMenuClosed(menu);
            }
        }
    }

    public void performSaveInstanceState(Bundle outState) {
        Parcelable p;
        onSaveInstanceState(outState);
        if (this.mChildFragmentManager != null && (p = this.mChildFragmentManager.saveAllState()) != null) {
            outState.putParcelable("android:support:fragments", p);
        }
    }

    public void performPause() {
        if (this.mView != null) {
            this.mViewLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchPause();
        }
        this.mState = 3;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    public void performStop() {
        if (this.mView != null) {
            this.mViewLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchStop();
        }
        this.mState = 2;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public void performDestroyView() {
        if (this.mView != null) {
            this.mViewLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchDestroyView();
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        LoaderManager.getInstance(this).markForRedelivery();
        this.mPerformedCreateView = false;
    }

    public void performDestroy() {
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchDestroy();
        }
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
        this.mChildFragmentManager = null;
    }

    public void performDetach() {
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
        } else if (this.mChildFragmentManager == null) {
        } else {
            if (!this.mRetaining) {
                throw new IllegalStateException("Child FragmentManager of " + this + " was not  destroyed and this fragment is not retaining instance");
            }
            this.mChildFragmentManager.dispatchDestroy();
            this.mChildFragmentManager = null;
        }
    }

    public void setOnStartEnterTransitionListener(OnStartEnterTransitionListener listener) {
        ensureAnimationInfo();
        if (listener != this.mAnimationInfo.mStartEnterTransitionListener) {
            if (listener == null || this.mAnimationInfo.mStartEnterTransitionListener == null) {
                if (this.mAnimationInfo.mEnterTransitionPostponed) {
                    this.mAnimationInfo.mStartEnterTransitionListener = listener;
                }
                if (listener != null) {
                    listener.startListening();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new AnimationInfo();
        }
        return this.mAnimationInfo;
    }

    public int getNextAnim() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.mNextAnim;
    }

    public void setNextAnim(int animResourceId) {
        if (this.mAnimationInfo != null || animResourceId != 0) {
            ensureAnimationInfo().mNextAnim = animResourceId;
        }
    }

    public int getNextTransition() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.mNextTransition;
    }

    public void setNextTransition(int nextTransition, int nextTransitionStyle) {
        if (this.mAnimationInfo != null || nextTransition != 0 || nextTransitionStyle != 0) {
            ensureAnimationInfo();
            this.mAnimationInfo.mNextTransition = nextTransition;
            this.mAnimationInfo.mNextTransitionStyle = nextTransitionStyle;
        }
    }

    public int getNextTransitionStyle() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.mNextTransitionStyle;
    }

    public SharedElementCallback getEnterTransitionCallback() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mEnterTransitionCallback;
    }

    public SharedElementCallback getExitTransitionCallback() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mExitTransitionCallback;
    }

    public View getAnimatingAway() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mAnimatingAway;
    }

    public void setAnimatingAway(View view) {
        ensureAnimationInfo().mAnimatingAway = view;
    }

    public void setAnimator(Animator animator) {
        ensureAnimationInfo().mAnimator = animator;
    }

    public Animator getAnimator() {
        if (this.mAnimationInfo == null) {
            return null;
        }
        return this.mAnimationInfo.mAnimator;
    }

    public int getStateAfterAnimating() {
        if (this.mAnimationInfo == null) {
            return 0;
        }
        return this.mAnimationInfo.mStateAfterAnimating;
    }

    public void setStateAfterAnimating(int state) {
        ensureAnimationInfo().mStateAfterAnimating = state;
    }

    public boolean isPostponed() {
        if (this.mAnimationInfo == null) {
            return false;
        }
        return this.mAnimationInfo.mEnterTransitionPostponed;
    }

    public boolean isHideReplaced() {
        if (this.mAnimationInfo == null) {
            return false;
        }
        return this.mAnimationInfo.mIsHideReplaced;
    }

    public void setHideReplaced(boolean replaced) {
        ensureAnimationInfo().mIsHideReplaced = replaced;
    }

    /* loaded from: classes.dex */
    public static class AnimationInfo {
        Boolean mAllowEnterTransitionOverlap;
        Boolean mAllowReturnTransitionOverlap;
        View mAnimatingAway;
        Animator mAnimator;
        boolean mEnterTransitionPostponed;
        boolean mIsHideReplaced;
        int mNextAnim;
        int mNextTransition;
        int mNextTransitionStyle;
        OnStartEnterTransitionListener mStartEnterTransitionListener;
        int mStateAfterAnimating;
        Object mEnterTransition = null;
        Object mReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
        Object mExitTransition = null;
        Object mReenterTransition = Fragment.USE_DEFAULT_TRANSITION;
        Object mSharedElementEnterTransition = null;
        Object mSharedElementReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
        SharedElementCallback mEnterTransitionCallback = null;
        SharedElementCallback mExitTransitionCallback = null;

        AnimationInfo() {
        }
    }
}