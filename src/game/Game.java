package game;

import javax.swing.*;
import java.awt.event.*;

public class Game extends JFrame {
    private Draw draw = new Draw();
    private Bird bird = new Bird();

    public Game() {
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500, 200);
        add(draw);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                bird.jump();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bird.jump();
            }
        });
    }

    public static void main(String[] args) {
        Game game = new Game();
    }

}
