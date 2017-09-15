/**
 * Created by jc428209 on 15/09/17.
 */
public class TestSpikeUserStory1ClientSide {
    public static void main(String[] args) throws Exception{

        MulticastServer server = new MulticastServer("228.5.6.7",49321);
        Client client = new Client(server.getPort());

        String message = "Hello server can you hear me?";
        client.send(server.getIP(), message);
        System.out.println("Message sent >> " + message);

        String serverMessage = client.listen(server.getMulticast());
        System.out.println(serverMessage);
    }
}

