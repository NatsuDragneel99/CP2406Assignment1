import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    //GridTile[][] grid;
    int gridHeight;
    int gridWidth;
    MenuPanel menuPanel;
    GamePanel gamePanel;


    GameFrame(int gridHeight, int gridWidth) {
        //setLayout(new FlowLayout());
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        //this.grid = new GridTile[gridHeight][gridWidth];
        setTitle("TRON");
        setSize(900,900);
        setBackground(Color.BLACK);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);





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
        menuPanel = new MenuPanel(this);
        add(menuPanel);
        invalidate();
        validate();
        repaint();
        setVisible(true);
    }

    void loadGame() {
        gamePanel = new GamePanel(gridHeight, gridWidth);
        setContentPane(gamePanel);
        invalidate();
        validate();
        repaint();
        setVisible(true);
    }

    void closeGame() {
        remove(gamePanel);
    }

    //public static void main(String[] args) {
    //    GameFrame panel = new GameFrame(10, 10);
//
    //}

}
