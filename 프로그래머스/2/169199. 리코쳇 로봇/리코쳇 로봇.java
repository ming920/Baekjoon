import java.util.*;

class Solution {
    public static int N, M;
    public static char[][] map;
    public static int[][] dist;
    public static int[] dirY = {-1, 0, 1, 0};
    public static int[] dirX = {0, 1, 0, -1};
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        
        map = new char[N][M];
        int sy = 0, sx = 0, ey = 0, ex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = board[i].charAt(j);
                
                if (map[i][j] == 'R') {
                    sy = i; sx = j;
                } else if (map[i][j] == 'G') {
                    ey = i; ex = j;
                }
            }
        }
        
        dist = new int[N][M];
        bfs(sy, sx, ey, ex);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        
        return dist[ey][ex] == 0 ? -1 : dist[ey][ex];
    }
    
    public static void bfs(int sy, int sx, int ey, int ex) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sy, sx});
        visited[sy][sx] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == ey && cur[1] == ex) break;
            
            for (int d = 0; d < 4; d++) {
                int ny = cur[0] + dirY[d];
                int nx = cur[1] + dirX[d];
                
                if (inRange(ny, nx) && map[ny][nx] != 'D') {
                    while (inRange(ny + dirY[d], nx + dirX[d]) && 
                           map[ny + dirY[d]][nx + dirX[d]] != 'D') {
                        ny += dirY[d];
                        nx += dirX[d];
                    }
                    
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[] {ny, nx});
                        dist[ny][nx] = dist[cur[0]][cur[1]] + 1; 
                    }
                }
            }
        }
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}