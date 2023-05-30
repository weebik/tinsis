package src;

import lib.*;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Tinsis extends JFrame {

    public Tinsis() {
        initUI();
    }

    private void initUI() {
        add(new Board());
        setSize(Board.getWindowWidth(), Board.getWindowHeight());
        setResizable(false);
        setTitle("There is no sound in space!");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Tinsis ex = new Tinsis();
            ex.setVisible(true);
        });
    }
}