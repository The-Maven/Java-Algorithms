public class World
{
  public boolean isWorldCupYear(int year)
  {
    return (((year-1930) % 4 ==0));    // the difference between a world cup year and the original year (1930)
                                       //  can be thought of as a multiple of 4
  }
}