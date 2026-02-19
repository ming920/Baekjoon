import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crane, Collections.reverseOrder());
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> box = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(box, Collections.reverseOrder());
        
        int cnt = 0;
        while (!box.isEmpty() && box.get(0) <= crane[0]) {
            cnt += 1;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < box.size(); j++) {
                    if (box.get(j) <= crane[i]) {
                        box.remove(j);
                        break;
                    }
                }
            }
        }
        
        if (!box.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }
    }
}