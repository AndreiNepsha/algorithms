package nepsha.algorithm.sort;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {
    private static final Integer[] unsortedInts1 = {5, 90, 13, -9, -24, 54, -100, 144, 43, 3, 2, 111};
    private static final Integer[] sortedInts1 = {-100, -24, -9, 2, 3, 5, 13, 43, 54, 90, 111, 144};

    private static final Integer[] unsortedInts2 = {};
    private static final Integer[] sortedInts2 = {};

    @Test
    public void integer_test_1() {
        Sort sort = new BubbleSort();
        MergeSort mSort = new MergeSort();
        mSort.sort(unsortedInts1);
        print(unsortedInts1);
        mSort.sort(unsortedInts2);
        print(unsortedInts2);
        assertArrayEquals(sortedInts1, unsortedInts1);
        assertArrayEquals(sortedInts2, unsortedInts2);
    }

    private void print(Object[] a) {
        System.out.println(Arrays.asList(a));
    }
}
