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
    boolean bookGrabbed = false;
    boolean pictureFixed = false;

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
    public void startRoom() {
        // change view
        btn_invoList = super.setView(mainActivity, R.layout.tut_room1, 0);
        final ImageButton btn_book = mainActivity.findViewById(R.id.btn_book);

        if (bookGrabbed)
            btn_book.setVisibility(View.INVISIBLE);

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


        btn_book.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                btn_invoList = inventory.addToInventory("book", btn_invoList);
                btn_book.setVisibility(View.INVISIBLE);
                bookGrabbed = true;
            }
        });

        // finding other things needed for the room

        /*
        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);
        btn_hint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // link to a function to show a hint
                // based on where the player is
            }
        });
        */

        // first time in room message
        //super.printMessage("Use the arrows to move to different rooms!", mainActivity);
    }

    public void view2()
    {
        // changes to tut_room2
        btn_invoList.clear();
        btn_invoList = super.setView(mainActivity, R.layout.tut_room2, 0);
        currentView = 2;

        final ImageButton btn_picture = mainActivity.findViewById(R.id.btn_picture);

        if (!pictureFixed)
            btn_picture.setRotation(-15);

        // hiding things not wanted on the view
        mainActivity.findViewById(R.id.btn_right).setVisibility(View.INVISIBLE);

        // set up things you always want to be clickable
        ImageButton btn_left = mainActivity.findViewById(R.id.btn_left);
        btn_left.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startRoom();
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


        btn_picture.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                btn_picture.setRotation(0);
                pictureFixed = true;
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
        final ImageButton btn_door = mainActivity.findViewById(R.id.btn_door);
        btn_door.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (inventory.selectedItem == "book")
                    nextRoom();
                else
                    printMessage("It seems like there's a book missing from the shelf.", mainActivity);
            }
        });
    }

    // loads next room
    private void nextRoom()
    {
        Room1 room1 = new Room1(mainActivity, timer);
        room1.startRoom();
    }
}
