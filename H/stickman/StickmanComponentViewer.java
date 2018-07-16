package stickman;

import javax.swing.JFrame;

/**
   Tests theComponent class.
 */
public class StickmanComponentViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new StickmanButtonFrame();

      //frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Stickman");
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      frame.setSize(500, 500);
   }
}
