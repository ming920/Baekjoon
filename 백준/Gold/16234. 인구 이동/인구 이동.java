import java.io.*;
import java.util.*;

public class Main {
	public static int N, L, R;
	public static int[][] board;
	public static boolean[][] visited;
	public static int[] dirY = {1, -1, 0, 0};
	public static int[] dirX = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        int day = 0;
		while (true) {
			int result = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
						result++;
					}
				}
			}
			
			if (result == N * N) {
			    System.out.println(day);
			    return;
			} else {
			    day++;
			}
		}
	}

	public static void bfs(int sy, int sx) {
		Queue<int[]> queue = new ArrayDeque<>();
		Queue<int[]> log = new ArrayDeque<>();
		visited[sy][sx] = true;
		queue.add(new int[] {sy, sx});
		log.add(new int[] {sy, sx});
		int total = board[sy][sx];
		int cnt = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int ny = cur[0] + dirY[d];
				int nx = cur[1] + dirX[d];

				if (inRange(ny, nx) && !visited[ny][nx] &&
				        Math.abs(board[cur[0]][cur[1]] - board[ny][nx]) >= L && Math.abs(board[cur[0]][cur[1]] - board[ny][nx]) <= R) {
					visited[ny][nx] = true;
					queue.add(new int[] {ny, nx});
					log.add(new int[] {ny, nx});
					total += board[ny][nx];
					cnt++;
				}
			}
		}
		
		int people = total / cnt;
		while (!log.isEmpty()) {
		    int[] loc = log.poll();
		    board[loc[0]][loc[1]] = people;
		}
	}

	public static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}