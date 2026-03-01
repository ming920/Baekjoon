import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int N = numbers.length;
        String[] strNumbers = new String[N];
        
        for (int i = 0; i < N; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNumbers, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        
        StringBuilder answer = new StringBuilder();
        for (String str : strNumbers) {
            answer.append(str);
        }
        
        if (strNumbers[0].equals("0")) return "0";
    
        return answer.toString();
    }
}