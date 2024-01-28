package com.mobisec.plaku.reversing.second_reversing;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.Key;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {
    public static boolean g1 = false;
    public static boolean g2 = false;
    public static boolean g3 = false;
    public static boolean g4 = false;
    TextView mResultWidget = null;

    /* access modifiers changed from: protected */
    public void onCreateUpos(Bundle savedInstanceState) {
        Activity.initActivity(this);
        final EditText flagWidget = (EditText) findViewById(R.id.flag);
        Button checkButton = (Button) findViewById(R.id.check);
        final TextView resultWidget = (TextView) findViewById(R.id.result);
        this.mResultWidget = resultWidget;
        flagWidget.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.mResultWidget.setText(BuildConfig.FLAVOR);
            }

            public void afterTextChanged(Editable s) {
            }
        });
        checkButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String str = "MOBISEC";
                if (MainActivity.g1) {
                    resultWidget.setText("g1 was true");
                    resultWidget.setTextColor(SupportMenu.CATEGORY_MASK);
                    Log.e(str, "1");
                    g1 = false;
                }
                if (MainActivity.g2) {
                    resultWidget.setText("g2 was true");
                    resultWidget.setTextColor(SupportMenu.CATEGORY_MASK);
                    Log.e(str, "2");
                    g2 = false;
                }
                if (MainActivity.g3) {
                    resultWidget.setText("g3 was true.");
                    resultWidget.setTextColor(SupportMenu.CATEGORY_MASK);
                    Log.e(str, "3");
                    g3 = false;
                }
                if (MainActivity.g4) {
                    resultWidget.setText("g4 was true");
                    resultWidget.setTextColor(SupportMenu.CATEGORY_MASK);
                    Log.e(str, "4");
                    g4 = false;
                }
                String flag = flagWidget.getText().toString();
                resultWidget.setText("Checking flag....");
                resultWidget.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                boolean result = false;
                try {
                    Log.d("MOBISEC", "BEFORE CF "+Boolean.toString(g4));
                    result = FC.checkFlag(MainActivity.this, flag);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Flag result: ");
                    sb.append(result);
                    Log.d("MOBISEC", "AFTER CF "+Boolean.toString(g4));
                    Log.e(str, sb.toString());
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Exception while checking flags:");
                    sb2.append(Log.getStackTraceString(e));
                    Log.e(str, sb2.toString());
                }
                if (MainActivity.g1) {
                    resultWidget.setText("Debugger detected. ;-) Goodbye.");
                    resultWidget.setTextColor(SupportMenu.CATEGORY_MASK);
                    Log.e(str, "1");
                } else if (MainActivity.g2) {
                    resultWidget.setText("Frida detected. ;-) Goodbye.");
                    resultWidget.setTextColor(SupportMenu.CATEGORY_MASK);
                    Log.e(str, "2");
                } else if (MainActivity.g3) {
                    resultWidget.setText("Could not find Google Play Store app. is this a rooted device? ;-) Goodbye.");
                    resultWidget.setTextColor(SupportMenu.CATEGORY_MASK);
                    Log.e(str, "3");
                } else if (MainActivity.g4) {
                    resultWidget.setText("The app appears to be modified. I do not run stuff I didn't sign. Goodbye.");
                    resultWidget.setTextColor(SupportMenu.CATEGORY_MASK);
                    Log.e(str, "4");
                } else if (result) {
                    resultWidget.setText("Flag is valid!");
                    resultWidget.setTextColor(-16737536);
                    Log.e(str, "v");
                } else {
                    resultWidget.setText("Flag is not valid");
                    resultWidget.setTextColor(SupportMenu.CATEGORY_MASK);
                    Log.e(str, "nv");
                }
            }
        });
    }
    public long[][] lm() throws Exception {
        long[][] matrix = ((long[][]) Array.newInstance(long.class, new int[]{256, 256}));
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(this.getAssets().open("lotto.dat")));
            int rowIdx = 0;
            while (true) {
                String readLine = reader.readLine();
                String row = readLine;
                String str = "error";
                if (readLine == null) {
                    break;
                }
                int colIdx = 0;
                for (String elem : row.split(" ")) {
                    matrix[rowIdx][colIdx] = Long.parseLong(elem);
                    colIdx++;
                }
                if (colIdx == 256) {
                    rowIdx++;
                } else {
                    throw new Exception(str);
                }
            }
        } catch (Throwable th) {
            if (reader != null) {
                reader.close();
            }
            throw th;
        }
        return matrix;
    }

    long[][] m = ((long[][]) Array.newInstance(long.class, new int[]{256, 256}));
    boolean found_seed = false;
    int counting = 0;

    void printTheArray(int arr[], int n) {
        String seed = "";
        for (int i = 0; i < n; i++) {
            seed += Integer.toString(arr[i]);
        }

        Streamer s = new Streamer(seed, 8);

        int i14 = 0;
        String core="this_is_aabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        String curr = Character.toString(core.charAt(i14 * 2)) +
                Character.toString(core.charAt((i14 * 2) + 1));
        int first = s.g2()&255;
        int second = (s.g2() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        Log.d("MOBISEC", "Tried this first " + first);
        Log.d("MOBISEC", "Tried this second " + second);
////76 227//77 110//233 206
        if(first==76 && second==227){
            Log.d("MOBISEC", "first was here ");
        }
        if(first==77 && second==110){
            Log.d("MOBISEC", "second was here");
        }
        if(first==233 && second==206){
            Log.d("MOBISEC", "third was here");
        }
        Log.d("MOBISEC", "sq(r(curr))" + sq(r(curr)));
        if (sq(r(curr)) != m[first][second]) {
            Log.d("MOBISEC", "Tried this " + s.toString());
        }else{
            Log.d("MOBISEC", "FOUND IT " + s.toString());
            found_seed = true;
        }
        counting++;
        if(found_seed){
            counting=1000000;
        }
    }
    // Function to generate all binary strings
    void generateAllBinaryStrings(int n,int arr[], int i)
    {
        if(found_seed){
            return;
        }
        if (i == n)
        {
            printTheArray(arr, n);
            return;
        }

        // First assign "0" at ith position
        // and try for all other permutations
        // for remaining positions
        arr[i] = 0;
        generateAllBinaryStrings(n, arr, i + 1);

        // And then assign "1" at ith position
        // and try for all other permutations
        // for remaining positions
        arr[i] = 1;
        generateAllBinaryStrings(n, arr, i + 1);
    }

    private void whatever(){
        long[][] m = ((long[][]) Array.newInstance(long.class, new int[]{256, 256}));
        try {
            m = lm();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Streamer s = new Streamer();
        boolean[] fs = new boolean[200];

        int i14 = 0;
        int idx7 = 100;
        String core="this_is_aabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        while (i14 < 30) {
            fs[idx7] = true;
            String curr = Character.toString(core.charAt(i14 * 2)) +
                    Character.toString(core.charAt((i14 * 2) + 1));
            if (ip(i14)) {
                for (int j = 0; j < i14; j++) {
                    s.step();
                }
            }
            boolean cont = true;
            int steps = 1;
            List<String> possibilities = new ArrayList<String>();

            List<Character> chars = new ArrayList<>();
            String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-.!@#$%^&*()=+[];'?";
            for (char ch : str.toCharArray()) {
                chars.add(ch);
            }
            for(int z=0; z<chars.size(); z++){
                for(int zh=0; zh<chars.size(); zh++){
                    possibilities.add(Character.toString(chars.get(z))+Character.toString(chars.get(zh)));
                }
            }

            do {
                for(int str_item=0; str_item<possibilities.size(); str_item++){
                    s = new Streamer();
                    for (int i=0; i<steps; i++) {
                        s.step();
                    }
                    curr=possibilities.get(str_item);

                    if(sq(r(curr)) != m[s.g2() & 255][(s.g2() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8]) {
//                s.step();
//                        Log.d("MOBISEC", "Tried " + possibilities.get(str_item));

                    }else{
                        Log.d("MOBISEC", Integer.toString(steps) + " " +s.toString());
                        Log.d("MOBISEC", curr);
//                        cont=false;
//                        if(curr.equals("_t")){
                            s.step();
                            for(int str_item2=0; str_item2<possibilities.size(); str_item2++){
                                String curr2 = possibilities.get(str_item2);
                                if(sq(r(curr2)) != m[s.g2() & 255][(s.g2() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8]) {
//                                    Log.d("MOBISEC", "nah");

                                }else{
                                    Log.d("MOBISEC", "------------------");
                                    Log.d("MOBISEC", curr2);

                                }
                            }
//do the additional steps
//                            set the str_item to 0
//                        }
                    }
                }
//                Log.d("MOBISEC", String.valueOf(steps));
                steps++;
                if(steps>2500){
                    Log.d("MOBISEC", "THAT WAS ENOUGH");
                    return;
                }
            } while (cont);


//            for(int i = 0; i<256; i++){
//                for(int j = 0; j<256; j++){
//                    if(sq(r(curr))==m[i][j]){
//                        Log.d("MOBISEC", Integer.toString(i)+ " " +Integer.toString(j));
//                        Log.d("MOBISEC", curr + Long.toString(sq(r(curr))));
//                    }
//                }
//            }
//            812991169
//            Log.d("MOBISEC", s.toString());
//            long val = (s.g2() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
//            Log.d("MOBISEC", Long.toString(val));
//            while(val!=110  ){
//                Log.d("MOBISEC", s.toString());
////76 227//77 110//233 206
//                long temp = s.g2();
//                Log.d("MOBISEC", Long.toString(temp&255));
//                val = (s.g2() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
//                Log.d("MOBISEC", Long.toString(val));
//            }
//            Log.d("MOBISEC", Long.toString(val));

//            while (sq(r(curr)) != m[s.g2() & 255][(s.g2() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8]) {
////                s.step();
//
//                Log.d("MOBISEC", s.toString());
//            }
//            i14++;
            Log.d("MOBISEC", "FOUND " + s.toString());
            return;
//            idx7++;
        }
        for (int i20 = idx7 - 30; i20 < idx7; i20++) {
            if (!fs[i20]) {
                Log.d("MOBISEC", Integer.toString(i20) + "was false");
            }
        }
    }


    public static boolean ip(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long sq(String a) {
        return (long) Math.pow((double) ((a.charAt(0) + (a.charAt(1) << 8)) & SupportMenu.USER_MASK), 2.0d);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        onCreateUpos(savedInstanceState);
//        whatever();

//        try {
//            m = lm();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        int n = 11;
//
//        int[] arr = new int[n];
//
////         Print all binary strings
//        generateAllBinaryStrings(n, arr, 0);
        Log.d("MOBISEC", "Items " + Integer.toString(counting));

        Log.d("MOBISEC", "g1 " + Boolean.toString(g1));
        Log.d("MOBISEC", "g2 " + Boolean.toString(g2));
        Log.d("MOBISEC", "g3 " + Boolean.toString(g3));
        Log.d("MOBISEC", "g4 " + Boolean.toString(g4));
//        int r5 = 200; //(0xc8, float:2.8E-43)
//        boolean[] r1 = new boolean[r5]; //0xc8
//        String rstr = r("this_is_"); //aopz_pz_
//        Log.d("MOBISEC", rstr);
//        Log.d("MOBISEC", Boolean.toString(r1[0]));
        //        stuff_before();

        String s1="bHM=";
    }

    public static String r(String s) {
        String out = BuildConfig.FLAVOR;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 's') {
                c = (char) (c + 7);
            } else if (c >= 'A' && c <= 'S') {
                c = (char) (c + 7);
            } else if (c >= 't' && c <= 'z') {
                c = (char) (c - 19);
            } else if (c >= 'T' && c <= 'Z') {
                c = (char) (c - 19);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(out);
            sb.append(c);
            out = sb.toString();
        }
        return out;
    }
    public void stuff_before(){
        //        Log.d("MOBISEC", foo());

        Log.d("MOBISEC", "1" + gs(getString(R.string.ct1), getString(R.string.k1)));

        char[] set1 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int k = 5;
        try {
//            byte[] digest = hash("abc".getBytes());
            byte[] currKey = hash(new byte[]{(byte) 1, (byte) 1, (byte) 255});
            String hexKey = toHex(currKey);
            Log.d("MOBISEC", hexKey);
            byte[] currPt = "abc".getBytes();
            for (int i = 0; i < 10; i++) {
                currPt = encrypt(currPt, currKey);
                Log.d("MOBISEC", Integer.toString(i) + " " + toHex(currKey));
                Log.d("MOBISEC", toHex(currPt));
                currKey = hash(currKey);

            }

//            byte[] key = new byte[0];


//            String a = toHex(encrypt("abc".getBytes(), key));
            String a = toHex(currPt);
            Log.d("MOBISEC", a);
        }catch (Exception e){
            Log.getStackTraceString(e.fillInStackTrace());
        }


//        new DoStuff().start(MainActivity.this, "whatever");
//        new LoadImage().load(MainActivity.this, "whatever");
//        sdf.checkFlag(getApplicationContext(), "MOBISEC{peppa-9876543-BAAAM-A1z9-3133337}");
//        printAllKLength(set1, k);

//        String strkey = "abc";
//        byte[] key = strkey.getBytes();
//        String str = "abc";
//        byte[] in = str.getBytes();

//        for(int i=34; i<=255; i++){
//            for(int j=0; j<=255; j++){
//                for(int h=0; h<=255; h++){
//                    try {
//                        byte[] currKey = new byte[0];
//                        currKey = hash(new byte[]{(byte) i, (byte) j, (byte) h});
////
//                        String out = "0eef68c5ef95b67428c178f045e6fc8389b36a67bbbd800148f7c285f938a24e696ee2925e12ecf7c11f35a345a2a142639fe87ab2dd7530b29db87ca71ffda2af558131d7da615b6966fb0360d5823b79c26608772580bf14558e6b7500183ed7dfd41dbb5686ea92111667fd1eff9cec8dc29f0cfe01e092607da9f7c2602f5463a361ce5c83922cb6c3f5b872dcc088eb85df80503c92232bf03feed304d669ddd5ed1992a26674ecf2513ab25c20f95a5db49fdf6167fda3465a74e0418b2ea99eb2673d4c7e1ff7c4921c4e2d7b";

//            String done = decrypt(out, currKey);
//            Log.d("MOBISEC", done);
//            String plain = "HelloMobisec";
//            byte[] cipherBytes = encrypt(plain.getBytes(), currKey);
//            String cipher = toHex(cipherBytes);
//            Log.d("MOBISEC", cipher);

//            try {
//                currKey = hash(new byte[]{(byte) 255, (byte) 255, (byte) 255});
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

//            String done = decrypt(fromHexString(cipher), currKey);
//            Log.d("MOBISEC", done);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//                        TextView tv = (TextView) findViewById(R.id.tv);
//
//                        String decrypted = "";
//                        for(int times = 10; times >=0; times--){
//                            for (int count = 0; count < times; count++) {
////                            Log.i("MOBISEC", "Tried "+ Integer.toString(i) + "-" + Integer.toString(j) + "-" + Integer.toString(h));
//                                currKey = hash(currKey);
//                            }
//                            decrypted = decrypt(fromHexString(out), currKey);
////                            Log.d("MOBISEC", "Found "+ Integer.toString(i) + "-" + Integer.toString(j) + "-" + Integer.toString(h));
//                            if(times!=10){
//                                Log.i("MOBISEC", Integer.toString(times) + " Found "+ Integer.toString(i) + "-" + Integer.toString(j) + "-" + Integer.toString(h));
//                            }
//
//                        }
//
////                        Log.d("MOBISEC", decrypted);
//                        Log.w("MOBISEC", i + " " + j + " " + h);
//                        if(decrypted.startsWith("MOBISEC{")){
//                            Log.e("MOBISEC", decrypted);
//
//                        }
//                        tv.setText(tv.getText() + "\n" + Integer.toString(i) + "-" + Integer.toString(j) + "-" + Integer.toString(h));
//                        tv.setText(tv.getText() + "\n" + decrypted);
//                        return;
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }

//        try {
//            String a = toHex(encrypt(in, hash(key)));
//            Log.d("MOBISEC", a);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    public static byte[] hash(byte[] in) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(in);
        return md.digest();
    }

    public static String decrypt(byte[] in, byte[] key) throws Exception {
        Key aesKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, aesKey);

        cipher.init(2, aesKey);
        String a = new String(cipher.doFinal(in));
        return a;
//        encryptCipher.init(Cipher.DECRYPT_MODE, aesKey);
//        byte[] decryptedBytes = encryptCipher.doFinal(in);
//        String decryptedText = new String(decryptedBytes, "UTF8");
//        return decryptedText;
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(in);
//        CipherInputStream cipherInputStream= new CipherInputStream(inputStream, encryptCipher);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//
//        byte[] b = new byte[1024];
//        int numberOfBytedRead;
//        while ((numberOfBytedRead = cipherInputStream.read(b)) >= 0) {
//            baos.write(b, 0, numberOfBytedRead);
//        }
//        return new String(baos.toByteArray());
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

    public static String toHex(byte[] bytes) {
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

    public static byte[] fromHexString(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    private static String dh(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            return toHexString(md.digest());
        } catch (Exception e) {
            return null;
        }
    }

    static void printAllKLength(char[] set, int k) {
        int n = set.length;
        printAllKLengthRec(set, "", n, k);
    }

    static void printAllKLengthRec(char[] set,
                                   String prefix,
                                   int n, int k) {

        // Base case: k is 0,
        // print prefix
        if (k == 0) {
//            Log.d("MOBISEC", prefix);
            if (dh(prefix).equals("1885eca5a40bc32d5e1bca61fcd308a5")) {
                Log.e("MOBISEC", prefix);
                return;
            }
            return;
        }

        // One by one add all characters
        // from set and recursively
        // call for k equals to k-1
        for (int i = 0; i < n; ++i) {

            // Next character of input added
            String newPrefix = prefix + set[i];

            // k is decreased, because
            // we have added a new character
            printAllKLengthRec(set, newPrefix,
                    n, k - 1);
        }
    }

    private static String toHexString(byte[] bytes) {
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

    private static String gs(String a, String b) {
        String s = BuildConfig.FLAVOR;
        for (int i = 0; i < a.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(Character.toString((char) (a.charAt(i) ^ b.charAt(i % b.length()))));
            s = sb.toString();
        }
        return s;
    }

    public static String foo() {
        char[] syms = new char[4];
        int[] idxs = {13, 21, 27, 32};
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < syms.length; i++) {
            syms[i] = '0';
            chars.add(Character.valueOf(syms[i]));
        }
        int sum = 0;
        for (char c : syms) {
            sum += c;
        }
        return Integer.toString(sum);
    }

}
