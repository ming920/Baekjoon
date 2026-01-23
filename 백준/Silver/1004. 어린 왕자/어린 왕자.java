import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; ++t) {
		    st = new StringTokenizer(br.readLine());
		    
		    int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
		    
		    int N = Integer.parseInt(br.readLine());
		    
		    int result = 0;
		    
		    for(int n = 0; n < N; ++n) {
		        st = new StringTokenizer(br.readLine());
		        int cx = Integer.parseInt(st.nextToken());
		        int cy = Integer.parseInt(st.nextToken());
		        int radius = Integer.parseInt(st.nextToken());
		        boolean contain1 = Math.sqrt(Math.pow(cx - x1, 2) + Math.pow(cy - y1, 2)) < radius;
		        boolean contain2 = Math.sqrt(Math.pow(cx - x2, 2) + Math.pow(cy - y2, 2)) < radius;
		        
		        if (contain1 != contain2) result++;
		    }
		    
		    System.out.println(result);
		}
	}
}