import java.util.Arrays;

public class GridTravelerTab extends BaseHelperClass {

    public long gridTraveler(int rows, int cols) {
        if (rows == 0 || cols == 0)
            return 0;

        long[][] dp = new long[rows + 1][cols + 1];
        dp[1][1] = 1;

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (i + 1 <= rows) {
                    dp[i + 1][j] += dp[i][j];
                }
                if (j + 1 <= cols) {
                    dp[i][j + 1] += dp[i][j];
                }
            }
        }

        /*
        for(long[] r : dp) {
            System.out.println(Arrays.toString(r));
        }
         */

        return dp[rows][cols];
    }

    public static void main(String[] args) {
        GridTravelerTab m = new GridTravelerTab();
        m.print(m.gridTraveler(3, 3));
        m.print(m.gridTraveler(1, 1));
        m.print(m.gridTraveler(0, 1));
        m.print(m.gridTraveler(1, 0));
        m.print(m.gridTraveler(0, 8));
        m.print(m.gridTraveler(0, 0));
        m.print(m.gridTraveler(3, 3));
        m.print(m.gridTraveler(18, 18));
    }
}
