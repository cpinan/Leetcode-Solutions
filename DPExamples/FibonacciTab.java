public class FibonacciTab extends BaseHelperClass {

    public long fibonacci(int n) {
        long[] dp = new long[n + 1];

        if (n > 0) {
            dp[1] = 1;
            /*
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            */
            for (int i = 0; i <= n; i++) {
                if (i + 1 <= n) {
                    dp[i + 1] += dp[i];
                }
                if (i + 2 <= n) {
                    dp[i + 2] += dp[i];
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciTab m = new FibonacciTab();

        m.print(m.fibonacci(2));
        m.print(m.fibonacci(6));
        m.print(m.fibonacci(8));
        m.print(m.fibonacci(15));
        m.print(m.fibonacci(50));
        m.print(m.fibonacci(100));
    }
}
