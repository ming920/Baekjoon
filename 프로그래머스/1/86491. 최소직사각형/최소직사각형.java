class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int N = sizes.length;
        
        int maxW = 0, maxH = 0;
        for (int i = 0; i < N; i++) {
            int w1 = Math.max(maxW, sizes[i][0]);
            int h1 = Math.max(maxH, sizes[i][1]);
            
            int w2 = Math.max(maxW, sizes[i][1]);
            int h2 = Math.max(maxH, sizes[i][0]);
            
            if (w1 * h1 < w2 * h2) {
                answer = w1 * h1;
                maxW = w1;
                maxH = h1;
            } else {
                answer = w2 * h2;
                maxW = w2;
                maxH = h2;
            }
        }
        
        return answer;
    }
}