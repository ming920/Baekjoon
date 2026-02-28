class Solution {
    public static int N, M;
    
    public int[] solution(String[] park, String[] routes) {
        N = park.length;
        M = park[0].length();
        
        char[][] board = new char[N][M];
        int sy = 0, sx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = park[i].charAt(j);
                
                if (board[i][j] == 'S') {
                    sy = i;
                    sx = j;
                }
            }
        }
        
        for (String route : routes) {
            char op = route.charAt(0);
            int n = route.charAt(2) - '0';
            boolean possible = true;
            
            switch (op) {
                case 'N':
                    if (!inRange(sy - n, sx)) continue;
                    for (int i = 0; i <= n; i++) {
                        if (board[sy - i][sx] == 'X') {
                            possible = false;
                            break;
                        }
                    }
                    if (possible) {
                        sy -= n;
                    }
                    break;
                    
                case 'S':
                    if (!inRange(sy + n, sx)) continue;
                    for (int i = 0; i <= n; i++) {
                        if (board[sy + i][sx] == 'X') {
                            possible = false;
                            break;
                        }
                    }
                    if (possible) {
                        sy += n;
                    }
                    break;
                    
                case 'W':
                    if (!inRange(sy, sx - n)) continue;
                    for (int i = 0; i <= n; i++) {
                        if (board[sy][sx - i] == 'X') {
                            possible = false;
                            break;
                        }
                    }
                    if (possible) {
                        sx -= n;
                    }
                    break;
                    
                case 'E':
                    if (!inRange(sy, sx + n)) continue;
                    for (int i = 0; i <= n; i++) {
                        if (board[sy][sx + i] == 'X') {
                            possible = false;
                            break;
                        }
                    }
                    if (possible) {
                        sx += n;
                    }
                    break;
            }
        }
        
        int[] answer = {sy, sx};
        return answer;
    }
    
    public static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}