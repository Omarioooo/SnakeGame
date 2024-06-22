import java.util.Random;
public class Apple implements GameContents{

    private int appleX;
    private int appleY;
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

    public void newApple(){
        appleX = random.nextInt((SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    public void increaseAppleEaten(){
        appleEaten++;
    }

}
