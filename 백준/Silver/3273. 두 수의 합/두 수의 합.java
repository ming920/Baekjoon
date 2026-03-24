import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        
        int left = 0, right = N - 1, result = 0;
        
        while (left < right) {
            if (arr[left] + arr[right] == M) {
                result++;
                left++;
            } else if (arr[left] + arr[right] < M) {
                left++;
            } else {
                right--;
            }
        }
        
        System.out.println(result);
    }
}
