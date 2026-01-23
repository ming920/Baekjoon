import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int minEvery = Integer.MAX_VALUE, minEach = Integer.MAX_VALUE;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int every = Integer.parseInt(st.nextToken());
            int each = Integer.parseInt(st.nextToken());
            
            minEvery = Math.min(minEvery, every);
            minEach = Math.min(minEach, each);
        }
        
        if (minEvery > minEach * 6) {
            System.out.println(minEach * N);
            return;
        } else {
            System.out.println(Math.min(((N + 5) / 6) * minEvery, (N / 6) * minEvery + (N % 6) * minEach));
        }
    }
}