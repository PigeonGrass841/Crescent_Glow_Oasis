import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;

public class Oasis
{
    public static void main(String[] args)
    {
        try {
            File f = new File("src/player.data");
            Scanner s = new Scanner(f);

            String name = "";
            ArrayList<String> inventory = new ArrayList<String>();
            int sum = 15;

            // Reading from the file line by line
            int line = 1;
            while (s.hasNextLine())
            {
                String data = s.nextLine();
                if (line == 1)
                {
                    name = data;
                }
                if (line == 2)
                {
                    if (!(data.equals("[]")))
                    {
                        while (data.contains(","))
                        {
                            inventory.add(data.substring(1, data.indexOf(",")));
                            data = data.substring(data.indexOf(",") + 1);
                        }
                        inventory.add(data.substring(1, data.indexOf("]")));
                    }
                }
                if (line == 3)
                {
                    sum = Integer.parseInt(data);
                }
                line++;
            }
            s.close();

            Window tab = new Window();

            Player user = new Player(name, inventory, sum);
            tab.runWindow(user);
        }
        // if the file doesn't exist, we will create a blank Player object and ask them for a name
        catch (FileNotFoundException e) {
            Player user = new Player();

            System.out.println(user.welcome());
            System.out.print("Name: ");

            Scanner input = new Scanner(System.in);
            String name = input.nextLine();

            ArrayList<String> inventory = new ArrayList<String>();

            user.setName(name);
            user.setInventory(inventory);
            user.save();
        }
    }
}