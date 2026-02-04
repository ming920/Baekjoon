import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] score = new int[N + 1][3];
        int[][] dp_max = new int[N + 1][3];
        int[][] dp_min = new int[N + 1][3];
        
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < 3; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp_max[i][j] = Math.max(dp_max[i - 1][j], dp_max[i - 1][j + 1]) + score[i][j];
                    dp_min[i][j] = Math.min(dp_min[i - 1][j], dp_min[i - 1][j + 1]) + score[i][j];
                } else if (j == 1) {
                    dp_max[i][j] = Math.max(dp_max[i - 1][j], Math.max(dp_max[i - 1][j + 1], dp_max[i - 1][j - 1])) + score[i][j];
                    dp_min[i][j] = Math.min(dp_min[i - 1][j], Math.min(dp_min[i - 1][j + 1], dp_min[i - 1][j - 1])) + score[i][j];
                } else {
                    dp_max[i][j] = Math.max(dp_max[i - 1][j], dp_max[i - 1][j - 1]) + score[i][j];
                    dp_min[i][j] = Math.min(dp_min[i - 1][j], dp_min[i - 1][j - 1]) + score[i][j];
                }
            }
        }
        
        int max_result = 0, min_result = Integer.MAX_VALUE;
        
        for (int i = 0; i < 3; i++) {
            max_result = Math.max(max_result, dp_max[N][i]);
            min_result = Math.min(min_result, dp_min[N][i]);
        }
        
        System.out.println(max_result + " " + min_result);
    }
}