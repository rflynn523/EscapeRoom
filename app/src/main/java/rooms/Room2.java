package rooms;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

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
        final ImageButton plane = (ImageButton) mainActivity.findViewById(R.id.plane);
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


        // Makes the plane image invisible when clicked on
        plane.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plane.setVisibility((View.INVISIBLE));
            }
        });

    }

    void keypad_screen()
    {
        mainActivity.setContentView(R.layout.keypad_screen);

        Button five = mainActivity.findViewById(R.id.button5);

        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                frontWall();
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
