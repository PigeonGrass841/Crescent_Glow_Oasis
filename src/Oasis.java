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

            Player user = new Player(name, inventory, sum);
            System.out.println(user.welcome());

            System.out.println("\nWelcome to the Crescent Glow Oasis. You can fish and sell or buy items in the shop.");
            System.out.println("[1] Go fishing\n[2] Enter the shop\n[3] Check inventory and sum\n[4] Resort to capitalism\n[5] Leave");
            System.out.print("Choice: ");

            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();

            while (!(choice.equals("5")))
            {
                // Choice [1] Go fishing
                if (choice.equals("1"))
                {
                    Fish oasis = new Fish(user);
                    oasis.fish();
                }
                // Choice [2] Enter the shop
                if (choice.equals("2"))
                {
                    Shop counter = new Shop(user);

                    System.out.println("\nThanks for coming to the shop, would you like to sell or buy something?");
                    System.out.println("[1] Sell something\n[2] Buy something");
                    System.out.print("Choice: ");

                    choice = input.nextLine();

                    // Choice [1] Sell something
                    if (choice.equals("1"))
                    {
                        System.out.println("\n[1] Sell an item\n[2] Sell all items");
                        System.out.print("Choice: ");

                        choice = input.nextLine();

                        // Choice [1] Sell an item
                        if (choice.equals("1"))
                        {
                            counter.sellItem();
                        }
                        // Choice [2] Sell all items
                        if (choice.equals("2"))
                        {
                            counter.sellItemAll();
                            choice = "1";
                        }
                    }
                    // Choice [2] Buy something
                    if (choice.equals("2"))
                    {
                        System.out.println("\n[1] Buy an item\n[2] Buy an item in bulk");
                        System.out.print("Choice: ");

                        choice = input.nextLine();

                        // Choice [1] Buy an item
                        if (choice.equals("1"))
                        {
                            counter.buyItem();
                        }
                        // Choice [2] Buy an item in bulk
                        if (choice.equals("2"))
                        {
                            counter.buyItemAll();
                        }
                    }
                }
                // Choice [3] Check inventory and sum
                if (choice.equals("3"))
                {
                    System.out.println("\nInventory: " + user.getInventory());
                    System.out.println("Sum: " + user.getSum());
                }
                // Choice [4] Resort to capitalism
                if (choice.equals("4"))
                {
                    System.out.println("\nYou found a job at McDonalads and earned 1 sum");
                    user.addSum(1);
                }

                System.out.println("\nYou can fish and sell or buy items in the shop.");
                System.out.println("[1] Go fishing\n[2] Enter the shop\n[3] Check inventory and sum\n[4] Resort to capitalism\n[5] Leave");
                System.out.print("Choice: ");

                choice = input.nextLine();
            }

            user.save();
            System.out.println("\nData saved. See you later!");
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