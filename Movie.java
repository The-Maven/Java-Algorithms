public class Movie
{
  private String name;
  private String mpaaRating;
  private double terribleRaters;
  private double badRaters;
  private double okRaters;
  private double goodRaters;
  private double greatRaters;
  
  
  public Movie(String newName, String newMpaaRating)
  {
    name = newName;
    mpaaRating = newMpaaRating;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getMpaaRating()
  {
    return mpaaRating;
  }
  
  public void setName(String newName)
  {
    name = newName;
  }
  
  public void setRating(String newMpaaRating)
  {
    mpaaRating = newMpaaRating;
  }
  
  public void addRating( int rating) 
  {
    
    if (rating < 1 || rating > 5)
      System.exit(0);
    
    else if (rating == 1)
    {
      terribleRaters ++;
    }
    else if (rating == 2)
    {
      badRaters ++;
    }
    else if (rating == 3)
    {
      okRaters ++;
    }
    else if (rating == 4)
    {
      goodRaters ++;
    }
    else if (rating == 5)
    {
      greatRaters ++;
    }
    
  }
  
  
  
  
  public double getAverage()
  {
    
    return ((terribleRaters * 1)+ (badRaters * 2) + (okRaters * 3) + (goodRaters * 4) + (greatRaters * 5))/(terribleRaters + badRaters + okRaters + goodRaters + greatRaters);
  }
  
}








