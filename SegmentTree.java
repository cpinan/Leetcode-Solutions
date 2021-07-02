import java.util.Arrays;

public class SegmentTree {

    private int n;
    private int[] tree;

    public SegmentTree(int[] input) {
        this.n = input.length;
        this.tree = new int[n * 2];

        for (int i = tree.length - 1; i >= n; i--) {
            tree[i] = input[i - n];
        }

        for (int i = n - 1; i > 0; i--) {
            tree[i] = Math.max(tree[i * 2], tree[i * 2 + 1]);
        }

        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(tree));
        System.out.println();
    }

    public void update(int index, int value) {
        index += n;
        tree[index] = value;

        while (index > 1) {
            index /= 2;
            tree[index] = Math.max(tree[index * 2], tree[index * 2 + 1]);
        }

        System.out.println(Arrays.toString(tree));
    }

    public int max(int from, int to) {
        from += n;
        to += (n + 1);

        int max = Integer.MIN_VALUE;
        while (from < to) {
            if ((from & 1) == 1) {
                max = Math.max(max, tree[from]);
                from++;
            }
            if ((to & 1) == 1) {
                to--;
                max = Math.max(max, tree[to]);
            }
            from /= 2;
            to /= 2;
        }
        return max;
    }

    public static void main(String[] args) {
        SegmentTree s1 = new SegmentTree(new int[]{6, 10, 5, 2, 7, 1, 5, 9});
        // s1.update(7, 50);
        System.out.println(s1.max(4, 4));
        System.out.println(s1.max(5, 5));
        System.out.println(s1.max(5, 6));
        // System.out.println(s1.max(0, 3));
        //SegmentTree s2 = new SegmentTree(new int[]{6, 10, 5, 2, 7, 1, 0, 9});
    }
}
