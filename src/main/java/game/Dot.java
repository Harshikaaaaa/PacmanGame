package game;

import java.awt.*;

public class Dot {
    private int x, y;
    private final int size = 8;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x - size / 2, y - size / 2, size, size);
    }

    public Rectangle getBounds() {
        return new Rectangle(x - size / 2, y - size / 2, size, size);
    }
}
