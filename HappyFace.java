import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class HappyFace extends JApplet{
  
  
  public static final int FACE_LENGTH = 200;
  public static final int A_FACE = 100;
  public static final int B_FACE = 50;
  public static final int EYE_WIDTH = 10;
  public static final int EYE_HEIGHT = 20;
  public static final int A_RIGHT_EYE = 155;
  public static final int B_RIGHT_EYE = 100;
  public static final int A_LEFT_EYE = 230;
  public static final int B_LEFT_EYE = B_RIGHT_EYE;
  public static final int MOUTH_WIDTH = 100;
  public static final int MOUTH_HEIGHT = 50;
  public static final int A_MOUTH = 150;
  public static final int B_MOUTH = 160;
  public static final int MOUTH_START_ANGLE = 180;
  public static final int MOUTH_EXTENT_ANGLE = 180;
  
  
  public void paint(Graphics canvas){
    canvas.setColor(Color.RED);
    canvas.drawRect(A_FACE, B_FACE, FACE_LENGTH, FACE_LENGTH);
    canvas.fillRect(A_FACE, B_FACE, FACE_LENGTH, FACE_LENGTH);
    canvas.setColor(Color.GREEN);
    canvas.fillRect(10, 20, 30,40);
    
    canvas.setColor(Color.BLUE);
    canvas.fillOval(A_RIGHT_EYE, B_RIGHT_EYE, EYE_WIDTH, EYE_HEIGHT);
    
    canvas.setColor(Color.YELLOW);
    canvas.fillOval(A_LEFT_EYE, B_LEFT_EYE, EYE_WIDTH, EYE_HEIGHT);
    
    canvas.setColor(Color.ORANGE);
    canvas.drawArc(A_MOUTH, B_MOUTH, MOUTH_WIDTH, MOUTH_HEIGHT, MOUTH_START_ANGLE, -MOUTH_EXTENT_ANGLE);
    
    canvas.drawLine(150, 50, 0, 0);
    
    
    
    
  }
}