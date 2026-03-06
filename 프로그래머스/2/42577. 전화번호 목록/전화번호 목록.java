import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for (String str : phone_book) {
            set.add(str);
        }
        
        for (String phone : phone_book) {   
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < phone.length() - 1; i++) {
                sb.append(phone.charAt(i));
                
                if (set.contains(sb.toString())) return false;
            }
        }

        return true;
    }
}