import java.util.ArrayList;
import java.util.Scanner;

public class Shop extends Storage
{
    private Player user;

    public Shop(Player user)
    {
        super();
        this.user = user;
    }

    // Removes the item from the inventory and increments the sum by its corresponding price
    public void sellItem()
    {
        System.out.println("\nInventory: " + user.getInventory());
        System.out.print("Enter the name of the item you want to sell: ");

        Scanner input = new Scanner(System.in);
        String item = input.nextLine();

        int index = user.getInventory().indexOf(item);
        int items = super.getITEMS().indexOf(item);

        if (index != -1)
        {
            user.removeInventory(item);
            user.addSum(super.getPRICES().get(items));
            System.out.println("Thanks for selling the " + item);
        }
        else
        {
            if (items != -1)
            {
                System.out.println("That item does not exist in your inventory");
            }
            else
            {
                System.out.println("We cannot accept that");
            }
        }
    }

    // Removes each item from the inventory and increments the sum by their respective prices
    public void sellItemAll()
    {
        String item;

        System.out.println();
        for (int i = user.getInventory().size() - 1; i >= 0; i--)
        {
            item = user.getInventory().get(i);

            int index = user.getInventory().indexOf(item);
            int items = super.getITEMS().indexOf(item);

            if (index != -1)
            {
                user.removeInventory(item);
                user.addSum(super.getPRICES().get(items));
                System.out.println("Thanks for selling the " + item);
            }
            else
            {
                if (items != -1)
                {
                    System.out.println("That item does not exist in your inventory");
                }
                else
                {
                    System.out.println("We cannot accept that");
                }
            }
        }
    }

    // Adds the item to the inventory and decrements the sum by its corresponding price
    public void buyItem()
    {
        System.out.println();
        for (int i = 0; i < getITEMS().size(); i++)
        {
            System.out.println(getITEMS().get(i) + ": $" + getPRICES().get(i));
        }

        System.out.println("\nSum: " + user.getSum());
        System.out.print("Enter the name of the item you want to buy: ");

        Scanner input = new Scanner(System.in);
        String item = input.nextLine();

        int items = super.getITEMS().indexOf(item);

        if ((items != -1) && (user.getSum() >= super.getPRICES().get(items)))
        {
            System.out.println("Thanks for buying the " + item);
            user.addInventory(item);
            user.subtractSum(super.getPRICES().get(items));
        }
        else
        {
            if (items == -1)
            {
                System.out.println("That item does not exist in our inventory");
            }
            else
            {
                System.out.println("There is not enough sum");
            }
        }
    }

    //// Adds the item to the inventory and decrements the sum by their respective prices until the price exceeds the sum
    public void buyItemAll()
    {
        System.out.println();
        for (int i = 0; i < getITEMS().size(); i++)
        {
            System.out.println(getITEMS().get(i) + ": $" + getPRICES().get(i));
        }

        System.out.println("\nSum: " + user.getSum());
        System.out.print("Enter the name of the item you want to buy in bulk: ");

        Scanner input = new Scanner(System.in);
        String item = input.nextLine();

        int items = super.getITEMS().indexOf(item);

        if ((items != -1) && (user.getSum() >= super.getPRICES().get(items)))
        {
            int count = 0;
            while (user.getSum() >= super.getPRICES().get(items))
            {
                user.addInventory(item);
                user.subtractSum(super.getPRICES().get(items));
                count++;
            }

            if (count > 1)
            {
                System.out.println("Thanks for buying " + count + " " + item + "s");
            }
            else
            {
                System.out.println("Thanks for buying " + count + " " + item);
            }
        }
        else
        {
            if (items == -1)
            {
                System.out.println("That item does not exist in our inventory");
            }
            else
            {
                System.out.println("There is not enough sum");
            }
        }
    }
}