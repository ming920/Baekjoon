import java.io.*;
import java.util.*;

public class Main {
    public static int[] dirY = {0, 1, 0, -1};
    public static int[] dirX = {1, 0, -1, 0};
    public static int[][] board = new int[5][5];
    public static Set<Integer> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(0, 0, i, j);
            }
        }
        
        System.out.println(set.size());
    }
    
    public static void dfs(int depth, int num, int sy, int sx) {
        if (depth == 6) {
            set.add(num);
            return;
        }
        
        for (int d = 0; d < 4; d++) {
            int ny = sy + dirY[d];
            int nx = sx + dirX[d];
            if (inRange(ny, nx)) {
                dfs(depth + 1, num * 10 + board[ny][nx], ny, nx);
            }
        }
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < 5 && x >= 0 && x < 5;
    }
}