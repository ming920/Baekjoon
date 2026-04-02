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
        
        long[] A = new long[list.size() + 1];
        for (int i = 1; i <= list.size(); i++) {
            A[i] = list.get(i - 1);
        }
        
        for (int i = 1; i <= list.size(); i++) {
            A[i] += A[i - 1];
        }
        
        int left = 0, right = 0, result = 0;
        
        while (right < A.length) {
            long diff = A[right] - A[left];
            
            if (diff < num) right++;
            else if (diff > num) left++;
            else {
                result++;
                right++;
                left++;
            }
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