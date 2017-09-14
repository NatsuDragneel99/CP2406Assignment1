/**
 * Created by jc428209 on 15/09/17.
 */
public class TestSpikeUserStory1ServerSide {
    public static void main(String[] args) throws Exception{

        MulticastServer server = new MulticastServer("228.5.6.7",49321);

        String message = server.read();
        System.out.println(message);
        server.broadcast("Message received loud and clear >> " + message);



    }
}
