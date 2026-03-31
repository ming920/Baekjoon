import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        int sd = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] dirY = {-1, 0, 1, 0};
        int[] dirX = {0, 1, 0, -1};
        boolean[][] visited = new boolean[N][M];
        int result = 0;
        
        while (true) {
            if (!visited[sy][sx]) {
                visited[sy][sx] = true;
                result++;
            }
            
            boolean cleaned = true;
            for (int d = 0; d < 4; d++) {
                int ny = sy + dirY[d];
                int nx = sx + dirX[d];
                
                if (inRange(ny, nx) && board[ny][nx] == 0 && !visited[ny][nx]) {
                    cleaned = false;
                }
            }
            
            if (cleaned) {
                int d = (sd + 2) % 4;
                int ny = sy + dirY[d];
                int nx = sx + dirX[d];
                
                if (inRange(ny, nx) && board[ny][nx] == 0) {
                    sy = ny;
                    sx = nx;
                } else if (inRange(ny, nx) && board[ny][nx] == 1) {
                    System.out.println(result);
                    return;
                }
            } else {
                sd = sd == 0 ? 3 : sd - 1;
                int ny = sy + dirY[sd];
                int nx = sx + dirX[sd];
                
                if (inRange(ny, nx) && board[ny][nx] == 0 && !visited[ny][nx]) {
                    sy = ny;
                    sx = nx;
                }
            }
        }
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}