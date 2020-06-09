import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EquationSolver 
{
    Queue store;
    Stack operandStack;
    Stack operatorStack;
    
    public EquationSolver(Queue store)
    {
        this.store = store;
        operandStack = new Stack<Token>();
        operatorStack = new Stack<Token>();
    }
    
    public double getValue()
    {
        while (!store.empty())
        {
            Token item = (Token)store.getQ();
           
            if (item.isLeftParen())
            {
                int count = 1;
                
                Queue paren = new Queue<Token>();
                
                item = (Token)store.getQ();
                if (item.isLeftParen()) count++;
                    
                while (count != 0)
                {
                    paren.addQ(item);
                    item = (Token)store.getQ();
                    
                    if (item.isLeftParen()) count++;
                    if (item.isRightParen()) count--;
                }
                
                EquationSolver evaluator = new EquationSolver(paren);
                
                double result = evaluator.getValue();
                
                item = new Token(result);
            }
        
            if (item.isOperand()) operandStack.push(item);
            
            if (item.isOperator()) solveForOperator(item);
        }
        
        while (!operatorStack.empty()) solveEquation();
        
        return popOperand();
    }
    
    private void solveForOperator(Token operator)
    {        
        if (operatorStack.empty()) operatorStack.push(operator);
        
        else
        {
            Token previousOperator = (Token)operatorStack.peek();
            int op = operator.priority();
            int pp = previousOperator.priority();
            
            if (op < pp)
            {
                while (previousOperator != null && op < pp)
                {
                    solveEquation();
                    previousOperator = (Token)operatorStack.peek();
                    
                    if (previousOperator != null) pp = previousOperator.priority();
                }
                
                operatorStack.push(operator);
            }
            
            else operatorStack.push(operator);
        }
    }
     
    private double popOperand()
    {
        Token num = (Token)operandStack.pop();
        
        return num.doubleValue();
    }
    
    private void solveEquation()
    {
        double operand = popOperand();
        Token operator = (Token)operatorStack.pop();
        
        double result = 0;
        
        if (operator.isMinus()) result = solveEquation(operator)-operand;
        
        if (operator.isPlus()) result = solveEquation(operator)+operand;
          
        if (operator.isTimes()) result = solveEquation(operator)*operand;
        
        if (operator.isDivide()) result = solveEquation(operator)/operand;
        
        if (operator.isPower()) result = Math.pow(solveEquation(operator),operand);
        
        operandStack.push(new Token(result));
    }
    
    private double solveEquation(Token nextOperator)
    {
        double operand = popOperand();
        Token operator = (Token)operatorStack.peek();
        
        if (operator == null || operator.priority() != nextOperator.priority()) return operand;
        
        operatorStack.pop();
        
        double result = 0;
        
        if (operator.isMinus()) result = solveEquation(operator)-operand;
        
        if (operator.isPlus()) result = solveEquation(operator)+operand;
          
        if (operator.isTimes()) result = solveEquation(operator)*operand;
        
        if (operator.isDivide()) result = solveEquation(operator)/operand;
        
        if (operator.isPower()) result = Math.pow(solveEquation(operator),operand);
        
        return result;
    }
    
public static class Token
{
    private String symbol;
	
    public Token(String symbol)
    {
	this.symbol = symbol;
    }
	
    public Token(double number)
    {
    	this.symbol = "" + number;
    }
	
    public double doubleValue()
    {
	Scanner scan = new Scanner( this.symbol );
	if (!scan.hasNextDouble())
		throw new RuntimeException("Token is not an Integer");
	return scan.nextDouble();
    }
	
    public boolean isLeftParen()
    {
	return this.symbol.equals("(");
    }
	
    public boolean isRightParen()
    {
	return this.symbol.equals(")");
    }
	
    public boolean isPlus()
    {
	return this.symbol.equals("+");
    }
	
    public boolean isMinus()
    {
	return this.symbol.equals("-");
    }
	
    public boolean isTimes()
    {
	return this.symbol.equals("*");
    }
	
    public boolean isDivide()
    {
	return this.symbol.equals("/");
    }
	
    public boolean isPower()
    {
    	return this.symbol.equals("^");
    }

    public boolean isOperator()
    {
	return this.isPlus()  || this.isMinus() ||
               this.isTimes() || this.isDivide() ||
               this.isPower();
    }
	
    public boolean isOperand()
    {
	return !this.isLeftParen() && 
               !this.isRightParen() &&
               !this.isOperator();
    }
	
    public int priority()
    {
	if (this.isPower()) return 3;
		
        if (this.isTimes() || this.isDivide()) return 2;
		
        if (this.isPlus() || this.isMinus()) return 1;
		
        return 0;
    }
}
    
public class Stack<T>
{
    private ArrayList list;
    
    public Stack()
    {
        list = new ArrayList<T>();
    }
     
    public boolean empty()
    {
        return list.isEmpty();
    }
    
    public void push(T item)
    {
        list.add(0,item);
    }
    
    public T pop()
    {
        if (empty()) return null;
        
        return (T)list.remove(0);
    }
    
    public T peek()
    {
        if (empty()) return null;
        
        return (T)list.get(0);
    }
}

public static class Queue<T> 
{
    private ArrayList list;
    
    public Queue()
    {
        list = new ArrayList<T>();
    }
     
    public boolean empty()
    {
        return list.isEmpty();
    }
    
    public void addQ(T item)
    {
        list.add(item);
    }
    
    public T getQ()
    {
        if (empty()) return null;
        
        return (T)list.remove(0);
    }
    
    public T peek()
    {
        if (empty()) return null;
        
        return (T)list.get(0);
    }
}

    public static void main(String[]args)
    {
        String input = JOptionPane.showInputDialog(
                "Enter equation.                                          "+
                "                                                         ");
        
        while (input!= null) 
        {
            Queue list = new Queue<Token>();
            
            while (input.length() != 0) 
            {
                String item = input.substring(0,1);
                input = input.substring(1);
                
                Token newToken = new Token(item);
                
                boolean done = false;
                
                if (!newToken.isOperand()) done = true;
                
                while (input.length() != 0 && !done)
                {
                    String item2 = input.substring(0,1);
                    Token newToken2 = new Token(item2);
                    
                    if (newToken2.isOperand())
                    {
                        item += item2;
                        input = input.substring(1);
                    }
                   
                    else done = true;
                }
                        
                list.addQ(new Token(item));
            }
        
            EquationSolver evaluator = new EquationSolver(list);
        
            JOptionPane.showMessageDialog(null,evaluator.getValue());
            
            input = JOptionPane.showInputDialog(
                "Enter equation.                                          "+
                "                                                         ");
        }
    }
}