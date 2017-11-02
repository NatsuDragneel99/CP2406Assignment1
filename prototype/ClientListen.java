import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Created by jc428209 on 23/10/17.
 */

public class ClientListen extends Thread {
    int gridHeight;
    int gridWidth;
    GameFrame gameFrame;
    GamePanel gamePanel;
    String userName = null;
    String playerString;
    TestLightCycle[] lightCycles = new TestLightCycle[3];

    ClientListen() throws UnknownHostException {
        this.gameFrame = new GameFrame(500, 500);
        gameFrame.loadMenu();
    }

    public void run() {
        try {
            MulticastSocket multicast = new MulticastSocket(49321);
            InetAddress multicastIP = InetAddress.getByName("228.5.6.7");
            multicast.joinGroup(multicastIP);

            while(true) {
                byte[] messageBuffer = new byte[2048];
                DatagramPacket receivedPacket = new DatagramPacket(messageBuffer, 2048);
                multicast.receive(receivedPacket);
                String messageString;
                messageString = new String(messageBuffer);
                System.out.println(messageString);
                if(messageString.startsWith("GRID SIZE")) {
                    String[] gridSizeArray = messageString.split(" ");
                    this.gridHeight = Integer.parseInt(gridSizeArray[1]);
                    this.gridWidth = Integer.parseInt(gridSizeArray[2]);

                } else if(messageString.startsWith("PLAY")) {
                    String playArray[] = messageString.split(" ");
                    this.playerString = playArray[1].trim();
                    this.gamePanel = gameFrame.loadGame(userName, playerString);

                    //GamePanel gamePanel = new GamePanel(gridHeight, gridWidth);
                    //gameFrame.setContentPane(gamePanel); //given NullPointerException?????
                    //gameFrame.invalidate();
                    //gameFrame.validate();
                    //gameFrame.repaint();
                    //gameFrame.setVisible(true);
                } else if(messageString.startsWith("OKAY")) {
                    String[] userNameArray = messageString.trim().split(" ");
                    if(userName == null) {
                        this.userName = userNameArray[1].trim();
                        System.out.println(userName);
                    }

                } else {
                    this.playerString = messageString.trim();
                    gamePanel.getNewCoordinates(playerString);
                }
            }
            } catch (Exception e) {
                e.printStackTrace();

        }
    }

    public static void main(String[] args) throws UnknownHostException {
        ClientListen client = new ClientListen();
        client.start();

        //try {
        //    GameFrame gameFrame = new GameFrame(10, 10);
        //    gameFrame.loadMenu();
        //    //gameFrame.loadGame();
//
        //} catch (Exception e) {
        //    e.printStackTrace();
        //    System.out.println("TESTING");
        //}
    }
}

