/** this is an interface contain the common data fields in the project */

import java.util.Random;

public interface GameContents {

       static final int SCREEN_WIDTH = 1300;
       static final int SCREEN_HEIGHT = 750;
       static final int UNIT_SIZE = 22;
       static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);    // to separete the screen as a pixels
       Random random = new Random();
}
