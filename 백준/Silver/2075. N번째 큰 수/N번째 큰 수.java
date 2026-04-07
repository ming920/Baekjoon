import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] size = new int[N];
        for (int i = 0; i < N; i++) {
            size[i] = N - 1;
        }
        
        int cnt = 0;
        int answer = Integer.MAX_VALUE;
        while (cnt < N) {
            int index = 0;
            int num = Integer.MIN_VALUE;
            
            for (int i = 0; i < N; i++) {
                if (arr[size[i]][i] > num) {
                    num = arr[size[i]][i];
                    index = i;
                }
            }
            
            answer = Math.min(answer, num);
            size[index]--;
            cnt++;
        }
        
        System.out.println(answer);
    }
}