import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }
        
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new ArrayDeque<>();
            
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    
                    for (int next : graph[now]) {
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.add(next);
                        }
                    }
                }
                answer++;
            }
        }
        
        return answer;
    }
}