import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[1001][1001];
        
        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j < 10; ++j) {
                for (int k = 0; k < 10; ++k) {
                    board[w + j][h + k] = true;
                }
            }
        }
        
        int result = 0;
        
        for (int i = 0; i <= 1000; ++i) {
            for (int j = 0; j <= 1000; ++j) {
                if (board[i][j]) result++;
            }
        }
        
        System.out.println(result);
    }
}