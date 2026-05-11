import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peekLast() == ch) {
                    stack.pollLast();
                    continue;
                }
            }
            
            stack.addLast(ch);
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}