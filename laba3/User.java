import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String login;
    String password;
    List<Ticket> tickets = new ArrayList<>();

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public User(int id, String login, String password, List<Ticket> tickets) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.tickets = tickets;
    };

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
