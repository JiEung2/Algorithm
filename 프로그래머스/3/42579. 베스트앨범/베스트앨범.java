import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);
            genreSongs.computeIfAbsent(genre, k -> new ArrayList<>()).add(new int[]{i, play});
        }
        
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a)); 
        
        List<Integer> result = new ArrayList<>();
        for(String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);

            songs.sort((a, b) -> {
                if(b[1] != a[1]) return b[1] - a[1];
                return a[0] - b[0];
            });

            for(int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[0]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}