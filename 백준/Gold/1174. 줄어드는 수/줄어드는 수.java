import java.io.*;

public class Main {
    public static int count = 0, N;
    public static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        visited = new boolean[10];
        
        if (N == 1) {
            System.out.println(0);
            return;
        } else if (N >= 1024) {
            System.out.println(-1);
            return;
        }
        
        for (int d = 1; d <= 10; d++) {
            long result = backtracking(d, 0, 0);
            if (result != -1) {
                System.out.println(result);
                return;
            }
        }
    }
    
    public static long backtracking(int digit, int depth, long value) {
        if (depth == digit) {
            count++;
            
            if (count == N) {
                return value;
            }
            
            return -1;
        }
        
        long prev = depth == 0 ? 10 : value % 10;
        value *= 10;
        
        for (int i = 0; i <= 9; i++) {
            if (i < prev && !visited[i]) {
                visited[i] = true;
                long result = backtracking(digit, depth + 1, value + i);
                visited[i] = false;
                
                if (result != -1) {
                    return result;
                }
            }
        }
        
        return -1;
    }
}