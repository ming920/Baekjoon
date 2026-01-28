import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] dirY = {-1, 0, 1, 0};
    public static int[] dirX = {0, -1, 0, 1};
    public static int[][] board;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    results.add(bfs(i, j));
                }
            }
        }
        
        Collections.sort(results);
        System.out.println(results.size());
        for (Integer result : results) {
            System.out.println(result);
        }
    }
    
    public static int bfs(int sy, int sx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sy, sx});
        visited[sy][sx] = true;
        int result = 0;
        
        while (!queue.isEmpty()) {
            result++;
            int[] cur = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int ny = cur[0] + dirY[d];
                int nx = cur[1] + dirX[d];
                
                if (inRange(ny, nx) && board[ny][nx] == 1 && !visited[ny][nx]) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
        
        return result;
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}