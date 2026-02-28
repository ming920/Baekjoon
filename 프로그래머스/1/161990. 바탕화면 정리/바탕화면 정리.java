import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int minY = Integer.MAX_VALUE, minX = Integer.MAX_VALUE, maxY = 0, maxX = 0;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minY = Math.min(minY, i);
                    minX = Math.min(minX, j);
                    maxY = Math.max(maxY, i);
                    maxX = Math.max(maxX, j);
                }
            }
        }
        int[] answer = {minY, minX, maxY + 1, maxX + 1};
        return answer;
    }
}