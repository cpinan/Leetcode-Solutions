import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HowSumTab extends BaseHelperClass {

    public List<Integer> howSum(int target, int[] numbers) {
        List<Integer>[] table = new List[target + 1];
        table[0] = new ArrayList<>();

        for (int i = 0; i <= target; i++) {
            if (table[i] != null) {
                for (int x : numbers) {
                    int id = i + x;
                    if (id <= target) {
                        table[id] = new ArrayList<>();
                        table[id].addAll(table[i]);
                        table[id].add(x);
                    }
                }
            }
        }

        /*
        for (int i = 0; i <= target; i++) {
            List<Integer> t = table[i];
            if (t != null) {
                System.out.println(i + ") " + Arrays.toString(t.toArray(new Integer[t.size()])));
            }
        }

         */

        return table[target];
    }

    public static void main(String[] args) {
        HowSumTab m = new HowSumTab();

        m.print(m.howSum(7, new int[]{2, 3}));
        m.print(m.howSum(7, new int[]{5, 3, 4, 7}));
        m.print(m.howSum(7, new int[]{2, 4}));
        m.print(m.howSum(8, new int[]{2, 3, 5}));
        m.print(m.howSum(300, new int[]{7, 14}));

    }

}
