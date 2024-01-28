package com.mobisec.frontdoor;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        try {
            Log.d("MOBISEC", Flag.getFlag("aaa", "aaa"));
            Log.d("MOBISEC", "tried");
        } catch (Exception e) {
            Log.d("MOBISEC", Log.getStackTraceString(e));
            e.printStackTrace();

        }
    }
}
