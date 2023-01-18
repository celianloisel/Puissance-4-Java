package model;

import static model.Menu.ANSI_RESET;
import static model.Menu.ANSI_YELLOW;

public class Grid {
    private final int rows;
    private final int columns;
    private Piece[][] grid;

    public Grid() {
        rows = 6;
        columns = 7;
        grid = new Piece[rows][columns];
    }


    public void displayGrid() {
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
                if (grid[i][j] == null) {
                    System.out.print(" . ");
                } else {
                    System.out.print(" " + grid[i][j].getColor());
                }

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

    public void dropPiece(String color, int column) {
        for (int i = rows - 1; i >= 0; i--) {
            if (grid[i][column - 1] == null) {
                grid[i][column - 1] = new Piece(color, i, column);
                break;
            }
        }
    }

    public boolean isFull(int col) {
        for (int i = 0; i < rows; i++) {
            if (grid[i][col] == null || grid[i][col].getColor().equals(" . ")) {
                return false;
            }
        }
        return true;
    }

    public boolean isFullGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWin() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Piece currentPiece = grid[i][j];
                if (currentPiece != null) {
                    // Check horizontal win
                    if (j <= columns - 4) {
                        if (grid[i][j + 1] != null && grid[i][j + 2] != null && grid[i][j + 3] != null) {
                            if (grid[i][j + 1].getColor().equals(currentPiece.getColor()) && grid[i][j + 2].getColor().equals(currentPiece.getColor()) && grid[i][j + 3].getColor().equals(currentPiece.getColor())) {
                                return true;
                            }
                        }
                    }
                    // Check vertical win
                    if (i <= rows - 4) {
                        if (grid[i + 1][j] != null && grid[i + 2][j] != null && grid[i + 3][j] != null) {
                            if (grid[i + 1][j].getColor().equals(currentPiece.getColor()) && grid[i + 2][j].getColor().equals(currentPiece.getColor()) && grid[i + 3][j].getColor().equals(currentPiece.getColor())) {
                                return true;
                            }
                        }
                    }
                    // Check diagonal win (ascending)
                    if (i <= rows - 4 && j <= columns - 4) {
                        if (grid[i + 1][j + 1] != null && grid[i + 2][j + 2] != null && grid[i + 3][j + 3] != null) {
                            if (grid[i + 1][j + 1].getColor().equals(currentPiece.getColor()) && grid[i + 2][j + 2].getColor().equals(currentPiece.getColor()) && grid[i + 3][j + 3].getColor().equals(currentPiece.getColor())) {
                                return true;
                            }
                        }
                    }
// Check diagonal win (descending)
                    if (i <= rows - 4 && j >= 3) {
                        if (grid[i + 1][j - 1] != null && grid[i + 2][j - 2] != null && grid[i + 3][j - 3] != null) {
                            if (grid[i + 1][j - 1].getColor().equals(currentPiece.getColor()) && grid[i + 2][j - 2].getColor().equals(currentPiece.getColor()) && grid[i + 3][j - 3].getColor().equals(currentPiece.getColor())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
