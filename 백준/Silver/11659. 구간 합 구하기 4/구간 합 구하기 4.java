import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] sumArr = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        sumArr[1] = prev;
        for (int i = 2; i <= N; i++) {
            int next = Integer.parseInt(st.nextToken()); 
            sumArr[i] = prev + next;
            prev = sumArr[i];
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            System.out.println(sumArr[end] - sumArr[start - 1]);
        }
    }
}