import java.util.*;

class Solution {
    public static class Book {
        int start;
        int end;
        
        public Book(int start, int end) {
            this.start = start;
            this.end = end + 9;
        }
    }
    
    public int solution(String[][] book_time) {
        Book[] books = new Book[book_time.length];
        
        for (int i = 0; i < book_time.length; i++) {
            
            String startStr = book_time[i][0];
            int startHour = (startStr.charAt(0) - '0') * 10 + (startStr.charAt(1) - '0');
            int startMinute = (startStr.charAt(3) - '0') * 10 + (startStr.charAt(4) - '0');
            int start = startHour * 60 + startMinute;
            
            String endStr = book_time[i][1];
            int endHour = (endStr.charAt(0) - '0') * 10 + (endStr.charAt(1) - '0');
            int endMinute = (endStr.charAt(3) - '0') * 10 + (endStr.charAt(4) - '0');
            int end = endHour * 60 + endMinute;
            
            books[i] = new Book(start, end);
        }
        
        Arrays.sort(books, (a, b) -> {
            return Integer.compare(a.start, b.start);
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Book book : books) {
            if (!pq.isEmpty() && pq.peek() < book.start) pq.poll();
            pq.add(book.end);
        }
        
        return pq.size();
    }
}