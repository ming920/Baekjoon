import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N == 0) {
            System.out.println(0);
            return;
        }
        
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        
        Arrays.sort(arr);
        
        long except = Math.round(N * 0.15);
        for (int i = 0; i < except; i++) {
            sum -= arr[i];
        }
        
        for (int i = N - 1; i >= N - except; i--) {
            sum -= arr[i];
        }
        
        N -= 2 * except;
        System.out.print(Math.round((double)sum / N));
    }
}