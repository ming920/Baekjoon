import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int result = 0;
        
        for (int i = 0; i < N; i++) {
            Set<Character> set = new HashSet<>();
            String word = br.readLine();
            
            set.add(word.charAt(0));
            for (int j = 1; j < word.length(); j++) {
                int prev = word.charAt(j - 1);
                if (prev == word.charAt(j)) continue;
                else {
                    if (set.contains(word.charAt(j))) {
                        result--;
                        break;
                    }
                    else {
                        set.add(word.charAt(j));
                    }
                }
            }
            result++;
        }
        
        System.out.println(result);
    }
}