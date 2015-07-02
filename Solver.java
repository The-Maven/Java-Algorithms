import java.util.ArrayList;
public class Solver extends IntelliPuzzle
{
    public static Moves[] solve(String initialPosition, String[] goal) {
    
    IntelliPuzzle smartEight = new IntelliPuzzle();   // New Instance of the EightPuzzle
    
    smartEight.add(initialPosition, 0, Moves.START);        // Add the Initial State
    
    ArrayList<Moves> steps = new ArrayList<Moves>();
    
    boolean arrivedAtGoal = false;
    
    Moves endMove = Moves.START;
    
    
    while(smartEight.puzzleQueue.peek() != null && !arrivedAtGoal){
      
      // Move north
      if (smartEight.north(smartEight.puzzleQueue.peek(), '0', goal)){ 
        endMove = Moves.NORTH;
        arrivedAtGoal = true;
      }
       // Move south
      else if (smartEight.south(smartEight.puzzleQueue.peek(), '0', goal)){ 
        endMove = Moves.SOUTH;
        arrivedAtGoal = true;
      }
          // Move west 
      else if (smartEight.west(smartEight.puzzleQueue.peek(), '0', goal)){ 
        endMove = Moves.WEST;
        arrivedAtGoal = true;
      }
      // Move east
      else if (smartEight.east(smartEight.puzzleQueue.remove(), '0', goal)){    
        endMove = Moves.EAST;
        arrivedAtGoal = true;
      }
    }
    if (arrivedAtGoal){
      smartEight.routeOutline(smartEight.arrivedAtGoal, endMove, initialPosition, steps);
    }
    
    // store steps in array
    Moves[] storage = new Moves[steps.size()];
    for (int i=0; i<steps.size(); i++){
      storage[i] = steps.get(i);
    }
    
    return storage;
  }
}