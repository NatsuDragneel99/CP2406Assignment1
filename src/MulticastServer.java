//ports 49152 - 65535
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.util.Scanner;

public class MulticastServer {
    public static void main(String[] args) throws Exception {
        //Connect to socket to inet address
        InetAddress address = InetAddress.getByName("228.5.6.7");
        MulticastSocket socket = new MulticastSocket(49321);
        socket.joinGroup(address);

        //Receive user input
        byte[] messageBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(messageBuffer, 1024);
        socket.receive(receivePacket);
        String userInput = new String(messageBuffer);
        System.out.println(userInput);

        //Leave inet address and close socket
        socket.leaveGroup(address);
        socket.close();


    }
}
