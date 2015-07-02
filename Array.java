import java.util.Scanner;
public class Array
{
  
  public static String findLongestMethod(String[] myString)   // class for finding longest string
  {
    String longestString = myString[0];
    
    for(int j = 1; j < myString.length; j++)
    {
      if (myString[j].length() > longestString.length())
        longestString = myString[j];
    }
    return longestString;
  }
  
  public static void main(String[] args)                  // main method
  {
    Scanner input = new Scanner(System.in);
    System.out.println("enter array size");
    int arraySize = input.nextInt();
    String[] myString = new String[arraySize];
    
    System.out.println("enter words");
    
    for (int j = 0; j < myString.length; j++)
    {
      myString[j] = input.nextLine();
    }
    
    String longestString = findLongestMethod(myString);
    System.out.println(" longest string = " + longestString);
  }
}