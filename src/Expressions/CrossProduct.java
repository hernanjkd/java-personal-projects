package Expressions;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class CrossProduct 
{
    private double a;
    private double b;
    private double c;
    private double x;
    private double y;
    private double z;
    
    private boolean done = false;
    
    public CrossProduct()
    {
        String var = getVariables();
        
        if (!done)
        {
            Scanner scan = new Scanner(var);

            a = scan.nextDouble();
            b = scan.nextDouble();
            c = scan.nextDouble();
            x = scan.nextDouble();
            y = scan.nextDouble();
            z = scan.nextDouble();
        }
    }
    
    private String getVariables()
    {
        String input;
        
        do 
        {
            input = JOptionPane.showInputDialog(
                    "<a,b,c> x <x,y,z>       \n\n\n" +
                    "a b c x y z                                   b. back");
        }
        while (!User.check(false,input));
        
        if (input.equals("b")) done = true;
        
        return input;
    }
    
    public boolean done()
    {
        return done;
    }
    
    private double i()
    {
        return b*z - c*y;
    }
    
    private double j()
    {
        return - (a*z - x*c);
    }
    
    private double k()
    {
        return a*y - x*b;
    }
    
    public String toString()
    {
        return "< "+ i() +" , "+ j() +" , "+ k() +" >";
    }
}