import java.io.*;
import java.util.*;

public class Main {
    public static class Score {
    int document;
    int interview;
    
    public Score(int document, int interview) {
        this.document = document;
        this.interview = interview;
    }
}
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Score[] scores = new Score[N];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                scores[i] = new Score(document, interview);
            }
            
            Arrays.sort(scores, (a, b) -> {
                return Integer.compare(a.document, b.document);
            });
            
            int result = 1;
            int minRank = scores[0].interview;
            
            for (int i = 1; i < N; i++) {
                if (scores[i].interview < minRank) {
                    minRank = scores[i].interview;
                    result++;
                }
            }
            
            sb.append(result).append("\n");
        } 
        
        System.out.println(sb);
    }
}