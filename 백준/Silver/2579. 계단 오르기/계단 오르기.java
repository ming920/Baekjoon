import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] score = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        
        if (N == 1) {
            System.out.println(score[1]);
            return;
        } else if (N == 2) {
            System.out.println(score[1] + score[2]);
            return;
        }
        
        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        
        for (int i = 3; i <= N; i++) {
            dp[i] = score[i] + Math.max(dp[i - 2], dp[i - 3] + score[i - 1]);
        }
        
        System.out.println(dp[N]);
    }
}