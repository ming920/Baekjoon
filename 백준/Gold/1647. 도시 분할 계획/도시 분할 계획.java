import java.io.*;
import java.util.*;

public class Main {
	public static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge other) {
			return Integer.compare(this.cost, other.cost);
		}
	}

	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Edge> edges = new ArrayList<>();
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			edges.add(new Edge(
			              Integer.parseInt(st.nextToken()),
			              Integer.parseInt(st.nextToken()),
			              Integer.parseInt(st.nextToken())
			          ));
		}

		Collections.sort(edges);
		
		int sum = 0, maxEdge = 0, picked = 0;
		
		for (Edge edge : edges) {
		    if (union(edge.from, edge. to)) {
		        sum += edge.cost;
		        maxEdge = edge.cost;
		        picked++;
		    }
		    
		    if (picked == N - 1) break;
		}

		System.out.println(sum - maxEdge);
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) return false;

		if (x < y) parent[y] = x;
		else parent[x] = y;
		return true;
	}

	public static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
}