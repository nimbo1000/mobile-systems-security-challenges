package com.mobisec.fortnitepayload;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mobisec.fortnite.R;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Logger;

import dalvik.system.DexClassLoader;

public class Payload extends AppCompatActivity {

    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payload2);

        context = getApplicationContext();
    }

    public static void run() {
        Log.d("MOBISEC", "Run method");


        try {
            Class<?> c = Thread.currentThread().getContextClassLoader().loadClass("com.mobisec.fortnite.MainActivity");
            Field field = c.getDeclaredField("flag");
            field.setAccessible(true);
            Object value = field.get(new Object[0]);
            Log.d("MOBISEC", String.valueOf(value));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


//        Class<?> c = null;
//        try {
////            c = Class.forName("com.mobisec.plaku.fortnite.MainActivity");
//
//            Class<?> classToLoad = new DexClassLoader("/data/app/com.mobisec.plaku.fortnite-0Hx30DxJHAWeSaAynzoepA==/base.apk", "/data/app/com.mobisec.plaku.fortnite-0Hx30DxJHAWeSaAynzoepA==/base.apk", null, ClassLoader.getSystemClassLoader()).loadClass("com.mobisec.fortnite.MainActivity");
//
////            Object obj = c.newInstance();
//
//            Log.d("MOBISEC", String.valueOf(c.getDeclaredField("flag")));
//
//        } catch (ClassNotFoundException e) {
//            Log.d("MOBISEC", Log.getStackTraceString(e));
//        } catch (NoSuchFieldException e) {
//            Log.d("MOBISEC", Log.getStackTraceString(e));
//        }


//        if (context != null) {
//            Log.d("MOBISEC", context.getPackageName());
//        }
//        try {
//            Log.d("MOBISEC", "Trying to load main");
//            Object c = Payload.class.getClassLoader().getParent().loadClass("MainActivity").newInstance();
//            Log.d("MOBISEC", "getClass.getField " + String.valueOf(c.getClass().getDeclaredField("flag")));
//            Log.d("MOBISEC", c.getClass().getSimpleName());
//        } catch (IllegalAccessException e) {
//            Log.d("MOBISEC", Log.getStackTraceString(e));
//        } catch (InstantiationException e) {
//            Log.d("MOBISEC", Log.getStackTraceString(e));
//        } catch (ClassNotFoundException e) {
//            Log.d("MOBISEC", Log.getStackTraceString(e));
//        } catch (NoSuchFieldException e) {
//            Log.d("MOBISEC", Log.getStackTraceString(e));
//        }
    }
}
