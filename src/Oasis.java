public class Oasis
{
    public static void main(String[] args)
    {
        // Reads from the file line buy line and creates a new Player object
        LocalVisitor user = LocalVisitor.read();

        // Creates a new Player object and runs the program's logic
        TourGuide tab = new TourGuide();
        tab.runWindow(user);
    }
}