/** this class is the food class with its features */

import java.util.Random;
public class Apple implements GameContents{

    // The Dim of the apple appeared
    private int appleX;
    private int appleY;
    // The Score of the game by the number of eaten apples
    private int appleEaten;

    public Apple(){
    }

    public int getAppleX() {
        return appleX;
    }

    public int getAppleY() {
        return appleY;
    }

    public int getAppleEaten() {
        return appleEaten;
    }

      // Generate a random Dim for X & Y on the game board
    public void newApple(){
        appleX = random.nextInt((SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }
      // count the score
    public void increaseAppleEaten(){
        appleEaten++;
    }

}
