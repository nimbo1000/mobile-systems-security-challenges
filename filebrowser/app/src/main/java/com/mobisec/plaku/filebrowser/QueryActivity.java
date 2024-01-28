package com.mobisec.plaku.filebrowser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueryActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        String out = null;
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_file_operator);
        String out2 = null;
        try {
            Intent intent = getIntent();
            String oper = intent.getStringExtra("oper");
            String arg = intent.getStringExtra("arg");
            MainActivity.logQuery(this, oper, arg);
            Process p = null;
            String str = "-c";
            String str2 = "sh";
            if (oper.equals("ls")) {
                StringBuilder sb = new StringBuilder();
                sb.append("ls ");
                sb.append(arg);
                p = Runtime.getRuntime().exec(new String[]{str2, str, sb.toString()});
            } else if (oper.equals("du")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("du ");
                sb2.append(arg);
                p = Runtime.getRuntime().exec(new String[]{str2, str, sb2.toString()});
            } else if (oper.equals("cat")) {
                out2 = "cat has been momentarily disabled for security reasons";
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("oper '");
                sb3.append(oper);
                sb3.append("' not supported");
                out2 = sb3.toString();
            }
            if (out == null) {
                if (p != null) {
                    BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    BufferedReader stdErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    String line = stdOut.readLine();
                    if (line == null) {
                        line = stdErr.readLine();
                    }
                    if (line != null) {
                        out = line;
                    } else {
                        out = "error while reading output";
                    }
                } else {
                    out = "error while exec command";
                }
            }
        } catch (Exception e) {
            out = "exception while exec command";
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Exception while executing operation:");
            sb4.append(Log.getStackTraceString(e));
            Log.e("MOBISEC", sb4.toString());
        }
        if (getIntent().getBooleanExtra(BuildConfig.BUILD_TYPE, false)) {
            MainActivity.writeToFile("/sdcard/browser.log", out);
        }
        reply(out);
    }

    public void reply(String msg) {
        Intent i = new Intent();
        i.putExtra("result", msg);
        setResult(-1, i);
        finish();
    }
}