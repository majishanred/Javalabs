import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Session {
    int id;
    String movieName;
    Calendar begginng;
    Calendar ending;
    List<Ticket> relatedTickets = new ArrayList<>();

    public Session(int id, String movieName, Calendar begginng, Calendar ending) {
        this.id = id;
        this.movieName = movieName;
        this.begginng = begginng;
        this.ending = ending;
    }

    public Session(String movieName, Calendar begginng, Calendar ending, List<Ticket> relatedTickets) {
        this.movieName = movieName;
        this.begginng = begginng;
        this.ending = ending;
        this.relatedTickets = relatedTickets;
    }

    public void addTicket(Ticket ticket) {
        this.relatedTickets.add(ticket);
    }

    public boolean doTicketsIntersect(Ticket ticketToCheck) {
        List<Boolean> results = new ArrayList<>();
        for (Ticket ticket : this.relatedTickets) {
            if (ticket.row == ticketToCheck.row && ticket.col == ticketToCheck.col) {
                results.add(true);
            } else {
                results.add(false);
            }
        }
        return results.contains(true);
    }

    public static List<Session> sortDateExcAndReturnObe(List<Session> sessions) {
        sessions.sort((a, b) -> {
            if(a.begginng.before(b.begginng)) {
                return 1;
            } else {
                return -1;
            }
        });

        return sessions;
    };
}
