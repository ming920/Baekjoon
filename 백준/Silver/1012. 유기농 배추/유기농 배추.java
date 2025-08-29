//  유기농 배추

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int M, N;
    public static int[] dirY = {0, 1, 0, -1};
    public static int[] dirX = {1, 0, -1, 0};
    public static int[][] board;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; ++t) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            board = new int[N][M];
            visited = new boolean[N][M];

            for (int k = 0; k < K; ++k) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                board[Y][X] = 1;
            }

            int count = 0;

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (board[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; ++i) {
                int ny = cur[0] + dirY[i];
                int nx = cur[1] + dirX[i];

                if (inRange(ny, nx) && board[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny, nx});
                }
            }
        }
    }

    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}