.import java.util.Scanner;
public class TestProblem5
{
  public static void main(String[] args)
  {
    
    Problem5 myCup = new Problem5();                          //instantiating object
    
    int year;
    
    System.out.println("Please enter a year to check if it's a world cup year!");
    Scanner keyboard = new Scanner(System.in);
    year = keyboard.nextInt();                                 // user's year input
    
    if ((year < 1930) || (year >= 1938 && year <= 1950))       // if year is before 1930 or is part of the the gap period
    {
      System.out.println(" Invalid year entry, the world cup did not exist in this period"); // display message and exit
      System.exit(0);
    }
    else
    {
      
      System.out.println(" Hold on a minute");
      
      boolean WorldCup = myCup.isWorldCupYear(year);            // call method to check if it's a world cup year
      if (WorldCup)
        System.out.println(year + " is a world cup year");      // if true display message
      else
        System.out.println(year + " is not a world cup year");  // if false display message
    }
  }
}