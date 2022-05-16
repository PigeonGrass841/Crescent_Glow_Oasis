import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import java.util.ArrayList;
import java.util.Arrays;

public class Storage
{
    private final ArrayList<String> FISH = new ArrayList<String>(Arrays.asList("Fish"));
    private final ArrayList<String> ITEMS = new ArrayList<String>(Arrays.asList("Fish"));
    private final ArrayList<Integer> PRICES = new ArrayList<Integer>(Arrays.asList(10));

    private ArrayList<String> inventory = new ArrayList<String>();
    private int sum;

    public Storage()
    {
        this.inventory = new ArrayList<String>();
        this.sum = 10;
    }

    public Storage(ArrayList<String> inventory)
    {
        this.inventory = inventory;
        this.sum = 10;
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

    public int getSum()
    {
        return this.sum;
    }

    // This method is an example of how to take some information and write it into a file!
    public void save() {
        try {
            File f = new File("src/Storage.data");
            f.createNewFile(); // this method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/Storage.data");
            fw.write(inventory + "\n");
            fw.write(sum);
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}
