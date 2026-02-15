import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[] dirX = {1, 0, -1, 0};
    public static int[] dirY = {0, 1, 0, -1};
    public static int[][] board;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int cnt = 0, result = 0;
        while (cnt < 2) {
            result++;
            Queue<int[]> queue = new ArrayDeque<>();
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 0) queue.add(new int[] {i, j});
                }
            }
            
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int cy = cur[0], cx = cur[1];
                
                for (int d = 0; d < 4; d++) {
                    int ny = cy + dirY[d];
                    int nx = cx + dirX[d];
                    
                    if (inRange(ny, nx) && board[ny][nx] > 0) board[ny][nx] -= 1;
                }
            }
            
            cnt = 0;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] != 0 && !visited[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }
            
            if (cnt == 0) {
                System.out.println(0);
                return;
            }
        }
        
        System.out.println(result);
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
    
    public static void bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {y, x});
        visited[y][x] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1];
            
            for (int d = 0; d < 4; d++) {
                int ny = cy + dirY[d];
                int nx = cx + dirX[d];
                
                if (inRange(ny, nx) && board[ny][nx] > 0 && !visited[ny][nx]) {
                    queue.add(new int[] {ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }
}