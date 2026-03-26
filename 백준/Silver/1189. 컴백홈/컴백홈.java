import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, K, result = 0;
    public static char[][] board;
    public static boolean[][] visited;
    public static int[] dirY = {0, 1, 0, -1};
    public static int[] dirX = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        board = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        visited[N - 1][0] = true;
        dfs(N - 1, 0, 1);
        System.out.println(result);
    }
    
    public static void dfs(int sy, int sx, int depth) {
        if (depth > K) return;
        
        if (sy == 0 && sx == M - 1) {
            if (depth == K) result++;
            return;
        }
        
        for (int d = 0; d < 4; d++) {
            int ny = sy + dirY[d];
            int nx = sx + dirX[d];
            
            if (inRange(ny, nx) && !visited[ny][nx] && board[ny][nx] == '.') {
                visited[ny][nx] = true;
                dfs(ny, nx, depth + 1);
                visited[ny][nx] = false;
            }
        }
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}