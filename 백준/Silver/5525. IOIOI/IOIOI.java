import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int size = 2 * N + 1;
		Deque<Character> queue = new ArrayDeque<>();
		int cnt = 0;
		
		for (int i = 0; i < M; i++) {
		    char ch = str.charAt(i);
		    if (queue.isEmpty() && ch == 'I') {
		        queue.addLast('I');
		    } else if (!queue.isEmpty() && queue.peekLast() != ch) {
		        queue.addLast(ch);
		    } else if (!queue.isEmpty() && queue.peekLast() == ch) {
		        queue.clear();
		        if (ch == 'I') queue.addLast('I');
		    }
		    
		    while (queue.size() > size) {
		        queue.pollFirst();
		    }
		    
		    if (queue.size() == size && queue.peekLast() == 'I') {
		        cnt++;
		    }
		}
		
		System.out.println(cnt);
	}
}