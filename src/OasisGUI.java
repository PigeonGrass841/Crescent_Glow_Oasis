import javax.swing.*;
import java.awt.*;

public class OasisGUI {
    public static void main(String[] args) {
        // Creates the frame
        JFrame frame = OasisGUI.createFrame();

        // Creates the panel at bottom and adds the components
        JMenuBar menuBar = OasisGUI.createMenuBar();

        // Creates the panel
        JPanel panel = OasisGUI.createPanel();

        // Adds frame components
        OasisGUI.addFrameComponents(frame, menuBar, panel);
    }

    // Creates and returns a frame
    public static JFrame createFrame() {
        // Creates a frame
        JFrame frame = new JFrame("Crescent_Glow_Oasis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 675);

        // Returns the frame
        return frame;
    }

    // Creates the menu bar and adds components
    public static JMenuBar createMenuBar() {
        // Creates a menu bar
        JMenuBar menuBar = new JMenuBar();
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
    public static JPanel createPanel() {
        // The panel is not visible in output
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Choice: ");
        // Accepts up to 18 characters
        JTextField textField = new JTextField(10);
        JButton enter = new JButton("Enter");
        // Components Added using Flow Layout
        panel.add(label);
        panel.add(textField);
        panel.add(enter);

        return panel;
    }

    public static void addFrameComponents(JFrame frame, JMenuBar menuBar, JPanel panel) {
        // Text Area at the Center
        JTextArea textArea = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.setVisible(true);
    }
}