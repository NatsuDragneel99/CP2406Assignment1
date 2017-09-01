//ports 49152 - 65535
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.util.Scanner;

public class MulticastServer {
    public static void main(String[] args) throws Exception {
        //Connect socket to inet address
        InetAddress address = InetAddress.getByName("228.5.6.7");
        MulticastSocket socket = new MulticastSocket(49321);
        socket.joinGroup(address);

        //Create grid
        Grid newGrid = new Grid();
        int[][] grid = newGrid.createGrid(10,10);
        newGrid.printGrid(grid);


        //Receive packet
        byte[] messageBuffer = new byte[1024];
        DatagramPacket receivedPacket = new DatagramPacket(messageBuffer, 1024);
        socket.receive(receivedPacket);
        String userInput = new String(messageBuffer);
        System.out.println(userInput);

        //Send a response to clients
        DatagramPacket serverResponsePacket = new DatagramPacket(userInput.getBytes(), userInput.length(), address, 49321);
        socket.send(serverResponsePacket);

        //Leave inet address and close socket
        socket.leaveGroup(address);
        socket.close();


    }
}
