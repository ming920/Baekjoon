import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N + 1];
        int[] arr = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= N; i++) {
            if (dp[i - 1] + arr[i] > arr[i]) {
                dp[i] = dp[i - 1] + arr[i];
            } else {
                dp[i] = arr[i];
            }
        }
        
        int result = -Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dp[i]);
        }
        
        System.out.println(result);
    }
}