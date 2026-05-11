class Solution {
    public int solution(int n) {
        int next = n;
        do {
            next++;
        } while (Integer.bitCount(n) != Integer.bitCount(next));
        return next;
    }
}