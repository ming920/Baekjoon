import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int right = 0;
        int[] budgets = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, budgets[i]);
        }
        
        int M = Integer.parseInt(br.readLine());
        
        int left = 1, mid = 0, result = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int sum = 0;
            
            for (int i = 0; i < N; i++) {
                if (budgets[i] >= mid) sum += mid;
                else sum += budgets[i];
            }
            
            if (sum <= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}