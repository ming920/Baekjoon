import java.io.*;
import java.util.*;

public class Main {
    public static int N, result = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        N = S.length();
        
        int[] alphabet = new int[26];
        for (int i = 0; i < S.length(); i++) {
            alphabet[S.charAt(i) - 'a']++;
        }
        
        backtracking(alphabet, -1, 0);
        System.out.println(result);
    }
    
    public static void backtracking(int[] alphabet, int prev, int length) {
        if (length == N) {
            result++;
            return;
        }
        
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > 0 && prev != i) {
                alphabet[i]--;
                backtracking(alphabet, i, length + 1);
                alphabet[i]++;
            }
        }
    }
}