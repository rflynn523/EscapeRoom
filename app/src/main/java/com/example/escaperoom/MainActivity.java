package com.example.escaperoom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import framework.MainBoi;

public class MainActivity extends AppCompatActivity {
    MainBoi main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.main = new MainBoi(this);
    }

}

