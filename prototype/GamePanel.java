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
    //private ArrayList usedCoordinates = new ArrayList();
    private Timer t;
    //private Color colours[] = {Color.cyan, Color.red};
    int[][] playerCoordinates;
    private String userName;
    private String playerString;
    private String updatedPlayerString = "";
    private int score;
    InetAddress address;
    String userAction;
    GameFrame gameFrame;

    int xPositions[] = new int[50000];
    int yPositions[] = new int[50000];
    Rectangle trails[] = new Rectangle[50000];

    public GamePanel(GameFrame gameFrame, int gridHeight, int gridWidth, String userName, String serverIP, int clientPort, String playerString, Client client) {
        this.gameFrame = gameFrame;
        this.SERVERIP = serverIP;
        this.CLIENTPORT = clientPort;
        this.client = client;
        this.userName = userName.trim();
        this.playerString = playerString.trim();
        //setSize(new Dimension(900,900));
        String playerArray[] = playerString.trim().split("-");
        for(String player : playerArray) {
            //System.out.print(player);
            String playerComponent[] = player.trim().split(",");
            String playerName = playerComponent[0].trim();
            if(playerName.equals(userName)) {
                System.out.println(playerComponent[1].trim());
                System.out.println(x);
                System.out.println(y);
                x = Integer.parseInt(playerComponent[1].trim());
                y = Integer.parseInt(playerComponent[2].trim());
                if(x < gridWidth/2 && y < gridHeight/2) { //bike in top left corner it goes down
                    userAction = "TURN down";
                    this.xVelocity = 0;
                    this.yVelocity = 1;
                } else if(x > gridWidth/2 && y > gridHeight/2) { //bike in top right corner it goes left
                    userAction = "TURN left";
                    this.xVelocity = -1;
                    this.yVelocity = 0;
                } else if(x < gridWidth/2 && y > gridHeight/2) { //bike in bottom left corner it goes right
                    userAction = "TURN right";
                    this.xVelocity = 1;
                    this.yVelocity = 0;
                }else if(x > gridWidth/2 && y > gridHeight/2) { //bike in bottom right corner it goes up
                    userAction = "TURN up";
                    this.xVelocity = 0;
                    this.yVelocity = -1;
                }
            }
        }
        //System.out.println(playerString);
        //System.out.println(userName);

        //try {
        //    this.client = new Client(CLIENTPORT);
        //}catch (Exception e) {
        //    e.printStackTrace();
        //}



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
            //System.out.print(player);
            String playerComponent[] = playerArray[i].trim().split(",");
            String playerName = playerComponent[0].trim();
            if(Integer.parseInt(playerComponent[1].trim()) < 0 || Integer.parseInt(playerComponent[2].trim()) < 0 || Integer.parseInt(playerComponent[1].trim()) > 900 || Integer.parseInt(playerComponent[2].trim()) > 900) {
                if(playerName.equals(userName)) {
                    t.stop();
                    gameFrame.loadScoreBoard(score);
                }
            } else if(playerName.equals(userName)) {
                g2d.setColor(Color.CYAN);
                g2d.fillRect(Integer.parseInt(playerComponent[1].trim()), Integer.parseInt(playerComponent[2].trim()), 10, 10);
                score++;
                } else {
                g2d.setColor(Color.RED);
                g2d.fillRect(Integer.parseInt(playerComponent[1].trim()), Integer.parseInt(playerComponent[2].trim()), 10, 10);
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
        //for(String player : playerArray) {
        //    //System.out.print(player);
        //    String playerComponent[] = player.trim().split(",");
        //    String playerName = playerComponent[0].trim();
        //    if(playerName.equals(userName)) {
        //        if(Integer.parseInt(playerComponent[1].trim()) < 0 || Integer.parseInt(playerComponent[2].trim()) < 0 || Integer.parseInt(playerComponent[1].trim()) > 900 || Integer.parseInt(playerComponent[2].trim()) > 900)
        //    } else {
        //        t.stop();
        //        gameFrame.loadScoreBoard(score);
        //    }
        //}




        String playerMovement = "USER " + userName + " " + userAction;
        try {
            client.send(SERVERIP, playerMovement.trim());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        //String playerArray[] = playerString.trim().split("-");
        //for(String player : playerArray) {
        //    //System.out.print(player);
        //    String playerComponent[] = player.trim().split(",");
        //    String playerName = playerComponent[0].trim();
//
        //    //System.out.println("--------------------");
        //    //System.out.println(player);
        //    //System.out.println("Player Length " + player.length());
        //    //System.out.println(playerComponent[0]);
        //    //System.out.println("playerComponent[0] length " + playerComponent[0].length());
        //    //System.out.println(playerComponent[1]);
        //    //System.out.println("playerComponent[1] length " + playerComponent[1].length());
        //    //System.out.println(playerComponent[2]);
        //    //System.out.println("playerComponent[2] length " + playerComponent[2].length());
        //    //System.out.println("--------------------");
//
        //    if(playerName.equals(userName)) {
        //        playerComponent[1] = Integer.toString(x);
        //        playerComponent[2] = Integer.toString(y);
        //    }
        //    if(updatedPlayerString.equals("")) {
        //        updatedPlayerString = playerComponent[0] + "," + playerComponent[1] + "," + playerComponent[2];
        //    } else {
        //        updatedPlayerString = updatedPlayerString + "-" + playerComponent[0] + "," + playerComponent[1] + "," + playerComponent[2];
        //    }
//
        //}
        System.out.println("--------------------");
        System.out.println(updatedPlayerString);
        System.out.println("x " + x);
        System.out.println("y " + y);
        System.out.println("x " + xVelocity);
        System.out.println("y " + yVelocity);
        System.out.println("--------------------");
        //client.send(SERVERIP, updatedPlayerString.trim());
        //usedCoordinates.add(x + "," + y);
        //try {
        //    client.send(SERVERIP, updatedPlayerString.trim());
        //    client.closeSocket();
        //
        //} catch (Exception e1) {
        //    e1.printStackTrace();
        //}
        //this.updatedPlayerString = "";
        repaint();
    }

    //public static void main(String[] args) {
    //    GamePanel testing = new GamePanel();
    //    //testing.setVisible(true);
    //}
}
