import java.io.*;
import java.util.*;

public class Main {
    public static int[] results;
    public static List<Integer>[] arr;
    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        results = new int[N + 1];
        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            
            arr[num1].add(num2);
            arr[num2].add(num1);
        }
        
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(results[i]).append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        
        while (!queue.isEmpty()) {
            int num = queue.poll();
            visited[num] = true;
            
            for (Integer next : arr[num]) {
                if (!visited[next]) {
                    results[next] = num;
                    queue.add(next);
                }
            }
        }
    }
}