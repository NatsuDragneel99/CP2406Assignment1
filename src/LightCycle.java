import java.util.Random;

public class LightCycle {
    int[] cyclePosition = new int[2];
    public void createCycle(int gridHeight, int gridWidth) {
        Random rand = new Random();
        int randomPos1 = rand.nextInt(gridHeight) + 500;
        int randomPos2 = rand.nextInt(gridWidth) + 500;
        cyclePosition[0] = randomPos1;
        cyclePosition[1] = randomPos2;

    }

    public int[] getCyclePosition() {
        return cyclePosition;
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
