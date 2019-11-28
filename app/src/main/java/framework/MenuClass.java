package framework;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.escaperoom.Menu;
import com.example.escaperoom.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MenuClass
{
    private Menu menu;

    public MenuClass(Menu menu)
    {
        this.menu = menu;
    }

    public void startMenu(Bundle bundle)
    {
        // bundled info
        ArrayList<String> messages = bundle.getStringArrayList("messages");
        long overall = bundle.getLong("overall");
        long hintTime = bundle.getLong("hintTime");
        long score = bundle.getLong("score");

        // menu comps
        TextView text_messages;
        TextView text_time;
        TextView text_hints;
        TextView text_overall;
        ImageButton btn_resume;

        // get all the comps
        text_hints = menu.findViewById(R.id.text_hints);
        text_overall = menu.findViewById(R.id.text_overall);
        text_time = menu.findViewById(R.id.text_time);
        text_messages = menu.findViewById(R.id.text_messages);
        btn_resume = menu.findViewById(R.id.btn_resume);
        btn_resume.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // go back to were we were
                // before the menu
                menu.finish();
            }
        });

        // fill our textView with messages
        String temp = "";
        text_messages.setText(temp);
        for (String s : messages)
        {
            text_messages.append(s);
            text_messages.append("\n");
            text_messages.append("\n");
        }

        // gives textView a scroll function
        text_messages.setMovementMethod(new ScrollingMovementMethod());

        // show all the times
        temp = "Current Time:   " + overall + " sec";
        text_time.setText(temp);

        temp = "Hint Penalties: " + hintTime + " sec";
        text_hints.setText(temp);

        temp = "Over All Score: " + score + " sec";
        text_overall.setText(temp);
    }
}
