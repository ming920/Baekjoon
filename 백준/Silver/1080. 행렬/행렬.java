import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static boolean[][] board1, board2;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board1 = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) - '0' == 1) board1[i][j] = true;
            }
        }
        
        board2 = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) - '0' == 1) board2[i][j] = true;
            }
        }
        
        int result = 0;
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (board1[i][j] != board2[i][j]) {
                    reverse(i, j);
                    result++;
                }
            }
        }
        
        if (match()) System.out.println(result);
        else System.out.println("-1");
    }
    
    public static void reverse(int sy, int sx) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board1[sy + i][sx + j] = !board1[sy + i][sx + j];
            }
        }
    }
    
    public static boolean match() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board1[i][j] != board2[i][j]) return false;
            }
        }
        
        return true;
    }
}