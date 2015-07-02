public class Grading
{
  
  public static final int A = 80;
  public static final int Bplus = 75;
  public static final int B = 70;
  public static final int Cplus = 65;
  public static final int C = 60;
  public static final int Dplus = 55;
  public static final int D = 50;
  public static final int MAX = 100;
  public static final int MIN = 0;
  
  
  public static String tellGrade(double Grade)
  {
    String finalGrade;
    
     if (Grade < MIN || Grade > MAX)
     {
       finalGrade = "Invalid grade";
     }
     else if (Grade >= A)
     {
     finalGrade = "A";
    }
    else if (Grade >= Bplus)
    {
      finalGrade = "B+";
    }
    else if (Grade >= B)
    {
      finalGrade = "B";
    }
    else if(Grade >= Cplus)
    {
      finalGrade = "C+";
    }
    else if(Grade >= C)
    {
      finalGrade = "C";
    }
    else if(Grade >= Dplus)
    {
      finalGrade = "D+";
    }    
    else if(Grade >= D)
    {
      finalGrade = "D";
    }
    else
    {
      finalGrade = "Fail";
      
  }
    return finalGrade;
}
}