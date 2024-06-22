import javax.swing.*;

public class GameFrame extends JFrame {

    private final ImageIcon GameIcon ;

    GameFrame(String diff, String mod) {
        GameIcon = new ImageIcon(getClass().getResource("/Icon/images.png"));
        setTitle("Snake game");
        setIconImage(GameIcon.getImage());
        if(mod.equals("Mode 1")) {
            add(new GamePanel(diff));
        } else if(mod.equals("Mode 2")) {
            add(new GamePanel2(diff));
        }else {
            add(new GamePanel3(diff));
        }
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);   // the window open in the center of the screen
        setVisible(true);
    }
}
