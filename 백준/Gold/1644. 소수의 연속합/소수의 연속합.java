import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 4_000_000; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
        
        int left = 0, right = 0, result = 0;
        long sum = 0;
        
        while (true) {
            if (sum >= num) {
                sum -= list.get(left++);
            } else {
                if (right == list.size()) break;
                sum += list.get(right++);
            }
            
            if (sum == num) result++;
        }
        
        System.out.println(result);
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        
        for (int i = 5; i * i <= num; i++) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        
        return true;
    }
}