package HW2.engines.common;

import java.awt.*;

public interface GameObject {
    void update(MainCanvas canvas, float deltaTime);
    void render(MainCanvas canvas, Graphics g);
}
