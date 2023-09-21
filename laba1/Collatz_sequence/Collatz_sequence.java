package Collatz_sequence;
public class Collatz_sequence {
    public static int steps_of_sequence(int num) {
     int steps = 0;
     int num_cp = num;

     while(num_cp != 1) {
         if (num_cp % 2 == 0) {
             num_cp /= 2;
         } else num_cp = num_cp * 3 + 1;

         steps++;
     }

     return steps;
    }
}
