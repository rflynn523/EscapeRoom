package framework;

import android.widget.TextView;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

import org.w3c.dom.Text;

public abstract class TextHelp
{
    int hintCheckPoint;

    public void sendMessage(MainActivity mainActivity, String text, int checkPoint)
    {
        TextView text_message = (TextView) mainActivity.findViewById(R.id.text_message);
        text_message.setText(text);
        text_message.setVisibility(TextView.VISIBLE);

    }

    public void useHint(MainActivity mainActivity, String text, int checkPoint)
    {

    }
}
