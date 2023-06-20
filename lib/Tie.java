package lib;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Enemy object class
 */
public class Tie extends Sprite {
    private int TIE_SPEED = Commons.TIE_SPEED;
    private int TIE_COOLDOWN = Commons.TIE_COOLDOWN;
    private long lastShotTime = 0;
    private int dx;
    private int dy;
    private List<TieLaser> lasers;

    /**
     * Initialize enemy object with position (x, y)
     * 
     * @param x position x
     * @param y position y
     */
    public Tie(int x, int y) {
        super(x, y);
        initTie();
    }

    /**
     * Randomly transforms enemies positions
     */
    public void move() {
        Random rand = new Random();
        int randNum = rand.nextInt(50);

        if (randNum == 0) {
            dx = rand.nextInt(3) - 1;
            dy = rand.nextInt(3) - 1;
        }

        x += dx * TIE_SPEED;
        y += dy * TIE_SPEED;

        if (x < 1) {
            x = 1;
            dx = 1;
        }

        if (y < 1) {
            y = 1;
            dy = 1;
        }

        if (x > 700 - width) {
            x = 700 - width;
            dx = -1;
        }

        if (y > 400 - height) {
            y = 400 - height;
            dy = -1;
        }
    }

    /**
     * @return List of enemy lasers
     */
    public List<TieLaser> getLasers() {
        return lasers;
    }

    /**
     * Fires enemy lasers
     */
    public void fire() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastShotTime > TIE_COOLDOWN) {
            lastShotTime = currentTime;
            lasers.add(new TieLaser(x + (width / 2) - 4, y));
        }
    }

    /**
     * Get bounds of enemy spaceship
     * 
     * @return Rectangle that represents bounds of object
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * Initialize Enemies image
     */
    private void initTie() {
        lasers = new ArrayList<>();
        loadImage("src/resources/tiefighter.png");
        getImageDimensions();
    }
}
