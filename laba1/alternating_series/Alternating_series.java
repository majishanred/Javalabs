package alternating_series;

import java.util.ArrayList;

public class Alternating_series {
    public static int sum(int[] series) {
        int sum = 0;

        for(int i = 0; i < series.length; i++) {
            if(i % 2 == 0) {
                sum += series[i];
            } else sum -= series[i];
        };

        return sum;
    }
}
