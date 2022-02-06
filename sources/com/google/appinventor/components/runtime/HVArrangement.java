package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.util.AlignmentUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.ViewUtil;
import java.io.IOException;

@SimpleObject
/* loaded from: classes.dex */
public class HVArrangement extends AndroidViewComponent implements Component, ComponentContainer {
    private static final String LOG_TAG = "HVArrangement";
    private AlignmentUtil alignmentSetter;
    private int backgroundColor;
    private Drawable backgroundImageDrawable;
    private final Activity context;
    private Drawable defaultButtonDrawable;
    private ViewGroup frameContainer;
    private final int orientation;
    private boolean scrollable;
    private final LinearLayout viewLayout;
    private String imagePath = "";
    private final Handler androidUIHandler = new Handler();
    private int horizontalAlignment = 1;
    private int verticalAlignment = 1;

    public HVArrangement(ComponentContainer container, int orientation, boolean scrollable) {
        super(container);
        this.scrollable = false;
        this.context = container.$context();
        this.orientation = orientation;
        this.scrollable = scrollable;
        this.viewLayout = new LinearLayout(this.context, orientation, 100, 100);
        this.viewLayout.setBaselineAligned(false);
        this.alignmentSetter = new AlignmentUtil(this.viewLayout);
        this.alignmentSetter.setHorizontalAlignment(this.horizontalAlignment);
        this.alignmentSetter.setVerticalAlignment(this.verticalAlignment);
        if (scrollable) {
            switch (orientation) {
                case 0:
                    Log.d(LOG_TAG, "Setting up frameContainer = HorizontalScrollView()");
                    this.frameContainer = new HorizontalScrollView(this.context);
                    break;
                case 1:
                    Log.d(LOG_TAG, "Setting up frameContainer = ScrollView()");
                    this.frameContainer = new ScrollView(this.context);
                    break;
            }
        } else {
            Log.d(LOG_TAG, "Setting up frameContainer = FrameLayout()");
            this.frameContainer = new FrameLayout(this.context);
        }
        this.frameContainer.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
        this.frameContainer.addView(this.viewLayout.getLayoutManager(), new ViewGroup.LayoutParams(-1, -1));
        this.defaultButtonDrawable = getView().getBackground();
        container.$add(this);
        BackgroundColor(0);
    }

    @Override // com.google.appinventor.components.runtime.ComponentContainer
    public Activity $context() {
        return this.context;
    }

    @Override // com.google.appinventor.components.runtime.ComponentContainer
    public Form $form() {
        return this.container.$form();
    }

    @Override // com.google.appinventor.components.runtime.ComponentContainer
    public void $add(AndroidViewComponent component) {
        this.viewLayout.add(component);
    }

    @Override // com.google.appinventor.components.runtime.ComponentContainer
    public void setChildWidth(AndroidViewComponent component, int width) {
        setChildWidth(component, width, 0);
    }

    public void setChildWidth(final AndroidViewComponent component, final int width, final int trycount) {
        int cWidth = this.container.$form().Width();
        if (cWidth == 0 && trycount < 2) {
            this.androidUIHandler.postDelayed(new Runnable() { // from class: com.google.appinventor.components.runtime.HVArrangement.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.d(HVArrangement.LOG_TAG, "(HVArrangement)Width not stable yet... trying again");
                    HVArrangement.this.setChildWidth(component, width, trycount + 1);
                }
            }, 100L);
        }
        if (width <= -1000) {
            Log.d(LOG_TAG, "HVArrangement.setChildWidth(): width = " + width + " parent Width = " + cWidth + " child = " + component);
            width = ((-(width + 1000)) * cWidth) / 100;
        }
        component.setLastWidth(width);
        if (this.orientation == 0) {
            ViewUtil.setChildWidthForHorizontalLayout(component.getView(), width);
        } else {
            ViewUtil.setChildWidthForVerticalLayout(component.getView(), width);
        }
    }

    @Override // com.google.appinventor.components.runtime.ComponentContainer
    public void setChildHeight(final AndroidViewComponent component, final int height) {
        int cHeight = this.container.$form().Height();
        if (cHeight == 0) {
            this.androidUIHandler.postDelayed(new Runnable() { // from class: com.google.appinventor.components.runtime.HVArrangement.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.d(HVArrangement.LOG_TAG, "(HVArrangement)Height not stable yet... trying again");
                    HVArrangement.this.setChildHeight(component, height);
                }
            }, 100L);
        }
        if (height <= -1000) {
            height = ((-(height + 1000)) * cHeight) / 100;
        }
        component.setLastHeight(height);
        if (this.orientation == 0) {
            ViewUtil.setChildHeightForHorizontalLayout(component.getView(), height);
        } else {
            ViewUtil.setChildHeightForVerticalLayout(component.getView(), height);
        }
    }

    @Override // com.google.appinventor.components.runtime.AndroidViewComponent
    public View getView() {
        return this.frameContainer;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "A number that encodes how contents of the %type% are aligned  horizontally. The choices are: 1 = left aligned, 2 = right aligned,  3 = horizontally centered.  Alignment has no effect if the arrangement's width is automatic.")
    public int AlignHorizontal() {
        return this.horizontalAlignment;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "1", editorType = PropertyTypeConstants.PROPERTY_TYPE_HORIZONTAL_ALIGNMENT)
    public void AlignHorizontal(int alignment) {
        try {
            this.alignmentSetter.setHorizontalAlignment(alignment);
            this.horizontalAlignment = alignment;
        } catch (IllegalArgumentException e) {
            this.container.$form().dispatchErrorOccurredEvent(this, "HorizontalAlignment", ErrorMessages.ERROR_BAD_VALUE_FOR_HORIZONTAL_ALIGNMENT, Integer.valueOf(alignment));
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "A number that encodes how the contents of the %type% are aligned  vertically. The choices are: 1 = aligned at the top, 2 = vertically centered, 3 = aligned at the bottom.  Alignment has no effect if the arrangement's height is automatic.")
    public int AlignVertical() {
        return this.verticalAlignment;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "1", editorType = PropertyTypeConstants.PROPERTY_TYPE_VERTICAL_ALIGNMENT)
    public void AlignVertical(int alignment) {
        try {
            this.alignmentSetter.setVerticalAlignment(alignment);
            this.verticalAlignment = alignment;
        } catch (IllegalArgumentException e) {
            this.container.$form().dispatchErrorOccurredEvent(this, "VerticalAlignment", ErrorMessages.ERROR_BAD_VALUE_FOR_VERTICAL_ALIGNMENT, Integer.valueOf(alignment));
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Returns the background color of the %type%")
    public int BackgroundColor() {
        return this.backgroundColor;
    }

    @SimpleProperty(description = "Specifies the background color of the %type%. The background color will not be visible if an Image is being displayed.")
    @DesignerProperty(defaultValue = Component.DEFAULT_VALUE_COLOR_DEFAULT, editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR)
    public void BackgroundColor(int argb) {
        this.backgroundColor = argb;
        updateAppearance();
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public String Image() {
        return this.imagePath;
    }

    @SimpleProperty(description = "Specifies the path of the background image for the %type%.  If there is both an Image and a BackgroundColor, only the Image will be visible.")
    @DesignerProperty(defaultValue = "", editorType = PropertyTypeConstants.PROPERTY_TYPE_ASSET)
    public void Image(String path) {
        if (!path.equals(this.imagePath) || this.backgroundImageDrawable == null) {
            if (path == null) {
                path = "";
            }
            this.imagePath = path;
            this.backgroundImageDrawable = null;
            if (this.imagePath.length() > 0) {
                try {
                    this.backgroundImageDrawable = MediaUtil.getBitmapDrawable(this.container.$form(), this.imagePath);
                } catch (IOException e) {
                }
            }
            updateAppearance();
        }
    }

    private void updateAppearance() {
        if (this.backgroundImageDrawable != null) {
            ViewUtil.setBackgroundImage(this.viewLayout.getLayoutManager(), this.backgroundImageDrawable);
        } else if (this.backgroundColor == 0) {
            ViewUtil.setBackgroundDrawable(this.viewLayout.getLayoutManager(), this.defaultButtonDrawable);
        } else {
            ViewUtil.setBackgroundDrawable(this.viewLayout.getLayoutManager(), null);
            this.viewLayout.getLayoutManager().setBackgroundColor(this.backgroundColor);
        }
    }
}
