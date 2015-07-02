
/**
 * A program to test the Date class
 **/
public class TestDate {
 
  public static void main(String[] args){
   
    Date date1 = new Date(7,10,2013);
    Date date2 = new Date(12, 3, 1979);
    
    System.out.println("I have created two dates: " + date1.toString() +
                       " and " + date2.toString());
    
    date1.setMonth(1);
    
    System.out.println("The first date is now " + date1.toString());
  }
}