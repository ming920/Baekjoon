import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, answer = 0;
    public static char[][] board;
    public static int[] dirY = {1, -1, 0, 0};
    public static int[] dirX = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
        
        System.out.println(answer);
    }
    
    public static void bfs(int sy, int sx) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];
        queue.add(new int[] {sy, sx});
        visited[sy][sx] = true;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int ny = now[0] + dirY[d];
                int nx = now[1] + dirX[d];
                
                if (inRange(ny, nx) && !visited[ny][nx] && board[ny][nx] == 'L') {
                    queue.add(new int[] {ny, nx});
                    visited[ny][nx] = true;
                    dist[ny][nx] = dist[now[0]][now[1]] + 1; 
                }
            }
        }
        
        int maxDist = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDist = Math.max(maxDist, dist[i][j]);
            }
        }
        
        answer = Math.max(answer, maxDist);
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}