package game;

import java.awt.*;

public class Pacman {
    private int x, y;
    private int dx, dy;
    private Maze maze;

    public Pacman(int x, int y, Maze maze) {
        this.x = x;
        this.y = y;
        this.maze = maze;
    }

    public void setDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void update() {
        int newX = x + dx;
        int newY = y + dy;
        if (!maze.isWall(newX, newY)) {
            x = newX;
            y = newY;
            maze.eatPellet(x, y);
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x * Maze.SIZE + 5, y * Maze.SIZE + 5, Maze.SIZE - 10, Maze.SIZE - 10);
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
