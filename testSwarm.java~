import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JApplet;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class testSwarm extends JApplet implements MouseListener, ActionListener
{ 
  private Swarm newSwarm;          //instance variables
  private Timer time;
  
  public void init()             //receiving image, setting image and other useful Timer and MouseListener methods 
  {
    newSwarm = new Swarm();
    Image bugPicture = getImage(getCodeBase(), "ladybug.gif");
    Bug.setImage(bugPicture);
    addMouseListener(this);
    time = new Timer(100, this);
    time.start();
  }
  
  
  public void paint(Graphics canvas)       //display swarm
  {
    if (newSwarm != null){
      canvas.drawString("Bugs:" + newSwarm.getCount(), 0, 20);
      newSwarm.swarmDisplay(this, canvas);
    }
  }
  
  public void mouseClicked(MouseEvent e){ // get mouse coordinates
    
    int x = (int)e.getPoint().getX();
    int y = (int)e.getPoint().getY();
    if(e.getClickCount() == 2)            // creat bugs if clicked twice
      newSwarm.newBug(x, y);
    else if(e.getClickCount() == 1)       // terminate if clicked once
      newSwarm.overlap(x, y);
    
    clear();
    repaint();
  }
  
  public void actionPerformed(ActionEvent e){  // move bugs seamlessly
    newSwarm.moveBugs();
    clear();
    repaint();
  }
  
  public void  mouseEntered(MouseEvent e){
  }
  
  public void  mouseExited(MouseEvent e){
  }
  
  public void  mousePressed(MouseEvent e){
  }
  
  public void  mouseReleased(MouseEvent e){
  }
  
  private void clear() {                  //method to clear screen
    Graphics g = getGraphics();
    Dimension d = getSize();
    if (g != null){
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, d.width, d.height);
    }
  }
}