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
        Scanner input = new Scanner(System.in);
        System.out.print("Enter message for server >> ");
        String message = input.nextLine();

        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), address, 49321);
        socket.send(packet);

        //Receive server response
        byte[] messageBuffer = new byte[1024];
        DatagramPacket serverResponsePacket = new DatagramPacket(messageBuffer, 1024);
        socket.receive(serverResponsePacket);
        String serverResponse = new String(messageBuffer);
        System.out.println(serverResponse);

        //Leave inet address and close socket
        /*socket.leaveGroup(address);
        socket.close();*/
    }
}
