package game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Pipe extends JPanel {
    private int width1 = 500;
    private int width2 = width1 + 140;
    private int width3 = width2 + 140;
    private int width4 = width3 + 140;

    private int height1, height2, height3, height4;

    private boolean isRandom1 = false;
    private boolean isRandom2 = false;
    private boolean isRandom3 = false;
    private boolean isRandom4 = false;

    public void drawPipe(Graphics graphic) {

        Random random = new Random();

        if (!isRandom1) {
            height1 = random.nextInt(200);
            isRandom1 = true;
        }

        if (!isRandom2) {
            height2 = random.nextInt(200);
            isRandom2 = true;
        }

        if (!isRandom3) {
            height3 = random.nextInt(200);
            isRandom3 = true;
        }

        if (!isRandom4) {
            height4 = random.nextInt(200);
            isRandom4 = true;
        }

        createTopPipe(graphic, width1, 50, height1);
        createBottomPipe(graphic, width1, height1 + 100, 500);

        createTopPipe(graphic, width2, 50, height2);
        createBottomPipe(graphic, width2, height2 + 100, 500);

        createTopPipe(graphic, width3, 50, height3);
        createBottomPipe(graphic, width3, height3 + 100, 500);

        createTopPipe(graphic, width4, 50, height4);
        createBottomPipe(graphic, width4, height4 + 100, 500);
    }

    public void createTopPipe(Graphics graphic, int left, int pipeWidth, int pipeHeight) {
        graphic.setColor(Color.green);
        graphic.fillRect(left, 0, pipeWidth, pipeHeight);
    }

    public void createBottomPipe(Graphics graphic, int left, int right, int pipeHeight) {
        graphic.setColor(Color.green);
        graphic.fillRect(left, right, 50, pipeHeight);
    }

    public void decreaseWidth() {
        width1--;
        width2--;
        width3--;
        width4--;
    }

    public void repeat() {
        if (width1 == -50) {
            width1 = 500;
            isRandom1 = false;
        }

        if (width2 == -50) {
            width2 = 500;
            isRandom2 = false;
        }

        if (width3 == -50) {
            width3 = 500;
            isRandom3 = false;
        }

        if (width4 == -50) {
            width4 = 500;
            isRandom4 = false;
        }
    }

}
