package com.example.escaperoom;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import framework.MenuClass;
import framework.PopUpHelper;

import android.view.WindowManager;

public class PopUpWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // sets the view stored in bundle
        setContentView(getIntent().getExtras().getInt("viewValue"));

        // set window fullscreen and remove titlebar
        // forces landscape through manifest
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        PopUpHelper popUpHelper = new PopUpHelper(this);
        popUpHelper.setUpWindow(getIntent().getExtras());
    }
}
