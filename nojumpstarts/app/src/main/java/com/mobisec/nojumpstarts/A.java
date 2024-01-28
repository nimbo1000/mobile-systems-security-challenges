package com.mobisec.nojumpstarts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class A extends AppCompatActivity {
    private static String expectedMsg = "Main-to-A";

    private void reply(String flag) {
        Log.d("MOBISEC", "REPLY A" + flag);
        Intent resIntent = new Intent();
        resIntent.putExtra("flag", flag);
        setResult(-1, resIntent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_a);
        Intent data = getIntent();
        String msg = data.getStringExtra("authmsg");
        Log.d("MOBISEC", "A" + msg);
        byte[] sign = data.getByteArrayExtra("authsign");
        if (msg == null || sign == null || !msg.equals(expectedMsg) || !Main.verify(msg, sign)) {
            reply("A: broken auth");
        } else {
            startActivityForResult(Main.buildIntent("A", "B", msg), 401);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 401) {

            reply(data.getStringExtra("flag"));
        }
    }
}