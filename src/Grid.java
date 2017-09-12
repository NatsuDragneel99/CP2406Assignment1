import java.util.Arrays;
import java.util.Scanner;


public class Grid extends LightCycle {
    //LightCycle[] lightCycles = new LightCycle[20];
    private int gridHeight;
    private int gridWidth;
    int[][] grid;

    public Grid(int gridHeight, int gridWidth) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        createGrid();
    }

    public void createGrid() {
        this.grid = new int[this.gridHeight][this.gridWidth];
        for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                this.grid[row][col] = 0;
            }
        }
    }

    public void addUser(int lightCycleNumber) {
        //this.createCycle(this.gridHeight,this.gridWidth);
    }

    public void printGrid() {
        for (int[] row : this.grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
