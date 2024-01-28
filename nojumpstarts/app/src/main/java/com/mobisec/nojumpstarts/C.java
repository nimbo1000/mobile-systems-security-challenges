package com.mobisec.nojumpstarts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class C extends AppCompatActivity {
    private static String expectedMsg = "Main-to-A/A-to-B/B-to-C";

    private void reply(String flag) {
        Log.d("MOBISEC", "REPLY C" + flag);
        Intent resIntent = new Intent();
        resIntent.putExtra("flag", flag);
        setResult(-1, resIntent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_c);
        Intent data = getIntent();
        String msg = data.getStringExtra("authmsg");
        Log.d("MOBISEC", "C msg =" + msg);
        byte[] sign = data.getByteArrayExtra("authsign");
        if (msg == null || sign == null || !msg.equals(expectedMsg) || !Main.verify(msg, sign)) {
            reply("C: broken auth");
        } else {
            Log.d("MOBISEC", "C" + "else");
            reply(MainActivity.flag);
        }
    }
}