package com.google.appinventor.components.runtime;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import kawa.lang.SyntaxForms;

@DesignerComponent(category = ComponentCategory.SENSORS, description = "<p>Non-visible component that can measure angular velocity in three dimensions in units of degrees per second.</p><p>In order to function, the component must have its <code>Enabled</code> property set to True, and the device must have a gyroscope sensor.</p>", iconName = "images/gyroscopesensor.png", nonVisible = SyntaxForms.DEBUGGING, version = 1)
@SimpleObject
/* loaded from: classes.dex */
public class GyroscopeSensor extends AndroidNonvisibleComponent implements SensorEventListener, Deleteable, OnPauseListener, OnResumeListener {
    private boolean enabled;
    private boolean listening;
    private float xAngularVelocity;
    private float yAngularVelocity;
    private float zAngularVelocity;
    private final SensorManager sensorManager = (SensorManager) this.form.getSystemService("sensor");
    private final Sensor gyroSensor = this.sensorManager.getDefaultSensor(4);

    public GyroscopeSensor(ComponentContainer container) {
        super(container.$form());
        this.form.registerForOnResume(this);
        this.form.registerForOnPause(this);
        Enabled(true);
    }

    private void startListening() {
        if (!this.listening) {
            this.sensorManager.registerListener(this, this.gyroSensor, 0);
            this.listening = true;
        }
    }

    private void stopListening() {
        if (this.listening) {
            this.sensorManager.unregisterListener(this);
            this.listening = false;
            this.xAngularVelocity = 0.0f;
            this.yAngularVelocity = 0.0f;
            this.zAngularVelocity = 0.0f;
        }
    }

    @SimpleEvent(description = "Indicates that the gyroscope sensor data has changed. The timestamp parameter is the time in nanoseconds at which the event occurred.")
    public void GyroscopeChanged(float xAngularVelocity, float yAngularVelocity, float zAngularVelocity, long timestamp) {
        EventDispatcher.dispatchEvent(this, "GyroscopeChanged", Float.valueOf(xAngularVelocity), Float.valueOf(yAngularVelocity), Float.valueOf(zAngularVelocity), Long.valueOf(timestamp));
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Indicates whether a gyroscope sensor is available.")
    public boolean Available() {
        return this.sensorManager.getSensorList(4).size() > 0;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean Enabled() {
        return this.enabled;
    }

    @SimpleProperty(description = "If enabled, then sensor events will be generated and XAngularVelocity, YAngularVelocity, and ZAngularVelocity properties will have meaningful values.")
    @DesignerProperty(defaultValue = "True", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
    public void Enabled(boolean enabled) {
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (enabled) {
                startListening();
            } else {
                stopListening();
            }
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The angular velocity around the X axis, in degrees per second.")
    public float XAngularVelocity() {
        return this.xAngularVelocity;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The angular velocity around the Y axis, in degrees per second.")
    public float YAngularVelocity() {
        return this.yAngularVelocity;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The angular velocity around the Z axis, in degrees per second.")
    public float ZAngularVelocity() {
        return this.zAngularVelocity;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.enabled) {
            this.xAngularVelocity = (float) Math.toDegrees(sensorEvent.values[0]);
            this.yAngularVelocity = (float) Math.toDegrees(sensorEvent.values[1]);
            this.zAngularVelocity = (float) Math.toDegrees(sensorEvent.values[2]);
            GyroscopeChanged(this.xAngularVelocity, this.yAngularVelocity, this.zAngularVelocity, sensorEvent.timestamp);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // com.google.appinventor.components.runtime.Deleteable
    public void onDelete() {
        stopListening();
    }

    @Override // com.google.appinventor.components.runtime.OnPauseListener
    public void onPause() {
        stopListening();
    }

    @Override // com.google.appinventor.components.runtime.OnResumeListener
    public void onResume() {
        if (this.enabled) {
            startListening();
        }
    }
}
