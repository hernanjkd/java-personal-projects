package Bubbles;

public class Bubble 
{
    private static int count = 0;
    
    private String color;
    private int name;
    
    private Bubble up    = null;
    private Bubble down  = null;
    private Bubble left  = null;
    private Bubble right = null;
    
    public Bubble(int color)
    {
        switch(color)
        {
            case 1 : this.color = "blue";   break;
            case 2 : this.color = "red";    break;
            case 3 : this.color = "yellow"; break;
            case 4 : this.color = "green";  break;
            case 5 : this.color = "purple"; break;
        }
        
        count++;
        
        name = count;
    }
    
    public String getColor()
    {
        return color;
    }
    
    public int getName()
    {
        return name;
    }
    
    public void connect(Bubble b, String direction)
    {
        if (direction.equals("up"))    up = b;
        if (direction.equals("down"))  down = b;
        if (direction.equals("left"))  left = b;
        if (direction.equals("right")) right = b;
    }
}
