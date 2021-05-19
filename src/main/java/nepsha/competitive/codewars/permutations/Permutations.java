package nepsha.competitive.codewars.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.codewars.com/kata/5254ca2719453dcc0b00027d
// TODO
public class Permutations {
    private static void swap(char[] a, int i1, int i2) {
        char t = a[i1];
        a[i1] = a[i2];
        a[i2] = t;
    }

    private static int indexOfMin(char[] a, int from, char ignored) {
        int minI = from;
        for (int i = from; i < a.length; i++) if (a[minI] > a[i] && a[i] != ignored) minI = i;
        return minI;
    }

    public static List<String> singlePermutations(String s) {
        var p = s.toCharArray();
        List<String> result = new ArrayList<>();
        result.add(new String(p));
        while (true) {
            int i;
            for (i = p.length-1; i > 0 && p[i] <= p[i-1]; i--);
            if (i == 0) break;
            swap(p, i-1, indexOfMin(p, i, p[i-1]));
            Arrays.sort(p, i, p.length);
            result.add(new String(p));
        }

        return result;
    }
}
