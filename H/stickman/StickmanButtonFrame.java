package stickman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StickmanButtonFrame extends JFrame
{
   private JButton button;
   private JPanel stickmanPanel; 
   private StickmanComponent component;
   private ButtonListener listener; 
   
   public StickmanButtonFrame()
   {
      
       setSize(400,400);
       listener = new ButtonListener(); 
       
       add(createBullsEyePanel(), BorderLayout.CENTER); 
       add(createButtonPanel(), BorderLayout.SOUTH);
  
   }
   
   public JPanel createButtonPanel()
   {
      JPanel panel = new JPanel();
      button = new JButton("Press Me");
      
      button.addActionListener(listener);  
      
      panel.add(button);

      return panel; 
      
   }
       
  public JPanel createBullsEyePanel()
  {
      stickmanPanel = new JPanel();
      
      component = new StickmanComponent();

      //issue with 
      component.setPreferredSize(new Dimension(200,200));
      stickmanPanel.add(component);
      return stickmanPanel; 
      
  }
  
  class ButtonListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
          System.out.println("REP");
         component.incCount();
         component.repaint();   //repaint calls paintComponent()   
      }
  
  }
  
  
   



}