
/**
 * A class to model a car that can contain people.
 **/
public class Car {
  private Person driver;
  private Person frontSeatPassenger;
  private Person backSeatPassenger1;
  private Person backSeatPassenger2;
  private Person backSeatPassenger3;
  private String licenseNumber;
  private static int numCars;
  public static int MIN_DRIVING_AGE = 18;
  
  // default constructor
  public Car() {
    driver = null;
    frontSeatPassenger = null;
    backSeatPassenger1 = null;
    backSeatPassenger2 = null;
    backSeatPassenger3 = null;
    licenseNumber = "";
    numCars++;
  }
  
  // A constructor
  public Car(Person carsDriver) {
    if (carsDriver.getAge() < MIN_DRIVING_AGE){
      System.err.println("The driver must be 18 or above");
      System.exit(0);
    }
    
    driver = carsDriver;
    frontSeatPassenger = null;
    backSeatPassenger1 = null;
    backSeatPassenger2 = null;
    backSeatPassenger3 = null;
    licenseNumber = "";
    numCars++;
  }
  
  public static int getNumCars()
  {
    return numCars;
  }
    
  // checks whether the car has a driver
  public boolean hasDriver(){
    return driver != null;
  }
  
  // checks whether the car has at least 1 passenger
  public boolean hasPassengers(){
    return (frontSeatPassenger != null ||
            backSeatPassenger1 != null ||
            backSeatPassenger2 != null ||
            backSeatPassenger3 != null);
  }
  
  // checks whether the car is empty
  public boolean isEmpty(){
    return (driver == null && frontSeatPassenger == null &&
            backSeatPassenger1 == null && backSeatPassenger2 == null &&
            backSeatPassenger3 == null);
  }
  
  // checks whether the car is full
  public boolean isFull(){
    return (driver != null && frontSeatPassenger != null &&
            backSeatPassenger1 != null && backSeatPassenger2 != null &&
            backSeatPassenger3 != null);
  }
  
  // set the driver of the car
  public boolean setDriver(Person newDriver){
    if (newDriver.getAge() >= MIN_DRIVING_AGE){
      driver = newDriver;
      return true;
    }
    else
      return false;
  }

  // adds a passenger to the car
  public boolean addPassenger(Person newPassenger){
    if (frontSeatPassenger == null)
      frontSeatPassenger = newPassenger;
    else if (backSeatPassenger1 == null)
      backSeatPassenger1 = newPassenger;
    else if (backSeatPassenger2 == null)
      backSeatPassenger2 = newPassenger;
    else if (backSeatPassenger3 == null)
      backSeatPassenger3 = newPassenger;
    else
      return false; // no space for this passenger - return false
    
    // if we got this far, we didn't return false, which means
    // we successfully found a spot, so return true
    return true;
  }
  
  // determine the number of occupants in the car
  public int getNumOccupants(){
    int numOccupants = 0;
    
    if (driver != null)
      numOccupants++;
    if (frontSeatPassenger != null)
      numOccupants++;
    if (backSeatPassenger1 != null)
      numOccupants++;
    if (backSeatPassenger2 != null)
      numOccupants++;
    if (backSeatPassenger3 != null)
      numOccupants++;
    
    return numOccupants;
  }
  
  // List the riders in the car
  public void listRiders(){
    if (driver != null)
      System.out.println("  Driver: " + driver.getName() + ", "
                           + driver.getAge());
    else
      System.out.println("  No driver.");
    
    if (hasPassengers()){
      System.out.print("  Passengers: ");
     if (frontSeatPassenger != null)
       System.out.println(" " + frontSeatPassenger.getName() + ", "
                           + frontSeatPassenger.getAge() + " (front seat)");
     if (backSeatPassenger1 != null)
       System.out.println("               " + backSeatPassenger1.getName() + ", "
                           + backSeatPassenger1.getAge() + " (back seat)");
     if (backSeatPassenger2 != null)
       System.out.println("               " + backSeatPassenger2.getName() + ", "
                           + backSeatPassenger2.getAge() + " (back seat)");
     if (backSeatPassenger3 != null)
       System.out.println("               "  + backSeatPassenger3.getName() + ", "
                           + backSeatPassenger3.getAge() + " (back seat)");
    }
  }
}