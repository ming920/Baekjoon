import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        arr = new int[N + 1];
        arr[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            if (arr[i] >= S) {
                result = Math.min(result, i - binarySearch(arr[i] - S, i));
            }
        }
        
        if (result == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(result);
    }
    
    public static int binarySearch(int num, int right) {
        int left = 0, mid = 0;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            
            if (arr[mid] <= num) left = mid + 1;
            else right = mid - 1;
        }
        
        return right;
    }
}