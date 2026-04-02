import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node>{
        int to;
        int weight;
        
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
    
    public static int[] dist;
    public static List<Node>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, 1_000_000_000);
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int K = Integer.parseInt(br.readLine());
        dist[K] = 0;
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph[u].add(new Node(v, w));
        }
        
        dijkstra(K);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == 1_000_000_000) {
                sb.append("INF\n");
            } else sb.append(dist[i]).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (now.weight > dist[now.to]) continue;
            
            for (Node next : graph[now.to]) {
                if (dist[next.to] > dist[now.to] + next.weight) {
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }
}