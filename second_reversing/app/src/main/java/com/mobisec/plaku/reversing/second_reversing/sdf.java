package com.mobisec.plaku.reversing.second_reversing;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;

class sdf {

    public static boolean checkFlag(Context ctx, String flag) {
        if (!flag.startsWith("MOBISEC{") || !flag.endsWith("}")) {
            return false;
        }
        String core = flag.substring(8, 40);
        if (core.length() != 32) {
            return false;
        }
        String[] ps = core.split(foo()); // foo returns -
        // MOBISEC{"^[a-z]+$"--^[A-Z]+$--^[0-9]+$}
        if (ps.length != 5 || !bim(ps[0]) || !bum(ps[2]) || !bam(ps[4])
                || !core.replaceAll("[A-Z]", "X").replaceAll("[a-z]", "x").replaceAll("[0-9]", " ").matches("[A-Za-z0-9]+.       .[A-Za-z0-9]+.[Xx ]+.[A-Za-z0-9 ]+")) {
            //telling that there are 7 numbers in the ps[1]. ps[3] can have upper, lower or number
            return false;
        }
        char[] syms = new char[4];
        int[] idxs = {13, 21, 27, 32};  // ids of -
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < syms.length; i++) {
            syms[i] = flag.charAt(idxs[i]);
            chars.add(Character.valueOf(syms[i]));
        }
        int sum = 0;
        // MOBISEC{peppa-9876543-BAAAM-A1z9-3133337}
        for (char c : syms) {
            sum += c;
        }
        if (sum == 180 && chars.size() == 1 // dh calculates MD5 hash of the last parameter
                && me(ctx, dh(gs(ctx.getString(R.string.ct1), ctx.getString(R.string.k1)), ps[0]), ctx.getString(R.string.t1)) //peppa
                && me(ctx, dh(gs(ctx.getString(R.string.ct2), ctx.getString(R.string.k2)), ps[1]), ctx.getString(R.string.t2)) //9876543
                && me(ctx, dh(gs(ctx.getString(R.string.ct3), ctx.getString(R.string.k3)), ps[2]), ctx.getString(R.string.t3)) //BAAAM
                && me(ctx, dh(gs(ctx.getString(R.string.ct4), ctx.getString(R.string.k4)), ps[3]), ctx.getString(R.string.t4)) //A1z9
                && me(ctx, dh(gs(ctx.getString(R.string.ct5), ctx.getString(R.string.k5)), ps[4]), ctx.getString(R.string.t5)) //3133337
                && me(ctx, dh(gs(ctx.getString(R.string.ct6), ctx.getString(R.string.k6)), flag), ctx.getString(R.string.t6))) {
            return true;
        }
        return false;
    }

    private static boolean bim(String s) {
        return s.matches("^[a-z]+$");
    }

    private static boolean bum(String s) {
        return s.matches("^[A-Z]+$");
    }

    private static boolean bam(String s) {
        return s.matches("^[0-9]+$");
    }

    private static String dh(String hash, String s) {
        try {
            MessageDigest md = MessageDigest.getInstance(hash);
            md.update(s.getBytes());
            return toHexString(md.digest());
        } catch (Exception e) {
            return null;
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

    public static String foo() {
        String s = "Vm0wd2QyVkZNVWRYV0docFVtMVNWVmx0ZEhkVlZscDBUVlpPVmsxWGVIbFdiVFZyVm0xS1IyTkliRmRXTTFKTVZsVmFWMVpWTVVWaGVqQTk=";
        for (int i = 0; i < 10; i++) {
            s = new String(Base64.decode(s, 0));
        }
        return s;
    }

    private static String gs(String a, String b) {  //Returns MD5
        String s = BuildConfig.FLAVOR;
        for (int i = 0; i < a.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(Character.toString((char) (a.charAt(i) ^ b.charAt(i % b.length()))));
            s = sb.toString();
        }
        return s;
    }

    private static boolean me(Context ctx, String s1, String s2) {
        try {
            return ((Boolean) s1.getClass().getMethod(r(ctx.getString(R.string.m1)), new Class[]{Object.class})
                    .invoke(s1, new Object[]{s2})).booleanValue();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exception: ");
            sb.append(Log.getStackTraceString(e));
            Log.e("MOBISEC", sb.toString());
            return false;
        }
    }

    public static String r(String s) {  // reverse string
        return new StringBuffer(s).reverse().toString();
    }
}