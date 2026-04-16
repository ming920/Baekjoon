import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, answer = Integer.MAX_VALUE;
    public static int[] dist = new int[101];
    public static int[] shortcut = new int[101];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= 100; i++) {
            shortcut[i] = i;
            dist[i] = -1;
        }
        
        dist[1] = 0;
        
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            shortcut[u] = v;
        }
        
        bfs();
        System.out.println(dist[100]);
    }
    
    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int dice = 1; dice <= 6; dice++) {
                int nx = cur + dice;
                if (nx > 100) continue;
                
                nx = shortcut[nx];
                
                if (dist[nx] == -1) {
                    queue.add(nx);
                    dist[nx] = dist[cur] + 1;
                }
            }
        }
    }
}