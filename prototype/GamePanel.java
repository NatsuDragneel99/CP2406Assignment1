import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.KeyStroke;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
public class GamePanel extends JPanel implements ActionListener {
    private final String SERVERIP;
    private final int CLIENTPORT;
    Client client;

    private int x = 0;
    private int y = 0;
    private int xVelocity = 0;
    private int yVelocity = 0;
    private Timer t;
    private String userName;
    private String playerString;
    private String updatedPlayerString = "";
    private int score;
    private String userAction;
    private GameFrame gameFrame;

    private int xPositions[] = new int[50000];
    private int yPositions[] = new int[50000];
    private int otherXPositions[] = new int[50000];
    private int otherYPositions[] = new int[50000];
    private Rectangle otherTrails[] = new Rectangle[50000];
    private Rectangle trails[] = new Rectangle[50000];
    private Rectangle player;
    private Rectangle otherPlayer;

    public GamePanel(GameFrame gameFrame, int gridHeight, int gridWidth, String userName, String serverIP, int clientPort, String playerString, Client client) {
        this.gameFrame = gameFrame;
        this.SERVERIP = serverIP;
        this.CLIENTPORT = clientPort;
        this.client = client;
        this.userName = userName.trim();
        this.playerString = playerString.trim();
        setBackground(Color.BLACK);
        String playerArray[] = playerString.trim().split("-");
        for(String player : playerArray) {
            String playerComponent[] = player.trim().split(",");
            String playerName = playerComponent[0].trim();
            if(playerName.equals(userName)) {
                System.out.println(playerComponent[1].trim());
                System.out.println(x);
                System.out.println(y);
                x = Integer.parseInt(playerComponent[1].trim());
                y = Integer.parseInt(playerComponent[2].trim());
                if(x < gridWidth/2 && y < gridHeight/2) { //bike in top left corner goes down
                    userAction = "TURN down";
                    this.xVelocity = 0;
                    this.yVelocity = 1;
                } else if(x > gridWidth/2 && y > gridHeight/2) { //bike in top right corner goes left
                    userAction = "TURN left";
                    this.xVelocity = -1;
                    this.yVelocity = 0;
                } else if(x < gridWidth/2 && y > gridHeight/2) { //bike in bottom left corner goes right
                    userAction = "TURN right";
                    this.xVelocity = 1;
                    this.yVelocity = 0;
                }else if(x > gridWidth/2 && y > gridHeight/2) { //bike in bottom right corner goes up
                    userAction = "TURN up";
                    this.xVelocity = 0;
                    this.yVelocity = -1;
                }
            }
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
        String playerArray[] = playerString.trim().split("-");
        for(int i = 0; i < 3; i++) {
            String playerComponent[] = playerArray[i].trim().split(",");
            String playerName = playerComponent[0].trim();
            if(Integer.parseInt(playerComponent[1].trim()) < 0 || Integer.parseInt(playerComponent[2].trim()) < 0 || Integer.parseInt(playerComponent[1].trim()) > 900 || Integer.parseInt(playerComponent[2].trim()) > 900) {
                if(playerName.equals(userName)) {
                    t.stop();
                    gameFrame.loadScoreBoard(score);
                    for(int position : xPositions) {
                        System.out.print(position + " ");
                    }
                    System.out.println("-----------");
                    for(int position : yPositions) {
                        System.out.print(position + " ");
                    }
                    System.out.println("-----------");
                    for(int position : otherXPositions) {
                        System.out.print(position + " ");
                    }
                    System.out.println("-----------");
                    for(int position : otherYPositions) {
                        System.out.print(position + " ");
                    }
                    System.out.println("-----------");
                }
            } else if(playerName.equals(userName)) {
                //for(int f = 0; i < xPositions.length; i++) {
                //    if (xPositions[f] != 0 && yPositions[f] != 0) {
                //        g2d.setColor(Color.CYAN);
                //        player = new Rectangle(xPositions[f], yPositions[f], 10, 10);
                //        trails[f] = player;
                //        g2d.fill(player);
                //    }
                //}

                g2d.setColor(Color.CYAN);
                g2d.fillRect(Integer.parseInt(playerComponent[1].trim()), Integer.parseInt(playerComponent[2].trim()), 10, 10);
                score++;
                //g2d.setColor(Color.CYAN);
                g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g2d.drawString("Score: " + Integer.toString(score), 10, 20);

                } else {
                    try {
                        g2d.setColor(Color.RED);
                        g2d.fillRect(Integer.parseInt(playerComponent[1].trim()), Integer.parseInt(playerComponent[2].trim()), 10, 10);
                    } catch(Exception e) {
                        System.out.println("Other player crashed");
                    }
            }
        }
    }


    void getNewCoordinates(String newPlayerString) {
        System.out.println("***********");
        System.out.println("Old " + playerString);
        System.out.println("Received " + newPlayerString.trim());
        this.playerString = newPlayerString.trim();
        System.out.println("New" + playerString);
        System.out.println("***********");

    }

    Action upAction = new AbstractAction() {
        //@Override
        public void actionPerformed(ActionEvent e) {
            userAction = "TURN up";
            xVelocity = 0;
            yVelocity = -1;
        }
    };

    Action downAction = new AbstractAction() {
        //@Override
        public void actionPerformed(ActionEvent e) {
            userAction = "TURN down";
            xVelocity = 0;
            yVelocity = 1;
        }
    };

    Action leftAction = new AbstractAction() {
        //@Override
        public void actionPerformed(ActionEvent e) {
            userAction = "TURN left";
            xVelocity = -1;
            yVelocity = 0;
        }
    };

    Action rightAction = new AbstractAction() {
        //@Override
        public void actionPerformed(ActionEvent e) {
            userAction = "TURN right";
            xVelocity = 1;
            yVelocity = 0;
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        x = x + xVelocity;
        y = y + yVelocity;

        //String playerArray[] = playerString.trim().split("-");
        //for(int i = 0; i < 3; i++) {
        //    String playerComponent[] = playerArray[i].trim().split(",");
        //    String playerName = playerComponent[0].trim();
        //    if (playerName.equals(userName)) {
        //        for (int f = 0; f < xPositions.length; f++) {
        //            if (xPositions[f] == 0) {
        //                xPositions[f] = Integer.parseInt(playerComponent[1].trim());
        //                yPositions[f] = Integer.parseInt(playerComponent[2].trim());
        //                break;
        //            }
        //        }
        //    } else {
        //        for (int f = 0; f < otherXPositions.length; f++) {
        //            if(otherXPositions[f] == 0) {
        //                otherXPositions[f] = Integer.parseInt(playerComponent[1].trim());
        //                otherYPositions[f] = Integer.parseInt(playerComponent[2].trim());
        //                break;
        //            }
        //        }
        //    }
        //}

        String playerMovement = "USER " + userName + " " + userAction;
        try {
            client.send(SERVERIP, playerMovement.trim());
        } catch (Exception e1) {
            e1.printStackTrace();
        }


        System.out.println("--------------------");
        System.out.println(updatedPlayerString);
        System.out.println("x " + x);
        System.out.println("y " + y);
        System.out.println("x " + xVelocity);
        System.out.println("y " + yVelocity);
        System.out.println("--------------------");

        repaint();
    }
}
