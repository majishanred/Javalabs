// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
import Collatz_sequence.Collatz_sequence;
import alternating_series.Alternating_series;
import doubly_even.DoublyEven;
import logical_maximin.LogicalMaximin;
import treasure_search.Treasure_search;

public class Main {
    public static void main(String[] args)  {
    }

    private static int[] each_sub_max(int[][] arr) {
        int[] max = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            int cur_max = 0;
            for(int j = 0; j < arr[i].length; j++) {
                cur_max = Math.max(cur_max, arr[i][j]);
            }

            max[i] = cur_max;
        }

        return max;
    }

    private static int sum(int[][] arr) {
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }

        return sum;
    }

    private static int[] pair(int[] arr, int target) {
        int[] pos = new int[2];

        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target) {
                    pos[0] = arr[i];
                    pos[1] = arr[j];
                    return pos;
                }
            }
        }

        return null;
    }

    private static int[][] rotate_90deg_right(int[][] arr) {
        int[][] copy = new int[arr[0].length][arr.length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                copy[j][arr.length - i - 1] = arr[i][j];
            }
        }

        return copy;
    }

    private static int[][] rotate_90deg_left(int[][] arr) {
        int[][] copy = new int[arr[0].length][arr.length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                copy[arr[i].length - j - 1][i] = arr[i][j];
            }
        }

        return copy;
    }
    private static int[] concat(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int ind = 0;
        int[] res = new int[a.length + b.length];

        while(i < a.length && j < b.length) {
            if(a[i] > b[j]) {
                res[ind] = b[j];
                ind++;
                j++;
            } else {
                res[ind] = a[i];
                ind++;
                i++;
            }
        }

        while(i < a.length) {
            res[ind] = a[i];
            ind++;
            i++;
        }

        while(j < b.length) {
            res[ind] = b[j];
            ind++;
            j++;
        }

        return res;
    }

    private static String substr(String str) {
        String max_str = "";
        String sub = "";

        for(int i = 0; i < str.length(); i++) {
            if(sub.indexOf(str.charAt(i)) == -1) {
                sub = sub.concat(Character.toString(str.charAt(i)));
            } else {
                int ind = sub.indexOf(str.charAt(i));
                sub = sub.substring(ind+1).concat(Character.toString(str.charAt(i)));
            }

            max_str = sub.length() > max_str.length() ? sub : max_str;
        }

        return max_str;
    }

    private static int max_sum(int[] arr) {
        int max_sum = 0;
        int partial_sum = 0;

        for(int elem : arr) {
            partial_sum += elem;
            max_sum = Math.max(max_sum, partial_sum);
            if(partial_sum < 0) partial_sum = 0;
        }

        return max_sum;
    }
}