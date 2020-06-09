package Expressions;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Quadratic
{
    private double a;
    private double b;
    private double c;
    
    private boolean done = false;
    
    public Quadratic()
    {
        String var = getVariables();
        
        if (!done)
        {
            Scanner scan = new Scanner(var);

            a = scan.nextDouble();
            b = scan.nextDouble();
            c = scan.nextDouble();
        }
    }
    
    private String getVariables()
    {
        String input;
        
        do 
        {
            input = JOptionPane.showInputDialog(
                    "-b ± √(bb - 4ac) \n" + 
                    "————————         \n" +
                    "           2a    \n\n\n" +
                    "a b c                                            b. back");
        }
        while (!User.check(false,input));
        
        if (input.equals("b")) done = true;
        
        return input;
    }
    
    public boolean done()
    {
        return done;
    }
    
    private double sqrt()
    {
        return Math.sqrt((b*b) - 4*a*c);
    }
    
    private double answer1()
    {
        return ((-b) + sqrt()) / (2 * a);
    }
    
    private double answer2()
    {
        return ((-b) - sqrt()) / (2 * a);
    }
    
    public String toString()
    {
        return answer1() + "     " + answer2();
    }
}