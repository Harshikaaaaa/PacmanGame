package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private Maze maze;
    private Pacman pacman;
    private java.util.List<Ghost> ghosts;
    private boolean gameOver = false;
    private boolean gameWin = false;

    public GamePanel() {
        setPreferredSize(new Dimension(520, 320));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        initGame();

        timer = new Timer(150, this); // speed control (smaller = faster)
        timer.start();
    }

    private void initGame() {
        maze = new Maze();
        pacman = new Pacman(1, 1, maze);

        ghosts = new ArrayList<>();
        ghosts.add(new Ghost(6, 3, Color.RED, maze));
        ghosts.add(new Ghost(2, 5, Color.CYAN, maze));
        ghosts.add(new Ghost(10, 5, Color.PINK, maze));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver || gameWin) return;

        pacman.update();

        for (Ghost g : ghosts) {
            g.update(pacman);
            if (g.collidesWith(pacman)) {
                gameOver = true;
            }
        }

        if (maze.allPelletsEaten()) {
            gameWin = true;
        }

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        maze.draw(g2);
        pacman.draw(g2);
        for (Ghost ghost : ghosts) {
            ghost.draw(g2);
        }

        if (gameOver) {
            drawCenteredText(g2, "Game Over - Press R to Restart");
        } else if (gameWin) {
            drawCenteredText(g2, "YOU WIN! Press R to Restart");
        }
    }

    private void drawCenteredText(Graphics2D g, String text) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(text)) / 2;
        int y = getHeight() / 2;
        g.drawString(text, x, y);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver || gameWin) {
            if (e.getKeyCode() == KeyEvent.VK_R) {
                gameOver = false;
                gameWin = false;
                initGame();
            }
            return;
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                pacman.setDirection(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                pacman.setDirection(1, 0);
                break;
            case KeyEvent.VK_UP:
                pacman.setDirection(0, -1);
                break;
            case KeyEvent.VK_DOWN:
                pacman.setDirection(0, 1);
                break;
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
