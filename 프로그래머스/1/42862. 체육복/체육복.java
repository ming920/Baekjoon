class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            clothes[i] = 1;
        }
        
        for (int index : lost) {
            clothes[index]--;
        }
        
        for (int index : reserve) {
            clothes[index]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) continue;
            else if (clothes[i] == 0) {
                if (clothes[i - 1] >= 2) {
                    clothes[i - 1]--;
                    clothes[i]++;
                } else if (i + 1 <= n && clothes[i + 1] >= 2) {
                    clothes[i + 1]--;
                    clothes[i]++;
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) answer++;
        }
        return answer;
    }
}