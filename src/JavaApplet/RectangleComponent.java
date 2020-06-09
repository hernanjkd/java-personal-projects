package JavaApplet;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class RectangleComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        //Recover Graphics2D
        Graphics2D g2 = (Graphics2D)g;
        
        //Construct a rectangle and draw it.
        //(int) from left, (int) from top, (int) width, (int) height.
        Rectangle box = new Rectangle(10, 10, 15, 15);
        g2.draw(box);
        
        for (int vertical = 0 ; vertical <= 165 ; vertical += 20)
        {
            if (vertical != 0)
            {
                if (vertical == 20) vertical = 30;
                
                box.setBounds(10, vertical, 15, 15);
                g2.draw(box);
            }
            
            for (int horizontal = 1 ; horizontal <= 14 ; horizontal++)
            {
                box.translate(20, 0);
                g2.draw(box);
            }
        }
    }
}