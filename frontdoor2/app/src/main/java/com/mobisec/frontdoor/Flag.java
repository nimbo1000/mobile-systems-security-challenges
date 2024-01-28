package com.mobisec.frontdoor;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

class Flag {
    private static boolean debug = true;
    private static String sUrl = "http://10.0.2.2:31337/getflag";

    Flag() {
    }

    public static String getFlag(String username, String password) throws Exception {
        String urlParameters;
        if (debug) {
            urlParameters = "username=testuser&password=passtestuser123";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("username=");
            sb.append(username);
            sb.append("&password=");
            sb.append(password);
            urlParameters = sb.toString();
        }
        int postDataLength = urlParameters.getBytes(StandardCharsets.UTF_8).length;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sUrl);
        sb2.append("?");
        sb2.append(urlParameters);
        HttpURLConnection conn = (HttpURLConnection) new URL(sb2.toString()).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        conn.setUseCaches(false);
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String content = BuildConfig.FLAVOR;
        while (true) {
            String readLine = rd.readLine();
            String line = readLine;
            if (readLine == null) {
                Log.e("MOBISEC", content);
                return content;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(content);
            sb3.append(line);
            sb3.append("\n");
            content = sb3.toString();
        }
    }
}