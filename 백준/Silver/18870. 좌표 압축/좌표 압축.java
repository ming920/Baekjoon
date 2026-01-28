import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer> list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        SortedSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        
        list = new ArrayList<>(set);
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(binarySearch(num)).append(" ");
        }
        
        System.out.println(sb);
    }
    
    public static int binarySearch(int num) {
        int left = 0, right = list.size() - 1, mid = 0;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            int value = list.get(mid);
            
            if (value < num) left = mid + 1;
            else if (value > num) right = mid - 1;
            else return mid;
        }
        
        return mid;
    }
}