import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        
        for (int n = 1; n <= N; n++) {
            for (int k = 1; k < n; k++) {
                dp[n][k] = (dp[n - 1][k - 1] + dp[n - 1][k]) % 10007;
            }
        }
        
        System.out.println(dp[N][K] % 10007);
    }
}