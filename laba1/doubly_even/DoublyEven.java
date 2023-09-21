package doubly_even;

import static java.lang.Integer.parseInt;

public class DoublyEven {
    public static boolean check(String num) {
        int sum = 0;
        int mult = 1;

        for(int i = 0; i < num.length(); i++) {
            sum += num.charAt(i);
            mult *= num.charAt(i);
        }

        if (sum != mult) {
            return false;
        } else {
            return true;
        }
    }
}
