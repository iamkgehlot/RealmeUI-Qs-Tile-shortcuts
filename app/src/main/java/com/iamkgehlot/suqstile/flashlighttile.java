package com.iamkgehlot.suqstile;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;

public class flashlighttile extends TileService {


    @Override
    public void onClick() {
        super.onClick();
        torchON();
    }
    public static void sudo(String... strings) {
        try {
            Process su = Runtime.getRuntime().exec("su");
            DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());

            for (String s : strings) {
                outputStream.writeBytes(s + "\n");
                outputStream.flush();
            }

            outputStream.writeBytes("exit\n");
            outputStream.flush();
            try {
                su.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void torchON() {
        Tile tile = getQsTile();
        if (tile.getState() == 1) {
            tile.setState(2);
            sudo("echo 1 > /sys/devices/platform/soc/1.qcom,camera-flash/fswitch");
            Toast.makeText(this, R.string.flash_on, Toast.LENGTH_SHORT).show();
            tile.updateTile();

        } else if (tile.getState() == 2) {
            tile.setState(1);
            sudo("echo 0 > /sys/devices/platform/soc/1.qcom,camera-flash/fswitch");
            Toast.makeText(this, R.string.flash_off, Toast.LENGTH_SHORT).show();
            tile.updateTile();

        }
    }


}
