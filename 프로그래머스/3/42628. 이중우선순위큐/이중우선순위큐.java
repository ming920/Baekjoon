import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<>();
        
        for (String operation : operations) {
            char op = operation.charAt(0);
            int num = Integer.parseInt(operation.split(" ")[1]);
            
            if (op == 'I') {
                int index = Collections.binarySearch(list, num);
                if (index >= 0) {
                    list.add(index, num);
                } else {
                    index = -1 * index - 1;
                    list.add(index, num);
                }
            } else {
                if (!list.isEmpty() && num == -1) {
                    list.remove(0);
                } else if (!list.isEmpty() && num == 1) {
                    list.remove(list.size() - 1);
                }
            }
        }
        
        int[] answer = new int[2];
        if (list.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else if (list.size() == 1) {
            answer[0] = list.get(0);
            answer[1] = list.get(0);
        } else if (list.size() >= 2){
            answer[0] = list.get(list.size() - 1);
            answer[1] = list.get(0);
        }
        return answer;
    }
}