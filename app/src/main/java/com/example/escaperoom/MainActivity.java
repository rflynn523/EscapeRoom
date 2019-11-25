package com.example.escaperoom;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import framework.MainBoi;

public class MainActivity extends AppCompatActivity {
    MainBoi main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set window fullscreen and remove titlebar
        // forces landscape through manifest
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.main = new MainBoi(this);
    }
}

