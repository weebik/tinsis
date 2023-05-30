package lib;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tie extends Sprite {
    private static final int TIE_SPEED = 2;
    private final int COOLDOWN = 500;
    private long lastShotTime = 0;
    private int dx;
    private int dy;
    private List<TieLaser> lasers;

    public Tie(int x, int y) {
        super(x, y);
        initTie();
    }

    private void initTie() {
        lasers = new ArrayList<>();
        loadImage("src/resources/tiefighter.png");
        getImageDimensions();
    }

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

    public List<TieLaser> getLasers() {
        return lasers;
    }

    public void fire() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastShotTime > COOLDOWN) {
            lastShotTime = currentTime;
            lasers.add(new TieLaser(x + (width / 2) - 4, y));
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
