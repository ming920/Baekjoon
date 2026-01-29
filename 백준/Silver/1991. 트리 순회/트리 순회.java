import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        char ch;
        Node left;
        Node right;
        
        public Node(char ch) {
            this.ch = ch;
            left = null;
            right = null;
        }
    }
    
    public static Node root = new Node('A');
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Node parent = find(root, st.nextToken().charAt(0));
            Node left = null, right = null;
            
            char leftCh = st.nextToken().charAt(0);
            if (leftCh != '.') left = new Node(leftCh);
            
            char rightCh = st.nextToken().charAt(0);
            if (rightCh != '.') right = new Node(rightCh);
            
            parent.left = left;
            parent.right = right;
        }
        prefix(root);
        sb.append("\n");
        infix(root);
        sb.append("\n");
        postfix(root);
        
        System.out.println(sb);
    }
    
    public static Node find(Node node, char ch) {
        if (node == null) return null;
        
        if (node.ch == ch) return node;
        
        Node leftNode = find(node.left, ch);
        if (leftNode != null) return leftNode;
        
        return find(node.right, ch);
    }
    
    public static void prefix(Node node) {
        sb.append(node.ch);
        if (node.left != null) prefix(node.left);
        if (node.right != null) prefix(node.right);
    }
    
    public static void infix(Node node) {
        if (node.left != null) infix(node.left);
        sb.append(node.ch);
        if (node.right != null) infix(node.right);
    }
    
    public static void postfix(Node node) {
        if (node.left != null) postfix(node.left);
        if (node.right != null) postfix(node.right);
        sb.append(node.ch);
    }
}