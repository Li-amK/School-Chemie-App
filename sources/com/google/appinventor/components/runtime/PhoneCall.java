package com.google.appinventor.components.runtime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.telephony.TelephonyManager;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.util.BulkPermissionRequest;
import com.google.appinventor.components.runtime.util.PhoneCallUtil;
import kawa.lang.SyntaxForms;

@DesignerComponent(category = ComponentCategory.SOCIAL, description = "<p>A non-visible component that makes a phone call to the number specified in the <code>PhoneNumber</code> property, which can be set either in the Designer or Blocks Editor. The component has a <code>MakePhoneCall</code> method, enabling the program to launch a phone call.</p><p>Often, this component is used with the <code>ContactPicker</code> component, which lets the user select a contact from the ones stored on the phone and sets the <code>PhoneNumber</code> property to the contact's phone number.</p><p>To directly specify the phone number (e.g., 650-555-1212), set the <code>PhoneNumber</code> property to a Text with the specified digits (e.g., \"6505551212\").  Dashes, dots, and parentheses may be included (e.g., \"(650)-555-1212\") but will be ignored; spaces may not be included.</p>", iconName = "images/phoneCall.png", nonVisible = SyntaxForms.DEBUGGING, version = 3)
@SimpleObject
/* loaded from: classes.dex */
public class PhoneCall extends AndroidNonvisibleComponent implements Component, OnDestroyListener, ActivityResultListener {
    private static final int PHONECALL_REQUEST_CODE = 1346916174;
    private final Context context;
    private String phoneNumber;
    private boolean havePermission = false;
    private boolean didRegisterReceiver = false;
    private final CallStateReceiver callStateReceiver = new CallStateReceiver();

    public PhoneCall(ComponentContainer container) {
        super(container.$form());
        this.context = container.$context();
        this.form.registerForOnDestroy(this);
        this.form.registerForActivityResult(this, PHONECALL_REQUEST_CODE);
        PhoneNumber("");
    }

    public void Initialize() {
        if (this.form.doesAppDeclarePermission("android.permission.READ_CALL_LOG")) {
            this.form.askPermission(new BulkPermissionRequest(this, "Initialize", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.READ_PHONE_STATE", "android.permission.READ_CALL_LOG") { // from class: com.google.appinventor.components.runtime.PhoneCall.1
                @Override // com.google.appinventor.components.runtime.util.BulkPermissionRequest
                public void onGranted() {
                    PhoneCall.this.registerCallStateMonitor();
                }
            });
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String PhoneNumber() {
        return this.phoneNumber;
    }

    @SimpleProperty
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING)
    public void PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @SimpleFunction(description = "Launches the default dialer app set to start a phone call usingthe number in the PhoneNumber property.")
    public void MakePhoneCall() {
        Intent i = new Intent("android.intent.action.DIAL", Uri.fromParts("tel", this.phoneNumber, null));
        if (i.resolveActivity(this.form.getPackageManager()) != null) {
            this.form.startActivityForResult(i, PHONECALL_REQUEST_CODE);
        }
    }

    @SimpleFunction(description = "Directly initiates a phone call using the number in the PhoneNumber property.")
    @UsesPermissions({"android.permission.CALL_PHONE"})
    public void MakePhoneCallDirect() {
        if (!this.havePermission) {
            this.form.askPermission("android.permission.CALL_PHONE", new PermissionResultHandler() { // from class: com.google.appinventor.components.runtime.PhoneCall.2
                @Override // com.google.appinventor.components.runtime.PermissionResultHandler
                public void HandlePermissionResponse(String permission, boolean granted) {
                    if (granted) {
                        PhoneCall.this.havePermission = true;
                        PhoneCall.this.MakePhoneCallDirect();
                        return;
                    }
                    PhoneCall.this.form.dispatchPermissionDeniedEvent(PhoneCall.this, "MakePhoneCall", "android.permission.CALL_PHONE");
                }
            });
        } else {
            PhoneCallUtil.makePhoneCall(this.context, this.phoneNumber);
        }
    }

    @UsesPermissions({"android.permission.PROCESS_OUTGOING_CALLS", "android.permission.READ_CALL_LOG", "android.permission.READ_PHONE_STATE"})
    @SimpleEvent(description = "Event indicating that a phonecall has started. If status is 1, incoming call is ringing; if status is 2, outgoing call is dialled. phoneNumber is the incoming/outgoing phone number.")
    public void PhoneCallStarted(int status, String phoneNumber) {
        EventDispatcher.dispatchEvent(this, "PhoneCallStarted", Integer.valueOf(status), phoneNumber);
    }

    @UsesPermissions({"android.permission.PROCESS_OUTGOING_CALLS", "android.permission.READ_CALL_LOG", "android.permission.READ_PHONE_STATE"})
    @SimpleEvent(description = "Event indicating that a phone call has ended. If status is 1, incoming call is missed or rejected; if status is 2, incoming call is answered before hanging up; if status is 3, outgoing call is hung up. phoneNumber is the ended call phone number.")
    public void PhoneCallEnded(int status, String phoneNumber) {
        EventDispatcher.dispatchEvent(this, "PhoneCallEnded", Integer.valueOf(status), phoneNumber);
    }

    @UsesPermissions({"android.permission.PROCESS_OUTGOING_CALLS", "android.permission.READ_CALL_LOG", "android.permission.READ_PHONE_STATE"})
    @SimpleEvent(description = "Event indicating that an incoming phone call is answered. phoneNumber is the incoming call phone number.")
    public void IncomingCallAnswered(String phoneNumber) {
        EventDispatcher.dispatchEvent(this, "IncomingCallAnswered", phoneNumber);
    }

    @Override // com.google.appinventor.components.runtime.ActivityResultListener
    public void resultReturned(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHONECALL_REQUEST_CODE) {
            PhoneCallStarted(2, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class CallStateReceiver extends BroadcastReceiver {
        private int status = 0;
        private String number = "";

        public CallStateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.PHONE_STATE".equals(action)) {
                String state = intent.getStringExtra("state");
                if (TelephonyManager.EXTRA_STATE_RINGING.equals(state)) {
                    this.status = 1;
                    this.number = intent.getStringExtra("incoming_number");
                    if (this.number != null) {
                        PhoneCall.this.PhoneCallStarted(1, this.number);
                    }
                } else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(state)) {
                    if (this.status == 1) {
                        this.status = 3;
                        PhoneCall.this.IncomingCallAnswered(this.number);
                    }
                } else if (TelephonyManager.EXTRA_STATE_IDLE.equals(state)) {
                    if (this.status == 1) {
                        PhoneCall.this.PhoneCallEnded(1, this.number);
                    } else if (this.status == 3) {
                        PhoneCall.this.PhoneCallEnded(2, this.number);
                    } else if (this.status == 2) {
                        PhoneCall.this.PhoneCallEnded(3, this.number);
                    }
                    this.status = 0;
                    this.number = "";
                }
            } else if ("android.intent.action.NEW_OUTGOING_CALL".equals(action)) {
                this.status = 2;
                this.number = intent.getStringExtra("android.intent.extra.PHONE_NUMBER");
                PhoneCall.this.PhoneCallStarted(2, this.number);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerCallStateMonitor() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        this.context.registerReceiver(this.callStateReceiver, intentFilter);
        this.didRegisterReceiver = true;
    }

    private void unregisterCallStateMonitor() {
        if (this.didRegisterReceiver) {
            this.context.unregisterReceiver(this.callStateReceiver);
            this.didRegisterReceiver = false;
        }
    }

    @Override // com.google.appinventor.components.runtime.OnDestroyListener
    public void onDestroy() {
        unregisterCallStateMonitor();
    }
}
