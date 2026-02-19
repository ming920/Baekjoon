import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] price = new int[M];
        for (int i = 0; i < M; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(price);
        int resultSum = 0;
        int resultPrice = 0;
        for (int i = 0; i < M; i++) {
            if (resultSum < price[i] * Math.min(N, M - i)) {
                resultSum = price[i] * Math.min(N, M - i);
                resultPrice = price[i];
            }
        }
        
        System.out.println(resultPrice + " " + resultSum);
    }
}