/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) {
            return answer;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graphGeneration(graph, root);
        
        int level = 0;
        while(graph.containsKey(level)) {
            answer.add(graph.get(level++));
        }
        
        return answer;
    }
    
    private int graphGeneration(
        Map<Integer, List<Integer>> graph,
        TreeNode node
    ) {
        if(node == null) {
            return 0;
        }
        int left = graphGeneration(graph, node.left);
        int right = graphGeneration(graph, node.right);

        int max = Math.max(left, right);
        if(!graph.containsKey(max)) {
            graph.put(max, new ArrayList<>());
        }
        graph.get(max).add(node.val);
        
        return max + 1;
    }

}