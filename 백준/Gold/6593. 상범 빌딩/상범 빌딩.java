import java.io.*;
import java.util.*;

public class Main {
	public static int L, R, C;
	public static char[][][] building;
	public static int[] dirZ = {1, -1, 0, 0, 0, 0};
	public static int[] dirY = {0, 0, -1, 1, 0, 0};
	public static int[] dirX = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0) {
				System.out.println(sb);
				return;
			}

			building = new char[L][R][C];
			int sy = 0, sx = 0, sz = 0;
			int ey = 0, ex = 0, ez = 0;

			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					String line = br.readLine();

					if (line.isEmpty()) {
						r--;
						continue;
					}

					for (int c = 0; c < C; c++) {
						building[l][r][c] = line.charAt(c);

						if (building[l][r][c] == 'S') {
							sz = l;
							sy = r;
							sx = c;
						} else if (building[l][r][c] == 'E') {
							ez = l;
							ey = r;
							ex = c;
						}
					}
				}
				br.readLine();
			}

			int[][][] dist = new int[L][R][C];
			boolean[][][] visited = new boolean[L][R][C];
			Queue<int[]> queue = new ArrayDeque<>();
			visited[sz][sy][sx] = true;
			queue.add(new int[] {sz, sy, sx});

			while (!queue.isEmpty()) {
				int[] loc = queue.poll();

				for (int d = 0; d < 6; d++) {
					int nz = loc[0] + dirZ[d];
					int ny = loc[1] + dirY[d];
					int nx = loc[2] + dirX[d];

					if (inRange(nz, ny, nx) && !visited[nz][ny][nx] && building[nz][ny][nx] != '#') {
						visited[nz][ny][nx] = true;
						queue.add(new int[] {nz, ny, nx});
						dist[nz][ny][nx] = dist[loc[0]][loc[1]][loc[2]] + 1;
					}
				}
			}

			if (dist[ez][ey][ex] == 0) {
				sb.append("Trapped!\n");
			} else {
				sb.append("Escaped in ").append(dist[ez][ey][ex]).append(" minute(s).\n");
			}
		}
	}

	public static boolean inRange(int z, int y, int x) {
		return z >= 0 && z < L && y >= 0 && y < R && x >= 0 && x < C;
	}
}