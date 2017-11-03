import java.util.Random;
import java.util.Arrays;

class NewLightCycle {
    private int[] cyclePosition = new int[2];
    private int cycleNumber;

    NewLightCycle(int gridHeight, int gridWidth) {
        //this.cycleNumber = cycleNumber;
        Random rand = new Random();
        this.cyclePosition[0] = rand.nextInt(900);
        this.cyclePosition[1] = rand.nextInt(900);

        //System.out.println(Arrays.toString(this.cyclePosition));

        //boolean positionTaken = true;
        //while (positionTaken) {
        //    for (int[] position : usedPositions) {
        //        if (Arrays.equals(position, this.cyclePosition)) {
        //            this.cyclePosition[0] = rand.nextInt(gridWidth);
        //            this.cyclePosition[1] = rand.nextInt(gridHeight);
        //        }
        //    }
        //    positionTaken = false;
        //}
    }

    int[] getCyclePosition() {
        return cyclePosition;
    }
}
