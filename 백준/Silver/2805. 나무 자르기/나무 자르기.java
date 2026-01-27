import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        
        int[] trees = new int[N];
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, trees[i]);
        }
        
        int left = 0, mid = 0, result = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (trees[i] - mid > 0) sum += trees[i] - mid;
            }
            
            if (sum >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}