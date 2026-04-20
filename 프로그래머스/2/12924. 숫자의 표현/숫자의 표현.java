class Solution {
    public int solution(int n) {
        long[] dp = new long[10_001];
        
        for (int i = 1; i <= 10_000; i++) {
            dp[i] = i;
        }
        
        for (int i = 1; i <= 10_000; i++) {
            dp[i] += dp[i - 1];
        }
        
        int answer = 0;
        int left = 0, right = 1;
        
        while (left < right) {
            if (dp[right] - dp[left] == n) {
                answer++;
                right++;
                left++;
            } else if (dp[right] - dp[left] < n) {
                right++;
            } else left++;
        }
        
        return answer;
    }
}