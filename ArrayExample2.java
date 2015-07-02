import java.util.Scanner;

public class ArrayExample2 {
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    // Create and populate an array
    int[] numbers = {3, 5, 8, -2, 4, 9, -8};
        
    System.out.println("The array's length is: " + numbers.length);
    
    // Print out the numbers:
    printArray(numbers);
    
    // Sum the numbers:
    int sum = ArrayExample2.sumArray(numbers);
    System.out.println("The sum of the numbers is: " + sum);
    
    // Find the smallest number:
    int smallestNumber = findSmallest(numbers);
    System.out.println("Smallest number: " +
                       smallestNumber);
    
    // Find the largest number:
    int largestNumber = findLargest(numbers);
    System.out.println("Largest number: " +
                       largestNumber);
    
    // Search for a specific number
    System.out.println("Enter a number to search for: ");
    int numToSearch = input.nextInt();
    int foundIndex = find(numbers, numToSearch);
    if (foundIndex == -1)
      System.out.println(numToSearch + " is not in the array.");
    else
      System.out.println(numToSearch + " is at index " + foundIndex); 
  }
  
  // a helper method to print the array
  public static void printArray(int[] array){
    System.out.println("The numbers in the array are: ");
    for (int i=0; i<array.length; i++){
      System.out.print(array[i] + " ");
    }
    System.out.println();
    
  }
  
  // a helper method to sum the elements of the array
  public static int sumArray(int[] array){
    int sum = 0;
    for (int i=0; i<array.length; i++){
      sum += array[i];
    }
    return sum;
  }
  
  // a helper method to find the smallest element in the array
  public static int findSmallest(int[] array){
    int smallest = array[0];
    for (int i=1; i<array.length; i++){
      if (array[i] < smallest)
        smallest = array[i];
    }
    return smallest;
  }    
  
  // a helper method to find the largest element in the array
  public static int findLargest(int[] array){
    int largest = array[0];
    for (int i=1; i<array.length; i++){
      if (array[i] > largest)
        largest = array[i];
    }    
    return largest;
  }
  
  // a helper method to find a specific element in the array
  public static int find(int[] array, int numToFind){
    int foundIndex = -1;
    
    // Search for a specific number:
    for (int i=0; i<array.length; i++){
      if (array[i] == numToFind)
        foundIndex = i;
    }    
    return foundIndex;
  }
}