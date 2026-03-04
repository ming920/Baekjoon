import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], 1_000_000_000);
        }
        
        map.put(begin, 0);
        
        Queue<String> queue = new ArrayDeque<>();
        queue.add(begin);
        
        while (!queue.isEmpty()) {
            String start = queue.poll();
            
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String word = entry.getKey();
                Integer cnt = entry.getValue();
                
                int count = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != start.charAt(i)) count++;
                }
                
                if (count == 1 && map.get(start) + 1 < map.get(word)) {
                    map.put(word, map.get(start) + 1);
                    queue.add(word);
                }
            }
        }
        
        int answer = map.getOrDefault(target, 0);
        if (answer >= 1_000_000_000) return 0;
        return answer;
    }
}