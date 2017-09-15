/**
 * Michael Koppen CP2406 Assignment 1
 */
public class testUserStory2and3 {
    public static void main(String[] args) {
        Grid newGrid = new Grid(10, 10);
        LightCycle cycle1 = newGrid.addCycle(1);
        LightCycle cycle2 = newGrid.addCycle(2);
        LightCycle cycle3 = newGrid.addCycle(3);

        newGrid.printGrid();


    }
}
