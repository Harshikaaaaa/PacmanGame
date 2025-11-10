package game;

import java.awt.*;
import java.util.Random;

public class Ghost {
    private int x, y;
    private Color color;
    private Maze maze;
    private int dx, dy;
    private Random rand = new Random();

    public Ghost(int x, int y, Color color, Maze maze) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.maze = maze;
        randomDirection();
    }

    private void randomDirection() {
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int[] dir = dirs[rand.nextInt(4)];
        dx = dir[0];
        dy = dir[1];
    }

    public void update(Pacman pacman) {
        int newX = x + dx;
        int newY = y + dy;

        // Change direction if wall hit
        if (maze.isWall(newX, newY)) {
            randomDirection();
            newX = x + dx;
            newY = y + dy;
        }

        // Move
        if (!maze.isWall(newX, newY)) {
            x = newX;
            y = newY;
        }

        // Occasionally change direction randomly
        if (rand.nextInt(10) == 0) randomDirection();
    }

    public boolean collidesWith(Pacman pacman) {
        return pacman.getX() == x && pacman.getY() == y;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x * Maze.SIZE + 10, y * Maze.SIZE + 10, Maze.SIZE - 20, Maze.SIZE - 20);
    }
}
