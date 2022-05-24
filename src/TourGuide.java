import java.util.Scanner;

public class TourGuide
{
    public void runWindow(LocalVisitor user)
    {
        System.out.print(user.welcome());

        System.out.println("\nWelcome to the Crescent Glow Oasis. You can fish and sell or buy items in the shop.");
        System.out.println("[1] Go fishing\n[2] Enter the shop\n[3] Check inventory and sum\n[4] Resort to capitalism\n[5] Leave");
        System.out.print("Choice: ");

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        boolean dropBurger = false;

        while (!(choice.equals("5")))
        {
            // Choice [1] Go fishing
            if (choice.equals("1"))
            {
                FishPond oasis = new FishPond(user);
                oasis.fish();
            }
            // Choice [2] Enter the shop
            if (choice.equals("2"))
            {
                ItemShop counter = new ItemShop(user);

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
                if (!dropBurger)
                {
                    int dropChance = (int)(Math.random() * 100);
                    if (dropChance > 1)
                    {
                        System.out.println("\nYou found a job at McDonalads and earned 1 sum");
                        user.addSum(1);
                    }
                    else
                    {
                        System.out.println("\nYou dropped a burger and got fired from McDonalads :(");
                        dropBurger = true;
                    }
                }
                else
                {
                    System.out.println("\nMcDonalads refuses to hire you. You dropped a burger after all :(");
                }
            }

            System.out.println("\nYou can fish and sell or buy items in the shop.");
            System.out.println("[1] Go fishing\n[2] Enter the shop\n[3] Check inventory and sum\n[4] Resort to capitalism\n[5] Leave");
            System.out.print("Choice: ");

            choice = input.nextLine();
        }

        user.save();
        System.out.println("\nData saved. See you later!");
    }
}