/** This is a page that control the mode and difficulty of the game */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMenu extends JFrame implements  ActionListener  {

    private final ImageIcon GameIcon ;
    private String selectedDifficulty = "Medium";
    private String selectedMode = "Mode 1";
    private final JPanel difficultyPanel, modesPanel;
    private final JButton startButton;

      // Buttons fot check the game flow
    private final JRadioButton easyButton, mediumButton, hardButton,
                               mode1Button, mode2Button, mode3Button;
    
      // A button to collect the same buttons in one panel
    private final ButtonGroup difficultyGroup, modesGroup;

    public GameMenu() {
        // Set up the frame
        GameIcon = new ImageIcon(getClass().getResource("/Icon/images.png"));
        setIconImage(GameIcon.getImage());
        setTitle("Game Menu");
        setSize(1300,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setResizable(false);
          // To make the page Middle of the page
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


         // Create and add difficulty panel
        difficultyPanel = new JPanel();
        difficultyPanel.setLayout(new FlowLayout());
        difficultyPanel.setBorder(BorderFactory.createTitledBorder("Difficulty:"));

         // Create difficulty buttons
        easyButton = new JRadioButton("Easy");
        mediumButton = new JRadioButton("Medium", true);
        hardButton = new JRadioButton("Hard");

         // No focus on buttons
        easyButton.setFocusPainted(false);
        mediumButton.setFocusPainted(false);
        hardButton.setFocusPainted(false);

         // Add action listeners to difficulty buttons
        easyButton.addActionListener(this);
        mediumButton.addActionListener(this);
        hardButton.addActionListener(this);

         // Group difficulty buttons
        difficultyGroup = new ButtonGroup();
        difficultyGroup.add(easyButton);
        difficultyGroup.add(mediumButton);
        difficultyGroup.add(hardButton);

         // Add difficulty buttons to panel
        difficultyPanel.add(easyButton);
        difficultyPanel.add(mediumButton);
        difficultyPanel.add(hardButton);


         // Create and add modes panel
        modesPanel = new JPanel();
        modesPanel.setLayout(new FlowLayout());
        modesPanel.setBorder(BorderFactory.createTitledBorder("Game Modes:"));

         // Create modes buttons
        mode1Button = new JRadioButton("Mode 1", true);
        mode2Button = new JRadioButton("Mode 2");
        mode3Button = new JRadioButton("Mode 3");

         // No focus on buttons
        mode1Button.setFocusPainted(false);
        mode2Button.setFocusPainted(false);
        mode3Button.setFocusPainted(false);

         // Add action listeners to buttons
        mode1Button.addActionListener(this);
        mode2Button.addActionListener(this);
        mode3Button.addActionListener(this);

         // Group mode buttons
        modesGroup = new ButtonGroup();
        modesGroup.add(mode1Button);
        modesGroup.add(mode2Button);
        modesGroup.add(mode3Button);

         // Add mode buttons to panel
        modesPanel.add(mode1Button);
        modesPanel.add(mode2Button);
        modesPanel.add(mode3Button);


         // Create start button
        startButton = new JButton("Start Game");
        startButton.setFocusPainted(false);
        startButton.addActionListener(this);

         // Add panels and button to frame
        add(difficultyPanel, BorderLayout.NORTH);
        add(modesPanel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);

         // Revalidate and repaint the frame
        revalidate();
        repaint();

         // Set the frame visible
        setVisible(true);
    }
      // Override the actionPerformed because the frame implemnts the ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == easyButton) {
            selectedDifficulty = "Easy";
        } else if (e.getSource() == mediumButton) {
            selectedDifficulty = "Medium";
        } else if (e.getSource() == hardButton) {
            selectedDifficulty = "Hard";
        } else if (e.getSource() == mode1Button) {
            selectedMode = "Mode 1";
        } else if (e.getSource() == mode2Button) {
            selectedMode = "Mode 2";
        } else if (e.getSource() == mode3Button) {
            selectedMode = "Mode 3";
        } else if (e.getSource() == startButton) {
            startGame();
        }
    }

    private void startGame() {
        // Close the menu
        dispose();
        // Start the game with the selected settings
        new GameFrame(selectedDifficulty, selectedMode);
    }
}
