import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int[] newArr = new int[commands[i][1] - commands[i][0] + 1];
            for (int j = 0; j < newArr.length; j++) {
                newArr[j] = array[commands[i][0] - 1 + j];
            }
            Arrays.sort(newArr);
            answer[i] = newArr[commands[i][2] - 1];
        }

        return answer;
    }
}