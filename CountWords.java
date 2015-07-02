
import java.util.Scanner;

/**
 * This is a program that attempts to count the number of words in a sentence.
 * This version has problems because it just counts the number of whitespace
 * characters (plus one if a word ends the input).  It thus does not work
 * if the user enters multiple spaces between the words.
 * See CountWords2.java and CountWords3.java for improved versions.
 * 
 * @author G. Ayorkor Korsah
 */
public class CountWords
{
  public static void main(String[] args)
  {
    String userInput;
    int length, position, numWords;
    char currentChar;
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("Write a sentence or a paragraph, and I'll tell you " +
                       "how many words it has.");
    userInput = keyboard.nextLine();
    length = userInput.length();
    
    position = 0;
    numWords = 0;
    while(position < length){
      currentChar = userInput.charAt(position);
      
      if (Character.isWhitespace(currentChar)){
          numWords++;
      }
      else if (position == length-1){
        numWords++;
      }      
      
      position++;
    }
    System.out.println("The sentence you entered has " + numWords + " words.");
  }
}