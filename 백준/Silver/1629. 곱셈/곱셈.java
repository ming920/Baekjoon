import java.io.*;
import java.util.*;

public class Main {
    
    public static long A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        
        System.out.println(power(A, B));
    }
    
    public static long power(long base, long expon) {
        if (expon == 1) return base % C;
        
        if (expon % 2 == 0) {
            long num = power(base, expon / 2) % C;
            return (num * num) % C;
        } else {
            long num = power(base, expon / 2) % C;
            return ((num * num) % C) * A % C;
        }
    }
}