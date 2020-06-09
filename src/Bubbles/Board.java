package Bubbles;

import java.util.Random;

public class Board 
{
    int bubbles;
    
    public Board(int width, int height)
    {
        Random gen = new Random();
        
        for (int b=1 ; b <= width*height ; b++)
        {
            Bubble ball = new Bubble(gen.nextInt(5) + 1);
        }
        
        bubbles = width*height;
    }
    
    public void createBoard()
    {
        
    }
    
    public static void main(String[]args)
    {
        Board set = new Board(15,8);
        
        System.out.println(set.bubbles);
        
        float f = (float)3.212341234;
        
        System.out.println(f);
    }
}
