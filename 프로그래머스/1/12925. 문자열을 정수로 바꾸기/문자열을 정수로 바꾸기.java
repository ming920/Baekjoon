class Solution {
    public int solution(String s) {
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            if (s.charAt(0) == '+') {
                return Integer.parseInt(s);
            } else {
                return Integer.parseInt(s.substring(1)) * -1;
            }
        } else {
            return Integer.parseInt(s);
        }
    }
}