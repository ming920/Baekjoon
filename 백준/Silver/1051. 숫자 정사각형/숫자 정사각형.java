//  숫자 정사각형

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; ++i) {
            String line = br.readLine();
            for (int j = 0; j < M; ++j) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        int res = 1;

        for (int i = 0; i < N; ++i) {
            int area = 1;

            for (int j = 0; j < M; ++j) {
                int maxLength = Math.min(N - i, M - j);
                for (int k = 1; k < maxLength; ++k) {
                    if (board[i][j] == board[i + k][j] &&
                            board[i][j] == board[i][j + k] &&
                            board[i][j] == board[i + k][j + k])
                        area = Math.max(area, (k + 1) * (k + 1));
                }
            }

            res = Math.max(res, area);
        }

        System.out.println(res);
    }
}