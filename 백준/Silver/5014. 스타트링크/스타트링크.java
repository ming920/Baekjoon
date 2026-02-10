import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[F + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[S] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(S);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            if (cur + U <= F && dp[cur + U] > dp[cur] + 1) {
                dp[cur + U] = dp[cur] + 1;
                queue.add(cur + U);
            }
            
            if (cur - D >= 1 && dp[cur - D] > dp[cur] + 1) {
                dp[cur - D] = dp[cur] + 1;
                queue.add(cur - D);
            }
        }
        
        if (dp[G] == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
            return;
        } else {
            System.out.println(dp[G]);
        }
    }
}