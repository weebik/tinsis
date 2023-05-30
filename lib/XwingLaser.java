package lib;

import java.awt.Rectangle;

public class XwingLaser extends Sprite {
    private final int LASER_SPEED = 7;

    public XwingLaser(int x, int y) {
        super(x, y);
        initLaser();
    }

    private void initLaser() {
        loadImage("src/resources/laserXwing.png");
        getImageDimensions();
    }

    public void move() {
        y -= LASER_SPEED;
        if (y < 0)
            visible = false;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}