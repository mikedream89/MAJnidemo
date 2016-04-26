package com.example.mark.jnidemo;

/**
 * Created by mark on 16-4-22.
 */
public class JniUtils {
    static {
        System.loadLibrary("NdkJniDemo");//之前在build.gradle里面设置的so名字，必须一致
    }

    public static native String getStringFormC();

    public static native String getStringFormC2();

    public static native int getIntC(int a, int b);

}
