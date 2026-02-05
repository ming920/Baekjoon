import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] A, dp_left, dp_right;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        A = new int[N];
        dp_left = new int[N];
        dp_right = new int[N];
        
        Arrays.fill(dp_left, 1);
        Arrays.fill(dp_right, 1);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) dp_left[i] = Math.max(dp_left[i], dp_left[j] + 1);
            }
        }
        
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (A[i] > A[j]) dp_right[i] = Math.max(dp_right[i], dp_right[j] + 1);
            }
        }
        
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp_left[i] + dp_right[i] - 1);
        }
        
        System.out.println(result);
    }    
}