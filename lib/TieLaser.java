package lib;

import java.awt.Rectangle;

public class TieLaser extends Sprite {
    private final int LASER_SPEED = 4;

    public TieLaser(int x, int y) {
        super(x, y);
        initLaser();
    }

    private void initLaser() {
        loadImage("src/resources/laserTie.png");
        getImageDimensions();
    }

    public void move() {
        y += LASER_SPEED;
        if (y > 900)
            visible = false;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
