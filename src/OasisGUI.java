/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OasisGUI
{
    private JTextArea text;
    private JTextField inputSpace;
    private LocalVisitor user;

    // Constructor, which calls helper methods to setup the GUI then load the options
    public OasisGUI()
    {
        text = new JTextArea(20, 35);
        inputSpace = new JTextField();
        user = new LocalVisitor();

        // Sets up GUI
        createGUI();
    }

    // Private helper method, called by constructor to set up the GUI and display it
    private void setupGui()
    {
        // Reads from the file line buy line and creates a new Player object
        LocalVisitor user = LocalVisitor.read();

        // Creates a frame
        JFrame frame = new JFrame("Crescent_Glow_Oasis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 675);

        // Middle panel with text
        JPanel movieListPanel = new JPanel();
        // Welcomes the user
        text.setText(user.welcome());
        text.setFont(new Font("Helvetica", Font.PLAIN, 16));
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        movieListPanel.add(text);

        // Bottom panel with text field and buttons
        JPanel panel = new JPanel(); // The panel is not visible in output
        JLabel label = new JLabel("Choice: ");

        // Accepts up to 18 characters
        inputSpace = new JTextField(10);
        JButton enter = new JButton("Enter");

        // Components Added using Flow Layout
        panel.add(label);
        panel.add(inputSpace);
        panel.add(enter);

        // Prompts the user for a choice
        System.out.println("\nWelcome to the Crescent Glow Oasis. You can fish and sell or buy items in the shop.");
        System.out.println("[1] Go fishing\n[2] Enter the shop\n[3] Check inventory and sum\n[4] Resort to capitalism\n[5] Leave");

        // PART 2 -- SET UP EVENT HANDLING
        // Setting up buttons to use ActionListener interface and actionPerformed method
        enter.addActionListener(this);

        // Showing the frame
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        // Cast source to JButton
        JButton button = (JButton) event.getSource();
        String text = button.getText();

        if (text.equals("Enter"))
        {
            // Retrieves the user input
            // getText() returns a string and converts it to an integer
            String choice = inputSpace.getText();

            // Executes the corresponding method
            // Choice [1] Go fishing
            if (choice.equals("1"))
            {
                // Creates the FishPond object
                FishPond oasis = new FishPond(user);
                oasis.fish();
            }
            // Choice [2] Enter the shop
            if (choice.equals("2"))
            {
                // Creates the ItemShop object
                ItemShop counter = new ItemShop(user);

                // Prompts the user to sell or buy something
                System.out.println("\nThanks for coming to the shop, would you like to sell or buy something?");
                System.out.println("[1] Sell something\n[2] Buy something");
                System.out.print("Choice: ");

                // Choice [1] Sell something
                if (choice.equals("1"))
                {
                    // Prompts the user to sell an item or all items in their inventory
                    System.out.println("\n[1] Sell an item\n[2] Sell all items");
                    System.out.print("Choice: ");

                    // Prompts user input
                    choice = input.nextLine();

                    // Choice [1] Sell an item
                    if (choice.equals("1"))
                    {
                        counter.sellItem();
                    }
                    // Choice [2] Sell all items
                    if (choice.equals("2"))
                    {
                        counter.sellItemAll();
                        choice = "1";
                    }
                }
                // Choice [2] Buy something
                if (choice.equals("2"))
                {
                    // Prompts the user to buy an item or buy multiple instance of the same item using their entire sum
                    System.out.println("\n[1] Buy an item\n[2] Buy an item in bulk");
                    System.out.print("Choice: ");

                    //Prompts user input
                    choice = input.nextLine();

                    // Choice [1] Buy an item
                    if (choice.equals("1"))
                    {
                        counter.buyItem();
                    }
                    // Choice [2] Buy an item in bulk
                    if (choice.equals("2"))
                    {
                        counter.buyItemAll();
                    }
                }
            }
            // Choice [3] Check inventory and sum
            if (choice.equals("3"))
            {
                System.out.println(user);
            }
            // Choice [4] Resort to capitalism
            if (choice.equals("4"))
            {
                McDonalads job = new McDonalads();
                job.work(user);
            }
            // Choice [5] Quit
            if (choice.equals("5"))
            {

            }

            // Prompts the user for a choice
            System.out.println("\nYou can fish and sell or buy items in the shop.");
            System.out.println("[1] Go fishing\n[2] Enter the shop\n[3] Check inventory and sum\n[4] Resort to capitalism\n[5] Leave");
            System.out.print("Choice: ");
        }
    }
}
*/