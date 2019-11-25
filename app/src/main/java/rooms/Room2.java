package rooms;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

import java.lang.String;
import java.util.ArrayList;

import framework.Timer;

public class Room2 extends Room
{
    MainActivity mainActivity;

    ArrayList<R.id> inventory = new ArrayList<>();

    private int front = R.layout.front2;
    private int right = R.layout.right2;
    private int left = R.layout.left2;
    private int back = R.layout.back2;

    private int solved = 0;

    public Room2(MainActivity ma, Timer timer)
    {
        this.mainActivity = ma;

    }


    public void startRoom2()
    {
        mainActivity.setContentView(front);

        frontWall();

    }

    void frontWall()
    {
        super.setView(mainActivity, front);
        //mainActivity.setContentView(front);
        ImageButton right_arrow = (ImageButton) mainActivity.findViewById(R.id.right_arrow);
        ImageButton left_arrow = (ImageButton) mainActivity.findViewById(R.id.left_arrow);
        final ImageButton keypad = (ImageButton) mainActivity.findViewById(R.id.keypad);


        // Right Arrow button
        right_arrow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                rightWall();
            }
        });

        // Left Arrow button
        left_arrow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                leftWall();
            }
        });

        // Keypad button
        keypad.setOnClickListener(new View.OnClickListener() {
//            @Override
            public void onClick(View v) {
                keypad_screen();
            }
        });

    }

    void keypad_screen()
    {
        mainActivity.setContentView(R.layout.keypad_screen);
        final EditText keypad_screen = (EditText)mainActivity.findViewById(R.id.keypad_text);
//        final String content = keypad_screen.getText().toString();

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

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = keypad_screen.getText().toString();
                keypad_screen.setText(content +"0", TextView.BufferType.EDITABLE);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = keypad_screen.getText().toString();
                keypad_screen.setText(content +"1", TextView.BufferType.EDITABLE);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = keypad_screen.getText().toString();
                keypad_screen.setText(content +"2", TextView.BufferType.EDITABLE);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = keypad_screen.getText().toString();
                keypad_screen.setText(content +"3", TextView.BufferType.EDITABLE);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = keypad_screen.getText().toString();
                keypad_screen.setText(content +"4", TextView.BufferType.EDITABLE);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                frontWall();
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = keypad_screen.getText().toString();
                keypad_screen.setText(content +"6", TextView.BufferType.EDITABLE);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = keypad_screen.getText().toString();
                keypad_screen.setText(content +"7", TextView.BufferType.EDITABLE);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = keypad_screen.getText().toString();
                keypad_screen.setText(content +"8", TextView.BufferType.EDITABLE);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = keypad_screen.getText().toString();
                keypad_screen.setText(content +"9", TextView.BufferType.EDITABLE);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                content = keypad_screen.getText().toString();
//                int len = content.length();
                keypad_screen.setText("", TextView.BufferType.EDITABLE);
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = keypad_screen.getText().toString();

                if (content.equals("1130"))
                    keypad_screen.setText("CORRECT", TextView.BufferType.EDITABLE);
                else
                    keypad_screen.setText("WRONG", TextView.BufferType.EDITABLE);
            }
        });
    }


    void rightWall()
    {
        mainActivity.setContentView(right);
        ImageButton right_arrow = (ImageButton) mainActivity.findViewById(R.id.right_arrow);
        ImageButton left_arrow = (ImageButton) mainActivity.findViewById(R.id.left_arrow);

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

    }

    void leftWall()
    {
        mainActivity.setContentView(left);
        ImageButton right_arrow = (ImageButton) mainActivity.findViewById(R.id.right_arrow);
        ImageButton left_arrow = (ImageButton) mainActivity.findViewById(R.id.left_arrow);

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
    }

    void backWall()
    {
        mainActivity.setContentView(back);
        ImageButton right_arrow = (ImageButton) mainActivity.findViewById(R.id.right_arrow);
        ImageButton left_arrow = (ImageButton) mainActivity.findViewById(R.id.left_arrow);

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
    }


}
