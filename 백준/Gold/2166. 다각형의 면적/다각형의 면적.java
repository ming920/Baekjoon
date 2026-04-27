import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        long[][] xy = new long[N + 1][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
        }
        
        xy[N][0] = xy[0][0];
        xy[N][1] = xy[0][1];
        
        long area = 0;
        
        for (int i = 0; i < N; i++) {
            area += xy[i][0] * xy[i + 1][1] - xy[i + 1][0] * xy[i][1];
        }
        
        System.out.println(String.format("%.1f", Math.abs(area) / 2.0));
    }  
}