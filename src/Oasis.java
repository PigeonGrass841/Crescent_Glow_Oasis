import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import java.io.IOException;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class Oasis
{
    public static void main(String[] args)
    {
        Window oasis = new Window();

        try {
            File f = new File("src/Storage.data");
            Scanner s = new Scanner(f);
            int line = 1;
            String name = "";
            String hobby = "";
            // reading from the file line by line
            while (s.hasNextLine()) {
                String data = s.nextLine();
                if (line == 1) {
                    name = data;
                }
                if (line == 2) {
                    hobby = data;
                }
                line++;
            }
            s.close();


        }
        // if the file doesn't exist, we will create a blank Person object and ask them for a name and hobby
        catch (FileNotFoundException e) {

        }
    }
}
