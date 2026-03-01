

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int N = t.length();
        int M = p.length();
        
        for (int i = 0; i <= N - M; i++) {
            String str = t.substring(i, i + M);
            
            if (str.compareTo(p) <= 0) answer++;
        }
        return answer;
    }
}