package com.example.escaperoom;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Objects;

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

    public void launchMenu(Intent intent)
    {
        startActivity(intent);
    }
}

