/** The normal mood */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements GameContents, ActionListener {
         public int SPEED;
         private  Snake snake;
         private  Apple apple;
         private Timer timer;
         boolean running = true;
         char Direction = 'R';
         private  JButton exit ;
      // private  JButton menu;

    GamePanel(String diff ) {
        if(diff.equals("Easy")){
            SPEED = 100;
        }else if(diff.equals("Medium")){
            SPEED = 75;
        }else{
            SPEED = 50;
        }
        snake= new Snake();
        apple= new Apple();
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));   // The size of the Panel
        setBackground(Color.black);
        setFocusable(true);    // accept the keyboard inputs
        addKeyListener(new Controller());
        startGame();
    }

    public void startGame(){
        apple.newApple();
        running=true;
        timer = new Timer(SPEED,this);
        timer.start();
    }

    public void draw(Graphics g){
        if(running) {
            //Score
            g.setColor(Color.CYAN);
            g.setFont(new Font("Ink Free", Font.BOLD, 25));
            FontMetrics metrics1 = getFontMetrics(g.getFont());
            g.drawString("Score: " + apple.getAppleEaten(), (SCREEN_WIDTH - metrics1.stringWidth("Score: " + apple.getAppleEaten())) / 2, g.getFont().getSize());

            //Apple
            g.setColor(Color.red);
            g.fillOval(apple.getAppleX(),apple.getAppleY(), UNIT_SIZE, UNIT_SIZE);

            //Snake
            for (int i = 0; i < snake.getBodyParts(); i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(snake.getX(i), snake.getY(i), UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(snake.getX(i), snake.getY(i), UNIT_SIZE, UNIT_SIZE);
                }
            }
        }else {
            gameOver(g);
        }
    }

    public void move(){
          // Shift the body
        for(int i= snake.getBodyParts();i>0;i--) {
              snake.changeX(i,snake.getX(i-1));
              snake.changeY(i,snake.getY(i-1));
        }
         // Shift the head
        switch(Direction){
            case 'R' :
                snake.changeX(0,snake.getX(0)+UNIT_SIZE);
                break;

            case 'L' :
                snake.changeX(0,snake.getX(0)-UNIT_SIZE);
                break;

            case 'U' :
                snake.changeY(0,snake.getY(0)-UNIT_SIZE);
                break;

            case 'D' :
                snake.changeY(0,snake.getY(0)+UNIT_SIZE);
                break;
        }
    }

    public void checkApple() {
        if(snake.getX(0)==apple.getAppleX() && snake.getY(0)==apple.getAppleY()){
            apple.increaseAppleEaten();
            snake.increaseBoodyParts();
            apple.newApple();
        }
    }

    public void Death(){
         // Check the body
       for(int i=snake.getBodyParts() ; i>0 ; i--){
           if((snake.getX(0)==snake.getX(i)) && (snake.getY(0)==snake.getY(i))){
                  running = false;
           }
       }
       // Check the Dimension of the board
        // check the right side
        if(snake.getX(0)>SCREEN_WIDTH){
            running = false;
        }
        // check the lift side
        if(snake.getX(0)<0){
            running = false;
        }
        // check the Top Side
        if(snake.getY(0)<0){
            running = false;
        }
        // check the Bottom Side
        if(snake.getY(0)>SCREEN_HEIGHT){
            running = false;
        }
         // Stop the game
        if(!running)
           timer.stop();
    }

    public void gameOver(Graphics g) {
        g.setColor(Color.CYAN);

        //Score
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + apple.getAppleEaten(), (SCREEN_WIDTH - metrics1.stringWidth("Score: " + apple.getAppleEaten())) / 2,  g.getFont().getSize());

        //Game Over text
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);

//        menu = new JButton();
//        menu.setFocusPainted(false);
//        menu.setBounds(1050,700,100,40);
//        menu.setBackground(Color.black);
//        menu.setText("Menu");
//        menu.setForeground(Color.cyan);
//        menu.setFont(Font.getFont("Ink Free"));
//        menu.addMouseListener(new mouseController());

        exit = new JButton();
        exit.setFocusPainted(false);
        exit.setBounds(600,700,100,40);
        exit.setBackground(Color.black);
        exit.setText("Exit");
        exit.setFont(Font.getFont("Ink Free"));
        exit.setForeground(Color.cyan);
        exit.addMouseListener(new GamePanel.mouseController());

     // add(menu);
        add(exit);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkApple();
            Death();
        }
        repaint();
    }

       /** An inner class to have control on the game
            with direct access to the game direction */
    private class Controller extends KeyAdapter{
         @Override
        public void keyPressed(KeyEvent e) {
            //Control the directions
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (Direction != 'R') {
                        Direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (Direction != 'L') {
                        Direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (Direction != 'D') {
                        Direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (Direction!= 'U'){
                        Direction='D';
                    }
                break;
            }
        }
    }

    private class mouseController extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
            if(e.getSource()==exit) {
                System.exit(0);
            }
//            else if(e.getSource()==menu){
//                new Menu();
//            }
        }
    }
}
