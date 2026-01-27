import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] lines = new int[K];
        long right = 0;
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, lines[i]);
        }
        
        long left = 1, mid = 0, result = 0;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            
            int sum = 0;
            for (int i = 0; i < K && mid > 0; i++) {
                sum += lines[i] / mid;
            }
            
            if (sum >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right  = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}