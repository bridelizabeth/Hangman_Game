package hangman;

import javax.swing.JFrame;

public class ButtonsFrameViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new ButtonsFrame();
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Hangman");
      frame.setVisible(true);
      frame.setLocation(200,200);
		frame.setSize(700, 600);
   }
}

      