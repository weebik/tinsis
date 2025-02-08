package lib;

import java.awt.Rectangle;

/**
 * Enemy object missles
 */
public class TieLaser extends Sprite {
    private int TIE_LASER_SPEED = Commons.TIE_LASER_SPEED;

    /**
     * Initialize enemy's laser with position (x, y)
     * 
     * @param x position x
     * @param y position y
     */
    public TieLaser(int x, int y) {
        super(x, y);
        initLaser();
    }

    /**
     * Transform enemy's Laser position
     */
    public void move() {
        y += TIE_LASER_SPEED;
        if (y > 900)
            visible = false;
    }

    /**
     * Get bounds of enemy laser
     * 
     * @return Rectangle that represents bounds of object
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * Initialize enemy's laser image
     */
    private void initLaser() {
        loadImage("src/assets/laserTie.png");
        getImageDimensions();
    }
}
