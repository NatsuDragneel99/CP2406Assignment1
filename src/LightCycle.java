/**
 * Michael Koppen CP2406 Assignment 1
 */

import java.util.Random;
import java.util.Arrays;

class LightCycle {
    private int[] cyclePosition = new int[2];
    private int cycleNumber;

    LightCycle(int gridHeight, int gridWidth, int cycleNumber, int[][] usedPositions) {
        this.cycleNumber = cycleNumber;
        Random rand = new Random();
        this.cyclePosition[0] = rand.nextInt(gridWidth);
        this.cyclePosition[1] = rand.nextInt(gridHeight);

        //System.out.println(Arrays.toString(this.cyclePosition));

        boolean positionTaken = true;
        while(positionTaken) {
            for(int[] position : usedPositions) {
                if(Arrays.equals(position,this.cyclePosition)) {
                    this.cyclePosition[0] = rand.nextInt(gridWidth);
                    this.cyclePosition[1] = rand.nextInt(gridHeight);
                }
            }
            positionTaken = false;
        }
    }

    int[] getCyclePosition() {
        return cyclePosition;
    }

    void moveUp(Grid grid) {
        try {
            this.cyclePosition[0] = cyclePosition[0] - 1;
            grid.getGrid()[cyclePosition[0]][cyclePosition[1]] = cycleNumber;
        } catch (ArrayIndexOutOfBoundsException hitWall) {
            System.out.println("Cycle has crashed into wall");
        }
    }

    void moveDown(Grid grid) {
        try {
            this.cyclePosition[0] = cyclePosition[0] + 1;
            grid.getGrid()[cyclePosition[0]][cyclePosition[1]] = cycleNumber;
        } catch (ArrayIndexOutOfBoundsException hitWall) {
            System.out.println("Cycle has crashed into wall");
        }
    }

    void moveRight(Grid grid) {
        try {
            this.cyclePosition[1] = cyclePosition[1] + 1;
            grid.getGrid()[cyclePosition[0]][cyclePosition[1]] = cycleNumber;
        } catch (ArrayIndexOutOfBoundsException hitWall) {
            System.out.println("Cycle has crashed into wall");
        }
    }

    void moveLeft(Grid grid) {
        try {
            this.cyclePosition[1] = cyclePosition[1] - 1;
            grid.getGrid()[cyclePosition[0]][cyclePosition[1]] = cycleNumber;
        } catch (ArrayIndexOutOfBoundsException hitWall) {
            System.out.println("Cycle has crashed into wall");
        }

    }

    void increaseSpeed() {

    }

    void decreaseSpeed() {

    }

    void toggleLightWall() {

    }
}
