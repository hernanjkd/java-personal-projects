package JavaApplet;

import javax.swing.JFrame;

public class RectangleViewer
{ 
    public static void main(String[]args) 
    {    
        JFrame frame2 = new JFrame(); 
        frame2.setSize(300,400);
        frame2.setTitle("Two Rectangles in an applet");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
                
        RectangleApplet applet = new RectangleApplet(); 
        frame2.add(applet);  
      
        frame2.setVisible(true); 
   
        JFrame frame = new JFrame();  
        frame.setSize(315,200); 
        frame.setTitle("Two Rectangles in a component");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        RectangleComponent component = new RectangleComponent();
        frame.add(component);
        
        frame.setVisible(true); 
    } 
}
