import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class GamePanel extends JFrame{
    GridTile[][] grid;
    int gridHeight;
    int gridWidth;

    GamePanel(int gridHeight, int gridWidth) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.grid = new GridTile[gridHeight][gridWidth];
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(gridHeight, gridWidth));
        setTitle("TRON");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,900);
        for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                GridTile tile = new GridTile();
                tile.putClientProperty("row", row);
                tile.putClientProperty("col", col);
                gamePanel.add(tile);
                this.grid[row][col] = tile;
            }
        }



        //for(int i = 0; i < gridHeight * gridWidth; i++) {
        //    JButton button = new JButton(String.valueOf(i));
        //    gamePanel.add(button);
        //}
        add(gamePanel);





        //Container test = getContentPane();
        //test.setLayout(new BorderLayout());
        //test.add(gamePanel, BorderLayout.CENTER);
    }


    //void createGrid() {
    //   for (int row = 0; row < gridHeight; row++) {
    //       for (int col = 0; col < gridWidth; col++) {
    //           DrawPanel panel = new DrawPanel();
    //           this.grid[row][col] = panel;
    //       }
    //   }

    void addCycle() {
        if("3" == grid[3][2].getClientProperty("row") && "2" == grid[3][2].getClientProperty("col"));
        grid[3][2].setBackground(Color.yellow);
        //for (int row = 0; row < gridHeight; row++) {
        //    for (int col = 0; col < gridWidth; col++) {
        //        if("3" == grid[row][col].getClientProperty("row") && "2" == grid[row][col].getClientProperty("col"));
        //        grid[row][col].setBackground(Color.yellow);
        //    }
        //}
    }
    public static void main(String[] args) {
        GamePanel panel = new GamePanel(200, 200);
        panel.setVisible(true);
        System.out.println(panel.grid[0][6].getClientProperty("row"));
        System.out.println(panel.grid[0][6].getClientProperty("col"));
        panel.addCycle();
    }
}
