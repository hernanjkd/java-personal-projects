import java.io.*;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class ReadAndCopy
{
    public static void main(String[]args) throws IOException
    {
        String input = JOptionPane.showInputDialog("Enter file to be read.");
        
        PrintWriter file = new PrintWriter("copy.txt");
        
        FileReader read = new FileReader(input);
        
        Scanner scan = new Scanner(read);
        
        while(scan.hasNext())
        {
            String line = scan.nextLine();
            
            file.println(line);
        }
 
        file.close();
    }
}
