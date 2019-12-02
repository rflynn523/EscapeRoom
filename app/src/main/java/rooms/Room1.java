package rooms;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

import java.util.ArrayList;

import framework.Inventory;
import framework.PauseMenu;
import framework.Timer;

public class Room1 extends Room
{
    private MainActivity mainActivity;
    private Timer timer;
    private boolean done;
    boolean firstEntrance = true;
    private int checkpoint;
    private int currentView;

    boolean purpleGrabbed = false;
    boolean blueGrabbed = false;
    boolean greenGrabbed = false;
    boolean purplePlaced = false;
    boolean bluePlaced = false;
    boolean greenPlaced = false;
    boolean batteryGrabbed = false;
    boolean portalActivated = false;

    // UI components from views
    private ArrayList<ImageButton> btn_invoList;

    // use super to access inventory
    public Room1(MainActivity mainActivity, Timer timer)
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
    public void startRoom() {
        // change view
        btn_invoList = super.setView(mainActivity, R.layout.room1_front, 0);
        final ImageButton btn_item_beaker_purple = mainActivity.findViewById(R.id.btn_item_beaker_purple);

        final ImageView img_beaker1 = mainActivity.findViewById(R.id.img_beaker1);
        final ImageView img_beaker2 = mainActivity.findViewById(R.id.img_beaker2);
        final ImageView img_beaker3 = mainActivity.findViewById(R.id.img_beaker3);

        if (firstEntrance)
        {
            printMessage("Wow, I never knew this was behind that bookshelf. Must be some sort of lab.", mainActivity);
            firstEntrance = false;
        }

        if (purpleGrabbed)
            btn_item_beaker_purple.setVisibility(View.INVISIBLE);

        if (purplePlaced)
            img_beaker1.setVisibility(View.VISIBLE);
        if (bluePlaced)
            img_beaker2.setVisibility(View.VISIBLE);
        if (greenPlaced)
            img_beaker3.setVisibility(View.VISIBLE);

        ImageButton btn_left;
        btn_left = (ImageButton) mainActivity.findViewById(R.id.btn_left);
        btn_left.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                checkpoint++;
                view1();
            }
        });

        // getting UI comps
        ImageButton btn_right;
        btn_right = (ImageButton) mainActivity.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                checkpoint++;
                view2();
            }
        });

        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                menu.openMenu(mainActivity, timer);
                timer.startTime();
            }
        });

        ImageButton btn_beaker1 = mainActivity.findViewById(R.id.btn_beaker1);
        btn_beaker1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (inventory.selectedItem == "lab_beaker_purple")
                {
                    printMessage("I think that goes there", mainActivity);
                    img_beaker1.setVisibility(View.VISIBLE);
                    purplePlaced = true;
                    btn_invoList = inventory.removeFromInventory("lab_beaker_purple", btn_invoList);
                }
                else
                    printMessage("I don't think this is the right spot for that.", mainActivity);
            }
        });

        ImageButton btn_beaker2 = mainActivity.findViewById(R.id.btn_beaker2);
        btn_beaker2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (inventory.selectedItem == "lab_beaker_blue")
                {
                    printMessage("I think that goes there", mainActivity);
                    img_beaker2.setVisibility(View.VISIBLE);
                    bluePlaced = true;
                    btn_invoList = inventory.removeFromInventory("lab_beaker_blue", btn_invoList);
                }
                else
                    printMessage("I don't think this is the right spot for that.", mainActivity);
            }
        });
        ImageButton btn_beaker3 = mainActivity.findViewById(R.id.btn_beaker3);
        btn_beaker3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (inventory.selectedItem == "lab_beaker_green")
                {
                    printMessage("I think that goes there", mainActivity);
                    img_beaker3.setVisibility(View.VISIBLE);
                    greenPlaced = true;
                    btn_invoList = inventory.removeFromInventory("lab_beaker_green", btn_invoList);
                }
                else
                    printMessage("I don't think this is the right spot for that.", mainActivity);
            }
        });

        btn_item_beaker_purple.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                btn_invoList = inventory.addToInventory("lab_beaker_purple", btn_invoList);
                btn_item_beaker_purple.setVisibility(View.INVISIBLE);
                purpleGrabbed = true;
            }
        });

        if(greenPlaced && purplePlaced && bluePlaced && !batteryGrabbed)
        {
            btn_invoList = inventory.addToInventory("battery", btn_invoList);
            batteryGrabbed = true;
            printMessage("After placing all the beakers correctly, I found a battery!", mainActivity);
        }
    }

    public void view1()
    {
        // changes to tut_room1
        btn_invoList.clear();
        btn_invoList = super.setView(mainActivity, R.layout.room1_left, 0);

        final ImageButton btn_item_beaker_blue = mainActivity.findViewById(R.id.btn_item_beaker_blue);

        if (blueGrabbed)
            btn_item_beaker_blue.setVisibility(View.INVISIBLE);

        // hiding things not wanted on the view
        mainActivity.findViewById(R.id.btn_left).setVisibility(View.INVISIBLE);

        // set up movement buttons
        ImageButton btn_right = mainActivity.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startRoom();
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

        btn_item_beaker_blue.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                btn_invoList = inventory.addToInventory("lab_beaker_blue", btn_invoList);
                btn_item_beaker_blue.setVisibility(View.INVISIBLE);
                blueGrabbed = true;
            }
        });

        final ImageButton btn_portal = mainActivity.findViewById(R.id.btn_portal);
        final ImageButton btn_portal_on = mainActivity.findViewById(R.id.btn_portal_on);
        btn_portal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (inventory.selectedItem == "battery") {
                    portalActivated = true;
                    btn_portal.setVisibility(View.INVISIBLE);
                    printMessage("The battery turned on the portal. Lets jump in!", mainActivity);
                    btn_portal_on.setVisibility(View.VISIBLE);
                    btn_invoList = inventory.removeFromInventory("battery", btn_invoList);
                }
            }
        });

        btn_portal_on.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                nextRoom();
            }
        });

        /*
        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);
        btn_hint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // link to a function to show a hint
                // based on where the player is
            }
        });
*/
        // start calling functions based on what the player should see
        // depending on where they are in the room

    }

    public void view2()
    {
        // changes to tut_room2
        btn_invoList.clear();
        btn_invoList = super.setView(mainActivity, R.layout.room1_right, 0);
        currentView = 2;

        // hiding things not wanted on the view
        mainActivity.findViewById(R.id.btn_right).setVisibility(View.INVISIBLE);

        final ImageButton btn_item_beaker_green = mainActivity.findViewById(R.id.btn_item_beaker_green);

        if (greenGrabbed)
            btn_item_beaker_green.setVisibility(View.INVISIBLE);

        // set up things you always want to be clickable
        ImageButton btn_left = mainActivity.findViewById(R.id.btn_left);
        btn_left.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startRoom();
            }
        });

        // menu btn
        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                menu.openMenu(mainActivity, timer);
                timer.startTime();
            }
        });

        btn_item_beaker_green.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //puzzle();
                btn_invoList = inventory.addToInventory("lab_beaker_green", btn_invoList);
                btn_item_beaker_green.setVisibility(View.INVISIBLE);
                greenGrabbed = true;
            }
        });

        // hint btn
        /*
        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);
        btn_hint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // link to a function to show a hint
                // based on where the player is
            }
        });
*/
        // start calling functions based on what the player should see
        // depending on where they are in the room
    }


    // loads next room
    private void nextRoom()
    {
        Room2 room2 = new Room2(mainActivity, timer);
        room2.startRoom2();
    }
}
