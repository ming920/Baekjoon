import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st;

			int size = 0;
			TreeMap<Integer, Integer> map = new TreeMap<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());

				switch (command) {
				    case 'I':
					    map.put(num, map.getOrDefault(num, 0) + 1);
					    break;
					    
				    case 'D':
				        if (map.size() == 0) continue;
				        
				        int deleteNum;
                        if (num == 1) {
                            deleteNum = map.lastKey();
                        } else {
                            deleteNum = map.firstKey();
                        }
                        
                        map.put(deleteNum, map.get(deleteNum) - 1);
                        if (map.get(deleteNum) == 0) {
                            map.remove(deleteNum);
                        }
				}
			}
			
			if (map.size() == 0) {
			    sb.append("EMPTY\n");
			} else {
			    sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}

		System.out.println(sb);
	}
}