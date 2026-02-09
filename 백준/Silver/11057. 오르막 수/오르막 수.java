import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[N + 1][10];
        
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10_007;
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[N][i]) % 10_007;
        }
        
        System.out.println(result);
    }
}