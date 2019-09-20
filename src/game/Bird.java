package game;

import javax.swing.*;
import java.awt.*;

public class Bird extends JPanel {

    private static int hight = 200;
    private int deadPoint = 200;

    public Bird() {
    }

    public void drawBird(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillRect(20, hight, 20, 20);
    }

    public void inceaseHight() {
        hight++;
    }

    public void jump() {
        hight -= 60;
        System.out.println(hight);
    }

    public static int getHight() {
        return hight;
    }

    public int getDeadPoint() {
        return deadPoint;
    }

    public void setDeadPoint(int deadPoint) {
        this.deadPoint = deadPoint;
    }

}
