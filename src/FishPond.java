import java.util.Scanner;

public class FishPond extends StorageSpace
{
    private LocalVisitor user;

    // User parameter constructor
    public FishPond(LocalVisitor user)
    {
        this.user = user;
    }

    // Enables fishing for the Player
    public void fish()
    {
        // Welcomes the user and provides a brief explanation of how to fish
        System.out.println("\nWelcome to the oasis, you need [Bait] to fish");
        System.out.println("Number of Bait: " + user.getBaitNum());
        System.out.print("Press [enter] to leave and [c] to cast your rod: ");

        // Prompts user input
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        // If the user contains the item [Bait] in their inventory allow them to fish
        if (user.getInventory().contains("Bait"))
        {
            // If the user enters c and has the item [Bait] add a random fish to their inventory
            while (choice.equals("c") && user.getBaitNum() > 0)
            {
                // Removes the item [Bait] from the inventory
                user.removeInventory("Bait");

                // The user has a 50% chance to reel in a fish
                int index = (int)(Math.random() * super.getFISH().size() * 2);

                // If the index is less than the size of the FISH list, add a random fish to the player's inventory
                if (index < super.getFISH().size())
                {
                    String fish = super.getFISH().get(index);
                    System.out.println("\nYou reeled in a healthy " + fish + "! It has been added to your inventory");
                    user.addInventory(fish);
                }
                // Else print the following statement
                else
                {
                    System.out.println("\nYou reeled in nothing! How unfortunate!");
                }

                // Prints the number of [Bait] remaining
                System.out.println("Number of Bait: " + user.getBaitNum());

                // Prompts the user to fish again
                System.out.print("Cast?: ");
                choice = input.nextLine();
            }
        }
        // If the user's inventory has no [Bait], stop fishing
        if (user.getBaitNum() <= 0)
        {
            System.out.println("\nYou do not possess enough [Bait] to continue fishing. Buy more [Bait] at the shop");
        }
        // Termination statement
        System.out.println("\nLeaving the oasis . . .");
    }
}