package com.mobisec.nojumpstarts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String flag = "dummyflag";

    /* access modifiers changed from: 0000 */
    public void setFlag(Intent intent) {
        if (intent != null) {
            String flag2 = intent.getStringExtra("flag");
            if (flag2 != null) {
                flag = flag2;
                Log.e("MOBISEC", "flag set correctly");
                Log.d("MOBISEC", "flag2 " + flag2);

            }
        }
    }

    public void getFlag() throws Exception {
        startActivityForResult(Main.buildIntent("Main", "A", null), 400);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        setFlag(getIntent());

        Log.d("MOBISEC", "Getting flag....");

        try {
            MainActivity.this.getFlag();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exception while getting the flag:");
            sb.append(Log.getStackTraceString(e));
            Log.e("MOBISEC", sb.toString());
            Log.d("MOBISEC", "An error occurred when getting flag");
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 400) {
            String flag2 = data.getStringExtra("flag");
            if (flag2 != null) {
                Log.d("MOBISEC", flag2);
            } else {
                Log.d("MOBISEC", "flag was null");
            }
        }
    }
}