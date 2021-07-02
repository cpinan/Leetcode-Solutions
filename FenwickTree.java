public class FenwickTree {

    private int n;
    private int[] tree;
    private int[] input;

    public FenwickTree(int[] input) {
        this.n = input.length;
        this.input = input;

        this.tree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = input[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int p = i + (i & -i);
            if (p <= n) {
                tree[p] = tree[p] + tree[i];
            }
        }
    }

    public void update(int index, int value) {
        int diff = value - input[index];
        input[index] = value;
        index++;

        while (index <= n) {
            tree[index] += diff;
            index += (index & -index);
        }
    }

    public int sum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= (index & -index);
        }
        return sum;
    }

    public int sumRange(int left, int right) {
        return sum(right + 1) - sum(left);
    }

    public static void main(String[] args) {

    }
}
