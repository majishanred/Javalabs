package Pieces;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(String name, char color) {
        super(name, color);
    }

    public Rook(String name, char color, int row, int col) {
        super(name, color, row, col);
    }

    @Override
    public List<int[]> possible_movement(Piece[][]pieces) {
        List<int[]> result = new ArrayList<>();

        for(int i = this.row+1; i <= 7; i++) {
            int[] res = {i, this.col};

            if(pieces[i][this.col] == null) {
                result.add(res);
            } else if (pieces[i][this.col] != null && pieces[i][this.col].getColor() != this.getColor()) {
                result.add(res);
                break;
            } else {
                break;
            }
        };
        for(int row = this.row-1; row >= 0; row--) {
            int[] res = {row, this.col};

            if(pieces[row][this.col] == null) {
                result.add(res);
            } else if (pieces[row][this.col] != null && pieces[row][this.col].getColor() != this.getColor()) {
                result.add(res);
                break;
            } else {
                break;
            }
        };
        for(int col = this.col+1; col <= 7; col++) {
            int[] res = {this.row, col};

            if(pieces[this.row][col] == null) {
                result.add(res);
            } else if (pieces[this.row][col] != null && pieces[this.row][col].getColor() != this.getColor()) {
                result.add(res);
                break;
            } else {
                break;
            }
        };
        for(int col = this.col-1; col >= 0; col--) {
            int[] res = {this.row, col};

            if(pieces[this.row][col] == null) {
                result.add(res);
            } else if (pieces[this.row][col] != null && pieces[this.row][col].getColor() != this.getColor()) {
                result.add(res);
                break;
            } else {
                break;
            }
        };

        return result;
    }

    private boolean checkEmptyFields(int start, int end, int step, int index, Piece[][] fields) {
        for (int i = start + step; Math.abs(end - i) > 0; i = i + step) {
            if (fields[index][i] != null) return false;
        }
        return true;
    }
}
