import java.util.*;

class Solution {
    public static int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> {
           return Integer.compare(a[2], b[2]); 
        });
        
        int answer = 0;
        for (int[] cost : costs) {
            if (union(cost[0], cost[1])) {
                answer += cost[2];
            }
        }
        
        return answer;
    }
    
    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }
}