import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.IOException;
import java.io.FileNotFoundException;

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

            // reading from the file line by line
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
                    while (data.contains(","))
                    {
                        inventory.add(data.substring(1, data.indexOf(",")));
                        data = data.substring(data.indexOf(","));
                    }
                }
                line++;
            }
            s.close();

            Player user = new Player(name, inventory);
            System.out.println(user.greet());

            System.out.println("Welcome to the Crescent Glow Oasis. You can fish and sell your items in the shop.");
            System.out.println("[1] Go fishing\n[2] Enter the shop\n[3] Check inventory and sum\n[4] Leave");
            System.out.print("Choice: ");

            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();

            while (!(choice.equals("4")))
            {
                if (choice.equals("1"))
                {
                    System.out.print("Welcome to the oasis, press [enter] to leave and [f] to cast your rod: ");
                    choice = input.nextLine();

                    Fish oasis = new Fish();
                    while (choice.equals("f"))
                    {
                        oasis.fish();
                        choice = input.nextLine();
                    }

                    System.out.println("Leaving the oasis . . .");
                }
            }

            user.save();
            System.out.println("Data saved. See you later!");
        }
        // if the file doesn't exist, we will create a blank Player object and ask them for a name and hobby
        catch (FileNotFoundException e) {
            Player user = new Player();
            System.out.println(user.greet());
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
