public class Fish extends Storage
{
    public void fish()
    {
        int index = (int)(Math.random() * super.getFISH().size());
        String fish = super.getFISH().get(index);

        System.out.println("You reeled in a healthy" + fish + "! It has been added to your inventory");
        addInventory(fish);
    }
}
