import java.util.Scanner;

public class CurrencyConverter{
  
  public static final String YES = "y";
  public static final String NO = "n";
  
  
  public static void main(String[] args) {
    
    //initialize variables
    int digit;
    double cediEquivalent;
    String decision;
    double newValue;
    
    
    do{ //start loop
      System.out.println("This program can change Ghana cedis to dollars, naira or shilling");
      System.out.println("Enter 1 to change cedi to dollar");  //screen output
      System.out.println("2 to change cedi to Naira");
      System.out.println("3 to change cedi to shilling");
      
      Scanner keyboardInput = new Scanner(System.in);         //read input
      digit = keyboardInput.nextInt();
      
      
      switch (digit) {                                       //begin switch statements
        case 1:
          System.out.println("Now enter money in cedis");
          cediEquivalent = keyboardInput.nextDouble();
          newValue = cediEquivalent * 0.4614; 
          System.out.printf("Your money is worth...%1.2f dollars",newValue);
          break;
          
        case 2:
          System.out.println("Now enter money in cedis");
          cediEquivalent = keyboardInput.nextDouble();
          newValue = cediEquivalent *81.1808;
          System.out.printf("Your money is worth...%1.2f naira",newValue);
          break;
          
        case 3:
          System.out.println("Now enter money in cedis");
          cediEquivalent = keyboardInput.nextDouble();
          newValue = cediEquivalent * 43.7653;
          System.out.printf("Your money is worth ...%1.2f Shilling",newValue);
          break;
          
        default : System.out.println("sorry please try again");    //discard wrong inputs
        break;
      }
      
      System.out.println(" . Do you want to convert again? " + "y/n");  // loop?
      decision = keyboardInput.next();
      
    }
    while(decision.equalsIgnoreCase(YES));          
  }
}