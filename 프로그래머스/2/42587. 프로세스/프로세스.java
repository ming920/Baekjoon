class Solution {
    public int solution(int[] priorities, int location) {
        int N = priorities.length;
        int cnt = 0, i = 0;

        while (i < N) {
            int max = 0;
            
            for (int j = 0; j < N; j++) {
                max = Math.max(max, priorities[j]);
            }
            
            if (max == priorities[i]) {
                cnt++;
                priorities[i] = 0;
                    
                if (i == location) break;
            }
            
            i = i == N - 1 ? 0 : i + 1;
        }
        
        return cnt;
    }
}