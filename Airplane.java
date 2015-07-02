public class Airplane extends Vehicle
{
  private static double wingSpan;
  private int engines;
  
  public Airplane(String theManufacturer, int theCylinders, double theFuelCap, double theWingSpan, int theEngines)
  {
    super(theManufacturer, theCylinders, theFuelCap);
    wingSpan = theWingSpan;
    engines = theEngines;
  }
  
  public double getWingSpan()
  {
    return wingSpan;
  }
  
  public int getEngines()
  {
    return engines;
  }
  
  
  public void printDetails()
  {
    super.printDetails();
    System.out.println("Wing Span: " + wingSpan);
    System.out.println("Engines: " + engines);
  }
    public static void main(String[] args)
    {
      
    Airplane Boeing = new Airplane("Boeing", 3, 56.7, 4.5, 6);
    Airplane LearJet = new Airplane("Stark", 4, 45, 34.64, 2);
      
   System.out.println(" This vehicle's manufacturer is " + Boeing.getManufacturer() + " its wing span is " +  wingSpan);
    }
}
  