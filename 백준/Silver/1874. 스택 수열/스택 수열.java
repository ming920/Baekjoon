import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            stack.addFirst(i);
            sb.append("+\n");
            
            while (!stack.isEmpty() && stack.peekFirst() == arr[index]) {
                stack.pollFirst();
                sb.append("-\n");
                index++;
            }
        }
        
        while (!stack.isEmpty() && index < N && stack.peekFirst() == arr[index]) {
            stack.pollFirst();
            sb.append("-\n");
            index++;
        }
        
        if (stack.isEmpty()) System.out.println(sb);
        else System.out.println("NO");
    }
}