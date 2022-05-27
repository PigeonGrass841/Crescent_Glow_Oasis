import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OasisGUI {
    public static void main(String[] args) {
        OasisGUI graphicUserInterface = new OasisGUI();
        // Creates the frame
        JFrame frame = graphicUserInterface.createFrame();

        // Creates the panel at bottom and adds the components
        JMenuBar menuBar = graphicUserInterface.createMenuBar();

        // Creates the panel
        JPanel panel = graphicUserInterface.createPanel();

        // Adds frame components
        graphicUserInterface.addFrameComponents(frame, menuBar, panel);
    }

    private JFrame frame;
    private JMenuBar menuBar;
    private JPanel panel;
    private JTextArea textArea;
    private JTextField input;

    // Creates and returns a frame
    public JFrame createFrame() {
        // Creates a frame
        frame = new JFrame("Crescent_Glow_Oasis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 675);

        // Returns the frame
        return frame;
    }

    // Creates the menu bar and adds components
    public JMenuBar createMenuBar() {
        // Creates a menu bar
        menuBar = new JMenuBar();
        JMenu save = new JMenu("Save");
        menuBar.add(save);

        // Adds the components
        JMenuItem sContinue = new JMenuItem("Save and continue");
        JMenuItem sQuit = new JMenuItem("Save and quit");
        save.add(sContinue);
        save.add(sQuit);

        // Returns the menu bar
        return menuBar;
    }

    // Creates the panel
    public JPanel createPanel() {
        // The panel is not visible in output
        panel = new JPanel();
        JLabel label = new JLabel("Choice: ");
        // Accepts up to 18 characters
        input = new JTextField(10);
        JButton enter = new JButton("Enter");
        // Components Added using Flow Layout
        panel.add(label);
        panel.add(input);
        panel.add(enter);

        return panel;
    }

    public void addFrameComponents(JFrame frame, JMenuBar menuBar, JPanel panel) {
        // Text Area at the Center
        textArea = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
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
            String choice = input.getText();

            // Executes the corresponding method

        }
    }
}