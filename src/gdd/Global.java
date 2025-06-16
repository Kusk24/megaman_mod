package gdd;

public class Global {
    private Global() {
        // Prevent instantiation
    }

    public static final int DELAY = 10; // Delay in milliseconds for the game loop
    public static final int SCALE_FACTOR = 1; // Scaling factor for sprites

    public static final int BOARD_WIDTH = 800; // Doubled from 358
    public static final int BOARD_HEIGHT = 800; // Doubled from 350
    public static final int BORDER_RIGHT = 10; // Doubled from 30
    public static final int BORDER_LEFT = 10; // Doubled from 5

    public static final int GROUND = 580; // Doubled from 290

    public static final int PLAYER_WIDTH = 100; // Doubled from 15
    public static final int PLAYER_HEIGHT = 100; // Doubled from 10

    // Images
    public static final String IMG_PLAYER = "src/images/megaman-sprite.png";
    // public static final String IMG_SHOT = "src/images/shot.png";

}
