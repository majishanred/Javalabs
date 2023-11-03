import java.util.ArrayList;
import java.util.List;

public class Hall {
    int id;
    String name;
    int rows;
    int cols;
    List<Session> sessions = new ArrayList<>();

    public Hall(int id, String name, int rows, int cols) {
        this.id = id;
        this.name = name;
        this.rows = rows;
        this.cols = cols;
    }

    public Hall(String name, int rows, int cols, List<Session> sessions) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
        this.sessions = sessions;
    }

    public String getName() {
        return name;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public List<Session> find_session(String movie_name) {
        List<Session> results = new ArrayList<>();
        for(Session session : this.sessions) {
            if(session.movieName.equals(movie_name)) results.add(session);
        }

        return results;
    }

    public void add_session(Session session) {
        this.sessions.add(session);
    }

    public boolean does_fit(int row, int col) {
        return this.cols >= col && this.rows >= row;
    };

    public boolean doSessionsIntersect(Session session) {
        List<Boolean> results = new ArrayList<>();
        for(Session session1 : this.sessions) {
        }

        return true;
    }
}
