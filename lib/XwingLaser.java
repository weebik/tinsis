package lib;

import java.awt.Rectangle;

/**
 * Player lasers
 */
public class XwingLaser extends Sprite {
    private int XWING_LASER_SPEED = Commons.XWING_LASER_SPEED;

    /**
     * Initialize laser with position (x, y)
     * 
     * @param x position x
     * @param y position y
     */
    public XwingLaser(int x, int y) {
        super(x, y);
        initLaser();
    }

    /**
     * Transform Laser's position
     */
    public void move() {
        y -= XWING_LASER_SPEED;
        if (y < 0)
            visible = false;
    }

    /**
     * Get bounds of player's missle
     * 
     * @return Rectangle that represents bounds of object
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * Initialize Player's Laser image
     */
    private void initLaser() {
        loadImage("src/resources/laserXwing.png");
        getImageDimensions();
    }
}