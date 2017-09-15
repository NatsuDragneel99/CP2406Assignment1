/**
 * Michael Koppen CP2406 Assignment 1
 */

import java.util.Arrays;

class Grid {
    //LightCycle[] lightCycles = new LightCycle[20];
    private int gridHeight;
    private int gridWidth;
    private int[][] grid;
    private int[][] usedPositions = new int[8][];


    Grid(int gridHeight, int gridWidth) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        createGrid();
    }

    private void createGrid() {
        this.grid = new int[gridHeight][gridWidth];
        for (int row = 0; row < gridHeight; row++) {
            for (int col = 0; col < gridWidth; col++) {
                this.grid[row][col] = 0;
            }
        }
    }

    LightCycle addCycle(int cycleNumber) {
        LightCycle cycle = new LightCycle(gridHeight, gridWidth, cycleNumber, usedPositions);
        this.grid[cycle.getCyclePosition()[0]][cycle.getCyclePosition()[1]] = cycleNumber;
        cycleNumber -= 1;
        this.usedPositions[cycleNumber] = cycle.getCyclePosition();
        /*for (int[] position : this.usedPositions) {
            if(position != null) {
                System.out.println(Arrays.toString(position));
            }
        }*/
        return cycle;
    }

    void startGame() {

    }

    public int[][] getGrid() {
        return grid;
    }

    void printGrid() {
        for (int[] row : this.grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
