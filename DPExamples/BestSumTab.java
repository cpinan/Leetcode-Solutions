import java.util.ArrayList;
import java.util.List;

public class BestSumTab extends BaseHelperClass {

    public List<Integer> bestSum(int target, int[] nums) {
        List<Integer>[] table = new List[target + 1];
        table[0] = new ArrayList<>();

        for (int i = 0; i <= target; i++) {
            if (table[i] != null) {
                for (int x : nums) {
                    int id = i + x;
                    if (id <= target) {
                        if (table[id] == null) {
                            table[id] = new ArrayList<>();
                            table[id].addAll(table[i]);
                            table[id].add(x);
                        } else {
                            List<Integer> newList = new ArrayList<>(table[i]);
                            newList.add(x);

                            if (newList.size() < table[id].size()) {
                                table[id] = newList;
                            }
                        }
                    }
                }
            }
        }

        return table[target];
    }


    public static void main(String[] args) {
        BestSumTab m = new BestSumTab();

        m.print(m.bestSum(7, new int[]{2, 3}));
        m.print(m.bestSum(7, new int[]{5, 3, 4, 7}));
        m.print(m.bestSum(7, new int[]{2, 4}));
        m.print(m.bestSum(8, new int[]{2, 3, 5}));
        m.print(m.bestSum(300, new int[]{7, 14}));
    }
}
