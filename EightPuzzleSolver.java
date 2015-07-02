import java.util.ArrayList;
import java.util.Queue;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;

class EightPuzzleSolver {
  
  // An enumeration for the actions
  public enum Action {START, UP, DOWN, LEFT, RIGHT};
  
  // An array listing the possible solutions
  public static String[] SOLUTIONS = {"012345678","123456780"};
  
  public static final int PUZZLE_SIZE = 3;
  
  // private instance variables
  private Queue<String> q = new LinkedList<String>();    // Use of Queue Implemented using LinkedList for Storing All the Nodes in BFS.
  private Map<String,Integer> map = new HashMap<String, Integer>(); // HashMap is used to ignore repeated nodes
  private Map<String, Action> actions = new HashMap<String, Action>();
  private int numTraces = 0;
  private String foundSolution = "";
  
  /**
   * This program solves an 8-Puzzle, given a single command-line parameter representing
   * the current state of the board.  
   * Program usage:
   *     java EightPuzzle [board state]
   * The state of the board is an ordered arrangement of the numbers in the puzzle,
   * with the blank space represented by 0.  For example, the board state:
   *      3   1
   *      2 4 5
   *      6 7 8
   * Is represented by the string 301245678.
   **/
  public static void main(String args[]){
   
    if (args.length < 1){
      System.out.println("Missing command-line parameter.");
      System.out.print("This program expects a command-line parameter,"
                           + " representing the current board state ");
      System.out.println("as a string, and with 0 representing a blank space.");
      System.out.println();
      System.out.println("Example of how to run the program from the command line:");
      System.out.println("java EightPuzzleSolver 301245678");
      System.out.println();
      System.out.println("Example of how to run the program from within the DrJava environment:");
      System.out.println("run EightPuzzleSolver 301245678");
      System.out.println();
    }
    
    else {
      String curState = args[0];
    
      if (isSolvable(curState)) {
        Action[] actionList =  solve(curState, SOLUTIONS);
        String message = "Here are the instructions for solving the puzzle:\n";
      
        // print out the steps
        for (int i=0; i<actionList.length; i++)
          message += ("\n" + i + ") Click on the tile " +  getDescription(actionList[i]) + 
                      " the space.");
        
        System.out.println(message);
      }
      else {
        System.out.println("This puzzle is not solvable.");
      }
    }
  }
  
  /**
   * This method returns true if the puzzle is solvable and false otherwise 
   */
  public static boolean isSolvable(String strRepOfPuzzle){ 
    int inversions = 0, taxiCab = 0;     
    int maxNum = PUZZLE_SIZE*PUZZLE_SIZE-1;          
    
    for (int i=0; i<maxNum; i++){      
      for (int j=i+1; j<=maxNum; j++){    
        if (strRepOfPuzzle.charAt(i) > strRepOfPuzzle.charAt(j))    
          inversions++;      
      }  
    }     
    
    int pos = strRepOfPuzzle.indexOf('0');     
    int row = pos/PUZZLE_SIZE;    
    int col = pos%PUZZLE_SIZE;    
    taxiCab = row+col;      
    
    return (inversions + taxiCab)%2 == 0;   
  } 
  
  /**
   * This method returns true if the puzzle is solvable and false otherwise 
   */
  public static Action[] solve(String startState, String[] solution) {
    EightPuzzleSolver e = new EightPuzzleSolver();   // New Instance of the EightPuzzle
    e.add(startState, 0, Action.START);        // Add the Initial State
    Action finalAction = Action.START;
    boolean foundSolution = false;
    ArrayList<Action> actionList = new ArrayList<Action>();
    
    int iters = 0;
    while(e.q.peek()!=null && !foundSolution){
      
      if (e.up(e.q.peek(), '0', solution)){     // Move the blank space up and add new state to queue
        finalAction = Action.UP;
        foundSolution = true;
      }
      else if (e.down(e.q.peek(), '0', solution)){     // Move the blank space down
        finalAction = Action.DOWN;
        foundSolution = true;
      }
      else if (e.left(e.q.peek(), '0', solution)){     // Move left 
        finalAction = Action.LEFT;
        foundSolution = true;
      }
      else if (e.right(e.q.remove(), '0', solution)){    // Move right and remove the current node from Queue
        finalAction = Action.RIGHT;
        foundSolution = true;
      }
      iters++;
    }
    if (foundSolution){
      e.trace(e.foundSolution, finalAction, startState, actionList);
    }
    
    // put it in an array
    Action[] actionListArray = new Action[actionList.size()];
    for (int i=0; i<actionList.size(); i++){
      actionListArray[i] = actionList.get(i);
    }
    
    return actionListArray;
  }
  
  public static String getDescription(Action a) {
    switch (a) {
      case UP:
        return "ABOVE";
      case DOWN:
        return "BELOW";
      case RIGHT:
        return "to the RIGHT of";
      case LEFT:
        return "to the LEFT of";
      default:
        return "";
    }
  }
  
    
  private static int computeParity(String state){
    int parity = 0;
    for (int i=0; i<8; i++){
      for (int j=i+1; j<=8; j++){
        if (state.charAt(i) > state.charAt(j))
          parity++;
      }
    }
    return parity;
  }
  
  private static int computeTaxiCabUL(String state, char c, 
                                      int rows, int cols){
    int pos = state.indexOf(c);
    int row = pos/cols;
    int col = pos%cols;
    return (row+col);
  }
  
  private static int computeTaxiCabLR(String state, char c, int rows, int cols){
    int pos = state.indexOf(c);
    int row = pos/cols;
    int col = pos%cols;
    return ((rows-row)+(cols-col));    
  }

  //Add method to add the new string to the Map and Queue
  private void add(String str,int n, Action a){
    if(!map.containsKey(str)){
      map.put(str,n);
      actions.put(str,a);
      q.add(str);
    }
  }
  
  /* Each of the Methods below Takes the Current State of Board as String. Then the operation to move the blank space is done if possible.
   After that the new string is added to the map and queue.If it is the Goal State then the Program Terminates.
   */
  private String up(String str, char charToMove) {
    int a = str.indexOf(charToMove);
    if(a>2){
      String s = str.substring(0,a-3)+charToMove+str.substring(a-2,a)+str.charAt(a-3)+str.substring(a+1);
      return s;
    }
    else 
      return str;
  }
  
  private boolean up(String str, char charToMove, String[] solution){
    String s = up(str, charToMove);
    if (!s.equals(str)){
      add(s,map.get(str)+1, Action.UP);
      for (int i=0; i<solution.length; i++){
        if(s.equals(solution[i])) {
          //System.out.println("Solution Exists at Level "+map.get(s)+" of the tree, after moving the space UP");
          foundSolution = solution[i];
          return true;
        }
      }
    }
    return false;
  }
  
  private String down(String str, char charToMove){
    int a = str.indexOf(charToMove);
    if(a<6){
      String s = str.substring(0,a)+str.substring(a+3,a+4)+str.substring(a+1,a+3)+charToMove+str.substring(a+4);
      return s;
    }
    else
      return str;
  }
  
  private boolean down(String str, char charToMove, String[] solution){
    String s = down(str, charToMove);
    if (!s.equals(str)){
      add(s,map.get(str)+1,Action.DOWN);
      for (int i=0; i<solution.length; i++){
        if(s.equals(solution[i])) {
          //System.out.println("Solution Exists at Level "+map.get(s)+" of the tree, after moving the space DOWN");
          foundSolution = solution[i];
          return true;
        }
      }
    }
    return false;
  }
  
  private String left(String str, char charToMove){
    int a = str.indexOf(charToMove);
    if(a!=0 && a!=3 && a!=6){
      String s = str.substring(0,a-1)+charToMove+str.charAt(a-1)+str.substring(a+1);
      return s;
    }
    else
      return str;
  }
  
  private boolean left(String str, char charToMove, String[] solution){
    String s = left(str, charToMove);
    if (!s.equals(str)){
      add(s,map.get(str)+1,Action.LEFT);
      for (int i=0; i<solution.length; i++){
        if(s.equals(solution[i])) {
          //System.out.println("Solution Exists at Level "+map.get(s)+" of the tree, after moving the space LEFT");
          foundSolution = solution[i];
          return true;
        }
      }
    }
    return false;
  }
  
  private String right(String str, char charToMove){
    int a = str.indexOf(charToMove);
    if(a!=2 && a!=5 && a!=8){
      String s = str.substring(0,a)+str.charAt(a+1)+charToMove+str.substring(a+2);
      return s;
    }
    else 
      return str;
  }
  
  private boolean right(String str, char charToMove, String[] solution){
    String s = right(str, charToMove);
    if (!s.equals(str)){
      add(s,map.get(str)+1,Action.RIGHT);
      for (int i=0; i<solution.length; i++){
        if(s.equals(solution[i])) {
          //System.out.println("Solution Exists at Level "+map.get(s)+" of the tree, after moving the space RIGHT");
          foundSolution = solution[i];
          return true;
        }
      }
    }
    return false;
  }
  
  private void trace(String state, Action a, String startState, ArrayList<Action> actionList) {
    String s;
    if (a == Action.UP)
      s = down(state, '0');
    else if (a == Action.DOWN)
      s = up(state, '0');
    else if (a == Action.LEFT)
      s = right(state, '0');
    else if (a == Action.RIGHT)
      s = left(state, '0');
    else
      s = state;
    
    if (!s.equals(startState))
      trace(s, actions.get(s), startState, actionList);
    actionList.add(a);
  }
}