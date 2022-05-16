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
}
