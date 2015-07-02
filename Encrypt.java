import java.util.Scanner;

public class Encrypt {
 
  public static void main(String[] args) {
  
    String userInput;
    String encryptedInput = "";
    char curChar, convertedChar;
    
    Scanner kb = new Scanner(System.in);
    
    System.out.println("Please enter something to encrypt");
    userInput = kb.nextLine();
    
    for(int pos = 0; pos < userInput.length(); pos++){
      curChar = userInput.charAt(pos);
      convertedChar = (char)(curChar+1);
      
      encryptedInput = encryptedInput + convertedChar;      
    }
    
    System.out.println("The encrypted string has a length of " + encryptedInput.length());
    System.out.println("Encrypted, we have: " + encryptedInput);
    
  }
  
}