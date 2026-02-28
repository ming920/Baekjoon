import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        Map<String, Integer> map = new HashMap<>();
        int N = name.length;
        
        for (int i = 0; i < N; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (String str : photo[i]) {
                score += map.getOrDefault(str, 0);
            }
            answer[i] = score;
        }
        return answer;
    }
}