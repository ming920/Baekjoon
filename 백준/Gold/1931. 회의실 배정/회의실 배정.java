import java.io.*;
import java.util.*;

class Room {
    int start;
    int end;
    
    public Room(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            rooms.add(new Room(start, end));
        }
        
        Collections.sort(rooms, (a, b) -> {
            if (a.end == b.end) return Integer.compare(a.start, b.start);
            return Integer.compare(a.end, b.end);
        });
        
        int prevEnd = rooms.get(0).end;
        int result = 1;
        
        for (int i = 1; i < rooms.size(); ++i) {
            if (rooms.get(i).start >= prevEnd) {
                result++;
                prevEnd = rooms.get(i).end;
            }
        }
        
        System.out.println(result);
    }
}