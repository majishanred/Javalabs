public class Ticket {
    int user_id;
    int cinema_id;
    int hall_id;
    int session_id;
    int row;
    int col;

    public Ticket(int user_id, int cinema_id, int hall_id, int session_id, int row, int col) {
        this.user_id = user_id;
        this.cinema_id = cinema_id;
        this.hall_id = hall_id;
        this.session_id = session_id;
        this.row = row;
        this.col = col;
    }
}
