import java.text.DecimalFormat;

/**
 * A class to represent a date (day, month, and year)
 **/
public class Date {
 
  // instance variables of the class
  private int day;
  private int month;
  private int year;
  
  // a constructor
  public Date(int d, int m, int y) {
    setDate(d, m, y);
  }
  
  // an accessor method for day
  public int getDay(){
    return day;
  }
  
  // an accessor method for month
  public int getMonth(){
    return month;
  }
  
  // an accessor method for year
  public int getYear(){
   return year; 
  }
  
  // A method to return the date formatted as a String
  public String toString(){
    DecimalFormat twoDigitFormat = new DecimalFormat("00");
    DecimalFormat fourDigitFormat = new DecimalFormat("0000");
    return (twoDigitFormat.format(day) + "/" +
            twoDigitFormat.format(month) + "/" +
            fourDigitFormat.format(year));
  }
  
  // a mutator method for day
  public void setDay(int d){
    day = d;
  }
  
  // a mutator method for month
  public void setMonth(int m){
    month = m;
  }
  
  // a mutator method for year
  public void setYear(int y){
    year = y;
  }
  
  // A method to set the date
  public void setDate(int d, int m, int y){
    day = d;
    month = m;
    year = y;
  }
  
}