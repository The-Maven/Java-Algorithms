import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JApplet;
import java.awt.Color;




public class theBug extends JApplet
{
  Bug newBug;
  
  public void init()
  {
    newBug = new Bug (100, 100);
    Image bugPicture = getImage(getCodeBase(), "ladybug.gif");
    Bug.setImage(bugPicture);
  }
  
  public void paint(Graphics canvas)
  {
    
    if (newBug != null)
    newBug.display(this, canvas);
  }
}