import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
            int sum = 10;

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
                    inventory = new ArrayList<String>();
                }
                if (line == 3)
                {
                    sum = Integer.parseInt(data);
                }
                line++;
            }
            s.close();

            Player user = new Player(name, inventory, sum);
            System.out.println(user.greet());

            System.out.println("\nWelcome to the Crescent Glow Oasis. You can fish and sell or buy items in the shop.");
            System.out.println("[1] Go fishing\n[2] Enter the shop\n[3] Check inventory and sum\n[4] Leave");
            System.out.print("Choice: ");

            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();

            while (!(choice.equals("4")))
            {
                // Choice [1] Go fishing
                if (choice.equals("1"))
                {
                    System.out.print("\nWelcome to the oasis, press [enter] to leave and [c] to cast your rod: ");
                    choice = input.nextLine();

                    Fish oasis = new Fish(user);
                    while (choice.equals("c"))
                    {
                        oasis.fish();
                        System.out.print("Cast?: ");
                        choice = input.nextLine();
                    }

                    System.out.println("\nLeaving the oasis . . .");
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
                        System.out.println("\nInventory: " + user.getInventory());
                        System.out.print("Enter the name of the item you want to sell: ");

                        choice = input.nextLine();

                        counter.sellItem(choice);
                    }
                    // Choice [2] Buy something
                    if (choice.equals("2"))
                    {
                        System.out.println();
                        for (int i = 0; i < counter.getITEMS().size(); i++)
                        {
                            System.out.println(counter.getITEMS().get(i) + ": $" + counter.getPRICES().get(i));
                        }

                        System.out.println("\nSum: " + user.getSum());
                        System.out.print("Enter the name of the item you want to buy: ");
                        choice = input.nextLine();

                        counter.buyItem(choice);
                    }
                }
                // Choice [3] Check inventory and sum
                if (choice.equals("3"))
                {
                    System.out.println("\nInventory: " + user.getInventory());
                    System.out.println("Sum: " + user.getSum());
                }

                System.out.println("\nYou can fish and sell or buy items in the shop.");
                System.out.println("[1] Go fishing\n[2] Enter the shop\n[3] Check inventory and sum\n[4] Leave");
                System.out.print("Choice: ");

                choice = input.nextLine();
            }

            user.save();
            System.out.println("\nData saved. See you later!");
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
