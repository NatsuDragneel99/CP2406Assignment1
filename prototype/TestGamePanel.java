import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestGamePanel extends JPanel implements ActionListener,KeyListener {
    private int x = 50;
    private int y = 50;
    private int xVelocity = 1;
    private int yVelocity = 0;
    private Timer t;

    public TestGamePanel() {
        setDoubleBuffered(true);
        t = new Timer(7, this);
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(x, y, 10, 10);

    }

    void moveUp() {
        xVelocity = 0;
        yVelocity = -1;
    }
    void moveDown() {
        xVelocity = 0;
        yVelocity = 1;
    }
    void moveLeft() {
        xVelocity = -1;
        yVelocity = 0;
    }
    void moveRight() {
        xVelocity = 1;
        yVelocity = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x = x + xVelocity;
        y = y + yVelocity;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            moveUp();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            moveDown();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
