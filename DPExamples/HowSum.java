import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum extends BaseHelperClass {

    public List<Integer> howSum(int target, int[] numbers) {
        return howSum(target, numbers, new HashMap<>());
    }

    private List<Integer> howSum(int target, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target == 0) {
            return new ArrayList<>();
        }
        if (target < 0) {
            return null;
        }

        for (int x : numbers) {
            int diff = target - x;
            List<Integer> result = howSum(diff, numbers, memo);
            if (result != null) {
                result.add(x);
                memo.put(target, result);
                return result;
            }
        }

        memo.put(target, null);
        return null;
    }

    public static void main(String[] args) {
        HowSum m = new HowSum();

        m.print(m.howSum(7, new int[]{2, 3}));
        m.print(m.howSum(7, new int[]{5, 3, 4, 7}));
        m.print(m.howSum(7, new int[]{2, 4}));
        m.print(m.howSum(8, new int[]{2, 3, 5}));
        m.print(m.howSum(300, new int[]{7, 14}));
    }
}
