import java.util.*;

class Solution {
    static int N, M;
    int[] dirY = {0, 1, 0, -1};
    int[] dirX = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0});
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int sy = now[0], sx = now[1];
            
            for (int d = 0; d < 4; d++) {
                int ny = sy + dirY[d];
                int nx = sx + dirX[d];
                
                if (inRange(ny, nx) && maps[ny][nx] == 1) {
                    maps[ny][nx] = maps[sy][sx] + 1;
                    queue.add(new int[] {ny, nx});
                }
            }
        }
        
        int answer = maps[N - 1][M - 1] <= 1 ? -1 : maps[N - 1][M - 1];
        return answer;
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}