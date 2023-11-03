import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Cinema cinema1;
    static Cinema cinema2;
    static Hall cinema1_hall1;
    static Hall cinema1_hall2;
    static Hall cinema2_hall1;
    static Hall cinema2_hall2;
    static User user = new User(1, "user", "password");

    static public void main(String[] args) {
        init_cinemas();
        add_some_session();

        buy_ticket_to_session(
                user,
                cinema1,
                cinema1_hall1,
                cinema1_hall1.sessions.get(0),
                5,
                5
        );

        System.out.println(
                "Вы купили билет с номером сессии:" + user.tickets.get(0).session_id
        );

        find_session();
    };

    static public void add_some_session() {
        Session session_to_add = new Session(
                1,
                "Marvel's Avengers",
                new GregorianCalendar(2023, 11, 10, 14, 30, 0),
                new GregorianCalendar(2023, 11, 10, 17, 0, 0)
        );

        cinema1_hall1.add_session(session_to_add);
    };

    static public void buy_ticket_to_session(User user1, Cinema cinema1, Hall hall1, Session session1, int row, int col) {
        Ticket ticket = new Ticket(
                user1.id,
                cinema1.id,
                hall1.id,
                session1.id,
                row,
                col
        );

        if(hall1.does_fit(row, col) && !(session1.doTicketsIntersect(ticket))) {
            user.tickets.add(ticket);
            session1.relatedTickets.add(ticket);
        };
    };

    static public void find_session() {
        List<Session> result = new ArrayList<>();
        List<Cinema> cinemas = new ArrayList<>();
        cinemas.add(cinema1);
        cinemas.add(cinema2);

        for(Cinema cinema : cinemas) {
            for(Hall hall : cinema.halls) {
                List<Session> sessions = hall.find_session("Marvel's Avengers");
                result.addAll(sessions);
            }
        }

        result = Session.sortDateExcAndReturnObe(result);

        Session session = result.get(0);
        System.out.println("Мы нашли для вас сессию: " + session.id +
                "\n" + "Время проведения: " + session.begginng.get(Calendar.YEAR) + ":" +
                session.begginng.get(Calendar.MONTH) + ":" +
                session.begginng.get(Calendar.DAY_OF_MONTH) + " " +
                session.begginng.get(Calendar.HOUR_OF_DAY) + ":" +
                session.begginng.get(Calendar.MINUTE)
        );
    };
    static void init_cinemas() {
        List<Hall> cinema1_halls = new ArrayList<>();
        Hall hall1 = new Hall(1, "Север", 20, 20);
        Hall hall2 = new Hall(2,"Юг", 15, 17);
        cinema1_halls.add(hall1);
        cinema1_halls.add(hall2);

        List<Hall> cinema2_halls = new ArrayList<>();
        Hall hall3 = new Hall(3,"Восток", 20, 20);
        Hall hall4 = new Hall(4,"Запад", 15, 19);
        cinema2_halls.add(hall3);
        cinema2_halls.add(hall4);

        cinema1 = new Cinema(1,"Плаза", cinema1_halls);
        cinema2 = new Cinema(2,"Европа", cinema2_halls);

        cinema1_hall1 = cinema1_halls.get(0);
        cinema1_hall2 = cinema1_halls.get(1);

        cinema2_hall1 = cinema2_halls.get(0);
        cinema2_hall2 = cinema2_halls.get(1);
    }
}