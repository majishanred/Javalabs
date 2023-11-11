package Pieces;

import java.util.List;

public abstract class Piece {
    private String name;
    private char color;
    public int row;
    public int col;
    public Piece(String name, char color) {
        this.name = name;
        this.color = color;
    }

    public Piece(String name, char color, int row, int col) {
        this.name = name;
        this.color = color;
        this.row = row;
        this.col = col;
    }
    public char getColor() {
        return color;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setColor(char color) { this.color = color; }

    public String getName() { return name; }

    public List<int[]> possible_movement(Piece[][] pieces) {
        return null;
    };

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
