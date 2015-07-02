import java.util.Scanner;

/**
 * A program to illustrate some of the functionality of strings.
 * 
 * @author Ayorkor Korsah
 */
public class StringFun
{
  public static void main(String[] args)
  {
    String word, middlePart;
    char firstLetter, lastLetter;
    int length;
    
    Scanner input = new Scanner(System.in);
    System.out.print("Hello.  Give me a word, and I will tell you some things about it. ");
    word = input.next();
    
    length = word.length();
    firstLetter = word.charAt(0);
    lastLetter = word.charAt(length-1);
    
    System.out.println(word + " has " + length + " characters.");
    System.out.print("It starts with " + firstLetter + ", ");
    System.out.println("and ends with " + lastLetter + ".");

    if (length > 2){
      middlePart = word.substring(1, length-1);
      System.out.println("Without the first and last letters, the word is: " +
                         middlePart);
    }
    
    System.out.println("So sorry that I can't tell you its meaning!");
  }
}