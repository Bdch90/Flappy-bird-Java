package game;

import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel implements Runnable {
    private int hightOfBird;
    private static int score = 0;
    private Bird bird = new Bird();
    private Pipe pipe = new Pipe();

    private final static int leftDie = 40;
    private final static int botDie = -35;
    private final static int topDie = 380;

    Thread thread;

    Draw() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics graphics) {
        createGame(graphics);
    }

    private void createGame(Graphics graphics) {

        drawSky(graphics);

        pipe.drawPipe(graphics);

        drawGrass(graphics);
        drawEarth(graphics);

        bird.drawBird(graphics);
    }

    private void drawSky(Graphics graphics) {
        graphics.setColor(Color.cyan);
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    private void drawGrass(Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fillRect(0, 400, getWidth(), getHeight());
    }

    private void drawEarth(Graphics graphics) {
        graphics.setColor(Color.orange);
        graphics.fillRect(0, 410, getWidth(), getHeight());
    }

    private boolean checkDie() {
        hightOfBird = bird.getY();

        if (hightOfBird >= topDie || hightOfBird < -botDie) {
            return true;
        }

        if ((hightOfBird < pipe.getY1() && pipe.getX1() < leftDie && (pipe.getX1() + 50 >= leftDie)) ||
                (hightOfBird > pipe.getY1() + 200 && pipe.getX1() < leftDie && (pipe.getX1() + 50 >= leftDie))) {
            return true;
        }

        if ((hightOfBird < pipe.getY2() && pipe.getX2() < leftDie && (pipe.getX2() + 50 >= leftDie)) ||
                (hightOfBird > pipe.getY2() + 200 && pipe.getX2() < leftDie && (pipe.getX2() + 50 >= leftDie))) {
            return true;
        }

        if ((hightOfBird < pipe.getY3() && pipe.getX3() < leftDie && (pipe.getX3() + 50 >= leftDie)) ||
                (hightOfBird > pipe.getY3() + 200 && pipe.getX3() < leftDie && (pipe.getX3() + 50 >= leftDie))) {
            return true;
        }

        if ((hightOfBird < pipe.getY4() && pipe.getX4() < leftDie && (pipe.getX4() + 50 >= leftDie)) ||
                (hightOfBird > pipe.getY4() + 200 && pipe.getX4() < leftDie && (pipe.getX4() + 50 >= leftDie))) {
            return true;
        }

        return false;
    }

    void inceaseScore() {
        int checkPipe1 = pipe.getX1() + 50;
        int checkPipe2 = pipe.getX2() + 50;
        int checkPipe3 = pipe.getX3() + 50;
        int checkPipe4 = pipe.getX4() + 50;

        if (hightOfBird == checkPipe1 || hightOfBird == checkPipe2 || hightOfBird == checkPipe3 || hightOfBird == checkPipe4) {
            score++;
            System.out.println(score);
        }
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

            inceaseScore();
        }
    }
}
