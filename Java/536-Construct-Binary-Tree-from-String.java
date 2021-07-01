/**
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
    public TreeNode str2tree(String s) {
        return insert(s);
    }
    
    private TreeNode insert(String s) {
        if(s == null || s.length() == 0) {
            return null;
        }
        int start = 0;
        char first = s.charAt(0);
        int sign = 1;
        if(first == '-') {
            start++;
            sign = -1;
        }

        int value = 0;
        while(start < s.length() && s.charAt(start) != '(') {
            value = value * 10 + ((s.charAt(start) - '0'));
            start++;
        }
        
        TreeNode root = new TreeNode(value * sign);
        
        int leftStart = start;
        int leftEnd = parseString(s, leftStart);
        
        if(leftEnd != -1) {
            root.left = insert(s.substring(leftStart + 1, leftEnd));
            
            int rightStart = leftEnd + 1;
            int rightEnd = parseString(s, rightStart);
            
            if(rightEnd != -1) {
                root.right = insert(s.substring(rightStart + 1, rightEnd));
            }
        }
        
        return root;
    }
    
    private int parseString(String s, int start) {
        int count = 1;
        int index = -1;
        for(int i = start + 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')') {
                count --;
            } else if(c == '(') {
                count++;
            }
            if(count == 0) {
                return i;
            }
        }
        return -1;
    }
}