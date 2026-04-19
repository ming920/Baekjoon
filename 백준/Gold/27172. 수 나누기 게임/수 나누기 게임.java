import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] player = new int[N];
        Set<Integer> set = new HashSet<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            player[i] = Integer.parseInt(st.nextToken());
            set.add(player[i]);
        }
        
        int[] score = new int[1_000_001];
        for (int i = 0; i < N; i++) {
            int p1 = player[i];
            
            for (int j = p1 * 2; j <= 1_000_000; j += p1) {
                score[j]--;
                if (set.contains(j)) {
                    score[p1]++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(score[player[i]]).append(" ");
        }
        
        System.out.println(sb);
    }
}