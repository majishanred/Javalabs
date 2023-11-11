package Pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(String name, char color) {
        super(name, color);
    }

    public King(String name, char color, int row, int col) {
        super(name, color, row, col);
    };

    @Override
    public List<int[]> possible_movement(Piece[][] pieces) {
        List<int[]> results = new ArrayList<>();
        if(row > 0 && col < 7 && (pieces[row-1][col+1] == null
                || pieces[row-1][col+1].getColor() != this.getColor())) {
            int[] res = {row-1, col+1};
            results.add(res);
        };
        if(col < 7 && (pieces[row][col+1] == null
                || pieces[row][col+1].getColor() != this.getColor())) {
            int[] res = {row, col+1};
            results.add(res);
        };
        if(row < 7 && col < 7 && (pieces[row+1][col+1] == null
                || pieces[row+1][col+1].getColor() != this.getColor())) {
            int[] res = {row+1, col+1};
            results.add(res);
        }
        if(row < 7 && (pieces[row+1][col] == null
                || pieces[row+1][col].getColor() != this.getColor())) {
            int[] res = {row+1, col};
            results.add(res);
        };
        if(row < 7 && col > 0 && (pieces[row+1][col-1] == null
                || pieces[row+1][col-1].getColor() != this.getColor())) {
            int[] res = {row+1, col-1};
            results.add(res);
        };
        if(col > 0 && (pieces[row][col-1] == null
                || pieces[row][col-1].getColor() != this.getColor())) {
            int[] res = {row, col-1};
            results.add(res);
        };
        if(row > 0 && col > 0 && (pieces[row-1][col-1] == null
                || pieces[row-1][col-1].getColor() != this.getColor())) {
            int[] res = {row-1, col-1};
            results.add(res);
        };
        if(row > 0 && (pieces[row-1][col] == null
                || pieces[row-1][col].getColor() != this.getColor())) {
            int[] res = {row-1, col+1};
            results.add(res);
        };

        return results;
    };


    public boolean can_escape(Piece[][] pieces, List<int[]> pos_move) {
        List<int[]> attack_move = new ArrayList<>();
        for(Piece[] row : pieces) {
            for(Piece piece : row) {
                if(piece != null && piece.getColor() != this.getColor()) attack_move.addAll(piece.possible_movement(pieces));
            }
        }

        List<int[]> res = new ArrayList<>();
        for(int[] attack : attack_move) {
            for(int[] escape : pos_move) {
                if(attack[0] != escape[0] && attack[1] != escape[1]) {
                    res.add(escape);
                }
            };
        }

        return res.isEmpty();
    };

    public boolean can_be_protected_from(Piece[][] pieces, int[] from) {
        List<int[]> defender_move = new ArrayList<>();
        for(Piece[] row : pieces) {
            for(Piece piece : row) {
                if(piece != null && piece.getColor() == this.getColor()) defender_move.addAll(piece.possible_movement(pieces));
            }
        };

        for(int[] move : defender_move) {
            if(move[0] == from[0] && move[1] == from[1]) { return true; }
        };

        return false;
    };
}
