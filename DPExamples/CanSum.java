import java.util.HashMap;
import java.util.Map;

public class CanSum extends BaseHelperClass {

    public boolean canSum(int target, int[] nums) {
        return canSum(target, nums, new HashMap<>());
    }

    private boolean canSum(int target, int[] nums, Map<Integer, Boolean> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }

        for (int x : nums) {
            int diff = target - x;
            if (canSum(diff, nums, memo)) {
                memo.put(target, true);
                return true;
            }
        }

        memo.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        CanSum m = new CanSum();

        m.print(m.canSum(7, new int[]{2, 3}));
        m.print(m.canSum(7, new int[]{5, 3, 4, 7}));
        m.print(m.canSum(7, new int[]{2, 4}));
        m.print(m.canSum(8, new int[]{2, 3, 5}));
        m.print(m.canSum(300, new int[]{7, 14}));

    }
}
