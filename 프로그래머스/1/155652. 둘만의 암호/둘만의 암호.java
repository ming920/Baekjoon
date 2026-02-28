import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> set = new HashSet<>();
        
        for (char ch : skip.toCharArray()) {
            set.add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int i = 0;
            while (i < index) {
                ch += 1;
                if (ch > 'z') ch = 'a';
                if (set.contains(ch)) {
                    continue;
                }
                i += 1;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}