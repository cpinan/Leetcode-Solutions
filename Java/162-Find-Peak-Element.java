/**
 * https://leetcode.com/problems/find-peak-element/
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = 0;
        while(l < r) {
            int m = l + (r-l) / 2;
            if(nums[m] < nums[m+1]) {
                l = m + 1;
                ans = l;
            } else {
                r = m;
            }
        }
        return ans;
    }
}
