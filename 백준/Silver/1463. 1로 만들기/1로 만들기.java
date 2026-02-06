import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1_000_001];
        Arrays.fill(dp, 987654321);
        dp[1] = 0;
        
        for (int i = 1; i <= 999_999; i++) {
            if (i + 1 <= 1_000_000) dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            if (i * 2 <= 1_000_000) dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            if (i * 3 <= 1_000_000) dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
        }
        
        System.out.println(dp[N]);
    }
}