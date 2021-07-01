package com.iamkgehlot.suqstile;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;

public class dctile extends TileService {



    @Override
    public void onClick() {
        super.onClick();
        dcON();
    }

    private void dcON() {
        Tile tile = getQsTile();
        if (tile.getState() == 1) {
            tile.setState(2);
            qssetting.writeLine("/sys/kernel/oppo_display/dimlayer_bl_en","1");
            Toast.makeText(this, R.string.dc_on, Toast.LENGTH_SHORT).show();
            tile.updateTile();

        } else if (tile.getState() == 2) {
            tile.setState(1);
            qssetting.writeLine("/sys/kernel/oppo_display/dimlayer_bl_en","0");
            Toast.makeText(this, R.string.dc_off, Toast.LENGTH_SHORT).show();
            tile.updateTile();



        }
    }


}
