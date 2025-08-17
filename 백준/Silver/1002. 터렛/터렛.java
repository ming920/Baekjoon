//  터렛

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println("-1");
                continue;
            }

            double distance = Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2));

            if (distance > r1 + r2 || distance < Math.abs(r1 - r2)) {
                System.out.println("0");
                continue;
            } else if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) {
                System.out.println("1");
                continue;
            } else {
                System.out.println("2");
                continue;
            }

        }

    }
}