  //ANTHONY KAFUI KWAWU
// LAB WORK

import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;
    
    public class Checkerboard extends JApplet {
      
      // Drawing a yellow and blue checkerboard of  400 x 400 pixels
       
    
       public void paint(Graphics pen) {
          
          int row;   // number of rows from 0 - 7
          int column;   // number of columns from 0 - 7
          int x,y;   // Top left corner of the axes   
          // all these are declared as integer values
       
          for ( row = 0;  row < 8;  row++ ) {   // Loop that controls the colouring of the squares
          
             for ( column = 0;  column < 8;  column++) {
               
                x = column * 50; // the squares are actually 50 pixels not 0, 1, 2....
                y = row * 50;
                
                
                if ( (row % 2) == (column % 2)) // checks to see if squares are equal before colouring
                   pen.setColor(Color.blue);// blue colouring
                else
                   pen.setColor(Color.yellow);// yellow colouring
                pen.fillRect(x, y, 50, 50);// drawing alternate squares
             } 
          
          }
       
       }  

    }  