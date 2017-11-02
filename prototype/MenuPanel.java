import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MenuPanel extends JPanel {
    private final String SERVERIP;
    private final int CLIENTPORT;

    String userName;
    Client client;
    GameFrame gameFrame;
    MulticastServer server;
    boolean userAdded;
    InetAddress address;

    public MenuPanel(GameFrame gameFrame, String serverIP, int clientPort, Client client){
        this.SERVERIP = serverIP;
        this.CLIENTPORT = clientPort;
        this.gameFrame = gameFrame;
        this.client = client;
        //JFrame test = new JFrame();
        //test.setSize(900,900);
        //test.add(this);
        //test.setVisible(true);
        //setLayout(new FlowLayout());
        setLayout(new GridBagLayout());
        setVisible(true);
        setBackground(Color.BLACK);
        JButton joinGame = new JButton("Join Game");
        joinGame.setPreferredSize(new Dimension(250, 100));
        //ClientListen thread = new ClientListen();
        //thread.start();

        //try {
        //    this.client = new Client(CLIENTPORT);
        //}catch (Exception e) {
        //    e.printStackTrace();
        //}
        add(joinGame);
        joinGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAddUserFrame();
                if(userName != null) {
                    addUser();
                    //gameFrame.loadGame();
                }
                joinGame.setVisible(false);
            }
        });

    }

    private void displayAddUserFrame() {
        this.userName = JOptionPane.showInputDialog("Enter Username");
    }

    private void addUser() {
        try {
            String addUser = "ADD USER " + userName;
            client.send(SERVERIP, addUser);

        }catch (Exception e) {
            e.printStackTrace();
        }


        //revalidate();
        //repaint();
    }


   // public static void main(String[] args) {
   //     MenuPanel test = new MenuPanel(gameFrame);
   // }
}
