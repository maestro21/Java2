package HW1.circles;

import javax.swing.*;
import java.awt.*;

public class Background {

    public static int counter = 0;

    public static void setBackground(JPanel jPanel) {
        if(counter < 50) {
            counter++;
        } else {
            int r = (int)(Math.random() * 255);
            int g = (int)(Math.random() * 255);
            int b = (int)(Math.random() * 255);
            Color color = new Color(r,g,b);
            jPanel.setBackground(color);
            counter = 0;
        }
    }

}

