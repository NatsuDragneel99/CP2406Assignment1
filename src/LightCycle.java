import java.util.Random;
import java.util.Arrays;

public class LightCycle {
    //int cycleXposition;
    //int cycleYposition;
    int gridHeight;
    int gridWidth;
    int[] cyclePosition = new int[2];

    public LightCycle(int gridHeight, int gridWidth, int[][] usedPositions) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
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

    public void moveCycle() {
        /*if((this.gridWidth - this.cyclePosition[0]) > this.cyclePosition[1]) {

        }*/
    }

    public void createCycle(int gridHeight, int gridWidth) {

    }


    public void turnLeft() {

    }

    public void turnRight() {

    }

    public void increaseSpeed() {

    }

    public void decreaseSpeed() {

    }
}
