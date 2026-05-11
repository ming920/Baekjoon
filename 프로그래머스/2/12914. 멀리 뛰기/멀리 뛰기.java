class Solution {
    public long solution(int n) {
        if (n < 3) {
            return n;
        }
        
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        
        return dp[n];
    }
}