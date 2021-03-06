package com.google.appinventor.components.annotations.androidmanifest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface PathPermissionElement {
    String path() default "";

    String pathPattern() default "";

    String pathPrefix() default "";

    String permission() default "";

    String readPermission() default "";

    String writePermission() default "";
}
