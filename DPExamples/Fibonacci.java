import java.util.HashMap;
import java.util.Map;

public class Fibonacci extends BaseHelperClass {

    public long fibonacci(int n) {
        Map<Integer, Long> map = new HashMap<>();
        return fibonacci(n, map);
    }

    private long fibonacci(int n, Map<Integer, Long> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n <= 2)
            return 1;
        long fib = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        memo.put(n, fib);
        return fib;
    }

    public static void main(String[] args) {
        Fibonacci m = new Fibonacci();

        m.print(m.fibonacci(2));
        m.print(m.fibonacci(6));
        m.print(m.fibonacci(15));
        m.print(m.fibonacci(50));
        m.print(m.fibonacci(100));

    }
}
