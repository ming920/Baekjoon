import java.util.*;

class Solution {
    public long solution(long n) {
        List<Integer> list = new ArrayList<>();
        
        while (n > 0) {
            list.add((int)(n % 10));
            n /= 10;
        }
        
        Collections.sort(list, Collections.reverseOrder());
        long answer = 0;
        for (int i = 0; i < list.size(); i++) {
            answer = answer * 10 + list.get(i);
        }
        return answer;
    }
}