/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private Comparator comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            // 0 is value, 1 is level
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        }
    };
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> orderMap = new HashMap<>();
        
        int[] orderId = new int[2]; // 0 = left; 1 = right
        dfs(orderMap, root, orderId, 0, 0);
        
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = orderId[0]; i <= orderId[1]; i++) {
            List<int[]> current = orderMap.get(i);
            Collections.sort(current, comparator);
            
            List<Integer> tmp = new ArrayList<>();
            for(int[] item : current) {
                tmp.add(item[0]);
            }
            answer.add(tmp);
        }
        
        return answer;
    }
    
    private void dfs(Map<Integer, List<int[]>> orderMap, TreeNode node, int[] orderId, int order, int level) {
        if(node != null) {
            orderId[0] = Math.min(orderId[0], order);
            orderId[1] = Math.max(orderId[1], order);
            
            if(!orderMap.containsKey(order)) {
                orderMap.put(order, new ArrayList<>());
            }
            orderMap.get(order).add(new int[] { node.val, level });
            dfs(orderMap, node.left, orderId, order - 1, level + 1);
            dfs(orderMap, node.right, orderId, order + 1, level + 1);
        }
    }
}