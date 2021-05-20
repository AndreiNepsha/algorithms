package nepsha.algorithm.sort;

public class BubbleSort extends AbstractSort {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] a) {
        int n = a.length;
        boolean swapped;
        do {
            swapped = false;
            for (int j = 0; j < n-1; j++) {
                if (a[j].compareTo(a[j+1]) > 0) {
                    swap(a, j, j+1);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}
