import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
            File f = new File("src/localvisitor.data");
            f.createNewFile(); // This method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/localvisitor.data");
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

    public static LocalVisitor read()
    {
        try
        {
            File source = new File("src/localvisitor.data");
            Scanner scan = new Scanner(source);

            String user = "";
            ArrayList<String> space = new ArrayList<String>();
            int value = 15;

            // Reads from the file line by line
            int line = 1;
            while (scan.hasNextLine())
            {
                String data = scan.nextLine();
                if (line == 1)
                {
                    user = data;
                }
                if (line == 2)
                {
                    if (!(data.equals("[]")))
                    {
                        while (data.contains(","))
                        {
                            space.add(data.substring(1, data.indexOf(",")));
                            data = data.substring(data.indexOf(",") + 1);
                        }
                        space.add(data.substring(1, data.indexOf("]")));
                    }
                }
                if (line == 3)
                {
                    value = Integer.parseInt(data);
                }
                line++;
            }
            scan.close();

            // Creates a new Player object
            return new LocalVisitor(user, space, value);
        }
        catch (FileNotFoundException e)
        {
            // Creates a new Player object
            LocalVisitor user = new LocalVisitor();

            // Welcomes the user
            System.out.print(user.welcome());

            // Prompts user input
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            ArrayList<String> inventory = new ArrayList<String>();

            // Sets the user's name and inventory
            user.setName(name);
            user.setInventory(inventory);
            user.save();

            return user;
        }

    }
}