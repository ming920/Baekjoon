import java.io.*;
import java.util.*;

public class Main {
    
    public static int N, M, K, answer = Integer.MIN_VALUE;
    public static int[] dirY = {0, 1, 0, -1};
    public static int[] dirX = {1, 0, -1, 0};
    public static int[][] board;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[N][M];
        backtracking(0, 0);
        
        System.out.println(answer);
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
    
    public static void backtracking(int depth, int sum) {
        if (depth == K) {
            answer = Math.max(answer, sum);
            return;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && canPick(i, j)) {
                    visited[i][j] = true;
                    backtracking(depth + 1, sum + board[i][j]);
                    visited[i][j] = false;
                }
            }
        }
    }
    
    public static boolean canPick(int y, int x) {
        for (int d = 0; d < 4; d++) {
            int ny = y + dirY[d];
            int nx = x + dirX[d];
            
            if (inRange(ny, nx) && visited[ny][nx]) return false;
        }
        
        return true;
    }
}