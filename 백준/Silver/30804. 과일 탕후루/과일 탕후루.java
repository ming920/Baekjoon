import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        int[] count = new int[10];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int kind = 0;
        int answer = 0;
        
        for (int right = 0; right < N; right++) {
            if (count[arr[right]] == 0) kind++;
            count[arr[right]]++;
            
            while (kind > 2) {
                count[arr[left]]--;
                if (count[arr[left]] == 0) {
                    kind--;
                }
                left++;
            }
            
            answer = Math.max(answer, right - left + 1);
        }
        
        System.out.println(answer);
    }
}