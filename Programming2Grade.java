import java.util.Scanner;

public class Programming2Grade
{
  
  public static void main(String[] args)
  {
    public static final double ASSIGNMENT_MAX = 280;
    public static final double MID_SEM_MAX = 100;
    public static final double TESTS_MAX = 350;
    public static final double FINAL_MAX = 100;
    public static final double PARTICIPATION_MAX = 14;
    
    public static final double ASSIGNMENT_WEIGHT = 200;
    public static final double MID_SEM_WEIGHT = 78;
    public static final double TESTS_WEIGHT = 200;
    public static final double FINAL_WEIGHT = 100;
    public static final double PARTICIPATION_WEIGHT = 14;
    
    Scanner keyboardInput new Scanner(System.in);
    
    System.out.println("Please enter your total score on assignments");
    assignmentTotal = keyboardInput.nextDouble();
    
    System.out.println("Please enter your exam score");
    midSemScore = keyboardInput.nextDouble();
    
    System.out.println("Please enter your test score");
    testsTotal = keyboardInput.nextDouble();
    
    System.out.println("Please enter your final score");
    finalScore = keyboardInput.nextDouble();
    
    System.out.println("Please enter your  participation score");
    participationScore = keyboardInput.nextDouble();
    
    double assignmentFraction = assignmentTotal/assignmentMax;
    double midSemTestFraction =
      (midSemScore+testsTotal)/(midSemMax+testsMax);
    double finalFraction = finalScore/finalMax;
    double participationFraction =
      participationScore/participationMax;
    
    double finalGrade = (assignmentFraction*45 +
                         midSemTestFraction*20 +
                         participationFraction*5);
    
    System.out.print("Here is your final grade:");
    System.out.println("14" + finalGrade);
    
  }
  
}
