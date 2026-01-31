import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int result = 0;
        int[] arr = new int[N];
        List<Integer> list = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            list.add(arr[i]);
            
            if (i >= k - 1) {
                Set<Integer> set = new HashSet<>(list);
                set.add(c);
                result = Math.max(result, set.size());
                list.remove(0);
            }
        }
        
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
            Set<Integer> set = new HashSet<>(list);
            set.add(c);
            result = Math.max(result, set.size());
            list.remove(0);
        }
        
        System.out.println(result);
    }
}