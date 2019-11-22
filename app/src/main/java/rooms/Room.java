package rooms;

import android.view.View;

import com.example.escaperoom.MainActivity;

public abstract class Room {
    private String name;

    public void setView(MainActivity ma, int view)
    {
        ma.setContentView(view);
    }
}
