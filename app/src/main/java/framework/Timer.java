package framework;

import android.view.View;
import android.widget.Chronometer;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

// Need to decide when to call timer, for now don't deal with it.
public class Timer
{
    public long startTime;
    public long endTime;

    public Timer()
    {
    }

    public void startTime()
    {
        startTime = System.nanoTime();
    }

    public long getTime()
    {
        return System.nanoTime() - startTime;
    }
}
