import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GameFrame extends JFrame {
    private int gridHeight;
    private int gridWidth;
    private MenuPanel menuPanel;
    private GamePanel gamePanel;
    private Client client;
    private final String SERVERIP = "10.178.246.25"; //IP of the multicast server being connected to.
    private final int CLIENTPORT = 49324; //Change for each individual client.


    GameFrame(int gridHeight, int gridWidth) throws UnknownHostException {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        setTitle("TRON");
        setSize(900, 900);
        setBackground(Color.BLACK);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        try {
            this.client = new Client(CLIENTPORT);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    void loadMenu() {
        menuPanel = new MenuPanel(this, SERVERIP, CLIENTPORT, client);
        setContentPane(menuPanel);
        invalidate();
        validate();
        repaint();
        setVisible(true);
    }

    void loadScoreBoard(int score) {
        ScoreBoard scoreBoard = new ScoreBoard(this, score);
        setContentPane(scoreBoard);
        invalidate();
        validate();
        repaint();
        setVisible(true);
    }


    GamePanel loadGame(String userName, String playerString) {
        gamePanel = new GamePanel(this, gridHeight, gridWidth, userName, SERVERIP, CLIENTPORT, playerString, client);
        setContentPane(gamePanel);
        invalidate();
        validate();
        repaint();
        setVisible(true);
        return gamePanel;
    }
}
