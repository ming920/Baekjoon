class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        int[] cnt = new int[2_000_000];
        
        for (int[] signal : signals) {
            int index = signal[0] + 1;
            int green = signal[0];
            int yellow = signal[1];
            int red = signal[2];
            
            while (index < cnt.length) {
                int temp = 0;
                while (temp < yellow && index < cnt.length) {
                    cnt[index++] += 1;
                    temp++;
                }
                
                index += (green + red);
            }
        }
        
        for (int i = 1; i < 2_000_000; i++) {
            if (cnt[i] == n) {
                return i;
            }
        }
        return -1;
    }
}