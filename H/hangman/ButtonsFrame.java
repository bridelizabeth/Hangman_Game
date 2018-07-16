package hangman;

import stickman.StickmanComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**

 */
public class ButtonsFrame extends JFrame {
 
    private JLabel label;
    private JLabel secretWordLabel;
    private JLabel livesLabel;
    private ButtonListener listener;
    private JButton exitButton;
    private JButton newGameButton;
    private List<JButton> buttonList = new ArrayList<>();
    private WordGenerator wordGenerator;
    private String word = "";


    private JPanel stickmanPanel;
    private StickmanComponent component;   //repaint
    private int lives = 8;

    //create instance of the hangman game
    private HangmanGame myGame;

    public ButtonsFrame() {
        wordGenerator = new WordGenerator();
        word = wordGenerator.getWord().toUpperCase();
        System.out.println("WORD: " + word);
        myGame = new HangmanGame(word);


        add(createStickmanButtonFrame(), BorderLayout.BEFORE_FIRST_LINE);
        add(createInfoPanel(), BorderLayout.WEST);

        add(createButtonPanel(), BorderLayout.CENTER);
        add(createExitPanel(), BorderLayout.SOUTH);
        // Construct menu for game rules and level selection
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);  //set the menu bar for this frame
        menuBar.add(createRulesMenu());

        add(createFieldsPanel(), BorderLayout.NORTH);
        //setSize(400,400);
        //pack();  //note use of pack
    }

    /**
     * Creates the control panel with the text field
     * and buttons on the frame.
     */

    public JPanel createFieldsPanel() {
        //create a panel with gridlayout 2 x 2
        JPanel panel = new JPanel(new GridLayout(2, 2));


        //return the panel to constructor
        return panel;

    }

    public JPanel createStickmanButtonFrame(){

        stickmanPanel = new JPanel();

       component = new StickmanComponent();
       component.repaint();
       //issue with
       component.setPreferredSize(new Dimension(200,200));
       stickmanPanel.add(component);
   
       return stickmanPanel;

    }

    /**
     * Creates the View Rules menu
     *
     * @return the menu
     */
    public JMenu createRulesMenu() {
        JMenu menu = new JMenu("Game Rules");
        menu.add(createFileMenuItem("View Hangman Rules"));
        return menu;
    }

    //Creates menu to view rules of Hangman
    public JMenuItem createFileMenuItem(String name) {
        JMenuItem item = new JMenuItem(name);

        class MenuItemListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.out.println("View Hangman Rules");

                JDialog dialog = new JDialog();
                dialog.setTitle("Hangman Rules");
                dialog.setSize(400, 200);
                dialog.setLocation(200, 200);

                JTextArea textArea = new JTextArea(5, 20);
                textArea.setText("Player tries to guess the word by asking what letters it contains.\n However, every wrong guess brings them one step closer to losing. ");
                JScrollPane scrollPane = new JScrollPane(textArea);
                textArea.setEditable(false);
                dialog.add(scrollPane);

                dialog.setVisible(true);


            }
        }

        ActionListener listener = new MenuItemListener();
        item.addActionListener(listener);
        return item;
    }


    private JPanel createButtonPanel() {
        // the panel for holding the user interface components
        JPanel buttonPanel = new JPanel();
        buttonPanel.setMaximumSize(new Dimension(450, 250));
        buttonPanel.setMinimumSize(new Dimension(450, 250));
        buttonPanel.setPreferredSize(new Dimension(450, 250));
        buttonPanel.setLayout(new GridLayout(4, 7));

        listener = new ButtonListener();


        //create 26 letter buttons

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            JButton button = new JButton("" + ch);
            button.setMaximumSize(new Dimension(60, 20));
            button.setMinimumSize(new Dimension(60, 20));
            button.setPreferredSize(new Dimension(60, 20));
            button.addActionListener(listener);
            buttonList.add(button);
            buttonPanel.add(button);
        }

        return buttonPanel;
    }

    //this panel will hold labels showing game info to user
    private JPanel createInfoPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.setMinimumSize(new Dimension(270, 300));
        panel.setMaximumSize(new Dimension(270, 300));
        panel.setPreferredSize(new Dimension(270, 300));

        label = new JLabel("Please guess a letter from the options below  ");
        secretWordLabel = new JLabel(myGame.showDashes());
        livesLabel = new JLabel("Lives Left:  " + myGame.getLives());

        panel.add(label);
        panel.add(secretWordLabel);
        panel.add(livesLabel);


        return panel;
    }


    public JPanel createExitPanel() {
        JPanel panel = new JPanel();

        //create 3 buttons
        exitButton = new JButton("Exit");
        exitButton.setMinimumSize(new Dimension(100, 40));
        exitButton.setMaximumSize(new Dimension(100, 40));
        exitButton.setPreferredSize(new Dimension(100, 40));
        newGameButton = new JButton("New game");
        newGameButton.setMinimumSize(new Dimension(100, 40));
        newGameButton.setMaximumSize(new Dimension(100, 40));
        newGameButton.setPreferredSize(new Dimension(100, 40));
        class ButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                //if exit button is clicked - exit the application
                if (e.getSource().equals(exitButton)) {
                    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION)
                        System.exit(0);  //exit application
                }

            }
        }

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(newGameButton)) {
                    // System.out.println("new Game pressed");
                    for (JButton jButton : buttonList) {
                        jButton.setEnabled(true);
                    }
                    word = wordGenerator.getWord().toUpperCase();
                    System.out.println("NEW WORD: " + word);
                    myGame = new HangmanGame(word);
                    label.setText("Please guess a letter from the options below  ");
                    myGame.setLives(8);
                    livesLabel.setText("Lives Left:  " + myGame.getLives());
                    secretWordLabel.setText(myGame.showDashes());
                    lives = 8;
                    component.setCount(0);
                    component.repaint();
                }
            }
        });

        ActionListener listener = new ButtonListener();

        //add listener to each of my buttons
        exitButton.addActionListener(listener);

        //add all the button to the panel
        panel.add(exitButton);
        panel.add(newGameButton);

        return panel;
    }


    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String s = event.getActionCommand(); //gets the text or string on the button
            JButton btn = (JButton) event.getSource(); //returns the source of the event - when a button is clicked
            btn.setEnabled(false);
            label.setText(s + " was clicked                                     ");

            myGame.guessLetter(s.charAt(0));
            //update the secretWordLabel
            secretWordLabel.setText(myGame.showDashes());
            livesLabel.setText("Lives Left:  " + myGame.getLives());

            //myGame.guessLetter(s.charAt(0));
            secretWordLabel.setText(myGame.showDashes());  //update the secretword label

            if (lives > myGame.getLives()){
                component.incCount();
                component.repaint();
                lives = myGame.getLives();
            }
            livesLabel.setText("Lives Left:  " + myGame.getLives());
            if (myGame.gameOver()) {
                if (word.equals(secretWordLabel.getText()) && myGame.getLives() > 0) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You are a winner!", "JOptionPane.PLAIN_MESSAGE", JOptionPane.PLAIN_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Sorry! Please try again!", "JOptionPane.PLAIN_MESSAGE", JOptionPane.PLAIN_MESSAGE);

                }


            }

        }
    }


}



	 