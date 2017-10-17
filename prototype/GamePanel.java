import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class GamePanel extends JFrame{
    DrawPanel[][] grid;
    int gridHeight;
    int gridWidth;

    GamePanel(int gridHeight, int gridWidth) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.grid = new DrawPanel[gridHeight][gridWidth];
        setLayout(new GridLayout(gridHeight, gridWidth));
        setTitle("TRON");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,900);
        for(int i = 0; i < gridHeight * gridWidth; i++) {
            JButton button = new JButton(String.valueOf(i));
            add(button);
        }





        //Container test = getContentPane();
        //test.setLayout(new BorderLayout());
        //test.add(gamePanel, BorderLayout.CENTER);



        //add(gamePanel);
    }

    interface Drawable {
        void draw(Graphics g);
    }

    //void createGrid() {
    //   for (int row = 0; row < gridHeight; row++) {
    //       for (int col = 0; col < gridWidth; col++) {
    //           DrawPanel panel = new DrawPanel();
    //           this.grid[row][col] = panel;
    //       }
    //   }
    //

    public static void main(String[] args) {
        GamePanel panel = new GamePanel(500, 500);
        panel.setVisible(true);
    }
}
