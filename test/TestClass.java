import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        //createGrid
        Grid newGrid = new Grid();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter height of grid (500-10000) >> ");
        String gridHeightString = input.nextLine();
        System.out.print("Enter width of grid (500-10000) >> ");
        String gridWidthString = input.nextLine();
        int gridHeight = Integer.parseInt(gridHeightString);
        int gridWidth = Integer.parseInt(gridWidthString);

        int[][] grid = newGrid.createGrid(gridHeight, gridWidth);
        newGrid.printGrid(grid);

        //LightCycle user1 = newGrid.addUser(0);
        //LightCycle user2 = newGrid.addUser(1);
        //LightCycle user1 = newGrid.createCycle(10,10);

    }



}
