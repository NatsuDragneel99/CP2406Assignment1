/**
 * Michael Koppen CP2406 Assignment 1
 */
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


class MulticastServer {
    private InetAddress multicastIP;
    private int multicastPort;
    private MulticastSocket multicast;
    private String ip = InetAddress.getLocalHost().getHostAddress();

    MulticastServer(String multicastIP, int multicastPort) throws Exception {
        this.multicastIP = InetAddress.getByName(multicastIP);
        this.multicastPort = multicastPort;

        multicast = new MulticastSocket(this.multicastPort);
        multicast.joinGroup(this.multicastIP);
    }

    void broadcast(String message) throws Exception {
        DatagramPacket broadcastMessage = new DatagramPacket(message.getBytes(), message.length(), multicastIP, 49321);
        multicast.send(broadcastMessage);
    }

    String getIP() {
        return ip;
    }

    int getPort() {
        return multicastPort;
    }

    MulticastSocket getMulticast() {
        return multicast;
    }

    String read() throws Exception {
        byte[] messageBuffer = new byte[2048];
        DatagramPacket receivedPacket = new DatagramPacket(messageBuffer, 2048);
        multicast.receive(receivedPacket);
        String messageString;
        messageString = new String(messageBuffer).trim();
        return messageString;
    }

    void close() throws Exception{
        multicast.leaveGroup(multicastIP);
        multicast.close();
    }

}
