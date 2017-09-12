import java.util.Arrays;
import java.util.Scanner;


public class Grid extends LightCycle {
    //LightCycle[] lightCycles = new LightCycle[20];
    private int gridHeight;
    private int gridWidth;
    public int[][] createGrid(int gridHeight, int gridWidth) {
        /*Scanner input = new Scanner(System.in);
        System.out.print("Enter height of grid (500-10000) >> ");
        String gridHeightString = input.nextLine();
        System.out.print("Enter width of grid (500-10000) >> ");
        String gridWidthString = input.nextLine();
        int gridHeight = Integer.parseInt(gridHeightString);
        int gridWidth = Integer.parseInt(gridWidthString);*/
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        int[][] grid = new int[this.gridHeight][this.gridWidth];
        for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                grid[row][col] = 0;
            }
        }
        return grid;
    }

    public void addUser(int lightCycleNumber) {
        //this.createCycle(this.gridHeight,this.gridWidth);
    }

    public void printGrid(int [][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
