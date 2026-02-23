import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] power;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        power = new int[N];
        int prevPower = -1;
        String prevTitle = "";
        String[] title = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            
            if (prevPower == p) {
                title[i] = prevTitle;
                power[i] = p;
                continue;
            }
            
            title[i] = t;
            power[i] = p;
            prevPower = p;
            prevTitle = t;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(title[binarySearch(Integer.parseInt(br.readLine()))]).append("\n");
        }
        System.out.print(sb);
    }
    
    public static int binarySearch(int num) {
        int left = 0, right = N - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (power[mid] == num) return mid;
            else if (power[mid] < num) left = mid + 1;
            else right = mid - 1;
        }
        
        return left;
    }
}