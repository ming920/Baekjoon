import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int index = 0, N = speeds.length;
        List<Integer> list = new ArrayList<>();
        
        while (index < N) {
            if (progresses[index] >= 100) index++;
            
            int days = (100 - progresses[index] + speeds[index] - 1) / speeds[index];
            for (int j = index; j < N; j++) {
                progresses[j] += speeds[j] * days;
            }
            
            int cnt = 0;
            while (index < N && progresses[index] >= 100) {
                cnt++;
                index++;
            }
            
            list.add(cnt);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}