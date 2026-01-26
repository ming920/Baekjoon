import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] board;
    static int[][] days;
    static boolean[][] visited;
    static int[] dirY = {0, 0, 1, -1};
    static int[] dirX = {1, -1, 0, 0};
    static List<int[]> idxTomato;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        visited = new boolean[N][M];
        idxTomato = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    idxTomato.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        days = new int[N][M];
        bfs();
        int maxDays = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (!visited[i][j]&& board[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
                maxDays = Math.max(maxDays, days[i][j]);
            }
        }
        
        System.out.println(maxDays);
    }
    
    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] idx : idxTomato) {
            queue.offer(new int[] {idx[0], idx[1]});
        }
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0], x = now[1];
            
            for (int i = 0; i < 4; ++i) {
                int ny = y + dirY[i];
                int nx = x + dirX[i];
                if (inRange(ny, nx) && !visited[ny][nx] && board[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    queue.offer(new int[] {ny, nx});
                    days[ny][nx] = days[y][x] + 1;
                }
            }
        }
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}