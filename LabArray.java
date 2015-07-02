import java.util.Scanner;
public class LabArray
{
  public static void main(String[] args)
  {
    double expenses[] = new double[10];
    
    Scanner input = new Scanner(System.in);
    System.out.println(" Please enter 10 cedi values");
    
    for(int k = 0; k < expenses.length; k++)
    {
      expenses[k] = input.nextDouble();
    }
    
    
    int sum = 0;
    for(int x = 0; x < expenses.length; x++)
    {
      System.out.println("Element = " + expenses[x]);
      sum += expenses[x];
    }
    
    System.out.println(" sum of array elements =" + sum);
    
  }
}
