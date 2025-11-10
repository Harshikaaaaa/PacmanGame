package game;

import java.awt.*;

public class Maze {
    private int[][] grid = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,1,0,0,0,1,0,0,0,1},
            {1,0,1,0,1,0,1,0,1,0,1,0,1},
            {1,0,1,0,0,0,1,0,0,0,1,0,1},
            {1,0,1,0,1,1,1,1,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    public static final int SIZE = 40;

    public boolean isWall(int x, int y) {
        return grid[y][x] == 1;
    }

    public boolean eatPellet(int x, int y) {
        if (grid[y][x] == 0) {
            grid[y][x] = 2;
            return true;
        }
        return false;
    }

    public boolean allPelletsEaten() {
        for (int[] row : grid)
            for (int cell : row)
                if (cell == 0) return false;
        return true;
    }

    public void draw(Graphics2D g) {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 1) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x * SIZE, y * SIZE, SIZE, SIZE);
                } else if (grid[y][x] == 0) {
                    g.setColor(Color.WHITE);
                    g.fillOval(x * SIZE + SIZE / 2 - 3, y * SIZE + SIZE / 2 - 3, 6, 6);
                }
            }
        }
    }
}
