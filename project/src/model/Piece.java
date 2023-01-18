package model;

public class Piece {
    private String color;
    private int row;
    private int column;

    public Piece(String color, int row, int column) {
        this.color = color;
        this.row = row;
        this.column = column;
    }

    public String getColor() {
        return color;
    }
}

