import java.util.Arrays;

public class RemoveIslands {

    private static final int[][] INPUT = {
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1}
    };

    public static void main(String[] args) {
        RemoveIslands m = new RemoveIslands();
        m.removeIslands(INPUT);
    }

    public void removeIslands(final int[][] matrix) {
        printMatrix(matrix);

        final int m = matrix.length;
        if (m == 0)
            return;

        final int n = matrix[0].length;
        if (n == 0)
            return;

        // Create boolean matrix to track borders
        final boolean[][] borders = new boolean[m][n];

        // DFS from borders
        for (int row = 0; row < m; row++) {
            // Column 0 and n - 1
            dfs(m, n, row, 0, matrix, borders);
            dfs(m, n, row, n - 1, matrix, borders);
        }

        for (int col = 0; col < n; col++) {
            // Row 0 and m - 1
            dfs(m, n, 0, col, matrix, borders);
            dfs(m, n, m - 1, col, matrix, borders);
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (!borders[row][col]) {
                    matrix[row][col] = 0;
                }
            }
        }

        printMatrix(matrix);
    }

    private void dfs(
            final int m,
            final int n,
            final int row,
            final int col,
            final int[][] matrix,
            final boolean[][] borders
    ) {
        if (row < 0 || row >= m || col < 0 || col >= n ||
                matrix[row][col] == 0 || borders[row][col])
            return;

        borders[row][col] = true;

        dfs(m, n, row - 1, col, matrix, borders);
        dfs(m, n, row + 1, col, matrix, borders);
        dfs(m, n, row, col - 1, matrix, borders);
        dfs(m, n, row, col + 1, matrix, borders);
    }

    private void printMatrix(final int[][] m) {
        System.out.println();
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
        System.out.println();
    }
}
