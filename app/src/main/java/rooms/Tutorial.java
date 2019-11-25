package rooms;

import android.view.View;
import android.widget.ImageButton;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

import java.util.ArrayList;

import framework.Inventory;
import framework.Timer;

public class Tutorial extends Room
{
    private MainActivity mainActivity;
    private Timer timer;
    private boolean done;
    private int checkpoint;
    private int currentView;

    // UI components from views
    private ArrayList<ImageButton> btn_invoList;

    // use super to access inventory
    public Tutorial(MainActivity mainActivity, Timer timer)
    {
        super.inventory = new Inventory(mainActivity);
        this.mainActivity = mainActivity;
        this.timer = timer;
        this.done = false;
        this.checkpoint = 0;
    }

    // anything not wanted to init in constructor
    // always change view immediately
    public void startRoom()
    {
        // change view
        btn_invoList = super.setView(mainActivity, R.layout.tut_room1, 0);

        btn_invoList = super.inventory.addToInventory("stopsign", btn_invoList);

        // getting UI comps
        ImageButton btn_right;
        btn_right = (ImageButton) mainActivity.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                checkpoint++;
                view2();
            }
        });
    }

    public void view1()
    {
        // changes to tut_room1
        btn_invoList.clear();
        btn_invoList = super.setView(mainActivity, R.layout.tut_room1, 0);
        currentView = 1;

        // hiding things not wanted on the view
        mainActivity.findViewById(R.id.btn_left).setVisibility(View.INVISIBLE);

        // set up movement buttons
        ImageButton btn_right = mainActivity.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                view2();
            }
        });

        //check checkpoint for next action
    }

    public void view2()
    {
        // changes to tut_room2
        btn_invoList.clear();
        btn_invoList = super.setView(mainActivity, R.layout.tut_room2, 0);
        currentView = 2;

        // hiding things not wanted on the view
        mainActivity.findViewById(R.id.btn_right).setVisibility(View.INVISIBLE);

        // set up things you always want to be clickable
        ImageButton btn_left = mainActivity.findViewById(R.id.btn_left);
        btn_left.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                view1();
            }
        });

        //check checkpoint for next action
        tutTextBox();
    }

    public void tutTextBox()
    {
        switch (checkpoint)
        {
            // player hasnt done anything yet
            case 0:
                break;

            // player has moved right atleast once
            case 1:

        }
    }

    // loads next room
    private void nextRoom()
    {
        //Room1 room1 = new Room1(mainActivity, timer);
        //room1.startRoom1();
    }
}
