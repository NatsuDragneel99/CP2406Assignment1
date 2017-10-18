import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame {
    GridTile[][] grid;
    int gridHeight;
    int gridWidth;

    GameFrame(int gridHeight, int gridWidth) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.grid = new GridTile[gridHeight][gridWidth];
        setTitle("TRON");
        setSize(900,900);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        loadMenu();

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
        this.add(new MenuPanel());
    }
    void loadGame() {
        this.add(new TestGamePanel());
    }

    //public static void main(String[] args) {
    //    GameFrame panel = new GameFrame(10, 10);
//
    //}

}
