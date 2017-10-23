import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MulticastSocket;

public class MenuPanel extends JPanel {
    String userName;
    Client client;
    MulticastServer server;
    boolean userAdded;

    public MenuPanel(){
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
                    joinGame();

                }
            }
        });

    }

    private void displayAddUserFrame() {
        this.userName = JOptionPane.showInputDialog("Enter Username");
    }

    private void joinGame() {
        try {
            String message = "ADD USER " + userName;
            client.send("10.140.33.213", message);
            //System.out.println(message);

        }catch (Exception e) {
            e.printStackTrace();
        }

        //this.getParent().remove(this);
        //revalidate();
        //repaint();
    }


    public static void main(String[] args) {
        MenuPanel test = new MenuPanel();
    }
}
