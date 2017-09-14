//ports 49152 - 65535
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.util.Scanner;

public class OldClientIgnore {
    public static void main(String[] args) throws Exception {
        //Connect socket to inet address
        InetAddress address = InetAddress.getByName("228.5.6.7");
        MulticastSocket socket = new MulticastSocket(49321);
        socket.joinGroup(address);


        //Create and send packet
        Scanner input = new Scanner(System.in);
        System.out.println("Enter message for server:");
        System.out.println("ADD USER");
        System.out.println("REMOVE USER");
        System.out.println("GRID SIZE");
        System.out.println("GAME STATE");
        System.out.println("SAVE SCORE");
        System.out.println(">> ");
        String message = input.nextLine();

        /*if(message.equals("ADD USER")) {
            System.out.print("Enter user's name >> ");
            message = input.nextLine();
        }*/

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

    public void send() {

    }

    public void listen() {

    }

    public void close() {
        //Leave inet address and close socket
        /*socket.leaveGroup(address);
        socket.close();*/
    }
}
