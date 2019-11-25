package rooms;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

import framework.Timer;

public class Tutorial extends Room
{
    private MainActivity mainActivity;
    private Timer timer;
    private ImageButton btn_invo1;
    private boolean done;
    public Tutorial(MainActivity mainActivity, Timer timer)
    {
        this.mainActivity = mainActivity;
        this.timer = timer;
    }

    public void StartRoom()
    {

        super.setView(mainActivity, R.layout.tut_room1);
        btn_invo1 = mainActivity.findViewById(R.id.btn_invo1);
        btn_invo1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                switchInvo();
            }
        });

    }

    public void switchInvo()
    {
//        btn_invo1.setImageResource(R.drawable.stop);

        Room2 room2 = new Room2(mainActivity, timer);
        room2.startRoom2();
    }
}
