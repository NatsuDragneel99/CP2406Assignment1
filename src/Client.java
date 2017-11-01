/**
 * Michael Koppen CP2406 Assignment 1
 */
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.MulticastSocket;

class Client {
    private DatagramSocket direct;
    private int serverPort = 49321;
    Client(int hostPort) throws Exception {
        direct = new DatagramSocket(hostPort);

    }

    void send(String targetIP, String message) throws Exception {
        InetAddress address = InetAddress.getByName(targetIP);
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), address, serverPort);
        direct.send(packet);
    }

    String listen(MulticastSocket multicast) throws Exception{
        byte[] messageBuffer = new byte[2048];
        DatagramPacket receivedPacket = new DatagramPacket(messageBuffer, 2048);
        multicast.receive(receivedPacket);
        return new String(messageBuffer).trim();
    }

    public int getPort() {
        return direct.getLocalPort();
    }

    void closeSocket() throws Exception{
        direct.close();
    }
}
