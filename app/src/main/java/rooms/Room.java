package rooms;

import android.view.View;
import android.widget.ImageButton;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

import java.util.ArrayList;

import framework.Inventory;

public abstract class Room {
    private String name;
    public Inventory inventory;

    // if you dont want to use build in inventory class
    // pass mainActivity and desired view
    public void setView(MainActivity mainActivity, int view)
    {
        mainActivity.setContentView(view);
    }

    // uses built in Inventory class
    // pass mainActivity and desired view with any random value for int
    // returns new references to inventory buttons in new view
    public ArrayList<ImageButton> setView(MainActivity mainActivity, int view, int num)
    {
        mainActivity.setContentView(view);
        return setUpInvoButtons(mainActivity);
    }

    // used to make a new set of inventory buttons when you switch views
    // this should only be called in this class, but I left open in case anyone
    // wants to use it for any reason
    public ArrayList<ImageButton> setUpInvoButtons(MainActivity mainActivity)
    {
        ArrayList<ImageButton> list = new ArrayList();
        ImageButton btn = mainActivity.findViewById(R.id.btn_invo1);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                inventory.inventoryClicked(0);
            }
        });
        list.add(btn);
        btn = mainActivity.findViewById(R.id.btn_invo2);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                inventory.inventoryClicked(1);
            }
        });

        list.add(btn);
        btn = mainActivity.findViewById(R.id.btn_invo3);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                inventory.inventoryClicked(2);
            }
        });
        list.add(btn);
        btn = mainActivity.findViewById(R.id.btn_invo4);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                inventory.inventoryClicked(3);
            }
        });
        list.add(btn);
        btn = mainActivity.findViewById(R.id.btn_invo5);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                inventory.inventoryClicked(4);
            }
        });
        list.add(btn);

        return inventory.updateInventoryUI(list);
    }
}
