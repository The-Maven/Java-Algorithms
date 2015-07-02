
public class GradingScheme {
  
  // Constants to represent each of the grade thresholds
  public static final int A = 80;
  public static final int BPLUS = 75;
  public static final int B = 70;
  public static final int CPLUS = 65;
  public static final int C = 60;
  public static final int DPLUS = 55;
  public static final int D = 50;
  public static final int MAX = 100;
  public static final int MIN = 0;
  
  // A method to determine the letter grade, given a 
  // numerical grade (in percent).  It returns a letter grade, 
  // or "Invalid" if the grade is >100% or <0%
  public static String getLetterGrade(double grade){
    String letterGrade;
    
    if (grade > MAX || grade < MIN)
      letterGrade = "Invalid";
    else if (grade >= A)
      letterGrade = "A";
    else if (grade >= BPLUS)
      letterGrade = "B+";
    else if (grade >= B)
      letterGrade = "B";
    else if (grade >= CPLUS)
      letterGrade = "C+";
    else if (grade >= C)
      letterGrade = "C";
    else if (grade >= DPLUS)
      letterGrade = "D+";
    else if (grade >= D)
      letterGrade = "D";
    else
      letterGrade = "E";
    
    return letterGrade;
  }
  
  // A test program
  public static void main(String[] args){
    System.out.println("100% is: " + getLetterGrade(100));
    System.out.println("82% is: " + getLetterGrade(82));
    System.out.println("80% is: " + getLetterGrade(80));
    System.out.println("79.99% is: " + getLetterGrade(79.99));
    System.out.println("75% is: " + getLetterGrade(75));
    System.out.println("74.99% is: " + getLetterGrade(74.99));
    System.out.println("70% is: " + getLetterGrade(70));
    System.out.println("69.99% is: " + getLetterGrade(69.99));
    System.out.println("65% is: " + getLetterGrade(65));
    System.out.println("64.99% is: " + getLetterGrade(64.99));
    System.out.println("60% is: " + getLetterGrade(60));
    System.out.println("59.99% is: " + getLetterGrade(59.99));
    System.out.println("55% is: " + getLetterGrade(55));
    System.out.println("54.99% is: " + getLetterGrade(54.99));
    System.out.println("50% is: " + getLetterGrade(50));
    System.out.println("49.99% is: " + getLetterGrade(49.99));
    System.out.println("0% is: " + getLetterGrade(0));
    System.out.println("101% is: " + getLetterGrade(101));
    System.out.println("-3% is: " + getLetterGrade(-3));
  }
}