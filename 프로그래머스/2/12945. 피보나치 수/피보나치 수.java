class Solution {
    public int solution(int n) {
        int[] dp = new int[100_001];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= 100_000; i++) {
            dp[i] = ((dp[i - 2] % 1234567) + (dp[i - 1] % 1234567)) % 1234567;
        }

        return dp[n];
    }
}