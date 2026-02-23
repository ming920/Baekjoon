import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] board = new int[8][8];

		String kingLoc = st.nextToken();
		String rockLoc = st.nextToken();
		int N = Integer.parseInt(st.nextToken());

		int cy = (kingLoc.charAt(1) - '0') - 1;
		int cx = (kingLoc.charAt(0) - 'A');

		board[cy][cx] = 1;
		board[(rockLoc.charAt(1) - '0') - 1][rockLoc.charAt(0) - 'A'] = 2;

		for (int i = 0; i < N; i++) {
			String dir = br.readLine();

			int dy = 0, dx = 0;
			switch (dir) {
			case "R":
				dy = 0;
				dx = 1;
				break;
			case "L":
				dy = 0;
				dx = -1;
				break;
			case "B":
				dy = -1;
				dx = 0;
				break;
			case "T":
				dy = 1;
				dx = 0;
				break;
			case "RT":
				dy = 1;
				dx = 1;
				break;
			case "LT":
				dy = 1;
				dx = -1;
				break;
			case "RB":
				dy = -1;
				dx = 1;
				break;
			case "LB":
				dy = -1;
				dx = -1;
				break;
			}

			int ny = cy + dy, nx = cx + dx;
			if (inRange(ny, nx) && board[ny][nx] == 2) {
				if (inRange(ny + dy, nx + dx)) {
					board[ny + dy][nx + dx] = 2;
					board[ny][nx] = 1;
					board[cy][cx] = 0;
					cy = ny;
					cx = nx;
				}
			} else if (inRange(ny, nx) && board[ny][nx] == 0) {
				board[ny][nx] = 1;
				board[cy][cx] = 0;
				cy = ny;
				cx = nx;
			}
		}

		char kingY = '1', kingX = 'A', rockY = '1', rockX = 'A';
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == 1) {
					kingY += i;
					kingX += j;
				} else if (board[i][j] == 2) {
					rockY += i;
					rockX += j;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(kingX).append(kingY).append("\n");
		sb.append(rockX).append(rockY);

		System.out.print(sb);
	}

	public static boolean inRange(int y, int x) {
		return y >= 0 && y < 8 && x >= 0 && x < 8;
	}
}