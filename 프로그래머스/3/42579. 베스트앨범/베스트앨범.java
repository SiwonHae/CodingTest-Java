import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> cntMap = new HashMap<>(); // 장르와 재생횟수
        Map<String, List<Song>> songMap = new HashMap<>(); // 장르와 (고유번호, 재생횟수)
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            cntMap.put(genre, cntMap.getOrDefault(genre, 0) + play);
            
            songMap.computeIfAbsent(genre, key -> new ArrayList<>())
                .add(new Song(i, play));
        }
        
        // 재일 많이 재생된 장르 순으로 정렬
        List<String> sortedGenres = cntMap.entrySet().stream()
            .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        // 장르 내에서 재생횟수 높은 순으로 정렬해서 2개까지 뽑기
        List<Integer> result = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            List<Song> songs = songMap.get(genre);
            
            Collections.sort(songs, (o1, o2) -> {
                if (o1.cnt == o2.cnt) {
                    return o1.id - o2.id;
                }
                
                return o2.cnt - o1.cnt;
            });
            
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i).id);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Song {
        int id; // 고유번호
        int cnt; // 재생횟수
        
        public Song(int id, int cnt) {
            this.id = id;
            this.cnt = cnt;
        }
    }
}