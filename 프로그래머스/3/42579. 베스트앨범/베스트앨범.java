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
        Map<String,Integer> genreTotal=new HashMap<>();
        Map<String,List<Song>> genreSong=new HashMap<>();
        
        for(int i=0;i<plays.length;i++){
            genreTotal.put(genres[i],genreTotal.getOrDefault(genres[i],0)+plays[i]); //장르별 재생횟수
            genreSong.computeIfAbsent(genres[i],k->new ArrayList<>())
                .add(new Song(i,plays[i])); //장르별 노래
        }
        
        //장르 내림차순 정렬
        List<String> maxGenre=new ArrayList<>(genreTotal.keySet());
        maxGenre.sort((a,b)->genreTotal.get(b)-genreTotal.get(a));
        
        //장르별 노래2곡 뽑기
        List<Integer> result=new ArrayList<>();
        for(String genre : maxGenre){
            List<Song> songs=genreSong.get(genre);
            songs.sort((a,b)-> a.play==b.play ? a.index-b.index : b.play-a.play);
            
            result.add(songs.get(0).index);
            if(songs.size()>1) result.add(songs.get(1).index);
        }
        
        return result.stream().mapToInt(i->i).toArray();
        
    }
}