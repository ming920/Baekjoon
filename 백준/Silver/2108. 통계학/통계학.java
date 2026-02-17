import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int[] numCnt = new int[8001];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            numCnt[num + 4000]++;
            list.add(num);
            sum += num;
        }
        
        
        Collections.sort(list);
        long avg = Math.round((double)sum / N);
        int mid = list.get(N / 2);
        
        int cnt = 0;
        List<Integer> freqNum = new ArrayList<>();
        for (int i = 0; i <= 8000; i++) {
            cnt = Math.max(cnt, numCnt[i]);
        }
        
        for (int i = 0; i <= 8000; i++) {
            if (cnt == numCnt[i]) freqNum.add(i - 4000);
        }
        
        Collections.sort(freqNum);
        
        int freq = 0;
        if (freqNum.size() >= 2) freq = freqNum.get(1);
        else freq = freqNum.get(0);
        
        System.out.println(avg);
        System.out.println(mid);
        System.out.println(freq);
        System.out.println(list.get(N - 1) - list.get(0));
    }
}