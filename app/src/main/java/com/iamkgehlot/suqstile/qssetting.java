package com.iamkgehlot.suqstile;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings.Secure;

import java.io.FileOutputStream;
import java.io.IOException;

public class qssetting {

    private final Context context;

    public qssetting(Context context) {
        this.context = context;
    }

    public static boolean writeLine(String fileName, String value) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(value.getBytes());
            fos.flush();
            fos.close();
            return true;
        } catch (IOException e) {

            return false;
        }
    }

}
