import java.util.Arrays;
import java.util.Scanner;


public class Grid {
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

    public LightCycle addCycle() {
        LightCycle cycle = new LightCycle(this.gridHeight, this.gridWidth);
        for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                if (row == cycle.cycleYposition && col == cycle.cycleXposition) {
                    this.grid[row][col] = 1;
                }
            }
        }
        return cycle;
    }

    public void printGrid() {
        for (int[] row : this.grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
