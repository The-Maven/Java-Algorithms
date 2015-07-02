public class TicTacToeBoard
{
  private char[][] symbol;
  private int pos;
  private int a;
  private int b;
  private int slot;
  private char yourChar;
  
  public TicTacToeBoard()                              //creating multi-dimensional array
  {
    symbol = new char [3][3];
    for (int x = 0; x < 3; x++)
    {
      for (int y = 0; y < 3; y++)
      {
        pos = x*3+y;
        symbol[x][y] = (char)('0'+ pos);
      }
    }
  }
  public int getSlot(int newSlot)
  {
    slot = newSlot;
    return slot;
  }
  
  public void print()                         //printing board
  {   
    for (int x = 0; x < 3; x++)
      
    {
      for (int y =0; y < 3; y++)
        System.out.print(symbol[x][y] + "\t");
      {
        System.out.println();
      }
    }
  }
  
  
  public boolean isSlotFree(int slot)                    //checking if slot is free
  {
    a = 0;
    b = 0;
    
    
    if (slot >=0 && slot <= 8)
    {
      
      a = (slot)/3;
      b = (slot)%3;
      pos = a * 3 + b;
    }
    else
    {
      System.exit(0);
    }  
    return (symbol[a][b] == (char)('0' + pos));
  }
  
  public boolean enterChar(char yourChar, int slot)                    //entering characters
  {
    if (isSlotFree(slot))
    {
      symbol[a][b] = yourChar;
    }
    else
    {
      return false;
    }
    return true;
    
  }
  
  public boolean winner(char yourChar)                   // checking winner
  {
    if  (((symbol[0][0] == yourChar) && (symbol[1][1] == yourChar) && (symbol[2][2] == yourChar)) ||
         ((symbol[0][2] == yourChar) && (symbol[1][1] == yourChar) && (symbol[2][0]== yourChar)) ||
         ((symbol[0][0] == yourChar) && (symbol[1][0] == yourChar) && (symbol[2][0]== yourChar)) ||
         ((symbol[0][0] == yourChar) && (symbol[1][0] == yourChar) && (symbol[2][0]== yourChar)) ||
         ((symbol[0][1] == yourChar) && (symbol[1][1] == yourChar) && (symbol[2][1]== yourChar)) ||
         ((symbol[0][2] == yourChar) && (symbol[1][2] == yourChar) && (symbol[2][2]== yourChar)) ||
         ((symbol[0][0] == yourChar) && (symbol[0][1] == yourChar) && (symbol[0][2]== yourChar)) ||
         ((symbol[1][0] == yourChar) && (symbol[1][1] == yourChar) && (symbol[1][2]== yourChar)) ||
         ((symbol[2][0] == yourChar) && (symbol[2][1] == yourChar) && (symbol[2][2]== yourChar)))
      
    {
      System.out.println("Winner!");
      System.exit(0);
    }
    else
    {
      System.out.println("not there yet");
    }
    return true;
  }
  
  public boolean isBoardFull()                                   // checking if board is Full
  {
    int x = 0;
    int y = 0;
    for (x = 0; x < 3; x++)
    {
      for (y = 0; y < 3; y++)
      {
        pos = x*3+y;
        
      }
    }
    
    return (symbol[x][y] != (char)('0'+ pos)); 
  }
  
  
  
  
  
  
  
  
  
  
  public static void main(String[] args)                      // testing methods
  {
    TicTacToeBoard tick = new TicTacToeBoard();
    tick.print();
    boolean freedom = tick.isSlotFree(2);
    if (freedom)
    {
      System.out.println("Slot is Free");
    }
    else
    {
      System.out.println(" full");
    }
    
    
    boolean play = tick.enterChar('x', 0);
    if (play)
    {
      System.out.println(" position 5 now contains x");
    }
    else
    {
      System.out.println(" operation unsuccessful");
    }
    tick.print();
    
    boolean newPlay = tick.enterChar('x', 4);
    if (newPlay)
    {
      System.out.println(" position 2 now contains x");
    }
    else
    {
      System.out.println(" operation unsuccessful");
    }
    boolean anotherPlay = tick.enterChar('x', 8);
    if (anotherPlay)
    {
      System.out.println(" position 8 now contains x");
    }
    else
    {
      System.out.println(" operation unsuccessful");
    }
    tick.print();
    tick.winner('x');
    
  }
}



