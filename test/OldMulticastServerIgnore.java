//ports 49152 - 65535
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.util.Scanner;

public class OldMulticastServerIgnore {
    public static void main(String[] args) throws Exception {
        //Connect socket to inet address
        InetAddress address = InetAddress.getByName("228.5.6.7");
        MulticastSocket socket = new MulticastSocket(49321);
        socket.joinGroup(address);

        //Create grid
        Grid newGrid = new Grid(10,10);
        newGrid.printGrid();

        LightCycle[] cycles = new LightCycle[20];

        long timeSinceLastConnection = 0;
        int userCount = 1;
        while(userCount <= 20) {
            //Receive packet
            byte[] messageBuffer = new byte[1024];
            DatagramPacket receivedPacket = new DatagramPacket(messageBuffer, 1024);
            socket.receive(receivedPacket);
            String userInput = new String(messageBuffer);
            /*if(userInput.equals("ADD USER")) {
                newGrid.addCycle(userCount);
                newGrid.printGrid();
                //Send a response to clients
                DatagramPacket serverResponsePacket = new DatagramPacket("OKAY".getBytes(), "OKAY".length(), address, 49321);
                socket.send(serverResponsePacket);
                userCount += 1;
            }*/
            System.out.println(userInput);

            //Send a response to clients
            DatagramPacket serverResponsePacket = new DatagramPacket("OKAY".getBytes(), "OKAY".length(), address, 49321);
            socket.send(serverResponsePacket);
        }

        /*while(userCount <= 20) {
            //Receive packet
            byte[] messageBuffer = new byte[1024];
            DatagramPacket receivedPacket = new DatagramPacket(messageBuffer, 1024);
            socket.receive(receivedPacket);
            String userInput = new String(messageBuffer);
            System.out.println(userInput);


            userCount += 1;
            //Send a response to clients
            DatagramPacket serverResponsePacket = new DatagramPacket(userInput.getBytes(), userInput.length(), address, 49321);
            socket.send(serverResponsePacket);
        }*/
            //Leave inet address and close socket
            /*socket.leaveGroup(address);
            socket.close();*/


    }

    public void broadCast() {

    }

    public void read() {

    }

    public void close() {
        //Leave inet address and close socket
            /*socket.leaveGroup(address);
            socket.close();*/
    }
}
