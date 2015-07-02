
/**
 * This is a class to represent an arbitrary thing (e.g. a cup,
 * a balloon, a key, etc) by specifying its color and name.
 * It is meant to illustrate the use of a constructor, accessor and mutator
 * methods, and the equals method.
 * 
 * @author G. Ayorkor Korsah
 */
public class Thing
{
  private String color;
  private String name;
  private static int numThingsCreated = 0;

  public Thing(){
    this("No color specified", "No name yet");
  }
  
  public Thing(String name){
    this("No color specified", name);
  }
  
  public Thing(String myColor, String myName){
    setColor(myColor);
    setName(myName);
    numThingsCreated++;
  }
  
  public static int getNumThingsCreated()
  {
    return numThingsCreated;
  }
  
  public static Thing createSpecialThing(){
    Thing specialThing = new Thing("No color", "Special Thing");
    return specialThing;
  }
  
  public String getName() {
    return name;
  }
  
  public String getColor() {
    return color;
  }
  
  public void setName(String newName) {
    name = newName;
  }
  
  public void setColor(String newColor) {
    color = newColor;
  }
  
  public String getDescription(){
    return color + " " + name;
  }
  
  public void describe(){
    String description = getDescription();
    System.out.println("This is a " + description);
  }
  
  public boolean equals(Thing otherThing){
    boolean isEqual = (this.name.equals(otherThing.name) &&
                       this.color.equals(otherThing.color));
    return isEqual;
  }
  
  public String toString() {
    return (color + " " + name);
  }
  
  public static void main(String[] args) {
    Thing thing1 = new Thing("blue", "bottle");
    Thing thing2 = new Thing("computer");
    Thing thing3 = new Thing();
    
    System.out.println(thing1.getDescription());
    System.out.println(thing2.getDescription());
    System.out.println(thing3.getDescription());
    
    System.out.println();
    thing1.describe();
    thing2.describe();
    thing3.describe();
    
  }
  
}