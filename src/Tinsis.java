package src;

import lib.*;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * Main class creates executable and initialize UI
 */
public class Tinsis extends JFrame {

    /**
     * Creates executable new game
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Tinsis ex = new Tinsis();
            ex.setVisible(true);
        });
    }

    /**
     * Start initUI
     **/
    public Tinsis() {
        initUI();
    }

    /**
     * Initialize UI,
     * creates Board,
     * sets Size and sets Default operations.
     **/

    private void initUI() {
        add(new Board());
        setSize(Commons.WINDOW_WIDTH, Commons.WINDOW_HEIGHT);
        setResizable(false);
        setTitle("There is no sound in space!");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
}