import java.util.*;

class Solution {
    public class Song implements Comparable<Song> {
        int index;
        int play;
        
        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song other) {
            if (this.play == other.play) {
                return Integer.compare(this.index, other.index);
            }
            
            return Integer.compare(other.play, this.play);
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCnt = new HashMap<>();
        Map<String, Queue<Song>> genreQ = new HashMap<>();
        
        for (int i = 0; i < plays.length; i++) {
            genreCnt.put(genres[i], genreCnt.getOrDefault(genres[i], 0) + plays[i]);
            
            genreQ.putIfAbsent(genres[i], new PriorityQueue<>());
            genreQ.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        List<String> genreList = new ArrayList<>(genreCnt.keySet());
        genreList.sort((a, b) -> {
            return Integer.compare(genreCnt.get(b), genreCnt.get(a));
        });
        
        List<Integer> answers = new ArrayList<>();
        for (String genre : genreList) {
            Queue<Song> q = genreQ.get(genre);
            
            for (int i = 0; i < 2 && !q.isEmpty(); i++) {
                answers.add(q.poll().index);
            }
        }
        
        int[] answer = new int[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }
        return answer;
    }
}