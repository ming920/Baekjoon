import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int minSum = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i <= N; i++) {
            int[] depth = new int[N + 1];
            boolean[] visited = new boolean[N + 1];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            visited[i] = true;
            
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                
                for (int next : graph[cur]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                        depth[next] = depth[cur] + 1;
                    }
                }
            }
            
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += depth[j];
            }
            
            if (minSum > sum) {
                minSum = sum;
                result = i;
            }
        }
        
        System.out.println(result);
    }
}