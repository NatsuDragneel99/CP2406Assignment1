import java.util.Random;

public class LightCycle {
    int cycleXposition;
    int cycleYposition;
    int[] cyclePosition = new int[2];

    public LightCycle(int gridHeight, int gridWidth) {
        Random rand = new Random();
        this.cycleXposition = rand.nextInt(gridWidth);
        this.cycleYposition = rand.nextInt(gridHeight);
        this.cyclePosition[0] = cycleXposition;
        this.cyclePosition[1] = cycleYposition;
    }

    public void createCycle(int gridHeight, int gridWidth) {

    }

    /*public int[] getCyclePosition() {
        return cyclePosition;
    }*/

    public void turnLeft() {

    }

    public void turnRight() {

    }

    public void increaseSpeed() {

    }

    public void decreaseSpeed() {

    }
}
