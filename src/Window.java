import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import java.io.IOException;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class Window
{
    public Window()
    {
        JFrame j = new JFrame();
        j.setSize(1000, 750);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setTitle("Crescent Glow Oasis");
        j.setVisible(true);
    }
}
