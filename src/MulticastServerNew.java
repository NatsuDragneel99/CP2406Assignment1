import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by jc428209 on 14/09/17.
 */
public class MulticastServerNew {
    InetAddress multicastIP;
    int multicastPort;
    MulticastSocket multicast;

    public MulticastServerNew(String multicastIP, int multicastPort) throws Exception {
        this.multicastIP = InetAddress.getByName(multicastIP);
        this.multicastPort = multicastPort;

        multicast = new MulticastSocket(this.multicastPort);
        multicast.joinGroup(this.multicastIP);
    }

    public void broadcast(String message) throws Exception {
        DatagramPacket broadcastMessage = new DatagramPacket(message.getBytes(), message.length(), multicastIP, 49321);
        multicast.send(broadcastMessage);
    }

    public String read() throws Exception {
        byte[] messageBuffer = new byte[1024];
        DatagramPacket receivedPacket = new DatagramPacket(messageBuffer, 1024);
        multicast.receive(receivedPacket);
        String messageString;
        messageString = new String(messageBuffer);
        return messageString;
    }

    public void close() throws Exception{
        multicast.leaveGroup(multicastIP);
        multicast.close();
    }

}
