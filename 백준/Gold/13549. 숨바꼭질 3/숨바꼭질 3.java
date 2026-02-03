import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        dp = new int[100_001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        bfs(N);
        
        System.out.println(dp[K]);
    }
    
    public static void bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(start);
        dp[N] = 0;
        
        while (!deque.isEmpty()) {
            int now = deque.poll();
            
            if (now * 2 <= 100_000 && dp[now * 2] > dp[now]) {
                deque.addFirst(now * 2);
                dp[now * 2] = dp[now];
            }
            
            if (now - 1 >= 0 && dp[now - 1] > dp[now] + 1) {
                deque.addLast(now - 1);
                dp[now - 1] = dp[now] + 1;
            }
            
            if (now + 1 <= 100_000 && dp[now + 1] > dp[now] + 1) {
                deque.addLast(now + 1);
                dp[now + 1] = dp[now] + 1;
            }
        }
    }
}