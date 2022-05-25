import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LocalVisitor extends StorageSpace
{
    private String name;

    // Empty parameter constructor
    public LocalVisitor()
    {
        super();
        this.name = "";
    }

    // Name, inventory, and sum parameter constructor
    public LocalVisitor(String name, ArrayList<String> inventory, int sum)
    {
        super(inventory, sum);
        this.name = name;
    }

    // Returns the name of the Plauer
    public String getName()
    {
        return this.name;
    }

    // Sets the name of the Plauer
    public void setName(String name)
    {
        this.name = name;
    }

    // Returns an appropriate greeting
    public String welcome()
    {
        if (name.equals("") && super.getInventory().equals(new ArrayList<String>())) {
            return "Welcome! Before we allow you to start, we need to identify the vistor: ";
        }
        else {
            return "Name: " + name + "\nInventory: " + super.getInventory();
        }
    }

    // Takes the name, inventory, and sum of the player and write it into a file!
    public void save()
    {
        try {
            File f = new File("src/visitor.data");
            f.createNewFile(); // This method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/visitor.data");
            fw.write(name + "\n");
            fw.write(super.getInventory().toString() + "\n");
            fw.write(String.valueOf(super.getSum()));
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}