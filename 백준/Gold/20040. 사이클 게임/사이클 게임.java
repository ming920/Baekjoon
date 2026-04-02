import java.io.*;
import java.util.*;

public class Main {
    public static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if (!union(x, y)) {
                System.out.println(i);
                return;
            }
        }
        
        System.out.println(0);
        return;
    }
    
    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return false;
        
        if (x < y) parent[y] = x;
        else parent[x] = y;
        return true;
    }
    
    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}