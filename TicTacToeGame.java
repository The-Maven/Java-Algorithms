import java.util.Scanner;
public class TicTacToeGame
{
  private static TicTacToeBoard board;          //instance variables
  private TicTacToePlayer player;
  private TicTacToePlayer newPlayer;
  private static TicTacToePlayer currentPlayer;
  private int decision;
  private char yourSymbol;
  private int position;
  
  
  Scanner keyboardInput = new Scanner(System.in);
  public TicTacToeGame(String playerName1, char symbol1, String playerName2, char symbol2)     //constructor
  {
    board =  new TicTacToeBoard();
    player = new TicTacToePlayer(playerName1, symbol1);
    newPlayer = new TicTacToePlayer(playerName2, symbol2);
  }
  
  
  public void play()                                                      //play method
  {
    
    System.out.println("Please enter 1 to play first or 2 to play next");
    decision = keyboardInput.nextInt();
    
    switch (decision) 
    {
      case 1:
        currentPlayer = player;
        break;
        
      case 2:
        currentPlayer = newPlayer;
        break;
        
      default : System.out.println("sorry please enter 1 or 2");
      play();
      break;
      
    }
    
  }
  
  public void letsPlay()                           //main play method
  {
    
    do
    {
      play();
      System.out.println("Please enter the position");
      position = keyboardInput.nextInt();
      System.out.println("Please enter character");
      char yourSymbol = keyboardInput.next().trim().charAt(0);
      System.out.println(currentPlayer.getName() + " " + "play");
      board.enterChar(yourSymbol, position);
      board.print();
      if (board.winner(yourSymbol))
      {
        System.out.println("....");
      }
      else if (board.winner(yourSymbol) == false && board.isBoardFull())
      {
        System.out.println("draw");
      }
    }while(board.winner(yourSymbol));
  }
  
  
  public static void main(String[] args)                   //main method to test play
  {
    
    int newPosition;
    Scanner keyboardInput = new Scanner(System.in);
    TicTacToeGame game = new TicTacToeGame("Percy", 'x', "Luke", 'o');
    
    game.letsPlay();
    
    boolean Full = board.isBoardFull();
    
    if(board.isBoardFull())
    {
      System.out.println("draw");
    }
    else
    {
      game.letsPlay();
    }
    
    
    
    
    
    
  }
}


