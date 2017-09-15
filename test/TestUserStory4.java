/**
 * Created by jc428209 on 15/09/17.
 */
public class TestUserStory4 {
    public static void main(String[] args) {
        Grid newGrid = new Grid(10, 10);
        LightCycle cycle1 = newGrid.addCycle(1);
        LightCycle cycle2 = newGrid.addCycle(1);
        newGrid.printGrid();
    }
}

