public class McDonalads extends StorageSpace {
    private boolean dropBurger;

    public void work()
    {
        if (!dropBurger)
        {
            int dropChance = (int)(Math.random() * 100);

            if (dropChance > 1)
            {
                System.out.println("\nYou found a job at McDonalads and earned 1 sum");
                addSum(1);
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
}
