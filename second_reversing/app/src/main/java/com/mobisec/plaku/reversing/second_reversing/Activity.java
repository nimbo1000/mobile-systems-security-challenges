package com.mobisec.plaku.reversing.second_reversing;

import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.mobisec.plaku.reversing.second_reversing.FC;
import com.mobisec.plaku.reversing.second_reversing.MainActivity;
import com.mobisec.plaku.reversing.second_reversing.R;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;

public class Activity {
    @SuppressLint("WrongConstant")
    public static void initActivity(MainActivity ctx) {
        boolean found;
        MainActivity mainActivity = ctx;
        boolean found2 = false;
        StringBuilder sb = new StringBuilder();
        sb.append(FC.dec(mainActivity.getString(R.string.s1)));
        String str = " ";
        sb.append(str);
        sb.append(FC.dec(mainActivity.getString(R.string.s2)));
        String[] lines = FC.ec(sb.toString()).split("\n");
        int length = lines.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String line = lines[i];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(FC.dec(mainActivity.getString(R.string.s3)));
            sb2.append(str);
            sb2.append(FC.dec(mainActivity.getString(R.string.s2)));
            sb2.append("/");
            sb2.append(line);
            sb2.append("/maps");
            if (FC.ec(sb2.toString()).contains(FC.dec(mainActivity.getString(R.string.s4)))) {
                found2 = true;
                break;
            }
            i++;
        }
        MainActivity.g2 = found2;
        Iterator it = ctx.getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA).iterator();
        while (true) {
            if (it.hasNext()) {
                if (((ApplicationInfo) it.next()).packageName.equals(FC.dec(mainActivity.getString(R.string.s5)))) {
                    found = true;
                    break;
                }
            } else {
                found = false;
                break;
            }
        }
        MainActivity.g3 = !found;
        try {
            MainActivity.g1 = ((Boolean) Class.forName(FC.dec(mainActivity.getString(R.string.s7))).getMethod(FC.dec(mainActivity.getString(R.string.s8)), new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            MainActivity.g1 = false;
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 64);
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
        }
        InputStream input = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
        CertificateFactory cf = null;
        try {
            cf = CertificateFactory.getInstance("X509");
        } catch (CertificateException e3) {
            e3.printStackTrace();
        }
        X509Certificate c = null;
        try {
            c = (X509Certificate) cf.generateCertificate(input);
        } catch (CertificateException e4) {
            e4.printStackTrace();
        }
        String hexString = null;
        try {
            hexString = FC.th(MessageDigest.getInstance("SHA1").digest(c.getEncoded()));
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (CertificateEncodingException e5) {
            e5.printStackTrace();
        }
        MainActivity.g4 = !hexString.equals(mainActivity.getString(R.string.s6));
    }
}
