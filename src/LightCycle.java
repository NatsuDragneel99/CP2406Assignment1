import java.util.Random;
import java.util.Arrays;

class LightCycle {
    //int[][] grid;
    int[] cyclePosition = new int[2];
    int cycleNumber;

    LightCycle(int gridHeight, int gridWidth, int cycleNumber, int[][] usedPositions) {
        //this.grid = grid;
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

    void moveUp(Grid grid) {
        cyclePosition[0] = cyclePosition[0] + 1;
        grid.getGrid()[cyclePosition[0]][cyclePosition[1]] = cycleNumber;
    }

    void moveDown(Grid grid) {
        cyclePosition[0] = cyclePosition[0] - 1;
        grid.getGrid()[cyclePosition[0]][cyclePosition[1]] = cycleNumber;
    }

    void moveRight(Grid grid) {
        cyclePosition[1] = cyclePosition[1] + 1;
        grid.getGrid()[cyclePosition[0]][cyclePosition[1]] = cycleNumber;
    }

    void moveLeft(Grid grid) {
        cyclePosition[1] = cyclePosition[1] - 1;
        grid.getGrid()[cyclePosition[0]][cyclePosition[1]] = cycleNumber;
    }
}
