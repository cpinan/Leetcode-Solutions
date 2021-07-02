/**
 * https://leetcode.com/problems/max-consecutive-ones-ii/
 */
class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int lo = -1;
        int last = 0;        
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if(x == 0) {
                last = lo + 1;
                lo = i;
            }
            ans = Math.max(ans, i - last + 1);
        }
        return ans;
    }

}

