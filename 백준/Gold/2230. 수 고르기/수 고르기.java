import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(A);
        
        int result = Integer.MAX_VALUE;
        
        for (int num : A) {
            if (num - M >= -1_000_000_000) {
                int index = Arrays.binarySearch(A, num - M);
                
                if (index >= 0) {
                    System.out.println(Math.abs(num - A[index]));
                    return;
                } else {
                    if (index <= -2) {
                        result = Math.min(result, Math.abs(num - A[(index + 2) * -1]));
                    }
                }
            } 
            
            if (num + M <= 1_000_000_000) {
                int index = Arrays.binarySearch(A, num + M);
                
                if (index >= 0) {
                    System.out.println(A[index] - num);
                    return;
                } else {
                    if (index > -1 * N) {
                        result = Math.min(result, A[(index + 1) * -1] - num);
                    }
                }
            }
        }
        
        System.out.println(result);
    }
}