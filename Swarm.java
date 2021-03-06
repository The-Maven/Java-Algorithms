import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JApplet; 




public class Swarm                        
{
  private static Bug lady[];                    //Instance variables and named constants
  private int count;
  public static final int MAX_BUG = 100;
  Bug b1;
  
  public Swarm()                                //constructor
  {
    lady = new Bug[MAX_BUG];
    count = 0;
  }
  
  public int getCount(){                        //accessor method
    return count;
  }
  
  public void newBug(int x, int y){             //creating a bug
    if (count <= MAX_BUG)
      b1 = new Bug(x, y);
    lady[count]=b1;
    count++;
  }
  
  public void terminate(int delete){            //terminating a bug
    if(lady[delete] == null){
      lady[delete] = lady[count-1];
    lady[count-1] = null;
    }
    else if (lady[delete] != null){
      lady[delete] = null;
    lady[delete] = lady[count-1];
    lady[count-1] = null;
    count--;
    }
  }
  
  public void moveBugs(){                        //move bugs in swarm
    for(int i = 0; i < count; i++){
      lady[i].moveUp();
      if(lady[i].moveUp() == false)
        terminate(i);
    }
  }
  
  public void overlap(int a, int b){             //terminate bugs at specific location
    for(int k = 0; k < count; k++){
      if(lady[k].iClick(a, b) == true)
        terminate(k);
    }
  }
  
  
  public void swarmDisplay(JApplet anApplet, Graphics aCanvas){  //display swarm
    for(int i = 0; i < count; i++){
      if(lady[i] != null)
        lady[i].display(anApplet, aCanvas);
    }
  }
  
  public static void main(String[] args)                //main method to test some functionality
  {
    Swarm newSwarm = new Swarm();
    newSwarm.newBug(0, 20);
    newSwarm.newBug(50, 20);
    newSwarm.newBug(100, 20);
    newSwarm.newBug(150, 20);
    
    newSwarm.overlap(101, 22);
    
    System.out.println(newSwarm.getCount());
    System.out.println(lady[2].getXpos());
  }
}

