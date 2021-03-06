package com.google.appinventor.components.runtime.errors;

import com.google.appinventor.components.runtime.util.ErrorMessages;
import java.io.IOException;

/* loaded from: classes.dex */
public class RequestTimeoutException extends IOException {
    final int errorNumber = ErrorMessages.ERROR_WEB_REQUEST_TIMED_OUT;
}
