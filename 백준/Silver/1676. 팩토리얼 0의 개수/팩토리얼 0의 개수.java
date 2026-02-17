import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int twoCnt = 0, fiveCnt = 0;
        for (int n = N; n > 0; n--) {
            int num = n;
            
            while (num % 2 == 0 || num % 5 == 0) {
                if (num % 2 == 0) {
                    twoCnt++;
                    num /= 2;
                }
                
                if (num % 5 == 0) {
                    fiveCnt++;
                    num /= 5;
                }
            }
        }
        
        System.out.print(Math.min(twoCnt, fiveCnt));
    }
}