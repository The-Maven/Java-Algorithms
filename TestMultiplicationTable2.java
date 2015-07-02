import java.util.Scanner;

public class TestMultiplicationTable2 
{
  public static final String MULT_COMMAND = "MULT";
  public static final String END_COMMAND = "END";
  
  public static void main(String[] args) 
  {
    int maxX, maxY, x, y, prod;
    String command;
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("I can create a multiplication table to compute x * y");
    System.out.println("(where x and y are integers)");
    System.out.println("What's the maximum value of x? ");
    maxX = keyboard.nextInt();
    
    System.out.println("What's the maximum value of y? ");
    maxY = keyboard.nextInt();
    
    MultiplicationTable2 mTable = new MultiplicationTable2(maxX+1, maxY+1);
    
    System.out.println("The multiplication table is: ");
    mTable.print();
    
    System.out.println("To lookup the value of x*y, enter MULT x y.  ");
    System.out.println("To end, enter END");
    
    do {
      System.out.print("Enter Command: ");
      command = keyboard.next();
      if (command.equalsIgnoreCase(MULT_COMMAND)){
        x = keyboard.nextInt();
        y = keyboard.nextInt();
        prod = mTable.lookUp(x,y);
        
        if (prod >= 0)
          System.out.println(x + "*" + y + " = " + prod);
        else
          System.out.println("Out of range.");
      }
      
    } while (!command.equalsIgnoreCase(END_COMMAND));
    
    System.out.println("Good-bye!");
  }
}