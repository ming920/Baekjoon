import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        
        int index = 0;
        int length = S.length();
        Deque<Character> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        while (index < length) {
            if (S.charAt(index) == '<') {
                
                while (!dq.isEmpty()) {
                    sb.append(dq.pop());
                }
                
                sb.append('<');
                index++;
                
                while (S.charAt(index) != '>') {
                    sb.append(S.charAt(index++));
                }
                
                sb.append('>');
                index++;
            } else if (S.charAt(index) == ' ') {
                while (!dq.isEmpty()) {
                    sb.append(dq.pop());
                }
                sb.append(' ');
                index++;
            } else {
                dq.push(S.charAt(index));
                index++;
            }
        }
        
        while (!dq.isEmpty()) {
            sb.append(dq.pop());
        }
        
        System.out.println(sb);
    }
} 