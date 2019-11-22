package framework;

import android.view.View;
import android.widget.Button;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

import rooms.Room2;
import rooms.Tutorial;

public class MainBoi
{
    Timer timer;
    Button play_btn;
    MainActivity mainActivity;
    Room2 room2;

    public MainBoi(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
        this.timer = new Timer();
        this.play_btn = (Button) mainActivity.findViewById(R.id.play_btn);

        startGame();
    }

    public void startGame()
    {
        // Play button calls the first room
       play_btn.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               startRooms();
           }
       });

    }

    public void startRooms()
    {
        timer.startTime();

        // start room calls here
        // Parameters for rooms
        // - mainActivity
        // - timer
        // Return void


        // To start working on your room make a room in the rooms folder and call it here.
        // Make sure room class extends room and uses setView immediately.
        Tutorial tut = new Tutorial(mainActivity, timer);
        tut.StartRoom();
//        mainActivity.setContentView(R.layout.activity_main);
    }

}
