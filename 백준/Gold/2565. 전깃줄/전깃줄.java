import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] line = new int[N + 1][2];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(line, new Comparator<int[]>() {

			@Override
			public int compare(int[] l1, int[] l2) {
				return l1[0] - l2[0];
			}
		});

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                int left = line[j][0], right = line[j][1];
                
                if (line[i][0] > left && line[i][1] > right) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    left = line[i][0];
                    right = line[i][1];
                }
            }
        }
        
        int result = 0;
        
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dp[i]);
        }
        
        System.out.println(N - result);
	} 
}