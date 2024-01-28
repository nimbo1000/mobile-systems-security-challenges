package com.mobisec.plaku.reversing.second_reversing;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.internal.view.SupportMenu;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.sql.BatchUpdateException;
import java.util.IllformedLocaleException;
import java.util.Iterator;

public class upos {
    public static Context ctx = null;
    public static long[][] m = ((long[][]) Array.newInstance(long.class, new int[]{256, 256}));

//    public static boolean checkFlag(Context context_param, String flag_param) {
//        boolean z;
//        boolean z2;
//        boolean z3;
//        int idx;
//        String hexString;
//        int idx2;
//        int idx3;
//        int idx4;
//        boolean z4;
//        int idx5;
//        boolean found;
//        int length;
//        int i;
//        boolean found2;
//        int idx6;
//        Context context = context_param;
//        String flag = flag_param;
//        String empty_space_str = " ";
//        String mayb = "mayb";
////        Activity.initActivity((MainActivity) context);
//        ctx = context;
//        boolean[] booleans = new boolean[200];
//        Streamer s = new Streamer();
//        int idx7 = 0;
//
////        lm(m);
//
//        if (flag_param.length() != 69) {
//            return false;
//        }
//        int idx8 = 0 + 1;
//
//        booleans[0] = flag.startsWith("MOBISEC{");
//        String flag_core_substring = flag.substring(8);
//        int idx9 = idx8 + 1;
//        booleans[idx8] = flag_core_substring.endsWith("}");
//        boolean f = true;
//        int idx10 = idx9 + 1;
//
//        booleans[idx9] = flag_core_substring.startsWith("this_is_");
//        idx4 = idx10 + 1;
//        booleans[idx10] = flag_core_substring.endsWith("upos");//same thing endswith } and endswith upos
//        int idx11 = idx4 + 1;
//        if (flag_core_substring.charAt(10) != 'c') {
//            if (flag_core_substring.charAt(13) != 'q') {
//                z4 = false;
//                booleans[idx4] = z4;
//                idx5 = idx11 + 1;
//                booleans[idx11] = flag_core_substring.charAt(3) + flag_core_substring.charAt(7) != 114;
//                s.step();
//                idx3 = idx5 + 1;
//                booleans[idx5] = flag_core_substring.contains("really_");
//                found = false;
//                StringBuilder sb = new StringBuilder();
//                sb.append(dec(context.getString(R.string.s1)));
//                sb.append(empty_space_str);
//                sb.append(dec(context.getString(R.string.s2)));
//                String[] lines = ec(sb.toString()).split("\n");
//                length = lines.length;
//                i = 0;
//                while (true) {
//                    if (i < length) {
//                        break;
//                    }
//                    String line = lines[i];
//                    StringBuilder sb2 = new StringBuilder();
//                    sb2.append(dec(context.getString(R.string.s3)));
//                    sb2.append(empty_space_str);
//                    sb2.append(dec(context.getString(R.string.s2)));
//                    sb2.append("/");
//                    sb2.append(line);
//                    sb2.append("/maps");
//                    String maps = sb2.toString();
//                    String str4 = maps;
//                    if (ec(maps).contains(dec(context.getString(R.string.s4)))) {
//                        found = true;
//                        break;
//                    }
//                    i++;
//                    String flag_param1 = flag_param;
//                }
//                idx = idx3 + 1;
//                booleans[idx3] = found;
//                if (booleans[idx - 1]) {
//                    s.step();
//                    int idx12 = idx + 1;
//                    booleans[idx] = flag_core_substring.substring(14).endsWith("_evil");
//                    idx = idx12 + 1;
//                    booleans[idx12] = flag_core_substring.substring(9, 13).endsWith("bam");
//                    s.step();
//                    if (MainActivity.g4) {
//                        return false;
//                    }
//                    s.step();
//                    found2 = false;
//                    Iterator it = context_param.getPackageManager().getInstalledApplications(128).iterator();
//                    while (true) {
//                        if (it.hasNext()) {
//                            if (((ApplicationInfo) it.next()).packageName.equals(dec(context.getString(R.string.s5)))) {
//                                found2 = true;
//                                break;
//                            }
//                        } else {
//                            break;
//                        }
//                    }
//                    idx6 = idx + 1;
//                    idx3 = idx;
//
//                    idx7 = idx3 + 1;
//                    booleans[idx3] = flag_core_substring.substring(22).toUpperCase().startsWith(mayb);
//                    s.step();
//                    if (!booleans[idx7 - 3]) {
//                    }
//                    booleans[idx] = found2;
//                    s.step();
//                    idx = idx6 + 1;
//                    booleans[idx6] = flag_core_substring.substring(4, 10).toLowerCase().equals("incred");
//                    if (MainActivity.g1) {
//                        return false;
//                    }
//                    s.step();
//                    if (s.step() > 0 || !MainActivity.g1) {
//                        throw new IllformedLocaleException();
//                    }
//                    s.step();
//                    s.step();
//                    s.step();
//                    s.step();
//                    s.step();
//                    if (!f) {
//                        return false;
//                    }
//                    int idx13 = idx + 1;
//                    booleans[idx] = flag_core_substring.toLowerCase().substring(11, 14).charAt(1) == '4';
//                    int idx14 = idx13 + 1;
//                    booleans[idx13] = flag_core_substring.substring(22).toUpperCase().startsWith(mayb);
//                    PackageManager pm = context_param.getPackageManager();
//                    String packageName = context_param.getPackageName();
//                    PackageInfo packageInfo = null;
//                    packageInfo = pm.getPackageInfo(packageName, 64);
//                    InputStream input = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
//                    CertificateFactory cf = null;
//                    cf = CertificateFactory.getInstance("X509");
//                    X509Certificate c = null;
//                    c = (X509Certificate) cf.generateCertificate(input);
//                    PackageManager packageManager = pm;
//                    String str6 = packageName;
//                    hexString = th(MessageDigest.getInstance("SHA1").digest(c.getEncoded()));
//                    idx2 = idx14 + 1;
//                    booleans[idx14] = hexString.equals(context.getString(R.string.s6));
//                    if (!booleans[idx2 - 1]) {
//                        throw new GeneralSecurityException();
//                    } else if (!booleans[0] || !booleans[1]) {
//                        return false;
//                    } else {
//                        int i14 = 0;
//                        idx7 = 100;
//                        while (i14 < 30) {
//                            booleans[idx7] = true;
//                            StringBuilder sb3 = new StringBuilder();
//                            sb3.append(Character.toString(flag_core_substring.charAt(i14 * 2)));
//                            sb3.append(Character.toString(flag_core_substring.charAt((i14 * 2) + 1)));
//                            String curr = sb3.toString();
//                            if (ip(i14)) {
//                                for (int j = 0; j < i14; j++) {
//                                    s.step();
//                                }
//                            }
//                            if (sq(r(curr)) != m[s.g2() & 255][(s.g2() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8]) {
//                                int idx15 = idx7 + 1;
//                                booleans[idx7] = false;
//                                idx7 = idx15;
//                            } else {
//                                idx7++;
//                            }
//                            i14++;
//                            Context context2 = context_param;
//                        }
//                        for (int i20 = idx7 - 30; i20 < idx7; i20++) {
//                            if (!booleans[i20]) {
//                                return false;
//                            }
//                        }
//                        if (!h(flag_param).equals("4193d9b72a5c4805e9a5cc739f8a8fc23b2890e13b83bb887d96f86c30654a12")) {
//                            return false;
//                        }
//                        return true;
//                    }
//                } else {
//                    throw new BatchUpdateException();
//                }
//            }
//        }
//        z4 = true;
//        booleans[idx4] = z4;
//        idx5 = idx11 + 1;
//        booleans[idx11] = flag_core_substring.charAt(3) + flag_core_substring.charAt(7) != 114;
//        s.step();
//        idx3 = idx5 + 1;
//        booleans[idx5] = flag_core_substring.contains("really_");
//        found = false;
//        StringBuilder sb4 = new StringBuilder();
//        sb4.append(dec(context.getString(R.string.s1)));
//        sb4.append(empty_space_str);
//        sb4.append(dec(context.getString(R.string.s2)));
//        String[] lines2 = ec(sb4.toString()).split("\n");
//        length = lines2.length;
//        i = 0;
//        while (true) {
//            if (i < length) {
//            }
//            i++;
//            String str52 = flag_param;
//        }
//        idx = idx3 + 1;
//        booleans[idx3] = found;
//        if (booleans[idx - 1]) {
//        }
//
//    }

//    public static boolean checkFlag(android.content.Context r28, java.lang.String r29) {
//        /*
//        1==================================================
//            r1 = r28  //context
//            r2 = r29 //flag
//            java.lang.String r3 = " "
//            java.lang.String r4 = "mayb"
//            r5 = r1 //context
//            com.mobisec.upos.MainActivity r5 = (com.mobisec.upos.MainActivity) r5
//            android.support.v7.app.Activity.initActivity(r5)
//            ctx = r1
//            r5 = 200(0xc8, float:2.8E-43)
//            //array of 200 false itemes [false, false, false ....]
//            boolean[] r5 = new boolean[r5] //0xc8
//            com.mobisec.upos.Streamer r6 = new com.mobisec.upos.Streamer
//            r6.<init>()
//            r7 = 0
//            r8 = 0
//            //not sure what the following 2 lines do. Reads lotto.dat from assets
//            long[][] r10 = m     // Catch:{ BatchUpdateException -> 0x0552, CertificateEncodingException -> 0x054b, RejectedExecutionException -> 0x0544, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            lm(r10)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            //This is the length of flag
//            int r10 = r29.length()     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r11 = 69
//            if (r10 == r11) goto L_0x0029
//            return r8
//        2==================================================
//        L_0x0029:   //LENGTH IS 69
//            //r10=1
//            int r10 = r7 + 1 //= 1
//            java.lang.String r11 = "MOBISEC{"
//            //r2 is the flag
//            //r11 = true
//            boolean r11 = r2.startsWith(r11)     // Catch:{ BatchUpdateException -> 0x0524, CertificateEncodingException -> 0x051f, RejectedExecutionException -> 0x051a, GeneralSecurityException -> 0x0516, Exception -> 0x0512 }
//            //boolean[] r5 = new boolean[0xc8]  //0000 0100
//            //r5[0] = true
//            r5[r7] = r11     // Catch:{ BatchUpdateException -> 0x0524, CertificateEncodingException -> 0x051f, RejectedExecutionException -> 0x051a, GeneralSecurityException -> 0x0516, Exception -> 0x0512 }
//            //r7 = 8
//            r7 = 8
//            //r11 = flag without MOBISEC{
//            java.lang.String r11 = r2.substring(r7)     // Catch:{ BatchUpdateException -> 0x0524, CertificateEncodingException -> 0x051f, RejectedExecutionException -> 0x051a, GeneralSecurityException -> 0x0516, Exception -> 0x0512 }
//            //r12 = 2
//            int r12 = r10 + 1
//            //r13 = "}"
//            java.lang.String r13 = "}"
//            //r13 = true
//            boolean r13 = r11.endsWith(r13)     // Catch:{ BatchUpdateException -> 0x050c, CertificateEncodingException -> 0x0506, RejectedExecutionException -> 0x0500, GeneralSecurityException -> 0x04fb, Exception -> 0x04f6 }
//            //r5[1]=true
//            r5[r10] = r13     // Catch:{ BatchUpdateException -> 0x050c, CertificateEncodingException -> 0x0506, RejectedExecutionException -> 0x0500, GeneralSecurityException -> 0x04fb, Exception -> 0x04f6 }
//            //r10=1
//            r10 = 1
//*            r6.step()     // Catch:{ IllformedLocaleException -> 0x02b2, NullPointerException -> 0x02ad }
//            //r15=false
//            boolean r15 = com.mobisec.upos.MainActivity.g2     // Catch:{ IllformedLocaleException -> 0x02b2, NullPointerException -> 0x02ad }
//            //goto L_0x004c
//            if (r15 == 0) goto L_0x004c
//            return r8
//        3==================================================
//        L_0x004c:
//*            r6.step()     // Catch:{ IllformedLocaleException -> 0x02b2, NullPointerException -> 0x02ad }
//*            r6.step()     // Catch:{ IllformedLocaleException -> 0x02b2, NullPointerException -> 0x02ad }
//            //r15=3
//            int r15 = r12 + 1
//            //r7="this_is_
//            java.lang.String r7 = "this_is_"
//            //r7=true
//            boolean r7 = r11.startsWith(r7)     // Catch:{ IllformedLocaleException -> 0x02a9, NullPointerException -> 0x02a5, BatchUpdateException -> 0x029f, CertificateEncodingException -> 0x0299, RejectedExecutionException -> 0x0293, GeneralSecurityException -> 0x028e, Exception -> 0x0289 }
//            //r5[2]=true
//            r5[r12] = r7     // Catch:{ IllformedLocaleException -> 0x02a9, NullPointerException -> 0x02a5, BatchUpdateException -> 0x029f, CertificateEncodingException -> 0x0299, RejectedExecutionException -> 0x0293, GeneralSecurityException -> 0x028e, Exception -> 0x0289 }
//            //r7=3
//            int r7 = r15 + 1
//            //r12="upos"
//            java.lang.String r12 = "upos"
//            //r12=true
//            boolean r12 = r11.endsWith(r12)     // Catch:{ IllformedLocaleException -> 0x0285, NullPointerException -> 0x0281 }
//            //r5[3]=true
//            r5[r15] = r12     // Catch:{ IllformedLocaleException -> 0x0285, NullPointerException -> 0x0281 }
//            //r12=4
//            int r12 = r7 + 1
//            //r15=10
//            r15 = 10
//            //r11 is the flag without MOBISEC{
//            //r9= char at 8+15 = 23rd character of flag
//            char r9 = r11.charAt(r15)     // Catch:{ IllegalFormatCodePointException -> 0x027c }
//            //r14=99
//            r14 = 99
//            //r15=13
//            r15 = 13
//!Might take another path
//            //if r9=99(ascii c) go to r9=0
//            if (r9 == r14) goto L_0x007f
//            //r9= char at 8+13 = 21st character of flag
//            char r9 = r11.charAt(r15)     // Catch:{ IllegalFormatCodePointException -> 0x027c }
//            //r14=113 (ascii q)
//            r14 = 113(0x71, float:1.58E-43)
//            if (r9 != r14) goto L_0x007d
//            goto L_0x007f
//        4...==================================================
//        L_0x007d:
//            r9 = 0
//            goto L_0x0080
//        L_0x007f:
//            r9 = 1
//        L_0x0080:
//            //r5[3]= 1 or 0
//            r5[r7] = r9     // Catch:{ IllegalFormatCodePointException -> 0x027c }
//            //r7=5
//            int r7 = r12 + 1
//            //r9=3
//            r9 = 3
//            //r9= char at 8+3 = i
//            char r9 = r11.charAt(r9)     // Catch:{ IllegalFormatCodePointException -> 0x0278 }
//            //r14=7
//            r14 = 7
//            //r14 = 's' char at 8+7 of the flag
//            char r14 = r11.charAt(r14)     // Catch:{ IllegalFormatCodePointException -> 0x0278 }
//            int r9 = r9 + r14
//            r14 = 114(0x72, float:1.6E-43)
//            if (r9 != r14) goto L_0x0095
//            r9 = 1
//            goto L_0x0096
//        L_0x0095:
//            r9 = 0
//        5==================================================
//        L_0x0096:
//            r5[r12] = r9     // Catch:{ IllegalFormatCodePointException -> 0x0278 }
//            r6.step()     // Catch:{ IllegalFormatCodePointException -> 0x0278 }
//            //r9=6?
//            int r9 = r7 + 1
//            //r12="really_"
//            java.lang.String r12 = "really_"
//            //r12=true
//            boolean r12 = r11.contains(r12)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            //r5[6]=true
//            r5[r7] = r12     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            //r7=0
//            r7 = 0
//            //r12=StringBuilder()
//            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            r12.<init>()     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            ////r14=0x7f0b0028 id of a string resource
//            r14 = 2131427368(0x7f0b0028, float:1.847635E38)
//            //r14="bHM=" string resource at the following id
//            java.lang.String r14 = r1.getString(r14)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            //r14="ls"
//            java.lang.String r14 = dec(r14)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            //r12 = "ls "
//            r12.append(r14)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            r12.append(r3)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            //r14=0x7f0b0029 (resource id)
//            r14 = 2131427369(0x7f0b0029, float:1.8476352E38)
//            //r20="L3Byb2M="
//            java.lang.String r20 = r1.getString(r14)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            //r8="/proc"
//            java.lang.String r8 = dec(r20)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            //r12="ls /proc"
//            r12.append(r8)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            r8="ls /proc"
//            java.lang.String r8 = r12.toString()     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            //r8=result of ec("ls /proc"
//            java.lang.String r8 = ec(r8)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            //r12="\n"
//            java.lang.String r12 = "\n"
//            //r8=array of result from ec(ls /proc).split("\n")
//            java.lang.String[] r8 = r8.split(r12)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            //r12=length of ec("ls /proc").split("\n")
//            int r12 = r8.length     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            //r15=0
//            r15 = 0
//        6==================================================
//        L_0x00da:
//===>>            //goto L 0x0138, here is debugger stuff
//!            if (r15 >= r12) goto L_0x0138
//!            r22 = r8[r15]     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//!            r23 = r22
//            //r13=StrinBuilder()
//            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            r13.<init>()     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//            //r14=0x7f0b002a
//            r14 = 2131427370(0x7f0b002a, float:1.8476354E38)
//            //r14=
//d            java.lang.String r14 = r1.getString(r14)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            java.lang.String r14 = dec(r14)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            r13.append(r14)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            r13.append(r3)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            r14 = 2131427369(0x7f0b0029, float:1.8476352E38)
//d            java.lang.String r24 = r1.getString(r14)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            java.lang.String r14 = dec(r24)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            r13.append(r14)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            java.lang.String r14 = "/"
//d            r13.append(r14)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            r14 = r23
//d            r13.append(r14)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            java.lang.String r2 = "/maps"
//d            r13.append(r2)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            java.lang.String r2 = r13.toString()     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            java.lang.String r13 = ec(r2)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            r23 = r2
//d            r2 = 2131427371(0x7f0b002b, float:1.8476356E38)
//d            java.lang.String r2 = r1.getString(r2)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            java.lang.String r2 = dec(r2)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            boolean r2 = r13.contains(r2)     // Catch:{ IllegalFormatCodePointException -> 0x0275, IllformedLocaleException -> 0x0271, NullPointerException -> 0x026d, BatchUpdateException -> 0x0267, CertificateEncodingException -> 0x0261, RejectedExecutionException -> 0x025b, GeneralSecurityException -> 0x0256, Exception -> 0x0251 }
//d            if (r2 == 0) goto L_0x0130
//d            r7 = 1
//d            goto L_0x0138
//        L_0x0130:
//d            int r15 = r15 + 1
//d            r2 = r29
//d            r14 = 2131427369(0x7f0b0029, float:1.8476352E38)
//d            goto L_0x00da
//        7==================================================
//        L_0x0138:
//            /r2=7?
//            int r2 = r9 + 1
//            //r5[7]=0
//            r5[r9] = r7     // Catch:{ IllegalFormatCodePointException -> 0x024d }
//            int r3 = r2 + -1
//            //r3=0
//            boolean r3 = r5[r3]     // Catch:{ IllegalFormatCodePointException -> 0x024d }
//            //goto exception
//            if (r3 != 0) goto L_0x023d
//            r6.step()     // Catch:{ IllegalFormatCodePointException -> 0x024d }
//            //r3=1
//            int r3 = r2 + 1
//            //r9=14
//            r9 = 14
//            //r12=r11.substring(14)  //r11 is flag without MOBISEC{
//            java.lang.String r12 = r11.substring(r9)     // Catch:{ IllegalFormatCodePointException -> 0x0238, IllformedLocaleException -> 0x0233, NullPointerException -> 0x022e, BatchUpdateException -> 0x0228, CertificateEncodingException -> 0x0222, RejectedExecutionException -> 0x021c, GeneralSecurityException -> 0x0217, Exception -> 0x0212 }
//            java.lang.String r9 = "_evil"
//            boolean r9 = r12.endsWith(r9)     // Catch:{ IllegalFormatCodePointException -> 0x0238, IllformedLocaleException -> 0x0233, NullPointerException -> 0x022e, BatchUpdateException -> 0x0228, CertificateEncodingException -> 0x0222, RejectedExecutionException -> 0x021c, GeneralSecurityException -> 0x0217, Exception -> 0x0212 }
//            r5[r2] = r9     // Catch:{ IllegalFormatCodePointException -> 0x0238, IllformedLocaleException -> 0x0233, NullPointerException -> 0x022e, BatchUpdateException -> 0x0228, CertificateEncodingException -> 0x0222, RejectedExecutionException -> 0x021c, GeneralSecurityException -> 0x0217, Exception -> 0x0212 }
//            int r2 = r3 + 1
//            //r9=9
//            r9 = 9
//            //r12=113
//            r12 = 13
//
//            java.lang.String r9 = r11.substring(r9, r12)     // Catch:{ IllegalFormatCodePointException -> 0x024d }
//            java.lang.String r12 = "bam"
//            boolean r9 = r9.endsWith(r12)     // Catch:{ IllegalFormatCodePointException -> 0x024d }
//            r5[r3] = r9     // Catch:{ IllegalFormatCodePointException -> 0x024d }
//            r6.step()     // Catch:{ IllegalFormatCodePointException -> 0x024d }
//            boolean r3 = com.mobisec.upos.MainActivity.g4     // Catch:{ IllegalFormatCodePointException -> 0x024d }
//            if (r3 == 0) goto L_0x0170
//            r3 = 0
//            return r3
//        L_0x0170:
//            r6.step()     // Catch:{ IllegalFormatCodePointException -> 0x024d }
//            android.content.pm.PackageManager r3 = r28.getPackageManager()     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            r8 = 128(0x80, float:1.794E-43)
//            java.util.List r3 = r3.getInstalledApplications(r8)     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            r7 = 0
//            java.util.Iterator r8 = r3.iterator()     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//        L_0x0183:
//            boolean r9 = r8.hasNext()     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            if (r9 == 0) goto L_0x01a5
//            java.lang.Object r9 = r8.next()     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            android.content.pm.ApplicationInfo r9 = (android.content.pm.ApplicationInfo) r9     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            java.lang.String r12 = r9.packageName     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            r13 = 2131427372(0x7f0b002c, float:1.8476358E38)
//            java.lang.String r13 = r1.getString(r13)     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            java.lang.String r13 = dec(r13)     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            boolean r12 = r12.equals(r13)     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            if (r12 == 0) goto L_0x01a4
//            r7 = 1
//            goto L_0x01a5
//        L_0x01a4:
//            goto L_0x0183
//        8==================================================
//        L_0x01a5:
//            int r8 = r2 + 1
//            r5[r2] = r7     // Catch:{ IllformedLocaleException -> 0x020d, NullPointerException -> 0x0208, BatchUpdateException -> 0x0202, CertificateEncodingException -> 0x01fc, RejectedExecutionException -> 0x01f6, GeneralSecurityException -> 0x01f1, Exception -> 0x01ec }
//            r6.step()     // Catch:{ IllformedLocaleException -> 0x020d, NullPointerException -> 0x0208, BatchUpdateException -> 0x0202, CertificateEncodingException -> 0x01fc, RejectedExecutionException -> 0x01f6, GeneralSecurityException -> 0x01f1, Exception -> 0x01ec }
//            int r2 = r8 + 1
//            r9 = 4
//            r12 = 10
//            java.lang.String r9 = r11.substring(r9, r12)     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            java.lang.String r9 = r9.toLowerCase()     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            java.lang.String r12 = "incred"
//            boolean r9 = r9.equals(r12)     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            r5[r8] = r9     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            boolean r8 = com.mobisec.upos.MainActivity.g1     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            if (r8 == 0) goto L_0x01c7
//            r4 = 0
//            return r4
//        9==================================================
//        L_0x01c7:
//            r6.step()     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            int r8 = r6.step()     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            if (r8 > 0) goto L_0x01e6
//            boolean r8 = com.mobisec.upos.MainActivity.g1     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            if (r8 == 0) goto L_0x01e6
//            r6.step()     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            r6.step()     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            r6.step()     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            r6.step()     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            r6.step()     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            goto L_0x031c
//        L_0x01e6:
//            java.util.IllformedLocaleException r8 = new java.util.IllformedLocaleException     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            r8.<init>()     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//            throw r8     // Catch:{ IllformedLocaleException -> 0x0248, NullPointerException -> 0x0243 }
//        L_0x01ec:
//            r0 = move-exception
//            r1 = r0
//            r2 = r8
//            goto L_0x053b
//        L_0x01f1:
//            r0 = move-exception
//            r1 = r0
//            r2 = r8
//            goto L_0x0540
//        L_0x01f6:
//            r0 = move-exception
//            r1 = r0
//            r2 = r8
//            r3 = 1
//            goto L_0x0548
//        L_0x01fc:
//            r0 = move-exception
//            r1 = r0
//            r2 = r8
//            r3 = 1
//            goto L_0x054f
//        L_0x0202:
//            r0 = move-exception
//            r1 = r0
//            r2 = r8
//            r3 = 1
//            goto L_0x0556
//        L_0x0208:
//            r0 = move-exception
//            r2 = r0
//            r9 = r8
//            goto L_0x02b0
//        L_0x020d:
//            r0 = move-exception
//            r2 = r0
//            r9 = r8
//            goto L_0x02b5
//        L_0x0212:
//            r0 = move-exception
//            r1 = r0
//            r2 = r3
//            goto L_0x053b
//        L_0x0217:
//            r0 = move-exception
//            r1 = r0
//            r2 = r3
//            goto L_0x0540
//        L_0x021c:
//            r0 = move-exception
//            r1 = r0
//            r2 = r3
//            r3 = 1
//            goto L_0x0548
//        L_0x0222:
//            r0 = move-exception
//            r1 = r0
//            r2 = r3
//            r3 = 1
//            goto L_0x054f
//        L_0x0228:
//            r0 = move-exception
//            r1 = r0
//            r2 = r3
//            r3 = 1
//            goto L_0x0556
//        L_0x022e:
//            r0 = move-exception
//            r2 = r0
//            r9 = r3
//            goto L_0x02b0
//        L_0x0233:
//            r0 = move-exception
//            r2 = r0
//            r9 = r3
//            goto L_0x02b5
//        L_0x0238:
//            r0 = move-exception
//            r2 = r0
//            r9 = r3
//            goto L_0x027f
//        L_0x023d:
//            java.sql.BatchUpdateException r3 = new java.sql.BatchUpdateException     // Catch:{ IllegalFormatCodePointException -> 0x024d }
//            r3.<init>()     // Catch:{ IllegalFormatCodePointException -> 0x024d }
//            throw r3     // Catch:{ IllegalFormatCodePointException -> 0x024d }
//        L_0x0243:
//            r0 = move-exception
//            r9 = r2
//            r2 = r0
//            goto L_0x02b0
//        L_0x0248:
//            r0 = move-exception
//            r9 = r2
//            r2 = r0
//            goto L_0x02b5
//        L_0x024d:
//            r0 = move-exception
//            r9 = r2
//            r2 = r0
//            goto L_0x027f
//        L_0x0251:
//            r0 = move-exception
//            r1 = r0
//            r2 = r9
//            goto L_0x053b
//        L_0x0256:
//            r0 = move-exception
//            r1 = r0
//            r2 = r9
//            goto L_0x0540
//        L_0x025b:
//            r0 = move-exception
//            r1 = r0
//            r2 = r9
//            r3 = 1
//            goto L_0x0548
//        L_0x0261:
//            r0 = move-exception
//            r1 = r0
//            r2 = r9
//            r3 = 1
//            goto L_0x054f
//        L_0x0267:
//            r0 = move-exception
//            r1 = r0
//            r2 = r9
//            r3 = 1
//            goto L_0x0556
//        L_0x026d:
//            r0 = move-exception
//            r2 = r0
//            goto L_0x02b0
//        L_0x0271:
//            r0 = move-exception
//            r2 = r0
//            goto L_0x02b5
//        L_0x0275:
//            r0 = move-exception
//            r2 = r0
//            goto L_0x027f
//        L_0x0278:
//            r0 = move-exception
//            r2 = r0
//            r9 = r7
//            goto L_0x027f
//        L_0x027c:
//            r0 = move-exception
//            r2 = r0
//            r9 = r12
//        L_0x027f:
//            r3 = 0
//            return r3
//        L_0x0281:
//            r0 = move-exception
//            r2 = r0
//            r9 = r7
//            goto L_0x02b0
//        L_0x0285:
//            r0 = move-exception
//            r2 = r0
//            r9 = r7
//            goto L_0x02b5
//        L_0x0289:
//            r0 = move-exception
//            r1 = r0
//            r2 = r15
//            goto L_0x053b
//        L_0x028e:
//            r0 = move-exception
//            r1 = r0
//            r2 = r15
//            goto L_0x0540
//        L_0x0293:
//            r0 = move-exception
//            r1 = r0
//            r2 = r15
//            r3 = 1
//            goto L_0x0548
//        L_0x0299:
//            r0 = move-exception
//            r1 = r0
//            r2 = r15
//            r3 = 1
//            goto L_0x054f
//        L_0x029f:
//            r0 = move-exception
//            r1 = r0
//            r2 = r15
//            r3 = 1
//            goto L_0x0556
//        L_0x02a5:
//            r0 = move-exception
//            r2 = r0
//            r9 = r15
//            goto L_0x02b0
//        L_0x02a9:
//            r0 = move-exception
//            r2 = r0
//            r9 = r15
//            goto L_0x02b5
//        L_0x02ad:
//            r0 = move-exception
//            r2 = r0
//            r9 = r12
//        L_0x02b0:
//            r3 = 0
//            return r3
//        L_0x02b2:
//            r0 = move-exception
//            r2 = r0
//            r9 = r12
//        10==================================================
//        L_0x02b5:
//            int r7 = r9 + 1
//            r3 = 22
//            java.lang.String r8 = r11.substring(r3)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            java.lang.String r3 = r8.toUpperCase()     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            boolean r3 = r3.startsWith(r4)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r5[r9] = r3     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r6.step()     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            int r3 = r7 + -3
//            boolean r3 = r5[r3]     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            if (r3 == 0) goto L_0x04f0
//            boolean r3 = com.mobisec.upos.MainActivity.g3     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            if (r3 == 0) goto L_0x02d9
//            r6.step()     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r3 = 0
//            return r3
//        11==================================================
//        L_0x02d9:
//            r6.step()     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r3 = 2131427374(0x7f0b002e, float:1.8476362E38)
//            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x030d, BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d }
//            java.lang.String r3 = dec(r3)     // Catch:{ Exception -> 0x030d, BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d }
//            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x030d, BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d }
//            r8 = 2131427375(0x7f0b002f, float:1.8476364E38)
//            java.lang.String r8 = r1.getString(r8)     // Catch:{ Exception -> 0x030d, BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d }
//            java.lang.String r8 = dec(r8)     // Catch:{ Exception -> 0x030d, BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d }
//            r9 = 0
//            java.lang.Class[] r12 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x030d, BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d }
//            java.lang.reflect.Method r8 = r3.getMethod(r8, r12)     // Catch:{ Exception -> 0x030d, BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d }
//            r12 = 0
//            java.lang.Object[] r13 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x030d, BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d }
//            java.lang.Object r9 = r8.invoke(r12, r13)     // Catch:{ Exception -> 0x030d, BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d }
//            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ Exception -> 0x030d, BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d }
//            boolean r9 = r9.booleanValue()     // Catch:{ Exception -> 0x030d, BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d }
//            r5[r7] = r9     // Catch:{ Exception -> 0x030d, BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d }
//            goto L_0x0312
//        L_0x030d:
//            r0 = move-exception
//            r3 = r0
//            r8 = 0
//            r5[r7] = r8     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//        L_0x0312:
//            int r7 = r7 + 1
//            int r3 = r7 + -1
//            boolean r3 = r5[r3]     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            if (r3 != 0) goto L_0x04ea
//            r10 = 0
//            r2 = r7
//        L_0x031c:
//            if (r10 == 0) goto L_0x0320
//            r3 = 0
//            return r3
//        L_0x0320:
//            int r7 = r2 + 1
//            java.lang.String r3 = r11.toLowerCase()     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r8 = 11
//            r9 = 14
//            java.lang.String r3 = r3.substring(r8, r9)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r8 = 1
//            char r3 = r3.charAt(r8)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r8 = 52
//            if (r3 != r8) goto L_0x0339
//            r3 = 1
//            goto L_0x033a
//        L_0x0339:
//            r3 = 0
//        12==================================================
//        L_0x033a:
//            r5[r2] = r3     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            int r2 = r7 + 1
//            r3 = 22
//            java.lang.String r3 = r11.substring(r3)     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            java.lang.String r3 = r3.toUpperCase()     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            boolean r3 = r3.startsWith(r4)     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            r5[r7] = r3     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            android.content.pm.PackageManager r3 = r28.getPackageManager()     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            java.lang.String r4 = r28.getPackageName()     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            r7 = 64
//            r8 = 0
//            android.content.pm.PackageInfo r9 = r3.getPackageInfo(r4, r7)     // Catch:{ NameNotFoundException -> 0x035f }
//            r8 = r9
//            goto L_0x0364
//        L_0x035f:
//            r0 = move-exception
//            r9 = r0
//            r9.printStackTrace()     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//        13==================================================
//        L_0x0364:
//            android.content.pm.Signature[] r9 = r8.signatures     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            r12 = 0
//            r13 = r9[r12]     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            byte[] r12 = r13.toByteArray()     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            java.io.ByteArrayInputStream r13 = new java.io.ByteArrayInputStream     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            r13.<init>(r12)     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            r14 = 0
//            java.lang.String r15 = "X509"
//            java.security.cert.CertificateFactory r15 = java.security.cert.CertificateFactory.getInstance(r15)     // Catch:{ CertificateException -> 0x037b }
//            r14 = r15
//            goto L_0x0380
//        L_0x037b:
//            r0 = move-exception
//            r15 = r0
//            r15.printStackTrace()     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//        L_0x0380:
//            r15 = 0
//            java.security.cert.Certificate r18 = r14.generateCertificate(r13)     // Catch:{ CertificateException -> 0x038a }
//            java.security.cert.X509Certificate r18 = (java.security.cert.X509Certificate) r18     // Catch:{ CertificateException -> 0x038a }
//            r15 = r18
//            goto L_0x0390
//        L_0x038a:
//            r0 = move-exception
//            r18 = r0
//            r18.printStackTrace()     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//        14==================================================
//        L_0x0390:
//            r18 = 0
//            java.lang.String r19 = "SHA1"
//            java.security.MessageDigest r19 = java.security.MessageDigest.getInstance(r19)     // Catch:{ NoSuchAlgorithmException -> 0x03cb, CertificateEncodingException -> 0x03c1, BatchUpdateException -> 0x04e5, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            r20 = r19
//            r19 = r3
//            byte[] r3 = r15.getEncoded()     // Catch:{ NoSuchAlgorithmException -> 0x03bc, CertificateEncodingException -> 0x03b7, BatchUpdateException -> 0x04e5, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            r22 = r4
//            r4 = r20
//            byte[] r3 = r4.digest(r3)     // Catch:{ NoSuchAlgorithmException -> 0x03b4, CertificateEncodingException -> 0x03b1, BatchUpdateException -> 0x04e5, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            java.lang.String r20 = th(r3)     // Catch:{ NoSuchAlgorithmException -> 0x03b4, CertificateEncodingException -> 0x03b1, BatchUpdateException -> 0x04e5, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            r18 = r20
//            r3 = r18
//            goto L_0x03d7
//        L_0x03b1:
//            r0 = move-exception
//            r3 = r0
//            goto L_0x03c7
//        L_0x03b4:
//            r0 = move-exception
//            r3 = r0
//            goto L_0x03d1
//        L_0x03b7:
//            r0 = move-exception
//            r22 = r4
//            r3 = r0
//            goto L_0x03c7
//        L_0x03bc:
//            r0 = move-exception
//            r22 = r4
//            r3 = r0
//            goto L_0x03d1
//        L_0x03c1:
//            r0 = move-exception
//            r19 = r3
//            r22 = r4
//            r3 = r0
//        L_0x03c7:
//            r3.printStackTrace()     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//            goto L_0x03d5
//        L_0x03cb:
//            r0 = move-exception
//            r19 = r3
//            r22 = r4
//            r3 = r0
//        L_0x03d1:
//            r3.printStackTrace()     // Catch:{ BatchUpdateException -> 0x04e5, CertificateEncodingException -> 0x04e0, RejectedExecutionException -> 0x04db, GeneralSecurityException -> 0x04d7, Exception -> 0x04d3 }
//        L_0x03d5:
//            r3 = r18
//        15==================================================
//        L_0x03d7:
//            int r4 = r2 + 1
//            r18 = r7
//            r7 = 2131427373(0x7f0b002d, float:1.847636E38)
//            java.lang.String r7 = r1.getString(r7)     // Catch:{ BatchUpdateException -> 0x04cd, CertificateEncodingException -> 0x04c7, RejectedExecutionException -> 0x04c1, GeneralSecurityException -> 0x04bc, Exception -> 0x04b7 }
//            boolean r7 = r3.equals(r7)     // Catch:{ BatchUpdateException -> 0x04cd, CertificateEncodingException -> 0x04c7, RejectedExecutionException -> 0x04c1, GeneralSecurityException -> 0x04bc, Exception -> 0x04b7 }
//            r5[r2] = r7     // Catch:{ BatchUpdateException -> 0x04cd, CertificateEncodingException -> 0x04c7, RejectedExecutionException -> 0x04c1, GeneralSecurityException -> 0x04bc, Exception -> 0x04b7 }
//            int r2 = r4 + -1
//            boolean r2 = r5[r2]     // Catch:{ BatchUpdateException -> 0x04cd, CertificateEncodingException -> 0x04c7, RejectedExecutionException -> 0x04c1, GeneralSecurityException -> 0x04bc, Exception -> 0x04b7 }
//            if (r2 == 0) goto L_0x04b1
//            r2 = 0
//            boolean r7 = r5[r2]     // Catch:{ BatchUpdateException -> 0x04cd, CertificateEncodingException -> 0x04c7, RejectedExecutionException -> 0x04c1, GeneralSecurityException -> 0x04bc, Exception -> 0x04b7 }
//            if (r7 == 0) goto L_0x04af
//            r2 = 1
//            boolean r7 = r5[r2]     // Catch:{ BatchUpdateException -> 0x04cd, CertificateEncodingException -> 0x04c7, RejectedExecutionException -> 0x04c1, GeneralSecurityException -> 0x04bc, Exception -> 0x04b7 }
//            if (r7 != 0) goto L_0x03fa
//            goto L_0x04af
//        L_0x03fa:
//            r2 = 100
//            r4 = 0
//            r7 = r2
//        16==================================================
//        L_0x03fe:
//            r2 = 30
//            if (r4 >= r2) goto L_0x0492
//            r2 = 1
//            r5[r7] = r2     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r2.<init>()     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            int r1 = r4 * 2
//            char r1 = r11.charAt(r1)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            java.lang.String r1 = java.lang.Character.toString(r1)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r2.append(r1)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            int r1 = r4 * 2
//            r17 = 1
//            int r1 = r1 + 1
//            char r1 = r11.charAt(r1)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            java.lang.String r1 = java.lang.Character.toString(r1)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r2.append(r1)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            java.lang.String r1 = r2.toString()     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            boolean r2 = ip(r4)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            if (r2 == 0) goto L_0x043b
//            r2 = 0
//        L_0x0433:
//            if (r2 >= r4) goto L_0x043b
//            r6.step()     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            int r2 = r2 + 1
//            goto L_0x0433
//        17==================================================
//        L_0x043b:
//            int r2 = r6.g2()     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r2 = r2 & 255(0xff, float:3.57E-43)
//            int r20 = r6.g2()     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r23 = 65280(0xff00, float:9.1477E-41)
//            r20 = r20 & r23
//            r16 = 8
//            int r20 = r20 >> 8
//            java.lang.String r23 = r(r1)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            long r23 = sq(r23)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            long[][] r25 = m     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r25 = r25[r2]     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r26 = r25[r20]     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            int r25 = (r23 > r26 ? 1 : (r23 == r26 ? 0 : -1))
//            //r25 likely has to bo 0
//            if (r25 == 0) goto L_0x048a
//            int r23 = r7 + 1
//            r21 = 0
//            r5[r7] = r21     // Catch:{ BatchUpdateException -> 0x0483, CertificateEncodingException -> 0x047c, RejectedExecutionException -> 0x0475, GeneralSecurityException -> 0x046f, Exception -> 0x0469 }
//            r7 = r23
//            goto L_0x048c
//        L_0x0469:
//            r0 = move-exception
//            r1 = r0
//            r2 = r23
//            goto L_0x053b
//        L_0x046f:
//            r0 = move-exception
//            r1 = r0
//            r2 = r23
//            goto L_0x0540
//        L_0x0475:
//            r0 = move-exception
//            r1 = r0
//            r2 = r23
//            r3 = 1
//            goto L_0x0548
//        L_0x047c:
//            r0 = move-exception
//            r1 = r0
//            r2 = r23
//            r3 = 1
//            goto L_0x054f
//        L_0x0483:
//            r0 = move-exception
//            r1 = r0
//            r2 = r23
//            r3 = 1
//            goto L_0x0556
//        L_0x048a:
//            int r7 = r7 + 1
//        L_0x048c:
//            int r4 = r4 + 1
//            r1 = r28
//            goto L_0x03fe
//        L_0x0492:
//            int r1 = r7 + -30
//        L_0x0494:
//            if (r1 >= r7) goto L_0x049f
//            boolean r2 = r5[r1]     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            if (r2 != 0) goto L_0x049c
//            r2 = 0
//            return r2
//        L_0x049c:
//            int r1 = r1 + 1
//            goto L_0x0494
//        L_0x049f:
//            java.lang.String r1 = h(r29)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            java.lang.String r2 = "4193d9b72a5c4805e9a5cc739f8a8fc23b2890e13b83bb887d96f86c30654a12"
//            boolean r1 = r1.equals(r2)     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            if (r1 != 0) goto L_0x04ad
//            r1 = 0
//            return r1
//        L_0x04ad:
//            r1 = 1
//            return r1
//        L_0x04af:
//            r1 = 0
//            return r1
//        L_0x04b1:
//            java.security.GeneralSecurityException r1 = new java.security.GeneralSecurityException     // Catch:{ BatchUpdateException -> 0x04cd, CertificateEncodingException -> 0x04c7, RejectedExecutionException -> 0x04c1, GeneralSecurityException -> 0x04bc, Exception -> 0x04b7 }
//            r1.<init>()     // Catch:{ BatchUpdateException -> 0x04cd, CertificateEncodingException -> 0x04c7, RejectedExecutionException -> 0x04c1, GeneralSecurityException -> 0x04bc, Exception -> 0x04b7 }
//            throw r1     // Catch:{ BatchUpdateException -> 0x04cd, CertificateEncodingException -> 0x04c7, RejectedExecutionException -> 0x04c1, GeneralSecurityException -> 0x04bc, Exception -> 0x04b7 }
//        L_0x04b7:
//            r0 = move-exception
//            r1 = r0
//            r2 = r4
//            goto L_0x053b
//        L_0x04bc:
//            r0 = move-exception
//            r1 = r0
//            r2 = r4
//            goto L_0x0540
//        L_0x04c1:
//            r0 = move-exception
//            r1 = r0
//            r2 = r4
//            r3 = 1
//            goto L_0x0548
//        L_0x04c7:
//            r0 = move-exception
//            r1 = r0
//            r2 = r4
//            r3 = 1
//            goto L_0x054f
//        L_0x04cd:
//            r0 = move-exception
//            r1 = r0
//            r2 = r4
//            r3 = 1
//            goto L_0x0556
//        L_0x04d3:
//            r0 = move-exception
//            r1 = r0
//            goto L_0x053b
//        L_0x04d7:
//            r0 = move-exception
//            r1 = r0
//            goto L_0x0540
//        L_0x04db:
//            r0 = move-exception
//            r1 = r0
//            r3 = 1
//            goto L_0x0548
//        L_0x04e0:
//            r0 = move-exception
//            r1 = r0
//            r3 = 1
//            goto L_0x054f
//        L_0x04e5:
//            r0 = move-exception
//            r1 = r0
//            r3 = 1
//            goto L_0x0556
//        L_0x04ea:
//            java.security.cert.CertificateEncodingException r1 = new java.security.cert.CertificateEncodingException     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r1.<init>()     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            throw r1     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//        L_0x04f0:
//            java.util.concurrent.RejectedExecutionException r1 = new java.util.concurrent.RejectedExecutionException     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            r1.<init>()     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//            throw r1     // Catch:{ BatchUpdateException -> 0x0533, CertificateEncodingException -> 0x052e, RejectedExecutionException -> 0x0529, GeneralSecurityException -> 0x053d, Exception -> 0x0538 }
//        L_0x04f6:
//            r0 = move-exception
//            r1 = r0
//            r2 = r12
//            goto L_0x053b
//        L_0x04fb:
//            r0 = move-exception
//            r1 = r0
//            r2 = r12
//            goto L_0x0540
//        L_0x0500:
//            r0 = move-exception
//            r1 = r0
//            r2 = r12
//            r3 = 1
//            goto L_0x0548
//        L_0x0506:
//            r0 = move-exception
//            r1 = r0
//            r2 = r12
//            r3 = 1
//            goto L_0x054f
//        L_0x050c:
//            r0 = move-exception
//            r1 = r0
//            r2 = r12
//            r3 = 1
//            goto L_0x0556
//        L_0x0512:
//            r0 = move-exception
//            r1 = r0
//            r2 = r10
//            goto L_0x053b
//        L_0x0516:
//            r0 = move-exception
//            r1 = r0
//            r2 = r10
//            goto L_0x0540
//        L_0x051a:
//            r0 = move-exception
//            r1 = r0
//            r2 = r10
//            r3 = 1
//            goto L_0x0548
//        L_0x051f:
//            r0 = move-exception
//            r1 = r0
//            r2 = r10
//            r3 = 1
//            goto L_0x054f
//        L_0x0524:
//            r0 = move-exception
//            r1 = r0
//            r2 = r10
//            r3 = 1
//            goto L_0x0556
//        L_0x0529:
//            r0 = move-exception
//            r1 = r0
//            r2 = r7
//            r3 = 1
//            goto L_0x0548
//        L_0x052e:
//            r0 = move-exception
//            r1 = r0
//            r2 = r7
//            r3 = 1
//            goto L_0x054f
//        L_0x0533:
//            r0 = move-exception
//            r1 = r0
//            r2 = r7
//            r3 = 1
//            goto L_0x0556
//        L_0x0538:
//            r0 = move-exception
//            r1 = r0
//            r2 = r7
//        L_0x053b:
//            r3 = 0
//            return r3
//        L_0x053d:
//            r0 = move-exception
//            r1 = r0
//            r2 = r7
//        L_0x0540:
//            r3 = 1
//            com.mobisec.upos.MainActivity.g4 = r3
//            goto L_0x0558
//        L_0x0544:
//            r0 = move-exception
//            r3 = 1
//            r1 = r0
//            r2 = r7
//        L_0x0548:
//            com.mobisec.upos.MainActivity.g3 = r3
//            goto L_0x0558
//        L_0x054b:
//            r0 = move-exception
//            r3 = 1
//            r1 = r0
//            r2 = r7
//        L_0x054f:
//            com.mobisec.upos.MainActivity.g1 = r3
//            goto L_0x0558
//        L_0x0552:
//            r0 = move-exception
//            r3 = 1
//            r1 = r0
//            r2 = r7
//        L_0x0556:
//            com.mobisec.upos.MainActivity.g2 = r3
//        L_0x0558:
//            r1 = 0
//            return r1
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.mobisec.upos.FC.checkFlag(android.content.Context, java.lang.String):boolean");
//    }


    private static void lm(long[][] r14) throws java.lang.Exception {
        /*
        //OPEN lotto.dat from assets
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x005a }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x005a }
            android.content.Context r3 = ctx     // Catch:{ all -> 0x005a }
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch:{ all -> 0x005a }
            java.lang.String r4 = "lotto.dat"
            java.io.InputStream r3 = r3.open(r4)     // Catch:{ all -> 0x005a }
            r2.<init>(r3)     // Catch:{ all -> 0x005a }
            r1.<init>(r2)     // Catch:{ all -> 0x005a }
            r0 = r1
            r1 = 0
            r2 = r1
        //read from lotto.dat
        L_0x001a:
            java.lang.String r3 = r0.readLine()     // Catch:{ all -> 0x005a }
            r4 = r3
            java.lang.String r5 = "error"
            r6 = 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x004d
            java.lang.String r3 = " "
            java.lang.String[] r3 = r4.split(r3)     // Catch:{ all -> 0x005a }
            r7 = 0
            int r8 = r3.length     // Catch:{ all -> 0x005a }
            r9 = r7
            r7 = 0
        L_0x002f:
            if (r7 >= r8) goto L_0x0041
            r10 = r3[r7]     // Catch:{ all -> 0x005a }
            long r11 = java.lang.Long.parseLong(r10)     // Catch:{ all -> 0x005a }
            r13 = r14[r2]     // Catch:{ all -> 0x005a }
            r13[r9] = r11     // Catch:{ all -> 0x005a }
            int r9 = r9 + 1
            int r7 = r7 + 1
            goto L_0x002f
        L_0x0041:
            if (r9 != r6) goto L_0x0047
            int r2 = r2 + 1
            goto L_0x001a
        L_0x004d:
            if (r2 != r6) goto L_0x0054
            r0.close()
            return
        L_0x005a:
            r1 = move-exception
            if (r0 == 0) goto L_0x0060
            r0.close()
        L_0x0060:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobisec.upos.FC.lm(long[][]):void");
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
