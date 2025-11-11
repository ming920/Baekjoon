import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int[] team = new int[N + 2];

        for (int i = 1; i <= N; ++i) {
            team[i] = 1;
        }        
        
        int teamMember = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; ++i) {
            teamMember = Integer.parseInt(st.nextToken());
            team[teamMember]--;
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; ++i) {
            teamMember = Integer.parseInt(st.nextToken());
            team[teamMember]++;
        }
        
        for (int i = 1; i <= N; ++i) {
            if (team[i] == 0) {
                if (team[i - 1] >= 2) {
                    team[i]++;
                    team[i - 1]--;
                    continue;
                }
                
                if (team[i + 1] >= 2) {
                    team[i]++;
                    team[i + 1]--;
                    continue;
                }
            }
        }
        
        int result = 0;
        for (int i = 1; i <= N; ++i) {
            if (team[i] == 0) {
                result++;
            }
        }
        
        System.out.println(result);
    }
}