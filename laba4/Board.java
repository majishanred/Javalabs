import Pieces.*;

import java.rmi.AccessException;
import java.util.List;

public class Board {
    private Piece[][] fields = new Piece[8][8];
    int check_index;
    public char getColorGaming() {
        return colorGaming;
    }

    public void setColorGaming(char colorGaming) {
        this.colorGaming = colorGaming;
    }

    private char colorGaming;

    private King black_king;
    private King white_king;

    public void init(){
        this.fields[0] = new Piece[] {
                new Rook("R", 'w', 0, 0), new Knight("N", 'w', 0, 1),
                new Bishop("B", 'w', 0, 2), new Queen("Q", 'w', 0, 3),
                new King("K", 'w', 0, 4), new Bishop("B", 'w', 0, 5),
                new Knight("N", 'w', 0, 6),new Rook("R", 'w', 0, 7)
        };
        this.fields[1] = new Piece[] {
                new Pawn("P", 'w', 1, 0),    new Pawn("P", 'w', 1, 1),
                new Pawn("P", 'w', 1, 2),    new Pawn("P", 'w', 1, 3),
                new Pawn("P", 'w', 1, 4),    new Pawn("P", 'w', 1, 5),
                new Pawn("P", 'w', 1, 6),    new Pawn("P", 'w', 1, 7),
        };

        this.fields[7] = new Piece[]{
                new Rook("R", 'b', 7, 0), new Knight("N", 'b', 7, 1),
                new Bishop("B", 'b', 7, 2), new Queen("Q", 'b', 7, 3),
                new King("K", 'b', 7, 4), new Bishop("B", 'b', 7, 5),
                new Knight("N", 'b', 7, 6),new Rook("R", 'b', 7, 7)
        };
        this.fields[6] = new Piece[]{
                new Pawn("P", 'b', 6, 0),    new Pawn("P", 'b', 6, 1),
                new Pawn("P", 'b', 6, 2),    new Pawn("P", 'b', 6, 3),
                new Pawn("P", 'b', 6, 4),    new Pawn("P", 'b', 6, 5),
                new Pawn("P", 'b', 6, 6),    new Pawn("P", 'b', 6, 7),
        };

        this.black_king = (King) this.fields[7][4];
        this.white_king = (King) this.fields[0][4];
    }

    public Piece getPiece(int row, int col) throws Exception {
        Piece piece = this.fields[row][col];
        if(piece == null || piece.getColor() != this.colorGaming) {
            throw new IllegalAccessException("На этом поле нет никакой фигуры или вы пытаетесь взять чужую фигуру");
        } else {
            return piece;
        }
    };

    public String getCell(int row, int col){
        Piece figure = this.fields[row][col];
        if (figure == null){
            return "    ";
        }
        return " "+figure.getColor()+figure.getName()+" ";
    }

    public void print_board(){
        System.out.println(" +----+----+----+----+----+----+----+----+");
        for(int row = 7; row > -1; row--){
            System.out.print(row);
            for(int col = 0; col< 8; col++){
                System.out.print("|"+getCell(row, col));
            }
            System.out.println("|");
            System.out.println(" +----+----+----+----+----+----+----+----+");
        }

        for(int col = 0; col < 8; col++){
            System.out.print("    "+col);
        };
    }

    public void can_perform_action(Piece piece, int row, int col) throws Exception {
        List<int[]> possibilities = piece.possible_movement(this.fields);
        boolean res = false;
        for(int[] pos : possibilities) {
            if(pos[0] == row && pos[1] == col) {
                res = true;
                System.out.println(res);
                break;
            }
        };

        if(!res) throw new AccessException("Невозможно сделать ход на это поле, или вы пытаетесь сходить фигурой противника");
    };

    public void move_figure(Piece piece, int row, int col, int row1, int col1) {
        if(fields[row][col] instanceof King) {
            return;
        };
        this.fields[row][col] = piece;
        piece.row = row;
        piece.col = col;
        fields[row1][col1] = null;
    }

    public void print_pos_mov(Piece piece) {
        for(int[] pos : piece.possible_movement(this.fields)) {
            System.out.printf("%n%s %d%n", pos[0], pos[1]);
        }
    };

    public boolean check(Piece piece) {
        List<int[]> pos_mov = piece.possible_movement(this.fields);
        int i = 0;
        switch (colorGaming) {
            case ('w'):
                for(int[] mv : pos_mov) {
                    if(mv[0] == black_king.row && mv[1] == black_king.col) { check_index = i; return true; };
                    i++;
                }

                break;
            case ('b'):
                for(int[] mv : pos_mov) {
                    if(mv[0] == white_king.row && mv[1] == white_king.col) { check_index = i; return true; };
                    i++;
                }
                break;
        };

        return false;
    };

    public boolean mate(Piece piece) {
        switch (colorGaming) {
            case ('w') :
                if(black_king.can_escape(this.fields, black_king.possible_movement(this.fields)) || black_king.can_be_protected_from(this.fields, piece.possible_movement(this.fields).get(this.check_index))) return false;
            case ('b'):
                if(black_king.can_escape(this.fields, black_king.possible_movement(this.fields)) || white_king.can_be_protected_from(this.fields, piece.possible_movement(this.fields).get(this.check_index))) return false;
        };
        return true;
    };
}
