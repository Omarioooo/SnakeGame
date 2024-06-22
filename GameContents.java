import java.util.Random;

public interface GameContents {

       static final int SCREEN_WIDTH = 1300;
       static final int SCREEN_HEIGHT = 750;
       static final int UNIT_SIZE = 22;
       static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
       Random random = new Random();
}
