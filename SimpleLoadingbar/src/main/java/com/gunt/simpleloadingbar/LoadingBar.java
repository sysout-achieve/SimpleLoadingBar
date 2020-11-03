/*
 * Create by Gunt on 2020. 11. 03.
 *
 * Copyright (c) 2020  Gunt All rights reserved.
 *
 * https://github.com/sysout-achieve/SimpleLoadingBar
 *
 */

package com.gunt.simpleloadingbar;

import android.app.Activity;

public class LoadingBar {

    private static LoadingBarHandler loadingBarHandler;

    private LoadingBar() {
        loadingBarHandler = new LoadingBarHandler();
    }

    private static class LazyInitLoadingBar {
        private static final LoadingBar instance = new LoadingBar();
    }

    public static LoadingBar init() {
        return LazyInitLoadingBar.instance;
    }

    public void on(Activity activity) {
        loadingBarHandler.progressON(activity, null);
    }

    public void on(Activity activity, String message) {
        loadingBarHandler.progressON(activity, message);
    }

    public void off() {
        loadingBarHandler.progressOFF();
    }

    public LoadingBar color(int color) {
        loadingBarHandler.loadingBarOptionColor(color);
        return this;
    }

    public LoadingBar backBrightness(LoadingBarOption.BackBrightness backBrightness) {
        loadingBarHandler.backScreenBrightness(backBrightness);
        return this;
    }

    public LoadingBar isCancelable(boolean isCancelable) {
        loadingBarHandler.setCancelable(isCancelable);
        return this;
    }
}
