package com.mobisec.plaku.keyboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.mobisec.keyboard.R;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MainActivity extends AppCompatActivity {
    private static boolean DEFAULT_DEBUG_MODE = false;
    private static String GLOBAL_PREFS_NAME = "GlobalKeyboardPrefs";
    /* access modifiers changed from: private */
    public static String INFO_PREFS_NAME = "InfoKeyboardPrefs";
    private static String MY_PREFS_NAME = "KeyboardPrefs";
    static AssetManager assetManager;
    static boolean debug = false;
//    private void setFlag(Intent intent) {
//        String flag;
//        String str = "flag";
//        if (intent != null) {
//            flag = intent.getStringExtra(str);
//            if (flag == null) {
//                flag = "dummyflag";
//            }
//        } else {
//            flag = "dummyflag";
//        }
//        if (flag != null) {
//            Editor editor = getSharedPreferences(INFO_PREFS_NAME, 0).edit();
//            editor.putString(str, flag);
//            editor.commit();
//            Log.e("MOBISEC", "flag set correctly");
//        }
//    }

    public static void extractFolder(String zipFilePath) throws Exception {
        Log.d("MOBISEC", "extractFolder() String zipFilePath:" + zipFilePath );

        int currentByte;
        String str = zipFilePath;
        System.out.println(str);
        File zipFile = new File(str);
        ZipFile zip = new ZipFile(zipFile);
        String destDir = zipFile.getParent();
        Enumeration zipFileEntries = zip.entries();
        while (zipFileEntries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
            File destFile = new File(destDir, entry.getName());
            Log.d("MOBISEC", destFile.toString());
            destFile.getParentFile().mkdirs();
            if (!entry.isDirectory()) {
                BufferedInputStream is = new BufferedInputStream(zip.getInputStream(entry));
                byte[] data = new byte[2048];
                BufferedOutputStream dest = new BufferedOutputStream(new FileOutputStream(destFile), 2048);
                while (true) {
                    int read = is.read(data, 0, 2048);
                    currentByte = read;
                    if (read == -1) {
                        break;
                    }
                    dest.write(data, 0, currentByte);
                }
                dest.flush();
                dest.close();
                is.close();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);

        assetManager = getAssets();

//        setFlag(getIntent());
//        Button getflagButton = (Button) findViewById(R.id.getflag);
//        final TextView flagWidget = (TextView) findViewById(R.id.flag);
//        Editor editor = getSharedPreferences(MY_PREFS_NAME, 0).edit();
//        editor.putBoolean("debugmode", DEFAULT_DEBUG_MODE);
//        editor.commit();
//        Editor editor2 = getSharedPreferences(INFO_PREFS_NAME, 0).edit();
//        editor2.putString("author", "reyammer");
//        editor2.commit();
//        getflagButton.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                flagWidget.setText("Getting flag....");
//                flagWidget.setTextColor(ViewCompat.MEASURED_STATE_MASK);
//                try {
//                    flagWidget.setText(MainActivity.this.getSharedPreferences(MainActivity.INFO_PREFS_NAME, 0).getString("flag", "flagnotfound"));
//                } catch (Exception e) {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append("Exception while getting the flag:");
//                    sb.append(Log.getStackTraceString(e));
//                    Log.e("MOBISEC", sb.toString());
//                    flagWidget.setText("An error occurred when getting flag");
//                }
//            }
//        });

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                copyAssets();
                debug = !debug;
            }
        }, 2000, 5000);

//        new Timer().scheduleAtFixedRate(new TimerTask() {
//            public void run() {
////                MainActivity.checkForUpdates(MainActivity.this);
//                SharedPreferences globprefs = getApplicationContext().getSharedPreferences(GLOBAL_PREFS_NAME, 0);
//
//                for (Entry<String, ?> entry2 : globprefs.getAll().entrySet()) {
//                    StringBuilder sb3 = new StringBuilder();
//                    sb3.append((String) entry2.getKey());
//                    sb3.append(": ");
//                    sb3.append(entry2.getValue().toString());
//                    if(entry2.getValue().toString().equals("true"))
//                        debug = true;
//                    Log.e("MOBISEC", "pref " + sb3.toString());
//                }
//            }
//        }, 2000, 5000);


//        Log.d("MOBISEC", "MINE");
//

    }

    public static void checkForUpdates(Context ctx) {
        Log.d("MOBISEC", "checkForUpdates");

        String str;
        Context context = ctx;
        File zipFile = new File(Environment.getExternalStorageDirectory(), "update.zip");
        if (zipFile.exists()) {
            Log.d("MOBISEC", "if(zipFile.exists())=True");

            try {
                extractFolder(zipFile.getAbsolutePath());
            } catch (Exception e) {
                Log.d("MOBISEC", Log.getStackTraceString(e));
                e = e;
                StringBuilder sb = new StringBuilder();
                sb.append("Exception while extracting the zip:");
                sb.append(Log.getStackTraceString(e));
                String str2 = "MOBISEC";
                Log.e(str2, sb.toString());
                SharedPreferences myprefs = context.getSharedPreferences(MY_PREFS_NAME, 0);
                SharedPreferences globprefs = context.getSharedPreferences(GLOBAL_PREFS_NAME, 0);
                SharedPreferences infoprefs = context.getSharedPreferences(INFO_PREFS_NAME, 0);
                Editor editor = globprefs.edit();
                String str3 = "crashes";
                editor.putInt(str3, globprefs.getInt(str3, 0) + 1);
                editor.commit();
                String str4 = "debugmode";
                boolean debugMode = myprefs.getBoolean(str4, false);
                boolean globDebugMode = globprefs.getBoolean(str4, false);
                if (debugMode || globDebugMode) {
                    Log.e(str2, "dumping all info for debugging");
                    Iterator it = myprefs.getAll().entrySet().iterator();
                    while (true) {
                        str = ": ";
                        if (!it.hasNext()) {
                            break;
                        }
                        Entry<String, ?> entry = (Entry) it.next();
                        StringBuilder sb2 = new StringBuilder();
                        Exception e2 = e;
                        sb2.append((String) entry.getKey());
                        sb2.append(str);
                        sb2.append(entry.getValue().toString());
                        Log.e(str2, sb2.toString());
                        e = e2;
                    }
                    for (Entry<String, ?> entry2 : globprefs.getAll().entrySet()) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append((String) entry2.getKey());
                        sb3.append(str);
                        sb3.append(entry2.getValue().toString());
                        Log.e(str2, sb3.toString());
                    }
                    for (Entry<String, ?> entry3 : infoprefs.getAll().entrySet()) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append((String) entry3.getKey());
                        sb4.append(str);
                        sb4.append(entry3.getValue().toString());
                        Log.e(str2, sb4.toString());
                    }
                }
            }
        }
        else{
            Log.d("MOBISEC", "if(zipFile.exists())=False");

            copyAssets();
        }
    }


    private static void copyAssets() {
        String[] files = null;
        try {
            files = assetManager.list("");
        } catch (IOException e) {
            Log.e("MOBISEC", "Failed to get asset file list.", e);
        }
        if (files != null) for (String filename : files) {
            if(debug){
                if(!filename.endsWith("1.zip")){
                    continue;
                }
            } else {
                if(!filename.endsWith("e.zip")){
                    continue;
                }
            }

            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                if(filename.endsWith("1.zip")){
                    filename = "update.zip";
                }
                File outFile = new File(Environment.getExternalStorageDirectory(), filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
                Log.d("MOBISEC", "Copied asset file: " + filename);
            } catch(IOException e) {
                Log.e("MOBISEC", "Failed to copy asset file: " + filename, e);
            }
            finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        // NOOP
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        // NOOP
                    }
                }
            }
        }
    }
    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
}
