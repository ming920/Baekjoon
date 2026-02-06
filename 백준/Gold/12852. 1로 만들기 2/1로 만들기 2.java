import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N + 1];
        
        Arrays.fill(dp, 987654321);
        dp[N] = 0;
        
        for (int i = N; i > 0; i--) {
            if (i % 3 == 0) {
                dp[i / 3] = Math.min(dp[i / 3], dp[i] + 1);
            }
            
            if (i % 2 == 0) {
                dp[i / 2] = Math.min(dp[i / 2], dp[i] + 1);
            }
            
            dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
        }
        
        Deque<Integer> deque = new ArrayDeque<>();
        int num = 1;
        deque.addFirst(num);
        
        while (num != N) {
            if (num * 3 <= N && dp[num * 3] == dp[num] - 1) {
                num *= 3;
                deque.addFirst(num);
            }
            
            if (num * 2 <= N && dp[num * 2] == dp[num] - 1) {
                num *= 2;
                deque.addFirst(num);
            }
            
            if (num + 1 <= N && dp[num + 1] == dp[num] - 1) {
                num += 1;
                deque.addFirst(num);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(dp[1]).append("\n");
        for (Integer n : deque) {
            sb.append(n).append(" ");
        }
        
        System.out.print(sb);
    }
}