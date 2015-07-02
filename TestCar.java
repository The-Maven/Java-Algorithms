import java.util.Scanner;
import java.util.Random;

public class TestCar {
 
  public static void main(String[] args){
    
    // Test the constructors and the listRiders() method
    Person bob = new Person("Bob", 17);
    Person esi = new Person("Esi", 18);
    Person kofi = new Person("Kofi", 21);
    
    Car toyota = new Car();
    Car mazda = new Car(esi);
    
    System.out.println("Toyota riders:");
    toyota.listRiders();
    
    System.out.println("Mazda riders: ");
    mazda.listRiders();

    // uncomment the following line to set under-age driving
    //Car benz = new Car(bob);
    
    // Test the hasDriver() method
    if (toyota.hasDriver())
      System.out.println("The Toyota has a driver.");
    else
      System.out.println("The Toyota does not have a driver.");
    
    if (mazda.hasDriver())
      System.out.println("The Mazda has a driver.");
    else
      System.out.println("The Mazda does not have a driver.");

    // Test the isEmpty() method
    if (toyota.isEmpty())
      System.out.println("The Toyota is empty.");
    else
      System.out.println("The Toyota is not empty.");
    
    if (mazda.isEmpty())
      System.out.println("The Mazda is empty.");
    else
      System.out.println("The Mazda is not empty.");
    
    // Test the setDriver() method
    if (toyota.setDriver(kofi))
      System.out.println(kofi.getName() + ", " + kofi.getAge() +
                         " now drives the Toyota.");
    else
      System.out.println(kofi.getName() + ", " + kofi.getAge() +
                         " cannot drive the Toyota.");

    if (mazda.setDriver(bob))
      System.out.println(bob.getName() + ", " + bob.getAge() +
                         " now drives the Mazda.");
    else
      System.out.println(bob.getName() + ", " + bob.getAge() +
                         " cannot drive the Mazda.");
    
    // Test the addPassengers method and getNumOccupants
    if (toyota.addPassenger(bob)){
      System.out.print("Added a passenger to the Toyota. ");
      System.out.println("It now has " + toyota.getNumOccupants() + 
                         " occupants, who are: ");
      toyota.listRiders();
    }
    
    // Test the hasPassengers() method
    if (toyota.hasPassengers())
      System.out.println("The Toyota has passengers.");
    else
      System.out.println("The Toyota does not have passengers.");
    
    if (mazda.hasPassengers())
      System.out.println("The Mazda has passengers.");
    else
      System.out.println("The Mazda does not have passengers.");

    // More testing of the addPassengers() method, including a case when
    // it is unsuccessful
    System.out.println("I'm going to try to add 5 passengers to the Mazda, with random ages.");
    Random r = new Random();
    String pName;
    for (int i=0; i<5; i++){
      pName = "Passenger"+i;
      if (mazda.addPassenger(new Person(pName, r.nextInt(40))))
        System.out.println("Successfully added " + pName);
      else
        System.out.println("Could not add " + pName);
    }
    System.out.println("The Mazda now has " + mazda.getNumOccupants() 
                      + " occupants:");
    mazda.listRiders();
    
    // Test the isFull() method
    if (toyota.isFull())
      System.out.println("The Toyota is full.");
    else
      System.out.println("The Toyota is not full.");

    if (mazda.isFull())
      System.out.println("The Mazda is full.");
    else
      System.out.println("The Mazda is not full.");
    
    System.out.println(Car.getNumCars());
  }
}