import java.util.Queue;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;

public class IntelliPuzzle {
  
//  possible results stored in array
  public static String[] possibleResults = {"012345678","123456780"};


// Defining scope of moves using enumerations
  public enum Moves {START, NORTH, SOUTH, WEST, EAST};
  
  
  // protected instance variables

  // let's avoid repeating nodes using this hash map
  protected Map<String,Integer> myMap = new HashMap<String, Integer>(); 
  //variable to keep track of our goal
  protected String arrivedAtGoal = "";
  
  protected Map<String, Moves> edges = new HashMap<String, Moves>();
  
  // store nodes in queue to facilitate breadth-first search
  protected Queue<String> puzzleQueue = new LinkedList<String>();
 
 
  //new string is added to the queuue and hash map using this method
  public void add(String value,int stuff, Moves position){
    if(!myMap.containsKey(value)){
      myMap.put(value,stuff);
      edges.put(value,position);
      puzzleQueue.add(value);
    }
  }
  
 // take state of board as string, move 0(blank space) and add to hashmap and queue where necessary.
 // WEST AND EAST
  protected String west(String value, char moveThis){
    int x = value.indexOf(moveThis);
    if(x!=0 && x!=3 && x!=6){
      String result = value.substring(0,x-1)+moveThis+value.charAt(x-1)+value.substring(x+1);
      return result;
    }
    else
      return value;
  }
  
  protected boolean west(String value, char moveThis, String[] goal){
    String result = west(value, moveThis);
    if (!result.equals(value)){
      add(result,myMap.get(value)+1,Moves.WEST);
      for (int i=0; i<goal.length; i++){
        if(result.equals(goal[i])) {
          arrivedAtGoal = goal[i];
          return true;
        }
      }
    }
    return false;
  }
  
  protected String east(String value, char moveThis){
    int x = value.indexOf(moveThis);
    if(x!=2 && x!=5 && x!=8){
      String result = value.substring(0,x)+value.charAt(x+1)+moveThis+value.substring(x+2);
      return result;
    }
    else 
      return value;
  }
  
  protected boolean east(String value, char moveThis, String[] goal){
    String result = east(value, moveThis);
    if (!result.equals(value)){
      add(result,myMap.get(value)+1,Moves.EAST);
      for (int i=0; i<goal.length; i++){
        if(result.equals(goal[i])) {
          arrivedAtGoal = goal[i];
          return true;
        }
      }
    }
    return false;
  }

  
  //NORTH AND SOUTH
  protected String north(String value, char moveThis) {
    int x = value.indexOf(moveThis);
    if(x>2){
      String result = value.substring(0,x-3)+moveThis+value.substring(x-2,x)+value.charAt(x-3)+value.substring(x+1);
      return result;
    }
    else 
      return value;
  }
  
  protected boolean north(String value, char moveThis, String[] goal){
    String result = north(value, moveThis);
    if (!result.equals(value)){
      add(result,myMap.get(value)+1, Moves.NORTH);
      for (int i=0; i<goal.length; i++){
        if(result.equals(goal[i])) {
          arrivedAtGoal = goal[i];
          return true;
        }
      }
    }
    return false;
  }
  
  protected String south(String value, char moveThis){
    int x = value.indexOf(moveThis);
    if(x<6){
      String result = value.substring(0,x)+value.substring(x+3,x+4)+value.substring(x+1,x+3)+moveThis+value.substring(x+4);
      return result;
    }
    else
      return value;
  }
  
  protected boolean south(String value, char moveThis, String[] goal){
    String result = south(value, moveThis);
    if (!result.equals(value)){
      add(result,myMap.get(value)+1,Moves.SOUTH);
      for (int i=0; i<goal.length; i++){
        if(result.equals(goal[i])) {
          arrivedAtGoal = goal[i];
          return true;
        }
      }
    }
    return false;
  }

  //keeping count of positions
  protected void routeOutline(String form, Moves item, String initialPosition, ArrayList<Moves> steps) {
    String result;
    if (item == Moves.NORTH)
      result = south(form, '0');
    else if (item == Moves.SOUTH)
      result = north(form, '0');
    else if (item == Moves.WEST)
      result = east(form, '0');
    else if (item == Moves.EAST)
      result = west(form, '0');
    else
      result = form;
    
    if (!result.equals(initialPosition))
      routeOutline(result, edges.get(result), initialPosition, steps);
    steps.add(item);
  }
  
    //instructions
    public static String instructions(Moves item) {
    switch (item) {
      case NORTH:
        return "go north";
      case SOUTH:
        return "go south";
      case EAST:
        return "go east";
      case WEST:
        return "go west";
      default:
        return "";
    }
  }
   
}