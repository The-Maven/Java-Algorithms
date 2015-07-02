import java.awt.Graphics;
import javax.swing.JApplet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Puzzleapplet extends JApplet implements MouseListener {
  private Eight newEight;
  int r,s;
  
  public void init(){
    newEight = new Eight();
    addMouseListener(this);
  }
  
  public void paint(Graphics canvas){
    if(newEight != null){
      clear();
      newEight.display(this, canvas);
    }
  }
  
  public void mouseClicked(MouseEvent e){ // get mouse coordinates
    
    int r = (int)e.getPoint().getX();
    int s = (int)e.getPoint().getY();
    if(e.getClickCount() == 1)            // moves tiles when clicked
      newEight.move(r,s);
    if(newEight.winner()){
    JOptionPane.showMessageDialog(null, "Congratulations, you solved the puzzle");
    }
    
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

