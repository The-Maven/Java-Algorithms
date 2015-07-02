import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JApplet; 

public class Bug 
{
  private  int Xpos;
  private  int Ypos;
  public static Image newBug;
  public static final int IMAGE_HEIGHT = 54;
  public static final int IMAGE_WIDTH = 49;
  public static final int BUG_SPEED = 2;
  
  public Bug(int newXpos, int newYpos)     //constructor
  {
    Xpos = newXpos;
    Ypos = newYpos;
  }
  public  int getXpos()                    //accessor methods
  {
    return Xpos;
  }
  public int getYpos()
  {
    return Ypos;
  }
  
  public boolean moveUp()                  //move bugs up
  {
    Ypos = Ypos - BUG_SPEED;
    return(Ypos + IMAGE_HEIGHT > 0);
  }
  
  public static void setImage(Image myBug) //set Image
  {
    newBug = myBug;
  }
  
  public boolean iClick(int x, int y) {    //check if coordinates are within image
    return((x < (Xpos + IMAGE_WIDTH)&&(x > Xpos)) && (y < (Ypos + IMAGE_HEIGHT)&& (y > Ypos)));
  }
  
  
  public void display(JApplet theApplet, Graphics canvas)
  {
    canvas.drawImage(newBug, Xpos, Ypos, theApplet);
  }
  
  
  public static void main(String[] args)     //main method to test some functionality
  {
    Bug b1 = new Bug(20, 19);
    System.out.println(b1.getYpos());
    boolean movement = b1.moveUp();
    if(movement)
      System.out.println("True");
    else
      System.out.println("False");
    b1.iClick(22, 22);
    boolean click = b1.iClick(22, 22);
    if(click)
      System.out.println("True");
    else
      System.out.println("False");
    
  }
}
