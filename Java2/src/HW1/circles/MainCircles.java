package HW1.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private MyArray<Sprite> sprites = new MyArray<Sprite>(10);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        initApplication();
        MainCanvas canvas = new MainCanvas(this);
        setVisible(true);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    addSprite();
                }

                if(SwingUtilities.isRightMouseButton(e)) {
                    deleteSprite();
                }
            }
        });
        add(canvas);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.getLength(); i++) {
            sprites.set(i, new Ball());
        }
    }

    public void onCanvasRepainted(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.getLength(); i++) {
            sprites.get(i).update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.getLength(); i++) {
            sprites.get(i).render(canvas, g);
        }
    }

    private void addSprite() {
        sprites.add(new Ball());
    }

    private void deleteSprite() {
        sprites.delete();
    }
}
