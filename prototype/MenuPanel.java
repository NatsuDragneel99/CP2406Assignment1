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

    private String userName;
    private Client client;
    private GameFrame gameFrame;

    MenuPanel(GameFrame gameFrame, String serverIP, int clientPort, Client client){
        this.SERVERIP = serverIP;
        this.CLIENTPORT = clientPort;
        this.gameFrame = gameFrame;
        this.client = client;
        setLayout(new GridBagLayout());
        setVisible(true);
        setBackground(Color.BLACK);
        JButton joinGame = new JButton("Join Game");
        joinGame.setPreferredSize(new Dimension(250, 100));
        add(joinGame);
        joinGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAddUserFrame();
                if(userName != null) {
                    addUser();
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
    }
}
