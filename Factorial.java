
import java.util.Scanner;

/**
 * This is a program to compute the factorial of a positive number.
 * 
 * @author G. Ayorkor Korsah
 */
public class Factorial
{

  public static void main(String[] args)
  {
    int number, count, factorial;
    Scanner input = new Scanner(System.in);
    
    System.out.println("This program can compute the factorial of a positive integer.");
    System.out.print("Please enter a number: ");
    
    number = input.nextInt();
    
    // Check if input is good and only compute the factorial if the input is good.
    if (number < 0){
      System.out.println("I cannot compute the factorial of " + number);
    }
    else {
      // initialize values I will use to compute the factorial
      factorial = 1;
      count = 1;
      
      // compute the factorial
      while (count <= number){
        factorial = factorial*count;
        count++;
      }
      
      // Note that the while loop above is the same as the for-loop below
      // you could comment out the loop above and comment out this loop below, to test it
      /*
      for (counter = number; count >= 1; count--){
        factorial = factorial * count;
      }
      */
      
      System.out.println(number + "! is " + factorial);
    }
  }
  
}