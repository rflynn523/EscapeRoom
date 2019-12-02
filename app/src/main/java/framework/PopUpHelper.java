package framework;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.escaperoom.PopUpWindow;
import com.example.escaperoom.R;

public class PopUpHelper
{
    private PopUpWindow popUpWindow;

    public PopUpHelper(PopUpWindow popUpWindow)
    {
        this.popUpWindow = popUpWindow;
    }

    public void setUpWindow(Bundle bundle)
    {
        switch (bundle.getInt("view"))
        {
            case 21:
                ImageButton btn_ok = popUpWindow.findViewById(R.id.btn_ok);
                btn_ok.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        popUpWindow.finish();
                    }
                });

            case 22:
                ImageButton btn_ok1 = popUpWindow.findViewById(R.id.btn_ok);
                btn_ok1.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        popUpWindow.finish();
                    }
                });

        }


    }
}
