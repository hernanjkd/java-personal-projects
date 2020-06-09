package TicTacToe;

import javax.swing.JOptionPane;
import java.util.Random;

public class TicTacToe
{
    private boolean isPlayersTurn;
    private boolean computerStarts;
    private boolean playerHasWon = false;
    
    private int turn = 0;
    
    private String t1 = "  ";
    private String t2 = "  ";
    private String t3 = "  ";
    private String t4 = "  ";
    private String t5 = "  ";
    private String t6 = "  ";
    private String t7 = "  ";
    private String t8 = "  ";
    private String t9 = "  ";
    
    public TicTacToe()
    {
        String input = JOptionPane.showInputDialog("Do you want to start? (yes/no)");
        
        boolean yes = input.equalsIgnoreCase("yes");
        
        isPlayersTurn = yes;
        computerStarts = !yes;
    }
    
    public String getPlayersMove()
    {
        String ticTacToe = "[1][2][3]\n" +
                           "[4][5][6]     Player x\n" +
                           "[7][8][9]     CPU    o\n\n\n";
        
        String input = JOptionPane.showInputDialog(ticTacToe+toString());
        
        return input;
    }
    
    public boolean isValidMove(String move)
    {
        if (!isNumber(move))
            return false;
        
        int num = Integer.parseInt(move);
        
        return num >= 1 && num <= 9 && isAvailable(num);
    }
    
    public void applyPlayerMove(String move)
    {
        apply(move);
        
        if (ticTacToe())
            playerHasWon = true;
        
        isPlayersTurn = false;
    }
    
    public void applyComputerMove()
    {
        turn++;
        
        if (computerStarts) 
        {
            if (turn == 1) 
            {
                apply(5+"");
            }
            
            if (turn == 2 && (t2.equals("x") || t4.equals("x") || t6.equals("x") || t8.equals("x")))
            {
                int move = getRandomMove(1,3,7,9);
                
                apply(move+"");
            }
            else if (turn == 2)
            {
                apply(getRandomMove()+"");
                        
                computerStarts = false;
            }
            
            if (turn == 3)
            {
                int num = getNumberForTicTacToe();
                
                if (num != 0) apply(num+"");
                else
                {
                    int move = 0;
                    
                    if (t1.equals("o")) move = getRandomMove(2,4);
                    if (t3.equals("o")) move = getRandomMove(2,6);
                    if (t7.equals("o")) move = getRandomMove(4,8);
                    if (t9.equals("o")) move = getRandomMove(6,8);
                
                    apply(move+"");
                }
            }
            
            if (turn == 4)
            {
                int num = getNumberForTicTacToe();
                        
                apply(num+"");
            }
        }
        else
        {
            int move = getNumberForTicTacToe();
            
            if (move != 0) apply(move+"");
            
            else apply(getRandomMove()+"");
        }
        
        isPlayersTurn = true;
    }
    
    public boolean isPlayersTurn()
    {
        return isPlayersTurn;
    }
    
    public boolean gameCompleted()
    {
        return ticTacToe() || isFull();
    }
    
    public boolean playerHasWon()
    {
        return playerHasWon;
    }
    
    @Override
    public String toString()
    {
        String out = "["+t1+"]["+t2+"]["+t3+"]\n"+
                     "["+t4+"]["+t5+"]["+t6+"]\n"+
                     "["+t7+"]["+t8+"]["+t9+"]\n\n";
        
        return out;
    }
    
    private boolean isNumber(String move)
    {        
        if (move.equals("")) return false;
        
        for (int i=0 ; i < move.length() ; i++)
        {
            String next = move.substring(i, i+1);
            
            if (next.compareTo("0") < 0 || next.compareTo("9") > 0) return false;
        }
          
        return true;
    }
    
    private boolean isAvailable(int move)
    {
        switch(move)
        {
            case 1 : return t1.equals("  ");
            case 2 : return t2.equals("  ");
            case 3 : return t3.equals("  ");
            case 4 : return t4.equals("  ");
            case 5 : return t5.equals("  ");
            case 6 : return t6.equals("  ");
            case 7 : return t7.equals("  ");
            case 8 : return t8.equals("  ");
            case 9 : return t9.equals("  ");
            default : return false;
        }
    }
    
    private void apply(String move)
    {
        String n = (isPlayersTurn ? "x" : "o");
        
        switch(Integer.parseInt(move))
        {
            case 1 : t1 = n; break;
            case 2 : t2 = n; break;
            case 3 : t3 = n; break;
            case 4 : t4 = n; break;
            case 5 : t5 = n; break;
            case 6 : t6 = n; break;
            case 7 : t7 = n; break;
            case 8 : t8 = n; break;
            default : t9 = n; break;
        }
    }
    
    private boolean ticTacToe()
    {
        String n = (isPlayersTurn ? "x" : "o");
                
        if (match(t1,t2,t3) || match(t4,t5,t6) || match(t7,t8,t9) || match(t1,t5,t9))
            return true;
        
        if (match(t1,t4,t7) || match(t2,t5,t8) || match(t3,t6,t9) || match(t3,t5,t7))
            return true;
                    
        return false;
    }
    
    private boolean match(String t1, String t2, String t3)
    {
        String match = t1+t2+t3;
        
        return match.equals("xxx") || match.equals("ooo");
    }
    
    private boolean isFull()
    {
        boolean row1 = !t1.equals("  ") && !t2.equals("  ") && !t3.equals("  ");
        boolean row2 = !t4.equals("  ") && !t5.equals("  ") && !t6.equals("  ");
        boolean row3 = !t7.equals("  ") && !t8.equals("  ") && !t9.equals("  ");
                
        return row1 && row2 && row3;
    }
    
    private String getT(int place)
    {
        switch(place)
        {
            case 1 : return t1;
            case 2 : return t2;
            case 3 : return t3;
            case 4 : return t4;
            case 5 : return t5;
            case 6 : return t6;
            case 7 : return t7;
            case 8 : return t8;
            default : return t9;
        }
    }
    
    private int getNumberForTicTacToe()
    {
        int num = 0;
        int move = 0;
                
        for (int i=1 ; i < 9 && num < 10 ; i++)
        {
            if (i == 1 || i == 4 || i == 7) num = check(i,i+1,i+2);            
            if (i == 2 || i == 3) num = check(i,i+3,i+6);    
            if (i == 5) num = check(1,4,7);            
            if (i == 6) num = check(1,5,9);            
            if (i == 8) num = check(3,5,7);
            
            if (num != 0) move = num;
        }
        
        if (num >10) return num - 10;
        
        else return move;
    }
    
    private int check(int one, int two, int three)
    {        
        String tone = getT(one);
        String ttwo = getT(two);
        String tthree = getT(three);
        
        String line = tone+ttwo+tthree;
        
        if (line.equals("xx  ")) return three;
        if (line.equals("oo  ")) return three + 10;
        if (line.equals("x  x")) return two;
        if (line.equals("o  o")) return two + 10;
        if (line.equals("  xx")) return one;
        if (line.equals("  oo")) return one + 10;
        
        return 0;
    }
    
    private int getRandomMove()
    {
        Random gen = new Random();
        
        int move;
        
        do
        {
            move = (gen.nextInt(9) + 1);
        }
        while (!isValidMove(move+""));
        
        return move;
    }
    
    private int getRandomMove(int one, int two)
    {
        int move;
                
        do 
        {
            move = getRandomMove();
        }
        while(move != one && move != two);
                
        return move;
    }
    
    private int getRandomMove(int one, int two, int three, int four)
    {
        int move;
                
        do 
        {
            move = getRandomMove();
        }
        while(move != one && move != two && move != three && move != four);
                
        return move;
    }
    
    public static void main(String[]args)
    {
        TicTacToe game = new TicTacToe();
                
        while ( !game.gameCompleted() )  
	{ 
            if ( game.isPlayersTurn() )
            {  
                String move;  
		do 
		{   
                    move = game.getPlayersMove();
		} 
                while ( !game.isValidMove(move) );
		
                game.applyPlayerMove(move);
            }
            else game.applyComputerMove();
	} 
        String message=""+(game.playerHasWon()?"YOU WON!":"YOU DIDN'T WIN. =)");
        
        JOptionPane.showMessageDialog(null,game+message);
    }
}