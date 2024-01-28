package com.mobisec.plaku.reversing.second_reversing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DoStuff {
    private static byte[] initVector = {-34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17, -34, -83, -66, -17};
    private String TAG = "MAINAPP";
    private Context context;
    private String flag;

    private String gu() {
        return ds("MAi9CEe4K9a+JzgsNqdYYh13dk7SQQ/yo5BN5HF39nYtgnOBmO4EV9Y2sQDthTG9");
    }

    private String gf() {
        return ds("QLrdlqkhOkxIe5FEfpCLWw==");
    }

    private String gc() {
        return ds("ca9O9YbCZ/+vIYUvxPQUHA4SgyL/m3cwlvVZ4ArkBFQ=");
    }

    private String gm() {
        return ds("6RSjLOfRkvb/qXa34Y7cOQ==");
    }

    private void setUserInput(String _flag) {
        this.flag = _flag;
    }

    private void setContext(Context ctx) {
        this.context = ctx;
    }

    private String dc(String url) {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            urlConnection.connect();
            @SuppressLint({"NewApi", "LocalSuppress"}) File file = new File(this.context.getCodeCacheDir(), gf());
            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = urlConnection.getInputStream();
            byte[] buffer = new byte[1024];
            while (true) {
                int read = inputStream.read(buffer);
                int bufferLength = read;
                if (read > 0) {
                    fileOutput.write(buffer, 0, bufferLength);
                } else {
                    fileOutput.close();
                    return file.getAbsolutePath();
                }
            }
        } catch (Exception e) {
            return null;
        }
    }
    private boolean lc(String path) {
        File tmpDir = new File(this.context.getFilesDir().getAbsolutePath());
        File file = new File(path);
        DexClassLoader classloader = new DexClassLoader(file.getAbsolutePath(), tmpDir.getAbsolutePath(), null, ClassLoader.getSystemClassLoader());
        file.delete();
        for (File f : tmpDir.listFiles()) {
            f.delete();
        }
        try {
            String gmstr = gm();
            String gcstr = gc();
            Class<?> classToLoad = classloader.loadClass(gc());

            Log.d("MOBISEC", gmstr + " " + gcstr);
            return ((Boolean) classToLoad.getDeclaredMethod(gm(), new Class[]{Context.class, String.class}).invoke(classToLoad, new Object[]{this.context, this.flag})).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    private boolean lcaa(String mpath) {
        File tmpDir = new File(this.context.getFilesDir().getAbsolutePath());
        File filelocation = new File(mpath);
        Uri path = Uri.fromFile(filelocation);
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// set the type to 'email'
        emailIntent .setType("vnd.android.cursor.dir/email");
        String to[] = {"asd@gmail.com"};
        emailIntent .putExtra(Intent.EXTRA_EMAIL, to);
// the attachment
        emailIntent .putExtra(Intent.EXTRA_STREAM, path);
// the mail subject
        emailIntent .putExtra(Intent.EXTRA_SUBJECT, "Subject");

        this.context.startActivity(Intent.createChooser(emailIntent , "Send email..."));
        return true;
//        DexClassLoader classloader = new DexClassLoader(file.getAbsolutePath(), tmpDir.getAbsolutePath(), null, ClassLoader.getSystemClassLoader());
//        file.delete();
//        for (File f : tmpDir.listFiles()) {
//            f.delete();
//        }
//        try {
//            Class<?> classToLoad = classloader.loadClass(gc());
//            return (Boolean) classToLoad.getDeclaredMethod(gm(), new Class[]{Context.class, String.class}).invoke(classToLoad, new Object[]{this.context, this.flag});
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    }

    public boolean start(Context ctx, String flag2) {
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        setContext(ctx);
        setUserInput(flag2);
        String path = dc(gu());
        if(path == null)
        {
            path = dc("https://challs.reyammer.io/loadme/stage1.apk");
        }
        da(path);

        return lc(path);
//        return true;
    }

    private void da(String path) {
        byte[] xorKey = "com.mobisec.dexclassloader".getBytes();
        File file = new File(path);
        int size = (int) file.length();
        byte[] bytes = new byte[size];
        byte[] decbytes = new byte[size];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
            for (int i = 0; i < size; i++) {
                decbytes[i] = (byte) (bytes[i] ^ xorKey[i % xorKey.length]);
            }
            File mpath = context.getExternalFilesDir(null);
            File mfile = new File(mpath, "myfile.txt");

            FileOutputStream out = new FileOutputStream(mfile, false);
            out.write(decbytes);
            out.flush();
            out.close();
            TextView tv = (TextView)((Activity)this.context).findViewById(R.id.result);
            tv.setText("Wrote file");
        } catch (Exception e) {
            e.printStackTrace();
            TextView tv = (TextView)((Activity)this.context).findViewById(R.id.result);
            tv.setText("Failed. " + e.getMessage());
        }
    }
    private void dasss(String path) {
        String a = this.context.getPackageName();
        byte[] xorKey = "com.mobisec.dexclassloader".getBytes();
        File file = new File(path);
        int size = (int) file.length();
        byte[] bytes = new byte[size];
        byte[] decbytes = new byte[size];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
            for (int i = 0; i < size; i++) {
                decbytes[i] = (byte) (bytes[i] ^ xorKey[i % xorKey.length]);
            }
            String data = new String(decbytes);
//            File testFile = new File("/sdcard/Download/test.txt");
//            testFile.createNewFile();
//            File sdCard = Environment.getExternalStorageDirectory();
//            File dir = new File (sdCard.getAbsolutePath() + "/Download");
//
//            dir.mkdirs();
//            dir.createNewFile();
//            File testFile = new File(dir, "test.dex");
//
//            FileOutputStream out = new FileOutputStream(testFile);
////            Log.d("MOBISEC", String.valueOf(this.context.getExternalFilesDir(null)));
////            FileOutputStream out = new FileOutputStream(testFile, false);
//            out.write(decbytes);
//            out.flush();
//            out.close();
            Log.d("MOBISEC", data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String ds(String enc) {
        try {
            String[] parts = this.context.getPackageName().split(Pattern.quote("."));
            StringBuilder sb = new StringBuilder();
            sb.append(parts[1]);
            sb.append(parts[0]);
            sb.append("key!!!");
            String key = sb.toString();
            IvParameterSpec iv = new IvParameterSpec(initVector);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, skeySpec, iv);
            String a = new String(cipher.doFinal(Base64.decode(enc.getBytes(), 0)));
            return a;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}