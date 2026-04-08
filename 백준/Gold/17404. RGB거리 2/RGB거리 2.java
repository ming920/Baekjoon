import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] houses = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int first = 0; first < 3; first++) {
            int[][] dp = new int[N + 1][3];
            
            for (int i = 0; i < 3; i++) dp[1][i] = 1_000_000_000;
            dp[1][first] = houses[1][first];
            
            for (int i = 2; i <= N - 1; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + houses[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + houses[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + houses[i][2];
            }
            
            if (first == 0) {
                answer = Math.min(answer, dp[N - 1][0] + Math.min(houses[N][1], houses[N][2]));
                answer = Math.min(answer, dp[N - 1][1] + houses[N][2]);
                answer = Math.min(answer, dp[N - 1][2] + houses[N][1]);
            } else if (first == 1) {
                answer = Math.min(answer, dp[N - 1][1] + Math.min(houses[N][0], houses[N][2]));
                answer = Math.min(answer, dp[N - 1][0] + houses[N][2]);
                answer = Math.min(answer, dp[N - 1][2] + houses[N][0]);
            } else {
                answer = Math.min(answer, dp[N - 1][2] + Math.min(houses[N][0], houses[N][1]));
                answer = Math.min(answer, dp[N - 1][0] + houses[N][1]);
                answer = Math.min(answer, dp[N - 1][1] + houses[N][0]);
            }
        }
        
        System.out.println(answer);
    }
}