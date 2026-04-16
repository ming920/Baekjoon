import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder[] command;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            command = new StringBuilder[10000];
            for (int i = 0; i < 10000; i++) {
                command[i] = new StringBuilder();
            }
            
            bfs(A);
            sb.append(command[B].toString()).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void bfs(int A) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];
        queue.add(A);
        visited[A] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            int next = (cur * 2) % 10000;
            if (!visited[next]) {
                command[next].append(command[cur]).append("D");
                queue.add(next);
                visited[next] = true;
            }
            
            next = (cur == 0) ? 9999 : cur - 1;
            if (!visited[next]) {
                command[next].append(command[cur]).append("S");
                queue.add(next);
                visited[next] = true;
            }
            
            next = (cur % 1000) * 10 + (cur / 1000);
            if (!visited[next]) {
                command[next].append(command[cur]).append("L");
                queue.add(next);
                visited[next] = true;
            }
            
            next = (cur % 10) * 1000 + (cur / 10);
            if (!visited[next]) {
                command[next].append(command[cur]).append("R");
                queue.add(next);
                visited[next] = true;
            }
        }
    }
}