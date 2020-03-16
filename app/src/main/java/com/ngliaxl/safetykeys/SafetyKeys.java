package com.ngliaxl.safetykeys;

public class SafetyKeys {

    static {
        System.loadLibrary("SafetyKeys");
    }
    public native String nativeAccessKey();

}
