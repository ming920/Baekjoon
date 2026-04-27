import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
    
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[] times = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] indegree = new int[N + 1];
            List<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                indegree[to]++;
            }
            
            
            Queue<Integer> queue = new ArrayDeque<>();
            int[] result = new int[N + 1];
            
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                    result[i] = times[i];
                }
            }
            
            while (!queue.isEmpty()) {
                int now = queue.poll();
                
                for (int next : graph[now]) {
                    result[next] = Math.max(result[next], result[now] + times[next]);
                    indegree[next]--;
                    
                    if (indegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
            
            int W = Integer.parseInt(br.readLine());
            sb.append(result[W]).append("\n");
        }
        
        System.out.println(sb);
    }
}