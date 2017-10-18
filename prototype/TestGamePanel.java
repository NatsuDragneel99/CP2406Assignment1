import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestGamePanel extends JPanel implements ActionListener {
    private int x = 50;
    private int y = 50;
    private int xVelocity = 1;
    private int yVelocity = 0;
    private Timer t;

    public TestGamePanel() {
        setDoubleBuffered(true);
        t = new Timer(7, this);
        t.start();
        InputMap inputMap = getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();
        inputMap.put(KeyStroke.getKeyStroke("UP"), "upAction");
        actionMap.put("upAction", upAction);
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        actionMap.put("downAction", downAction);
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        actionMap.put("leftAction", leftAction);
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        actionMap.put("rightAction", rightAction);

    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.cyan);
        g2d.fillRect(x, y, 50, 50);
        //myComponent.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), moveDown());
        //myComponent.getActionMap().put("myAction", moveDown());
    }

    Action upAction = new AbstractAction() {
        //@Override
        public void actionPerformed(ActionEvent e) {
            xVelocity = 0;
            yVelocity = -1;
        }
    };

    Action downAction = new AbstractAction() {
        //@Override
        public void actionPerformed(ActionEvent e) {
            xVelocity = 0;
            yVelocity = 1;
        }
    };

    Action leftAction = new AbstractAction() {
        //@Override
        public void actionPerformed(ActionEvent e) {
            xVelocity = -1;
            yVelocity = 0;
        }
    };

    Action rightAction = new AbstractAction() {
        //@Override
        public void actionPerformed(ActionEvent e) {
            xVelocity = 1;
            yVelocity = 0;
        }
    };

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

}
