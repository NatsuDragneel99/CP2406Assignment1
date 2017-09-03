import java.util.Arrays;
import java.util.Scanner;


public class Grid {
    public int[][] createGrid() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter height of grid (500-10000) >> ");
        String gridHeightString = input.nextLine();
        System.out.print("Enter width of grid (500-10000) >> ");
        String gridWidthString = input.nextLine();
        int gridHeight = Integer.parseInt(gridHeightString);
        int gridWidth = Integer.parseInt(gridWidthString);
        int[][] grid = new int[gridHeight][gridWidth];
        for (int row = 0; row < gridWidth; ++row) {
            for (int col = 0; col < gridHeight; ++col) {
                grid[row][col] = 0;
            }
        }
        return grid;
    }

    public void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
