import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import javax.swing.JFileChooser;


public class Main
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        Scanner in = new Scanner(System.in);

        String line;
        int numLines = 0;
        int numWords = 0;
        int numChars = 0;

        Path file = new File(System.getProperty("user.dir")).toPath();
        file = file.resolve("src");
        chooser.setCurrentDirectory(file.toFile());


        try
        {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                file = chooser.getSelectedFile().toPath();
                in = new Scanner(file);
                System.out.println("File: " + file.getFileName());
                while (in.hasNextLine())
                {
                    line = in.nextLine();
                    numLines++;
                    String[] arr=line.split(" ");
                    numWords = numWords + arr.length;
                    numChars += line.length();
                }
                in.close();
                System.out.println("Lines: " + numLines);
                System.out.println("Words: " + numWords);
                System.out.println("Characters: " + numChars);
            }
            else
            {
                System.out.println("File Not Selected. Closing Down .......");
                System.exit(0);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File Not Found");
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            System.out.println("ERROR: IOException");
            ex.printStackTrace();
        }
    }
}