package model;

public class Grid {
    private final int rows;
    private final int columns;
    private final char[][] grid;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new char[rows][columns];
    }

    public void display() {
        //print the top border
        for (int i = 0; i < columns; i++) {
            System.out.print("+-");
        }
        System.out.print("+");
        System.out.println();

        //print the grid contents
        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            for (int j = 0; j < columns; j++) {
                System.out.print(grid[i][j]);
                if (j != columns - 1) {
                    System.out.print("|");
                }
            }
            System.out.println("|");
            //print the horizontal separator
            for (int j = 0; j < columns; j++) {
                System.out.print("+-");
            }
            System.out.print("+");
            System.out.println();
        }
    }
}
