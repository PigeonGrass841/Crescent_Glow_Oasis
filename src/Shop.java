import java.util.ArrayList;

public class Shop extends Storage
{
    private Player user;

    public Shop(Player user)
    {
        super();
        this.user = user;
    }

    public void sellItem(String item)
    {
        int index = user.getInventory().indexOf(item);
        int items = super.getITEMS().indexOf(item);

        if (index != -1)
        {
            user.removeInventory(item);
            user.addSum(super.getPRICES().get(items));
            System.out.println("Thanks for selling a " + item);
        }
        else
        {
            if (items != -1)
            {
                System.out.println("There is no " + item + " in your inventory");
            }
            else
            {
                System.out.println("We cannot accept that");
            }
        }
    }

    public void sellItemAll()
    {
        for (int i = user.getInventory().size() - 1; i >= 0; i--)
        {
            sellItem(user.getInventory().get(i));
        }
    }

    public void buyItem(String item)
    {
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
                System.out.println("There is no " + item + " in our inventory");
            }
            else
            {
                System.out.println("There is not enough sum");
            }
        }
    }
}