package Pieces;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    private boolean isFirstStep = true;
    public boolean goUp;
    public Pawn(String name, char color) {
        super(name, color);
    }

    public Pawn(String name, char color, int row, int col) {
        super(name, color, row, col);
    }

    @Override
    public List<int[]> possible_movement(Piece[][] pieces) {
        List<int[]> result = new ArrayList<>();

        if(this.getColor() == 'w') {
            if(row < 7 && col < 7 && pieces[row+1][col+1] != null && pieces[row+1][col+1].getColor() == 'b') {
                int[] res = {row+1, col+1};
                result.add(res);
            };
            if (row < 7 && col > 0 && pieces[row+1][col-1] != null && pieces[row+1][col+1].getColor() == 'b') {
                int[] res = {row+1, col-1};
                result.add(res);
            };
            if(row < 7 && pieces[row+1][col] == null) {
                int[] res = {row+1, col};
                result.add(res);
            };

        } else {
            if(row > 0 && col < 7 && pieces[row-1][col+1] != null && pieces[row-1][col+1].getColor() == 'w') {
                int[] res = {row-1, col+1};
                result.add(res);
            };
            if(row > 0 && col > 0 && pieces[row-1][col-1] != null && pieces[row-1][col-1].getColor() == 'w') {
                int[] res = {row-1, col-1};
                result.add(res);
            };
            if(row > 0 && pieces[row-1][col] == null) {
                int[] res = {row-1, col};
                result.add(res);
            };
        }

        return result;
    }
}
