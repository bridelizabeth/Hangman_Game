package stickman;

import javax.swing.*;
import java.awt.*;

/**
   Displays a bull's eye.
 */
public class StickmanComponent extends JComponent
{
   private int count;
   
   public void paintComponent(Graphics g) {
      Graphics2D graphics2D = (Graphics2D) g;
      if (count > -2) {

         graphics2D.setStroke(new BasicStroke(10.0f));
         graphics2D.drawLine(40, 190, 135, 190);


      }
      if (count > 0) {
         graphics2D.drawLine(120, 20, 120, 190);
      }
      if (count > 1) {
         graphics2D.drawLine(70, 20, 120, 20);
         graphics2D.drawLine(70, 20, 70, 40);
      }
      if (count > 2)
      {
         // the head
         graphics2D.setStroke(new BasicStroke(2.0f));
         g.drawOval(55, 45, 30, 30);
      }
      if (count > 3)
      {
         //body
         g.drawLine(70, 75, 70, 110);
      }
      if (count > 4)
      {
         //right arm
         g.drawLine(70, 90, 90, 75);

      }
      if (count > 5)
      {
         //left arm
         g.drawLine(70, 90, 50, 75);
      }

      if (count > 6)
      {
          //right leg
         g.drawLine(70, 110, 90, 130);


      }
      if (count > 7)
      {
           //left leg
         g.drawLine(70, 110, 50, 130);

      }
      
      //reset it again
      if (count == 8)
         count = -1; 

   }
   
   public void incCount()
   {
      count++; 
   }

   public void setCount(int count) {
      this.count = count;
   }

   public int getCount() {
      return count;
   }
}
