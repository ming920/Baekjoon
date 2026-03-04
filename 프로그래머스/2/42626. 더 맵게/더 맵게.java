import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int scov : scoville) {
            pq.add(scov);
        }
        
        int answer = 0;
        while (pq.peek() < K && pq.size() >= 2) {
            int food1 = pq.poll();
            int food2 = pq.poll();
            pq.add(food1 + 2 * food2);
            answer++;
        }
        
        if (pq.peek() < K) return -1;
        else return answer;
    }
}