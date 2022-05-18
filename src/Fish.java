public class Fish extends Storage
{
    private Player user;
    public Fish(Player user)
    {
        this.user = user;
    }

    public void fish()
    {
        int index = (int)(Math.random() * super.getFISH().size());
        String fish = super.getFISH().get(index);

        System.out.println("\nYou reeled in a healthy " + fish + "! It has been added to your inventory");
        user.addInventory(fish);
    }
}
