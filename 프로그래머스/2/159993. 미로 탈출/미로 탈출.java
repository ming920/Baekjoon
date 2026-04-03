import java.util.*;

class Solution {
    public static int N, M;
    public static char[][] board;
    public static int[][] dist;
    public static int[] dirY = {1, -1, 0, 0};
    public static int[] dirX = {0, 0, 1, -1};
     
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        board = new char[N][M];
        int sy = 0, sx = 0, ly = 0, lx = 0, ey = 0, ex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = maps[i].charAt(j);
                
                if (board[i][j] == 'S') {
                    sy = i;
                    sx = j;
                } else if (board[i][j] == 'L') {
                    ly = i;
                    lx = j;
                } else if (board[i][j] == 'E') {
                    ey = i;
                    ex = j;
                }
            }
        }
        
        dist = new int[N][M];
        bfs(sy, sx, ly, lx);
        if (dist[ly][lx] == 0) return -1;
        
        bfs(ly, lx, ey, ex);
        if (dist[ey][ex] == 0) return -1;
        
        return dist[ey][ex];
    }
    
    public static void bfs(int sy, int sx, int ey, int ex) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        visited[sy][sx] = true;
        queue.add(new int[] {sy, sx});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == ey && cur[1] == ex) break;
            
            for (int d = 0; d < 4; d++) {
                int ny = cur[0] + dirY[d];
                int nx = cur[1] + dirX[d];
                
                if (inRange(ny, nx) && !visited[ny][nx] && board[ny][nx] != 'X') {
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny, nx});
                    dist[ny][nx] = dist[cur[0]][cur[1]] + 1;
                }
            }
        }
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}