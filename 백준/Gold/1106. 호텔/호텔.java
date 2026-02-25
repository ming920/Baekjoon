import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[C + 101];
        int[] person = new int[N];
        int[] cost = new int[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            person[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.fill(dp, 987654321);
        dp[0] = 0;
        
        for (int i = 0; i <= C + 100; i++) {
            for (int j = 0; j < N; j++) {
                if (i - person[j] >= 0 && dp[i] > dp[i - person[j]] + cost[j]) {
                    dp[i] = dp[i - person[j]] + cost[j];
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = C; i <= C + 100; i++) {
            result = Math.min(result, dp[i]);
        }
        
        System.out.println(result);
    }
}