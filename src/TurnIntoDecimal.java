import java.util.*;
import javax.swing.JOptionPane;

public class TurnIntoDecimal 
{
    private String binary;
    private int decimal;
    private ArrayList list;
    
    public TurnIntoDecimal(String binary)
    {
        this.binary = binary;
    }
    
    private void breakBinary()
    {
        list = new ArrayList<String>();
        
        String sub = binary.trim(); 
        String sub2 = sub;
        
        while (!sub.equals(""))
        {
            sub = sub.substring(0,1);
            
            list.add(sub);
                    
            sub = sub2.substring(1).trim();
            
            sub2 = sub;
        }
    }
    
    private void turnIntoDecimal()
    {
        int number = 1;
        
        while (list.get(0).equals("0") && list.size() > 1)
        {
            list.remove(0);
        }
        
        if (list.size() == 1 && list.get(0).equals("0")) number = 0;
        
        else 
        {
            for (int i=1 ; i < list.size() ; i++)
            {
                if (list.get(i).equals("1"))
                number = number*2+1;
            
                else number = number*2;
            }
        }
        
        decimal = number;
    }
    
    public int returnDecimal()
    {
        breakBinary();
        
        turnIntoDecimal();
        
        return decimal;
    }
    
    public static boolean checkInput(String input)
    {
        String test = input;
        
        while (test.length() > 0)
        {
            String check = test.substring(0,1);
            
            if (!check.equals("0") && !check.equals("1") && !check.equals(" "))
                return false;
            
            test = test.substring(1);
        }
        
        return true;
    }
    
    public static void main(String[]args)
    {
        String input = "";
        
        while (input != null)
        {
            do input = JOptionPane.showInputDialog("Enter binary to turn into decimal.");
            while (!checkInput(input));
        
            TurnIntoDecimal number = new TurnIntoDecimal(input);
       
            JOptionPane.showMessageDialog(null,number.returnDecimal());
        }
    }
}