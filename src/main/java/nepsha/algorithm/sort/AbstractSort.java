package nepsha.algorithm.sort;

public abstract class AbstractSort implements Sort {
    protected  <T extends Comparable<? super T>> void swap(T[] a, int i, int j) {
        T t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
