import java.util.Scanner;

public class Fish extends Storage
{
    private Player user;

    public Fish(Player user)
    {
        this.user = user;
    }
    public void fish()
    {
        System.out.print("\nWelcome to the oasis, press [enter] to leave and [c] to cast your rod: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        while (choice.equals("c"))
        {
            int index = (int)(Math.random() * super.getFISH().size());
            String fish = super.getFISH().get(index);

            System.out.println("\nYou reeled in a healthy " + fish + "! It has been added to your inventory");
            user.addInventory(fish);

            System.out.print("Cast?: ");
            choice = input.nextLine();
        }

        System.out.println("\nLeaving the oasis . . .");
    }
}