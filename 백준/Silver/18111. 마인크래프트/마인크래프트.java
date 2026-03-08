import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] blocks = new int[N][M];
		int totalBlock = B;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				blocks[i][j] = Integer.parseInt(st.nextToken());
				totalBlock += blocks[i][j];
			}
		}
		
		if (N == 1 && M == 1) {
		    System.out.println("0" + " " + blocks[0][0]);
		    return;
		}

		long timeAnswer = Long.MAX_VALUE;
		int heightAnswer = 0;

		for (int h = 0; h <= 256; h++) {
			long time = 0;
			if (totalBlock < N * M * h) break;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (blocks[i][j] == h) continue;
					else if (blocks[i][j] > h) {
						time += 2 * (blocks[i][j] - h);
					} else if (blocks[i][j] < h) {
						time += (h - blocks[i][j]);
					}
				}
			}
			
			if (timeAnswer >= time) {
				timeAnswer = time;
				heightAnswer = h;
			}
		}

		System.out.println(timeAnswer + " " + heightAnswer);
	}
}