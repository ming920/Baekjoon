class Solution {
    
    int N;
    boolean[] visited;
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        visited = new boolean[N];
        
        dfs(k, 0, dungeons);
        
        return answer;
    }
    
    public void dfs(int k, int cnt, int[][] dungeons) {
        answer = Math.max(answer, cnt);
        
        for (int i = 0; i < N; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], cnt + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}