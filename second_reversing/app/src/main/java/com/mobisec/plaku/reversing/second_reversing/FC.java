package com.mobisec.plaku.reversing.second_reversing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.MotionEventCompat;
import com.mobisec.plaku.reversing.second_reversing.Activity;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.sql.BatchUpdateException;
import java.util.IllegalFormatCodePointException;
import java.util.IllformedLocaleException;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;

public class FC {
    public static Context ctx = null;
    public static long[][] m = ((long[][]) Array.newInstance(long.class, new int[]{256, 256}));

    /* JADX WARNING: Code restructure failed: missing block: B:243:0x03b7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x03b8, code lost:
        r22 = r4;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x03bc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x03bd, code lost:
        r22 = r4;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x03c1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x03c2, code lost:
        r19 = r3;
        r22 = r4;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x03cb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x03cc, code lost:
        r19 = r3;
        r22 = r4;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x04d3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x04d4, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x04d7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x04d8, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x04db, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x04dc, code lost:
        r1 = r0;
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x04e0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x04e1, code lost:
        r1 = r0;
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x04e5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x04e6, code lost:
        r1 = r0;
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x0529, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x052a, code lost:
        r1 = r0;
        r2 = r7;
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x052e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x052f, code lost:
        r1 = r0;
        r2 = r7;
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x0533, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x0534, code lost:
        r1 = r0;
        r2 = r7;
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x0538, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x0539, code lost:
        r1 = r0;
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x053d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x053e, code lost:
        r1 = r0;
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x0544, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x0545, code lost:
        r3 = true;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x054b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x054c, code lost:
        r3 = true;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x0552, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0553, code lost:
        r3 = true;
        r1 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x023d A[SYNTHETIC, Splitter:B:119:0x023d] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x02d0 A[Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x031e A[Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0320 A[Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x03ee A[Catch:{ BatchUpdateException -> 0x04cd, CertificateEncodingException -> 0x04c7, RejectedExecutionException -> 0x04c1, GeneralSecurityException -> 0x04bc, Exception -> 0x04b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x04b1 A[SYNTHETIC, Splitter:B:308:0x04b1] */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x04d3 A[ExcHandler: Exception (r0v22 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:202:0x0340] */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x04d7 A[ExcHandler: GeneralSecurityException (r0v21 'e' java.security.GeneralSecurityException A[CUSTOM_DECLARE]), Splitter:B:202:0x0340] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x04db A[ExcHandler: RejectedExecutionException (r0v20 'e' java.util.concurrent.RejectedExecutionException A[CUSTOM_DECLARE]), Splitter:B:202:0x0340] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x04e5 A[ExcHandler: BatchUpdateException (r0v18 'e' java.sql.BatchUpdateException A[CUSTOM_DECLARE]), Splitter:B:202:0x0340] */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x04f0 A[Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }] */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x0529 A[ExcHandler: RejectedExecutionException (r0v7 'e' java.util.concurrent.RejectedExecutionException A[CUSTOM_DECLARE]), PHI: r7
  PHI: (r7v5 'idx' int) = (r7v0 'idx' int), (r7v15 'idx' int), (r7v15 'idx' int), (r7v19 'idx' int), (r7v19 'idx' int), (r7v20 'idx' int), (r7v19 'idx' int), (r7v19 'idx' int) binds: [B:3:0x001d, B:294:0x0496, B:267:0x0403, B:175:0x02b9, B:184:0x02df, B:331:0x04ea, B:188:0x0310, B:185:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:3:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x052e A[ExcHandler: CertificateEncodingException (r0v6 'e' java.security.cert.CertificateEncodingException A[CUSTOM_DECLARE]), PHI: r7
  PHI: (r7v4 'idx' int) = (r7v0 'idx' int), (r7v15 'idx' int), (r7v15 'idx' int), (r7v19 'idx' int), (r7v19 'idx' int), (r7v20 'idx' int), (r7v19 'idx' int), (r7v19 'idx' int) binds: [B:3:0x001d, B:294:0x0496, B:267:0x0403, B:175:0x02b9, B:184:0x02df, B:331:0x04ea, B:188:0x0310, B:185:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:3:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0533 A[ExcHandler: BatchUpdateException (r0v5 'e' java.sql.BatchUpdateException A[CUSTOM_DECLARE]), PHI: r7
  PHI: (r7v3 'idx' int) = (r7v0 'idx' int), (r7v15 'idx' int), (r7v15 'idx' int), (r7v19 'idx' int), (r7v19 'idx' int), (r7v20 'idx' int), (r7v19 'idx' int), (r7v19 'idx' int) binds: [B:3:0x001d, B:294:0x0496, B:267:0x0403, B:175:0x02b9, B:184:0x02df, B:331:0x04ea, B:188:0x0310, B:185:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:3:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x0538 A[ExcHandler: Exception (r0v4 'e' java.lang.Exception A[CUSTOM_DECLARE]), PHI: r7
  PHI: (r7v2 'idx' int) = (r7v0 'idx' int), (r7v0 'idx' int), (r7v0 'idx' int), (r7v15 'idx' int), (r7v15 'idx' int), (r7v19 'idx' int), (r7v20 'idx' int), (r7v19 'idx' int) binds: [B:1:0x001b, B:2:?, B:3:0x001d, B:294:0x0496, B:267:0x0403, B:175:0x02b9, B:331:0x04ea, B:188:0x0310] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x053d A[ExcHandler: GeneralSecurityException (r0v3 'e' java.security.GeneralSecurityException A[CUSTOM_DECLARE]), PHI: r7
  PHI: (r7v1 'idx' int) = (r7v0 'idx' int), (r7v0 'idx' int), (r7v0 'idx' int), (r7v15 'idx' int), (r7v15 'idx' int), (r7v19 'idx' int), (r7v19 'idx' int), (r7v20 'idx' int), (r7v19 'idx' int), (r7v19 'idx' int) binds: [B:1:0x001b, B:2:?, B:3:0x001d, B:294:0x0496, B:267:0x0403, B:175:0x02b9, B:184:0x02df, B:331:0x04ea, B:188:0x0310, B:185:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0138 A[EDGE_INSN: B:380:0x0138->B:51:0x0138 ?: BREAK
EDGE_INSN: B:380:0x0138->B:51:0x0138 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0093 A[Catch:{ IllegalFormatCodePointException -> 0x0278 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0095 A[Catch:{ IllegalFormatCodePointException -> 0x0278 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00dc A[Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0142 A[Catch:{ IllegalFormatCodePointException -> 0x024d }] */
    @SuppressLint("WrongConstant")
    public static boolean checkFlag(Context ctx2, String fl) {
        boolean z;
        boolean z2;
        boolean z3;
        int idx;
        String hexString;
        int idx2;
        int idx3;
        int idx4;
        boolean z4;
        int idx5;
        boolean found;
        int length;
        int i;
        boolean found2;
        int idx6;
        Context context = ctx2;
        String str = fl;
        String str2 = " ";
        String str3 = "mayb";
        Activity.initActivity((MainActivity) context);
        if (MainActivity.g1) {
            Log.e(str, "g1 was true");
            MainActivity.g1 = false;
        }
        if (MainActivity.g2) {
            Log.e(str, "g2 was true");
            MainActivity.g2 = false;
        }
        if (MainActivity.g3) {

            Log.e(str, "g3 was true");
            MainActivity.g3 = false;
        }
        if (MainActivity.g4) {
            Log.e(str, "g4 was true");
            MainActivity.g4 = false;
        }
        ctx = context;
        boolean[] fs = new boolean[200];
        Streamer s = new Streamer();
        int idx7 = 0;
        try {
            lm(m);
            if (fl.length() != 69) {
                return false;
            }
            int idx8 = 0 + 1;
            try {
                fs[0] = str.startsWith("MOBISEC{");
                String core = str.substring(8);
                int idx9 = idx8 + 1;
                try {
                    fs[idx8] = core.endsWith("}");
                    boolean f = true;
                    try {
                        s.step();
                        if (MainActivity.g2) {
                            return false;
                        }
                        s.step();
                        s.step();
                        int idx10 = idx9 + 1;
                        try {
                            fs[idx9] = core.startsWith("this_is_");
                            idx4 = idx10 + 1;
                        } catch (Exception e7) {
                            Exception exc = e7;
                            int i7 = idx10;
                            return false;
                        }
                        try {
                            fs[idx10] = core.endsWith("upos");
                            int idx11 = idx4 + 1;
                            try {
                                if (core.charAt(10) != 'c') {
                                    if (core.charAt(13) != 'q') {
                                        z4 = false;
                                        fs[idx4] = z4;
                                        idx5 = idx11 + 1;
                                        fs[idx11] = core.charAt(3) + core.charAt(7) != 114;
                                        s.step();
                                        idx3 = idx5 + 1;
                                        try {
                                            fs[idx5] = core.contains("really_");
                                            found = false;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(dec(context.getString(R.string.s1)));
                                            sb.append(str2);
                                            sb.append(dec(context.getString(R.string.s2)));
                                            String[] lines = ec(sb.toString()).split("\n");
                                            length = lines.length;
                                            i = 0;
                                            while (true) {
                                                if (i < length) {
                                                    break;
                                                }
                                                String line = lines[i];
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append(dec(context.getString(R.string.s3)));
                                                sb2.append(str2);
                                                sb2.append(dec(context.getString(R.string.s2)));
                                                sb2.append("/");
                                                sb2.append(line);
                                                sb2.append("/maps");
                                                String maps = sb2.toString();
                                                String str4 = maps;
                                                if (ec(maps).contains(dec(context.getString(R.string.s4)))) {
                                                    found = true;
                                                    break;
                                                }
                                                i++;
                                                String str5 = fl;
                                            }
                                            idx = idx3 + 1;
                                        } catch (Exception e8) {

                                            return false;
                                        }
                                        try {
                                            Log.d("MOBISEC", "making found true, i thing it is is the same as g4");
                                            found=true;
                                            fs[idx3] = found;
                                            if (fs[idx - 1]) {
                                                s.step();
                                                int idx12 = idx + 1;
                                                try {
                                                    fs[idx] = core.substring(14).endsWith("_evil");
                                                    idx = idx12 + 1;
                                                    fs[idx12] = core.substring(9, 13).endsWith("bam");
                                                    s.step();
                                                    if (MainActivity.g4) {
                                                        return false;
                                                    }
                                                    s.step();
                                                    try {
                                                        found2 = false;
                                                        Iterator it = ctx2.getPackageManager().getInstalledApplications(128).iterator();
                                                        while (true) {
                                                            if (it.hasNext()) {
                                                                if (((ApplicationInfo) it.next()).packageName.equals(dec(context.getString(R.string.s5)))) {
                                                                    found2 = true;
                                                                    break;
                                                                }
                                                            } else {
                                                                break;
                                                            }
                                                        }
                                                        idx6 = idx + 1;
                                                    } catch (Exception e16) {
                                                        return false;
                                                    }
                                                    try {
                                                        Log.d("MOBISEC", "MAKING ANOTHER found2 false");
                                                        found2 = false;
                                                        fs[idx] = found2;
                                                        s.step();
                                                        idx = idx6 + 1;
                                                        fs[idx6] = core.substring(4, 10).toLowerCase().equals("incred");
                                                        if (MainActivity.g1) {
                                                            return false;
                                                        }
                                                        s.step();
                                                        s.step();
                                                        s.step();
                                                        s.step();
                                                        s.step();
                                                        s.step();

                                                        int idx13 = idx + 1;
                                                        fs[idx] = core.toLowerCase().substring(11, 14).charAt(1) == '4';
                                                        int idx14 = idx13 + 1;
                                                        try {
                                                            fs[idx13] = core.substring(22).toUpperCase().startsWith(str3);
                                                            PackageManager pm = ctx2.getPackageManager();
                                                            String packageName = ctx2.getPackageName();
                                                            PackageInfo packageInfo = null;
                                                            try {
                                                                packageInfo = pm.getPackageInfo(packageName, 64);
                                                            } catch (NameNotFoundException e18) {
                                                                e18.printStackTrace();
                                                            }
                                                            InputStream input = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
                                                            CertificateFactory cf = null;
                                                            try {
                                                                cf = CertificateFactory.getInstance("X509");
                                                            } catch (CertificateException e19) {
                                                                e19.printStackTrace();
                                                            }
                                                            X509Certificate c = null;
                                                            try {
                                                                c = (X509Certificate) cf.generateCertificate(input);
                                                            } catch (Exception e20) {
                                                                e20.printStackTrace();
                                                            }
                                                            String str6 = packageName;
                                                            hexString = th(MessageDigest.getInstance("SHA1").digest(c.getEncoded()));
                                                        } catch (Exception e27) {
                                                            return false;
                                                        }
                                                        idx2 = idx14 + 1;
                                                        try {
//                                                            fs[idx14] = hexString.equals(context.getString(R.string.s6));
                                                            fs[idx14] = true;
//                                                          //Should make fs[0] and fs[1] true
                                                            if (!fs[idx2 - 1]) {
                                                                throw new GeneralSecurityException();
                                                            } else if (!fs[0] || !fs[1]) {
                                                                return false;
                                                            } else {
//                                                                s.step();
//                                                                s.step();
//                                                                s.step();
                                                                int i14 = 0;
                                                                idx7 = 100;
                                                                while (i14 < 30) {
                                                                    fs[idx7] = true;
                                                                    StringBuilder sb3 = new StringBuilder();
                                                                    sb3.append(Character.toString(core.charAt(i14 * 2)));
                                                                    sb3.append(Character.toString(core.charAt((i14 * 2) + 1)));
                                                                    String curr = sb3.toString();
//                                                                    if(i14==0){
//                                                                        s = new Streamer("01100010000", 8);
//                                                                    }
                                                                    if (ip(i14)) {
                                                                        for (int j = 0; j < i14; j++) {
                                                                            s.step();
                                                                        }
                                                                    }
                                                                    if (sq(r(curr)) != m[s.g2() & 255][(s.g2() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8]) {
                                                                        int idx15 = idx7 + 1;
                                                                        try {
                                                                            fs[idx7] = false;
                                                                            idx7 = idx15;
                                                                        } catch (Exception e32) {
                                                                            return false;
                                                                        }
                                                                    } else {
                                                                        idx7++;
                                                                    }
                                                                    i14++;
                                                                    Context context2 = ctx2;
                                                                }
                                                                for (int i20 = idx7 - 30; i20 < idx7; i20++) {
                                                                    if (!fs[i20]) {
//                                                                        return false;
                                                                        Log.d("MOBISEC", Integer.toString(i20) + "was false");

                                                                    }
                                                                }
                                                                if (!h(fl).equals("4193d9b72a5c4805e9a5cc739f8a8fc23b2890e13b83bb887d96f86c30654a12")) {
                                                                    return false;
                                                                }
                                                                return true;
                                                            }
                                                        } catch (Exception e37) {
                                                            return false;
                                                        }
                                                    } catch (Exception e43) {
                                                        return false;
                                                    }
                                                } catch (Exception e45) {
                                                    return false;
                                                }
                                            } else {
                                                throw new BatchUpdateException();
                                            }
                                        } catch (Exception e53) {

                                            return false;
                                        }
                                    }
                                }
                                z4 = true;
                                fs[idx4] = z4;
                                idx5 = idx11 + 1;
                                try {
                                    fs[idx11] = core.charAt(3) + core.charAt(7) != 114;
                                    s.step();
                                    idx3 = idx5 + 1;
                                    fs[idx5] = core.contains("really_");
                                    found = false;
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append(dec(context.getString(R.string.s1)));
                                    sb4.append(str2);
                                    sb4.append(dec(context.getString(R.string.s2)));
                                    String[] lines2 = ec(sb4.toString()).split("\n");
                                    length = lines2.length;
                                    i = 0;
                                    while (true) {
                                        if (i < length) {
                                        }
                                        i++;
                                        String str52 = fl;
                                    }

                                } catch (Exception e54) {

                                    return false;
                                }
                            } catch (Exception e55) {

                                return false;
                            }
                        } catch (Exception e56) {
                            return false;
                        }
                    }  catch (Exception e59) {
                        return false;
                    }
                } catch (Exception e60) {
                    return false;
                }
            } catch (Exception e65) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private static String h(String flag) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(flag.getBytes());
            return th(md.digest());
        } catch (Exception e) {
            return null;
        }
    }

    public static String th(byte[] bytes) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r2 != 256) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
        throw new java.lang.Exception(r5);
     */
    public static void lm(long[][] matrix) throws Exception {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(ctx.getAssets().open("lotto.dat")));
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
    }

    public static boolean ip(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
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

    public static long sq(String a) {
        return (long) Math.pow((double) ((a.charAt(0) + (a.charAt(1) << 8)) & SupportMenu.USER_MASK), 2.0d);
    }

    public static String dec(String x) {
        return new String(Base64.decode(x, 0));
    }

    public static String ec(String cmd) {
        String out = new String();
        try {
            InputStream stdout = Runtime.getRuntime().exec(cmd).getInputStream();
            byte[] buffer = new byte[102400];
            while (true) {
                int read = stdout.read(buffer);
                if (read > 0 && read <= 102400) {
                    String line = new String(buffer, 0, read);
                    StringBuilder sb = new StringBuilder();
                    sb.append(out);
                    sb.append(line);
                    out = sb.toString();
                } else if (stdout.available() <= 0) {
                    break;
                }
            }
            stdout.close();
        } catch (Exception e) {
        }
        return out;
    }
}