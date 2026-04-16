import java.io.*;
import java.util.*;

public class Main {
    public static int[][] board = new int[9][9];
    public static int[][][] count = new int[9][9][10];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j) - '0';
                if (board[i][j] != 0) fillNum(i, j, board[i][j]);
            }
        }
        
        backtracking();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static boolean backtracking() {
        if (filled()) return true;
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    for (int num = 1; num < 10; num++) {
                        if (count[i][j][num] == 0) {
                            fillNum(i, j, num);
                            board[i][j] = num;
                            
                            if (backtracking()) return true;
                            
                            emptyNum(i, j, num);
                            board[i][j] = 0;
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return false;
    }
    
    public static boolean filled() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        
        return true;
    }
    
    public static void fillNum(int y, int x, int num) {
        for (int i = 0; i < 9; i++) {
            count[i][x][num]++;
            count[y][i][num]++;
        }
        
        int sy = (y / 3) * 3;
        int sx = (x / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count[sy + i][sx + j][num]++;
            }
        }
        
        count[y][x][num] -= 2;
    }
    
    public static void emptyNum(int y, int x, int num) {
        for (int i = 0; i < 9; i++) {
            count[i][x][num]--;
            count[y][i][num]--;
        }
        
        int sy = (y / 3) * 3;
        int sx = (x / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count[sy + i][sx + j][num]--;
            }
        }
        
        count[y][x][num] += 2; 
    }
}