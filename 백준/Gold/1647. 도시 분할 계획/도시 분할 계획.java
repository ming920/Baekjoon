import java.io.*;
import java.util.*;

public class Main {
    public static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;
        
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge other) {
            if (this.cost == other.cost) {
                return Integer.compare(this.from, other.from);
            }
            return Integer.compare(this.cost, other.cost);
        }
    }
    
    public static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Edge> edge = new ArrayList<>();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (a < b) edge.add(new Edge(a, b, c));
            else edge.add(new Edge(b, a, c));
        }
        
        Collections.sort(edge);
        List<Integer> result = new ArrayList<>();
        
        for (Edge e : edge) {
            int x = e.from;
            int y = e.to;
            int c = e.cost;
            
            if (union(x, y)) {
                result.add(c);
            }
        }
        
        int sum = 0;
        for (int i = 0; i < result.size() - 1; i++) {
            sum += result.get(i);
        }
        
        System.out.println(sum);
    }
    
    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return false;
        
        if (x < y) parent[y] = x;
        else parent[x] = y;
        return true;
    }
    
    public static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
}