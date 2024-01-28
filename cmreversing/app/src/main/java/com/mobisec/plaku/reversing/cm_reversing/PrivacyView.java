package com.mobisec.plaku.reversing.cm_reversing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//import androidx.core.view.ViewCompat;
// TODO: 12/17/2019 check the comment description inside onDraw

public class PrivacyView extends View {
    private Paint blackPaint;
    private Context ctx;
    private ArrayList<Paper> papers;

    public PrivacyView(Context context) {
        this(context, null);
    }

    public PrivacyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blackPaint = new Paint();
        this.papers = new ArrayList<>();
        this.ctx = context;
        this.blackPaint.setStyle(Style.FILL_AND_STROKE);
    }

//    It doesn't know the size in the beginning, so this is called when the size is received (this was before onDraw)
    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        getItems();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
        Iterator it = this.papers.iterator();
        while (it.hasNext()) {
            Paper paper = (Paper) it.next();
//            this is where the piece of the picture are displayed
//            paper.citations is the id of a drawable resource
//            would have to import the drawables, and their IDs somehow (seems like a lot of work, think of other methods-tools)
//
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), paper.citations);
            if (decodeResource != null) {
                canvas.drawBitmap(decodeResource, null, new Rect(paper.title, paper.authors, paper.conf, paper.year), this.blackPaint);
            }
        }
    }

//    This reads the bytes from the cm.dat file in assets. This data is used to fill the list of Paper objects.
//    includes some XORing
    private void getItems() {
        this.papers.clear();
        try {
            InputStream open = this.ctx.getAssets().open("cm.dat");
            int i = 4;
            float[] fArr = new float[4];
            byte[] bArr = new byte[4];
            byte[] bArr2 = new byte[4];
            int i2 = 20;
            byte[] bArr3 = {99, 105, 115, 112, 97, 109, 97, 110, 104, 97, 115, 101, 118, 101, 114, 121, 102, 108, 97, 103};
            byte[] bArr4 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            while (true) {
                int i3 = 0;
                int i4 = -1;
                while (true) {
                    if (i3 >= i) {
                        break;
                    }
                    i4 = open.read(bArr, 0, i);
                    if (i4 < 0) {
                        break;
                    }
                    i4 = open.read(bArr2, i3, 1);
                    if (i4 < 0) {
                        break;
                    }
                    int i5 = i3 * 5;
                    int i6 = i5 + 4;
                    shield(bArr, bArr, Arrays.copyOfRange(bArr3, i5, i6));
                    bArr2[i3] = (byte) (bArr2[i3] ^ bArr3[i6]);
                    for (int i7 = 0; i7 < i; i7++) {
                        bArr4[i5 + i7] = bArr[i7];
                    }
                    bArr4[i6] = bArr2[i3];
                    fArr[i3] = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getFloat();
                    i3++;
                }
                if (i4 >= 0) {
                    int i8 = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN).getInt();
                    for (int i9 = 0; i9 < i2; i9++) {
                        bArr3[i9] = bArr4[i9];
                    }
                    ArrayList<Paper> arrayList = this.papers;
                    Paper paper = new Paper((int) (fArr[0] * ((float) getWidth())), (int) (fArr[1] * ((float) getHeight())), (int) (((float) getWidth()) * fArr[2]), (int) (((float) getHeight()) * fArr[3]), i8);
                    arrayList.add(paper);
                    i = 4;
                    i2 = 20;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void shield(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i = 0; i < bArr2.length; i++) {
            bArr[i] = (byte) (bArr2[i] ^ bArr3[i]);
        }
    }
}
