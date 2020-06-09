package Expressions;

import javax.swing.JOptionPane;

public class User 
{
    public static boolean check(boolean user, String input)
    {
        String amountOfExp = 3 +"";
        
        boolean isNumber = input.compareTo("a") <= 0;
        
        boolean isValid = true;
        
        if (user) isValid = input.compareTo("0") > 0 && input.compareTo(amountOfExp) <= 0;
        
        else isNumber = isNumber || input.equals("b");
        
        return isNumber && isValid;
    }
    
    public static void main(String[]args)
    {
        String input;
        
        int quadratic = 3;
        int dotProduct = 2;
        int crossProduct = 1;
        
        do
        {
            do 
            {
                input = JOptionPane.showInputDialog(
                        "1. cross product\n"+
                        "2. dot product\n"+
                        "3. quadratic");
            }
            while (!check(true,input));
 
            int number = Integer.parseInt(input);

            if (number == dotProduct)
            {
                DotProduct eq;
                
                do
                {
                    eq = new DotProduct();
                    
                    if (!eq.done()) JOptionPane.showMessageDialog(null,eq);
                }
                while(!eq.done());
            }
            
            if (number == quadratic)
            {
                Quadratic eq;
                
                do
                {
                    eq = new Quadratic();

                    if (!eq.done()) JOptionPane.showMessageDialog(null,eq);
                }
                while(!eq.done());
            }
            
            if (number == crossProduct)
            {
                CrossProduct eq;
                
                do
                {
                    eq = new CrossProduct();

                    if (!eq.done()) JOptionPane.showMessageDialog(null,eq);
                }
                while(!eq.done());
            }
        }
        while (input != null);
    }
}