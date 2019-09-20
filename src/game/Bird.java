package game;

import javax.swing.*;
import java.awt.*;

public class Bird extends JPanel {

    private static int y = 200;

    Bird() {
    }

    void drawBird(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillRect(20, y, 20, 20);
    }

    void inceaseHight() {
        y++;
    }

    void jump() {
        y -= 50;
    }

    public int getY() {
        return y;
    }

}
