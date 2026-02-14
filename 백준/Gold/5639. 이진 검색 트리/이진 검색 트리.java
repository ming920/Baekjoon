import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int num;
        Node left, right;
        
        public Node(int num) {
            this.num = num;
            this.left = null;
            this.right = null;
        }
    }
    
    public static Node root = null;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        root = new Node(Integer.parseInt(br.readLine()));
        
        String line;
        while ((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);
            insert(root, num);
        }
        
        print(root);
        System.out.print(sb);
    }
    
    public static void insert(Node node, int num) {
        if (node.num > num) {
            if (node.left != null) {
                insert(node.left, num);
            } else {
                node.left = new Node(num);
            }
        } else {
            if (node.right != null) {
                insert(node.right, num);
            } else {
                node.right = new Node(num);
            }
        }
    }
    
    public static void print(Node node) {
        if (node.left != null) print(node.left);
        if (node.right != null) print(node.right);
        sb.append(node.num).append("\n");
    }
}