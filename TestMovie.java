public class TestMovie
{
  public static void main(String[] args)
  {
    //instantiating an object
    Movie action = new Movie(" Pacific Rim", "PG-13");
    
    //displaying movie name and rating
    System.out.println(" The first movie's name and rating are " + action.getName() + " and " + action.getMpaaRating() + " respectively");
    
    //testing the addrating method
    action.addRating(5);
    action.addRating(5);
    action.addRating(4);
    action.addRating(3);
    
    //display rating
    System.out.printf(" The first movie's rating =...%1.2f",action.getAverage());
    
  }
}