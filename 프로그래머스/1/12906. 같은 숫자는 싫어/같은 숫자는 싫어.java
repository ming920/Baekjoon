import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int prev = 10;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (prev == arr[i]) continue;
            list.add(arr[i]);
            prev = arr[i];
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}