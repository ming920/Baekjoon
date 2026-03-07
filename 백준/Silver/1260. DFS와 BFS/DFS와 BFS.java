import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer>[] graph;
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph[v].add(w);
            graph[w].add(v);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        visited = new boolean[N + 1];
        dfs(V);
        
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);
        
        System.out.println(sb);
    }
    
    public static void dfs(int now) {
        sb.append(now).append(" ");
        visited[now] = true;
        
        for (int next : graph[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
    public static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}