import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] len = new int[3];
            for (int i = 0; i < 3; i++) {
                len[i] = Integer.parseInt(st.nextToken());
            }
            
            if (len[0] == 0 && len[1] == 0 && len[2] == 0) break;
            
            Arrays.sort(len);
            if (Math.pow(len[2], 2) == Math.pow(len[0], 2) + Math.pow(len[1], 2)) sb.append("right\n");
            else sb.append("wrong\n");
        }
        
        System.out.println(sb);
    }
}