package com.example.foodstorageapp;

/**
 * Class for converting a StorageItem to a QR code image
 * Takes a StorageItem, calls the makeString method and gives that string to a MultiFormatWriter
 * to turn it into a bitmap
 *
 *
 */

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MakeQrCode {

    Bitmap bitmap;

    public MakeQrCode(StorageItem itemToSerialize) {
        String serializedData = itemToSerialize.makeString();
        Log.i("MakeQR", serializedData);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(serializedData, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.createBitmap(bitMatrix);
            Log.i("MakeQR", "made bitmap");
            Log.i("MakeQR", Integer.toString(bitmap.getByteCount()));
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public Bitmap getBitmap() {
        Log.i("in getBitmap", "in here");
        Log.i("in getBitmap", Integer.toString(bitmap.getByteCount()));
        return bitmap;
    }
}
