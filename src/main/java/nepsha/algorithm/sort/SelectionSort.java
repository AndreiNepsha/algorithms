package nepsha.algorithm.sort;

import java.util.Arrays;

public class SelectionSort extends AbstractSort {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (a[j].compareTo(a[min]) < 0) min = j;
            }
            swap(a, i, min);
        }
    }
}
