package com.mobisec.nojumpstarts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class B extends AppCompatActivity {
    private static String expectedMsg = "Main-to-A/A-to-B";

    private void reply(String flag) {
        Log.d("MOBISEC", "REPLY B " + flag);
        Intent resIntent = new Intent();
        resIntent.putExtra("flag", flag);
        setResult(-1, resIntent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_b);
        Intent data = getIntent();
        String msg = data.getStringExtra("authmsg");
        Log.d("MOBISEC", "B msg =" + msg);
        byte[] sign = data.getByteArrayExtra("authsign");
        if (msg == null || sign == null || !msg.equals(expectedMsg) || !Main.verify(msg, sign)) {
            reply("B: broken auth");
        } else {
            Log.d("MOBISEC", "C else" );
            startActivityForResult(Main.buildIntent("B", "C", msg), 402);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 402) {
            reply(data.getStringExtra("flag"));
        }
    }
}