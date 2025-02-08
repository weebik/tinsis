package lib;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Handling display and physics
 */
public class Board extends JPanel implements ActionListener, KeyListener {
    private int WINDOW_HEIGHT = Commons.WINDOW_HEIGHT;
    private int WINDOW_WIDTH = Commons.WINDOW_WIDTH;
    private int START_POS_X = Commons.START_POS_X;
    private int START_POS_Y = Commons.START_POS_Y;
    private int score = Commons.score;
    private int DELAY = Commons.DELAY;
    private Timer timer;
    private Xwing xwing;
    private List<Tie> tiefighters;
    private List<TieLaser> tieLasers = new ArrayList<>();
    private boolean gameEnded = false;

    /**
     * Initialize new Board
     */
    public Board() {
        initBoard();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameEnded) {
            drawGameOverScreen(g);
        } else {
            doDrawing(g);
            Toolkit.getDefaultToolkit().sync();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateLasers();
        updateXwing();
        updateTies();
        checkCollision();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        xwing.keyPressed(e);
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_R)
            restartGame();
        if (key == KeyEvent.VK_Q)
            System.exit(0);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        xwing.keyReleased(e);
    }

    /**
     * Ends game and switching to restart window
     */
    private void endGame() {
        gameEnded = true;
        timer.stop();
        repaint();
    }

    /**
     * Initialize Board with Background, size and objects
     * Starts Timer
     */
    private void initBoard() {
        addKeyListener(this);
        setBackground(Color.BLACK);
        setFocusable(true);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setMaximumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        xwing = new Xwing(START_POS_X, START_POS_Y);
        tiefighters = new ArrayList<>();
        tieLasers = new ArrayList<>();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    /**
     * Generates random white lines representing stars
     * 
     * @param g2d Graphics2D
     */
    private void drawStars(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        Random rand = new Random();
        for (int i = 0; i < 15; i++) {
            int x = rand.nextInt(getWidth());
            int y = rand.nextInt(getHeight());
            Random rand2 = new Random();
            int lenght = rand2.nextInt(15, 50);
            g2d.drawLine(x, y, x, y + lenght);
        }
    }

    /**
     * Paints every component on screen
     * 
     * @param g Graphics
     */
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.WHITE);
        g.setFont(new Font("RetroGame", Font.PLAIN, 15));
        String scoreText = "Score: " + score;
        int scoreX = 10;
        int scoreY = 20;
        g.drawString(scoreText, scoreX, scoreY);

        drawStars(g2d);

        g2d.drawImage(xwing.getImage(), xwing.getX(), xwing.getY(), this);
        for (Tie tie : tiefighters) {
            g2d.drawImage(tie.getImage(), tie.getX(), tie.getY(), this);
        }
        for (TieLaser laser : tieLasers) {
            if (laser.isVisible()) {
                g2d.drawImage(laser.getImage(), laser.getX(), laser.getY(), this);
            }
        }

        List<XwingLaser> lasers = xwing.getLasers();
        for (XwingLaser laser : lasers)
            g2d.drawImage(laser.getImage(), laser.getX(), laser.getY(), this);
    }

    /**
     * Updates positions of lasers
     */
    private void updateLasers() {
        List<XwingLaser> xwingLasers = xwing.getLasers();

        Iterator<XwingLaser> xwingLaserIterator = xwingLasers.iterator();
        while (xwingLaserIterator.hasNext()) {
            XwingLaser xwingLaser = xwingLaserIterator.next();
            if (xwingLaser.isVisible()) {
                xwingLaser.move();
            } else {
                xwingLaserIterator.remove();
            }
        }

        Iterator<TieLaser> tieLaserIterator = tieLasers.iterator();
        while (tieLaserIterator.hasNext()) {
            TieLaser tieLaser = tieLaserIterator.next();
            if (tieLaser.isVisible()) {
                tieLaser.move();
            } else {
                tieLaserIterator.remove();
            }
        }
    }

    /**
     * Updates position of Player
     */
    private void updateXwing() {
        xwing.move();
    }

    /**
     * Updates positions of enemies
     */
    private void updateTies() {
        Random rand = new Random();
        if (rand.nextInt(1000) < 10 && tiefighters.size() < 5) {
            tiefighters.add(new Tie(rand.nextInt(getWidth()), 0));
        }

        Iterator<Tie> iterator = tiefighters.iterator();
        while (iterator.hasNext()) {
            Tie tie = iterator.next();
            if (tie.isVisible()) {
                tie.move();
                if (rand.nextInt(1000) < 10) {
                    tie.fire(tieLasers);
                }
            } else {
                iterator.remove();
            }
        }
    }

    /**
     * Checks collisions between lasers, enemies and player
     */
    private void checkCollision() {
        Rectangle xwingBounds = xwing.getBounds();

        Iterator<TieLaser> tieLaserIterator = tieLasers.iterator();
        while (tieLaserIterator.hasNext()) {
            TieLaser laser = tieLaserIterator.next();
            if (xwingBounds.intersects(laser.getBounds())) {
                endGame();
                return;
            }
        }

        Iterator<Tie> iterator = tiefighters.iterator();
        while (iterator.hasNext()) {
            Tie tie = iterator.next();
            Rectangle tieBounds = tie.getBounds();
            if (xwingBounds.intersects(tieBounds)) {
                endGame();
                return;
            }

            Iterator<XwingLaser> laserIterator = xwing.getLasers().iterator();
            while (laserIterator.hasNext()) {
                XwingLaser laser = laserIterator.next();
                if (laser.getBounds().intersects(tieBounds)) {
                    score += 10;
                    laserIterator.remove();
                    iterator.remove();
                    break;
                }
            }
        }
    }

    /**
     * Creates "Game Over" screen
     * 
     * @param g Graphics
     */
    private void drawGameOverScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        FontMetrics fontMetrics = g.getFontMetrics();

        g.setColor(Color.WHITE);

        g.setFont(new Font("RetroGame", Font.BOLD, 40));
        fontMetrics = g.getFontMetrics();
        String gameOverText = "GAME OVER";
        int gameOverX = (getWidth() - fontMetrics.stringWidth(gameOverText)) / 2;
        int gameOverY = (getHeight() - fontMetrics.getHeight()) / 2;
        g.drawString(gameOverText, gameOverX, gameOverY);

        g.setFont(new Font("RetroGame", Font.BOLD, 20));
        fontMetrics = g.getFontMetrics();
        String score = "Your score: " + this.score;
        int scoreX = (getWidth() - fontMetrics.stringWidth(score)) / 2;
        int scoreY = (getHeight() - fontMetrics.getHeight()) / 2 + 20;
        g.drawString(score, scoreX, scoreY);

        g.setFont(new Font("Arial", Font.PLAIN, 20));
        fontMetrics = g.getFontMetrics();
        String restartText = "PRESS [R] TO RESTART OR [Q] TO QUIT";
        int restartX = (getWidth() - fontMetrics.stringWidth(restartText)) / 2;
        int restartY = gameOverY + fontMetrics.getHeight() + 50;
        g.drawString(restartText, restartX, restartY);
    }

    /**
     * Restarts game, sets everything to default value
     */
    private void restartGame() {
        score = 0;
        xwing = new Xwing(START_POS_X, START_POS_Y);
        tiefighters.clear();
        tieLasers.clear();
        timer.restart();
        gameEnded = false;
        timer.start();
        repaint();
    }
}