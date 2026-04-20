import java.util.*;

class Solution {
    public String solution(String s) {
        char prev = ' ';
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (prev == ' ' && Character.isLetter(ch)) {
                sb.append(Character.toUpperCase(ch));
            } else if (prev != ' ' && Character.isLetter(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else {
                sb.append(ch);
            }
            
            prev = ch;
        }

        return sb.toString();
    }
}