import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String,Integer> playtime=new HashMap<>();
        Map<String,List<Song>> genreSongs=new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            String genre=genres[i];
            int play=plays[i];
            
            playtime.put(genre,playtime.getOrDefault(genre,0)+play);
            
            genreSongs.putIfAbsent(genre,new ArrayList<>());
            genreSongs.get(genre).add(new Song(i,play));
        }
        
        List<String> sortedGenres=new ArrayList<>(playtime.keySet());
        sortedGenres.sort((a,b)-> playtime.get(b)-playtime.get(a));
        
        List<Integer> result=new ArrayList<>();
        
        for(String genre: sortedGenres){
            List<Song> songs=genreSongs.get(genre);
            songs.sort((a,b)->b.play==a.play ? a.id-b.id: b.play-a.play);
            
            int cnt=0;
            for(Song song:songs){
                if(cnt++>=2) break;
                result.add(song.id);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
    
    static class Song{
        int id;
        int play;
        
        Song(int id, int play){
            this.id=id;
            this.play=play;
        }
    }
}