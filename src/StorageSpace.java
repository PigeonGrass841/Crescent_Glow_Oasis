import java.util.ArrayList;
import java.util.Arrays;

public class StorageSpace
{
    private final ArrayList<String> FISH = new ArrayList<String>(Arrays.asList("fish", "blob fish", "neon tetra", "immortal jellyfish", "ornate sleeper ray"));
    private final ArrayList<String> ITEMS = new ArrayList<String>(Arrays.asList("fish", "blob fish", "neon tetra", "immortal jellyfish", "ornate sleeper ray", "bait", "rubix cube", "imitation platoon", "subzero metro", "iridescent lichen", "crescent moon amulet"));
    private final ArrayList<Integer> PRICES = new ArrayList<Integer>(Arrays.asList(5, 10, 15, 20, 25, 5, 60, 70, 80, 90, 100));
    private ArrayList<String> inventory = new ArrayList<String>();
    private int sum = 15;

    // Empty parameter constructor
    public StorageSpace()
    {
        this.inventory = new ArrayList<String>();
    }

    // Inventory and sum parameter constructor
    public StorageSpace(ArrayList<String> inventory, int sum)
    {
        this.inventory = inventory;
        this.sum = sum;
    }

    // Returns the FISH list
    public ArrayList<String> getFISH()
    {
        return this.FISH;
    }

    // Returns the ITEMS list
    public ArrayList<String> getITEMS()
    {
        return this.ITEMS;
    }

    // Returns the PRICES list
    public ArrayList<Integer> getPRICES()
    {
        return this.PRICES;
    }

    // Returns the inventory list
    public ArrayList<String> getInventory()
    {
        return this.inventory;
    }

    // Sets the inventory list to the given list
    public void setInventory(ArrayList<String> inventory)
    {
        this.inventory = inventory;
    }

    // Adds an item to the inventory list
    public void addInventory(String item)
    {
        this.inventory.add(item);
    }

    // Removes an item from the inventory list
    public void removeInventory(String item)
    {
        this.inventory.remove(item);
    }

    // Returns the sum
    public int getSum()
    {
        return this.sum;
    }

    // Sets the sum to the given integer
    public void setSum(int sum)
    {
        this.sum = sum;
    }

    // Increments the sum by the given integer
    public void addSum(int sum)
    {
        this.sum += sum;
    }

    // Decrements the sum by the given integer
    public void subtractSum(int sum)
    {
        this.sum -= sum;
    }

    // Returns the number of [Bait] in the player's inventory
    public int getBaitNum()
    {
        int baitNum = 0;
        for (String item : inventory)
        {
            if (item.equals("bait"))
            {
                baitNum++;
            }
        }
        return baitNum;
    }

    // Prints the inventory list and the sum
    public String toString()
    {
        return "\nInventory: " + inventory + "\nSum: " + sum;
    }
}