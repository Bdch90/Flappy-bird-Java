package game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class Pipe extends JPanel {
    private int x1 = 500;
    private int x2 = x1 + 140;
    private int x3 = x2 + 140;
    private int x4 = x3 + 140;

    private int y1, y2, y3, y4;

    private boolean isRandom1 = false;
    private boolean isRandom2 = false;
    private boolean isRandom3 = false;
    private boolean isRandom4 = false;

    void drawPipe(Graphics graphic) {

        Random random = new Random();

        if (!isRandom1) {
            y1 = random.nextInt(200);
            isRandom1 = true;
        }

        if (!isRandom2) {
            y2 = random.nextInt(200);
            isRandom2 = true;
        }

        if (!isRandom3) {
            y3 = random.nextInt(200);
            isRandom3 = true;
        }

        if (!isRandom4) {
            y4 = random.nextInt(200);
            isRandom4 = true;
        }

        createTopPipe(graphic, x1, y1);
        createBottomPipe(graphic, x1, y1 + 200);

        createTopPipe(graphic, x2, y2);
        createBottomPipe(graphic, x2, y2 + 200);

        createTopPipe(graphic, x3, y3);
        createBottomPipe(graphic, x3, y3 + 200);

        createTopPipe(graphic, x4, y4);
        createBottomPipe(graphic, x4, y4 + 200);
    }

    void createTopPipe(Graphics graphic, int left, int pipeHeight) {
        graphic.setColor(Color.green);
        graphic.fillRect(left, 0, 50, pipeHeight);
    }

    void createBottomPipe(Graphics graphic, int x, int y) {
        graphic.setColor(Color.green);
        graphic.fillRect(x, y, 50, 500);
    }

    void decreaseWidth() {
        x1--;
        x2--;
        x3--;
        x4--;
    }

    void repeat() {
        if (x1 == -40) {
            x1 = 500;
            isRandom1 = false;
        }

        if (x2 == -40) {
            x2 = 500;
            isRandom2 = false;
        }

        if (x3 == -40) {
            x3 = 500;
            isRandom3 = false;
        }

        if (x4 == -40) {
            x4 = 500;
            isRandom4 = false;
        }
    }

    int getX1() {
        return x1;
    }

    int getX2() {
        return x2;
    }

    int getX3() {
        return x3;
    }

    int getX4() {
        return x4;
    }

    int getY1() {
        return y1;
    }

    int getY2() {
        return y2;
    }

    int getY3() {
        return y3;
    }

    int getY4() {
        return y4;
    }

}
