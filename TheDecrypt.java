import java.util.Scanner;

public class TheDecrypt {
  
  public static void main(String[] args) {
    
    String userInput;
    String decryptedInput = "";
    char curChar, convertedChar;
    
    Scanner kb = new Scanner(System.in);
    
    System.out.println("Please enter something to decrypt");
    userInput = kb.nextLine();
    
    for(int pos = 0; pos < userInput.length(); pos++){
      curChar = userInput.charAt(pos);
      if (curChar == 'a')                        // a or A should be replaced with z or Z because the characters before
        convertedChar = 'z';                     // them in the ASCII series are not z or Z
      else if (curChar == 'A')
        convertedChar = 'Z';
        else
        convertedChar = (char)(curChar-1);       // move to the preceeding character
      
      
      decryptedInput = decryptedInput + convertedChar;      // store characters in empty string
    }
    
    System.out.println("The decrypted string has a length of " + decryptedInput.length());
    System.out.println("decrypted, we have: " + decryptedInput);
    
  }
  
}