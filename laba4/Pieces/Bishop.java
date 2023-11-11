package Pieces;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(String name, char color) {
        super(name, color);
    }

    public Bishop(String name, char color, int row, int col) {
        super(name, color, row, col);
    }

    @Override
    public List<int[]> possible_movement(Piece[][] pieces) {
        List<int[]> result = new ArrayList<>();

        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            int[] res = {i, j};
            if(pieces[i][j] == null) {
                result.add(res);
            } else if (pieces[i][j] != null && pieces[i][j].getColor() != this.getColor()) {
                result.add(res);
                break;
            } else {
                break;
            }
        }
        for (int i = row+1, j = col-1; i <= 7 && j >= 0; i++, j--) {
            int[] res = {i, j};
            if(pieces[i][j] == null) {
                result.add(res);
            } else if (pieces[i][j] != null && pieces[i][j].getColor() != this.getColor()) {
                result.add(res);
                break;
            } else {
                break;
            }
        }
        for (int i = row+1, j = col-1; i <= 7 && j >= 0; i++, j--) {
            int[] res = {i, j};
            if(pieces[i][j] == null) {
                result.add(res);
            } else if (pieces[i][j] != null && pieces[i][j].getColor() != this.getColor()) {
                result.add(res);
                break;
            } else {
                break;
            }
        }
        for (int i = row+1, j = col+1; i <= 7 && j <= 7; i++, j++) {
            int[] res = {i, j};
            if(pieces[i][j] == null) {
                result.add(res);
            } else if (pieces[i][j] != null && pieces[i][j].getColor() != this.getColor()) {
                result.add(res);
                break;
            } else {
                break;
            }
        }

        return result;
    }
}