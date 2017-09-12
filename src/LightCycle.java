import java.util.Random;

public class LightCycle {
    int cycleYposition;
    int cycleXposition;
    public void createCycle(int gridHeight, int gridWidth) {
        Random rand = new Random();
        int randomPos1 = rand.nextInt(gridHeight) + 500;
        int randomPos2 = rand.nextInt(gridWidth) + 500;
        this.cycleYposition = randomPos1;
        this.cycleXposition = randomPos2;

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
