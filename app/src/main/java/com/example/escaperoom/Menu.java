package com.example.escaperoom;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import framework.MenuClass;
import android.view.WindowManager;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause_menu);

        // set window fullscreen and remove titlebar
        // forces landscape through manifest
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        MenuClass menu = new MenuClass(this);
        menu.startMenu(getIntent().getExtras());
    }
}
