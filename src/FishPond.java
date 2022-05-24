import java.util.Scanner;

public class FishPond extends StorageSpace
{
    private LocalVisitor user;

    public FishPond(LocalVisitor user)
    {
        this.user = user;
    }

    public void fish()
    {
        // Welcomes the user and provides a brief explanation of how to fish
        System.out.println("\nWelcome to the oasis, you need [Bait] to fish");
        System.out.println("Number of Bait: " + user.getBaitNum());
        System.out.print("Press [enter] to leave and [c] to cast your rod: ");

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        // If the user contains the item [Bait] in their inventory allow them to fish
        if (user.getInventory().contains("Bait"))
        {
            // If the user enters c and has the item [Bait] add a random fish to their inventory
            while (choice.equals("c") && user.getBaitNum() > 0)
            {
                user.removeInventory("Bait");

                int index = (int)(Math.random() * super.getFISH().size() * 2);

                if (index < super.getFISH().size())
                {
                    String fish = super.getFISH().get(index);
                    System.out.println("\nYou reeled in a healthy " + fish + "! It has been added to your inventory");
                    user.addInventory(fish);
                }
                else
                {
                    System.out.println("\nYou reeled in nothing! How unfortunate!");
                }

                System.out.println("Number of Bait: " + user.getBaitNum());

                System.out.print("Cast?: ");
                choice = input.nextLine();
            }
        }
        // If the user's inventory has no [Bait], stop fishing
        if (user.getBaitNum() <= 0)
        {
            System.out.println("\nYou do not possess enough [Bait] to continue fishing. Buy more [Bait] at the shop");
        }

        System.out.println("\nLeaving the oasis . . .");
    }
}