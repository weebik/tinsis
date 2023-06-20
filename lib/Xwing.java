package lib;

import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 * Player class
 */
public class Xwing extends Sprite {
    private int XWING_SPEED = Commons.XWING_SPEED;
    private int WINDOW_HEIGHT = Commons.WINDOW_HEIGHT;
    private int WINDOW_WIDTH = Commons.WINDOW_WIDTH;
    private long lastShotTime = 0;
    private int dx;
    private int dy;
    private List<XwingLaser> lasers;

    /**
     * Initialize Player with position (x, y)
     * 
     * @param x position x
     * @param y position y
     */
    public Xwing(int x, int y) {
        super(x, y);
        initXwing();
    }

    /**
     * Transform Player's positon
     */
    public void move() {
        int nextX = x + dx;
        int nextY = y + dy;

        if (nextX <= 0)
            x = 0;
        else if (nextX + width >= WINDOW_WIDTH)
            x = WINDOW_WIDTH - width;
        else
            x = nextX;

        if (nextY <= 0)
            y = 0;
        else if (nextY >= WINDOW_HEIGHT - 2 * height)
            y = WINDOW_HEIGHT - 2 * height;
        else
            y = nextY;
    }

    /**
     * @return List of Lasers
     */
    public List<XwingLaser> getLasers() {
        return lasers;
    }

    /**
     * Handling pressed key event
     * 
     * @param e KeyEvent
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastShotTime > Commons.XWING_COOLDOWN) {
                lastShotTime = currentTime;
                fire();
            }
        }
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)
            dx = -XWING_SPEED;
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
            dx = XWING_SPEED;
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W)
            dy = -XWING_SPEED;
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S)
            dy = XWING_SPEED;
    }

    /**
     * Creates new shooted Laser
     */
    public void fire() {
        lasers.add(new XwingLaser(x + (width / 2) - 4, y));
    }

    /**
     * Handling released key event
     * 
     * @param e KeyEvent
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            lastShotTime = 300;
        }
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)
            dx = 0;
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
            dx = 0;
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W)
            dy = 0;
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S)
            dy = 0;
    }

    /**
     * Get Bounds of players spaceship
     * 
     * @return Rectangle that represents bounds of object
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * Initialize Player's spaceship image
     */
    private void initXwing() {
        lasers = new ArrayList<>();
        loadImage("src/resources/xwing.png");
        getImageDimensions();
    }
}