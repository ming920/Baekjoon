import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Integer[] cnt = new Integer[10_000_001];
        
        for (int i = 0; i <= 10_000_000; i++) {
            cnt[i] = 0;
        }
        
        for (int tan : tangerine) {
            cnt[tan]++;
        }
        
        Arrays.sort(cnt, Comparator.reverseOrder());
        
        int number = 0;
        int answer = 0;
        for (int i = 0; i <= 10_000_000; i++) {
            number += cnt[i];
            answer++;
            if (k <= number) {
                break;
            }
        }
        return answer;
    }
}