import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by jc428209 on 23/10/17.
 */

public class ClientListen extends Thread {
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
                //System.out.println(messageString);
                if(messageString.startsWith("GRID SIZE")) {
                    String[] gridSizeArray = messageString.split(" ");
                    int gridHeight = Integer.parseInt(gridSizeArray[1]);
                    int gridWidth = Integer.parseInt(gridSizeArray[2]);
                } else if(messageString.startsWith("")) {

                }
            }
            } catch (Exception e) {
                e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        try {
            GameFrame gameFrame = new GameFrame(10, 10);
            gameFrame.loadMenu();
            //gameFrame.loadGame();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

