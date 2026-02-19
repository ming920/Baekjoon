import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = line.length();
        
        int[] alphabet = new int[26];
        char[] result = new char[N];
        for (int i = 0; i < N; i++) {
            alphabet[line.charAt(i) - 'A']++;
        }
        
        int oddCount = 0;
        int oddIndex = -1;
        
        
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] % 2 == 1) {
                oddCount++;
                oddIndex = i;
            }
        }
        
        if (N % 2 == 0 && oddCount > 0) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        
        if (N % 2 == 1 && oddCount != 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        
        if (N % 2 == 1) {
            result[N / 2] = (char)('A' + oddIndex);
            alphabet[oddIndex]--;
        }
        
        int index = 0;
        for (int i = 0; i < 26; i++) {
            while (alphabet[i] >= 2) {
                result[index] = (char)('A' + i);
                result[N - index - 1] = (char)('A' + i);
                index++;
                alphabet[i] -= 2;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : result) {
            sb.append(ch);
        }
        
        System.out.println(sb);
    }
}