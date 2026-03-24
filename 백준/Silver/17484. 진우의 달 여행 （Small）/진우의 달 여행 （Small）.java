import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, result = Integer.MAX_VALUE;
    public static int[][] board;
    public static int[] dirX = {-1, 0, 1};
    public static int[] dirY = {1, 1, 1};
    
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
        
        for (int i = 0; i < M; i++) {
            dfs(board[0][i], -1, 0, i);
        }
        
        System.out.println(result);
    }
    
    public static void dfs(int score, int prevDir, int sy, int sx) {
        if (sy == N - 1) {
            result = Math.min(result, score);
            return;
        }
        
        for (int d = 0; d < 3; d++) {
            if (d == prevDir) continue;
            
            int ny = sy + dirY[d];
            int nx = sx + dirX[d];
            
            if (inRange(ny, nx)) {
                dfs(score + board[ny][nx], d, ny, nx);
            }
        }
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}