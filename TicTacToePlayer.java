public class TicTacToePlayer
{
  private String name;                    //instance variables
  private char symbol;
  
  public TicTacToePlayer(String newName, char newSymbol)            //constructor
  {
    name = newName;
    symbol = newSymbol;
  }
  public String getName()              // accessor methods
  {
    return name;
  }
  public char getSymbol()
  {
    return symbol;
  }
  
}