package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import kawa.lang.SyntaxForms;

@DesignerComponent(category = ComponentCategory.LEGOMINDSTORMS, description = "A component that provides a high-level interface to an ultrasonic sensor on a LEGO MINDSTORMS EV3 robot.", iconName = "images/legoMindstormsEv3.png", nonVisible = SyntaxForms.DEBUGGING, version = 1)
@SimpleObject
/* loaded from: classes.dex */
public class Ev3UltrasonicSensor extends LegoMindstormsEv3Sensor implements Deleteable {
    private static final int DEFAULT_BOTTOM_OF_RANGE = 30;
    private static final String DEFAULT_SENSOR_MODE_STRING = "cm";
    private static final int DEFAULT_TOP_OF_RANGE = 90;
    private static final int DELAY_MILLISECONDS = 50;
    private static final int SENSOR_MODE_CM = 0;
    private static final String SENSOR_MODE_CM_STRING = "cm";
    private static final int SENSOR_MODE_INCH = 1;
    private static final String SENSOR_MODE_INCH_STRING = "inch";
    private static final int SENSOR_TYPE = 30;
    private boolean aboveRangeEventEnabled;
    private boolean belowRangeEventEnabled;
    private int bottomOfRange;
    private int topOfRange;
    private boolean withinRangeEventEnabled;
    private String modeString = "cm";
    private int mode = 0;
    private double previousDistance = -1.0d;
    private Handler eventHandler = new Handler();
    private final Runnable sensorValueChecker = new Runnable() { // from class: com.google.appinventor.components.runtime.Ev3UltrasonicSensor.1
        @Override // java.lang.Runnable
        public void run() {
            if (Ev3UltrasonicSensor.this.bluetooth != null && Ev3UltrasonicSensor.this.bluetooth.IsConnected()) {
                double currentDistance = Ev3UltrasonicSensor.this.getDistance("");
                if (Ev3UltrasonicSensor.this.previousDistance < 0.0d) {
                    Ev3UltrasonicSensor.this.previousDistance = currentDistance;
                    Ev3UltrasonicSensor.this.eventHandler.postDelayed(this, 50L);
                    return;
                }
                if (currentDistance < Ev3UltrasonicSensor.this.bottomOfRange) {
                    if (Ev3UltrasonicSensor.this.belowRangeEventEnabled && Ev3UltrasonicSensor.this.previousDistance >= Ev3UltrasonicSensor.this.bottomOfRange) {
                        Ev3UltrasonicSensor.this.BelowRange();
                    }
                } else if (currentDistance > Ev3UltrasonicSensor.this.topOfRange) {
                    if (Ev3UltrasonicSensor.this.aboveRangeEventEnabled && Ev3UltrasonicSensor.this.previousDistance <= Ev3UltrasonicSensor.this.topOfRange) {
                        Ev3UltrasonicSensor.this.AboveRange();
                    }
                } else if (Ev3UltrasonicSensor.this.withinRangeEventEnabled && (Ev3UltrasonicSensor.this.previousDistance < Ev3UltrasonicSensor.this.bottomOfRange || Ev3UltrasonicSensor.this.previousDistance > Ev3UltrasonicSensor.this.topOfRange)) {
                    Ev3UltrasonicSensor.this.WithinRange();
                }
                Ev3UltrasonicSensor.this.previousDistance = currentDistance;
            }
            Ev3UltrasonicSensor.this.eventHandler.postDelayed(this, 50L);
        }
    };

    public Ev3UltrasonicSensor(ComponentContainer container) {
        super(container, "Ev3UltrasonicSensor");
        this.eventHandler.post(this.sensorValueChecker);
        TopOfRange(90);
        BottomOfRange(30);
        BelowRangeEventEnabled(false);
        AboveRangeEventEnabled(false);
        WithinRangeEventEnabled(false);
        Unit("cm");
    }

    @SimpleFunction(description = "Returns the current distance in centimeters as a value between 0 and 254, or -1 if the distance can not be read.")
    public double GetDistance() {
        return getDistance("GetDistance");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double getDistance(String functionName) {
        double distance = readInputSI(functionName, 0, this.sensorPortNumber, 30, this.mode);
        if (distance == 255.0d) {
            return -1.0d;
        }
        return distance;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The bottom of the range used for the BelowRange, WithinRange, and AboveRange events.")
    public int BottomOfRange() {
        return this.bottomOfRange;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "30", editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER)
    public void BottomOfRange(int bottomOfRange) {
        this.bottomOfRange = bottomOfRange;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The top of the range used for the BelowRange, WithinRange, and AboveRange events.")
    public int TopOfRange() {
        return this.topOfRange;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "90", editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER)
    public void TopOfRange(int topOfRange) {
        this.topOfRange = topOfRange;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the BelowRange event should fire when the distance goes below the BottomOfRange.")
    public boolean BelowRangeEventEnabled() {
        return this.belowRangeEventEnabled;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void BelowRangeEventEnabled(boolean enabled) {
        this.belowRangeEventEnabled = enabled;
    }

    @SimpleEvent(description = "Called when the detected distance has gone below the range.")
    public void BelowRange() {
        EventDispatcher.dispatchEvent(this, "BelowRange", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the WithinRange event should fire when the distance goes between the BottomOfRange and the TopOfRange.")
    public boolean WithinRangeEventEnabled() {
        return this.withinRangeEventEnabled;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void WithinRangeEventEnabled(boolean enabled) {
        this.withinRangeEventEnabled = enabled;
    }

    @SimpleEvent(description = "Called when the detected distance has gone within the range.")
    public void WithinRange() {
        EventDispatcher.dispatchEvent(this, "WithinRange", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the AboveRange event should fire when the distance goes above the TopOfRange.")
    public boolean AboveRangeEventEnabled() {
        return this.aboveRangeEventEnabled;
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void AboveRangeEventEnabled(boolean enabled) {
        this.aboveRangeEventEnabled = enabled;
    }

    @SimpleEvent(description = "Called when the detected distance has gone above the range.")
    public void AboveRange() {
        EventDispatcher.dispatchEvent(this, "AboveRange", new Object[0]);
    }

    @SimpleProperty
    @DesignerProperty(defaultValue = "cm", editorType = PropertyTypeConstants.PROPERTY_TYPE_LEGO_EV3_ULTRASONIC_SENSOR_MODE)
    public void Unit(String unitName) {
        try {
            setMode(unitName);
        } catch (IllegalArgumentException e) {
            this.form.dispatchErrorOccurredEvent(this, "Unit", ErrorMessages.ERROR_EV3_ILLEGAL_ARGUMENT, "Unit");
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The distance unit, which can be either \"cm\" or \"inch\".")
    public String Unit() {
        return this.modeString;
    }

    @SimpleFunction(description = "Measure the distance in centimeters.")
    public void SetCmUnit() {
        try {
            setMode("cm");
        } catch (IllegalArgumentException e) {
            this.form.dispatchErrorOccurredEvent(this, "SetCmUnit", ErrorMessages.ERROR_EV3_ILLEGAL_ARGUMENT, "SetCmUnit");
        }
    }

    @SimpleFunction(description = "Measure the distance in inches.")
    public void SetInchUnit() {
        try {
            setMode(SENSOR_MODE_INCH_STRING);
        } catch (IllegalArgumentException e) {
            this.form.dispatchErrorOccurredEvent(this, "SetInchUnit", ErrorMessages.ERROR_EV3_ILLEGAL_ARGUMENT, "SetInchUnit");
        }
    }

    private void setMode(String newModeString) {
        this.previousDistance = -1.0d;
        if ("cm".equals(newModeString)) {
            this.mode = 0;
        } else if (SENSOR_MODE_INCH_STRING.equals(newModeString)) {
            this.mode = 1;
        } else {
            throw new IllegalArgumentException();
        }
        this.modeString = newModeString;
    }

    @Override // com.google.appinventor.components.runtime.LegoMindstormsEv3Base, com.google.appinventor.components.runtime.Deleteable
    public void onDelete() {
        this.eventHandler.removeCallbacks(this.sensorValueChecker);
        super.onDelete();
    }
}
