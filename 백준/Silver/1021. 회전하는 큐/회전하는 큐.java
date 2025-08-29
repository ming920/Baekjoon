//  회전하는 큐

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; ++i) {
            deque.add(i);
        }

        int res = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; ++i) {
            int num = Integer.parseInt(st.nextToken());

            int index = deque.indexOf(num);

            if (deque.size() / 2 >= index) {
                for (int r = 0; r < index; ++r) {
                    deque.addLast(deque.removeFirst());
                }
                deque.removeFirst();
                res += index;
            } else {
                int tmp = deque.size() - index;
                for (int r = 0; r < tmp; ++r) {
                    deque.addFirst(deque.removeLast());
                }
                deque.removeFirst();
                res += tmp;
            }
        }

        System.out.println(res);

    }
}