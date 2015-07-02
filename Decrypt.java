public class Decrypt
{ 
  public String decrypt(String encryptedString)
  {
    String decryptedInput = "";                               //empty string to store the new characters
    char character, newCharacter = 'k';
    
    for(int pos = 0; pos < encryptedString.length(); pos++)  // for loop that starts at index 0
    {  
      character = encryptedString.charAt(pos);
      if (character == 'a')                        // a or A should be replaced with z or Z because the characters before
        newCharacter = 'z';                     // them in the ASCII series are not z or Z
      else if (character == 'A')
        newCharacter = 'Z';
      else
        newCharacter = (char)(character-1);       // move to the preceeding character
      
      decryptedInput = decryptedInput + newCharacter;
    }
    
     System.out.println("The decrypted String is: " + decryptedInput); 
     
     return decryptedInput;
  }
}