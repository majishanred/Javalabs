import java.util.ArrayList;
import java.util.List;

public class Cinema {
    int id;
    String name;
    List<Hall> halls = new ArrayList<>();

    public Cinema(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Cinema(int id, String name, List<Hall> halls) {
        this.id = id;
        this.name = name;
        this.halls = halls;
    }

    public String getName() {
        return name;
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }
}
