/**
 * Michael Koppen CP2406 Assignment 1
 */
public class TestSpikeUserStory1ServerSide {
    public static void main(String[] args) throws Exception{

        MulticastServer server = new MulticastServer("228.5.6.7",49321);

        System.out.println(server.getIP());
        String message = server.read();
        System.out.println(message);
        server.broadcast("Message received loud and clear >> " + message);



    }
}
