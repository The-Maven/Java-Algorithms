
import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.util.Random;



public class RandomCircles extends JApplet implements MouseListener
{ 
  private MyCircle[] circles;
  private int numCircles;
  private int curColor;
  private Random rand;
  
  public static final int MAX_NUM_CIRCLES = 50;
  public static final int MAX_R = 100;
  public static final Color[] COLORS = {Color.RED,
                                         Color.BLUE, Color.GREEN};
  
  public void init(){
    circles = new MyCircle[MAX_NUM_CIRCLES];
    numCircles = 0;
    curColor = 0;
    rand = new Random();
    addMouseListener(this);
  }
  
  /*
   * The paint method allows the graphics of the applet to be drawn.
   */
  public void paint(Graphics canvas)
  {    
    int r;
    for (int i=0; i<numCircles; i++){
      r = circles[i].getR();
      canvas.setColor(circles[i].getColor());
      canvas.drawOval(circles[i].getX()-r, circles[i].getY()-r,
                      2*r, 2*r);
    }
  }
 
  
  public void mouseClicked(MouseEvent e){
    
    if (numCircles < circles.length) {
      int x = (int)e.getPoint().getX();
      int y = (int)e.getPoint().getY();
      
      circles[numCircles] = new MyCircle(x, y, 
                                         rand.nextInt(MAX_R),
                                         COLORS[curColor]);
      numCircles++;
      curColor = (curColor+1)%COLORS.length;
      
      clear();
      repaint();
    }
  }
  public void  mouseEntered(MouseEvent e){
  }
  
  public void  mouseExited(MouseEvent e){
  }
  
  public void  mousePressed(MouseEvent e){
  }
  
  public void  mouseReleased(MouseEvent e){
  }
 
  private void clear() {
    Graphics g = getGraphics();
    Dimension d = getSize();
    if (g != null){
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, d.width, d.height);
    }
  }
  
}