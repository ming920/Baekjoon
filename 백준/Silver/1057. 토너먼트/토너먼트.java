//  토너먼트

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int count = 0;

        while (x != y) {
            count++;

            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = (x + 1) / 2;
            }

            if (y % 2 == 0) {
                y /= 2;
            } else {
                y = (y + 1) / 2;
            }
        }

        System.out.println(count);
    }
}