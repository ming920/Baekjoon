import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        
        int answer = 1;
        int lastPoint = routes[0][1];
        
        for (int i = 1; i < routes.length; i++) {
            if (lastPoint >= routes[i][0]) continue;
            else {
                lastPoint = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}