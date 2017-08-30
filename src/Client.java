//ports 49152 - 65535
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        //Connect socket to inet address
        InetAddress address = InetAddress.getByName("228.5.6.7");
        MulticastSocket socket = new MulticastSocket(49321);
        socket.joinGroup(address);

        //Create and send packet
        String message = "TESTING";
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), address, 49321);
        socket.send(packet);
        
        //Leave inet address and close socket
        socket.leaveGroup(address);
        socket.close();
    }
}
