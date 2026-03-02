import java.util.*;

class Solution {
    
    TreeSet<String> set = new TreeSet<>();
    char[] vowel = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        dfs(sb);
        return set.headSet(word).size();
    }
    
    public void dfs(StringBuilder sb) {
        if (sb.length() > 5) return;
        else set.add(sb.toString());
        
        for (int i = 0; i < 5; i++) {
            sb.append(vowel[i]);
            dfs(sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}