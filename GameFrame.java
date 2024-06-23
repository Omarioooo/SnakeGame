/** The swing frame display the game board */\

import javax.swing.*;
public class GameFrame extends JFrame {

      // An icon for the Game 
    private final ImageIcon GameIcon ;  

    GameFrame(String diff, String mod) {
        
        GameIcon = new ImageIcon(getClass().getResource("/Icon/images.png"));
        setTitle("Snake game");
        setIconImage(GameIcon.getImage());
         
          // The modes of the game play
        if(mod.equals("Mode 1")) {
            add(new GamePanel(diff));
        } else if(mod.equals("Mode 2")) {
            add(new GamePanel2(diff));
        }else {
            add(new GamePanel3(diff));
        }
        
        pack();  // to collect the output from the JPanel page
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);   // the window open in the center of the screen
        setVisible(true);
    }
}
