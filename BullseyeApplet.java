//KWAWU ANTHONY KAFUI
//PROGRAMMING 2
//DR. AYORKOR KORSAH
//OCTOBER 10 2013
//PROGRAM TO DRAW A BULLSEYE DEPENDING ON A USER'S PREFERRED NUMBER OF RINGS FROM 2 TO 10 RINGS

import javax.swing.JApplet;     //Importing classes
import java.awt.Graphics;
import java.awt.Color;
import javax.swing. JOptionPane;

public class BullseyeApplet extends JApplet{
  
  public static final int MIN_RINGS = 2;        //declaring and initializing named constants: min and max rings place
  public static final int MAX_RINGS = 10;       // limit on rings drawn and ring width specifies exact width of ring width
  public static final int RING_WIDTH = 30;
  
  
  
  private int ringcount; // instance variable for this class
  
  public void init()    // initiates the drawing of dialog boxes
  {
    do  //start loop
    {
      String ringcountSTRING = JOptionPane.showInputDialog("How many Bullseye-rings do you fancy?");   // asking the user for input
      ringcount = Integer.parseInt(ringcountSTRING);          // converting the string to integer format
      if (ringcount < MIN_RINGS || ringcount > MAX_RINGS)     //checking to see if conditions are satisfied
      {       
        String message = ("Oops I can only draw from " + MIN_RINGS +  
                          " to " + MAX_RINGS + " rings !");
        JOptionPane.showMessageDialog(null, message);
      }
    }
    while(ringcount < MIN_RINGS || ringcount > MAX_RINGS);           // end of loop condition
  }
  
  
  
  public void paint(Graphics pen)  //  initiates the drawing of the bullseye
  {
    
    int x=50, y=80, diameter;       // declaring variables and initializing x and y co-ordinates
    int width = (ringcount * 60) + 100;  // formulae that determines the width of the bullseye in order to maintain a centre circle radius of 100 pixels
    diameter = width;
    
    while(ringcount >0)  // condition for start loop
    {
      
      diameter -= (2 * RING_WIDTH);    // diameter keeps decreasing by the ring width of 30 pixels on both sides = 60 pixels
     
      x += RING_WIDTH;   // shifting the x co-ordinate to the right and
                     
      y += RING_WIDTH;   // shifting the y co-ordinate downwards to draw smaller circles
      
      if (ringcount%2 == 0)            // checking to see if number of rings is even
      {
        pen.setColor (Color.yellow);   // paint circle yellow if ring is even
      } 
      else
      {
        pen.setColor (Color.cyan);     // and cyan if ring is odd
      }
      
      
      pen.fillOval (x, y, diameter, diameter);   // draw resulting bullseye
      
      ringcount--;                    // decrement operator, reduce number of rings by 1 untill ringcount disobeys loop condition
      
    }
  }
  
}    // end program