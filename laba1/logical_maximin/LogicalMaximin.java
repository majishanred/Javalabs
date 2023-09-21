package logical_maximin;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class LogicalMaximin {
    public static void apply() {
        Scanner scanner = new Scanner(System.in);

        int amount = parseInt(scanner.next());

        int road_num = 0;
        int height_max = 0;

        int i = 1;
        while(i <= amount) {
            int road_amount = parseInt(scanner.next());
            int[] roads = new int[road_amount];

            int j = 0;
            while(j < road_amount) {
                roads[j] = parseInt(scanner.next());
                j++;
            }

            int cur_min = roads[0];

            for (int road : roads) {
                if (road <= cur_min) {
                    cur_min = road;
                }
            }

            if(cur_min > height_max) {
                height_max = cur_min;
                road_num = i;
            }

            i++;
        }

        System.out.print(road_num);
        System.out.print(" ");
        System.out.print(height_max);
    }
}
