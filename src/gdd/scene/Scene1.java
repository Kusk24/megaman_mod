package gdd.scene;

import static gdd.Global.*;
import gdd.sprite.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Scene1 extends JPanel {

    private Player player;
    // private Shot shot;

    private int direction = -1;
    private int deaths = 0;

    private boolean inGame = true;

    private final Dimension d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
    private Timer timer;

    public Scene1() {
        initBoard();
        gameInit();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.black);

        timer = new Timer(DELAY, new GameCycle());
        timer.start();

        gameInit();
    }

    private void gameInit() {
        player = new Player();
    }

    private void drawPlayer(Graphics g) {
        if (player.isVisible()) {
            if (player.getFacing() == Player.DIR_RIGHT) {
                g.drawImage(player.getImage(), player.getX(), player.getY()-player.getHeight(), player.getWidth(), player.getHeight(), this);
            } else {
                g.drawImage(player.getImage(), player.getX()+player.getWidth(), player.getY()-player.getHeight(), -player.getWidth(), player.getHeight(), this);
            }
            // g.drawImage(player.getImage(), player.getX(), player.getY()-player.getHeight(), this);
            g.drawRect(player.getX(),player.getY(),10,10);            
            g.drawRect(player.getX(),player.getY()-player.getHeight(),player.getWidth(),player.getHeight());            
            g.drawString("Frame# "+player.getFrame(), 10,10);
        }
    }

    // private void drawShot(Graphics g) {
    //     if (shot.isVisible()) {
    //         g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
    //     }
    // }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.white);

        if (inGame) {

            // g.drawLine(0, GROUND,
            //         BOARD_WIDTH, GROUND);
            drawPlayer(g);
            // drawShot(g);

        } else {

            if (timer.isRunning()) {
                timer.stop();
            }

            // gameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void update() {

        // player
        player.act();

        // shot
        // if (shot.isVisible()) {
        //     int shotX = shot.getX();
        //     int shotY = shot.getY();
        //     for (Enemy enemy : enemies) {
        //         // Collision detection: shot and enemy
        //         int enemyX = enemy.getX();
        //         int enemyY = enemy.getY();
        //         if (enemy.isVisible() && shot.isVisible()
        //                 && shotX >= (enemyX)
        //                 && shotX <= (enemyX + ALIEN_WIDTH)
        //                 && shotY >= (enemyY)
        //                 && shotY <= (enemyY + ALIEN_HEIGHT)) {
        //             var ii = new ImageIcon(IMG_EXPLOSION);
        //             enemy.setImage(ii.getImage());
        //             enemy.setDying(true);
        //             deaths++;
        //             shot.die();
        //         }
        //     }
        //     int y = shot.getY();
        //     y -= 4;
        //     if (y < 0) {
        //         shot.die();
        //     } else {
        //         shot.setY(y);
        //     }
        // }
    }

    private void doGameCycle() {
        update();
        repaint();
    }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            doGameCycle();
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            int x = player.getX();
            int y = player.getY();

            int key = e.getKeyCode();

            // if (key == KeyEvent.VK_SPACE && inGame && !shot.isVisible()) {
            //     shot = new Shot(x, y);
            // }
        }
    }
}
