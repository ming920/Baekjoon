import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (a, b) -> {
           return Integer.compare(a[0], b[0]); 
        });
        
        int maxHeight = 0;
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i][1] > maxHeight) {
                maxHeight = arr[i][1];
                maxIdx = i;
            }
        }
        
        int answer = maxHeight;
        
        int leftPos = arr[0][0];
        int leftHeight = arr[0][1];
        for (int i = 1; i <= maxIdx; i++) {
            if (arr[i][1] >= leftHeight) {
                answer += (arr[i][0] - leftPos) * leftHeight;
                leftPos = arr[i][0];
                leftHeight = arr[i][1];
            }
        }
        
        int rightPos = arr[N - 1][0];
        int rightHeight = arr[N - 1][1];
        for (int i = N - 2; i >= maxIdx; i--) {
            if (arr[i][1] >= rightHeight) {
                answer += (rightPos - arr[i][0]) * rightHeight;
                rightPos = arr[i][0];
                rightHeight = arr[i][1];
            }
        }
        
        System.out.println(answer);
    }
}