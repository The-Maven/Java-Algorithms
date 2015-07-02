
public class Vehicle {

  protected static  String manufacturer;
  private int numCylinders;
  private double fuelTankCapacity;
  
  public Vehicle(String theManufacturer, int theCylinders, double theFuelCap){
    manufacturer = theManufacturer;
    numCylinders = theCylinders;
    fuelTankCapacity = theFuelCap;
  }
  
  public String getManufacturer(){
    return manufacturer;
  }
  
  public int getNumCylinders(){
    return numCylinders;
  }
  
  public double getFuelTankCapacity(){
    return fuelTankCapacity;
  }
    
  public void printDetails(){
    System.out.println("Manufacturer: " + manufacturer);
    System.out.println("Cylinders: " + numCylinders);
    System.out.println("Fuel Tank Capacity: " + fuelTankCapacity);
  }
  
  public static void main(String[] args){
    Vehicle v1 = new Vehicle("Toyota", 6, 20);
    Vehicle v2 = new Vehicle("Mazda", 8, 30);
      
    System.out.println("\nVehicle 1 details:");
    v1.printDetails();
    
    System.out.println("\nVehicle 2 details:");
    v2.printDetails();
  }
}