import java.util.Arrays;
import java.util.Scanner;

/**
 * This is based on the SelectionSortDemo program in 
 * Chapter 7 of the course textbook.
 */
public class SearchingDemo 
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int[] b = {7, 5, 11, 2, 16, 4, 18, 14, 12, 30, 23};
    display(b);
    
    String val;
    int valToSearch, index;
    do {
      System.out.print("Enter a number to search for, or \"end\" to end.");
      val = keyboard.next();
      if (!val.equalsIgnoreCase("end")) {
        valToSearch = Integer.parseInt(val);
        index = sequentialSearch(b, valToSearch);
        if (index >= 0)
          System.out.println(valToSearch + " is at index " + index);
        else
          System.out.println(valToSearch + " is not in the array.");
        
        System.out.println();
      }
    } while (!val.equalsIgnoreCase("end"));
    
    System.out.println("Good bye!");
  }
  
  // A method to display the contents of an array
  public static void display(int[] array)
  {
    System.out.print("Array values:");
    for (int i=0; i<array.length; i++)
      System.out.print(array[i] + " ");
    System.out.println("\n");
  }
  
  // A method that implements Sequential Search to search for a
  // value in any array
  public static int sequentialSearch(int[] array, int value) {
    int index = -1;
    boolean found = false;
    
    System.out.print("Starting sequential search. Checking index ");
    for (int i=0; i<array.length && !found; i++){
      System.out.print(i + "...");
      if (array[i] == value){
        index = i;
        found = true;
      }
    }
    
    if (found)
      System.out.println("Found!");
    else
      System.out.println("Not found.");
    
    return index;
  }
}