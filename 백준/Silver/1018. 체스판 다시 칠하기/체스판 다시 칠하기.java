//  체스판 다시 칠하기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static final char[][] BW =
            {
                    "BWBWBWBW".toCharArray(),
                    "WBWBWBWB".toCharArray(),
                    "BWBWBWBW".toCharArray(),
                    "WBWBWBWB".toCharArray(),
                    "BWBWBWBW".toCharArray(),
                    "WBWBWBWB".toCharArray(),
                    "BWBWBWBW".toCharArray(),
                    "WBWBWBWB".toCharArray()
            };

    public static final char[][] WB =
            {
                    "WBWBWBWB".toCharArray(),
                    "BWBWBWBW".toCharArray(),
                    "WBWBWBWB".toCharArray(),
                    "BWBWBWBW".toCharArray(),
                    "WBWBWBWB".toCharArray(),
                    "BWBWBWBW".toCharArray(),
                    "WBWBWBWB".toCharArray(),
                    "BWBWBWBW".toCharArray()
            };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        for (int i = 0; i < N; ++i) {
            String line = br.readLine();
            for (int j = 0; j < M; ++j) {
                board[i][j] = line.charAt(j);
            }
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; ++i) {
            for (int j = 0; j <= M - 8; ++j) {
                res = Math.min(res, countWB(i, j, board));
                res = Math.min(res, countBW(i, j, board));
            }
        }

        System.out.println(res);
    }

    public static int countBW(int y, int x, char[][] board) {
        int count = 0;

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[y + i][x + j] != BW[i][j]) count++;
            }
        }
        return count;
    }

    public static int countWB(int y, int x, char[][] board) {
        int count = 0;

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[y + i][x + j] != WB[i][j]) count++;
            }
        }
        return count;
    }
}