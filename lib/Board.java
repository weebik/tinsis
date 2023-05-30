package lib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener, KeyListener {
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 900;
    private static final int START_POS_X = 250;
    private static final int START_POS_Y = 700;
    private final int DELAY = 10;
    private Timer timer;
    private Xwing xwing;
    private List<Tie> tiefighters;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(this);
        setBackground(Color.BLACK);
        setFocusable(true);

        xwing = new Xwing(START_POS_X, START_POS_Y);
        tiefighters = new ArrayList<>();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawStars(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        Random rand = new Random();
        for (int i = 0; i < 15; i++) {
            int x = rand.nextInt(getWidth());
            int y = rand.nextInt(getHeight());
            g2d.drawLine(x, y, x, y + 25);
        }
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        drawStars(g2d);

        g2d.drawImage(xwing.getImage(), xwing.getX(), xwing.getY(), this);
        for (Tie tie : tiefighters) {
            g2d.drawImage(tie.getImage(), tie.getX(), tie.getY(), this);
            for (TieLaser laser : tie.getLasers()) {
                if (laser.isVisible())
                    g2d.drawImage(laser.getImage(), laser.getX(), laser.getY(), this);
            }
        }

        List<XwingLaser> lasers = xwing.getLasers();
        for (XwingLaser laser : lasers)
            g2d.drawImage(laser.getImage(), laser.getX(), laser.getY(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateLasers();
        updateXwing();
        updateTies();
        // checkCollision();
        repaint();
    }

    private void updateLasers() {
        List<XwingLaser> xwingLasers = xwing.getLasers();
        List<TieLaser> tieLasers = new ArrayList<>();

        for (int i = 0; i < xwingLasers.size(); i++) {
            XwingLaser xwingLaser = xwingLasers.get(i);
            if (xwingLaser.isVisible())
                xwingLaser.move();
            else
                xwingLasers.remove(i);
        }

        for (Tie tie : tiefighters) {
            for (int i = 0; i < tie.getLasers().size(); i++) {
                TieLaser laser = tie.getLasers().get(i);
                if (laser.isVisible())
                    laser.move();
                else
                    tieLasers.add(laser);
            }
            tie.getLasers().removeAll(tieLasers);
            tieLasers.clear();
        }
    }

    private void updateXwing() {
        xwing.move();
    }

    private void updateTies() {
        Random rand = new Random();
        if (rand.nextInt(1000) < 10 && tiefighters.size() < 5)
            tiefighters.add(new Tie(rand.nextInt(getWidth()), 0));

        for (Tie tie : tiefighters) {
            if (tie.isVisible())
                tie.move();
            else
                tiefighters.remove(tie);

            if (rand.nextInt(1000) < 10)
                tie.fire();
        }
    }

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }

    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        xwing.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        xwing.keyReleased(e);
    }
}