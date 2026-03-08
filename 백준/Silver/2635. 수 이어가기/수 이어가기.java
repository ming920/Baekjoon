import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int answer = 0;
        List<Integer> answerArr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            List<Integer> arr = new ArrayList<>();
            arr.add(N);
            arr.add(i);
            
            int size = arr.size();
            while (arr.get(size - 2) - arr.get(size - 1) >= 0) {
                arr.add(arr.get(size - 2) - arr.get(size - 1));
                size++;
            }
            
            if (answer < size) {
                answerArr = arr;
                answer = size;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        for (int num : answerArr) {
            sb.append(num).append(" ");
        }
        
        System.out.println(sb);
    }
}