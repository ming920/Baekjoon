import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        
        int[] extended = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            extended[i] = elements[i % n];
        }
        
        Set<Integer> set = new HashSet<>();
        for (int start = 0; start < n; start++) {
            int sum = 0;
            
            for (int length = 1; length <= n; length++) {
                sum += extended[start + length - 1];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}