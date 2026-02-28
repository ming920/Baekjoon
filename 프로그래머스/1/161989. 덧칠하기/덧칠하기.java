import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] painted = new boolean[n];
        Arrays.fill(painted, true);
        
        for (int sec : section) {
            painted[sec - 1] = false;
        }
        
        int answer = 0;
        for (int sec : section) {
            if (!painted[sec - 1]) {
                answer++;
                for (int i = 0; i < m; i++) {
                    painted[Math.min(sec - 1 + i, n - 1)] = true;
                }
            }
        }
        
        return answer;
    }
}