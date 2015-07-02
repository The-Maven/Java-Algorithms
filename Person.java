
/**
 * A class to model a person, who has a name and an age.
 **/
public class Person {
  private String name;
  private int age;
  private static int numPersons;
  
  
  
  // default constructor
  public Person(){
    setPerson("No name yet", 0);
    numPersons++;
  }
  
  // constructor that takes a name and an age
  public Person(String n, int a){
    setPerson(n, a);
    numPersons++;
  }
  
  //method to return number of persons
  public static int getNumPersons()
  {
    return numPersons;
  }
  

  //methods to return instances of the class
  public static Person creatAdult()
  {
    Person newAdult = new Person("no adult", 21);
    return newAdult;
  }
  
  public static Person creatToddler()
  {
    Person newToddler = new Person("A toddler", 2);
    return newToddler;
  }
  
  
  // accessor method for name
  public String getName(){
    return name;
  }
  
  // accessor method for age
  public int getAge(){
    return age;
  }
  
  // mutator method for name
  public void setName(String n){
    name = n;
  }
  
  // mutator method for age
  public void setAge(int a){
    if (a < 0){
      System.err.println("Age cannot be negative.");
      System.exit(0);
    }
    else
      age = a;
  }
  
  // method to set both the name and the age
  public void setPerson(String n, int a){
    setName(n);
    setAge(a);
  }
  
  // tests whether this person is equal to another
  public boolean equals(Person otherP){
    return (name.equals(otherP.name) && age == otherP.age);
  }
  
  // tests whether this person has the same name as another
  public boolean hasSameNameAs(Person otherP){
    return name.equals(otherP.name);
  }
  
  // tests whether this person has the same age as another
  public boolean hasSameAgeAs(Person otherP){
    return age == otherP.age;
  }
  
  // tests whether this person is older than another
  public boolean isOlderThan(Person otherP){
    return age > otherP.age;
  }
  
  // tests whether this person is younger than another
  public boolean isYoungerThan(Person otherP){
    return age < otherP.age;
  }
}