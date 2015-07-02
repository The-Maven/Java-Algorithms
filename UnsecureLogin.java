
import java.util.Scanner;

public class UnsecureLogin
{
  public static final String USERNAME = "ayorkor";
  public static final String PASSWORD = "he11o_!";
  
  public static void main(String[] args)
  {
    String username, password;
    Scanner input = new Scanner(System.in);
    
    System.out.print("Please enter your username: ");
    username = input.next();

    System.out.print("Please enter your password: ");
    password = input.next();

    if (!username.equalsIgnoreCase(USERNAME)){
      System.out.println("Sorry, that username is unknown. Bye!");
    }
    else if (!password.equals(PASSWORD)){
        System.out.println("Sorry, incorrect password. Bye!");
    }
    else {
      System.out.println("Correct login.  Welcome.");
    }
  }
}