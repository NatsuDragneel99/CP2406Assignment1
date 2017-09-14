import java.util.Random;
import java.util.Arrays;

class LightCycle {
    int[] cyclePosition = new int[2];

    LightCycle(int gridHeight, int gridWidth, int[][] usedPositions) {
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

    void moveCycle() {
        /*if((this.gridWidth - this.cyclePosition[0]) > this.cyclePosition[1]) {

        }*/
    }

    void turnLeft() {

    }

    void turnRight() {

    }

    void increaseSpeed() {

    }

    void decreaseSpeed() {

    }

    void toggleLightWall() {

    }
}
