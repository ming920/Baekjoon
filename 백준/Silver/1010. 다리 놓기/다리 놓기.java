//  다리 놓기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < T; ++t) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long[][] dp = new long[M + 1][M + 1];
            dp[0][0] = 1;

            for (int i = 1; i <= M; ++i) {
                    dp[i][0] = 1;
                    dp[i][i] = 1;
            }

            for (int n = 1; n <= M; ++n) {
                for (int m = 1; m <= n; ++m) {
                    dp[n][m] = dp[n - 1][m] + dp[n - 1][m - 1];
                }
            }

            System.out.println(dp[M][N]);
        }

    }
}