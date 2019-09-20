package game;

import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel implements Runnable {
    Bird bird = new Bird();
    Pipe pipe = new Pipe();

    Thread thread;

    public Draw() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.cyan);
        graphics.fillRect(0, 0, getWidth(), getHeight());

        pipe.drawPipe(graphics);

        graphics.setColor(Color.green);
        graphics.fillRect(0, 400, getWidth(), getHeight());

        graphics.setColor(Color.orange);
        graphics.fillRect(0, 410, getWidth(), getHeight());

        bird.drawBird(graphics);
    }

    private boolean checkDie() {
        if (Bird.getHight() >= 380 || Bird.getHight() < -35) {
            return true;
        }

        if (bird.getDeadPoint() < 1000) {
            return false;
        }

        return false;
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            pipe.decreaseWidth();

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pipe.repeat();

            bird.inceaseHight();

            if (checkDie()) {
                thread.stop();
            }
            ;
        }
    }
}
