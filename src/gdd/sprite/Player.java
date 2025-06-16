package gdd.sprite;

import static gdd.Global.*;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Player extends Sprite {

    private static final int START_X = 100;
    private static final int START_Y = 500;
    // private int width;
    private int frame = 0;
    private boolean isFiring = false;

    public static final int DIR_LEFT = 0;
    public static final int DIR_RIGHT = 1;
    private int facing = 0;

    private static final int ACT_STANDING = 0;
    private static final int ACT_RUNNING = 1;
    private static final int ACT_JUMPING = 2;
    private int action = ACT_STANDING;

    private int clipNo = 0;
    private final Rectangle[] clips = new Rectangle[] {
            new Rectangle(18, 20, 80, 90), // 0: stand still
            new Rectangle(110, 20, 80, 90), // 1: stand blink
            new Rectangle(294, 20, 90, 90), // 2: run 1
            new Rectangle(400, 20, 60, 90), // 3: run 2
            new Rectangle(470, 20, 80, 90), // 4: run 3
            new Rectangle(120, 220, 80, 90), // 5: jump 1, no firing
            new Rectangle(18, 149, 80, 90), // 6: jump 2, firing

    };

    public Player() {
        initPlayer();
    }

    public int getFrame() {
        return frame;
    }

    @Override
    public int getHeight() {
        return clips[clipNo].height;
    }

    public int getFacing() {
        return facing;
    }

    @Override
    public int getWidth() {
        return clips[clipNo].width;
    }

    @Override
    public Image getImage() {
        Rectangle bound = clips[clipNo];
        // TODO this can be cached.
        BufferedImage bImage = toBufferedImage(image);
        return bImage.getSubimage(bound.x, bound.y, bound.width, bound.height);
    }

    private void initPlayer() {
        var ii = new ImageIcon(IMG_PLAYER);
        setImage(ii.getImage());

        setX(START_X);
        setY(START_Y);
    }

    public void act() {
        System.out.printf("Player action=%d frame=%d facing=%d\n", action, frame, facing);

        frame++;

        switch (action) {
            case ACT_STANDING:
                if (clipNo == 1 && frame > 5) { // blink only one frame
                    frame = 0;
                    clipNo = 0;
                }
                if (frame > 40) { // blink
                    frame = 0;
                    clipNo = 1; // blink
                }

                break;
            case ACT_RUNNING:
                if (frame <= 10) {
                    clipNo = 3;
                } else if (frame <= 20) {
                    clipNo = 2;
                } else if (frame <= 30) {
                    clipNo = 3;
                } else if (frame <= 40) {
                    clipNo = 4;
                } else {
                    clipNo = 3;
                    frame = 0;
                }

                break;
            case ACT_JUMPING:
                if (isFiring) {
                    clipNo = 6;
                } else {
                    clipNo = 5;
                }
                break;
        }

        x += dx;

        if (x <= 2) {
            x = 2;
        }

        if (x >= BOARD_WIDTH - 2 * width) {
            x = BOARD_WIDTH - 2 * width;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            if (action != ACT_RUNNING) {
                // Change of action
                frame = 0;
            }
            action = ACT_RUNNING;
            facing = DIR_LEFT;
            dx = -2;
        } else if (key == KeyEvent.VK_RIGHT) {
            if (action != ACT_RUNNING) {
                // Change of action
                frame = 0;
            }
            action = ACT_RUNNING;
            facing = DIR_RIGHT;
            dx = 2;
        } else if (key == KeyEvent.VK_SPACE) {
            // action = ACT_JUMPING;
            // dy = -10;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            if (action != ACT_STANDING) {
                // Change of action
                clipNo = 0;
                frame = 0;
            }
            action = ACT_STANDING;
            facing = DIR_LEFT;
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            if (action != ACT_STANDING) {
                // Change of action
                clipNo = 0;
                frame = 0;
            }
            action = ACT_STANDING;
            facing = DIR_RIGHT;
            dx = 0;
        }
    }
}
