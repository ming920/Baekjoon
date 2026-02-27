import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int to;
        int weight;
        
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    public static int startNode = 0, result = 0;
    public static List<Node>[] graph;
    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N == 1) {
            System.out.println(0);
            return;
        }
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        
        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1, 0);
        
        visited = new boolean[N + 1];
        result = 0;
        visited[startNode] = true;
        dfs(startNode, 0);
        
        System.out.println(result);
    }
    
    public static void dfs(int start, int weight) {
        if (weight > result) {
            startNode = start;
            result = weight;
        }
        
        for (Node next : graph[start]) {
            if (!visited[next.to]) {
                visited[next.to] = true;
                dfs(next.to, weight + next.weight);
                visited[next.to] = false;
            }
        }
    }
}