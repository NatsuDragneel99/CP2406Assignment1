import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MulticastSocket;

public class MenuPanel extends JPanel {
    String userName;
    Client client;
    MulticastSocket multicast;

    public MenuPanel(){

        setLayout(new FlowLayout());
        setVisible(true);
        JButton joinGame = new JButton("Join Game");
        try {
            this.client = new Client(49322);
            this.multicast = new MulticastSocket(49321);
        }catch (Exception e) {
            e.printStackTrace();
        }

        joinGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAddUserFrame();
                if(userName != null) {
                    joinGame();
                    try {
                        String responseMessage = client.listen(multicast);
                        System.out.println(responseMessage);
                    }catch (Exception error) {
                        error.printStackTrace();
                    }

                }
            }
        });
        add(joinGame);
    }

    private void displayAddUserFrame() {
        this.userName = JOptionPane.showInputDialog("Enter Username");
    }

    private void joinGame() {
        try {
            String message = "ADD USER " + userName;
            client.send("10.178.246.25", message);
            System.out.println(message);
        }catch (Exception e) {
            e.printStackTrace();
        }
        GamePanel gamePanel = new GamePanel(10,10);
    }


    public static void main(String[] args) {
        //MenuPanel test = new MenuPanel();
    }
}
