public class CanSumTab extends BaseHelperClass {

    public boolean canSum(int target, int[] nums) {
        boolean[] table = new boolean[target + 1];
        table[0] = true;

        for (int i = 0; i <= target; i++) {
            if (table[i]) {
                for (int x : nums) {
                    if (i + x <= target) {
                        table[i + x] = table[i];
                    }
                }
            }
        }

        return table[target];
    }

    public static void main(String[] args) {
        CanSumTab m = new CanSumTab();

        m.print(m.canSum(7, new int[]{2, 3}));
        m.print(m.canSum(7, new int[]{5, 3, 4, 7}));
        m.print(m.canSum(7, new int[]{2, 4}));
        m.print(m.canSum(8, new int[]{2, 3, 5}));
        m.print(m.canSum(300, new int[]{7, 14}));

    }
}
