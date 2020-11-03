/*
 * Create by Gunt on 2020. 11. 03.
 *
 * Copyright (c) 2020  Gunt All rights reserved.
 *
 * https://github.com/sysout-achieve/SimpleLoadingBar
 *
 */

package com.gunt.simpleloadingbar;


import android.graphics.Color;
import android.view.WindowManager;

public class LoadingBarOption {

    public enum BackBrightness{
        DIM(WindowManager.LayoutParams.FLAG_DIM_BEHIND),
        KEEP_SCREEN_ON(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        int backScreenOpt;

        BackBrightness(int backScreenOpt) {
            this.backScreenOpt = backScreenOpt;
        }

        public int getBackScreenOpt() {
            return backScreenOpt;
        }
    }

    private BackBrightness backBrightness;
    private int color;
    private boolean isCancelable;

    public LoadingBarOption() {
        this.backBrightness = BackBrightness.DIM;
        this.color = Color.parseColor("#067a77");
        this.isCancelable = false;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public BackBrightness getBackBrightness() {
        return backBrightness;
    }

    public void setBackBrightness(BackBrightness backBrightness) {
        this.backBrightness = backBrightness;
    }

    public boolean isCancelable() {
        return isCancelable;
    }

    public void setCancelable(boolean cancelable) {
        isCancelable = cancelable;
    }
}
