import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        for (int k = K; k <= 100; k++) {
            double num = ((double)N / k) - ((double)(k - 1) / 2);
            
            if (num < 0) {
                System.out.println("-1");
                return;
            }
            
            if (isInteger(num)) {
                int x = (int)num;
                for (int i = 0; i < k; ++i) {
                    System.out.print(x++ + " ");
                }
                
                return;
            }
        }
        
        System.out.println("-1");
        return;
    }
    
    public static boolean isInteger(double num) {
        return num % 1 == 0.0;
    }
}