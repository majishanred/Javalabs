package alternating_series;

import java.util.Scanner;

public class Alternating_series {
    public static int sum() {
        Scanner in = new Scanner(System.in);
        int counter = in.nextInt();
        int pos = 0;
        int sum = 0;

        for(int i = 1; i <= counter; i++) {
            pos = pos % 2 + 1;

            sum += pos % 2 == 1 ? in.nextInt() : -in.nextInt();
        }

        return sum;
    }
}
