import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] days, costs, dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        days = new int[N + 1];
        costs = new int[N + 1];
        dp = new int[N + 2];
        
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = N; i > 0; --i) {
            dp[i] = dp[i + 1];
            
            if (i + days[i] <= N + 1) {
                dp[i] = Math.max(dp[i], costs[i] + dp[i + days[i]]);
            }
        }
        
        System.out.println(dp[1]);
    }
}