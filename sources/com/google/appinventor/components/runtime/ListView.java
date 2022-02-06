package com.google.appinventor.components.runtime;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.util.ElementsUtil;
import com.google.appinventor.components.runtime.util.YailList;

@DesignerComponent(category = ComponentCategory.USERINTERFACE, description = "<p>This is a visible component that displays a list of text elements. <br> The list can be set using the ElementsFromString property or using the Elements block in the blocks editor. </p>", iconName = "images/listView.png", nonVisible = ListView.DEFAULT_ENABLED, version = 5)
@SimpleObject
/* loaded from: classes.dex */
public final class ListView extends AndroidViewComponent implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    private static final int DEFAULT_BACKGROUND_COLOR = -16777216;
    private static final boolean DEFAULT_ENABLED = false;
    private static final int DEFAULT_SELECTION_COLOR = -3355444;
    private static final int DEFAULT_TEXT_COLOR = -1;
    private static final int DEFAULT_TEXT_SIZE = 22;
    private static final String LOG_TAG = "ListView";
    private static final Drawable UNSELECTED_DRAWABLE = new ColorDrawable(0);
    private ArrayAdapter<Spannable> adapter;
    private ArrayAdapter<Spannable> adapterCopy;
    private int backgroundColor;
    protected final ComponentContainer container;
    private View lastSelected;
    private final LinearLayout listViewLayout;
    private String selection;
    private int selectionColor;
    private Drawable selectionDrawable;
    private int selectionIndex;
    private int textColor;
    private int textSize;
    private EditText txtSearchBox;
    private final android.widget.ListView view;
    private boolean showFilter = DEFAULT_ENABLED;
    private YailList items = YailList.makeEmptyList();

    public ListView(ComponentContainer container) {
        super(container);
        this.container = container;
        SelectionIndex(0);
        this.view = new android.widget.ListView(container.$context());
        this.view.setOnItemClickListener(this);
        this.view.setOnItemSelectedListener(this);
        this.view.setChoiceMode(1);
        this.view.setScrollingCacheEnabled(DEFAULT_ENABLED);
        this.view.setSelector(new StateListDrawable());
        this.listViewLayout = new LinearLayout(container.$context());
        this.listViewLayout.setOrientation(1);
        this.txtSearchBox = new EditText(container.$context());
        this.txtSearchBox.setSingleLine(true);
        this.txtSearchBox.setWidth(-2);
        this.txtSearchBox.setPadding(10, 10, 10, 10);
        this.txtSearchBox.setHint("Search list...");
        if (!AppInventorCompatActivity.isClassicMode()) {
            this.txtSearchBox.setBackgroundColor(-1);
        }
        this.txtSearchBox.addTextChangedListener(new TextWatcher() { // from class: com.google.appinventor.components.runtime.ListView.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                ListView.this.adapter.getFilter().filter(cs);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable arg0) {
            }
        });
        if (this.showFilter) {
            this.txtSearchBox.setVisibility(0);
        } else {
            this.txtSearchBox.setVisibility(8);
        }
        Width(-2);
        BackgroundColor(-16777216);
        SelectionColor(-3355444);
        this.textColor = -1;
        TextColor(this.textColor);
        this.textSize = 22;
        TextSize(this.textSize);
        ElementsFromString("");
        this.listViewLayout.addView(this.txtSearchBox);
        this.listViewLayout.addView(this.view);
        this.listViewLayout.requestLayout();
        container.$add(this);
    }

    @Override // com.google.appinventor.components.runtime.AndroidViewComponent
    public View getView() {
        return this.listViewLayout;
    }

    @Override // com.google.appinventor.components.runtime.AndroidViewComponent, com.google.appinventor.components.runtime.VisibleComponent
    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Determines the height of the list on the view.")
    public void Height(int height) {
        if (height == -1) {
            height = -2;
        }
        super.Height(height);
    }

    @Override // com.google.appinventor.components.runtime.AndroidViewComponent, com.google.appinventor.components.runtime.VisibleComponent
    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Determines the width of the list on the view.")
    public void Width(int width) {
        if (width == -1) {
            width = -2;
        }
        super.Width(width);
    }

    @SimpleProperty(description = "Sets visibility of ShowFilterBar. True will show the bar, False will hide it.")
    @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void ShowFilterBar(boolean showFilter) {
        this.showFilter = showFilter;
        if (showFilter) {
            this.txtSearchBox.setVisibility(0);
        } else {
            this.txtSearchBox.setVisibility(8);
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns current state of ShowFilterBar for visibility.")
    public boolean ShowFilterBar() {
        return this.showFilter;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "List of text elements to show in the ListView.  This will signal an error if the elements are not text strings.")
    public void Elements(YailList itemsList) {
        this.items = ElementsUtil.elements(itemsList, "Listview");
        setAdapterData();
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public YailList Elements() {
        return this.items;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The TextView elements specified as a string with the items separated by commas such as: Cheese,Fruit,Bacon,Radish. Each word before the comma will be an element in the list.")
    @DesignerProperty(defaultValue = "", editorType = PropertyTypeConstants.PROPERTY_TYPE_TEXTAREA)
    public void ElementsFromString(String itemstring) {
        this.items = ElementsUtil.elementsFromString(itemstring);
        setAdapterData();
    }

    public void setAdapterData() {
        this.adapter = new ArrayAdapter<>(this.container.$context(), 17367043, itemsToColoredText());
        this.view.setAdapter((ListAdapter) this.adapter);
        this.adapterCopy = new ArrayAdapter<>(this.container.$context(), 17367043);
        for (int i = 0; i < this.adapter.getCount(); i++) {
            this.adapterCopy.insert(this.adapter.getItem(i), i);
        }
    }

    public Spannable[] itemsToColoredText() {
        int size = this.items.size();
        int displayTextSize = this.textSize;
        Spannable[] objects = new Spannable[size];
        for (int i = 1; i <= size; i++) {
            Spannable chars = new SpannableString(YailList.YailListElementToString(this.items.get(i)));
            chars.setSpan(new ForegroundColorSpan(this.textColor), 0, chars.length(), 0);
            this.container.$form();
            if (!Form.getCompatibilityMode()) {
                displayTextSize = (int) (this.textSize * this.container.$form().deviceDensity());
            }
            chars.setSpan(new AbsoluteSizeSpan(displayTextSize), 0, chars.length(), 0);
            objects[i - 1] = chars;
        }
        return objects;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The index of the currently selected item, starting at 1.  If no item is selected, the value will be 0.  If an attempt is made to set this to a number less than 1 or greater than the number of items in the ListView, SelectionIndex will be set to 0, and Selection will be set to the empty text.")
    public int SelectionIndex() {
        return this.selectionIndex;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Specifies the position of the selected item in the ListView. This could be used to retrievethe text at the chosen position. If an attempt is made to set this to a number less than 1 or greater than the number of items in the ListView, SelectionIndex will be set to 0, and Selection will be set to the empty text.")
    public void SelectionIndex(int index) {
        this.selectionIndex = ElementsUtil.selectionIndex(index, this.items);
        this.selection = ElementsUtil.setSelectionFromIndex(index, this.items);
        updateSelectionIndex();
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the text last selected in the ListView.")
    public String Selection() {
        return this.selection;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "", editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING)
    public void Selection(String value) {
        this.selection = value;
        this.selectionIndex = ElementsUtil.setSelectedIndexFromValue(value, this.items);
        updateSelectionIndex();
    }

    private void updateSelectionIndex() {
        if (this.selectionIndex > 0) {
            View previousView = this.container.$form().getCurrentFocus();
            this.view.requestFocusFromTouch();
            this.view.setSelection(this.selectionIndex - 1);
            if (previousView != null) {
                previousView.requestFocus();
            }
        } else if (this.lastSelected != null) {
            this.lastSelected.setBackgroundDrawable(UNSELECTED_DRAWABLE);
            this.lastSelected = null;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Spannable item = (Spannable) parent.getAdapter().getItem(position);
        this.selection = item.toString();
        this.selectionIndex = this.adapterCopy.getPosition(item) + 1;
        if (this.lastSelected != null) {
            this.lastSelected.setBackgroundDrawable(UNSELECTED_DRAWABLE);
        }
        view.setBackgroundDrawable(this.selectionDrawable);
        this.lastSelected = view;
        AfterPicking();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        onItemClick(adapterView, view, i, l);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @SimpleEvent(description = "Simple event to be raised after the an element has been chosen in the list. The selected element is available in the Selection property.")
    public void AfterPicking() {
        EventDispatcher.dispatchEvent(this, "AfterPicking", new Object[0]);
    }

    public void setBackgroundColor(int color) {
        this.backgroundColor = color;
        this.view.setBackgroundColor(this.backgroundColor);
        this.listViewLayout.setBackgroundColor(this.backgroundColor);
        this.view.setCacheColorHint(this.backgroundColor);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The color of the listview background.")
    public int BackgroundColor() {
        return this.backgroundColor;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = Component.DEFAULT_VALUE_COLOR_BLACK, editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR)
    public void BackgroundColor(int argb) {
        this.backgroundColor = argb;
        setBackgroundColor(this.backgroundColor);
    }

    @SimpleProperty(description = "The color of the item when it is selected.")
    public int SelectionColor() {
        return this.selectionColor;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = Component.DEFAULT_VALUE_COLOR_LTGRAY, editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR)
    public void SelectionColor(int argb) {
        this.selectionColor = argb;
        this.selectionDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{argb, argb});
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The text color of the listview items.")
    public int TextColor() {
        return this.textColor;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = Component.DEFAULT_VALUE_COLOR_WHITE, editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR)
    public void TextColor(int argb) {
        this.textColor = argb;
        setAdapterData();
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The text size of the listview items.")
    public int TextSize() {
        return this.textSize;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "22", editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER)
    public void TextSize(int fontSize) {
        if (fontSize > 1000) {
            this.textSize = 999;
        } else {
            this.textSize = fontSize;
        }
        setAdapterData();
    }
}
