import java.util.Scanner;

public class TestDecrypt {
  
  public static void main(String[] args) 
  {
    Problem4 myString = new Decrypt();              // creating object
    
    String encryptedString;
    
    System.out.println("Please enter your encrypted String");
    
    Scanner keyboard = new Scanner(System.in);
    encryptedString = keyboard.nextLine();        // taking encrypted input
    
    System.out.println("Please wait ...");
    
    myString.decrypt(encryptedString);            // calling method to decrypt and display
    
    
    
    
    
    
  }
  
}