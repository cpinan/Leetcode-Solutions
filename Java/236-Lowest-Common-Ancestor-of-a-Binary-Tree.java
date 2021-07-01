/**
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private Map<TreeNode, TreeNode> hierarchy;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        hierarchy = new HashMap<>();
        dfs(root, null);
        
        Set<TreeNode> pHierarchy = new HashSet<>();
        while(p != null) {
            pHierarchy.add(p);
            p = hierarchy.get(p);
        }
                
        while(!pHierarchy.contains(q)) {
            q = hierarchy.get(q);
        }
        
        return q;
    }
    
    private void dfs(TreeNode node, TreeNode parent) {
        if(node != null) {
            dfs(node.left, node);
            dfs(node.right, node);
            hierarchy.put(node, parent);
        }
    }
}