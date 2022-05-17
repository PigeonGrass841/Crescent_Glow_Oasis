public class Shop extends Storage
{
    public void sellItem(String item)
    {
        int index = super.getInventory().indexOf(item);
        int items = super.getITEMS().indexOf(item);

        if (index != -1)
        {
            System.out.println("Thanks for selling a " + item);
            super.removeInventory(item);
            super.addSum(super.getPRICES().get(items));
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

    public void buyItem(String item)
    {
        int items = super.getITEMS().indexOf(item);

        if ((items != -1) && (super.getSum() >= super.getPRICES().get(items)))
        {
            System.out.println("Thanks for buying a " + item);
            super.addInventory(item);
            super.subtractSum(super.getPRICES().get(items));
        }
        else
        {
            if (items != -1)
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
