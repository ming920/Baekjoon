//  좋은 구간

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int[] S = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int l = 0; l < L; ++l) {
            S[l] = Integer.parseInt(st.nextToken());
        }

        int num = Integer.parseInt(br.readLine());

        Arrays.sort(S);
        int index = Arrays.binarySearch(S, num);

        if (index >= 0) {
            System.out.println(0);
            return;
        }

        index = -1 * index - 1;
        int min, max;
        if (index == 0) {
            min = 1;
            max = S[index] - 1;
        } else {
            min = S[index - 1] + 1;
            max = S[index] - 1;
        }

        int res = 0;

        for (int i = 0; i <= max - min; ++i) {
            Set<Integer> set = new HashSet<>();

            for (int j = min + i; j <= max; ++j) {
                set.add(j);

                if (set.contains(num) && set.size() > 1) res++;
            }
        }

        System.out.println(res);
    }
}