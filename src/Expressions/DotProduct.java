package Expressions;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class DotProduct
{
    private double a;
    private double b;
    private double c;
    private double x;
    private double y;
    private double z;
    
    private boolean done = false;
    
    public DotProduct()
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
                    "<a,b,c>•<x,y,z>       \n\n\n" +
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
    
    private double answer()
    {
        return (a*x) + (b*y) + (c*z);
    }
    
    public String toString()
    {
        return answer()+"";
    }
}