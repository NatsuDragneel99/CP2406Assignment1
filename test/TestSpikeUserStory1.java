/**
 * Created by jc428209 on 15/09/17.
 */
public class TestSpikeUserStory1 {
    public static void main(String[] args) throws Exception{

        //Create server and client objects
        MulticastServer server = new MulticastServer("228.5.6.7", 49321);
        Client client = new Client(server.getPort());

        //Send a message to server from client
        client.send(server.getIP(), "Hello can you hear me?");
        String message = server.read();
        System.out.println(message);

        //Broadcast a response message from server and listen on client
        server.broadcast("Server to client test");
        String clientMessage = client.listen(server.getMulticast());
        System.out.println(clientMessage);

        //Close server
        server.close();
    }
}

