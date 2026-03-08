import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        if (N == 0) {
            System.out.print(1);
            return;
        }
        
        int[] scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        
        int rank = 1, cnt = 0;
        for (int score : scores) {
            if (newScore < score) rank++;
            else if (newScore == score) cnt++;
        }
        
        if (rank + cnt <= P) System.out.println(rank);
        else System.out.println(-1);
    }
}