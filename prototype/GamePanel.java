import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.KeyStroke;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
    private final String SERVERIP;
    private final int CLIENTPORT;
    Client client;

    private int x = 50;
    private int y = 50;
    private int xVelocity = 1;
    private int yVelocity = 0;
    private ArrayList usedCoordinates = new ArrayList();
    private Timer t;
    //private Color colours[] = {Color.cyan, Color.red};
    private String userName;
    private String playerString;

    public GamePanel(int gridHeight, int gridWidth, String userName, String serverIP, int clientPort, String playerString) {
        this.SERVERIP = serverIP;
        this.CLIENTPORT = clientPort;
        this.userName = userName;
        this.playerString = playerString;
        System.out.println(playerString);
        System.out.println(userName);
        try {
            this.client = new Client(CLIENTPORT);
        }catch (Exception e) {
            e.printStackTrace();
        }



        setDoubleBuffered(true);
        setPreferredSize(new Dimension(gridHeight, gridWidth));
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
        String playerArray[] = playerString.split("-");
        for(String player : playerArray) {
            //System.out.print(player);
            String playerComponent[] = player.split(",");
                if(playerComponent[0].equals(userName)) {
                    g2d.setColor(Color.CYAN);
                    //g2d.fillRect(Integer.parseInt(playerComponent[1]), Integer.parseInt(playerComponent[2]), 10, 10);
                } else {
                    g2d.setColor(Color.RED);
                    //g2d.fillRect(Integer.parseInt(playerComponent[1]), Integer.parseInt(playerComponent[2]), 10, 10);
                }
            g2d.fillRect(Integer.parseInt(playerComponent[1]), Integer.parseInt(playerComponent[2]), 10, 10);
        }
        //String playerArray[] = playerString.split("-");
        //for(String player : playerArray) {
        //    //System.out.println(player);
        //    String components[] = player.split(",");
        //    if(components[0].equals(userName)) {
        //        g2d.setColor(colours[0]);
        //        g2d.fillRect(Integer.parseInt(components[1]), Integer.parseInt(components[2]), 10, 10);
        //    } else {
        //        g2d.setColor(colours[1]);
        //        g2d.fillRect(Integer.parseInt(components[1]), Integer.parseInt(components[2]), 10, 10);
        //    }
        //g2d.fillRect(Integer.parseInt(components[1]), Integer.parseInt(components[2]), 10, 10);
        //System.out.println(components[1]);
        //System.out.println(components[2]);


        //}
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
        usedCoordinates.add(x + "," + y);
        repaint();
    }

    //public static void main(String[] args) {
    //    GamePanel testing = new GamePanel();
    //    //testing.setVisible(true);
    //}
}
