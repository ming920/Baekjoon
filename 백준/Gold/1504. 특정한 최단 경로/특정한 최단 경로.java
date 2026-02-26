import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
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
    
    public static int N;
    public static List<Node>[] graph;
    public static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        int[] d1 = new int[N + 1];
        int[] dv1 = new int[N + 1];
        int[] dv2 = new int[N + 1];
        
        dijkstra(1, d1);
        dijkstra(v1, dv1);
        dijkstra(v2, dv2);
        
        int result = Integer.MAX_VALUE;
        result = Math.min(result, d1[v1] + dv1[v2] + dv2[N]);
        result = Math.min(result, d1[v2] + dv2[v1] + dv1[N]);
        
        if (result >= 500_000_000) System.out.println(-1);
        else System.out.println(result);
	}
	
	public static void dijkstra(int start, int[] dist) {
	    PriorityQueue<Node> pq = new PriorityQueue<>();
	    for (int i = 1; i <= N; i++) {
	        dist[i] = 500_000_000;
	    }
	    dist[start] = 0;
	    visited = new boolean[N + 1];
	    pq.add(new Node(start, 0));
	    
	    while (!pq.isEmpty()) {
	        Node now = pq.poll();
	        
	        if (visited[now.to]) continue;
	        visited[now.to] = true;
	        
	        for (Node next : graph[now.to]) {
	            if (dist[next.to] > dist[now.to] + next.weight) {
	                dist[next.to] = dist[now.to] + next.weight;
	                pq.add(new Node(next.to, dist[next.to]));
	            }
	        }
	    }
	}
}