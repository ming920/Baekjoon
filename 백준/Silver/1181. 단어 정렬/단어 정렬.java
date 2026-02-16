import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            set.add(str);
        }
        
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, (a, b) -> {
           if (a.length() == b.length()) {
               return a.compareTo(b);
           }
           return Integer.compare(a.length(), b.length());
        });
        
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str).append("\n");
        }
        
        System.out.println(sb);
    }
}