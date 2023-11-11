package Pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(String name, char color) {
        super(name, color);
    }

    public Knight(String name, char color, int row, int col) {
        super(name, color, row, col);
    }
    @Override
    public List<int[]> possible_movement(Piece[][] pieces) {
        List<int[]> result = new ArrayList<>();
        if(row + 1 <= 7 && col + 2 <= 7 && (pieces[row+1][col+2] == null
                || pieces[row+1][col+2].getColor() != this.getColor())) {
            int[] res = {row + 1, col + 2};
            result.add(res);
        };
        if(row + 2 <= 7 && col + 1 <= 7 && (pieces[row+2][col+1] == null
                || pieces[row+2][col+1].getColor() != this.getColor())) {
            int[] res = {row + 2, col + 1};
            result.add(res);
        };
        if(row + 2 <= 7 && col - 1 >= 0 && (pieces[row+2][col-1] == null
                || pieces[row+2][col-1].getColor() != this.getColor())) {
            int[] res = {row + 2, col - 1};
            result.add(res);
        };
        if(row + 1 <= 7 && col - 2 >= 0 && (pieces[row+1][col-2] == null
                || pieces[row+1][col-2].getColor() != this.getColor())) {
            int[] res = {row + 1, col - 2};
            result.add(res);
        };
        if(row - 1 >= 0 && col - 2 >= 0 && (pieces[row-1][col-2] == null
                || pieces[row-1][col-2].getColor() != this.getColor())) {
            int[] res = {row - 1, col - 2};
            result.add(res);
        };
        if(row - 2 >= 0 && col - 1 >= 0 && (pieces[row-2][col-1] == null
                || pieces[row-2][col-1].getColor() != this.getColor())) {
            int[] res = {row - 2, col - 1};
            result.add(res);
        };
        if(row - 2 >= 0 && col + 1 <= 7 && (pieces[row-2][col+1] == null
                || pieces[row-2][col+1].getColor() != this.getColor())) {
            int[] res = {row - 2, col + 1};
            result.add(res);
        };
        if(row - 1 >= 0 && col + 2 <= 7 && (pieces[row-1][col+2] == null
                || pieces[row-1][col+2].getColor() != this.getColor())) {
            int[] res = {row - 1, col + 2};
            result.add(res);
        };

        return result;
    }
}