import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static char[] arr;
    public static boolean[] visited = new boolean[10];
    public static List<String> result = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new char[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            visited[i] = true;
            backtracking(sb, i, 1);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
        
        Collections.sort(result);
        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }
    
    public static void backtracking(StringBuilder sb, int prevNum, int depth) {
        if (depth == N + 1) {
            result.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < 10; i++) {
            if (!visited[i] && arr[depth - 1] == '<' && prevNum < i) {
                visited[i] = true;
                sb.append(i);
                backtracking(sb, i, depth + 1);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            } else if (!visited[i] && arr[depth - 1] == '>' && prevNum > i) {
                visited[i] = true;
                sb.append(i);
                backtracking(sb, i, depth + 1);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}