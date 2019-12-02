package framework;

import android.view.View;
import android.widget.Button;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

import rooms.Room;
import rooms.Room1;
import rooms.Room2;
import rooms.Room3;
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
               try {
                   startRooms();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       });

    }

    public void startRooms() throws InterruptedException {
        timer.startTime();

        // start room calls here
        // Parameters for rooms
        // - mainActivity
        // - timer
        // Return void


        // To start working on your room make a room in the rooms folder and call it here.
        // Make sure room class extends room and uses a setView immediately.
        Tutorial tutorial = new Tutorial(mainActivity, timer);
        tutorial.startRoom();

//        Room1 room1 = new Room1(mainActivity, timer);
//        room1.startRoom();
    }

}
