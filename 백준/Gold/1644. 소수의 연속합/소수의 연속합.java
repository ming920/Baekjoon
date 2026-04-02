import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 1. 에라토스테네스의 체
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        if (N >= 0) isPrime[0] = false;
        if (N >= 1) isPrime[1] = false;
        
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // 2. 소수 리스트 생성
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) primes.add(i);
        }
        
        int left = 0, right = 0;
        int sum = 0, result = 0;
        
        while (true) {
            if (sum >= N) {
                sum -= primes.get(left++);
            } else {
                if (right == primes.size()) break;
                sum += primes.get(right++);
            }
            
            if (sum == N) result++;
        }

        System.out.println(result);
    }
}