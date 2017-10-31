import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by jc428209 on 23/10/17.
 */

public class ClientListen extends Thread {
    int gridHeight;
    int gridWidth;
    GameFrame gameFrame;
    GamePanel gamePanel;
    TestLightCycle[] lightCycles = new TestLightCycle[3];

    ClientListen() {
        this.gameFrame = new GameFrame(10, 10);
        gameFrame.loadMenu();
    }

    public void run() {
        try {
            MulticastSocket multicast = new MulticastSocket(49321);
            InetAddress multicastIP = InetAddress.getByName("228.5.6.7");
            multicast.joinGroup(multicastIP);

            while(true) {
                byte[] messageBuffer = new byte[1024];
                DatagramPacket receivedPacket = new DatagramPacket(messageBuffer, 1024);
                multicast.receive(receivedPacket);
                String messageString;
                messageString = new String(messageBuffer);
                System.out.println(messageString);
                if(messageString.startsWith("GRID SIZE")) {
                    String[] gridSizeArray = messageString.split(" ");
                    this.gridHeight = Integer.parseInt(gridSizeArray[1]);
                    this.gridWidth = Integer.parseInt(gridSizeArray[2]);

                } else if(messageString.startsWith("PLAY")) {
                    this.gamePanel = gameFrame.loadGame();

                    //GamePanel gamePanel = new GamePanel(gridHeight, gridWidth);
                    //gameFrame.setContentPane(gamePanel); //given NullPointerException?????
                    //gameFrame.invalidate();
                    //gameFrame.validate();
                    //gameFrame.repaint();
                    //gameFrame.setVisible(true);

                } else {
                    //System.out.println(messageString);
                }
            }
            } catch (Exception e) {
                e.printStackTrace();

        }
    }

    public static void main(String[] args) {
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

