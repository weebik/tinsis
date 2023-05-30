package lib;

import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Xwing extends Sprite {
    private int XWING_SPEED = 3;
    private final int COOLDOWN = 300;
    private long lastShotTime = 0;
    private int dx;
    private int dy;
    private List<XwingLaser> lasers;

    public Xwing(int x, int y) {
        super(x, y);
        initXwing();
    }

    private void initXwing() {
        lasers = new ArrayList<>();
        loadImage("src/resources/xwing.png");
        getImageDimensions();
    }

    public void move() {
        int nextX = x + dx;
        int nextY = y + dy;

        if (nextX <= 0)
            x = 0;
        else if (nextX + width > Board.getWindowWidth())
            x = Board.getWindowWidth() - width;
        else
            x = nextX;

        if (nextY <= 0)
            y = 0;
        else if (nextY >= Board.getWindowHeight() - 2 * height)
            y = Board.getWindowHeight() - 2 * height;
        else
            y = nextY;
    }

    public List<XwingLaser> getLasers() {
        return lasers;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastShotTime > COOLDOWN) {
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
        if (key == KeyEvent.VK_R)
            System.out.println(height);
        if (key == KeyEvent.VK_Q)
            System.exit(0);

    }

    public void fire() {
        lasers.add(new XwingLaser(x + (width / 2) - 4, y));
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)
            dx = 0;
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
            dx = 0;
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W)
            dy = 0;
        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S)
            dy = 0;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}