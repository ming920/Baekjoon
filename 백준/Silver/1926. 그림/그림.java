import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dirY = {0, 1, 0, -1};
    static int[] dirX = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        
        board = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        
        int count = 0;
        int maxArea = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    count++;
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }
        
        System.out.println(count);
        System.out.println(maxArea);
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
    
    public static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {y, x});
        visited[y][x] = true;
        int area = 1;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int d = 0; d < 4; ++d) {
                int nextY = now[0] + dirY[d];
                int nextX = now[1] + dirX[d];
                
                if (inRange(nextY, nextX) && board[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    queue.add(new int[] {nextY, nextX});
                    visited[nextY][nextX] = true;
                    area++;
                }
            }
        }
        
        return area;
    }
}