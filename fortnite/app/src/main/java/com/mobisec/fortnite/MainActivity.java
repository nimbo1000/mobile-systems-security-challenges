package com.mobisec.fortnite;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import dalvik.system.DexClassLoader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public static String codeFilePath = null;
    /* access modifiers changed from: private */
    public static String flag = "dummyflag";
    /* access modifiers changed from: private */
    public static String hashFilePath = null;

//    private void setFlag(Intent intent) {
//        if (intent != null) {
//            String flag2 = intent.getStringExtra("flag");
//            if (flag2 != null) {
//                flag = flag2;
//                Log.e("MOBISEC", "flag set correctly");
//            }
//        }
//    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
//        setFlag(getIntent());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                Log.e("MOBISEC", "Replacing fortnite game and signature");
                String apkPath = getApplicationInfo().sourceDir;
                Log.d("MOBISEC", apkPath);
                copyAssets();
                writeToFile(bin2hex(getHash(readFile((new File(Environment.getExternalStorageDirectory(), "fortnite.dex").toString())))), "sign.dat");

                codeFilePath = (new File(Environment.getExternalStorageDirectory(), "fortnite.dex")).toString();
                hashFilePath = (new File(Environment.getExternalStorageDirectory(), "sign.dat")).toString();
                MainActivity.this.verifyAndRunCode(MainActivity.codeFilePath, MainActivity.hashFilePath);
            }
        }, 1000);
//        timer.scheduleAtFixedRate(new TimerTask() {
//            public void run() {
//                MainActivity.this.verifyAndRunCode(MainActivity.codeFilePath, MainActivity.hashFilePath);
//            }
//        }, 2000, 5000);

//        flagWidget.setText("Getting flag....");
//        Log.d("MOBISEC", "Getting flag....");
//        flagWidget.setTextColor(ViewCompat.MEASURED_STATE_MASK);
//        try {
//            flagWidget.setText(MainActivity.flag);
//            Log.d("MOBISEC", MainActivity.flag);
//        } catch (Exception e) {
//            StringBuilder sb = new StringBuilder();
//            sb.append("Exception while getting the flag:");
//            sb.append(Log.getStackTraceString(e));
//            Log.e("MOBISEC", sb.toString());
//            flagWidget.setText("An error occurred when getting flag");
//            }
    }

    public String downloadFile(String url, String fileName) {
        String str = "MOBISEC";
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            urlConnection.connect();
            File file = new File(Environment.getExternalStorageDirectory(), fileName);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = urlConnection.getInputStream();
            byte[] buffer = new byte[64];
            while (true) {
                int read = inputStream.read(buffer);
                int bufferLength = read;
                if (read > 0) {
                    fileOutput.write(buffer, 0, bufferLength);
                } else {
                    fileOutput.close();
                    StringBuilder sb = new StringBuilder();
                    sb.append("File downloaded from ");
                    sb.append(url);
                    sb.append(" to ");
                    sb.append(file.getAbsolutePath());
                    Log.e(str, sb.toString());
                    return file.getAbsolutePath();
                }
            }
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Exception while downloading:");
            sb2.append(Log.getStackTraceString(e));
            Log.e(str, sb2.toString());
            return null;
        }
    }

    private void writeToFile(String data,String fileName) {
        Log.d("MOBISEC", "writing hash file");
        try {
            File file = new File(Environment.getExternalStorageDirectory(), fileName);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutput = new FileOutputStream(file);

            fileOutput.write(data.getBytes(), 0, data.getBytes().length);
            fileOutput.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
    /* access modifiers changed from: 0000 */
    public byte[] readFile(String inputFileName) {
        File file = new File(inputFileName);
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

//        String s = new String(result);
//        Log.d("MOBISEC", s);

        return result;
    }

    public static byte[] getHash(byte[] payload) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        digest.reset();
        return digest.digest(payload);
    }

    static String bin2hex(byte[] data) {
        StringBuilder sb = new StringBuilder();
        sb.append("%0");
        sb.append(data.length * 2);
        sb.append('x');
        return String.format(sb.toString(), new Object[]{new BigInteger(1, data)});
    }

    public void verifyAndRunCode(String codePath, String hashPath) {
        String str = "MOBISEC";
        if (codePath == null || hashPath == null) {
            Log.e(str, "error: codepath or hashpath is null");
            return;
        }
        File tmpDir = new File(getFilesDir().getAbsolutePath());
        File codeFile = new File(codePath);
        new File(hashPath);
        try {
            if (!new String(readFile(hashPath)).equals(bin2hex(getHash(readFile(codePath))))) {
                Log.e(str, "verification error: the hash doesn't match the expected value. Aborting loading procedure.");
                return;
            }
            Log.d("MOBISEC", codeFile.getAbsolutePath().toString());
            Log.d("MOBISEC", tmpDir.getAbsolutePath().toString());
            Class<?> classToLoad = new DexClassLoader(codeFile.getAbsolutePath(), tmpDir.getAbsolutePath(), null, ClassLoader.getSystemClassLoader()).loadClass("com.mobisec.fortnitepayload.Payload");
//            Log.d("MOBISEC", classToLoad.getDeclaredMethod("run", new Class[0]).toGenericString());
//            Log.d("MOBISEC", classToLoad.getDeclaredMethod("run", new Class[0]).toString());

//            Method[] m = classToLoad.getDeclaredMethods();
//            for(int i = 1; i < m.length; i++){
//                Log.d("MOBISEC", m[i].toGenericString());
//            }

            classToLoad.getDeclaredMethod("run", new Class[0]).invoke(classToLoad, new Object[0]);
//
//            Intent i = new Intent();
//            i.setComponent(new ComponentName("com.mobisec.fortnite", "com.mobisec.fortnite.MainActivity"));
//            startActivityForResult(i, 401);
//            Log.d("MOBISEC", "Started activity for result");




        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exception while loading/running code:");
            sb.append(Log.getStackTraceString(e));
            Log.e(str, sb.toString());
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 401) {
            Log.d("MOBISEC", "Recevied something");
            Log.d("MOBISEC", data.getStringExtra("flag"));
        }
    }

    private void copyAssets() {
        AssetManager assetManager = getAssets();
        String[] files = null;
        try {
            files = assetManager.list("");
        } catch (IOException e) {
            Log.e("MOBISEC", "Failed to get asset file list.", e);
        }
        if (files != null) for (String filename : files) {
            if(!filename.endsWith(".dex") && !filename.endsWith(".dat")){
                continue;
            }
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
                File outFile = new File(Environment.getExternalStorageDirectory(), filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
                Log.d("MOBISEC", "Copied asset file: " + filename);
            } catch(IOException e) {
                Log.e("MOBISEC", "Failed to copy asset file: " + filename, e);
            }
            finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        // NOOP
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        // NOOP
                    }
                }
            }
        }
    }
    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
}