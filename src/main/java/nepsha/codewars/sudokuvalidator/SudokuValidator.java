package nepsha.codewars.sudokuvalidator;

import java.util.Arrays;
import java.util.List;

public class SudokuValidator {
    private static List<Boolean> createPresentDigitMask() {
        Boolean[] data = new Boolean[9];
        Arrays.fill(data,false);
        return Arrays.asList(data);
    }

    private static boolean checkAllDigitsPresent(List<Boolean> digitsPresent) {
        return digitsPresent.stream().allMatch(a -> a);
    }

    private static boolean checkSquare(int[][] sudoku, int xShift, int yShift) {
        List<Boolean> digitsPresent = createPresentDigitMask();
        for (int i = yShift * 3; i < yShift * 3 + 3; i++) {
            for (int k = xShift * 3; k < xShift * 3 + 3; k++) {
                digitsPresent.set(sudoku[i][k] - 1, true);
            }
        }
        return checkAllDigitsPresent(digitsPresent);
    }

    public static boolean check(int[][] sudoku) {
        List<Boolean> columnDigitsPresentMask = createPresentDigitMask();
        List<Boolean> rowDigitsPresentMask = createPresentDigitMask();
        // check lines
        for (int i = 0; i < sudoku.length; i++) {
            for (int k = 0; k < sudoku.length; k++) {
                if (sudoku[i][k] < 1 || sudoku[k][i] < 1) return false;
                columnDigitsPresentMask.set(sudoku[i][k] - 1, true);
                rowDigitsPresentMask.set(sudoku[k][i] - 1, true);
            }
            if (!checkAllDigitsPresent(columnDigitsPresentMask) || !checkAllDigitsPresent(rowDigitsPresentMask))
                return false;
            columnDigitsPresentMask = createPresentDigitMask();
            rowDigitsPresentMask = createPresentDigitMask();
        }
        // check squares
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                if (!checkSquare(sudoku, i, k)) return false;
            }
        }
        return true;
    }
}