package framework;

import android.view.View;
import android.widget.Chronometer;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

// Need to decide when to call timer, for now don't deal with it.
public class Timer
{
    private long startTime;
    private long overAllTime;
    private long hintTime;

    public Timer()
    {
        this.hintTime = 0;
        this.overAllTime = 0;
        this.startTime = 0;
    }

    // call to start the time
    // this should only be called at start play
    // and in menu
    public void startTime()
    {
        startTime = System.currentTimeMillis() / 1000;
    }

    // pauses the timer
    public void pauseTime()
    {
        overAllTime = overAllTime + (System.currentTimeMillis() / 1000) - startTime;
    }

    // add some amount of time to timer due to use of a hint
    public void addToHintTime(long add)
    {
        hintTime += add;
    }

    // get non hint time
    public long getTime()
    {
        return overAllTime;
    }

    // gets time + hint time
    public long getScoredTime()
    {
        return overAllTime + hintTime;
    }

    // gets hint pentalties
    public long getHintTime()
    {
        return hintTime;
    }

}
