import java.io.*;
import java.util.*;

public class Main {
    public static int l;
    public static int[] dirY = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] dirX = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int fromY = Integer.parseInt(st.nextToken());
            int fromX = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int toY = Integer.parseInt(st.nextToken());
            int toX = Integer.parseInt(st.nextToken());
            
            int[][] dp = new int[l][l];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    dp[i][j] = 1_000_000_000;
                }
            }
            dp[fromY][fromX] = 0;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[] {fromY, fromX});
            
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int cy = cur[0];
                int cx = cur[1];
                
                for (int d = 0; d < 8; d++) {
                    int ny = cy + dirY[d];
                    int nx = cx + dirX[d];
                    
                    if (inRange(ny, nx) && dp[ny][nx] > dp[cy][cx] + 1) {
                        dp[ny][nx] = dp[cy][cx] + 1;
                        queue.add(new int[] {ny, nx});
                    }
                }
            }
            
            sb.append(dp[toY][toX]).append("\n");
        }
        System.out.println(sb);
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < l && x >= 0 && x < l;
    }
}