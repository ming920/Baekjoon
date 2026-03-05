import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    queue.add(next);
                }
            }
        }
        
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (maxDist == dist[i]) answer++;
        }
        return answer;
    }
}