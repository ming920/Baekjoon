import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[] arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = Math.max(arr[0], N - arr[M - 1]);
        for (int i = 1; i < M; i++) {
            answer = Math.max(answer, (int) Math.ceil((double)(arr[i] - arr[i - 1]) / 2));
        }
        
        System.out.println(answer);
    }
}