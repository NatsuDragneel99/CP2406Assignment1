import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    String userName;
    Client client;

    public MenuPanel(){

        setLayout(new FlowLayout());
        setVisible(true);
        JButton joinGame = new JButton("Join Game");
        try {
            this.client = new Client(49322);
        }catch (Exception e) {
            e.printStackTrace();
        }

        joinGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAddUserFrame();
                if(userName != null) {
                    joinGame();
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
