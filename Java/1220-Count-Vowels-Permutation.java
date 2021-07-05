/**
 * https://leetcode.com/problems/count-vowels-permutation/
 */ 
class Solution {
    
    private static final String[] combinations = {
        "e",
        "ai",
        "aeou",
        "iu",
        "a"
    };
    
    private static final int MOD = 1000000007;
    
    public int countVowelPermutation(int n) {
        int[][] dp = new int[n+1][5];
        int a = helper(n, 0, dp);
        int e = helper(n, 1, dp);
        int i = helper(n, 2, dp);
        int o = helper(n, 3, dp);
        int u = helper(n, 4, dp);
        
        int sumAE = sum(a, e);
        int sumIO = sum(i, o);
        
        int sumAEIO = sum(sumAE, sumIO);
        
        return sum(sumAEIO, u);
        
    }
    
    private int helper(int n, int id, int[][] dp) {
        if(dp[n][id] > 0) {
            return dp[n][id] % MOD;
        }
        
        if(n == 1)
            return 1;
        
        int count = 0;
        String combs = combinations[id];
        
        for(char c : combs.toCharArray()) {
            int tmp = sum(count, helper(n - 1, getId(c), dp));
            count = tmp;
        }
                
        dp[n][id] = count;
        return dp[n][id];
    }
    
    private int sum(int a, int b) {
        return (a % MOD + b % MOD) % MOD;
    }
    
    private int getId(char c) {
        if(c == 'a')
            return 0;
        if(c == 'e')
            return 1;
        if(c == 'i')
            return 2;
        if(c == 'o')
            return 3;
        return 4;
    }
    
}