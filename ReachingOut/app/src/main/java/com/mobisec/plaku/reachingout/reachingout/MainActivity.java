package com.mobisec.plaku.reachingout.reachingout;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.provider.UserDictionary;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mobisec.serialintent.FlagContainer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    static final String CREATE_TABLE =
            " CREATE TABLE joke" +
                    " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " author TEXT NOT NULL, " +
                    " joke TEXT NOT NULL);";

    static final String PROVIDER_NAME = "com.mobisec.provider.Joke";
    static final String URL = "content://" + PROVIDER_NAME + "/jokes";

    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "jokes", 1);
    }

    private Messenger mBoundServiceMessenger;
    private boolean mServiceConnected = false;
    private final Messenger mActivityMessenger = new Messenger(
            new ActivityHandler());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serialIntent();

//        unbindable();

//        jokeprovider();

//        justask();

//        reachingout();
    }

    private void serialIntent() {
        Intent i = new Intent();
        i.setComponent(new ComponentName("com.mobisec.serialintent", "com.mobisec.serialintent.SerialActivity"));
        startActivityForResult(i, 234);
    }

    private void unbindable() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("MOBISEC", "RUN");
                if (mServiceConnected) {
                    try {

                        Message msg2 = Message.obtain(null,
                                1, 0, 0);
                        msg2.replyTo = mActivityMessenger;
                        mBoundServiceMessenger.send(msg2);
                        Log.d("MOBISEC", "Sent Client register");

                        Message msg = Message.obtain(null,
                                4, 0, 0);
                        msg.replyTo = mActivityMessenger;
                        mBoundServiceMessenger.send(msg);
                        Log.d("MOBISEC", "Sent");


                    } catch (Exception e) {
                        Log.d("MOBISEC", Log.getStackTraceString(e));
                    }
                }
//                handler.postDelayed(this, 1000);
            }
        }, 1000);

    }

    private void jokeprovider() {
        // Queries the user dictionary and returns results
        ContentResolver contentResolver = getContentResolver();
        Uri contentUri = Uri.parse(URL);
        Cursor cursor = getContentResolver().query(contentUri, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();

            // Loop in the cursor to get each row.
            do {
                // Get column 1 value.
                int column1Index = cursor.getColumnIndex("author");
                String column1Value = cursor.getString(column1Index);

                // Get column 2 value.
                int column2Index = cursor.getColumnIndex("joke");
                String column2Value = cursor.getString(column2Index);
                Log.d("MOBISEC", column1Value + " --- " + column2Value);
            } while (cursor.moveToNext());
        }

    }

    int requestCode = 400;

    private void justask() {
        try {
            Intent i = new Intent("com.mobisec.intent.action.JUSTASKBUTNOTSOSIMPLE");
            i.setComponent(new ComponentName("com.mobisec.justask", "com.mobisec.justask.PartFour"));
//            i.setPackage("com.mobisec.justask");
//            i.setComponent(new ComponentName("com.mobisec.justask", ));
            startActivityForResult(i, requestCode);

//            Intent i = new Intent();
//            i.setComponent(new ComponentName("com.mobisec.justask", "com.mobisec.justask.PartOne"));
//            startActivityForResult(i, requestCode);
        } catch (Exception e) {
            Log.e("MOBISEC", Log.getStackTraceString(e));
        }
//
//
//        try {
//            Intent i = new Intent();
//            i = new Intent();
//            i.setComponent(new ComponentName("com.mobisec.justask", "com.mobisec.justask.PartOne"));
//            startActivityForResult(i, requestCode);
////
//            Log.d("MOBISEC", "Passed first intent");
//            i = new Intent();
//            i.setComponent(new ComponentName("com.mobisec.justask", "com.mobisec.justask.PartThree"));
//            startActivityForResult(i, requestCode);
//            Log.d("MOBISEC", "Passed second intent");
//        } catch(Exception e){
//            Log.e("MOBISEC", Log.getStackTraceString(e));
//        }
//        try{
//            Intent i = new Intent("com.mobisec.intent.action.JUSTASKBUTNOTSOSIMPLE");
//            //i.setComponent(new ComponentName("com.mobisec.justask", ""));
//            i.setPackage("com.mobisec.justask");
////            i.setComponent(new ComponentName("com.mobisec.justask", ));
//            startActivityForResult(i, requestCode);
//        } catch(Exception e){
//            Log.e("MOBISEC", Log.getStackTraceString(e));
//        }
    }

    String TAG = "MOBISEC";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            Log.d(TAG, "Result " + resultCode);
//        Log.d(TAG, "data.getExtras " + data.getExtras());
//            FlagContainer fc = data.getParcelableExtra("flag");
//            if (fc != null) {
//                Log.d(TAG, fc.getFlag());
//            } else {
//                Log.d(TAG, "FC is null");
//            }

            if (data.hasExtra("flag")) {
                Bundle bundle = data.getExtras();

                com.mobisec.serialintent.FlagContainer value = (FlagContainer) bundle.get("flag");
                Log.d(TAG, String.format("Key: %s, value: %s, className: (%s)", "flag",
                        value.toString(), value.getClass().getName()));

                Method method = value.getClass().getDeclaredMethod("getFlag");
                method.setAccessible(true);
                Object r = method.invoke(value);

                Log.d(TAG, "Res " + r);
//                com.mobisec.serialintent.FlagContainer fc = (com.mobisec.serialintent.FlagContainer)bundle.getSerializable("flag");
//                Method method = fc.getClass().getDeclaredMethod("getFlag");
//                method.setAccessible(true);
//                Object r = method.invoke(fc);
            } else {
                Log.d(TAG, "It has NOT flag");
            }
        } catch (Exception e) {
            Log.d(TAG, Log.getStackTraceString(e));
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        Log.d("MOBISEC", resultCode + "");
//        Log.d("MOBISEC", data.toString());
////        Log.d("MOBISEC", data.getExtras().get("flag").toString());
//        Log.d("MOBISEC", ((FlagContainer)data.getExtras().getSerializable("flag")).getFlag());
//
//        Bundle bundle = data.getExtras();
//        if (bundle != null) {
//            for (String key : bundle.keySet()) {
//                Log.d("MOBISEC", "FOUND KEY " + key);
//                Log.e("MOBISEC", key + " new: " + (bundle.get(key) != null ? bundle.get(key) : "NULL"));
//            }
//        }
//        else {
//            Log.d("MOBISEC", "ISNULL");
//        }
////        if(data.hasExtra("flag")){
////            Log.d("MOBISEC", "-------->" + bdl.getSerializable("flag").toString());
////            Log.d("MOBISEC", "-------->" + bdl.getString("flag"));
////
////            return;
////        }
////        else {
////
////
////            if (data.hasExtra("hiddenFlag")) {
////                Log.d("MOBISEC", "-------->" + data.getStringExtra("hiddenFlag"));
////            }
////
////            if (data.hasExtra("flag")) {
////                Log.d("MOBISEC", "-------->" + data.getStringExtra("flag"));
////            }
//////        Log.d("MOBISEC", "RESULT RECEIVED");
////            Bundle bundle = data.getExtras();
////            if (bundle != null) {
////                for (String key : bundle.keySet()) {
////                    Log.e("MOBISEC", key + " new: " + (bundle.get(key) != null ? bundle.get(key) : "NULL"));
//////                Log.e("MOBISEC", bundle.getParcelable("follow").toString());
//////                Log.e("MOBISEC", bundle.getParcelable("follow").getClass().toString());
////                    Bundle bd = (Bundle) bundle.get(key);
////                    if (bd != null) {
////                        for (String bdkey : bd.keySet()) {
////                            Log.e("MOBISEC", bdkey + " new: " + (bd.get(bdkey) != null ? bd.get(bdkey) : "NULL"));
////                            Bundle bdthe = (Bundle) bd.get(bdkey);
////                            if (bdthe != null) {
////                                for (String bdthekey : bdthe.keySet()) {
////                                    Log.e("MOBISEC", bdthekey + " new: " + (bdthe.get(bdthekey) != null ? bdthe.get(bdthekey) : "NULL"));
////
////                                    Bundle rabbdthe = (Bundle) bdthe.get(bdthekey);
////                                    if (rabbdthe != null) {
////                                        for (String rabbdthekey : rabbdthe.keySet()) {
////                                            Log.e("MOBISEC", rabbdthekey + " new: " + (rabbdthe.get(rabbdthekey) != null ? rabbdthe.get(rabbdthekey) : "NULL"));
////                                            Bundle horabbdthe = (Bundle) rabbdthe.get(rabbdthekey);
////                                            if (horabbdthe != null) {
////                                                for (String horabbdthekey : horabbdthe.keySet()) {
////                                                    Log.e("MOBISEC", horabbdthekey + " new: " + (horabbdthe.get(horabbdthekey) != null ? horabbdthe.get(horabbdthekey) : "NULL"));
////                                                    Bundle dehorabbdthe = (Bundle) horabbdthe.get(horabbdthekey);
////                                                    if (dehorabbdthe != null) {
////                                                        for (String dehorabbdthekey : dehorabbdthe.keySet()) {
////                                                            Log.e("MOBISEC", dehorabbdthekey + " new: " + (dehorabbdthe.get(dehorabbdthekey) != null ? dehorabbdthe.get(dehorabbdthekey) : "NULL"));
////                                                        }
////                                                    }
////                                                }
////                                            }
////                                        }
////                                    }
////                                }
////                            }
////                        }
////                    }
//////                    Log.e("MOBISEC", "toString() " + bundle.get(key).toString());
//////                    Log.e("MOBISEC", "String.valueOf() " + String.valueOf(bundle.get(key)));
////
////                }
////            }
////        =========================================================================================
//
////        if (requestCode == 400) {
////            Log.d("MOBISEC","Up was Part one");
////            requestCode += 1;
////            Intent i =     new Intent("com.mobisec.intent.action.JUSTASKBUTNOTSOSIMPLE");
////            i.setComponent(new ComponentName("com.mobisec.justask", "com.mobisec.justask.PartTwo"));
////            startActivityForResult(i, requestCode);
////        }
////        if (requestCode == 401) {
////            Log.d("MOBISEC","Up was Part two");
////            requestCode += 1;
////            Intent i = new Intent();
////            i.setComponent(new ComponentName("com.mobisec.justask", "com.mobisec.justask.PartThree"));
////            startActivityForResult(i, requestCode);
////        }
////        if (requestCode == 402) {
////            Log.d("MOBISEC","Up was Part three");
////            Intent i = new Intent("com.mobisec.intent.action.JUSTASKBUTNOTSOSIMPLE");
////            i.setComponent(new ComponentName("com.mobisec.justask", "com.mobisec.justask.PartFour"));
//////            i.setPackage("com.mobisec.justask");
//////            i.setComponent(new ComponentName("com.mobisec.justask", ));
////            startActivityForResult(i, requestCode+1);
////        }
////        if (requestCode == 403){
////            Log.d("MOBISEC","Up was Part four");
////        }
////            Log.d("MOBISEC", "================================================");
//
////        }
//    }


    private void reachingout() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                URL url = null;

                try {
                    url = new URL("http://10.0.2.2:31337/flag");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                HttpURLConnection urlConnection = null;

                try {
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("POST");
                    Uri.Builder builder = new Uri.Builder()
                            .appendQueryParameter("val1", "4")
                            .appendQueryParameter("val2", "5")
                            .appendQueryParameter("oper", "+")
                            .appendQueryParameter("answer", "9");

                    String query = builder.build().getEncodedQuery();

                    OutputStream os = urlConnection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(query);
                    writer.flush();
                    writer.close();
                    os.close();
                    urlConnection.connect();

                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    Log.d("MOBISEC", convertStreamToString(in));
                } catch (Exception e) {
                    Log.e("MOBISEC", Log.getStackTraceString(e));
                } finally {
                    urlConnection.disconnect();
                }
            }
        };

        thread.start();

    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("MOBISEC", "ONSTART");
//        Intent intent = new Intent();
//        intent.setComponent(new ComponentName("com.mobisec.unbindable", "com.mobisec.unbindable.UnbindableService"));
//        startService(intent);
//
//        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
//    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mServiceConnected) {
            unbindService(mServiceConnection);
            mServiceConnected = false;
        }
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBoundServiceMessenger = null;
            mServiceConnected = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBoundServiceMessenger = new Messenger(service);
            mServiceConnected = true;
            Log.d("MOBISEC", "ServiceConnected");
            Log.d("MOBISEC", name.toString());
//            try {
//                Message msg = Message.obtain(null,
//                        4, 0, 0);
//                msg.replyTo = mActivityMessenger;
//                mBoundServiceMessenger.send(msg);
//            } catch (Exception e) {
//                Log.d("MOBISEC", Log.getStackTraceString(e));
//            }
        }
    };


    static class ActivityHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            try {
                Log.d("MOBISEC", "MESSAGE CAME" + msg.toString());

//                Log.d("MOBISEC", "MESSAGE CAME" + msg.obj.toString());
                Bundle bundle = (Bundle) msg.obj;
                String res = bundle.getString("flag");
//                Log.d("MOBISEC", "MESSAGE CAME" + msg.getData().getString("flag"));
                Log.d("MOBISEC", "CAME HERE " + res);

//            Log.d("MOBISEC", msg.toString());
                switch (msg.what) {
                    case 4: {
                        Log.d("MOBISEC", msg.getData().getString(
                                "flag"));
//                    mActivity.get().mTimestampText.setText(msg.getData().getString(
//                            "timestamp"));
                    }
                    default: {
                        Log.d("MOBISEC", msg.getData().toString());
                    }
                }
            } catch (Exception e) {
                Log.d("MOBISEC", Log.getStackTraceString(e));
            }
        }

    }
}


