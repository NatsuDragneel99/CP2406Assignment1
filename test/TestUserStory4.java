/**
 * Michael Koppen CP2406 Assignment 1
 */
public class TestUserStory4 {
    public static void main(String[] args) {
        Grid newGrid = new Grid(10, 10);
        LightCycle cycle1 = newGrid.addCycle(1);
        LightCycle cycle2 = newGrid.addCycle(2);
        System.out.println("Screen 1");
        newGrid.printGrid();
        System.out.println("------------------------------");
        cycle1.moveUp(newGrid);
        cycle2.moveUp(newGrid);
        System.out.println("Screen 2");
        newGrid.printGrid();
        System.out.println("------------------------------");
        cycle1.moveUp(newGrid);
        cycle2.moveUp(newGrid);
        System.out.println("Screen 3");
        newGrid.printGrid();
        System.out.println("------------------------------");
        cycle1.moveLeft(newGrid);
        cycle2.moveRight(newGrid);
        System.out.println("Screen 4");
        newGrid.printGrid();
        System.out.println("------------------------------");


    }
}

