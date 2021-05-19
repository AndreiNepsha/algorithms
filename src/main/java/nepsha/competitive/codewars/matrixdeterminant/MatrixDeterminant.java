package nepsha.competitive.codewars.matrixdeterminant;

public class MatrixDeterminant {
    public static int determinant(int[][] matrix) {
        if (matrix.length == 1) return matrix[0][0];
        int[] indexes = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) indexes[i] = i;
        return _determinant(matrix, 0, indexes);
    }

    public static int _determinant(int[][] matrix, int row, int[] columnIndexes)
    {
        int majorSize = columnIndexes.length;
        if (majorSize == 1) return matrix[row][columnIndexes[0]];
        else {
            int d = 0;
            int op = 0;
            for (int column : columnIndexes) {
                int[] minorColumnIndexes = new int[majorSize-1];
                for (int i = 0, j = 0; i < majorSize; i++) {
                    if (columnIndexes[i] != column) minorColumnIndexes[j++] = columnIndexes[i];
                }
                int subD = matrix[row][column] * _determinant(matrix, row+1, minorColumnIndexes);
                if (op++ % 2 == 1) subD = -subD;
                d += subD;
            }
            return d;
        }
    }
}
