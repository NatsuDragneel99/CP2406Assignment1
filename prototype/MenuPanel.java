import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MulticastSocket;

public class MenuPanel extends JPanel {
    String SERVERIP = "10.140.33.213";
    String userName;
    Client client;
    GameFrame gameFrame;
    MulticastServer server;
    boolean userAdded;

    public MenuPanel(GameFrame gameFrame){
        this.gameFrame = gameFrame;
        //JFrame test = new JFrame();
        //test.setSize(900,900);
        //test.add(this);
        //test.setVisible(true);
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(Color.BLACK);
        JButton joinGame = new JButton("Join Game");
        ClientListen thread = new ClientListen();
        thread.start();

        try {
            this.client = new Client(49322);
        }catch (Exception e) {
            e.printStackTrace();
        }

        add(joinGame);
        joinGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAddUserFrame();
                if(userName != null) {
                    addUser();
                    gameFrame.startGame();
                }
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
            String gridSize = "GRID SIZE ";
            client.send(SERVERIP, gridSize);
            //System.out.println(message);

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
