package rooms;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

import java.util.ArrayList;

import framework.Inventory;
import framework.PauseMenu;
import framework.Timer;

// Room2, written by Ryan Flynn
public class Room2 extends Room
{
    MainActivity mainActivity;
    private Timer timer;

    private ArrayList<ImageButton> room2_invo;

    private int front = R.layout.room2_front;
    private int right = R.layout.room2_right;
    private int left = R.layout.room2_left;
    private int back = R.layout.room2_back;

    private boolean[] checkpoints;

    public Room2(MainActivity ma, Timer timer)
    {
        super.inventory = new Inventory(mainActivity);
        super.menu = new PauseMenu();

        this.mainActivity = ma;
        this.timer = timer;
        this.checkpoints = new boolean[15];
        checkpoints[0] = true;

    }


    public void startRoom2()
    {
        room2_invo = super.setView(mainActivity, front, 0);

        super.printMessage("I should probably find a note from Max", mainActivity);

        frontWall();
    }

    public void frontWall()
    {
        room2_invo.clear();
        room2_invo = super.setView(mainActivity, front, 0);

        ImageButton right_arrow = (ImageButton) mainActivity.findViewById(R.id.btn_right);
        ImageButton left_arrow = (ImageButton) mainActivity.findViewById(R.id.btn_left);
        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);

        ImageButton keypad = (ImageButton) mainActivity.findViewById(R.id.room2_keypad);
        final ImageButton sticky_note = (ImageButton) mainActivity.findViewById(R.id.room2_sticky_note);
        final ImageButton morse_translator = (ImageButton) mainActivity.findViewById(R.id.room2_morse_icon);

        // Checks to see if riddle needs to be hidden
        if(checkpoints[1] == true)
            sticky_note.setVisibility(View.GONE);

        // Hides the morse code translator card if needed
        if(checkpoints[3] == true)
            morse_translator.setVisibility(View.GONE);

        btn_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                menu.openMenu(mainActivity, timer);
            }
        });

        btn_hint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                show_room2_hint(1);
            }
        });

        // Right Arrow button
        right_arrow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                rightWall();
            }
        });

        // Left Arrow button
        left_arrow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                leftWall();
            }
        });

        // Keypad icon
        keypad.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                keypad_screen();
            }
        });

        // Sticky note represents the riddle
        sticky_note.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Room2.super.inventory.addToInventory("room2_sticky_note", room2_invo);
                sticky_note.setVisibility(View.INVISIBLE);
                checkpoints[1] = true;
                riddle_view_front();
            }
        });

        morse_translator.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Room2.super.inventory.addToInventory("room2_morse_icon", room2_invo);
                morse_translator.setVisibility(View.GONE);
                checkpoints[3] = true;

                Room2.super.printMessage("I should probably look at this on the white board", mainActivity);
                morse_translator_view_front();
            }
        });
    }

    public void rightWall()
    {
        room2_invo.clear();
        room2_invo = super.setView(mainActivity, right, 0);

        ImageButton right_arrow = (ImageButton) mainActivity.findViewById(R.id.btn_right);
        ImageButton left_arrow = (ImageButton) mainActivity.findViewById(R.id.btn_left);
        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);

        final ImageButton bulb = (ImageButton) mainActivity.findViewById(R.id.room2_light_bulb);
        final ImageButton tv = (ImageButton) mainActivity.findViewById(R.id.room2_tv_off);
        final ImageButton ch_1 = (ImageButton) mainActivity.findViewById(R.id.room2_channel1);
        final ImageButton ch_2 = (ImageButton) mainActivity.findViewById(R.id.room2_channel2);

        // Bulb already picked up
        if (checkpoints[2])
            bulb.setVisibility(View.GONE);

        // Tv already turned on
        if (checkpoints[11])
            tv.setVisibility(View.GONE);

        btn_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                menu.openMenu(mainActivity, timer);
            }
        });

        btn_hint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                show_room2_hint(2);
            }
        });

        // Right Arrow button
        right_arrow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                backWall();
            }
        });

        // Left Arrow button
        left_arrow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                frontWall();
            }
        });

        bulb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Room2.super.inventory.addToInventory("room2_light_bulb", room2_invo);
                bulb.setVisibility(View.GONE);
                checkpoints[2] = true;
            }
        });

        tv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Checks if the remote had been picked uo
                if (checkpoints[4])
                {
                    tv.setVisibility(View.GONE);
                    checkpoints[11] = true;
                }
            }
        });

        ch_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Makes sure the tv has been turned on before
                if (checkpoints[11])
                    ch_1.setVisibility(View.INVISIBLE);
            }
        });

        ch_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Makes sure the tv has been turned on before
                if (checkpoints[11])
                {
                    ch_1.setVisibility(View.VISIBLE);
                    checkpoints[12] = true;
                }
            }
        });
    }

    public void leftWall()
    {
        room2_invo.clear();
        room2_invo = super.setView(mainActivity, left, 0);

        ImageButton right_arrow = (ImageButton) mainActivity.findViewById(R.id.btn_right);
        ImageButton left_arrow = (ImageButton) mainActivity.findViewById(R.id.btn_left);
        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);

        final ImageButton lamp = (ImageButton) mainActivity.findViewById(R.id.room2_ceiling_lamp);
        final ImageButton morse_code_cir = (ImageButton) mainActivity.findViewById(R.id.room2_morse_circled);
        final ImageButton remote = (ImageButton) mainActivity.findViewById(R.id.room2_remote);
        final ImageButton grass_init = (ImageButton) mainActivity.findViewById(R.id.room2_grass_left_init);
        final ImageButton grass_moved = (ImageButton) mainActivity.findViewById(R.id.room2_grass_left_moved);

        // Light bulb is placed so the circle is always shown.
        if (checkpoints[5])
            morse_code_cir.setVisibility(View.VISIBLE);

        // Remote has been picked up so it should be invisible and the plant has been moved.
        if(checkpoints[4])
        {
            remote.setVisibility(View.GONE);
            grass_init.setVisibility(View.GONE);
            grass_moved.setVisibility(View.VISIBLE);
        }

        // After user sees the translator and places the light bulb they should have the number.
        if (checkpoints[5] && checkpoints[6])
            checkpoints[9] = true;

        btn_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                menu.openMenu(mainActivity, timer);
            }
        });

        btn_hint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                show_room2_hint(4);
            }
        });

        // Right Arrow button
        right_arrow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                frontWall();
            }
        });

        // Left Arrow button
        left_arrow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                backWall();
            }
        });

        remote.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Room2.super.inventory.addToInventory("room2_remote", room2_invo);
                remote.setVisibility(View.GONE);
                checkpoints[4] = true;
            }
        });

        lamp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if ("room2_light_bulb".equals(Room2.super.inventory.selectedItem))
                {
                    morse_code_cir.setVisibility(View.VISIBLE);
                    checkpoints[5] = true;
                    Room2.super.inventory.removeFromInventory("room2_light_bulb", room2_invo);
                }
            }
        });

        grass_init.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                grass_init.setVisibility(View.GONE);
                grass_moved.setVisibility(View.VISIBLE);
                remote.setVisibility(View.VISIBLE);
            }
        });
    }

    public void backWall()
    {
        room2_invo.clear();
        room2_invo = super.setView(mainActivity, back, 0);

        ImageButton right_arrow = (ImageButton) mainActivity.findViewById(R.id.btn_right);
        ImageButton left_arrow = (ImageButton) mainActivity.findViewById(R.id.btn_left);
        ImageButton btn_menu = mainActivity.findViewById(R.id.btn_menu);
        ImageButton btn_hint = mainActivity.findViewById(R.id.btn_hint);

        final ImageButton calendar = (ImageButton) mainActivity.findViewById(R.id.room2_calendar_small);
        final ImageButton white_board = (ImageButton) mainActivity.findViewById(R.id.room2_white_board);
        final ImageButton riddle_wb = (ImageButton) mainActivity.findViewById(R.id.room2_wb_riddle);
        final ImageButton morse_wb = (ImageButton) mainActivity.findViewById(R.id.room2_wb_morse);

        // Morse code translator placed on white board
        if (checkpoints[6])
            morse_wb.setVisibility(View.VISIBLE);

        // Riddle placed on white board.
        if (checkpoints[7])
            riddle_wb.setVisibility(View.VISIBLE);

        btn_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                menu.openMenu(mainActivity, timer);
            }
        });

        btn_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                show_room2_hint(3);
            }
        });

        // Right Arrow button
        right_arrow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                leftWall();
            }
        });

        // Left Arrow button
        left_arrow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                rightWall();
            }
        });

        calendar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                calendar_view();
            }
        });

        white_board.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            if ("room2_morse_icon".equals(Room2.super.inventory.selectedItem))
            {
                Room2.super.inventory.removeFromInventory("room2_morse_icon", room2_invo);
                checkpoints[6] = true;
                morse_wb.setVisibility(View.VISIBLE);
            }


            if ("room2_sticky_note".equals(Room2.super.inventory.selectedItem))
            {
                Room2.super.inventory.removeFromInventory("room2_sticky_note", room2_invo);
                checkpoints[7] = true;
                riddle_wb.setVisibility(View.VISIBLE);
            }
            }
        });

        riddle_wb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                riddle_view_back();
            }
        });

        morse_wb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                morse_translator_view_back();
            }
        });
    }

    public void show_room2_hint(int wall)
    {
       switch(wall)
        {
            // Front wall
            case 1:
                if (!checkpoints[1])
                {
                    timer.addToHintTime(2);
                    super.printMessage("HINT: Find the note from Max", mainActivity);
                }
                else if(!checkpoints[3])
                {
                    timer.addToHintTime(5);
                    super.printMessage("HINT: Is there something behind those picture frames?", mainActivity);
                }
                else if(!checkpoints[13])
                {
                    timer.addToHintTime(5);
                    super.printMessage("HINT: Those are a good set of picture frames", mainActivity);
                }
                else if(!checkpoints[14])
                {
                    timer.addToHintTime(10);
                    super.printMessage("HINT: This wall must be the front wall", mainActivity);
                }
                break;

            // Right wall
            case 2:
                if(!checkpoints[4])
                {
                    timer.addToHintTime(5);
                    super.printMessage("HINT: This tv probably needs a remote", mainActivity);
                }
                else if(!checkpoints[12])
                {
                    timer.addToHintTime(5);
                    super.printMessage("HINT: Hmm only 2 channels", mainActivity);
                }
                else if(!checkpoints[2])
                {
                    timer.addToHintTime(10);
                    super.printMessage("HINT: What's under the tv stand?", mainActivity);
                }
                break;

            // Back wall
            case 3:
                if(!checkpoints[10])
                {
                    timer.addToHintTime(5);
                    super.printMessage("HINT: I wonder when Max was here", mainActivity);
                }
                else if(!checkpoints[14])
                {
                    timer.addToHintTime(15);
                    super.printMessage("HINT: What's another way to right this riddle?", mainActivity);
                }
                break;

            // Left wall
            case 4:
                if(!checkpoints[2])
                {
                    timer.addToHintTime(10);
                    super.printMessage("HINT: Looks like that lamp needs a light bulb", mainActivity);
                }
                else if(!checkpoints[5])
                {
                    timer.addToHintTime(5);
                    super.printMessage("HINT: This bulb must go somewhere", mainActivity);
                }
                break;
        }
    }

    // An easier way for the user to see the riddle
    // Front returns to the front wall and back returns to the back wall.
    public void riddle_view_front()
    {
        super.setView(mainActivity, R.layout.room2_riddle);
        ImageButton riddle_back = (ImageButton) mainActivity.findViewById(R.id.room2_riddle_background);
        riddle_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frontWall();
            }
        });
    }

    public void riddle_view_back()
    {
        super.setView(mainActivity, R.layout.room2_riddle);
        ImageButton riddle_back = (ImageButton) mainActivity.findViewById(R.id.room2_riddle_background);
        riddle_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backWall();
            }
        });
    }

    // An easier way for the user to see the morse code translator
    // Front returns to the front wall and back returns to the back wall.
    public void morse_translator_view_front()
    {
        super.setView(mainActivity, R.layout.room2_morse_translator_view);
        ImageButton morse_back = (ImageButton) mainActivity.findViewById(R.id.room2_morse_translator_background);
        morse_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frontWall();
            }
        });
    }

    public void morse_translator_view_back()
    {
        super.setView(mainActivity, R.layout.room2_morse_translator_view);
        ImageButton morse_back = (ImageButton) mainActivity.findViewById(R.id.room2_morse_translator_background);
        morse_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backWall();
            }
        });
    }

    // Displays the calendar full screen XML
    public void calendar_view()
    {
        super.setView(mainActivity, R.layout.room2_calendar_view);

        checkpoints[10] = true;

        ImageButton calendar_back = (ImageButton) mainActivity.findViewById(R.id.room2_calendar_background);
        calendar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backWall();
            }
        });
    }

    // Keypad XML that allows the user to enter in the code.
    public void keypad_screen()
    {
        super.setView(mainActivity, R.layout.room2_keypad_screen);

        checkpoints[13] = true;

        Button zero = mainActivity.findViewById((R.id.button0));
        Button one = mainActivity.findViewById((R.id.button1));
        Button two = mainActivity.findViewById((R.id.button2));
        Button three = mainActivity.findViewById((R.id.button3));
        Button four = mainActivity.findViewById((R.id.button4));
        Button five = mainActivity.findViewById((R.id.button5));
        Button six = mainActivity.findViewById((R.id.button6));
        Button seven = mainActivity.findViewById((R.id.button7));
        Button eight = mainActivity.findViewById((R.id.button8));
        Button nine = mainActivity.findViewById(R.id.button9);

        Button clear = mainActivity.findViewById((R.id.clear));
        Button enter = mainActivity.findViewById((R.id.enter));

        final TextView keypad_screen = (TextView) mainActivity.findViewById(R.id.room2_keypad_output);


        ImageButton keypad_back = (ImageButton) mainActivity.findViewById(R.id.room2_keypad_background);
        keypad_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frontWall();
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keypad_screen.append("0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keypad_screen.append("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keypad_screen.append("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keypad_screen.append("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keypad_screen.append("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                keypad_screen.append("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keypad_screen.append("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keypad_screen.append("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keypad_screen.append("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keypad_screen.append("9");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            //            @Override
            public void onClick(View v) {
                keypad_screen.setText("");
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = keypad_screen.getText().toString();

                if (content.equals("2378"))
                {
                    keypad_screen.setText("ACCESS GRANTED");
                    checkpoints[14] = true;
                    // START END SEQUENCE
                    end_sequence();

                }
                else
                    keypad_screen.setText("DENIED");
            }
        });
    }

    // Handles the sequence for when the user passes level.
    private void end_sequence()
    {
        room2_invo.clear();

        super.setView(mainActivity, front, 0);

        ImageButton sticky_note = (ImageButton) mainActivity.findViewById(R.id.room2_sticky_note);
        ImageButton morse_translator = (ImageButton) mainActivity.findViewById(R.id.room2_morse_icon);

        sticky_note.setVisibility(View.INVISIBLE);
        morse_translator.setVisibility(View.INVISIBLE);

        ImageButton portal_on = (ImageButton) mainActivity.findViewById(R.id.room2_portal_on);
        ImageView portal_off = (ImageView) mainActivity.findViewById(R.id.room2_portal_off);

        // Correct code was entered
        if (checkpoints[14])
        {
            portal_on.setVisibility(View.VISIBLE);
            portal_off.setVisibility((View.INVISIBLE));
        }

        super.printMessage("Yes I got it!", mainActivity);
        portal_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // Call the next room OR have the uer click on the portal
               Room3 room3 = new Room3(mainActivity, timer);
               room3.startRoom3();
            }
        });

    }
}
