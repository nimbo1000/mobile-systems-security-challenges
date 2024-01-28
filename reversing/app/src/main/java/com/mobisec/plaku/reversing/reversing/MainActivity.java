package com.mobisec.plaku.reversing.reversing;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        for(int i=0; i<=999999; i++)
//        {
//            String val = Integer.toString(i);
//            val = padLeftZeros(val, 6);
//            if(checkPin(val)){
//                Log.e("MOBISEC", "Pin was found " + val);
//                break;
//            }
//            else{
//                if(i%10==0) {
//                    Log.d("MOBISEC", "Tried " + val);
//                }
//            }
//        }
        Log.e("MOBISEC", "BEFORE CALLING");
        checkPin("090157");
    }
    public String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }
    public static boolean checkPin(String pin) {
        Log.e("MOBISEC", "GOT IN");
        if (pin.length() != 6) {
            return false;
        }
        try {
            Log.e("MOBISEC", "TRYING");
            byte[] pinBytes = pin.getBytes();
            for (int i = 0; i < 25; i++) {
                for (int j = 0; j < 400; j++) {
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    md.update(pinBytes);
                    pinBytes = (byte[]) md.digest().clone();
                }
            }
            Log.e("MOBISEC", "GOT IT");
            Log.e("MOBISEC", toHexString(pinBytes));
            String a = toHexString(pinBytes);
            if (toHexString(pinBytes).equals("d04988522ddfed3133cc24fb6924eae9")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            Log.e("MOBISEC", "Exception while checking pin");
            return false;
        }
    }
    public static String toHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 255);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
