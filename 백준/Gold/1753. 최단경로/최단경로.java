import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int to, cost;
    
    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
    
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    static int[] dist;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; ++i) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, cost));
        }
        
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        
        dijkstra(K);
        
        for (int i = 1; i <= N; ++i) {
            if (dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (dist[now.to] < now.cost) continue;
            
            for (Node next : graph[now.to]) {
                if (dist[next.to] > dist[now.to] + next.cost) {
                    dist[next.to] = dist[now.to] + next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
    }
}