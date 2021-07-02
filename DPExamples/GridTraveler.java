import java.util.HashMap;
import java.util.Map;

public class GridTraveler extends BaseHelperClass {

    public long gridTraveler(int rows, int cols) {
        return gridTraveler(rows, cols, new HashMap<>());
    }

    private long gridTraveler(int rows, int cols, Map<String, Long> memo) {
        if (rows == 0 || cols == 0)
            return 0;

        final String key = rows + "#" + cols;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (rows == 1 || cols == 1)
            return 1;

        long top = gridTraveler(rows - 1, cols, memo);
        long left = gridTraveler(rows, cols - 1, memo);
        long size = top + left;
        memo.put(key, size);

        return size;
    }

    public static void main(String[] args) {
        GridTraveler m = new GridTraveler();
        m.print(m.gridTraveler(2, 3));
        m.print(m.gridTraveler(1, 1));
        m.print(m.gridTraveler(0, 1));
        m.print(m.gridTraveler(1, 0));
        m.print(m.gridTraveler(0, 8));
        m.print(m.gridTraveler(0, 0));
        m.print(m.gridTraveler(3, 3));
        m.print(m.gridTraveler(18, 18));
    }
}

/*

    0   1   1
    1   2   3
    1   3   6

 */
