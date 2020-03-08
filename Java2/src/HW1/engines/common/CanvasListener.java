package HW2.engines.common;

import java.awt.*;

public interface CanvasListener {
    void onCanvasRepainted(MainCanvas canvas, Graphics g, float deltaTime);
}
