import java.util.LinkedList;
import java.util.Queue;

public class CreateBSTFromSortedInputJava {

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(final int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}' +
                    "";
        }
    }

    public TreeNode createBST(final int[] input) {
        return createBST(input, 0, input.length - 1);
    }

    private TreeNode createBST(final int[] input, final int lo, final int hi) {
        if (lo > hi)
            return null;
        final int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(input[mid]);
        node.left = createBST(input, lo, mid - 1);
        node.right = createBST(input, mid + 1, hi);
        return node;
    }

    public static void main(String[] args) {
        CreateBSTFromSortedInputJava m = new CreateBSTFromSortedInputJava();
        TreeNode ans1 = m.createBST(new int[]{1, 3, 5, 7, 9});
        System.out.println(ans1);

        TreeNode ans2 = m.createBST(new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println(ans2);

        TreeNode ans3 = m.createBST(new int[]{});
        System.out.println(ans3);

        TreeNode ans4 = m.createBST(new int[]{10});
        System.out.println(ans4);
    }
}
