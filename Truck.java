public class Truck extends Vehicle {
 
  private double loadCapacity;
  private double towingCapacity;
  
  public Truck(String theManufacturer, int theCylinders, double theFuelCap,
               double theLoadCap, double theTowCap){
    super(theManufacturer, theCylinders, theFuelCap);
    
    loadCapacity = theLoadCap;
    towingCapacity = theTowCap;
  }
  
  public double getLoadCapacity(){
    return loadCapacity;
  }
  
  public double getTowingCapacity(){
    return towingCapacity;
  }
  
  public void printDetails(){
    super.printDetails();
    System.out.println("Load capacity: " + loadCapacity);
    System.out.println("Towing capacity: " + towingCapacity);
  }
  
}