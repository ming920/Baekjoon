import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        int[] blank = new int[N];
        int[] line = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            blank[i] = i;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (blank[j] == arr[i]) {
                    line[j] = i + 1;
                    blank[j] = -1;
                    
                    for (int k = j + 1; k < N; k++) {
                        if (blank[k] > 0) blank[k]--;
                    }
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : line) {
            sb.append(num).append(" ");
        }
        
        System.out.println(sb);
    }
}