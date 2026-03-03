class Solution {
    int N, answer = 0;
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    public void dfs(int start, int sum, int[] numbers, int target) {
        if (start == N) {
            if (sum == target) answer++;
            return;
        }
        
        dfs(start + 1, sum + numbers[start], numbers, target);
        dfs(start + 1, sum - numbers[start], numbers, target);
    }
}