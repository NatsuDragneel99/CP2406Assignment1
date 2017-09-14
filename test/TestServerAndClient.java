/**
 * Created by jc428209 on 15/09/17.
 */
public class TestServerAndClient {
    public static void main(String[] args) throws Exception{

        //Create server and client objects
        MulticastServerNew server = new MulticastServerNew("228.5.6.7", 49321);
        ClientNew client = new ClientNew(49321);

        //Send a message to server from client
        client.send(server.getIP(), server.getPort(), "TESTING");
        String message = server.read();
        System.out.println(message);

        //Broadcast a message from server and listen on client
        server.broadcast("HELLO IIIIIIIIIIIIIII");
        String clientMessage = client.listen(server.multicast);
        System.out.println(clientMessage);

        //Close server
        server.close();
    }
}

