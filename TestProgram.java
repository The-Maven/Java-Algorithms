import java.util.Scanner;

public class TestProgram extends IntelliPuzzle
{
    public static void main(String args[]){
    
       System.out.println("Welcome please enter the string representation of your eight puzzle");
       
       Scanner keyboard = new Scanner(System.in);
        
       String current= keyboard.nextLine();
        
      System.out.println("These are the steps to solving the puzzle");
        
    
        Moves[] steps =  Solver.solve(current, possibleResults);
       
        for (int i=0; i<steps.length; i++){
        System.out.println(instructions(steps[i]));
        }
  }
}