public class TestGrading
{
  public static void main(String[] args)
  {
    System.out.println(" You entered an " + Grading.tellGrade(-20));    // main method to test grades : including extremes and border values
    System.out.println(" You got an " + Grading.tellGrade(90.55));
    System.out.println(" You got an " + Grading.tellGrade(80));
    System.out.println(" You got a " + Grading.tellGrade(77));
    System.out.println(" You got a " + Grading.tellGrade(68));
    System.out.println(" You got a " + Grading.tellGrade(75));
    System.out.println(" You got a " + Grading.tellGrade(60.66));
    System.out.println(" You entered an " + Grading.tellGrade(200));
    System.out.println(" You got a " + Grading.tellGrade(45));
    System.out.println(" You got a " + Grading.tellGrade(50));
    System.out.println(" You got a " + Grading.tellGrade(63.9));
    System.out.println(" You got a " + Grading.tellGrade(63.889));
  }
}

