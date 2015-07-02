import java.util.Scanner;

public class palindrome{
  
  
  public static void main(String[] args) {
    
    String userInput;         //initialize variables
    String reversal = "";
    int position;
    int length;
    String decision;
    
    
    System.out.println("Enter word to detect palindrome");  //display output
    
    Scanner keyboard = new Scanner(System.in);       //read inputs
    
    userInput = keyboard.nextLine();
    
    
    length = userInput.length();                     //determine length of input
    
    
    for(position=length-1; position >= 0; position--)       //reverse character positions
      reversal = reversal + userInput.charAt(position);
    
    
    System.out.println(reversal);                          //display reversal 
    if (reversal.equalsIgnoreCase(userInput)){
      System.out.println("This is a Palindrome");
    }
    
    else System.out.println ("This is not a Palindrome");      // display palindrome or not
    
    
  }
  
}
