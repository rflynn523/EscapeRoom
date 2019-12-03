package rooms;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

import java.util.ArrayList;

import framework.Inventory;
import framework.PauseMenu;
import framework.Timer;

public class Room3 extends Room
{
    private int checkPoints;
    private int currentView;
    private int viewValue;

    private boolean noButtons = false;
    private boolean spadeTaken = false;
    private boolean screwDriverTaken = false;
    private boolean doorUnlocked = false;
    private boolean matMoved = false;
    private boolean key1 = false;
    private boolean key2 = false;

    private MainActivity mainActivity;

    private ArrayList<ImageButton> btnList;

    public Room3 (MainActivity mainActivity, Timer timer)
    {
        super.inventory = new Inventory(mainActivity);
        super.timer = timer;
        super.menu = new PauseMenu();
        this.mainActivity = mainActivity;
        this.checkPoints = 0;
    }

    public void startRoom3()
    {
        currentView = 1;
        viewValue = R.layout.room3_view1;
        switchView();
    }

    public void switchView()
    {
        if (noButtons)
            super.setView(mainActivity, viewValue);
        else
            btnList = super.setView(mainActivity, viewValue, 0);

        noButtons = false;
        loadIndependents();
    }

    public void loadIndependents()
    {
        Button btn_note1;
        Button btn_door;
        Button btn_open;
        Button btn_note2;
        Button btn_sink;
        Button btn_key;
        Button btn_knife;
        Button btn_spade;
        Button btn_clay;
        Button btn_remote;
        Button btn_hiding;
        Button btn_univ;
        Button btn_history;
        Button btn_harry;
        final Button btn_chest;
        Button btn_shower;
        ImageButton btn_ok;
        ImageButton btn_left;
        ImageButton btn_right;
        ImageButton btn_menu;
        ImageButton btn_hint;
        TextView text_message;

        switch (currentView)
        {
            case 1:
                // create button for note on chair
                btn_note1 = mainActivity.findViewById(R.id.btn_note1);
                btn_note1.setVisibility(View.VISIBLE);
                btn_note1.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (checkPoints == 0)
                            checkPoints = 1;
                        Bundle bundle = new Bundle();
                        bundle.putInt("viewValue", R.layout.room3_note1);
                        bundle.putInt("view", 21);
                        Room3.super.invokePopUp(mainActivity, bundle);
                    }
                });

                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view2;
                        currentView = 2;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });
                break;

            case 2:
                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view3;
                        currentView = 3;
                        switchView();
                    }
                });

                // right btn
                btn_right = mainActivity.findViewById(R.id.btn_right);
                btn_right.setVisibility(View.VISIBLE);
                btn_right.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view1;
                        currentView = 1;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });
                break;

            case 3:
                // right btn
                btn_right = mainActivity.findViewById(R.id.btn_right);
                btn_right.setVisibility(View.VISIBLE);
                btn_right.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view2;
                        currentView = 2;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // door btn
                btn_door = mainActivity.findViewById(R.id.btn_door);
                btn_door.setVisibility(View.VISIBLE);
                btn_door.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (checkPoints <= 0)
                            return;
                        if (checkPoints >= 2)
                        {
                            currentView = 42;
                            viewValue = R.layout.room3_view4_2;
                            switchView();
                            return;
                        }

                        currentView = 4;
                        viewValue = R.layout.room3_view4;
                        switchView();
                    }
                });
                break;

            case 4:
                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view5;
                        currentView = 5;
                        switchView();
                    }
                });

                // right btn
                btn_right = mainActivity.findViewById(R.id.btn_right);
                btn_right.setVisibility(View.VISIBLE);
                btn_right.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view8;
                        currentView = 8;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // open btn
                btn_open = mainActivity.findViewById(R.id.btn_open);
                btn_open.setVisibility(View.VISIBLE);
                btn_open.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (checkPoints == 1)
                            checkPoints = 2;
                        currentView = 42;
                        viewValue = R.layout.room3_view4_2;
                        switchView();
                    }
                });
                break;

            case 42:
                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view5;
                        currentView = 5;
                        switchView();
                    }
                });

                // right btn
                btn_right = mainActivity.findViewById(R.id.btn_right);
                btn_right.setVisibility(View.VISIBLE);
                btn_right.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view8;
                        currentView = 8;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // note2 btn
                btn_note2 = mainActivity.findViewById(R.id.btn_note2);
                btn_note2.setVisibility(View.VISIBLE);
                btn_note2.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (checkPoints == 2)
                            checkPoints = 3;
                        Bundle bundle = new Bundle();
                        bundle.putInt("viewValue", R.layout.room3_note2);
                        bundle.putInt("view", 22);
                        Room3.super.invokePopUp(mainActivity, bundle);
                    }
                });
                break;

            case 5:
                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (spadeTaken)
                        {
                            viewValue = R.layout.room3_view6_2;
                            currentView = 62;
                            switchView();
                            return;
                        }
                        viewValue = R.layout.room3_view6;
                        currentView = 6;
                        switchView();
                    }
                });

                // right btn
                btn_right = mainActivity.findViewById(R.id.btn_right);
                btn_right.setVisibility(View.VISIBLE);
                btn_right.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (checkPoints >= 2)
                        {
                            viewValue = R.layout.room3_view4_2;
                            currentView = 42;
                            switchView();
                            return;
                        }
                        viewValue = R.layout.room3_view4;
                        currentView = 4;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // sink btn
                btn_sink = mainActivity.findViewById(R.id.btn_sink);
                btn_sink.setVisibility(View.VISIBLE);
                btn_sink.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (inventory.inventory.contains("room3_dryclay"))
                        {
                            Room3.super.printMessage("Hmm wonder what I can use to shape this clay with...", mainActivity);
                            btnList = inventory.removeFromInventory("room3_dryclay", btnList);
                            btnList = inventory.addToInventory("room3_wetclay", btnList);
                        }
                    }
                });

                // knife btn
                btn_knife = mainActivity.findViewById(R.id.btn_knife);
                btn_knife.setVisibility(View.VISIBLE);
                btn_knife.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        for (String s : inventory.inventory)
                        {
                            if (s.equals("room3_wetclay") || s.equals("room3_circle") ||
                                s.equals("room3_triangle") || s.equals("room3_square") ||
                                s.equals("room3_pentagon") || s.equals("room3_hexagon"))
                            {
                                noButtons = true;
                                viewValue = R.layout.room3_view5_2;
                                currentView = 52;
                                switchView();
                            }
                        }
                    }
                });
                break;

            case 52:
                // ok btn
                btn_ok = mainActivity.findViewById(R.id.btn_ok);
                btn_ok.setVisibility(View.VISIBLE);
                btn_ok.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view5;
                        currentView = 5;
                        switchView();
                    }
                });

                // circle btn
                Button btn_circle = mainActivity.findViewById(R.id.btn_circle);
                btn_circle.setVisibility(View.VISIBLE);
                btn_circle.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        Room3.super.printMessage("The clay is turned into a circle", mainActivity);
                        if (inventory.inventory.contains("room3_wetclay"))
                            btnList = inventory.removeFromInventory("room3_wetclay", btnList);
                        if (inventory.inventory.contains("room3_circle"))
                            btnList = inventory.removeFromInventory("room3_circle", btnList);
                        if (inventory.inventory.contains("room3_triangle"))
                            btnList = inventory.removeFromInventory("room3_triangle", btnList);
                        if (inventory.inventory.contains("room3_square"))
                            btnList = inventory.removeFromInventory("room3_square", btnList);
                        if (inventory.inventory.contains("room3_pentagon"))
                            btnList = inventory.removeFromInventory("room3_pentagon", btnList);
                        if (inventory.inventory.contains("room3_hexagon"))
                            btnList = inventory.removeFromInventory("room3_hexagon", btnList);
                        btnList = inventory.addToInventory("room3_circle", btnList);
                        viewValue = R.layout.room3_view5;
                        currentView = 5;
                        switchView();
                    }
                });
                // square btn
                Button btn_square = mainActivity.findViewById(R.id.btn_square);
                btn_square.setVisibility(View.VISIBLE);
                btn_square.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        Room3.super.printMessage("The clay is turned into a square", mainActivity);
                        if (inventory.inventory.contains("room3_wetclay"))
                            btnList = inventory.removeFromInventory("room3_wetclay", btnList);
                        if (inventory.inventory.contains("room3_circle"))
                            btnList = inventory.removeFromInventory("room3_circle", btnList);
                        if (inventory.inventory.contains("room3_triangle"))
                            btnList = inventory.removeFromInventory("room3_triangle", btnList);
                        if (inventory.inventory.contains("room3_square"))
                            btnList = inventory.removeFromInventory("room3_square", btnList);
                        if (inventory.inventory.contains("room3_pentagon"))
                            btnList = inventory.removeFromInventory("room3_pentagon", btnList);
                        if (inventory.inventory.contains("room3_hexagon"))
                            btnList = inventory.removeFromInventory("room3_hexagon", btnList);
                        btnList = inventory.addToInventory("room3_square", btnList);
                        viewValue = R.layout.room3_view5;
                        currentView = 5;
                        switchView();
                    }
                });
                // triangle btn
                Button btn_triangle = mainActivity.findViewById(R.id.btn_triangle);
                btn_triangle.setVisibility(View.VISIBLE);
                btn_triangle.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        Room3.super.printMessage("The clay is turned into a triangle", mainActivity);
                        if (inventory.inventory.contains("room3_wetclay"))
                            btnList = inventory.removeFromInventory("room3_wetclay", btnList);
                        if (inventory.inventory.contains("room3_circle"))
                            btnList = inventory.removeFromInventory("room3_circle", btnList);
                        if (inventory.inventory.contains("room3_triangle"))
                            btnList = inventory.removeFromInventory("room3_triangle", btnList);
                        if (inventory.inventory.contains("room3_square"))
                            btnList = inventory.removeFromInventory("room3_square", btnList);
                        if (inventory.inventory.contains("room3_pentagon"))
                            btnList = inventory.removeFromInventory("room3_pentagon", btnList);
                        if (inventory.inventory.contains("room3_hexagon"))
                            btnList = inventory.removeFromInventory("room3_hexagon", btnList);
                        btnList = inventory.addToInventory("room3_triangle", btnList);
                        viewValue = R.layout.room3_view5;
                        currentView = 5;
                        switchView();
                    }
                });

                // pentagon btn
                Button btn_pentagon = mainActivity.findViewById(R.id.btn_pentagon);
                btn_pentagon.setVisibility(View.VISIBLE);
                btn_pentagon.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        Room3.super.printMessage("The clay is turned into a pentagon", mainActivity);
                        if (inventory.inventory.contains("room3_wetclay"))
                            btnList = inventory.removeFromInventory("room3_wetclay", btnList);
                        if (inventory.inventory.contains("room3_circle"))
                            btnList = inventory.removeFromInventory("room3_circle", btnList);
                        if (inventory.inventory.contains("room3_triangle"))
                            btnList = inventory.removeFromInventory("room3_triangle", btnList);
                        if (inventory.inventory.contains("room3_square"))
                            btnList = inventory.removeFromInventory("room3_square", btnList);
                        if (inventory.inventory.contains("room3_pentagon"))
                            btnList = inventory.removeFromInventory("room3_pentagon", btnList);
                        if (inventory.inventory.contains("room3_hexagon"))
                            btnList = inventory.removeFromInventory("room3_hexagon", btnList);
                        btnList = inventory.addToInventory("room3_pentagon", btnList);
                        viewValue = R.layout.room3_view5;
                        currentView = 5;
                        switchView();
                    }
                });

                // hexagon btn
                Button btn_hexagon = mainActivity.findViewById(R.id.btn_hexagon);
                btn_hexagon.setVisibility(View.VISIBLE);
                btn_hexagon.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        Room3.super.printMessage("The clay is turned into a hexagon", mainActivity);
                        if (inventory.inventory.contains("room3_wetclay"))
                            btnList = inventory.removeFromInventory("room3_wetclay", btnList);
                        if (inventory.inventory.contains("room3_circle"))
                            btnList = inventory.removeFromInventory("room3_circle", btnList);
                        if (inventory.inventory.contains("room3_triangle"))
                            btnList = inventory.removeFromInventory("room3_triangle", btnList);
                        if (inventory.inventory.contains("room3_square"))
                            btnList = inventory.removeFromInventory("room3_square", btnList);
                        if (inventory.inventory.contains("room3_pentagon"))
                            btnList = inventory.removeFromInventory("room3_pentagon", btnList);
                        if (inventory.inventory.contains("room3_hexagon"))
                            btnList = inventory.removeFromInventory("room3_hexagon", btnList);
                        btnList = inventory.addToInventory("room3_hexagon", btnList);
                        viewValue = R.layout.room3_view5;
                        currentView = 5;
                        switchView();
                    }
                });
                break;

            case 6:
                // right btn
                btn_right = mainActivity.findViewById(R.id.btn_right);
                btn_right.setVisibility(View.VISIBLE);
                btn_right.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view5;
                        currentView = 5;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // door btn
                btn_door = mainActivity.findViewById(R.id.btn_door);
                btn_door.setVisibility(View.VISIBLE);
                btn_door.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        for (String s : inventory.inventory)
                        {
                            viewValue = R.layout.room3_view7;
                            currentView = 7;
                            switchView();
                        }
                    }
                });

                // spade btn
                btn_spade = mainActivity.findViewById(R.id.btn_spade);
                btn_spade.setVisibility(View.VISIBLE);
                btn_spade.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        spadeTaken = true;
                        btnList = inventory.addToInventory("room3_spade", btnList);
                        viewValue = R.layout.room3_view6_2;
                        currentView = 62;
                        switchView();
                    }
                });
                break;

            case 62:
                // right btn
                btn_right = mainActivity.findViewById(R.id.btn_right);
                btn_right.setVisibility(View.VISIBLE);
                btn_right.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view5;
                        currentView = 5;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // door btn
                btn_door = mainActivity.findViewById(R.id.btn_door);
                btn_door.setVisibility(View.VISIBLE);
                btn_door.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        for (String s : inventory.inventory)
                        {
                            viewValue = R.layout.room3_view7;
                            currentView = 7;
                            switchView();
                        }
                    }
                });
                break;

            case 7:
                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (spadeTaken)
                        {
                            viewValue = R.layout.room3_view6_2;
                            currentView = 6_2;
                            switchView();
                            return;
                        }
                        viewValue = R.layout.room3_view6;
                        currentView = 6;
                        switchView();
                    }
                });


                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // clay btn
                btn_clay = mainActivity.findViewById(R.id.btn_clay);
                btn_clay.setVisibility(View.VISIBLE);
                btn_clay.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (inventory.inventory.contains("room3_spade"))
                        {
                            Room3.super.printMessage("You just picked up some dry clay!", mainActivity);
                            btnList = inventory.removeFromInventory("room3_spade", btnList);
                            btnList = inventory.addToInventory("room3_dryclay", btnList);
                        }
                    }
                });
                break;

            case 8:
            // left btn
            btn_left = mainActivity.findViewById(R.id.btn_left);
            btn_left.setVisibility(View.VISIBLE);
            btn_left.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if (checkPoints >= 2)
                    {
                        viewValue = R.layout.room3_view4_2;
                        currentView = 42;
                        switchView();
                        return;
                    }
                    viewValue = R.layout.room3_view4;
                    currentView = 4;
                    switchView();
                }
            });

            // right btn
            btn_right = mainActivity.findViewById(R.id.btn_right);
            btn_right.setVisibility(View.VISIBLE);
            btn_right.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    viewValue = R.layout.room3_view12;
                    currentView = 12;
                    switchView();
                }
            });

            // up btn
            ImageButton btn_up = mainActivity.findViewById(R.id.btn_up);
            btn_up.setVisibility(View.VISIBLE);
            btn_up.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    viewValue = R.layout.room3_view9;
                    currentView = 9;
                    switchView();
                }
            });

            // hint btn
            btn_hint = mainActivity.findViewById(R.id.btn_hint);
            btn_hint.setVisibility(View.VISIBLE);
            btn_hint.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    useHint();
                }
            });

            // menu btn
            btn_menu = mainActivity.findViewById(R.id.btn_menu);
            btn_menu.setVisibility(View.VISIBLE);
            btn_menu.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    menu.openMenu(mainActivity, timer);
                    timer.startTime();
                }
            });

            // door btn
            btn_door = mainActivity.findViewById(R.id.btn_doorkey);
            btn_door.setVisibility(View.VISIBLE);
            btn_door.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if (inventory.inventory.contains("room3_hexagon"))
                    {
                        doorUnlocked = true;
                        btnList = inventory.removeFromInventory("room3_hexagon", btnList);
                        viewValue = R.layout.room3_view8_2;
                        currentView = 82;
                        switchView();
                    }
                }
            });
            break;

            case 82:
                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (checkPoints >= 2)
                        {
                            viewValue = R.layout.room3_view4_2;
                            currentView = 42;
                            switchView();
                            return;
                        }
                        viewValue = R.layout.room3_view4;
                        currentView = 4;
                        switchView();
                    }
                });

                // right btn
                btn_right = mainActivity.findViewById(R.id.btn_right);
                btn_right.setVisibility(View.VISIBLE);
                btn_right.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view12;
                        currentView = 12;
                        switchView();
                    }
                });

                // up btn
                ImageButton btn_up2 = mainActivity.findViewById(R.id.btn_up);
                btn_up2.setVisibility(View.VISIBLE);
                btn_up2.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view9;
                        currentView = 9;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // door btn
                btn_door = mainActivity.findViewById(R.id.btn_doorkey);
                btn_door.setVisibility(View.VISIBLE);
                btn_door.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){

                            if (matMoved)
                            {
                                viewValue = R.layout.room3_view13_2;
                                currentView = 132;
                                switchView();
                                return;
                            }
                            viewValue = R.layout.room3_view13;
                            currentView = 13;
                            switchView();
                    }
                });
                break;

            case 12:
                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (doorUnlocked)
                        {
                            viewValue = R.layout.room3_view8_2;
                            currentView = 82;
                            switchView();
                            return;
                        }
                        viewValue = R.layout.room3_view8;
                        currentView = 8;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // remote btn
                btn_remote = mainActivity.findViewById(R.id.btn_remote);
                btn_remote.setVisibility(View.VISIBLE);
                btn_remote.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        noButtons = true;
                        viewValue = R.layout.room3_view12_2;
                        currentView = 122;
                        switchView();
                    }
                });
                break;
            case 122:
                // remote btn
                btn_remote = mainActivity.findViewById(R.id.btn_remote);
                btn_remote.setVisibility(View.VISIBLE);
                btn_remote.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (inventory.inventory.contains("room3_screwdriver"))
                        {
                            noButtons = true;
                            viewValue = R.layout.room3_view12_3;
                            currentView = 123;
                            switchView();
                        }
                    }
                });

                // ok btn
                btn_ok = mainActivity.findViewById(R.id.btn_ok);
                btn_ok.setVisibility(View.VISIBLE);
                btn_ok.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view12;
                        currentView = 12;
                        switchView();
                    }
                });
                break;
            case 123:
                // remote btn
                btn_remote = mainActivity.findViewById(R.id.btn_remote);
                btn_remote.setVisibility(View.VISIBLE);
                btn_remote.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        btnList = inventory.removeFromInventory("room3_screwdriver", btnList);
                        btnList = inventory.addToInventory("room3_battery", btnList);
                        viewValue = R.layout.room3_view12;
                        currentView = 12;
                        switchView();
                    }
                });
                break;
            case 9:
                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (doorUnlocked)
                        {
                            viewValue = R.layout.room3_view8_2;
                            currentView = 82;
                            switchView();
                            return;
                        }
                        viewValue = R.layout.room3_view8;
                        currentView = 8;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // door btn
                btn_door = mainActivity.findViewById(R.id.btn_room);
                btn_door.setVisibility(View.VISIBLE);
                btn_door.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                            viewValue = R.layout.room3_view10;
                            currentView = 10;
                            switchView();

                    }
                });

                // door btn
                btn_circle = mainActivity.findViewById(R.id.btn_bath);
                btn_circle.setVisibility(View.VISIBLE);
                btn_circle.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (checkPoints >= 4)
                        {
                            viewValue = R.layout.room3_view11_2;
                            currentView = 112;
                            switchView();
                            return;
                        }
                            viewValue = R.layout.room3_view11;
                            currentView = 11;
                            switchView();
                    }
                });
                break;
            case 10:
                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){

                        viewValue = R.layout.room3_view9;
                        currentView = 9;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // chest btn
                btn_chest = mainActivity.findViewById(R.id.btn_chest);
                btn_chest.setVisibility(View.VISIBLE);
                btn_chest.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (screwDriverTaken)
                        {
                            noButtons = true;
                            viewValue = R.layout.room3_chestun3;
                            currentView = 105;
                            switchView();
                            return;
                        }
                        noButtons = true;
                        viewValue = R.layout.room3_chest;
                        currentView = 102;
                        switchView();
                    }
                });

                // history btn
                btn_history = mainActivity.findViewById(R.id.history);
                btn_history.setVisibility(View.VISIBLE);
                btn_history.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        noButtons = true;
                        viewValue = R.layout.room3_book_history1;
                        currentView = 106;
                        switchView();
                    }
                });

                // univ btn
                btn_univ = mainActivity.findViewById(R.id.univ);
                btn_univ.setVisibility(View.VISIBLE);
                btn_univ.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        noButtons = true;
                        viewValue = R.layout.room3_book_univ;
                        currentView = 1001;
                        switchView();
                    }
                });
                // harry btn
                btn_harry = mainActivity.findViewById(R.id.harry);
                btn_harry.setVisibility(View.VISIBLE);
                btn_harry.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        noButtons = true;
                        viewValue = R.layout.room3_book_harry;
                        currentView = 1002;
                        switchView();
                    }
                });
                // hiding btn
                btn_hiding = mainActivity.findViewById(R.id.btn_hiding);
                btn_hiding.setVisibility(View.VISIBLE);
                btn_hiding.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        noButtons = true;
                        viewValue = R.layout.room3_book_hiding;
                        currentView = 1003;
                        switchView();
                    }
                });
                break;
            case 106:
                // ok btn
                btn_ok = mainActivity.findViewById(R.id.btn_ok);
                btn_ok.setVisibility(View.VISIBLE);
                btn_ok.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view10;
                        currentView = 10;
                        switchView();
                    }
                });

                // right btn
                btn_right = mainActivity.findViewById(R.id.btn_right);
                btn_right.setVisibility(View.VISIBLE);
                btn_right.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (key1)
                        {
                            noButtons = true;
                            viewValue = R.layout.room3_book_history4;
                            currentView = 109;
                            switchView();
                            return;
                        }
                        noButtons = true;
                        viewValue = R.layout.room3_book_history2;
                        currentView = 107;
                        switchView();
                    }
                });
                break;
            case 107:

                // ok btn
                btn_ok = mainActivity.findViewById(R.id.btn_ok);
                btn_ok.setVisibility(View.VISIBLE);
                btn_ok.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        noButtons = true;
                        viewValue = R.layout.room3_view10;
                        currentView = 10;
                        switchView();
                    }
                });

                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        noButtons = true;
                        viewValue = R.layout.room3_book_history1;
                        currentView = 106;
                        switchView();
                    }
                });

                // key btn
                btn_key = mainActivity.findViewById(R.id.btn_key);
                btn_key.setVisibility(View.VISIBLE);
                btn_key.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        noButtons = true;
                        viewValue = R.layout.room3_book_history3;
                        currentView = 108;
                        switchView();
                    }
                });
                break;
            case 108:
            // key btn
            btn_key = mainActivity.findViewById(R.id.btn_key);
            btn_key.setVisibility(View.VISIBLE);
            btn_key.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    btnList = inventory.addToInventory("room3_key1", btnList);
                    key1 = true;
                    viewValue = R.layout.room3_view10;
                    currentView = 10;
                    switchView();
                }
            });
            break;
            case 109:
                // ok btn
                btn_ok = mainActivity.findViewById(R.id.btn_ok);
                btn_ok.setVisibility(View.VISIBLE);
                btn_ok.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view10;
                        currentView = 10;
                        switchView();
                    }
                });
                break;

            case 1001:

            // ok btn
            btn_ok = mainActivity.findViewById(R.id.btn_ok);
            btn_ok.setVisibility(View.VISIBLE);
            btn_ok.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    viewValue = R.layout.room3_view10;
                    currentView = 10;
                    switchView();
                }
            });
            break;
            case 1002:

                // ok btn
                btn_ok = mainActivity.findViewById(R.id.btn_ok);
                btn_ok.setVisibility(View.VISIBLE);
                btn_ok.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view10;
                        currentView = 10;
                        switchView();
                    }
                });
                break;

            case 1003:
            // ok btn
            btn_ok = mainActivity.findViewById(R.id.btn_ok);
            btn_ok.setVisibility(View.VISIBLE);
            btn_ok.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    viewValue = R.layout.room3_view10;
                    currentView = 10;
                    switchView();
                }
            });

            // right btn
            btn_right = mainActivity.findViewById(R.id.btn_right);
            btn_right.setVisibility(View.VISIBLE);
            btn_right.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if (checkPoints == 2)
                        checkPoints = 3;
                    noButtons = true;
                    viewValue = R.layout.room3_book_hiding2;
                    currentView = 1004;
                    switchView();
                }
            });
            break;

            case 1004:
            // ok btn
            btn_ok = mainActivity.findViewById(R.id.btn_ok);
            btn_ok.setVisibility(View.VISIBLE);
            btn_ok.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    viewValue = R.layout.room3_view10;
                    currentView = 10;
                    switchView();
                }
            });

            break;

            case 102:
                // ok btn
                btn_ok = mainActivity.findViewById(R.id.btn_ok);
                btn_ok.setVisibility(View.VISIBLE);
                btn_ok.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view10;
                        currentView = 10;
                        switchView();
                    }
                });

                // key btn
                btn_key = mainActivity.findViewById(R.id.btn_key);
                btn_key.setVisibility(View.VISIBLE);
                btn_key.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (inventory.inventory.contains("room3_key2"))
                        {
                            noButtons = true;
                            btnList = inventory.removeFromInventory("room3_key2", btnList);
                            viewValue = R.layout.room3_chestun1;
                            currentView = 103;
                            switchView();
                        }
                    }
                });
                break;
            case 103:
            // key btn
            btn_key = mainActivity.findViewById(R.id.btn_key);
            btn_key.setVisibility(View.VISIBLE);
            btn_key.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    noButtons = true;
                    viewValue = R.layout.room3_chestun2;
                    currentView = 104;
                    switchView();
                }
            });
            break;
            case 104:
            // key btn
            btn_key = mainActivity.findViewById(R.id.btn_screw);
            btn_key.setVisibility(View.VISIBLE);
            btn_key.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    screwDriverTaken = true;
                    btnList = inventory.addToInventory("room3_screwdriver", btnList);
                    noButtons = true;
                    viewValue = R.layout.room3_chestun3;
                    currentView = 105;
                    switchView();
                }
            });
            break;
            case 105:
                // ok btn
                btn_ok = mainActivity.findViewById(R.id.btn_ok);
                btn_ok.setVisibility(View.VISIBLE);
                btn_ok.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view10;
                        currentView = 10;
                        switchView();
                    }
                });
                break;
            case 11:
            // left btn
            btn_left = mainActivity.findViewById(R.id.btn_left);
            btn_left.setVisibility(View.VISIBLE);
            btn_left.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    viewValue = R.layout.room3_view9;
                    currentView = 9;
                    switchView();
                }
            });

            // hint btn
            btn_hint = mainActivity.findViewById(R.id.btn_hint);
            btn_hint.setVisibility(View.VISIBLE);
            btn_hint.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    useHint();
                }
            });

            // menu btn
            btn_menu = mainActivity.findViewById(R.id.btn_menu);
            btn_menu.setVisibility(View.VISIBLE);
            btn_menu.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    menu.openMenu(mainActivity, timer);
                    timer.startTime();
                }
            });

            // shower btn
            btn_door = mainActivity.findViewById(R.id.btn_shower);
            btn_door.setVisibility(View.VISIBLE);
            btn_door.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if (checkPoints >= 3)
                    {
                        checkPoints = 4;
                        btnList = inventory.addToInventory("room3_key2", btnList);
                        key2 = true;
                        viewValue = R.layout.room3_view11_2;
                        currentView = 112;
                        switchView();
                    }

                }
            });

            break;

            case 112:
                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view9;
                        currentView = 9;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });
                break;

            case 13:
                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view8_2;
                        currentView = 82;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // carp btn
                btn_key = mainActivity.findViewById(R.id.btn_carp);
                btn_key.setVisibility(View.VISIBLE);
                btn_key.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view13_2;
                        currentView = 132;
                        switchView();
                    }
                });
                break;

            case 132:
                // left btn
                btn_left = mainActivity.findViewById(R.id.btn_left);
                btn_left.setVisibility(View.VISIBLE);
                btn_left.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        viewValue = R.layout.room3_view8_2;
                        currentView = 82;
                        switchView();
                    }
                });

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // carp btn
                btn_key = mainActivity.findViewById(R.id.btn_trap);
                btn_key.setVisibility(View.VISIBLE);
                btn_key.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if (inventory.inventory.contains("room3_key1"))
                        {
                            viewValue = R.layout.room3_view14;
                            currentView = 14;
                            switchView();
                        }
                    }
                });
                break;

            case 14:
            // right btn
            btn_right = mainActivity.findViewById(R.id.btn_right);
            btn_right.setVisibility(View.VISIBLE);
            btn_right.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    viewValue = R.layout.room3_view13_2;
                    currentView = 132;
                    switchView();
                }
            });

            // hint btn
            btn_hint = mainActivity.findViewById(R.id.btn_hint);
            btn_hint.setVisibility(View.VISIBLE);
            btn_hint.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    useHint();
                }
            });

            // menu btn
            btn_menu = mainActivity.findViewById(R.id.btn_menu);
            btn_menu.setVisibility(View.VISIBLE);
            btn_menu.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    menu.openMenu(mainActivity, timer);
                    timer.startTime();
                }
            });

            // power btn
            btn_key = mainActivity.findViewById(R.id.btn_power);
            btn_key.setVisibility(View.VISIBLE);
            btn_key.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if (inventory.inventory.contains("room3_battery"))
                    {
                        btnList = inventory.removeFromInventory("room3_battery", btnList);
                        viewValue = R.layout.room3_view14_2;
                        currentView = 142;
                        switchView();
                    }
                }
            });
            break;
            case 142:

                // hint btn
                btn_hint = mainActivity.findViewById(R.id.btn_hint);
                btn_hint.setVisibility(View.VISIBLE);
                btn_hint.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        useHint();
                    }
                });

                // menu btn
                btn_menu = mainActivity.findViewById(R.id.btn_menu);
                btn_menu.setVisibility(View.VISIBLE);
                btn_menu.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        menu.openMenu(mainActivity, timer);
                        timer.startTime();
                    }
                });

                // end btn
                btn_key = mainActivity.findViewById(R.id.btn_end);
                btn_key.setVisibility(View.VISIBLE);
                btn_key.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        callNextFloor();

                    }
                });
                break;
        }
    }

    public void useHint()
    {
        if (!spadeTaken)
        {
            super.printMessage("Maybe I should find something to dig up that clay outside with.", mainActivity);
            timer.addToHintTime(10);
            return;
        }
        if (!screwDriverTaken)
        {
            super.printMessage("I may find something up in that chest upstairs. Maybe one of the books can led me to a key", mainActivity);
            timer.addToHintTime(20);
            return;
        }
        if (!doorUnlocked)
        {
            super.printMessage("Hmm that clay from outside could probably be hydrated then cut to unlock the basement door", mainActivity);
            timer.addToHintTime(30);
            return;
        }
        if (!key1)
        {
            super.printMessage("I may be able to find a key for the basement in one of the books upstairs", mainActivity);
            timer.addToHintTime(30);
            return;
        }
        if (!key2)
        {
            super.printMessage("Maybe a book upstairs can led me too a hidin key for that chest upstairs", mainActivity);
            timer.addToHintTime(30);
            return;
        }
        if (!inventory.inventory.contains("room3_battery"))
        {
            super.printMessage("I should find something that might store batteries and I can use a screwdriver on. Maybe downstairs", mainActivity);
            timer.addToHintTime(10);
            return;
        }
    }

    public void callNextFloor()
    {
        Room5 room5 = new Room5(mainActivity, timer);
        room5.startRoom5();
    }


}
