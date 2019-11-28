package framework;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.Menu;
import com.example.escaperoom.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PauseMenu
{
    public ArrayList<String> messages;
    public ArrayList<TextView> textViews;
    public int menuView;
    public int currentView;
    int hintsUsed;

    public PauseMenu()
    {
        this.menuView = R.layout.pause_menu;
        this.messages = new ArrayList<>();
        this.textViews = new ArrayList<>();
        this.hintsUsed = 0;
    }

    // creates a new window to show a menu
    // pulls from stored messages and timer
    // the reset of the logic happens in menuClass

    // make sure you call startTime after you call this
    // function
    public void openMenu(MainActivity mainActivity, Timer timer)
    {
        // pause timer
        timer.pauseTime();

        // create new intent
        Intent intent = new Intent(mainActivity, Menu.class);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("messages", messages);
        bundle.putLong("overall", timer.getTime());
        bundle.putLong("hintTime", timer.getHintTime());
        bundle.putLong("score", timer.getScoredTime());
        intent.putExtras(bundle);
        mainActivity.launchMenu(intent);

    }
}
