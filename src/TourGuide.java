import java.util.Scanner;

public class TourGuide
{
    // The program logic that accepts the user's inputs to execute certain methods
    public void runWindow(LocalVisitor user)
    {
        // Welcomes the user
        System.out.print(user.welcome());

        // Prompts the user for a choice
        System.out.println("\nWelcome to the Crescent Glow Oasis. You can fish and sell or buy items in the shop.");
        System.out.println("[1] Go fishing\n[2] Enter the shop\n[3] Check inventory and sum\n[4] Resort to capitalism\n[5] Leave");
        System.out.print("Choice: ");

        // Prompts user input
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        // Choice [5] Leave
        while (!(choice.equals("5")))
        {
            // Choice [1] Go fishing
            if (choice.equals("1"))
            {
                // Creates the FishPond object
                FishPond oasis = new FishPond(user);
                oasis.fish();
            }
            // Choice [2] Enter the shop
            else if (choice.equals("2"))
            {
                // Creates the ItemShop object
                ItemShop counter = new ItemShop(user);

                // Prompts the user to sell or buy something
                System.out.println("\nThanks for coming to the shop, would you like to sell or buy something?");
                System.out.println("[1] Sell something\n[2] Buy something");
                System.out.print("Choice: ");

                // Prompts user input
                choice = input.nextLine();

                // Choice [1] Sell something
                if (choice.equals("1"))
                {
                    // Prompts the user to sell an item or all items in their inventory
                    System.out.println("\n[1] Sell an item\n[2] Sell all items");
                    System.out.print("Choice: ");

                    // Prompts user input
                    choice = input.nextLine();

                    // Choice [1] Sell an item
                    if (choice.equals("1"))
                    {
                        counter.sellItem();
                    }
                    // Choice [2] Sell all items
                    else if (choice.equals("2"))
                    {
                        counter.sellItemAll();
                        choice = "1";
                    }
                    else
                    {
                        System.out.println("\n[" + choice + "] is not an option");
                    }
                }
                // Choice [2] Buy something
                else if (choice.equals("2"))
                {
                    // Prompts the user to buy an item or buy multiple instance of the same item using their entire sum
                    System.out.println("\n[1] Buy an item\n[2] Buy an item in bulk");
                    System.out.print("Choice: ");

                    //Prompts user input
                    choice = input.nextLine();

                    // Choice [1] Buy an item
                    if (choice.equals("1"))
                    {
                        counter.buyItem();
                    }
                    // Choice [2] Buy an item in bulk
                    else if (choice.equals("2"))
                    {
                        counter.buyItemAll();
                    }
                    else
                    {
                        System.out.println("\n[" + choice + "] is not an option");
                    }
                }
                else
                {
                    System.out.println("\n[" + choice + "] is not an option");
                }
            }
            // Choice [3] Check inventory and sum
            else if (choice.equals("3"))
            {
                System.out.println(user);
            }
            // Choice [4] Resort to capitalism
            else if (choice.equals("4"))
            {
                McDonalads job = new McDonalads();
                job.work(user);
            }
            else
            {
                System.out.println("\n[" + choice + "] is not an option");
            }

            // Prompts the user for a choice
            System.out.println("\nYou can fish and sell or buy items in the shop.");
            System.out.println("[1] Go fishing\n[2] Enter the shop\n[3] Check inventory and sum\n[4] Resort to capitalism\n[5] Leave");
            System.out.print("Choice: ");

            // Prompts user input
            choice = input.nextLine();
        }

        // Saves the user's data
        user.save();
        System.out.println("\nData saved. See you later!");
    }
}