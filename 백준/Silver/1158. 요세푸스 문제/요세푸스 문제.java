import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        
        int index = 0, size = 0;
        for (int i = 0; i < N; i++) {
            size = N - i;
            index = (index + K - 1) % size;
            arr[i] = list.get(index);
            list.remove(index);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < N - 1; i++) {
            sb.append(arr[i] + ", ");
        }
        sb.append(arr[N - 1] + ">");
        System.out.println(sb);
    }
}