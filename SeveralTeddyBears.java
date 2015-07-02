
import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * An applet to draw several Teddy Bears
 */
public class SeveralTeddyBears extends JApplet
{
  // Constants for the dimensions and positions of the bear
  public static final int BODY_WIDTH = 130, BODY_HEIGHT = 180, BODY_X = 12, BODY_Y = 100;
  public static final int FACE_WIDTH = 75, FACE_HEIGHT = 75, FACE_X = 40, FACE_Y = 25;
  public static final int EARS_SIZE = 20, LEFT_EAR_X = 32, RIGHT_EAR_X = 103, EARS_Y = 20;
  public static final int EYES_SIZE = 10, LEFT_EYE_X = 55, RIGHT_EYE_X = 85, EYES_Y = 50;
  public static final int MOUTH_WIDTH = 30, MOUTH_HEIGHT = 20, MOUTH_X = 55, MOUTH_Y = 68;
  public static final int MOUTH_BEGIN_ANGLE = 190, MOUTH_ARC_ANGLE = 160;
  public static final int NOSE_SIZE = 5, NOSE_X = 70, NOSE_Y = 62;
  public static final int BEAR_LABEL_X = 20, BEAR_LABEL_Y = 15;
  
  // constants for the limits on the number of bears that the program will draw.
  public static final int MIN_BEARS = 1;
  public static final int MAX_BEARS = 5;
  
  // An instance variable for this class.
  private int numBears;
  
  public void init() {
     do {
      String numBearsString = JOptionPane.showInputDialog("How many bears should I draw?");
      numBears = Integer.parseInt(numBearsString);
      if (numBears < MIN_BEARS || numBears > MAX_BEARS){
        String message = ("Oops, I can only draw between " + MIN_BEARS + 
                          " and " + MAX_BEARS + " bears.");
        JOptionPane.showMessageDialog(null, message);
      }
    } while (numBears < MIN_BEARS || numBears > MAX_BEARS);
  }
  
  public void paint(Graphics canvas)
  {    
    for (int i=0; i<numBears; i++) {
      drawTeddy(canvas, i*(BODY_WIDTH+10), 0, "Bear"+i);
    }
  }
  
  public void drawTeddy(Graphics canvas, int x, int y, String label)
  {
    
    // draw body
    canvas.setColor(Color.BLUE);
    canvas.drawOval(x+BODY_X, y+BODY_Y, BODY_WIDTH, BODY_HEIGHT);
    
    //draw face
    canvas.drawOval(x+FACE_X, y+FACE_Y, FACE_WIDTH, FACE_HEIGHT);
    
    // draw ears
    canvas.drawOval(x+LEFT_EAR_X, y+EARS_Y, EARS_SIZE, EARS_SIZE);
    canvas.drawOval(x+RIGHT_EAR_X, y+EARS_Y, EARS_SIZE, EARS_SIZE);
    
     // draw eyes
    canvas.setColor(Color.BLACK);
    canvas.fillOval(x+LEFT_EYE_X, y+EYES_Y, EYES_SIZE, EYES_SIZE);
    canvas.fillOval(x+RIGHT_EYE_X, y+EYES_Y, EYES_SIZE, EYES_SIZE);
    
    // draw nose
    canvas.fillOval(x+NOSE_X, y+NOSE_Y, NOSE_SIZE, NOSE_SIZE);
    
    // draw mouth
    canvas.setColor(Color.RED);
    canvas.drawArc(x+MOUTH_X, y+MOUTH_Y, MOUTH_WIDTH, MOUTH_HEIGHT, MOUTH_BEGIN_ANGLE, MOUTH_ARC_ANGLE);
    
    // draw a label
    canvas.setColor(Color.BLACK);   
    canvas.drawString(label, x+BEAR_LABEL_X, y+BEAR_LABEL_Y);    
  }
}