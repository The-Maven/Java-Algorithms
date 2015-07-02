
import java.util.Scanner;
public class Problem4
{ 
  public String decrypt(String encryptedString)
  {
    String decryptedString = "";                               //empty string to store the new characters
    char character, newCharacter = 'k';
    int length = encryptedString.length();
    
    for(int pos = 0; pos < length; pos++)  // for loop that starts at index 0
    {  
      character = encryptedString.charAt(pos);
      if (character == 'a')                        // a or A should be replaced with z or Z because the characters before
        newCharacter = 'z';                     // them in the ASCII series are not z or Z
      else if (character == 'A')
        newCharacter = 'Z';
      else
        newCharacter = (char)(character-1);       // move to the preceeding character
      
      decryptedString = decryptedString + newCharacter;  // adding decrypted characters to empty string
    }
    
    System.out.println("The decrypted String is: " + decryptedString); // display and return String
    
    return decryptedString;
  }
  
  public static void main(String[] args)          // main program
  {
    Problem4 myString = new Problem4();              // instantiating object
    
    String encryptedString;
    
    System.out.println("Please enter your encrypted String");
    
    Scanner keyboard = new Scanner(System.in);
    encryptedString = keyboard.nextLine();        // taking encrypted input
    
    System.out.println("Please wait ...");
    
    myString.decrypt(encryptedString);            // calling method to decrypt and display
  }
}













