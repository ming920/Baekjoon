import java.io.*;
import java.util.*;

public class Main {
    public static class Pair {
        int y;
        int x;
        
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public static int N, M, result = Integer.MAX_VALUE;
    public static List<Pair> chickens = new ArrayList<>();
    public static List<Pair> houses = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                
                if (num == 1) {
                    houses.add(new Pair(i, j));
                } else if (num == 2) {
                    chickens.add(new Pair(i, j));
                }
            }
        }
        
        List<Integer> pick = new ArrayList<>();
        pickChicken(pick, 0, 0);
        System.out.println(result);
    }
    
    public static void pickChicken(List<Integer> pick, int start, int depth) {
        if (depth == M) {
            calcDist(pick);
            return;
        }
        
        for (int i = start; i < chickens.size(); i++) {
            pick.add(i);
            pickChicken(pick, i + 1, depth + 1);
            pick.remove(pick.size() - 1);
        }
    }
    
    public static void calcDist(List<Integer> pick) {
        int res = 0;
        
        for (Pair house : houses) {
            int houseY = house.y;
            int houseX = house.x;
            
            int minDist = Integer.MAX_VALUE;
            for (int index : pick) {
                int chickenY = chickens.get(index).y;
                int chickenX = chickens.get(index).x;
                int dist = Math.abs(houseY - chickenY) + Math.abs(houseX - chickenX);
                
                minDist = Math.min(minDist, dist);
            }
            res += minDist;
        }
        
        result = Math.min(result, res);
    }
}