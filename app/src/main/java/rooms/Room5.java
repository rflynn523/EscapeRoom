package rooms;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.widget.ImageView;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

import java.util.ArrayList;

import framework.Inventory;
import framework.PauseMenu;
import framework.Timer;

public class Room5 extends Room {
    MainActivity mainActivity;
    private Timer timer;

    private ArrayList<ImageButton> btn_invoList;

    private int start = R.layout.room5start;
    private int front = R.layout.room5front;
    private int right = R.layout.room5right;
    private int left = R.layout.room5left;

    //used for circuit box puzzle
    private int wireb = 0;
    private int wirer = 0;
    private int wirep = 0;
    private int wiret = 0;
    private int wireg = 0;
    private int hints = 0;

    private boolean[] checkpoints;

    public Room5(MainActivity mainActivity, Timer timer) {
        super.inventory = new Inventory(mainActivity);
        super.timer = timer;
        super.menu = new PauseMenu();

        this.mainActivity = mainActivity;
        this.timer = timer;
        this.checkpoints = new boolean[8];
    }

    public void startRoom5(){
        // change view
        btn_invoList = super.setView(mainActivity, start, 0);


        mainActivity.findViewById(R.id.btn_right).setVisibility(View.INVISIBLE);
        mainActivity.findViewById(R.id.btn_left).setVisibility(View.INVISIBLE);

        final Button btn_back1 = mainActivity.findViewById(R.id.btn_back1);
        mainActivity.findViewById(R.id.btn_back1).setVisibility(View.INVISIBLE);

        ImageView hint1 = mainActivity.findViewById(R.id.hint1);
        mainActivity.findViewById(R.id.hint1).setVisibility(View.INVISIBLE);

        // getting UI comps
        Button btn_door = mainActivity.findViewById(R.id.btn_door);
        btn_door.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                front();
            }
        });

        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);
        btn_hint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hints++;
                mainActivity.findViewById(R.id.btn_back1).setVisibility(View.VISIBLE);
                mainActivity.findViewById(R.id.hint1).setVisibility(View.VISIBLE);

                btn_back1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        mainActivity.findViewById(R.id.btn_back1).setVisibility(View.INVISIBLE);
                        mainActivity.findViewById(R.id.hint1).setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

    }

    void front() {

        // changes to room5front
        btn_invoList = super.setView(mainActivity, front, 0);

        ImageView msgf = mainActivity.findViewById(R.id.room5frontmsg);

        if(checkpoints[4] == true)
            msgf.setVisibility(View.INVISIBLE);

        else
            msgf.setVisibility(View.VISIBLE);

        checkpoints[4] = true;

        // set up movement buttons
        ImageButton btn_right = mainActivity.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                right();
            }
        });

        ImageButton btn_left = mainActivity.findViewById(R.id.btn_left);
        btn_left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(checkpoints[2]==false)
                    left();

                else
                    leftfixed();
            }
        });

        // finding other things needed for the room
        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                menu.openMenu(mainActivity, timer);
                timer.startTime();
            }
        });
        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);
        btn_hint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // link to a function to show a hint
                // based on where the player is
            }
        });
        // start calling functions based on what the player should see
        // depending on where they are in the room
    }


    void right() {
        btn_invoList.clear();
        // changes to room5front
        btn_invoList = super.setView(mainActivity, right, 0);

        // set up movement buttons
        mainActivity.findViewById(R.id.btn_right).setVisibility(View.GONE);

        ImageView portal_on = mainActivity.findViewById(R.id.portal_on);
        mainActivity.findViewById(R.id.portal_on).setVisibility(View.INVISIBLE);

        Button portal_btn = mainActivity.findViewById(R.id.portal_btn);
        mainActivity.findViewById(R.id.portal_btn).setVisibility(View.INVISIBLE);

        //"portal no power:("
        final ImageView msg1 = mainActivity.findViewById(R.id.room5msg1);
        msg1.setVisibility(View.VISIBLE);

        //"You did it!"
        final ImageView msg2 = mainActivity.findViewById(R.id.room5rightmsg2);
        msg2.setVisibility(View.INVISIBLE);

        final ImageView msg3 = mainActivity.findViewById(R.id.room5msg3);
        msg3.setVisibility(View.INVISIBLE);

        ImageButton btn_left = mainActivity.findViewById(R.id.btn_left);
        btn_left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                front();
            }
        });

        // finding other things needed for the room
        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                menu.openMenu(mainActivity, timer);
                timer.startTime();
            }
        });
        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);
        btn_hint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // link to a function to show a hint
                // based on where the player is
            }
        });

        Button btn_on = mainActivity.findViewById(R.id.btn_on);
        btn_on.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if((checkpoints[1]&&checkpoints[2]&&checkpoints[3]&&checkpoints[4])==true)
                {
                    mainActivity.findViewById(R.id.portal_on).setVisibility(View.VISIBLE);
                    mainActivity.findViewById(R.id.portal_btn).setVisibility(View.VISIBLE);


                    msg2.setVisibility(View.VISIBLE);
                    msg1.setVisibility(View.INVISIBLE);
                }
                else
                {
                    msg1.setVisibility(View.INVISIBLE);
                    msg2.setVisibility(View.INVISIBLE);
                    msg3.setVisibility(View.VISIBLE);
                }
            }
        });

        portal_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                endscreen();
            }
        });

    }


    void left() {
        // changes to room5front
        btn_invoList = super.setView(mainActivity, left, 0);

        // set up movement buttons
        ImageButton btn_right = mainActivity.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                front();
            }
        });

        Button btn_circuit = mainActivity.findViewById(R.id.btn_circuit);
        btn_circuit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                circuit();
            }
        });

        // finding other things needed for the room
        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                menu.openMenu(mainActivity, timer);
                timer.startTime();
            }
        });

        final Button btn_backleft = mainActivity.findViewById(R.id.btn_backleft);
        mainActivity.findViewById(R.id.btn_backleft).setVisibility(View.INVISIBLE);

        ImageView hintwire = mainActivity.findViewById(R.id.hintwire);
        mainActivity.findViewById(R.id.hintwire).setVisibility(View.INVISIBLE);

        ImageView hintcircuit = mainActivity.findViewById(R.id.hintcircuit);
        mainActivity.findViewById(R.id.hintcircuit).setVisibility(View.INVISIBLE);

        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);
        btn_hint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hints++;

                if(checkpoints[2]==false)
                {
                    mainActivity.findViewById(R.id.hintcircuit).setVisibility(View.INVISIBLE);
                    mainActivity.findViewById(R.id.hintwire).setVisibility(View.VISIBLE);
                    mainActivity.findViewById(R.id.btn_backleft).setVisibility(View.VISIBLE);
                    btn_backleft.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            mainActivity.findViewById(R.id.btn_backleft).setVisibility(View.INVISIBLE);
                            mainActivity.findViewById(R.id.hintwire).setVisibility(View.INVISIBLE);
                        }
                    });
                }

                if((checkpoints[3]==false)&&checkpoints[2]==true)
                {
                    mainActivity.findViewById(R.id.hintwire).setVisibility(View.INVISIBLE);
                    mainActivity.findViewById(R.id.hintcircuit).setVisibility(View.VISIBLE);
                    mainActivity.findViewById(R.id.btn_backleft).setVisibility(View.VISIBLE);
                    btn_backleft.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            mainActivity.findViewById(R.id.btn_backleft).setVisibility(View.INVISIBLE);
                            mainActivity.findViewById(R.id.hintcircuit).setVisibility(View.INVISIBLE);
                        }
                    });
                }

            }
        });

        final ImageButton btn_transistor = mainActivity.findViewById(R.id.btn_transistor);
        btn_transistor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn_transistor.setVisibility(View.INVISIBLE);
                btn_invoList = Room5.super.inventory.addToInventory("transistor", btn_invoList);
                checkpoints[1] = true;
            }
        });

        final Button btn_wire = mainActivity.findViewById(R.id.btn_wire);

        btn_wire.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (("transistor".equals(Room5.super.inventory.selectedItem))&& checkpoints[1] == true)
                {
                    checkpoints[2] = true;
                    btn_invoList = Room5.super.inventory.removeFromInventory("transistor", btn_invoList);
                    leftfixed();
                }
            }
        });

    }

    void leftfixed()
    {
        btn_invoList = super.setView(mainActivity, R.layout.room5leftfixed, 0);

        // set up movement buttons
        ImageButton btn_right = mainActivity.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                front();
            }
        });

        Button btn_circuit = mainActivity.findViewById(R.id.btn_circuit);
        btn_circuit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                circuit();
            }
        });

        // finding other things needed for the room
        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                menu.openMenu(mainActivity, timer);
                timer.startTime();
            }
        });

        final Button btn_backleftfix = mainActivity.findViewById(R.id.btn_backleftfixed);
        mainActivity.findViewById(R.id.btn_backleftfixed).setVisibility(View.INVISIBLE);

        ImageView hintcircuitfix = mainActivity.findViewById(R.id.hintcircuitfixed);
        mainActivity.findViewById(R.id.hintcircuitfixed).setVisibility(View.INVISIBLE);

        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);
        btn_hint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if((checkpoints[3]==false)&&checkpoints[2]==true)
                {
                    hints++;
                    mainActivity.findViewById(R.id.hintcircuitfixed).setVisibility(View.VISIBLE);
                    mainActivity.findViewById(R.id.btn_backleftfixed).setVisibility(View.VISIBLE);
                    btn_backleftfix.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            mainActivity.findViewById(R.id.btn_backleftfixed).setVisibility(View.INVISIBLE);
                            mainActivity.findViewById(R.id.hintcircuitfixed).setVisibility(View.INVISIBLE);
                        }
                    });
                }
            }
        });


    }

    void circuit()
    {


        // changes to room5front
        btn_invoList = super.setView(mainActivity, R.layout.room5circuit, 0);

        //circuit box controls
        ImageView greenbar = mainActivity.findViewById(R.id.greenbar);
        ImageView redbar = mainActivity.findViewById(R.id.redbar);

        ImageView circuitb = mainActivity.findViewById(R.id.circuitb);
        ImageView circuitr = mainActivity.findViewById(R.id.circuitr);
        ImageView circuitp = mainActivity.findViewById(R.id.circuitp);
        ImageView circuitt = mainActivity.findViewById(R.id.circuitt);
        ImageView circuitg = mainActivity.findViewById(R.id.circuitg);

        //if circuit is not finished
        if(checkpoints[3]==false)
        {
            circuitb.setVisibility(View.INVISIBLE);
            circuitr.setVisibility(View.INVISIBLE);
            circuitp.setVisibility(View.INVISIBLE);
            circuitt.setVisibility(View.INVISIBLE);
            circuitg.setVisibility(View.INVISIBLE);

            greenbar.setVisibility(View.INVISIBLE);
            redbar.setVisibility(View.INVISIBLE);
        }

        //if circuit is completed
        if(checkpoints[3] == true)
        {
            circuitb.setVisibility(View.VISIBLE);
            circuitr.setVisibility(View.VISIBLE);
            circuitp.setVisibility(View.VISIBLE);
            circuitt.setVisibility(View.VISIBLE);
            circuitg.setVisibility(View.VISIBLE);
            mainActivity.findViewById(R.id.greenbar).setVisibility(View.VISIBLE);
            mainActivity.findViewById(R.id.redbar).setVisibility(View.INVISIBLE);

        }

        // finding other things needed for the room
        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                menu.openMenu(mainActivity, timer);
                timer.startTime();
            }
        });
        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);
        btn_hint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // link to a function to show a hint
                // based on where the player is
            }
        });

        //controls for circuit buttons
        //solution code is button 3, 2, 1
        final ImageButton circuitbtn1 = mainActivity.findViewById(R.id.circuitbtn1);
        circuitbtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                wiret = 1;
                mainActivity.findViewById(R.id.circuitt).setVisibility(View.VISIBLE);
                wirep = 1;
                mainActivity.findViewById(R.id.circuitp).setVisibility(View.VISIBLE);
                wireb = 1;
                mainActivity.findViewById(R.id.circuitb).setVisibility(View.VISIBLE);

            }
        });

        final ImageButton circuitbtn2 = mainActivity.findViewById(R.id.circuitbtn2);
        circuitbtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                wirer = 1;
                mainActivity.findViewById(R.id.circuitr).setVisibility(View.VISIBLE);
                wireg = 1;
                mainActivity.findViewById(R.id.circuitg).setVisibility(View.VISIBLE);
                wirep = 0;
                mainActivity.findViewById(R.id.circuitp).setVisibility(View.INVISIBLE);
            }
        });

        ImageButton circuitbtn3 = mainActivity.findViewById(R.id.circuitbtn3);
        circuitbtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                wiret = 1;
                mainActivity.findViewById(R.id.circuitt).setVisibility(View.VISIBLE);
                wirer = 1;
                mainActivity.findViewById(R.id.circuitr).setVisibility(View.VISIBLE);
                wireb = 0;
                mainActivity.findViewById(R.id.circuitb).setVisibility(View.INVISIBLE);
            }
        });

        ImageButton circuitbtn4 = mainActivity.findViewById(R.id.circuitbtn4);
        circuitbtn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                wireb = 1;
                mainActivity.findViewById(R.id.circuitb).setVisibility(View.VISIBLE);
                wirer = 0;
                mainActivity.findViewById(R.id.circuitr).setVisibility(View.INVISIBLE);

                wirep = 1;
                mainActivity.findViewById(R.id.circuitp).setVisibility(View.VISIBLE);
            }
        });

        //used to check if all wires are turned on
        ImageButton checkbtn = mainActivity.findViewById(R.id.checkbtn);
        checkbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(wireb == 1 && wirer == 1 &&wiret == 1 &&wireg == 1&&wirep == 1)
                {
                    checkpoints[3] = true;
                    mainActivity.findViewById(R.id.greenbar).setVisibility(View.VISIBLE);
                    mainActivity.findViewById(R.id.redbar).setVisibility(View.INVISIBLE);
                }
                else{
                    checkpoints[3] = false;
                    mainActivity.findViewById(R.id.greenbar).setVisibility(View.INVISIBLE);
                    mainActivity.findViewById(R.id.redbar).setVisibility(View.VISIBLE);

                }
            }
        });


        final Button boxitemback = mainActivity.findViewById(R.id.boxitemback);
        boxitemback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(checkpoints[2] ==false)
                    left();

                else
                    leftfixed();
            }
        });
    }

    void endscreen(){
        btn_invoList = super.setView(mainActivity, R.layout.room5endscreen, 0);
        // finding other things needed for the room
        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                menu.openMenu(mainActivity, timer);
                timer.startTime();
            }
        });
    }

}
