import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int count = 0;
        int zeroCnt = 0;
        while (!s.equals("1")) {
            count++;
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                
                if (ch == '0') zeroCnt++;
                else sb.append(ch);
            }
            
            s = Integer.toBinaryString(sb.toString().length());
        }
        
        int[] answer = {count, zeroCnt};
        return answer;
    }
}