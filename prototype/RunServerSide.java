public class RunServerSide {
    public static void main(String[] args) throws Exception{

        MulticastServer server = new MulticastServer("228.5.6.7",49321);

        while(true) {
            String message = server.read();
            System.out.println(message);

            if(message.startsWith("ADD USER")) {
                server.broadcast("OKAY");
            }



        }

    }
}
