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

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    public void display() {

        System.out.println(ANSI_YELLOW + "\n⸺⸺⸺⸺ Grille ⸺⸺⸺⸺\n" + ANSI_RESET);

        System.out.print("  ");
        for (int i = 0; i < columns; i++) {
            System.out.print(i + 1 + "   ");
        }
        System.out.println();
        //print the top border
        for (int i = 0; i < columns; i++) {
            System.out.print("+---");
        }
        System.out.print("+");
        System.out.println();

        //print the grid contents
        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            for (int j = 0; j < columns; j++) {
                System.out.print(" " + grid[i][j] + " ");
                if (j != columns - 1) {
                    System.out.print("|");
                }
            }
            System.out.println("|");
            //print the horizontal separator
            for (int j = 0; j < columns; j++) {
                System.out.print("+---");
            }
            System.out.print("+");
            System.out.println();
        }

        System.out.println(ANSI_YELLOW + "\n⸺⸺⸺⸺⸺⸺⸺⸺⸺⸺\n" + ANSI_RESET);

    }
}
