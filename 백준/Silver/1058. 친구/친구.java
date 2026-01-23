import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] friends;
    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        friends = new int[N][N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            
            for (int j = 0; j < N; j++) {
                char ch = line.charAt(j);
                
                if (ch == 'Y') friends[i][j] = 1;
            }
        }
        
        int result = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[j] = false;
            }
            result = Math.max(result, bfs(i));
        }
        
        System.out.println(result);
    }
    
    public static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start] = true;
        
        for (int i = 0; i < N; i++) {
            if (friends[start][i] == 1 && !visited[i]) {
                visited[i] = true;
                queue.add(new int[]{i, 1});
            }
        }
        
        int result = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int depth = cur[1];
            
            if (depth > 2) continue;
            
            result++;
            
            for (int i = 0; i < N; i++) {
                if (friends[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i, depth + 1});
                }
            }
        }
        
        return result;
    }
}