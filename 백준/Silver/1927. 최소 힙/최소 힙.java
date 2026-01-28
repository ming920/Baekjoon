import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            int x = Integer.parseInt(br.readLine());
            
            if (x == 0) {
                if (list.size() == 0) sb.append('0').append('\n');
                else {
                    sb.append(list.get(0)).append('\n');
                    list.remove(0);
                }
            } else {
                int index = binarySearch(list, x);
                list.add(index, x);
            }
        }
        
        System.out.println(sb);
    }
    
    public static int binarySearch(List<Integer> a, int target) {
        int lo = 0, hi = a.size();
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a.get(mid) < target) lo = mid + 1;
            else hi = mid;
        }
        
        return lo;
    }
}