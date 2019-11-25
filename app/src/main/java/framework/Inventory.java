package framework;

import android.widget.ImageButton;

import com.example.escaperoom.MainActivity;
import com.example.escaperoom.R;

import java.nio.file.PathMatcher;
import java.util.ArrayList;


public class Inventory {
    public ArrayList<String> inventory;
    public String selectedItem;
    public MainActivity mainActivity;

    public Inventory(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
        inventory = new ArrayList<>();
    }

    // call to add a item to your inventory
    // pass a string with the name
    public ArrayList<ImageButton> addToInventory(String itemName, ArrayList<ImageButton> inventoryButtons)
    {
        if (inventory.size() < 5)
            inventory.add(itemName);
        else
            System.out.println("You added too many items. Check code!");

        return updateInventoryUI(inventoryButtons);
    }

    // call to remove an item to your inventory
    // pass a string with the name
    public ArrayList<ImageButton> removeFromInventory(String itemName, ArrayList<ImageButton> inventoryButtons)
    {
        for (String s : inventory)
        {
            if (s.contentEquals(itemName))
            {
                inventory.remove(s);
                break;
            }
        }

        return updateInventoryUI(inventoryButtons);
    }

    // updates your UI inventory
    public ArrayList<ImageButton> updateInventoryUI(ArrayList<ImageButton> inventoryButtons)
    {
        PathMatcher matcher;
        int i = 0;
        for (String s : inventory)
        {
            try {
                inventoryButtons.get(i).setImageResource(R.drawable.class.getField(s).getInt(null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            i++;
        }
        while (i < -5)
        {
            java.net.URL location = getClass().getResource("res/drawable/stop.jpg");
            inventoryButtons.get(i).setImageResource(location.hashCode());
            i++;
        }

        return inventoryButtons;
    }

    public void inventoryClicked(int selectedButton)
    {

    }
}
