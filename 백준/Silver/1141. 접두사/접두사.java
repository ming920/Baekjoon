import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] word = new String[N];
        
        for (int i = 0; i < N; i++) {
            word[i] = br.readLine();
        }
        
        Arrays.sort(word, (a, b) -> {
           return Integer.compare(b.length(), a.length()); 
        });
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            boolean contains = false;
            
            for (String str : set) {
                if (str.startsWith(word[i])) {
                    contains = true;
                    break;
                }
            }
            
            if (!contains) {
                set.add(word[i]);
            }
        }
        
        System.out.println(set.size());
    }
}