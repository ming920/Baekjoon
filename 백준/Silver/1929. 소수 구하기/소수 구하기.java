import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        for (int i = M; i <= N; i++) {
            if (isPrime(i)) System.out.println(i);
        }
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3 || num == 5) return true;
        
        if (num % 2 == 0 || num % 3 == 0) return false;
        
        for (int i = 5; i <= Math.sqrt(num); i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        
        return true;
    }
}