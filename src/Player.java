import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends Storage
{
    private String name;

    public Player()
    {
        super();
        this.name = "";
    }

    public Player(String name, ArrayList<String> inventory)
    {
        super(inventory);
        this.name = name;
    }

    // This method is an example of how to take some information and write it into a file!
    public void save() {
        try {
            File f = new File("src/Player.data");
            f.createNewFile(); // this method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/Player.data");
            fw.write(name + "\n");
            fw.write(getInventory() + "\n");
            fw.write(getSum());
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}
