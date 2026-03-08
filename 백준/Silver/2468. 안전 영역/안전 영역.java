import java.io.*;
import java.util.*;

public class Main {
    
    public static int N, answer = 0;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] dirY = {1, 0, -1, 0};
    public static int[] dirX = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, board[i][j]);
                max = Math.max(max, board[i][j]);
            }
        }
        
        for (int h = 0; h <= 100; h++) {
            int cnt = 0;
            visited = new boolean[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && board[i][j] > h) {
                        bfs(i, j, h);
                        cnt++;
                    }
                }
            }
            
            answer = Math.max(answer, cnt);
        }
        
        System.out.println(answer);
    }
    
    public static void bfs(int sy, int sx, int height) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sy, sx});
        visited[sy][sx] = true;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int ny = now[0] + dirY[d];
                int nx = now[1] + dirX[d];
                
                if (inRange(ny, nx) && !visited[ny][nx] && board[ny][nx] > height) {
                    queue.add(new int[] {ny, nx});
                    visited[ny][nx] = true; 
                }
            }
        }
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}