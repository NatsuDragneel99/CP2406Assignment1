import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GameFrame extends JFrame {
    //GridTile[][] grid;
    int gridHeight;
    int gridWidth;
    MenuPanel menuPanel;
    GamePanel gamePanel;
    //InetAddress address;

    final String SERVERIP = "10.140.33.243"; //IP of the multicast server being connected to.
    final int CLIENTPORT = 49322; //Change for each individual client.


    GameFrame(int gridHeight, int gridWidth) throws UnknownHostException {
        //setLayout(new FlowLayout());
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        //this.grid = new GridTile[gridHeight][gridWidth];
        setTitle("TRON");
        setSize(900, 900);
        setBackground(Color.BLACK);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        //this.address = InetAddress.getByName(SERVERIP);





        //JPanel gamePanel = new JPanel();
        //gamePanel.setLayout(new GridBagLayout());
        //GridBagConstraints c = new GridBagConstraints();
        //c.fill = GridBagConstraints.HORIZONTAL;
        //JButton tile = new JButton();
        ////GridTile tile = new GridTile();
        //c.weightx = 0.5;
        //c.gridx = 4;
        //c.gridy = 8;
        //gamePanel.add(tile, c);



    }
    void loadMenu() {
        menuPanel = new MenuPanel(this, SERVERIP, CLIENTPORT);
        setContentPane(menuPanel);
        invalidate();
        validate();
        repaint();
        setVisible(true);
    }

    GamePanel loadGame(String userName, String playerString) {
        gamePanel = new GamePanel(gridHeight, gridWidth, userName, SERVERIP, CLIENTPORT, playerString);
        setContentPane(gamePanel);
        invalidate();
        validate();
        repaint();
        setVisible(true);
        return gamePanel;
    }

    //public static void main(String[] args) {
    //    GameFrame panel = new GameFrame(10, 10);
//
    //}

}
