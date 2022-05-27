import java.util.Locale;
import java.util.Scanner;

public class ItemShop extends StorageSpace
{
    private final LocalVisitor user;

    // User parameter constructor
    public ItemShop(LocalVisitor user)
    {
        super();
        this.user = user;
    }

    // Removes the item from the inventory and increments the sum by its corresponding price
    public void sellItem()
    {
        // Prints the player's inventory and prompts the user to enter the name of the item to sell
        System.out.println("\nInventory: " + user.getInventory());
        System.out.print("Enter the name of the item you want to sell: ");

        // Prompts user input
        Scanner input = new Scanner(System.in);
        String item = input.nextLine().toLowerCase();

        // Retrieves index of item in the player's inventory and the ITEMS list respectively
        int index = user.getInventory().indexOf(item);
        int items = super.getITEMS().indexOf(item);

        // If the player's inventory contains the item, remove the item and add the corresponding sum
        if (index != -1 && items != -1)
        {
            user.removeInventory(item);
            user.addSum(super.getPRICES().get(items));
            System.out.println("Thanks for selling the " + item);
        }
        // Else if the item exists in the ITEMS list but not in the inventory, print the following statement
        else if (items != -1)
        {
            System.out.println("That item does not exist in your inventory");
        }
        // Else the item does not exist in the ITEMS list and inventory, print the following statement
        else
        {
            System.out.println("We cannot accept that");
        }
    }

    // Removes each item from the inventory and increments the sum by their respective prices
    public void sellItemAll()
    {
        System.out.println();
        // Sell each item in the inventory
        for (int i = user.getInventory().size() - 1; i >= 0; i--)
        {
            // Retrieves the item
            String item = user.getInventory().get(i).toLowerCase();

            // Retrieves index of item in the player's inventory and the ITEMS list respectively
            int index = user.getInventory().indexOf(item);
            int items = super.getITEMS().indexOf(item);

            // If the player's inventory contains the item, remove the item and the corresponding sum
            if (index != -1)
            {
                user.removeInventory(item);
                user.addSum(super.getPRICES().get(items));
                System.out.println("Thanks for selling the " + item);
            }
            // If the item does not exist in the ITEMS list and inventory, print the following statement
            if (items == -1)
            {
                System.out.println("We cannot accept that");
            }
        }
    }

    // Adds the item to the inventory and decrements the sum by its corresponding price
    public void buyItem()
    {
        System.out.println();
        // Prints each item in the ITEMS list and its corresponding price in the PRICES list
        for (int i = getFISH().size(); i < getITEMS().size(); i++)
        {
            System.out.println(getITEMS().get(i) + ": $" + getPRICES().get(i));
        }

        // Prints the player's sum and prompts the player to enter the name of the item to buy
        System.out.println("\nSum: " + user.getSum());
        System.out.print("Enter the name of the item you want to buy: ");

        // Prompts user input
        Scanner input = new Scanner(System.in);
        String item = input.nextLine().toLowerCase();

        // Retrieves index of item in the ITEMS list
        int items = super.getITEMS().indexOf(item);

        // If the item exists in the ITEMS list and the player's sum is more than or equal to the corresponding price in
        // the PRICES list, add the item and subtract the corresponding sum
        if ((items != -1) && (user.getSum() >= super.getPRICES().get(items)))
        {
            user.addInventory(item);
            user.subtractSum(super.getPRICES().get(items));
            System.out.println("Thanks for buying the " + item);
        }
        // Else if the item does not exist in the ITEMS list, print the following statement
        else if (items == -1)
        {
            System.out.println("That item does not exist in our inventory");
        }
        // Else the player's sum is less than the corresponding price in the PRICES list, print the following statement
        else
        {
            System.out.println("There is not enough sum");
        }
    }

    //// Adds the item to the inventory and decrements the sum by their respective prices until the price exceeds the sum
    public void buyItemAll()
    {
        System.out.println();
        // Prints each item in the ITEMS list and its corresponding price in the PRICES list
        for (int i = getFISH().size(); i < getITEMS().size(); i++)
        {
            System.out.println(getITEMS().get(i) + ": $" + getPRICES().get(i));
        }

        // Prints the player's sum and prompts the player to enter the name of the item to buy
        System.out.println("\nSum: " + user.getSum());
        System.out.print("Enter the name of the item you want to buy in bulk: ");

        // Prompts user input
        Scanner input = new Scanner(System.in);
        String item = input.nextLine().toLowerCase();

        // Retrieves index of item in the ITEMS list
        int items = super.getITEMS().indexOf(item);

        // If the item exists in the ITEMS list and the player's sum is more than or equal to the corresponding price in
        // the PRICES list, add the item and subtract the corresponding sum
        if ((items != -1) && (user.getSum() >= super.getPRICES().get(items)))
        {
            // While the player's sum is more than or equal to the corresponding price in the PRICES list, add the item
            // and subtract the corresponding sum
            while (user.getSum() >= super.getPRICES().get(items))
            {
                user.addInventory(item);
                user.subtractSum(super.getPRICES().get(items));
            }
            System.out.println("Thanks for buying the " + item);
        }
        // Else if the item does not exist in the ITEMS list, print the following statement
        else if (items == -1)
        {
            System.out.println("That item does not exist in our inventory");
        }
        // Else the player's sum is less than the corresponding price in the PRICES list, print the following statement
        else
        {
            System.out.println("There is not enough sum");
        }
    }
}