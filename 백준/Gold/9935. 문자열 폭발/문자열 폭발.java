import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        
        int strLen = str.length();
        int bombLen = bomb.length();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < strLen; i++) {
            char ch = str.charAt(i);
            stack.push(ch);
            
            boolean deleted = false;
            if (bomb.charAt(bombLen - 1) == ch && stack.size() >= bombLen) {
                deleted = true;
                for (int j = 0; j < bombLen; j++) {
                    int deleteLen = stack.size() - bombLen + j;
                    if (stack.elementAt(deleteLen) != bomb.charAt(j)) {
                        deleted = false;
                        break;
                    }
                }
            }
            
            if (deleted && stack.size() >= bombLen) {
                for (int j = 0; j < bombLen; j++) {
                    stack.pop();
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        
        if (sb.toString().isEmpty()) {
            sb.append("FRULA");
        }
        
        System.out.println(sb);
    }
}