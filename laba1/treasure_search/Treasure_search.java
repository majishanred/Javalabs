package treasure_search;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Treasure_search {
    public static void treasure_search() {
        Scanner scanner = new Scanner(System.in);
        int x_coord = 0;
        int y_coord = 0;
        int steps = 0;
        int treasure_x_coord = scanner.nextInt();
        int treasure_y_coord = scanner.nextInt();

        String way_to = scanner.next();

        while(!way_to.equals("стоп")) {
            int new_coord = scanner.nextInt();

            if(way_to.equals("север")) {
                y_coord += new_coord;
            } else if (way_to.equals("юг")) {
                y_coord -= new_coord;
            } else if (way_to.equals("запад")) {
                x_coord -= new_coord;
            } else if (way_to.equals("восток")) {
                x_coord += new_coord;
            }

            if(x_coord != treasure_x_coord || y_coord != treasure_y_coord) {
                steps += 1;
            }

            way_to = scanner.next();
        }

        System.out.println(steps);
    }
}
