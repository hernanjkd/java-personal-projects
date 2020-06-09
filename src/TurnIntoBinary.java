import javax.swing.JOptionPane;

public class TurnIntoBinary 
{
    int number;
    
    public TurnIntoBinary(int number)
    {
        this.number = number;
    }
    
    public String returnBinary()
    {
        String binary = "";
        
        int divide = 4;
        
        while (number > 1)
        {
            binary = (number%2 == 0? "0" : "1")+binary;
            
            number = number/2;
            
            if (binary.length()%divide == 0)
            {
                binary = " "+binary;
                
                divide += 5;
            }
        }
        
        binary = "1"+binary;
        
        if (number == 0) binary = "0";
        
        return binary;
    }
    
    public static void main(String[]args)
    {
        String input = "";
        
        while (input != null)
        {
            input = JOptionPane.showInputDialog("Enter a number to turn into binary.");

            int number = Integer.parseInt(input);
            
            TurnIntoBinary binary = new TurnIntoBinary(number);
            
            JOptionPane.showMessageDialog(null,binary.returnBinary());
        }
    }
}