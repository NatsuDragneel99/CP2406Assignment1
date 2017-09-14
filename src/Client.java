import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.MulticastSocket;
/**
 * Created by jc428209 on 14/09/17.
 */
class Client {
    private DatagramSocket direct;

    Client(int hostPort) throws Exception {
        direct = new DatagramSocket(hostPort);

    }

    void send(String targetIP,int targetPort, String message) throws Exception {
        InetAddress address = InetAddress.getByName(targetIP);
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), address, targetPort);
        direct.send(packet);
    }

    String listen(MulticastSocket multicast) throws Exception{
        byte[] messageBuffer = new byte[1024];
        DatagramPacket receivedPacket = new DatagramPacket(messageBuffer, 1024);
        multicast.receive(receivedPacket);
        return new String(messageBuffer).trim();
    }

    public int getPort() {
        return direct.getLocalPort();
    }
}
