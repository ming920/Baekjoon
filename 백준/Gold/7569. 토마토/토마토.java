import java.io.*;
import java.util.*;

public class Main {
    public static int M, N, H;
    public static int[] dirY = {0, 0, 1, 0, -1, 0};
    public static int[] dirX = {0, -1, 0, 1, 0, 0};
    public static int[] dirZ = {-1, 0, 0, 0, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        int[][][] box = new int[N][M][H];
        boolean[][][] visited = new boolean[N][M][H];
        Queue<int[]> queue = new ArrayDeque<>();
        
        
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                
                for (int j = 0; j < M; j++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    
                    if (box[i][j][k] == 1) {
                        visited[i][j][k] = true;
                        queue.add(new int[] {i, j, k});
                    }
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1], cz = cur[2];
            
            for (int d = 0; d < 6; d++) {
                int ny = cy + dirY[d];
                int nx = cx + dirX[d];
                int nz = cz + dirZ[d];
                
                if (inRange(ny, nx, nz) && box[ny][nx][nz] == 0 && !visited[ny][nx][nz]) {
                    box[ny][nx][nz] = box[cy][cx][cz] + 1;
                    visited[ny][nx][nz] = true;
                    queue.add(new int[] {ny, nx, nz});
                }
            }
        }
        
        int result = 0;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[i][j][k] == 0) {
                       System.out.println("-1");
                        return;
                    } else {
                       result = Math.max(result, box[i][j][k]);
                    }
                }
            }
        }
        
        System.out.println(result - 1);
    }
    
    public static boolean inRange(int y, int x, int z) {
        return y >= 0 && y < N && x >= 0 && x < M && z >= 0 && z < H;
    }
}