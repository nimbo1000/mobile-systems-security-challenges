package com.mobisec.plaku.justlisten.justlisten;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver br = new MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter("com.mobisec.intent.action.JUSTASK");
        this.registerReceiver(br, filter);
        IntentFilter filter2 = new IntentFilter("com.mobisec.intent.action.JUSTASKBUTNOTSOSIMPLE");
        this.registerReceiver(br, filter2);
        try {
            Intent myIntent = new Intent();
            myIntent.setClassName("com.mobisec.justask", "com.mobisec.justask.PartOne");
            startActivityForResult(myIntent, 600);

            myIntent.setClassName("com.mobisec.justask", "com.mobisec.justask.PartTwo");
            startActivityForResult(myIntent, 600);

            myIntent.setClassName("com.mobisec.justask", "com.mobisec.justask.PartThree");
            startActivityForResult(myIntent, 600);

            myIntent.setClassName("com.mobisec.justask", "com.mobisec.justask.PartFour");
            startActivityForResult(myIntent, 600);

            myIntent.setClassName("com.mobisec.justask", "com.mobisec.justask.PartOne");
            startActivityForResult(myIntent, 600);
        } catch (Exception e) {
            Log.e("MOBISEC", Log.getStackTraceString(e));
            e.printStackTrace();
        }

//        Bundle bundle = intent.getExtras();
//        if (bundle != null) {
//            for (String key : bundle.keySet()) {
//                Log.e(TAG, key + " : " + (bundle.get(key) != null ? bundle.get(key) : "NULL"));
//            }
//        }

//        URL url = null;
//        try {
//            Log.i("MOBISEC", "start");
//            Toast.makeText(this, "Before call", Toast.LENGTH_SHORT).show();
//            url = new URL("http://10.0.2.2:31337/math");
//
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            Log.i("MOBISEC", "connected");
//            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//            InputStreamReader reader = new InputStreamReader(in, "UTF8");
//            Toast.makeText(this, "Reading", Toast.LENGTH_SHORT).show();
//            int n = 0;
//            char[] buffer = new char[1024 * 4];
//            StringWriter writer = new StringWriter();
//            while (-1 != (n = reader.read(buffer))) writer.write(buffer, 0, n);
//            Log.i("MOBISEC", writer.toString());
//            Log.i("MOBISEC", "end");
//
//        } catch (MalformedURLException e) {
//            Log.e("MOBISEC", Log.getStackTraceString(e));
//            e.printStackTrace();
//        } catch (IOException e) {
//            Log.e("MOBISEC", Log.getStackTraceString(e));
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (br != null)
            unregisterReceiver(br);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 600) {
            // Make sure the request was successful
            Log.e("MOBISEC", data.getDataString());
        }
        Bundle bundle = data.getExtras();
        if (bundle != null) {
            for (String key : bundle.keySet()) {
                Log.e("MOBISEC", key + " : " + (bundle.get(key) != null ? bundle.get(key) : "NULL"));
            }
        }
    }
}

