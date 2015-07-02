import java.util.Scanner;

/**
 * A program to test the Phone class
 * 7th October 2013 Version
 **/
public class TestPhone {
 
  public static void main(String[] args) {
    
    // Instantiate (i.e. create) three difference phone objects
    // Two of the Phone objects are instantiated using the Phone constructor 
    // that takes in 4 arguments.  The third Phone object is instantiated
    // using the default Phone constructor
    Phone myPhone = new Phone("Samsung","SII","White","Airtel");
    Phone herPhone = new Phone("Apple", "IPhone 4S", "White", "Vodafone");
    Phone hisPhone = new Phone();
        
    Scanner keyboard = new Scanner(System.in);
    
    String ayorkorsPhone = myPhone.getColor() + " " + myPhone.getBrand() + " " + myPhone.getModel();
    System.out.println("Ayorkor's phone is a " + ayorkorsPhone);
    
    System.out.println("Naa Korkoi's phone is a " + herPhone.getColor() + " " + herPhone.getBrand() + 
                       " " + herPhone.getModel());
      
    System.out.println("His phone's color is: " + hisPhone.getColor());
   
    myPhone.setColor("Purple");
    System.out.println("Ayorkor's phone is now a " + myPhone.getColor() + " " + myPhone.getBrand() + " " +
                       myPhone.getModel());
    System.out.println("So far, Ayorkor has made calls for " + myPhone.getNumMinsCalled() + " minutes.");
    
    myPhone.makeCall(12.2);
    myPhone.makeCall(4.0);
 
    System.out.println("Now, Ayorkor has made calls for " + myPhone.getNumMinsCalled() + " minutes.");
    
    myPhone.receiveCall(17.0);
    myPhone.sendSMS(141);
    
    myPhone.listInfo();
    
    // This code will display something like the references (memory addresses) for each of the objects 
    System.out.println("My phone is: " + myPhone);
    System.out.println("Her phone is: " + herPhone);
    System.out.println("His phone is: " + hisPhone);
    
    // Print out the result of testing for equality
    System.out.print("Is myphone the same as herphone? ");
    System.out.println(myPhone.equals(herPhone));
  }
}