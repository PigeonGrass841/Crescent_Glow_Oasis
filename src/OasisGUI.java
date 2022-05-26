import javax.swing.*;
import java.awt.*;

public class OasisGUI
{
    public static void main(String[] args){
        //Creating the Frame
        JFrame frame = new JFrame("Crescent_Glow_Oasis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 675);

        //Creating the MenuBar and adding components
        JMenuBar menuBar = new JMenuBar();
        JMenu save = new JMenu("Save");
        menuBar.add(save);
        JMenuItem sContinue = new JMenuItem("Save and continue");
        JMenuItem sQuit = new JMenuItem("Save and quit");
        save.add(sContinue);
        save.add(sQuit);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Choice: ");
        JTextField textField = new JTextField(10); // Accepts up to 18 characters
        JButton enter = new JButton("Enter");
        panel.add(label); // Components Added using Flow Layout
        panel.add(textField);
        panel.add(enter);

        // Text Area at the Center
        JTextArea textArea = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.setVisible(true);
    }
}