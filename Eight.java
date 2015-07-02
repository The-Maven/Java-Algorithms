/** Anthony Kafui Kwawu's Eight Puzzle Algorithm*/

import java.awt.Graphics;
import javax.swing.JApplet;
import java.awt.Color;
import java.util.Random;

public class Eight{
  
  private char[][] puzzle;                                       //instance variables
  public static final int ROW = 3;                               //named constants
  public static final int COL = 3;
  public static final int TILE_SIZE = 100;
  private char[] number = {'1','2','3','4','5','6','7','8',' '};
  private int start = 0;
  private int a,b,r,s;
  private String letters = "";
  private boolean isPossible;                                    //initializing variables
  Random r1 = new Random();                                      // random number generator
  
  
  public Eight(){                                                //default constructor
    puzzle = new char[ROW][COL];
    this.testBoard();
    for(int b = 0; b < number.length; b++){
      if(number[b] == '0')
      {
        number[b] = ' ';
      }
    }
    this.fillArray();
  }
  
  public void fillArray(){                                        //method to fill array
    for(int x = 0; x < ROW; x++){
      for (int y = 0; y < COL; y++){
        puzzle[x][y] = number[start];
        start++;
        
      }
    }
  }
  
  public void shuffle(char[] array){               //The Fisher - Yates shuffling algorithm
    int index;
    char temp;
    for (int i = number.length - 1; i > 0; i--){
      index = r1.nextInt(i + 1);
      temp = array[index];
      array[index] = array[i];
      array[i] = temp;
    }
  }
  
  public void testBoard(){                                          // method to produce solvable puzzle
    isPossible = EightPuzzleSolver.isSolvable(this.realShuffle());
    do{
      this.shuffle(number);
    }while(isPossible == false);
  }
  
  public void arraySwap (int i, int j){                              //swap array indices method
    if (i-1 >= 0 && puzzle[i-1][j] == ' '){
      puzzle[i-1][j] = puzzle[i][j] ;
      puzzle[i][j] = ' ';}
    else if(i+1 < 3 && puzzle[i+1][j] == ' '){
      puzzle[i+1][j] = puzzle[i][j];
      puzzle[i][j] = ' ';}
    else if(j-1 >= 0 && puzzle[i][j-1] == ' '){
      puzzle[i][j-1] = puzzle[i][j];
      puzzle[i][j] = ' ';}
    else if(j+1 < 3 && puzzle[i][j+1] == ' '){
      puzzle[i][j+1] = puzzle[i][j];
      puzzle[i][j] = ' ';}
    
  }
  
  public boolean winner(){                                           //method to declare winner
    return (((puzzle[0][0] == '1')
               && (puzzle[0][1] == '2')
               && (puzzle[0][2] =='3')
               && (puzzle[1][0] == '4')
               && (puzzle[1][1] == '5')
               && (puzzle[1][2] == '6')
               && (puzzle[2][0] == '7')
               && (puzzle[2][1] == '8')
               && (puzzle[2][2] == ' ')) || ((puzzle[0][0] == ' ')
                                               && (puzzle[0][1] == '1')
                                               && (puzzle[0][2] =='2')
                                               && (puzzle[1][0] == '3')
                                               && (puzzle[1][1] == '4')
                                               && (puzzle[1][2] == '5')
                                               && (puzzle[2][0] == '5')
                                               && (puzzle[2][1] == '7')
                                               && (puzzle[2][2] == '8')));
  }
  
  
  public String realShuffle(){                                     //mehod returning the string equivalent of the array elements
    for(int b = 0; b < number.length; b++){
      if(number[b] == ' ')
      {
        number[b] = '0';
      }
      letters = letters + number[b];
    }
    return letters;
  }
  
  
  
  
  public char getIndex(int i, int j){                              // accessor methods of 2d array elements
    return puzzle[i][j];
  }
  
  public void print(){                                            // method to test printing
    for (int x = 0; x < ROW; x++){
      for (int y =0; y < COL; y++)
        System.out.print(puzzle[x][y] + "\t");{
        System.out.println();
      }
    }
  }
  
  public void move(int r, int s){                                 //method to facilitate moving of tiles
    if((r>0 && r<100) && (s>0 && s<100))
      this.arraySwap(0,0);
    else if((r>100 && r<200) && (s>0 && s<100))
      this.arraySwap(0,1);
    else if((r>200 && r<300) && (s>0 && s<100))
      this.arraySwap(0,2);
    else if((r>0 && r<100) && (s>100 && s<200))
      this.arraySwap(1,0);
    else if((r>100 && r<200) && (s>100 && s<200))
      this.arraySwap(1,1);
    else if((r>200 && r<300) && (s>100 && s<200))
      this.arraySwap(1,2);
    else if((r>0 && r<100) && (s>200 && s<300))
      this.arraySwap(2,0);
    else if((r>100 && r<200) && (s>200 && s<300))
      this.arraySwap(2,1);
    else if((r>200 && r<300) && (s>200 && s<300))
      this.arraySwap(2,2);
    
  }
  
  public void display(JApplet myApplet, Graphics canvas){          //mehod to display applet
    for ( int x = 0;  x < ROW;  x++ ) {
      for ( int y = 0;  y < COL;  y++) {
        
        a = x * TILE_SIZE;
        b = y * TILE_SIZE;
        
        canvas.setColor(Color.yellow);
        
        canvas.fillRect(b, a, TILE_SIZE, TILE_SIZE);
        
        canvas.setColor(Color.black);
        canvas.drawRect(b, a, TILE_SIZE, TILE_SIZE);
        
        if(puzzle[x][y] == ' '){
          canvas.setColor(Color.gray);
          canvas.fillRect(y*TILE_SIZE,x*TILE_SIZE,TILE_SIZE,TILE_SIZE);
        }
        
        
        canvas.drawString(""+puzzle[0][0], 50, 50);
        canvas.drawString(""+puzzle[1][0], 50, 150);
        canvas.drawString(""+puzzle[2][0], 50, 250);
        canvas.drawString(""+puzzle[0][1], 150, 50);
        canvas.drawString(""+puzzle[1][1], 150, 150);
        canvas.drawString(""+puzzle[2][1], 150, 250);
        canvas.drawString(""+puzzle[0][2], 250, 50);
        canvas.drawString(""+puzzle[1][2], 250, 150);
        canvas.drawString(""+puzzle[2][2], 250, 250);
        
      }
    }
  }
  public static void main(String[] args){  // main method to test some of the methods
    Eight newPuzzle = new Eight();
    
    /**newPuzzle.print();
      System.out.println(newPuzzle.getIndex(1,0));
      System.out.println(newPuzzle.realShuffle());
      String solution = newPuzzle.realShuffle();
      
      boolean isPossible = EightPuzzleSolver.isSolvable(solution);
      if (isPossible)
      System.out.println("Puzzle sovable!");
      
      //newPuzzle.arraySwap(1,2);
      newPuzzle.print();
      System.out.println(solution);*/
    newPuzzle.testBoard();
    newPuzzle.print();
    
    
    
  }
}


