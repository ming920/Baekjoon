import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] indegree = new int[N + 1];
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            
            graph[from].add(to);
            indegree[to]++;
        }
        
        int[] answer = new int[N];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int index = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            answer[index] = now;
            index++;
            
            for (int next : graph[now]) {
                indegree[next]--;
                
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num).append(" ");
        }
        
        System.out.println(sb);
    }
}