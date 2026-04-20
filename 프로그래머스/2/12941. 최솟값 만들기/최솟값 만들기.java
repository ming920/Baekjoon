import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : A) {
            minpq.add(num);
        }
        
        for (int num : B) {
            maxpq.add(num);
        }
        
        int answer = 0;
        while (!minpq.isEmpty()) {
            answer += minpq.poll() * maxpq.poll();
        }
        return answer;
    }
}