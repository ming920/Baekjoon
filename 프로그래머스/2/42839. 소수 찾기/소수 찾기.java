import java.util.*;

class Solution {
    int N;
    String str;
    boolean[] visited;
    Set<Integer> primes = new HashSet<>();
    
    public int solution(String numbers) {
        str = numbers;
        N = numbers.length();
        visited = new boolean[N];
        
        dfs(0);
        
        int answer = primes.size();

        return answer;
    }
    
    public void dfs(int num) {
        if (primes.contains(num) || isPrime(num)) primes.add(num);
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(num * 10 + str.charAt(i) - '0');
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        else if (num == 2 || num == 3) return true;
        else if (num % 2 == 0 || num % 3 == 0) return false;
        
        for (int i = 5; i * i <= num; i++) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        
        return true;
    }
}