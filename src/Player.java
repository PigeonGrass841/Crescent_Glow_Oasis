import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Storage
{
    private String name;

    public Player()
    {
        super();
        this.name = "";
    }

    public Player(String name, ArrayList<String> inventory, int sum)
    {
        super(inventory, sum);
        this.name = name;
    }

    // Returns the name of the Plauer
    public String getName()
    {
        return this.name;
    }

    // Sets the name of the Plauer
    public void setName(String name)
    {
        this.name = name;
    }

    // Returns an appropriate greeting
    public String welcome()
    {
        if (name.equals("") && super.getInventory().equals(new ArrayList<String>())) {
            return "Welcome! Before we allow you to start, we need to identify the vistor: ";
        }
        else {
            return "Name: " + name + "\nInventory: " + super.getInventory();
        }
    }

    // Takes the name, inventory, and sum of the player and write it into a file!
    public void save()
    {
        try {
            File f = new File("src/player.data");
            f.createNewFile(); // This method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/player.data");
            fw.write(name + "\n");
            fw.write(super.getInventory().toString() + "\n");
            fw.write(String.valueOf(super.getSum()));
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}