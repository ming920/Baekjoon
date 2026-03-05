import java.util.*;

class Solution {
    public class Price {
        int index;
        int price;
        
        public Price(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Price> deque = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!deque.isEmpty() && deque.peekLast().price >  prices[i]) {
                Price p = deque.pollLast();
                answer[p.index] = i - p.index;
            }
            
            deque.addLast(new Price(i, prices[i]));
        }
        
        while (!deque.isEmpty()) {
            Price p = deque.pollLast();
            answer[p.index] = prices.length - p.index - 1;
        }

        return answer;
    }
}