import javax.swing.*;
import java.awt.*;

public class SlashPage extends JFrame {

    private final ImageIcon GameIcon ;
    private final JLabel lblBackGround ,lblWelcome;
    private final ImageIcon backGroundImage,icon;
    private final JProgressBar bar;

    public SlashPage() {

        // Create JFrame
        GameIcon = new ImageIcon(getClass().getResource("/Icon/images.png"));
        setIconImage(GameIcon.getImage());
        setTitle("Loading: Snake game!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 790);
        setLocationRelativeTo(null);
        setLayout(null);

        // Set background
        backGroundImage = new ImageIcon(getClass().getResource("/Icon/cc.png"));
        lblBackGround = new JLabel(backGroundImage);
        lblBackGround.setBounds(0, 0, getWidth(), getHeight());
        setContentPane(lblBackGround);

        // Set the icon image for the JFrame
        icon = new ImageIcon(getClass().getResource("/Icon/images.png"));
        setIconImage(icon.getImage());


        // Welcome message
        lblWelcome = new JLabel("Welcome to Snake game..., Enjoy your time!");
        lblWelcome.setFont(new Font("Ink Free", Font.ITALIC, 30));
        lblWelcome.setBounds(440, 30, 850, 50);  // Position above the GIF
        add(lblWelcome);

        // Progress bar
        bar = new JProgressBar();
        bar.setBounds(75, 700, 1250, 30);  // Position below the GIF
        bar.setValue(0);
        bar.setStringPainted(true);
        bar.setFont(new Font("Ink Free", Font.BOLD, 20));
        bar.setBackground(Color.WHITE);
        bar.setForeground(Color.green);
        add(bar); // add to the frame

        setVisible(true);
        fillProgressBar();
        dispose();          // close the page

        new GameMenu();
    }

    // fill the progress bar
    public void fillProgressBar() {
        int progress = 0;
        while (progress <= 100) {

            bar.setValue(progress);

            try {
                Thread.sleep(30);


            } catch (InterruptedException e){}
            progress++;
        }
        bar.setString("Done... Let's continue :)");

    }  // the end of the fill method

}
