import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int[] cost = new int[N];
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            int sum = cost[i] * X + cost[i + 1] * X;
            min = Math.min(min, sum);
        }
        
        System.out.println(min);
    }
}