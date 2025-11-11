import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board, answer;
    static boolean[][] visited;
    static int[] dirY = {0, 0, 1, -1};
    static int[] dirX = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        answer = new int[N][M];
        for (int i = 0; i < N; ++i) {
            String line = br.readLine();
            for (int j = 0; j < M; ++j) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        
        visited = new boolean[N][M];
        bfs(0, 0);
        System.out.println(answer[N - 1][M - 1]);
    }
    
    public static void bfs(int sy, int sx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sy, sx});
        visited[sy][sx] = true;
        answer[sy][sx] = 1;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0], x = now[1];
            
            for (int i = 0; i < 4; ++i) {
                int ny = y + dirY[i];
                int nx = x + dirX[i];
                if (inRange(ny, nx) && !visited[ny][nx] && board[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    answer[ny][nx] = answer[y][x] + 1;
                    queue.offer(new int[] {ny, nx});
                }
            }
        }
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}