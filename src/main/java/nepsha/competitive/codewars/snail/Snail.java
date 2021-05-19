package nepsha.competitive.codewars.snail;

// https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/train/java
public class Snail {
    public static int[] snail(int[][] array) {
        int n = array[0].length;
        if (n == 0) return new int[]{};

        int[] snail = new int[n * n];

        int snailI = 0;
        int depth = 0;
        int maxIndex = n - 1;

        while (depth <= n / 2) {
            // top corner
            for (int i = depth; i < n - depth; i++) snail[snailI++] = array[depth][i];
            // right corner
            for (int i = depth + 1; i < maxIndex - depth; i++) snail[snailI++] = array[i][maxIndex - depth];
            // bottom corner
            if (n - depth * 2 != 1)
                for (int i = maxIndex - depth; i >= depth; i--) snail[snailI++] = array[maxIndex - depth][i];
            // left corner
            for (int i = maxIndex - depth - 1; i > depth; i--) snail[snailI++] = array[i][depth];
            depth++;
        }

        return snail;
    }
}