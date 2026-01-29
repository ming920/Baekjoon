import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] primes = new boolean[246913];
        
        for (int i = 1; i <= 246912; i++) {
            if (isPrime(i)) primes[i] = true;
        }
        
        while (true) {
            int num = Integer.parseInt(br.readLine());
            
            if (num == 0) break;
            
            int result = 0;
            
            for (int i = num + 1; i <= num * 2; i++) {
                if (primes[i]) result++;
            }
            
            sb.append(result).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        
        for (int i = 5; i <= Math.sqrt(num); i++) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}