import java.util.*;

class Solution {
    static class Song{
        int index;
        int play;
        
        Song(int index, int play){
            this.index=index;
            this.play=play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> genre=new HashMap<>();
        Map<String,List<Song>> song=new HashMap<>();
        
        int n=genres.length;
        for(int i=0;i<n;i++){
            genre.put(genres[i], genre.getOrDefault(genres[i],0)+plays[i]); //장르별 재생횟수 카운트
            song.computeIfAbsent(genres[i], k-> new ArrayList<>()).add(new Song(i,plays[i])); //고유번호, 재생횟수
        }
        
        List<String> maxGenre=new ArrayList<>(genre.keySet());
        maxGenre.sort((a,b)-> genre.get(b)-genre.get(a));
        
        //장르별 2곡
        List<Integer> result= new ArrayList<>();
        for(String g : maxGenre){
            List<Song> songs=song.get(g);
            songs.sort((a,b)-> a.play==b.play ? a.index-b.index : b.play-a.play);
            result.add(songs.get(0).index);
            if(songs.size()>1) result.add(songs.get(1).index);
        }
        
        return result.stream().mapToInt(i->i).toArray();
        
    }
}