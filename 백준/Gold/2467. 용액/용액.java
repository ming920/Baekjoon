import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        
        int left = 0, right = N - 1;
        int result = Integer.MAX_VALUE, resultLeft = 0, resultRight = N - 1;
        
        while (left < right) {
            int cur = Math.abs(arr[left] + arr[right]);
            
            if (cur < result) {
                result = cur;
                resultLeft = left;
                resultRight = right;
            } 
            
            if (arr[left] > 0 && arr[right] > 0) right--;
            else if (arr[left] < 0 && arr[right] < 0) left++;
            else {
                if (Math.abs(arr[left]) < Math.abs(arr[right])) right--;
                else left++;
            }
        }
        
        System.out.println(arr[resultLeft] + " " + arr[resultRight]);
    }
}