package JavaApplet;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JApplet;

public class RectangleApplet extends JApplet
{
    public void paint(Graphics g)
    {
        // Prepare for extended graphics
        Graphics2D g2 = (Graphics2D) g;
        
        // Construct a rectangle and draw it
        Rectangle box = new Rectangle(5,10,20,30);
        g2.draw(box);
        
        // Move rectangle
        box.translate(15, 20);
        
        // Draw moved rectangle
        g2.draw(box);
    }
}
