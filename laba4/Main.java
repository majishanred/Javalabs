// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import Pieces.Piece;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Board board = new Board();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        board.setColorGaming('w');
        board.init();
        start_game();
    }

    public static void start_game() {
        print_game(board);

        String inputLine = in.nextLine();
        if (inputLine.equals("exit")){
            end_game();
        }

        int x1, y1, x2, y2;
        String[] coords = inputLine.split(" ");
        y1 = Integer.parseInt(coords[0]);
        x1 = Integer.parseInt(coords[1]);

        try {
            Piece piece = board.getPiece(y1, x1);
            board.print_pos_mov(piece);
            String[] cord = in.nextLine().split(" ");
            y2 = Integer.parseInt(cord[0]);
            x2 = Integer.parseInt(cord[1]);
            board.can_perform_action(piece, y2, x2);
            board.move_figure(piece, y2, x2, y1, x1);
            System.out.println("\n");
            board.print_board();
            if(board.check(piece)) {
                if(board.mate(piece)) {
                    System.out.println("Игра закончена");
                    Main.end_game();
                };
            };
            switch (board.getColorGaming()) {
                case 'w' -> board.setColorGaming('b');
                case 'b' -> board.setColorGaming('w');
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
            end_game();
        } finally {
            start_game();
        }
    }

    public static void print_game(Board board) {
        board.print_board();
        System.out.println();
        System.out.println("Команды: ");
        System.out.println("exit: Выход из игры");
        System.out.println("y1 x1 y2 x2: Ход фигуры из клетки x1, y1 в клекту x2, y2");


        switch (board.getColorGaming()) {
            case 'w' -> System.out.println("Ход Белых:");
            case 'b' -> System.out.println("Ход Черных:");
        }
    }

    public static void end_game() {
        System.out.println();
        System.out.println("Игра завeршена.");
        in.close();
        System.exit(1);
    }
}