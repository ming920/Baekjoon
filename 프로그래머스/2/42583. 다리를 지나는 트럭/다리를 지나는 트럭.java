import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }
        
        int totalWeight = 0, answer = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            totalWeight -= queue.poll();
            
            if (totalWeight + truck_weights[i] <= weight) {
                totalWeight += truck_weights[i];
                queue.add(truck_weights[i]);
            } else {
                while (totalWeight + truck_weights[i] > weight) {
                    totalWeight -= queue.poll();
                    queue.add(0);
                    answer++;
                }
                
                queue.add(truck_weights[i]);
                totalWeight += truck_weights[i];
            }
            answer++;
        }
        
        return answer + bridge_length;
    }
}