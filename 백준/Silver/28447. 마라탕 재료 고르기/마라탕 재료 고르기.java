import java.io.*;
import java.util.*;

public class Main {
    public static long result = Integer.MIN_VALUE;
    public static int N, M;
    public static int[][] ingredient;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        ingredient = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ingredient[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        List<Integer> numbers = new ArrayList<>();
        pick(0, 0, numbers);
        System.out.println(result);
    }
    
    public static void pick(int start, int cnt, List<Integer> numbers) {
        if (cnt == M) {
            sum(numbers);
            return;
        }
        
        for (int i = start; i < N; i++) {
            numbers.add(i);
            pick(i + 1, cnt + 1, numbers);
            numbers.remove(numbers.size() - 1);
        }
    }
    
    public static void sum(List<Integer> numbers) {
        int size = numbers.size();
        long s = 0;
        
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int a = numbers.get(i);
                int b = numbers.get(j);
                s += ingredient[a][b];
            }
        }
        
        result = Math.max(result, s);
    }
}