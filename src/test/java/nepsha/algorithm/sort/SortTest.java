package nepsha.algorithm.sort;

import nepsha.competitive.codewars.matrixdeterminant.MatrixDeterminant;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SortTest {
    private static final Integer[] unsortedInts1 = {5, 90,13, -9, -24, 54, -100, 43, 3, 2, 111};
    private static final Integer[] sortedInts1 = {-100, -24, -9, 2, 3, 5, 13, 43, 54, 90, 111};

    @Test
    public void integer_test_1() {
        (new SelectionSort()).sort(unsortedInts1);
        print(unsortedInts1);
        assertArrayEquals(sortedInts1, unsortedInts1);
    }

    private void print(Object[] a) {
        System.out.println(Arrays.asList(a));
    }
}
