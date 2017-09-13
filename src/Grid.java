import java.util.Arrays;

public class Grid {
    //LightCycle[] lightCycles = new LightCycle[20];
    private int gridHeight;
    private int gridWidth;
    int[][] grid;
    int[][] usedPositions = new int[8][];


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

    public LightCycle addCycle(int cycleNumber) {
        LightCycle cycle = new LightCycle(this.gridHeight, this.gridWidth, this.usedPositions);
        /*for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                if (row == cycle.cyclePosition[0] && col == cycle.cyclePosition[1]) {
                    this.grid[row][col] = cycleNumber;
                }
            }
        }*/
        this.grid[cycle.cyclePosition[0]][cycle.cyclePosition[1]] = cycleNumber;
        cycleNumber -= 1;
        this.usedPositions[cycleNumber] = cycle.cyclePosition;
        /*for (int[] position : this.usedPositions) {
            if(position != null) {
                System.out.println(Arrays.toString(position));
            }
        }*/
        return cycle;
    }

    public void startGame() {

    }

    public void printGrid() {
        for (int[] row : this.grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
