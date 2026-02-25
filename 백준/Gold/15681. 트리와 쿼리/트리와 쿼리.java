import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer> graph[];
    public static List<Integer> child[];
    public static int[] size;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N + 1];
        child = new ArrayList[N + 1];
        size = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            child[i] = new ArrayList<>();
            size[i] = 1;
        }
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        
        makeTree(R, 0);
        count(R);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(size[q]).append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static void makeTree(int currentNode, int parentNode) {
        for (int num : graph[currentNode]) {
            if (num != parentNode) {
                child[currentNode].add(num);
                makeTree(num, currentNode);
            }
        }
    }
    
    public static void count(int currentNode) {
        for (int num : child[currentNode]) {
            count(num);
            size[currentNode] += size[num];
        }
    }
}