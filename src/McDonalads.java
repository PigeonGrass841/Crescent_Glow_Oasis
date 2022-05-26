public class McDonalads extends StorageSpace {
    private boolean dropBurger;

    // Enables work for the Player
    public void work(LocalVisitor user)
    {
        // If the boolean dropBurger is false, the Player has a chance to earn one sum
        if (!dropBurger)
        {
            int dropChance = (int)(Math.random() * 20);

            // If the drop chance is more than one, the Player's sum increments by one
            if (dropChance > 1)
            {
                System.out.println("\nYou found a job at McDonalads and earned 1 sum");
                user.addSum(1);
            }
            // Else set the boolean dropBurger to true
            else
            {
                System.out.println("\nYou dropped a burger and got fired from McDonalads :(");
                dropBurger = true;
            }
        }
        // Else the boolean dropBurger is true, the Player has no chance to earn one sum.
        else
        {
            System.out.println("\nMcDonalads refuses to hire you. You dropped a burger after all :(");
        }
    }
}
