package rooms;

import android.view.View;
import android.widget.ImageButton;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

import java.util.ArrayList;

import framework.Inventory;
import framework.PauseMenu;
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
        super.timer = timer;
        super.menu = new PauseMenu();

        this.mainActivity = mainActivity;
        this.timer = timer;
        this.done = false;
        this.checkpoint = 0;
    }

    // anything not wanted to init in constructor
    // always change view immediately
    public void startRoom() throws InterruptedException {
        // change view
        btn_invoList = super.setView(mainActivity, R.layout.tut_room1, 0);

        // this is a test dont put this in your
        // room
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

        // first time in room message
        super.printMessage("Use the arrows to move to different rooms!", mainActivity);
    }

    public void view1()
    {
        // changes to tut_room1
        btn_invoList.clear();
        btn_invoList = super.setView(mainActivity, R.layout.tut_room1, 0);

        // hiding things not wanted on the view
        mainActivity.findViewById(R.id.btn_left).setVisibility(View.INVISIBLE);

        // set up movement buttons
        ImageButton btn_right = mainActivity.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                view2();
            }
        });

        // finding other things needed for the room
        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                menu.openMenu(mainActivity, timer);
                timer.startTime();
            }
        });
        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);
        btn_hint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // link to a function to show a hint
                // based on where the player is
            }
        });

        // start calling functions based on what the player should see
        // depending on where they are in the room

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

        // finding other things needed for the room
        // menu btn
        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                menu.openMenu(mainActivity, timer);
                timer.startTime();
            }
        });
        // hint btn
        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);
        btn_hint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // link to a function to show a hint
                // based on where the player is
            }
        });

        // start calling functions based on what the player should see
        // depending on where they are in the room
    }

    // loads next room
    private void nextRoom()
    {
        //Room1 room1 = new Room1(mainActivity, timer);
        //room1.startRoom1();
    }
}
