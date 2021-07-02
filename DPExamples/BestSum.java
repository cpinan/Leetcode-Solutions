import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum extends BaseHelperClass {

    public List<Integer> bestSum(int target, int[] nums) {
        return bestSum(target, nums, new HashMap<>());
    }

    private List<Integer> bestSum(int target, int[] nums, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target == 0) {
            return new ArrayList<>();
        }
        if (target < 0) {
            return null;
        }

        List<Integer> result = null;
        for (int x : nums) {
            int diff = target - x;
            List<Integer> tmp = bestSum(diff, nums, memo);
            if (tmp != null) {
                tmp.add(x);
                if (result == null || result.size() > tmp.size()) {
                    result = new ArrayList<>(tmp);
                }
            }
        }
        memo.put(target, result);
        return result;
    }

    public static void main(String[] args) {
        BestSum m = new BestSum();
        m.print(m.bestSum(7, new int[]{2, 3}));
        m.print(m.bestSum(7, new int[]{5, 3, 4, 7}));
        m.print(m.bestSum(7, new int[]{2, 4}));
        m.print(m.bestSum(8, new int[]{2, 3, 5}));
        m.print(m.bestSum(300, new int[]{7, 14}));
    }
}
