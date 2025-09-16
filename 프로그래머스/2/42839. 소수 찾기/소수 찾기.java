import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        
        dfs(numbers, "", visited);
        int answer = set.size();
        return answer;
    }
    
    public static void dfs(String numbers, String current, boolean[] visited) {
        for (int i = 0; i < numbers.length(); ++i) {
            if (!visited[i]) {
                String next = current + numbers.charAt(i);
                visited[i] = true;
                if (isPrime(next)) set.add(Integer.parseInt(next));
                dfs(numbers, next, visited);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(String n) {
        int num = Integer.parseInt(n);
        
        if (num <= 1) return false;
        if (num == 2) return true;
        
        for (int i = 2; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) return false;
        }
        return true;
    }
}