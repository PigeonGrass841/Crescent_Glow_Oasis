import java.util.ArrayList;
import java.util.Arrays;

public class StorageSpace
{
    private final ArrayList<String> FISH = new ArrayList<String>(Arrays.asList("Fish", "Blob Fish", "Neon Tetra", "Immortal Jellyfish", "Ornate Sleeper Ray"));
    private final ArrayList<String> ITEMS = new ArrayList<String>(Arrays.asList("Fish", "Blob Fish", "Neon Tetra", "Immortal Jellyfish", "Ornate Sleeper Ray", "Bait", "Rubix Cube", "Imitation Platoon", "Subzero Metro", "Iridescent Lichen", "Crescent Moon Amulet"));
    private final ArrayList<Integer> PRICES = new ArrayList<Integer>(Arrays.asList(5, 10, 15, 20, 25, 5, 60, 70, 80, 90, 100));
    private ArrayList<String> inventory = new ArrayList<String>();
    private int sum = 15;

    public StorageSpace()
    {
        this.inventory = new ArrayList<String>();
    }

    public StorageSpace(ArrayList<String> inventory, int sum)
    {
        this.inventory = inventory;
        this.sum = sum;
    }

    public ArrayList<String> getFISH()
    {
        return this.FISH;
    }

    public ArrayList<String> getITEMS()
    {
        return this.ITEMS;
    }

    public ArrayList<Integer> getPRICES()
    {
        return this.PRICES;
    }

    public ArrayList<String> getInventory()
    {
        return this.inventory;
    }

    public void setInventory(ArrayList<String> inventory)
    {
        this.inventory = inventory;
    }

    public void addInventory(String item)
    {
        this.inventory.add(item);
    }

    public void removeInventory(String item)
    {
        this.inventory.remove(item);
    }

    public int getSum()
    {
        return this.sum;
    }

    public void setSum(int sum)
    {
        this.sum = sum;
    }

    public void addSum(int sum)
    {
        this.sum += sum;
    }

    public void subtractSum(int sum)
    {
        this.sum -= sum;
    }

    public int getBaitNum()
    {
        int baitNum = 0;
        for (String item : inventory)
        {
            if (item.equals("Bait"))
            {
                baitNum++;
            }
        }
        return baitNum;
    }

    public String toString()
    {
        return "\nInventory: " + inventory + "\nSum: " + sum;
    }
}