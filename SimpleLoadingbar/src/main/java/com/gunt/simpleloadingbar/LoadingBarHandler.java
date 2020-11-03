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
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;

public class LoadingBarHandler extends AppCompatActivity {

    public AppCompatDialog progressDialog;
    private LoadingBarOption loadingBarOption;

    public LoadingBarHandler() {
        loadingBarOption = new LoadingBarOption();
    }

    public void progressON(Activity activity, String message) {
        if (activity == null || activity.isFinishing()) {
            return;
        }


        progressDialog = new AppCompatDialog(activity);
        progressDialog.setCancelable(loadingBarOption.isCancelable());
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        progressDialog.getWindow().setFlags(loadingBarOption.getBackBrightness().getBackScreenOpt(), MODE_PRIVATE);
        if (loadingBarOption.getBackBrightness() == LoadingBarOption.BackBrightness.KEEP_SCREEN_ON) {
            progressDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            progressDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, MODE_PRIVATE);
        } else {
            progressDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            progressDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND, MODE_PRIVATE);
        }
        progressDialog.setContentView(R.layout.progress_loading);
        progressDialog.show();

        final ProgressBar progressBar = progressDialog.findViewById(R.id.progressBar);
        progressBar.setIndeterminate(true);
        progressBar.getIndeterminateDrawable().setColorFilter(loadingBarOption.getColor(), PorterDuff.Mode.MULTIPLY);
        TextView tv = progressDialog.findViewById(R.id.tv_progress_message);
        if (!TextUtils.isEmpty(message)) {
            tv.setText(message);
        }
    }


    public void progressOFF() {
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadingBarOptionColor(int color) {
        loadingBarOption.setColor(color);
    }

    public void backScreenBrightness(LoadingBarOption.BackBrightness backBrightness) {
        loadingBarOption.setBackBrightness(backBrightness);
    }

    public void setCancelable(boolean isCancelable) {
        loadingBarOption.setCancelable(isCancelable);
    }

}