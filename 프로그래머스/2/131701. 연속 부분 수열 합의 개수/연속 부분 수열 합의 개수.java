import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int length = elements.length;
        int[] sumArr = new int[length * 2];
        for (int i = 1; i <= length; i++) {
            sumArr[i] = elements[i - 1];
        }
        for (int i = length + 1; i < length * 2; i++) {
            sumArr[i] = elements[i - length - 1];
        }
        
        for (int i = 1; i < length * 2; i++) {
            sumArr[i] += sumArr[i - 1];
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < length * 2; i++) {
            for (int j = 1; j <= length; j++) {
                set.add(sumArr[i] - sumArr[Math.max(0, i - j)]);
            }
        }
        
        return set.size();
    }
}