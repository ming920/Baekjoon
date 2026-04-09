import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        char[][] board = new char[N][M];
        int sy = 0, sx = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                
                if (board[i][j] == 'I') {
                    sy = i; sx = j;
                }
            }
        }
        
        int answer = 0;
        int[] dirY = {1, -1, 0, 0};
        int[] dirX = {0, 0, 1, -1};
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[] {sy, sx});
        visited[sy][sx] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int ny = cur[0] + dirY[d];
                int nx = cur[1] + dirX[d];
                
                if (inRange(ny, nx) && !visited[ny][nx] && board[ny][nx] != 'X') {
                    queue.add(new int[] {ny, nx});
                    visited[ny][nx] = true;
                    if (board[ny][nx] == 'P') answer++;
                }
            }
        }
        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);   
        }
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}